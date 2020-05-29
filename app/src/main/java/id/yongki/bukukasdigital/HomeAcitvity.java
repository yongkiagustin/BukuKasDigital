package id.yongki.bukukasdigital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.anychart.core.stock.series.Stick;

import java.util.ArrayList;
import java.util.List;

import id.yongki.bukukasdigital.pengeluaran.PengeluaranDB;

public class HomeAcitvity extends AppCompatActivity {
    List<PengeluaranDB> listPengeluaran = new ArrayList<>();
    public static AppDatabase db;

    AnyChartView anyChartView;
//    String[] month = {"jan", "feb", "mar"};
//    int[] earning = {500, 2000, 1800};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_acitvity);
        anyChartView = findViewById(R.id.home_acv_chart);
        setupChart();
    }
// TODO FIX CHART
    public void setupChart() {
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class,"pengeluaran").allowMainThreadQueries().build();
        listPengeluaran = db.CatPengeluaranDao().getAll();
        for (int i = 0 ;i <listPengeluaran.size();i++){
            String nama = listPengeluaran.get(i).getNama()+i;
            String jumlah = listPengeluaran.get(i).getJumlah()+i;
            String tanggal = listPengeluaran.get(i).getTanggal()+i;
        }

        Pie pie = AnyChart.pie();
//        List<DataEntry> dataEntries = new ArrayList<>();
        for (int i = 0; i < month.length; i++) {
            dataEntries.add(new ValueDataEntry(month[i], earning[i]));
        }
        pie.data(dataEntries);
        anyChartView.setChart(pie);

    }
}
