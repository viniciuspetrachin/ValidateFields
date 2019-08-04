package com.github.viniciuspetrachin.validatefields;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.ui_editText_email);
        editTextPassword = findViewById(R.id.ui_editText_password);

    }
    public void button_check_email(View view){
        ValidateFields validateFields = new ValidateFields(getApplicationContext());

        if(validateFields.isEmailValid(editTextEmail)){
            Toast.makeText(this, "Valid", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
        }

    }
    public void button_check_password(View view){
        ValidateFields validateFields = new ValidateFields(getApplicationContext());

        if(validateFields.isPasswordValid(editTextPassword)){
            Toast.makeText(this, "Valid", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
        }

    }
    public void button_check_both(View view){
        ValidateFields validateFields = new ValidateFields(getApplicationContext());
        if(validateFields.isEmailPasswordValid(editTextEmail, editTextPassword)){
            Toast.makeText(this, "Valid", Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
        }
    }
}
