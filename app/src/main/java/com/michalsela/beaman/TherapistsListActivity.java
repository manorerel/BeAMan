package com.michalsela.beaman;

import androidx.appcompat.app.AppCompatActivity;
import model.FireBaseModel;
import model.User;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TherapistsListActivity extends BaseActivity {
    ListView lst;
    List<User> therapistsList;
    List<Drawable> therapistsImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_therapists_list);
        lst = findViewById(R.id.therapists_list);
        therapistsList = FireBaseModel.getAllTherapists();
        therapistsImages = new ArrayList<>();
        therapistsImages.add(getResources().getDrawable(R.drawable.therapist_one));
        therapistsImages.add(getResources().getDrawable(R.drawable.therapist_tow));
        therapistsImages.add(getResources().getDrawable(R.drawable.therapist_three));
        therapistsImages.add(getResources().getDrawable(R.drawable.therapist_four));
        therapistsImages.add(getResources().getDrawable(R.drawable.therapist_five));
        therapistsImages.add(getResources().getDrawable(R.drawable.therapist_six));
        therapistsImages.add(getResources().getDrawable(R.drawable.therapist_seven));
        lst.setAdapter(new TherapistsAdapter(this, therapistsList, therapistsImages));
    }

    public void openChat(View view){
        int position=Integer.parseInt(view.getTag().toString());
        Intent chatIntent = new Intent(this, ChatActivity.class);
        chatIntent.putExtra("therapist", therapistsList.get(position).get_lastName());
        startActivity(chatIntent);
    }
}

class TherapistsAdapter extends BaseAdapter {
    List<User> users;
    LayoutInflater inf;
    private List<Drawable> sources;
    TherapistsAdapter(Context con, List<User>data, List<Drawable> sourceImages){
        users=new LinkedList<>();
        if(data!=null){
            users=data;
        }
        sources = sourceImages;
        inf=LayoutInflater.from(con);
    }
    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inf.inflate(R.layout.therapist_row,null);
        TextView therapistName = convertView.findViewById(R.id.therapist_name);
        TextView therapistExplain = convertView.findViewById(R.id.therapist_explain);
        TextView therapistLanguage = convertView.findViewById(R.id.therapist_language);
        ImageView therapistImage = convertView.findViewById(R.id.therapist_image);
        LinearLayout linearLayout = convertView.findViewById(R.id.therapist_row_id);

        therapistName.setText("ד\"ר "+users.get(position).get_lastName());
        therapistName.setTag(position);
        therapistExplain.setText(users.get(position).get_explain());
        therapistExplain.setTag(position);
        therapistLanguage.setText(users.get(position).get_language());
        therapistLanguage.setTag(position);
        therapistImage.setImageDrawable(sources.get(position));
        therapistImage.setTag(position);
        linearLayout.setTag(position);

        return convertView;
    }
}
