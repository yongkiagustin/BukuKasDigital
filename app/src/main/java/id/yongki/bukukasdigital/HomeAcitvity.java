package id.yongki.bukukasdigital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import id.yongki.bukukasdigital.pemasukan.InActivity;
import id.yongki.bukukasdigital.pengeluaran.OutActivity;

public class HomeAcitvity extends AppCompatActivity {
    private Button btListPengeluaran;
    private Button btListPemasukan;

    AnyChartView anyChartView;
    String[] month = {"jan", "feb", "mar"};
    int[] earning = {500, 2000, 1800};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_acitvity);

        anyChartView = findViewById(R.id.home_acv_chart);
        btListPemasukan = findViewById(R.id.home_bt_pemasukan);
        btListPengeluaran = findViewById(R.id.home_bt_pengeluaran);

        setupChart();

        btListPemasukan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toPemasukan();
            }
        });

        btListPengeluaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toPengeluaran();
            }
        });
    }
    public void toPemasukan(){
        Intent intent = new Intent(HomeAcitvity.this, InActivity.class);
        startActivity(intent);
    }
    public void toPengeluaran(){
        Intent intent = new Intent(HomeAcitvity.this, OutActivity.class);
        startActivity(intent);
    }


// TODO FIX CHART
    public void setupChart() {

        }

        Pie pie = AnyChart.pie();
        List<DataEntry> dataEntries = new ArrayList<>();
        for (int i = 0; i < month.length; i++) {
            dataEntries.add(new ValueDataEntry(month[i], earning[i]));
        }
        pie.data(dataEntries);
        anyChartView.setChart(pie);

    }
}
