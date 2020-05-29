package id.yongki.bukukasdigital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import static id.yongki.bukukasdigital.MyApp.db;

public class OutActivity extends AppCompatActivity {


    private DatePickerDialog.OnDateSetListener mOnDateSetListener;
    private EditText etName, etTotal, etDate, etDesc;
    private ImageView setDate;
    private Button btSimpan;
    private PengeluaranDB pengeluaran;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out);



        //inialisasi view
        etDate = findViewById(R.id.out_et_tanggal);
        setDate = findViewById(R.id.out_iv_tanggal);
        etName = findViewById(R.id.out_et_nama);
        etTotal = findViewById(R.id.out_et_jumlah);
        etDesc =  findViewById(R.id.out_et_deskripsi);
        btSimpan = findViewById(R.id.out_bt_simpan);


        //menampilkan tanggal saat klik out_iv_tanggal
        setDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int date = calendar.get(Calendar.DATE);

                DatePickerDialog dialog = new DatePickerDialog(OutActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, mOnDateSetListener,
                        year, month, date);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });
        mOnDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String sDate = dayOfMonth + "/" + month + "/" + year;
                etDate.setText(sDate);


            }
        };


        btSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSimpan();
            }
        });
    }

    void buttonSimpan() {
        String name = etName.getText().toString();
        String total = etTotal.getText().toString();
        String date = etDate.getText().toString();
        String desc = etDesc.getText().toString();


        if (!name.isEmpty() && !total.isEmpty() && !date.isEmpty()) {
            pengeluaran = new PengeluaranDB();
            pengeluaran.setNama(name);
            pengeluaran.setTanggal(date);
            pengeluaran.setJumlah(total);
            pengeluaran.setDeskripsi(desc);

            db.CatPengeluaranDao().insertAll(pengeluaran);

            Intent intent = new Intent(OutActivity.this, DetailsActivity.class);
            startActivity(intent);


        } else {
            Toast.makeText(this, "Data belum diisi semua!", Toast.LENGTH_SHORT).show();

        }
    }

}
