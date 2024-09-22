package com.example.recycler_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recycler_view.R;
import com.example.recycler_view.adapter.KontakAdapter;
import com.example.recycler_view.model.Kontak;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    KontakAdapter kontakRecyclerAdapter;
    ArrayList<Kontak> _kontakList;
    Button btnAddData;
    EditText etNama, etNomor;
    int[] foto ={R.drawable.avatarr1,R.drawable.avatarr2,R.drawable.avatarr3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        btnAddData = findViewById(R.id.id_btTambahKontak);
        btnAddData.setOnClickListener(this);
        loadData();
        initRecyclerView();

        btnAddData = findViewById(R.id.id_btTambahKontak);
        etNama = findViewById(R.id.id_btNama);
        etNomor = findViewById(R.id.id_btNomor);

        btnAddData.setOnClickListener(this);
        loadData();
        initRecyclerView();

    }


    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.id_rv);
        kontakRecyclerAdapter = new KontakAdapter(_kontakList,this);
        recyclerView.setAdapter(kontakRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    private void addData() {
        //buat masukin data sesuai editText
        String nama = etNama.getText().toString();
        String nomor = etNomor.getText().toString();

        // Validasi input
        if (nama.isEmpty() || nomor.isEmpty()) {
            Toast.makeText(this, "Nama dan Nomor harus diisi", Toast.LENGTH_SHORT).show();
            return;
        }

        // Tambahkan data ke list
        Random rand = new Random();
        int randomFoto = foto[rand.nextInt(foto.length)]; // Random foto dari array
        _kontakList.add(new Kontak(randomFoto, nama, nomor, "email@example.com")); // Tambahkan data

        // Bersihkan EditText setelah data ditambahkan
        etNama.setText("");
        etNomor.setText("");

        // Beri notifikasi bahwa data telah berubah
        kontakRecyclerAdapter.notifyDataSetChanged();
    }


    private void loadData(){


        _kontakList = new ArrayList<>();
        _kontakList.add(new Kontak(foto[0],"Shifa","081234567890","shifa@gmail.com"));
        _kontakList.add(new Kontak(foto[1],"Akbar","085648640046","akbar@gmail.com"));
        _kontakList.add(new Kontak(foto[2],"Budi","085648640047","budi@gmail.com"));

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==btnAddData.getId())
        {
            addData();
            kontakRecyclerAdapter.notifyDataSetChanged();

        }
    }
}