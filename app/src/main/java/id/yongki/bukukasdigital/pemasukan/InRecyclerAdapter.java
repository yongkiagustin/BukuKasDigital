package id.yongki.bukukasdigital.pemasukan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import id.yongki.bukukasdigital.R;

public class InRecyclerAdapter extends RecyclerView.Adapter<InRecyclerAdapter.MyViewHolder> {

    private Context mContext;
    private List<PemasukanDB> pemasukanList;
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
    public InRecyclerAdapter(Context mContext, List<PemasukanDB> albumList) {
        this.mContext = mContext;
        this.pemasukanList = albumList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_layout, parent, false);

        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final PemasukanDB album = pemasukanList.get(position);
        holder.nama.setText(album.getNama());
        holder.jumlah.setText(album.getJumlah());
        holder.tanggal.setText(album.getTanggal());
        holder.deskripsi.setText(album.getDeskripsi());
    }
    @Override
    public int getItemCount() {
        return pemasukanList.size();
    }
}

