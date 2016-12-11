package com.vatttghern.itea_app;

public class Logic {

  public static final boolean isValidEmail(CharSequence target) {
    if (target == null) {
      return false;
    } else {
      return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
  }

  public static final boolean isValidPhoneNumber(CharSequence target) {
    if (target.length() != 10) {
      return false;
    } else {
      return android.util.Patterns.PHONE.matcher(target).matches();
    }
  }
}


