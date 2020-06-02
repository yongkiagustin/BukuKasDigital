package id.yongki.bukukasdigital.pemasukan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Calendar;

import id.yongki.bukukasdigital.R;

public class InActivity extends AppCompatActivity {
    private DatePickerDialog.OnDateSetListener mOnDateSetListener;
    private EditText Date;
    private ImageView setDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in);
        Date = findViewById(R.id.in_et_tanggal);
        setDate = findViewById(R.id.in_iv_date);
        Date.setEnabled(false);
        Date.setInputType(InputType.TYPE_NULL);
        setDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int date = calendar.get(Calendar.DATE);

                DatePickerDialog dialog = new DatePickerDialog(InActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth, mOnDateSetListener,
                        year, month, date);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });
        mOnDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Date.setText(dayOfMonth + "/" + month + "/" + year);
            }
        };
    }

}
