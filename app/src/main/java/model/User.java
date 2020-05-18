package model;

import java.util.UUID;

public class User {
    String _id;
    String _userName;
    String _password;
    String _mail;
    String _firstName;
    String _lastName;
    Boolean _isTherapist;

    public User(String userName, String password, String mail, String firstName, String lastName, Boolean isTherapist){
        _id = UUID.randomUUID().toString();
        _userName = userName;
        _password = password;
        _firstName = firstName;
        _lastName = lastName;
        _mail = mail;
        _isTherapist = isTherapist;
    }

    public String get_id(){return _id;}
    public void set_id(String id){_id = id;}

    public String get_userName(){return _userName;}
    public void set_userName(String userName){_userName = userName;}

    public String get_password(){return _password;}
    public void set_password0(String password){_password = password;}

    public String get_mail(){return _mail;}
    public String get_firstName(){return _firstName;}
    public String get_lastName(){return _lastName;}
    public Boolean get_isTherapist(){return _isTherapist;}
}
