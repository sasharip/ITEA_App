package com.vatttghern.itea_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class ProfileActivity extends AppCompatActivity {
    @BindView(R.id.tNewToolBar)
    Toolbar tNewToolBar;

    @BindView(R.id.bCancel)
    Button bCancel;

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



    final String SAVED_TEXT = "saved_text";
    String name;
    String surname;
    String city;
    String email;
    String country;
    String notes;
    String phone;

    SharedPreferences sPref;
    private int PICK_IMAGE_REQUEST = 1;
    POJO pojo= new POJO("text",1);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        setSupportActionBar(tNewToolBar);

        Intent i = getIntent();
        POJO pojo= new POJO("text",1);


        String userLogin = getIntent().getStringExtra("login");
        getSupportActionBar().setTitle(userLogin);


    }

    @OnClick(R.id.ivProfPic)
    void ivProfPic1(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST
                && resultCode == RESULT_OK
                && data != null
                && data.getData() != null) {
            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                // Log.d(TAG, String.valueOf(bitmap));

                ImageView imageView = (ImageView) findViewById(R.id.ivProfPic);
                imageView.setImageBitmap(bitmap);
                pojo.setImage(bitmap);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @OnTextChanged(R.id.etName)
    public void onTextChanged(CharSequence text) {
        String name = etName.getText().toString();
        if (name.trim().equals("")) {
            Toast.makeText(this, "Enter Name", Toast.LENGTH_SHORT).show();
        } else {
            if (name.trim().matches("[0-9]+") && name.length() > 2) {
                pojo.setName(name);
            }
        }
    }

    @OnTextChanged(R.id.etSurname)
    void onTextChanged1(CharSequence text) {
        String surname = etSurname.getText().toString();
        if (surname.trim().equals("")) {
            Toast.makeText(this, "Enter Surname", Toast.LENGTH_SHORT).show();

        } else {
            if (surname.trim().matches("[0-9]+") && surname.length() > 2) {
                pojo.setSurname(name);
            }
        }
    }

    @OnTextChanged(R.id.etCountry)
    public void onTextChanged2(CharSequence text) {
        String country = etCountry.getText().toString();
        if (country.trim().equals("")) {
            Toast.makeText(this, "Enter country", Toast.LENGTH_SHORT).show();
        } else {
            if (country.trim().matches("[0-9]+") && country.length() > 2) {
                pojo.setCountry(country);
            }
        }
    }

    @OnTextChanged(R.id.etCity)
    public void onTextChanged3(CharSequence text) {
        String city = etCity.getText().toString();
        if (city.trim().equals("")) {
            Toast.makeText(this, "Enter city", Toast.LENGTH_SHORT).show();
        } else {
            if (city.trim().matches("[0-9]+") && city.length() > 2) {
                pojo.setCity(city);
            }
        }
    }

    @OnTextChanged(R.id.etNotes)
    public void onTextChanged4(CharSequence text) {
        String notes = etNotes.getText().toString();
        if (notes.trim().equals("")) {

        } else {
            if (notes.trim().matches("[0-9]+") && notes.length() > 2) {
                pojo.setNotes(notes);
            }
        }
    }

    @OnTextChanged(R.id.etPhone)
    void onTextChanged5(CharSequence text) {
        phone = etPhone.getText().toString();

        try {
            int valPhone = Integer.parseInt(phone);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter numbers", Toast.LENGTH_SHORT).show();
        }

        if (phone.trim().equals("")) {
            boolean val = Logic.isValidPhoneNumber(phone);
            int valPhone = Integer.parseInt(phone);
            if (val = true) {
                pojo.setPhone(valPhone);
            } else {
                Toast.makeText(this, "Enter Number", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Fill Phone Number", Toast.LENGTH_SHORT);
        }
    }

    @OnTextChanged(R.id.etEmail)
    void onTextChanged6(CharSequence text) {
        email = etEmail.getText().toString();
        boolean val = Logic.isValidEmail(email);
        if (val = true) {
            pojo.setEmail(email);
        }
    }

    @OnClick(R.id.bExit1)
    void bExit(View view) {
        finish();
    }

    @OnClick(R.id.bSave)
    void bSave(View view) {
        if ((etName.getText().toString()).length() > 0
                || (etSurname.getText().toString()).length() > 0
                || (etCity.getText().toString()).length() > 0
                || (etEmail.getText().toString()).length() > 0
                || (etPhone.getText().toString()).length() > 0
                || (etCountry.getText().toString()).length() > 0) {


            Intent i2 = new Intent(this, ListActivity.class);
            i2.putExtra(POJO.class.getCanonicalName(), pojo);

            startActivity(i2);
        } else {
            Toast.makeText(this, "All fields cannot be empty", Toast.LENGTH_SHORT).show();

        }
    }
}

