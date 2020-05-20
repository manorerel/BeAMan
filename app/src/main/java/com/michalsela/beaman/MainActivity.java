package com.michalsela.beaman;

import model.FireBaseModel;
import model.Post;
import model.User;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
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

public class MainActivity extends BaseActivity {
    ListView lst;
    List<Post> postsList;
    List<Drawable> therapistsImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lst = findViewById(R.id.posts_list);
        postsList = FireBaseModel.getPosts();
        therapistsImages = new ArrayList<>();
        therapistsImages.add(getResources().getDrawable(R.drawable.post_one));
        therapistsImages.add(getResources().getDrawable(R.drawable.post_tow));
        therapistsImages.add(getResources().getDrawable(R.drawable.post_three));
        therapistsImages.add(getResources().getDrawable(R.drawable.first_pic));
        therapistsImages.add(getResources().getDrawable(R.drawable.second));
        therapistsImages.add(getResources().getDrawable(R.drawable.three));
        therapistsImages.add(getResources().getDrawable(R.drawable.therapist_seven));
        lst.setAdapter(new PostsAdapter(this,therapistsImages, postsList));
    }

    public void openTherapistList(View view){
        Intent treatIntent = new Intent(this, TherapistsListActivity.class);
        treatIntent.putExtra("kind","personal");
        startActivity(treatIntent);
    }

    public void openGroupCaht(View view){
        Intent groupVideoChatIntent = new Intent(this, TherapistsListActivity.class);
        groupVideoChatIntent.putExtra("kind","group");
        startActivity(groupVideoChatIntent);
    }

    public void goLink(View view){
        int position = Integer.parseInt(view.getTag().toString());
        String link = postsList.get(position).get_link();
        if(!link.equals("")){
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
            startActivity(browserIntent);
        }
    }
}

class PostsAdapter extends BaseAdapter {

    List<Post> posts;
    LayoutInflater inf;
    List<Drawable> imagesPost;
    PostsAdapter(Context con,List<Drawable>images, List<Post>data){
        posts =new LinkedList<>();
        if(data!=null){
            posts =data;
        }
        imagesPost = images;
        inf=LayoutInflater.from(con);
    }
    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inf.inflate(R.layout.post_row,null);
        TextView postHeader = convertView.findViewById(R.id.post_header);
        TextView postDescription = convertView.findViewById(R.id.post_description);
        TextView linkString = convertView.findViewById(R.id.link_string);
        ImageView postImage = convertView.findViewById(R.id.post_image);
        LinearLayout linearLayout = convertView.findViewById(R.id.post_row);
        TextView postLikes = convertView.findViewById(R.id.post_likes);
        TextView hashTag = convertView.findViewById(R.id.post_hash_tag);

        postHeader.setText(posts.get(position).get_header());
        postHeader.setTag(position);
        postDescription.setText(posts.get(position).get_description());
        postDescription.setTag(position);
        linkString.setText(posts.get(position).get_linkString());
        linkString.setTag(position);
        postImage.setImageDrawable(imagesPost.get(position));
        postImage.setTag(position);
        linearLayout.setTag(position);
        Integer likes = posts.get(position).get_likesCount();
        postLikes.setText(likes.toString());
        hashTag.setText(posts.get(position).get_category());

        return convertView;
    }

}
