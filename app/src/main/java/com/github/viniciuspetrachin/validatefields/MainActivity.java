/*
 * MIT License
 *
 * Copyright (c) 2019 Vinícius Rodrigues Petrachin
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.github.viniciuspetrachin.validatefields;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
