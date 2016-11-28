package com.vatttghern.itea_app;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
  private EditText etName;
  private EditText etSurname;
  private EditText etEmail;
  private CheckBox cbAuto;
  private CheckBox cbCreditCard;
  private CheckBox cbJava;
  private CheckBox cbJavaEE;
  private CheckBox cbAndroid;
  private CheckBox cbCsharp;
  private CheckBox cbPHP;
  private CheckBox cbOther;
  private RadioButton rbFulltime;
  private RadioButton rbFreelance;
  private RadioButton rbRemote;
  private RadioButton rbOther;
  private Button bSave;
  private Button bLater;
  private Button bCancel;
  private static final String MY_PREFS_NAME = "MyPrefsFile";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    final SharedPreferences settings = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);

    final EditText etName = (EditText) findViewById(R.id.etName);
    etName.addTextChangedListener(
        new TextWatcher() {

          @Override
          public void afterTextChanged(Editable s) {}

          @Override
          public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

          @Override
          public void onTextChanged(CharSequence s, int start, int before, int count) {
            etName.getText().toString();
            if (etName.equals("")) {
              Toast.makeText(MainActivity.this, "You did not enter a your name", LENGTH_SHORT)
                  .show();
            }
          }
        });

    final EditText etSurname = (EditText) findViewById(R.id.etSurname);
    etName.addTextChangedListener(
        new TextWatcher() {

          @Override
          public void afterTextChanged(Editable s) {}

          @Override
          public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

          @Override
          public void onTextChanged(CharSequence s, int start, int before, int count) {
            etSurname.getText().toString();
            if (etSurname.equals("")) {
              Toast.makeText(
                      getApplicationContext(), "You did not enter a your surname", LENGTH_SHORT)
                  .show();
            }
          }
        });

    final EditText etMail = (EditText) findViewById(R.id.etMail);
    etName.addTextChangedListener(
        new TextWatcher() {

          @Override
          public void afterTextChanged(Editable s) {}

          @Override
          public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

          @Override
          public void onTextChanged(CharSequence s, int start, int before, int count) {
            etMail.getText().toString();
            if (etMail.equals("")) {
              Toast.makeText(
                      getApplicationContext(), "You did not enter correct e-mail", LENGTH_SHORT)
                  .show();
            }
          }
        });

    final CheckBox cbAuto = (CheckBox) findViewById(R.id.cbAuto);
    cbAuto.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {

            if (cbAuto.isChecked()) {

              settings.edit().putBoolean("check", true).commit();
            }
          }
        });

    final CheckBox cbCreditCard = (CheckBox) findViewById(R.id.cbCreditCard);
    cbCreditCard.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {

            if (cbCreditCard.isChecked()) {

              settings.edit().putBoolean("check", true).commit();
            }
          }
        });

    final CheckBox cbJava = (CheckBox) findViewById(R.id.cbJava);
    cbJava.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {

            if (cbJava.isChecked()) {
              SharedPreferences settings = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
              settings.edit().putBoolean("check", true).commit();
            }
          }
        });

    final CheckBox cbJavaEE = (CheckBox) findViewById(R.id.cbJavaEE);
    cbJavaEE.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {

            if (cbJavaEE.isChecked()) {
              SharedPreferences settings = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
              settings.edit().putBoolean("check", true).commit();
            }
          }
        });

    final CheckBox cbAndroid = (CheckBox) findViewById(R.id.cbAndroid);
    cbAndroid.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {

            if (cbAndroid.isChecked()) {

              settings.edit().putBoolean("check", true).commit();
            }
          }
        });

    final CheckBox cbPHP = (CheckBox) findViewById(R.id.cbPHP);
    cbPHP.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {

            if (cbPHP.isChecked()) {
              SharedPreferences settings = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
              settings.edit().putBoolean("check", true).commit();
            }
          }
        });

    final CheckBox cbOther = (CheckBox) findViewById(R.id.cbOther);
    cbOther.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {

            if (cbOther.isChecked()) {
              SharedPreferences settings = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
              settings.edit().putBoolean("check", true).commit();
            }
          }
        });

    final CheckBox cbCsharp = (CheckBox) findViewById(R.id.cbCsharp);
    cbCsharp.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {

            if (cbCsharp.isChecked()) {
              SharedPreferences settings = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
              settings.edit().putBoolean("check", true).commit();
            }
          }
        });

    final RadioGroup rgWorkSchedule = (RadioGroup) findViewById(R.id.rgWorkSchedule);
    if (rgWorkSchedule.getCheckedRadioButtonId() != -1) {
      Toast.makeText(getApplicationContext(), "Please select some your language", LENGTH_SHORT)
          .show();
    } else {
      int selected = rgWorkSchedule.getCheckedRadioButtonId();
      RadioButton b = (RadioButton) findViewById(selected);
      b.getText();
    }

    Button bSave = (Button) findViewById(R.id.bSave);
    bSave.setOnClickListener(
        new View.OnClickListener() {

          @Override
          public void onClick(View v) {
            // TODO Auto-generated method stub

            SharedPreferences settings = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();

            editor.putString("name", etName.getText().toString());
            editor.putString("surname", etSurname.getText().toString());
            editor.putString("name", etMail.getText().toString());
            editor.putInt("work schedule", rgWorkSchedule.getCheckedRadioButtonId());
            editor.putBoolean("Java", cbJava.isChecked());
            editor.putBoolean("JavaEE", cbJavaEE.isChecked());
            editor.putBoolean("PHP", cbPHP.isChecked());
            editor.putBoolean("Android", cbAndroid.isChecked());
            editor.putBoolean("Other", cbOther.isChecked());
            editor.putBoolean("auto", cbAuto.isChecked());
            editor.putBoolean("credit card", cbCreditCard.isChecked());
            editor.putBoolean("Java", cbJava.isChecked());
            editor.putBoolean("Java", cbJava.isChecked());


            editor.commit();

            Toast.makeText(getBaseContext(), "Saved", Toast.LENGTH_SHORT).show();
          }
        });

      Button bLater = (Button) findViewById(R.id.bLater);
      bSave.setOnClickListener(
              new View.OnClickListener() {

                  @Override
                  public void onClick(View v) {

                      finish();
                      System.exit(0);

                  }
                  });
  }
}
