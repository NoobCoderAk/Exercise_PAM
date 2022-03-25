package com.example.todoapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TaskActivity extends AppCompatActivity {

    //deklarasi komponen
    TextView viewtask, viewjenis, viewwaktu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        //Menghubungkan variable dengan componen yang ada pada layout
        viewtask = findViewById(R.id.tvShowTask);
        viewjenis = findViewById(R.id.tvShowJenisTask);
        viewwaktu = findViewById(R.id.tvShowTimeTask);

        //mendeklarasikan variable bundle yang akan digunakan untuk mengambil
        //pesan yang dikirim  melalui metthod intent
        Bundle bundle = getIntent().getExtras();

        //membuat variable string yang digunakan untuk menyimpan data yang
        //dikirimkan dari activity sebelumnya dengan kunci :
        String Vtask = bundle.getString("task");
        String Vjenis = bundle.getString("jenis");
        String Vwaktu = bundle.getString("waktu");


        //menampilkan value dari variable
        viewtask.setText(Vtask);
        viewjenis.setText(Vjenis);
        viewwaktu.setText(Vwaktu);
    }
}
