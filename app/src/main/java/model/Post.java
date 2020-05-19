package model;

import android.graphics.drawable.Drawable;

import java.util.UUID;

public class Post {
    private int _postPhoto;
    private String _id;
    private String _header;
    private String _description;
    private String _linkString;
    private String _link;
    private int _likesCount;
    private String _category;

    public Post(String header,String description, String linkString, String link, String category, int image){
        _id = UUID.randomUUID().toString();
        _header = header;
        _description = description;
        _linkString = linkString;
        _link = link;
        _category = category;
        _postPhoto = image;

        _likesCount = 0;
    }

    public Post(String header, String description, String linkString, String link, String category, int image, int likes){
        _id = UUID.randomUUID().toString();
        _header = header;
        _description = description;
        _linkString = linkString;
        _link = link;
        _category = category;
        _postPhoto = image;

        _likesCount = likes;
    }

    public int get_postPhoto(){return _postPhoto;}
    public String get_id(){return _id;}
    public String get_header(){return _header;}
    public String get_description(){return _description;}
    public String get_linkString(){return _linkString;}
    public String get_link(){return _link;}
    public int get_likesCount(){return _likesCount;}
    public void set_likesCount(){_likesCount++;}
}
