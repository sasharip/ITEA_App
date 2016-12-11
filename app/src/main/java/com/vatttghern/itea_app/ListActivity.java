package com.vatttghern.itea_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.common.primitives.Ints;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListActivity extends AppCompatActivity {

    ArrayAdapter<Profile> ad;

    public List<String> name = Arrays.asList("name1", "name2", "name3", "name4");
    public List<String> surname = Arrays.asList("surname1", "surname2", "surname3", "surname4");
    public List<String> email = Arrays.asList("wq@11.123", "qqr@12q.dad", "faga@fa.faa", "gjhg@ff.q2e");
    public List<String> country = Arrays.asList("uk", "gb", "irl", "swe");
    public List<String> city = Arrays.asList("qwxd", "qe", "qe2", "qweqe");
    public List<String> phone = Arrays.asList("0505489444", "0068887494", "0488843675", "0965487268");
    public List<String> notes = Arrays.asList("adafagag", "aggagagag", "agagag", "aggagag");
    public List<Integer> logos = Arrays.asList(R.drawable.profile1logo, R.drawable.profile2logo, R.drawable.profile3logo, R.drawable.profile4logo);

    String newName;
    String newSurname;
    String newEmail;
    String newCountry;
    String newCity;
    String newPhone;
    String newNotes;
    int newlogo;

    public static String[] nameString;
    public static String[] surnameString;
    public static String[] countryString;
    public static String[] cityString;
    public static String[] emailString;
    public static String[] phoneString;
    public static String[] notesString;
    public static int[] logoString;

    @BindView(R.id.lvTest)
    ListView list;

    @BindView(R.id.bExit)
    Button bExit;


    @OnClick(R.id.bBack)
    void onClick(View v) {
        Intent refresh = new Intent(this, ProfileActivity.class);
        startActivity(refresh);
        this.finish(); //
    }

    @OnClick(R.id.bExit)
    void onClick1(View v) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactlist);
        ButterKnife.bind(this);


        Intent i3 = getIntent();

        POJO pojo = (POJO) getIntent().getParcelableExtra(POJO.class.getCanonicalName());

        newName = pojo.getName().toString();                        //getting from pojo
        name.add(newName);                                          //adding new value
        String[] nameString = name.toArray(new String[0]);          //set array to string[] to send to listdata

        newSurname = pojo.getSurname().toString();
        surname.add(newSurname);
        String[] surnameString = surname.toArray(new String[0]);

        newCity = pojo.getCity().toString();
        city.add(newCity);
        String[] cityString = city.toArray(new String[0]);

        newCountry = pojo.getCountry().toString();
        country.add(newCountry);
        String[] countryString = country.toArray(new String[0]);

        newEmail = pojo.getEmail().toString();
        email.add(newEmail);
        String[] emailString = email.toArray(new String[0]);

        newPhone = pojo.getPhone().toString();
        phone.add(newPhone);
        String[] phoneString = phone.toArray(new String[0]);

        newlogo=pojo.getImage().intValue();
        logos.add(newlogo);
        int[] logoString = Ints.toArray(logos);


        Profile profileData[] = ListData.initProfile();
        ad = new LvAdapterTest(this, R.id.lvTest, profileData);

        list.setAdapter(ad);


    }

    // Convert Integer[] to int[]
    public static int[] toPrimitive(Integer[] IntegerArray) {

        int[] result = new int[IntegerArray.length];
        for (int i = 0; i < IntegerArray.length; i++) {
            result[i] = IntegerArray[i].intValue();
        }
        return result;
    }


}
