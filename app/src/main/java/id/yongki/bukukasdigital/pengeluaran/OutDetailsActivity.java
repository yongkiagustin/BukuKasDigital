package id.yongki.bukukasdigital.pengeluaran;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import id.yongki.bukukasdigital.AppDatabase;
import id.yongki.bukukasdigital.R;

public class OutDetailsActivity extends AppCompatActivity {
    OutRecyclerAdapter recycleAdapter;
    List<PengeluaranDB> listPengeluaran = new ArrayList<>();
    public static AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_details);

        fetchDataFromRoom();
        initRecyclerView();
        setAdapter();
    }

    private void fetchDataFromRoom() {
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class,"pengeluaran").allowMainThreadQueries().build();
        listPengeluaran = db.CatPengeluaranDao().getAll();
        }

    private void initRecyclerView() {
        RecyclerView myRecyclerview = (RecyclerView)findViewById(R.id.myRecyclerview);
        myRecyclerview.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        myRecyclerview.setLayoutManager(llm);
        recycleAdapter =new OutRecyclerAdapter(this, listPengeluaran);
    }
    private void setAdapter() {
        RecyclerView myRecyclerview = (RecyclerView)findViewById(R.id.myRecyclerview);
        myRecyclerview.setAdapter(recycleAdapter);
    }
}
