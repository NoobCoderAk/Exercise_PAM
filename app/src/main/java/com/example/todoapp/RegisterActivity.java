package com.example.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class RegisterActivity extends AppCompatActivity {

    //deklarasi variable komponen
    Button btnReg;
    EditText edtNama, edtEmail, edtPassword, edtRepassword;

    //variable untuk menyimpan data
    String username, email, password, repassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //menghubungkan variable dengan komponen yang ada di layout
        btnReg=findViewById(R.id.reg_btn);
        edtNama=findViewById(R.id.etNama);
        edtEmail=findViewById(R.id.etEmail);
        edtPassword=findViewById(R.id.etPassword);
        edtRepassword=findViewById(R.id.etrePassword);

        //jika mengklik button Register
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //menyimpan inputan edittext ke variable
                username=edtNama.getText().toString();
                email=edtEmail.getText().toString();
                password=edtPassword.getText().toString();
                repassword=edtRepassword.getText().toString();


                //jika nama atau email kosong
                if(username.isEmpty() || email.isEmpty()){
                    edtNama.setError("nama harus di isi");
                    edtEmail.setError("email harus di isi");
                }

                //jika password tidak sama
                else if ( !repassword.matches(password) ){
                    Toast.makeText(RegisterActivity.this, "password salah", Toast.LENGTH_SHORT).show();
                }

                //pindah activity sekaligus register
                else{

                    //membuat objek bundle
                    Bundle bundle = new Bundle();

                    //masukkan value dari variable nama dengan kunci "nama"
                    //dan dimasukan kedalam bundle
                    bundle.putString("nama", username.trim());

                    //pindah activity
                    Intent i = new Intent(getApplicationContext(), TodoActivity.class);
                    startActivity(i);

                    //memasukkan bundle kedalam intent untuk dikirim ke ActivityTodo
                    i.putExtras(bundle);

                    //berpindah ke ActivityTodo
                    startActivity(i);
                }


            }
        });
    }
}
