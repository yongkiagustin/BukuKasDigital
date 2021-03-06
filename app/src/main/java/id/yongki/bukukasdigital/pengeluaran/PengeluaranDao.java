package id.yongki.bukukasdigital.pengeluaran;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PengeluaranDao {
    @Query("SELECT * FROM pengeluaran")
    List<PengeluaranDB> getAll();

    @Query("SELECT * FROM pengeluaran WHERE nama LIKE :nama")
    PengeluaranDB findByName(String nama);

    @Query("select sum(jumlah) from pengeluaran")
    PengeluaranDB findBytotal(String jumlah);

    @Insert
    void insertAll(PengeluaranDB... pengeluaran);

    @Delete
    public void deletePengeluaran(PengeluaranDB... pengeluaran);
}
