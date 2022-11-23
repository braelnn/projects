package com.example.Try;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.ims.RegistrationManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterActivity extends AppCompatActivity {

    TextView haveaccount;
    String emailPattern= "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        haveaccount= findViewById(R.id.haveaccount);
        haveaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        //for the inputs
        final EditText inputEmail= findViewById(R.id.inputEmail);
        final EditText inputPhone= findViewById(R.id.inputPhone);
        final EditText inputPassword= findViewById(R.id.inputPassword);
        final EditText inputConfirmPassword= findViewById(R.id.inputConfirmPassword);
        final Button btnreg= findViewById(R.id.btnregister);
        progressDialog= new ProgressDialog(this);
        mAuth= FirebaseAuth.getInstance();
        mUser= mAuth.getCurrentUser();


        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = inputEmail.getText().toString();
                String phone = inputPhone.getText().toString();
                String password = inputPassword.getText().toString();
                String confirm = inputConfirmPassword.getText().toString();

                if (!email.matches(emailPattern))
                {
                    inputEmail.setError("enter correct email");
                }
                else if (password.isEmpty() || password.length() < 4)
                {
                    inputPassword.setError("Incorrect format");
                }
                else if(phone.length()<10 || phone.length()>13)
                {
                    inputPhone.setError("incorrect phone number");
                }
                else if (!password.equals(confirm))
                {
                   inputConfirmPassword.setError("password does not match");
                }
                else
                {
                    //if everything is validated
                    progressDialog.setMessage("Please Wait");
                    progressDialog.setTitle("Registration");
                    progressDialog.setCanceledOnTouchOutside(false);
                    progressDialog.show();



                    mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                progressDialog.dismiss();
                                Toast.makeText(RegisterActivity.this,"REGISTRATION COMPLETE",Toast.LENGTH_SHORT).show();

                                //send to the Main Activity
                                Intent inte= new Intent(RegisterActivity.this,MainActivity.class);
                                inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(inte);

                            }else
                            {
                                progressDialog.dismiss();
                                Toast.makeText(RegisterActivity.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });





                }



            }
        });







    }
}