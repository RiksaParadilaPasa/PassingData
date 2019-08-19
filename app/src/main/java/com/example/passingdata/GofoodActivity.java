package com.example.passingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GofoodActivity extends AppCompatActivity {

    EditText iPesan;
    EditText iNama;
    EditText iAlamat;
    Button order;

    String nama, alamat, pesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gofood);

        iPesan = (EditText)findViewById(R.id.food_pesan);
        iAlamat = (EditText)findViewById(R.id.food_alamat);
        iNama = (EditText)findViewById(R.id.food_nama);
        order =(Button)findViewById(R.id.btn_order);




        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = iNama.getText().toString();
                alamat = iAlamat.getText().toString();
                pesan = iPesan.getText().toString();

                if (nama.isEmpty()){
                    iNama.setError("Nama harus diisi");
                    iNama.requestFocus();
                    return;
                }

                if (alamat.isEmpty()){
                    iAlamat.setError("Alamat harus diisi");
                    iAlamat.requestFocus();
                    return;
                }

                if (pesan.isEmpty()){
                    iPesan.setError("Nama harus diisi");
                    iPesan.requestFocus();
                    return;
                }

                Intent OFood = new Intent(GofoodActivity.this,OrderFoodActivity.class);
                OFood.putExtra("knama",nama);
                OFood.putExtra("kalamat",alamat);
                OFood.putExtra("kpesan",pesan);
                startActivity(OFood);
            }
        });




    }
}
