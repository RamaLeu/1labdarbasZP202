package com.example.a1labdarbas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText username=findViewById(R.id.username);
        final EditText password=findViewById(R.id.password);

        Button register =findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            Intent goToRegisterActivity = new Intent(MainActivity.this, Register.class);
                                            startActivity(goToRegisterActivity);
                                        }
                                    });

        Button submit =findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // cia rasomas kodas kuris vykdomas paspaudus mygtuka
               Toast.makeText(MainActivity.this,"prisijungimo vardas:"+
                        username.getText().toString() + "\n" + "slaptazodis:" +
                        password.getText().toString(), Toast.LENGTH_LONG).show();
                if ((Validation.isValidPassword(password.getText().toString())) && (Validation.isValidUsername(username.getText().toString()))){
                    Intent goToSeachActivity=new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(goToSeachActivity);
                }
                else{
                    username.setError(getResources().getString(R.string.login_invalid_username));
                    username.requestFocus();
                }

            }
        });

    }

}