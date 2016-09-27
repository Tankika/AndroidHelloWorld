package com.example.perlakitamas.helloworld;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainScreen {
    private MainPresenter mainPresenter;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.main_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MainAdapter();
        mRecyclerView.setAdapter(mAdapter);

        mainPresenter = MainPresenter.getInstance();
        mainPresenter.attachView(this, mAdapter);

        FloatingActionButton myFab = (FloatingActionButton) findViewById(R.id.myFAB);
        myFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                AddCityDialog addCityDialog = new AddCityDialog();
                addCityDialog.show(fm, "add_city");
            }
        });
    }
}