package com.vatttghern.itea_app;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;

import static com.vatttghern.itea_app.Constants.MY_PREFS_NAME;

public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.etNumber)
    EditText etNumber;

    @BindView(R.id.bCall)
    Button bCall;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final SharedPreferences settings = getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);

        etNumber.addTextChangedListener(
                new PhoneNumberFormattingTextWatcher() {
                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                        settings.edit().putString("number", etNumber.getText().toString());
                    }
                });

        bCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                String number = "tel:" + "38"+ settings.getString("number",null);
                callIntent.setData(Uri.parse(number));
                if (ActivityCompat.checkSelfPermission(SecondActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }
                startActivity(callIntent);
        }
    });
  }
}
