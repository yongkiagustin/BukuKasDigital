package id.yongki.bukukasdigital;

import android.app.Application;

import androidx.room.Room;
//db masih error

public class MyApp extends Application {
    public static AppDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class,"pengeluaran").allowMainThreadQueries().build();
    }
}
