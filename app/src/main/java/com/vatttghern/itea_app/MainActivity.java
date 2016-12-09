package com.vatttghern.itea_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.tNewToolBar)
  Toolbar tNewToolBar;

  @BindView(R.id.etLogin)
  EditText userLogin;

  @BindView(R.id.etPassword)
  EditText userPassword;

  @BindView(R.id.bSignIn)
  Button bSignIn;

  public static final String LOGIN = "login";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    setSupportActionBar(tNewToolBar);
    getSupportActionBar().setTitle("Log In");

    //       final String etPassword = userPassword.getText().toString();

    bSignIn.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
            i.putExtra("login", userLogin.getText().toString());
            //            i.putExtra("password", etPassword);
            startActivity(i);
            finish();
          }
        });

    //        lvTest = (ListView) findViewById(R.id.lvTest);
    //        adapter = new LvAdapterTest(this, R.layout.each_item);
    //        lvTest.setAdapter(adapter);
    //        List<ImageView> l = new ArrayList<ImageView>();
    //        for (i = 0; i < 40; i++) {
    //            l.add(new ImageView(getApplicationContext()));
    //
    //        }
    //        adapter.updateList(l);

  }
}
