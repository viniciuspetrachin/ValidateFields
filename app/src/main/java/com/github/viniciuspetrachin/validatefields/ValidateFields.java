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

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateFields {

    private Context context;
    // You can substitute the regex code below for one that suits you best.
    private Pattern pattern_password = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=*])(?=\\S+$).*$");
    // Accepts the following formats: 12.345-678 | 12345-678 | 12345678
    private Pattern pattern_zipcode = Pattern.compile("(^\\d{5}-\\d{3}|^\\d{2}.\\d{3}-\\d{3}|\\d{8})");
    // Set the minimum characters the password must contain.
    private static final int PASSWORD_LENGTH = 8;

    public ValidateFields() {

    }

    ValidateFields(Context context) {
        this.context = context;
    }

    // FUNCTIONS
    boolean isEmailValid(EditText editText){
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

    boolean isPasswordValid(EditText editText){
        String password = editText.getText().toString();
        Matcher matcher = pattern_password.matcher(password.trim());
        // Checks if password field is empty
        if (password.equals("")) {
            editText.setError(context.getString(R.string.password_field_empty));
            editText.requestFocus();
            return false;
        }
        // Checks whether the password field has the minimum required characters
        else if (password.length() <= PASSWORD_LENGTH) {
            editText.setError(context.getString(R.string.password_must_long) + " " + PASSWORD_LENGTH + " " + context.getString(R.string.characters));
            editText.requestFocus();
            return false;
        }
        // Checks whether the field meets regex requirements
        else if (!matcher.matches()) {
            editText.setError(context.getString(R.string.password_must_contain));
            editText.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    boolean isAllFieldsValid(EditText editTextEmail, EditText ediTextPassword, EditText editTextZipCode){
        return isEmailValid(editTextEmail) && isPasswordValid(ediTextPassword) && isZipCodeValid(editTextZipCode);
    }
    boolean isZipCodeValid(EditText editText){
        String zipcode = editText.getText().toString();
        Matcher matcher = pattern_zipcode.matcher(zipcode);
        if(zipcode.equals("")){
            editText.setError(context.getString(R.string.zipcode_field_empty));
            editText.requestFocus();
        }
        if (!matcher.matches()) {
            editText.setError(context.getString(R.string.please_enter_a_valid_zipcode));
            editText.requestFocus();
            return false;
        } else {
            return true;
        }

    }

}
