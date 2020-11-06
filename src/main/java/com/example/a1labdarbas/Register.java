package com.example.a1labdarbas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText username=findViewById(R.id.username);
        final EditText password=findViewById(R.id.password);
        final EditText email=findViewById(R.id.email);

        Button back =findViewById(R.id.backtologin);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToRegisterActivity = new Intent(Register.this, MainActivity.class);
                startActivity(goToRegisterActivity);
            }
        });
        Button submit =findViewById(R.id.reg);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((Validation.isValidEmail(email.getText().toString())) && (Validation.isValidPassword(password.getText().toString())) && (Validation.isValidUsername(username.getText().toString()))){
                    Toast.makeText(Register.this,"prisijungimo vardas:"+
                            username.getText().toString() + "\n" + "slaptazodis:" +
                            password.getText().toString() + "\n" + "e. pastas:" + email.getText().toString(), Toast.LENGTH_LONG).show();
                    Intent goToMain=new Intent(Register.this,MainActivity.class);
                    startActivity(goToMain);
                }
                else{
                    username.setError(getResources().getString(R.string.login_invalid_registration));
                    username.requestFocus();
                }

            }
        });
    }
}