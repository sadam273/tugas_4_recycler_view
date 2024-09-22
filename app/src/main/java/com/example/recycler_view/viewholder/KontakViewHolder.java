package com.example.recycler_view.viewholder;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycler_view.R;

public class KontakViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView _nama;
    TextView _noHp;
    ImageView _foto;
    Context _context;


    public KontakViewHolder(@NonNull View itemView) {
        super(itemView);
        _context = itemView.getContext();
        _nama = itemView.findViewById(R.id.id_txNama);
        _noHp = itemView.findViewById(R.id.id_txNomor);
        _foto = itemView.findViewById(R.id.id_foto);
    }

    @Override
    public void onClick(View view) {
        Uri uri = Uri.parse("tel:" + _noHp.getText().toString());
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        _context.startActivity(intent);

    }

    public TextView get_nama() {
        return _nama;
    }

    public TextView get_noHp() {
        return _noHp;
    }

    public ImageView get_foto() {
        return _foto;
    }

    public Context get_context() {
        return _context;
    }
}