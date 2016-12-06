package com.vatttghern.itea_app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  @BindView(R.id.ivBackground)
  ImageView ivBlur;

  @BindView(R.id.toolbar)
  Toolbar toolbar;

  @BindView(R.id.twToolbar)
  TextView twToolbar;

  @BindView(R.id.bFacebook)
  Button bFacebook;

  @BindView(R.id.bGoogle)
  Button bGoogle;

  @BindView(R.id.bSignIn)
  Button bSignIn;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    Bitmap ivFinishedBlur =
        BlurBuilder.blur(this, BitmapFactory.decodeResource(getResources(), R.drawable.bcgrdblur));
    ivBlur.setImageBitmap(ivFinishedBlur);
    bFacebook.setOnClickListener(this);
    bGoogle.setOnClickListener(this);
    bSignIn.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {

    switch (v.getId()) {
      case R.id.bFacebook:
        Toast.makeText(MainActivity.this, "Logged In Google", Toast.LENGTH_SHORT).show();
        break;

      case R.id.bGoogle:
        Toast.makeText(MainActivity.this, "Logged in Facebook", Toast.LENGTH_SHORT).show();
        break;

      case R.id.bSignIn:
        startActivity(new Intent(getApplicationContext(),SecondActivity.class));
        break;

      default:
        break;
    }
  }
}

/*
Ты использовал БаттерНайф - КРАСАВА. Реально молодец.
* 1 У меня выпала ошибка  java.lang.OutOfMemoryError: Failed to allocate a 47775756 byte allocation with 16777216 free bytes and 40MB until OOM
*   твое приложение не самое унифицированое. На разных телефонах ОС выделяет разное кол-во памяти одним куском.
*   Такое нужно предусмотреть!
* 2 Я уверен , что ты бы справился с той штукой о которой я говорил, ТекстИнпутЛейоут. Она не сложная.
*   Попробуй.
* 3 Написать свой тулбар, это хороший выход из ситуации, но все же попробуй найти способ сдельть уже существующий тулбар прозрачным,
*   это уменьшит количество строк кода, до пары строк в стилях
* */
