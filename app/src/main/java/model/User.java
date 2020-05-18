package model;

import java.util.UUID;

public class User {
    String _id;
    String _userName;
    String _password;

    public User(String userName, String password){
        _id = UUID.randomUUID().toString();
        _userName = userName;
        _password = password;
    }

    public String get_id(){return _id;}
    public void set_id(String id){_id = id;}

    public String get_userName(){return _userName;}
    public void set_userName(String userName){_userName = userName;}

    public String get_password(){return _password;}
    public void set_password0(String password){_password = password;}
}
