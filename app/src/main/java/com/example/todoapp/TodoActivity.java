package com.example.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


public class TodoActivity extends AppCompatActivity {

    //deklarasi variable komponen
    EditText edTask, edJenisTask, edWaktuTask;
    TextView txnama;
    FloatingActionButton fab;

    //deklarasi variable untuk menyimpan
    String task, jenisTask, waktuTask;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        //Menghubungkan variable dengan componen yang ada pada layout
        txnama = findViewById(R.id.tvNama);

        //mendeklarasikan variable bundle yang akan digunakan untuk mengambil
        //pesan yang dikirim  melalui method intent
        Bundle bundle = getIntent().getExtras();

        //membuat variable string yang digunakan untuk menyimpan data yang
        //dikirimkan dari activity sebelumnya dengan kunci "nama"
        String nama = bundle.getString("nama");

        //menampilkan value dari variable nama kedalam txnama
        txnama.setText(nama);

        //memanggil method submit
        Submit();

    }

    //submit melalui floating action button
    public void Submit(){
        //menghubungkan variable dengan komponen yang ada di layout
        edTask=findViewById(R.id.edtTask);
        edJenisTask=findViewById(R.id.edtJenisTask);
        edWaktuTask=findViewById(R.id.edtTimeTask);
        fab=findViewById(R.id.floatingActionButton);

        //jika mengklik button +
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //menyimpan inputan edittext ke variable
                task=edTask.getText().toString();
                jenisTask=edJenisTask.getText().toString();
                waktuTask=edWaktuTask.getText().toString();

                //membuat alert jika semua data kosong atau tidak terisi
                if(task.isEmpty() && jenisTask.isEmpty() && waktuTask.isEmpty()){

                    //membuat toast jika data semua kosong maka harus di isi
                    Toast.makeText( getApplicationContext(), "Semua data harus diisi !!",Toast.LENGTH_SHORT).show();

                }

                // membuat  alert jika data task kosong atau tidak terisi
                else if(task.isEmpty()){
                    edTask.setError("task harus terisi !!");
                }

                //membuat alert jika data jenis task kosong atau tidak terisi
                else if(jenisTask.isEmpty()){
                    edJenisTask.setError("jenis task harus terisi !!");
                }

                //membuat alert jika data waktu kosong atau tidak terisi
                else if (waktuTask.isEmpty()){
                    edWaktuTask.setError("waktu harus terisi !!");
                }

                //pindah activity
                else{

                    //membuat objek bundle
                    Bundle bun = new Bundle();

                    //masukkan value dari variable nama dengan kunci
                    //dan dimasukan kedalam bundle
                    bun.putString("task", task.trim());
                    bun.putString("jenis", jenisTask.trim());
                    bun.putString("waktu", waktuTask.trim());

                    Toast.makeText(getApplicationContext(), "berhasil", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(),TaskActivity.class);

                    //memasukkan bundle kedalam intent untuk dikirim ke ActivityTask
                    intent.putExtras(bun);

                    startActivity(intent);
                }
            }
        });
    }
    //membuat menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //method utnuk menampilkan menu.
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //jika mengklik menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //membuat kondisi jiks yang dipilih adalah id mnSubmit
        if (item.getItemId()==R.id.mnSubmit){

            //memanggil method submit
            Submit();
        }
        //membuat kondisi jiks yang dipilih adalah id mnLogut
        else if (item.getItemId()==R.id.mnLogout){


            //berpindah activity ke MainActivity
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);

            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
