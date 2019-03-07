package com.example.recyclerviewadapter;

import android.graphics.Bitmap;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.LoginFilter;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG= "MainActivity";

    //Listas
    ArrayList<String> mNombres = new ArrayList<>();
    ArrayList<String> mImagenes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate started" );

        inicializarDatos();

    }

    public void inicializarDatos()
    {
        Log.d(TAG, "onInicializarDatos: started");

        mImagenes.add("http://goo.gl/gEgYUd");
        mNombres.add("Primera");

        mImagenes.add("http://goo.gl/gEgYUd");
        mNombres.add("Segunda");

        mImagenes.add("https://www.android.com/static/2016/img/share/andy-lg.png");
        mNombres.add("Tercera");

        inintRecycleView();


    }

    private void inintRecycleView()
    {
        RecyclerView recyclerView = findViewById(R.id.recycle_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNombres, mImagenes);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}
