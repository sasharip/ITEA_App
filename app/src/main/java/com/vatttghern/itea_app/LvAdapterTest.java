package com.vatttghern.itea_app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class LvAdapterTest extends ArrayAdapter<ImageView> {
    private List<ImageView> list;
    private Context context;
    private LayoutInflater inflater;

    public LvAdapterTest(Context context, int resource) {
        super(context, resource);
        list = new ArrayList<>();
        this.context = context;
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void updateList(List<ImageView> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
        Toast.makeText(getContext(), "updateList", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    public List<ImageView> getList() {
        return list;
    }

    @Nullable
    @Override
    public ImageView getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.each_item, parent, false);
        }
        ImageView ivListItem = (ImageView) view.findViewById(R.id.ivListItem);

        Glide.with(getContext())
                .load("http://a1.mzstatic.com/us/r30/Purple3/v4/ed/dd/e3/eddde34d-892d-a1f7-b60c-1a515dad042d/icon256x256.jpeg")
                .override(64, 64)
                .into(ivListItem);

        TextView tvPosition = (TextView) view.findViewById(R.id.tvPosition);


        tvPosition.setText("" + position + " position");


//        Toast.makeText(getContext(), list.size(), Toast.LENGTH_SHORT).show();

        return view;
    }
}