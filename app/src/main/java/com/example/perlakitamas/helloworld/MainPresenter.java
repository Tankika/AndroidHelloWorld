package com.example.perlakitamas.helloworld;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainPresenter {

    private static MainPresenter instance;

    protected MainScreen screen = null;

    protected RecyclerView.Adapter mainAdapter = null;

    private MainPresenter() {}

    public static MainPresenter getInstance() {
        if(instance == null) {
            instance = new MainPresenter();
        }
        return instance;
    }

    public void attachView(MainScreen screen, RecyclerView.Adapter mainAdapter) {
        this.screen = screen;
        this.mainAdapter = mainAdapter;
    }

    public void detachView() {
        this.screen = null;
        this.mainAdapter = null;
    }
}
