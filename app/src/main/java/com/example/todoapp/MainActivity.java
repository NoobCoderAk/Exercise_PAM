package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Deklarasi variable komponen
    Button btnLogin;
    EditText ednama, edpassword;
    TextView edregister;

    //Deklarasi variable untk menyimpan nama dan password
    String nama, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variable dengan komponen yang ada pada layout
        btnLogin=findViewById(R.id.button);
        ednama=findViewById(R.id.etnama);
        edpassword=findViewById(R.id.etpassword);
        edregister=findViewById(R.id.textView5);


        //jika mengklik kata Register
        edregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //membuat objek intent berpindah activity ke Activity Register
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);
            }
        });


        //membuat pemberitahuan kalau nama tidak boleh kosong
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //menyimpan inputan di edittext ednama ke dalam variable nama
                nama = ednama.getText().toString();
                password = edpassword.getText().toString();


                //Mengset data yang benar
                String user= "abi";
                String pass = "123";


                //jika data sesuai
                if (nama.equals(user) && password.equals(pass)){

                    //membuat objek bundle
                    Bundle bundle = new Bundle();

                    //masukkan value dari variable nama dengan kunci "nama"
                    //dan dimasukan kedalam bundle
                    bundle.putString("nama", nama.trim());

                    //membuat objek intent berpindah activity ke ActivityTodo
                    Intent intent = new Intent(getApplicationContext(), TodoActivity.class);

                    //memasukkan bundle kedalam intent untuk dikirim ke ActivityTodo
                    intent.putExtras(bundle);
                    startActivity(intent);

                    Toast.makeText(getApplicationContext(), "Login Behasil", Toast.LENGTH_SHORT).show();
                }

                //jika semua data kosng
                else if(nama.isEmpty() && password.isEmpty()) {
                    //jika form nama belum di isi / masih kosong
                    ednama.setError("nama diperlukan");
                    edpassword.setError("");
                }

                //jika nama kosong
                else if (nama.isEmpty() && password.equals(pass)){
                    ednama.setError("nama diperlukan");
                }

                //jika password kosong
                else if (password.isEmpty() && nama.equals(user)){
                    edpassword.setError("password diperlukan");
                }

                //jika  input nama salah
                else if (nama != user && password.equals(pass)){
                    Toast t = Toast.makeText(getApplicationContext(), "Nama Salah", Toast.LENGTH_SHORT);
                    t.show();
                }

                //jika  password salah
                else if (nama.equals(user) && password != pass){
                    Toast t = Toast.makeText(getApplicationContext(), "Password Salah", Toast.LENGTH_SHORT);
                    t.show();
                }
            }
        });
    }


}