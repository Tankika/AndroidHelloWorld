package com.example.perlakitamas.helloworld;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainPresenter {

    private static MainPresenter instance;

    protected MainScreen screen;

    protected RecyclerView.Adapter mainAdapter;

    private MainPresenter() {
        screen = null;
        instance = null;
    }

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
