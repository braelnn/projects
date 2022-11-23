package com.example.Try;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginadminActivity extends AppCompatActivity {
    Button login;
    String emailPattern= "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginadmin);


        final EditText inputEmail= findViewById(R.id.inputEmail);
        final EditText inputPassword= findViewById(R.id.inputPassword);
        //final EditText inputConfirmPassword= findViewById(R.id.inputConfirmPassword);
        final Button btnlogin= findViewById(R.id.btnlogin);
        progressDialog= new ProgressDialog(this);
        mAuth= FirebaseAuth.getInstance();
        mUser= mAuth.getCurrentUser();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();
//                String Confirm=inputConfirmPassword.getText().toString();


                if (!email.matches(emailPattern)|| !email.equals("admin@gmail.com")) {
                    inputEmail.setError("enter correct email");
                } else if (password.isEmpty() || password.length() < 4 || !password.equals("admin123")) {
                    inputPassword.setError("Incorrect format");

//               }else if (!password.equals(Confirm))
//                {
//                    inputConfirmPassword.setError("password does not match");
//                }
                }else {
                    //if everything is validated
                    progressDialog.setMessage("Please Wait");
                    progressDialog.setTitle("Logging");
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.show();

                    mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                progressDialog.dismiss();
                                Toast.makeText(LoginadminActivity.this,"SUCCESSFUL LOGIN",Toast.LENGTH_SHORT).show();

                                //send to the Main Activity
                                Intent inte= new Intent(LoginadminActivity.this,AdminhomeActivity.class);
                                inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(inte);

                            }else
                            {
                                progressDialog.dismiss();
                                Toast.makeText(LoginadminActivity.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}