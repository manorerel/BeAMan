package model;

import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public static List<User> getAllTherapists(){
        List<User> therapists = new ArrayList<>();
        User u1 = new User("שלמה1", "1234", "", "גל", "כהן", true,
                "בעל ניסיון של עשרים שנה בתחום הייעוץ הזוגי, מטפל במרכז ת\"א ובאזור השרון","עברית");
        User u2 = new User("שלמה2", "2345", "", "אחמד", "חטיב", true,
                "עשר שנים ניסיון, התמחות בשליטה על כעסים ומיינדפולנס, מטפל בצפון","ערבית");
        User u3 = new User("שלמה3", "3456", "", "סרגיי", "בשבסקי", true,
                "עשרים שנה ניסיון, התמחות בשליטה על כעסים, מטפל בדרום ובמרכז","רוסית");
        User u4 = new User("שלמה4", "4567", "", "מייק", "מיטשל", true,
                "בעל ניסיון של חמש שנים בתחום הייעוץ הזוגי, מטפל בת\"א ובחיפה","אנגלית");
        User u5 = new User("שלמה5", "5678", "", "ארנון", "חובב", true,
                "בעל ניסיון של עשרים שנה בתחום הייעוץ הזוגי, מטפל במרכז ת\"א ובאזור השרון","עברית");
        User u6 = new User("שלמה6", "6789", "", "משה", "שריסט", true,
                "בעל ניסיון של עשרים שנה בתחום הייעוץ הזוגי, מטפל במרכז ת\"א ובאזור השרון","עברית");
        User u7 = new User("שלמה7", "7890", "", "אפרת", "אמיר", true,
                "בעלת ניסיון של שש שנה בתחום הייעוץ הזוגי, מטפלת באשדוד ואשקלון","עברית");
        therapists.add(u1);
        therapists.add(u2);
        therapists.add(u3);
        therapists.add(u4);
        therapists.add(u5);
        therapists.add(u6);
        therapists.add(u7);

        return therapists;
    }

    private static Map<String, Object> userToMap(User user){
        Map<String, Object> mapUser = new HashMap<>();
        mapUser.put("id", user.get_id());
        mapUser.put("userName", user.get_userName());
        mapUser.put("password", user.get_password());

        return mapUser;
    }
}
