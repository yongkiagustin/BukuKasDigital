package id.yongki.bukukasdigital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static id.yongki.bukukasdigital.MyApp.db;

public class DetailsActivity extends AppCompatActivity {
    RecyclerAdapter recycleAdapter;
    List<PengeluaranDB> listPengeluaran = new ArrayList<>();
    public static AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        fetchDataFromRoom();
        initRecyclerView();
        setAdapter();
    }

    private void fetchDataFromRoom() {
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class,"pengeluaran").allowMainThreadQueries().build();
        listPengeluaran = db.CatPengeluaranDao().getAll();

        //just checking data from db
        for (int i = 0 ;i <listPengeluaran.size();i++){
            Log.e("Aplikasi",listPengeluaran.get(i).getNama()+i);
            Log.e("Aplikasi",listPengeluaran.get(i).getJumlah()+i);
            Log.e("Aplikasi",listPengeluaran.get(i).getNama()+i);
            Log.e("Aplikasi",listPengeluaran.get(i).getTanggal()+i);
        }
    }
    private void initRecyclerView() {
        RecyclerView myRecyclerview = (RecyclerView)findViewById(R.id.myRecyclerview);
        myRecyclerview.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        myRecyclerview.setLayoutManager(llm);
        recycleAdapter =new RecyclerAdapter(this, listPengeluaran);
    }
    private void setAdapter() {
        RecyclerView myRecyclerview = (RecyclerView)findViewById(R.id.myRecyclerview);
        myRecyclerview.setAdapter(recycleAdapter);
    }
}
