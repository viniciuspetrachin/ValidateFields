# ValidateFields

This class aims to facilitate the means of verifying the fields of email, password, cpf, rg and phone number in Brazilian formats, as simplified, light and effective as possible, feel free to contribute to this project with your pull request. Whenever I learn something new I will implement here. Feel free to request formats from other countries as well.

# Validations implemented
- [x] Validate Email
- [x] Validate Password
- [x] Validate ZIP Code

# How to instantiate the class?

> ValidadeFields v1 = new ValidateFields(context); // You can use getActivityContext()

# Available Methods

> isEmailValid(editText);

> isPasswordValid(editText);

> isZipCodeValid(editText);

> isAllFieldsValid(editTextEmail, editTextPassword, editTextZipCode);
