package com.example.recycler_view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recycler_view.R;
import com.example.recycler_view.model.Kontak;
import com.example.recycler_view.viewholder.KontakViewHolder;

import java.util.ArrayList;

public class KontakAdapter extends RecyclerView.Adapter<KontakViewHolder> {

    private ArrayList<Kontak> _kontakList;
    private Context _context;


    public KontakAdapter(ArrayList<Kontak> itemList, Context context) {
        this._kontakList = itemList;
        this._context = context;
    }

    @NonNull
    @Override
    public KontakViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        KontakViewHolder vh = new KontakViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull KontakViewHolder holder, int position) {

        holder.get_nama().setText(_kontakList.get(position).getNama());
        Glide.with(holder.get_context()).load(_kontakList.get(position).getFoto()).into(holder.get_foto());
        holder.get_noHp().setText(_kontakList.get(position).getNoHp());

    }

    @Override
    public int getItemCount() {
        return _kontakList.size();
    }
}
