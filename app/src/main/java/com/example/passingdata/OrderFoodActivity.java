package com.example.passingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class OrderFoodActivity extends AppCompatActivity {
    TextView tvpesan,tvnama,tvalamat;
    Button cancel;
    public boolean status = true;
    int waktu = 2000;
    Timer t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_food);

        tvalamat = (TextView)findViewById(R.id.tv_alamat);
        tvnama = (TextView)findViewById(R.id.tv_nama);
        tvpesan = (TextView)findViewById(R.id.tv_pesan);

        cancel = (Button)findViewById(R.id.btn_cancel);


        String nama = getIntent().getStringExtra("knama");
        String alamat = getIntent().getStringExtra("kalamat");
        String pesan = getIntent().getStringExtra("kpesan");

        tvnama.setText(nama);
        tvalamat.setText(alamat);
        tvpesan.setText(pesan);

        t = new Timer();
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check();
                t.cancel();
                status = false;
            }
        });

    }

    private void check() {
        if (!status){
            Intent order = new Intent(OrderFoodActivity.this,GofoodActivity.class);
            startActivity(order);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                Intent home = new Intent(OrderFoodActivity.this,MainActivity.class);
                startActivity(home);
            }
        };
        t.schedule(tt,waktu);
//       if (!status){
//           Handler veri = new Handler();
//           veri.postDelayed(new Runnable() {
//               @Override
//               public void run() {
//                   while (status) {
//                       Intent home = new Intent(OrderFoodActivity.this,MainActivity.class);
//                       startActivity(home);
//                   }
//               }
//           },waktu);
//       }
//
    }
}
