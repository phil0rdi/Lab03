package com.example.philippe.lab08;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ChoisirUnite extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener{


    private static final int[] noms = {R.string.cm, R.string.mm, R.string.dm, R.string.m, R.string.po};
    private static final int[] bananes = {R.string.cmB, R.string.mmB, R.string.dmB, R.string.mB, R.string.poB};

    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choisir_unite);

        ArrayList<Unite> listeUnites = new ArrayList();
        for (int i = 0; i < 5; i++) {
            listeUnites.add(new Unite(getResources().getString(noms[i]), getResources().getString(bananes[i])));
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleur);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, listeUnites);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        intent.putExtra("nbBananes",adapter.getNbBananes(position));
        intent.putExtra("unites", adapter.getUnites(position));
        view.getContext().startActivity(intent);
    }
}
