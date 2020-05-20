package model;

import android.graphics.drawable.Drawable;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.michalsela.beaman.R;

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

    public static List<Group> getGourps(){
        List<Group> groups = new ArrayList<>();
        Group g1 = new Group("1", "כהן", "ב\' ו-ה\'", "18:00-20:00", "עברית");
        Group g2 = new Group("2", "חטיב", "א\' ו-ג\'", "15:00-16:30", "ערבית");
        Group g3 = new Group("3", "בשבסקי", "ב\' ו-ד\'", "17:00-18:00", "רוסית");
        Group g4 = new Group("4", "מיטשל", "ג\' ו-ו\'", "16:00-17:30", "אנגלית");
        Group g5 = new Group("5", "חובב", "ב\' ו-ד\'", "18:00-19:30", "עברית");
        Group g6 = new Group("6", "שריסט", "ד\' ו-ה\'", "19:00-20:00", "עברית");

        groups.add(g1);
        groups.add(g2);
        groups.add(g3);
        groups.add(g4);
        groups.add(g5);
        groups.add(g6);

        return groups;
    }

    public static List<Post> getPosts(){
        List<Post> posts = new ArrayList<>();
        Post p1 = new Post("ביחד הצלחנו לעשות זאת","קבוצת התמיכה נתנה לי את הכוח להמשיך את התהליך, מספר אורי",
                "לעוד סיפורי הצלחה", "", "#סיפורי הצלחה",R.drawable.post_one, 90);

        Post p2 = new Post("איך אתה מרגיש היום?",
                "אנחנו כאן כדי לשמוע אותך. בלחיצת כפתור תוכל להצטרף לצ'אט אישי או לקבוצת תמיכה", "להתחלת צ'אט ניסיון",
                "", "#אבחון",R.drawable.post_tow, 48);
        Post p3 = new Post("עשרה תרגילי נשימה לתרגול","תרגילי נשימה קלילים לתרגול בכל זמן ובכל מקום",
                "כנס לתרגל", "https://www.youtube.com/watch?v=sbrOSeZiRp4", "#כלים מסייעים",R.drawable.post_three, 52);
        Post p4 = new Post("\"הייתה לי שליטה מלאה באישה\"","במקום בכלא - בבית פרטי בבאר שבע חיים גברים שהורשעו בעבירות אלימות במשפחה. שם יש פיקוח וטיפול, וגם הילדים באים לבקר...",
                "כנס לכתבה", "https://www.ynet.co.il/articles/0,7340,L-5046837,00.html",
                "#אבחון",R.drawable.first_pic, 90);
        Post p5 = new Post("\"אם נתגרש - ארצח אותך ואתאבד\"",
                "אורלי אוימה ברצח על ידי בעלה לשעבר. על רקע שמונת מקרי הרצח של נשים על ידי בני זוגן מתחילת השנה..",
                "כנס לכתבה", "https://www.ynet.co.il/articles/0,7340,L-5732722,00.html", "#אבחון",R.drawable.second, 90);
        Post p6 = new Post("סיוע משפטי בנושא אלימות במשפחה מטעם משרד המשפטים",
                "משרד המשפטים מעניק לאוכלוסיות הזכאיות סיוע משפטי בתחומים אזרחיים הכוללים, בין היתר, את נושא האלימות במשפחה. הסיוע ניתן במקרים שבהם קיים לכך ביסוס משפטי.",
                "להסבר לחץ כאן", "https://www.kolzchut.org.il/he/%D7%A1%D7%99%D7%95%D7%A2_%D7%9E%D7%A9%D7%A4%D7%98%D7%99_%D7%91%D7%A0%D7%95%D7%A9%D7%90_%D7%90%D7%9C%D7%99%D7%9E%D7%95%D7%AA_%D7%91%D7%9E%D7%A9%D7%A4%D7%97%D7%94_%D7%9E%D7%98%D7%A2%D7%9D_%D7%9E%D7%A9%D7%A8%D7%93_%D7%94%D7%9E%D7%A9%D7%A4%D7%98%D7%99%D7%9D",
                "#יעוץ משפטי",R.drawable.three, 90);

        posts.add(p1);
        posts.add(p2);
        posts.add(p3);
        posts.add(p4);
        posts.add(p5);
        posts.add(p6);
        return posts;
    }

    private static Map<String, Object> userToMap(User user){
        Map<String, Object> mapUser = new HashMap<>();
        mapUser.put("id", user.get_id());
        mapUser.put("userName", user.get_userName());
        mapUser.put("password", user.get_password());

        return mapUser;
    }
}
