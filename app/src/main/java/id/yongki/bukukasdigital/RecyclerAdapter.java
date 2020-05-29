package id.yongki.bukukasdigital;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private Context mContext;
    private List<PengeluaranDB> pengeluaranList;
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nama,jumlah,tanggal,deskripsi;
        public MyViewHolder(View v) {
            super(v);

            nama = (TextView)v.findViewById(R.id.tvnama);
            jumlah = (TextView)v.findViewById(R.id.tvjumlah);
            tanggal = (TextView)v.findViewById(R.id.tvtanggal);
            deskripsi = (TextView)v.findViewById(R.id.tvdeskripsi);
        }
    }
    public RecyclerAdapter(Context mContext, List<PengeluaranDB> albumList) {
        this.mContext = mContext;
        this.pengeluaranList = albumList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_layout, parent, false);

        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final PengeluaranDB album = pengeluaranList.get(position);
        holder.nama.setText(album.getNama());
        holder.jumlah.setText(album.getJumlah());
        holder.tanggal.setText(album.getTanggal());
        holder.deskripsi.setText(album.getDeskripsi());
    }
    @Override
    public int getItemCount() {
        return pengeluaranList.size();
    }
}

