package com.example.perlakitamas.helloworld;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private MainPresenter mainPresenter;

    public MainAdapter(MainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_view_row, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mainPresenter.getCityList().get(position));
    }

    @Override
    public int getItemCount() {
        return mainPresenter.getCityList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;
        public ViewHolder(View v) {
            super(v);

            mTextView = (TextView)v.findViewById(R.id.row_city_name);
            mTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainActivity.startDetailsActivity(((TextView)v).getText().toString());
                }
            });
        }
    }
}
