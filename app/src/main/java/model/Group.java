package model;

import java.util.UUID;

public class Group {
    private String _id;
    private String _name;
    private String _doctor_name;
    private String _days;
    private String _hours;
    private String _language;

    public Group(String name, String doc_name, String days, String hours, String language){
        _id = UUID.randomUUID().toString();
        _name = name;
        _doctor_name = doc_name;
        _days = days;
        _hours = hours;
        _language = language;
    }

    public String get_id(){return _id;}
    public String get_name(){return _name;}
    public String get_doctor_name(){return _doctor_name;}
    public String get_days(){return _days;}
    public String get_hours(){return _hours;}
    public String get_language(){return _language;}
}
