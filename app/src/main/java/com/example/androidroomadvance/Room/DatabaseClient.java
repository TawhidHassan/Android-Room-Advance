package com.example.androidroomadvance.Room;
        import android.content.Context;
        import androidx.room.Room;
        import com.example.androidroomadvance.MainActivity;

        /**that was for  Single Instance fort prevent make multiple database object  **/

public class DatabaseClient {
    private static  MyDatabase myDatabase;

    public static MyDatabase databaseClient(Context context){
        if (myDatabase==null){
            myDatabase= Room.databaseBuilder(context, MyDatabase.class,"StudentDB")
                    .allowMainThreadQueries().build();
        }
        return myDatabase;
    }
}
