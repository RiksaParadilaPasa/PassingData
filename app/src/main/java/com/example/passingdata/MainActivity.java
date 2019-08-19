package com.example.passingdata;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    ImageButton gosend;
    ImageButton goride;
    ImageButton gofood;
    ImageButton gomart;
    LayoutInflater inflater;
    View dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gofood = (ImageButton)findViewById(R.id.btn_gofood);
        gofood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(MainActivity.this,GofoodActivity.class);
                startActivity(pindah);
            }
        });

        gosend = (ImageButton)findViewById(R.id.btn_gosend);
        gosend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Fitur GOJEK")
                        .setMessage("Maaf Fitur Ini Tidak Tersedia ")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"Yes",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,"No",Toast.LENGTH_SHORT).show();
                            }
                        });
                //Creating dialog box
                AlertDialog dialog  = builder.create();
                dialog.show();
            }
        });

        goride = (ImageButton)findViewById(R.id.btn_goride);
        goride.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Toast.makeText(getApplicationContext(),"Fitur Ini Belum Tersedia",Toast.LENGTH_SHORT).show();
            }
        });

        gomart = (ImageButton)findViewById(R.id.btn_gomart);
        gomart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(findViewById(R.id.main),"Fitur Ini Belum Tersedia" , Snackbar.LENGTH_LONG).show();

            }
        });
    }
}
