package com.vatttghern.itea_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class ProfileActivity extends AppCompatActivity {
  @BindView(R.id.tNewToolBar)
  Toolbar tNewToolBar;

  @BindView(R.id.bCancel)
  Button bCancel;

  @BindView(R.id.bSave)
  Button bSave;

  @BindView(R.id.etSurname)
  EditText etSurname;

  @BindView(R.id.etEmail)
  EditText etEmail;

  @BindView(R.id.etCountry)
  EditText etCountry;

  @BindView(R.id.etCity)
  EditText etCity;

  @BindView(R.id.etPhone)
  EditText etPhone;

  @BindView(R.id.etNotes)
  EditText etNotes;

  @BindView(R.id.etName)
  EditText etName;

    POJO pojo;

  final String SAVED_TEXT = "saved_text";
  SharedPreferences sPref;

  @OnClick(R.id.bExit1)
  void bExit(View view) {
    finish();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_profile);
    ButterKnife.bind(this);
    setSupportActionBar(tNewToolBar);

    Intent i = getIntent();
    Bundle extras = i.getExtras();

    if (extras.containsKey(MainActivity.LOGIN)) {
      String login = extras.getString(MainActivity.LOGIN);
      // getSupportActionBar().setTitle(getResources().getString(Integer.parseInt(login)));
    }
  }

  @OnTextChanged(
    value = {R.id.etName, R.id.etSurname, R.id.etCountry, R.id.etCity, R.id.etNotes},
    callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED
  )
  public void onTextChanged(EditText editText, Editable s) {
    String name = etName.getText().toString();
    String surname = etSurname.getText().toString();
    String country = etCountry.getText().toString();
    String city = etCity.getText().toString();
    String notes = etNotes.getText().toString();
  }


  @OnClick(R.id.bSave)
  void bSave(View view) {
    if(etName.getText().toString().trim().equals("")){
        Toast.makeText(this,"Enter Name",Toast.LENGTH_SHORT);
    }else {
        if(etName.getText().toString().trim().matches("[0-9]+") && etName.getText().toString().length() > 2){
 //           etName.getText().toString().
        }
    }
  }

  public boolean isValidEmailAddress(String email) {
    String ePattern =
        "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*\n"
            + "@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$;";
    java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
    java.util.regex.Matcher m = p.matcher(email);
    return m.matches();
  }

  public static boolean isValidPhoneNumber(CharSequence target) {
    if (target == null || TextUtils.isEmpty(target)) {
      return false;
    } else {
      return android.util.Patterns.PHONE.matcher(target).matches();
    }
  }

  /* @OnTextChanged(
    value = {
      R.id.etName,
      R.id.etSurname,
      R.id.etEmail,
      R.id.etCountry,
      R.id.etCity,
      R.id.etPhone,
      R.id.etNotes
    },
    callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED
  )
  public void onTextChanged (EditText editText, Editable s) {
    String str = editText.getText().toString();
    if ("".equals(str)) {
      Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT);
    } else {
      switch (editText.getId()) {
        case R.id.etEmail:
          isValidEmailAddress(str);
          break;
        case R.id.etPhone:
          isValidPhoneNumber(str);
          break;
        default:
          break;*/
}
