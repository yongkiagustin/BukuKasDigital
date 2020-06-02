package id.yongki.bukukasdigital.pemasukan;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import id.yongki.bukukasdigital.pengeluaran.PengeluaranDB;

@Dao
public interface PemasukanDao {
    @Query("SELECT * FROM pemasukan")
    List<PengeluaranDB> getAll();

    @Query("SELECT * FROM pengeluaran WHERE nama LIKE :nama")
    PengeluaranDB findByName(String nama);

    @Query("select sum(jumlah) from pemasukan")
    PengeluaranDB findBytotal(String jumlah);

    @Insert
    void insertAll(PemasukanDB... pemasukan);

    @Delete
    public void deletePengeluaran(PemasukanDB... pemasukan);
}
