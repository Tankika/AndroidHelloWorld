package com.example.perlakitamas.helloworld;

import android.support.v7.widget.RecyclerView;

public class DetailsPresenter {

    private DetailsScreen screen;
    private static DetailsPresenter instance;

    private DetailsPresenter() {
        instance = null;
    }

    public static DetailsPresenter getInstance(String city) {
        if(instance == null) {
            instance = new DetailsPresenter();
        }
        return instance;
    }

    public void attachView(DetailsScreen screen) {
        this.screen = screen;
    }

    public void detachView() {
        this.screen = null;
    }
}
