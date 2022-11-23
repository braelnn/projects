package com.example.Try;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FrontActivity extends AppCompatActivity {
    TextView regpage, admin;
    Button login;
    String emailPattern= "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front);

        regpage= findViewById(R.id.NoAccount);

        regpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(FrontActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        admin= findViewById(R.id.admin);

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(FrontActivity.this,LoginadminActivity.class);
                startActivity(intent);
            }
        });

        final EditText inputEmail= findViewById(R.id.inputEmail);
        final EditText inputPassword= findViewById(R.id.inputPassword);
        final EditText inputPhone =findViewById(R.id.inputPhone);
        final Button btnlogin= findViewById(R.id.btnlogin);
        progressDialog= new ProgressDialog(this);
        mAuth= FirebaseAuth.getInstance();
        mUser= mAuth.getCurrentUser();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // to cahnge input to string so it can be entered into the database
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();
                String phone = inputPhone.getText().toString();

                //validating the email and password
                if (!email.matches(emailPattern)) {
                    inputEmail.setError("enter correct email");
                } else if (password.isEmpty() || password.length() < 4) {
                    inputPassword.setError("Incorrect format");

                }else if (phone.length()<10)
                {
                    inputPhone.setError("incorrect number");

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
                                Toast.makeText(FrontActivity.this,"LOGIN SUCCESSFULLY",Toast.LENGTH_SHORT).show();

                                //send to the Main Activity
                                Intent inte= new Intent(FrontActivity.this,HomeActivity.class);
                                inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(inte);

                            }else
                            {
                                progressDialog.dismiss();
                                Toast.makeText(FrontActivity.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });




    }
}




