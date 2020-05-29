package id.yongki.bukukasdigital;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import id.yongki.bukukasdigital.pengeluaran.PengeluaranDB;
import id.yongki.bukukasdigital.pengeluaran.PengeluaranDao;

@Database(entities = PengeluaranDB.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PengeluaranDao CatPengeluaranDao();
}
