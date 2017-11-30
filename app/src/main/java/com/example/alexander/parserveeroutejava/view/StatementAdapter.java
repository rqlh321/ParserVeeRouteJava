package com.example.alexander.parserveeroutejava.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alexander.parserveeroutejava.R;
import com.example.alexander.parserveeroutejava.model.Statement;

import java.util.ArrayList;
import java.util.List;

class StatementAdapter extends RecyclerView.Adapter<StatementAdapter.ViewHolder> {
    private ArrayList<Statement> list = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.text.setText(list.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    void refresh(List<Statement> elements) {
        list.clear();
        list.addAll(elements);
        notifyDataSetChanged();
    }

    void clear() {
        list.clear();
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        TextView text;

        ViewHolder(View view) {
            super(view);
            mView = view;
            text = view.findViewById(R.id.text);
        }

    }

}