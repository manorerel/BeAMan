package model;

import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;

public class FireBaseModel {
    public static void saveUser(User user){
        try {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("user").child(user.toString());
            myRef.setValue(userToMap(user)).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                }
            });
        }
        catch (Exception e){
            Log.println(1, "",e.getMessage());
        }


    }

    private static Map<String, Object> userToMap(User user){
        Map<String, Object> mapUser = new HashMap<>();
        mapUser.put("id", user.get_id());
        mapUser.put("userName", user.get_userName());
        mapUser.put("password", user.get_password());

        return mapUser;
    }
}
