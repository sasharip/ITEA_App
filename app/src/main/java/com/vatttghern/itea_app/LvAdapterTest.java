package com.vatttghern.itea_app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;


public class LvAdapterTest extends ArrayAdapter<Profile> {
    private List<ImageView> list;
    private Context context;
    private LayoutInflater inflater;

    Profile profile[];

    public LvAdapterTest(Context context, int resource, Profile[] profiles) {
        super(context, resource, profiles);
        this.context = context;
        this.profile = profiles;

        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    ImageView imageView;
    TextView tvName;
    TextView tvSurname;
    TextView tvCity;
    TextView tvCountry;
    TextView tvNotes;
    TextView tvEmail;
    TextView tvPhone;


    public void updateList(List<ImageView> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
        Toast.makeText(getContext(), "updateList", Toast.LENGTH_SHORT).show();
    }


    public List<ImageView> getList() {
        return list;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = null;
        if (convertView == null) {

            convertView = inflater.inflate(R.layout.each_item, parent, false);
        }
        imageView = (ImageView) convertView.findViewById(R.id.ivListItem);

        Picasso.with(getContext())
                .load(profile[position].logoId)
                .resize(128, 128)
                .into(imageView);


        tvName = (TextView) convertView.findViewById(R.id.tvName);
        tvName.setText(profile[position].name);
        tvSurname = (TextView) convertView.findViewById(R.id.tvSurname);
        tvSurname.setText(profile[position].surname);
        tvCountry = (TextView) convertView.findViewById(R.id.tvCountry);
        tvCountry.setText(profile[position].country);
        tvCity = (TextView) convertView.findViewById(R.id.tvCity);
        tvCity.setText(profile[position].city);
        tvPhone = (TextView) convertView.findViewById(R.id.tvPhone);
        tvPhone.setText(profile[position].phone);
        tvEmail = (TextView) convertView.findViewById(R.id.tvEmail);
        tvEmail.setText(profile[position].email);


//        Toast.makeText(getContext(), list.size(), Toast.LENGTH_SHORT).show();

        return convertView;
    }

}
