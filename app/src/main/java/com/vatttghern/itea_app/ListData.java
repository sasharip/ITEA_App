package com.vatttghern.itea_app;

import android.content.Intent;
/**
 * Created by vattg on 10.12.2016.
 */

public class ListData extends ListActivity{
    static String[] name = ListActivity.nameString;
    static String[] surname = ListActivity.surnameString;
    static String[] email = ListActivity.emailString;
    static String[] country = ListActivity.countryString;
    static String[] city = ListActivity.cityString;
    static String[] phone = ListActivity.phoneString;
    static String[] notes = ListActivity.notesString;
    static int logos[] = ListActivity.logoString;


    static Profile[] initProfile() {
        Profile profiles[] = new Profile[name.length];
        for (int i = 0; i < name.length; i++) {
            profiles[i] = new Profile(logos[i],name[i], surname[i], email[i], country[i], city[i], phone[i], notes[i]);
        }
        return profiles;
    }
}
