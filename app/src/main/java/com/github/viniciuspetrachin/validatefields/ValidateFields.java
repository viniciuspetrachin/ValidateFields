package com.github.viniciuspetrachin.validatefields;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateFields {

    private Context context;

    public ValidateFields(Context context) {
        this.context = context;
    }

    public boolean isEmailValid(EditText editText){
         if(TextUtils.isEmpty(editText.getText().toString())){
             editText.setError(context.getString(R.string.email_field_empty));
             editText.requestFocus();
             return false;
         } else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(editText.getText().toString()).matches()){
             editText.setError(context.getString(R.string.please_enter_a_valid_email));
             editText.requestFocus();
             return false;
         } else{
             return true;
         }
    }
    public boolean isPasswordValid(EditText editText){
        Matcher matcher = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$")
                .matcher(editText.getText().toString().trim());
        if(!matcher.matches()){
            editText.setError(context.getString(R.string.password_must_contain));
            editText.requestFocus();
            return false;
        } else {
            return true;
        }
    }
    public boolean isEmailPasswordValid(EditText editTextEmail, EditText ediTextPassword){
        return isEmailValid(editTextEmail) && isPasswordValid(ediTextPassword);
    }

}
