package id.yongki.bukukasdigital;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = PengeluaranDB.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PengeluaranDao CatPengeluaranDao();
}
