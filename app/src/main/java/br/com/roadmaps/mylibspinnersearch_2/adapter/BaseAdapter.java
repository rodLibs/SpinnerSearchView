package br.com.roadmaps.mylibspinnersearch_2.adapter;

import android.widget.Filterable;
import androidx.recyclerview.widget.RecyclerView;

import br.com.roadmaps.mylibspinnersearch_2.listener.OnItemClickSpinnerSearch;

//public abstract class BaseAdapter<M extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements Filterable {

public abstract class BaseAdapter extends RecyclerView.Adapter<BaseViewHolder> implements Filterable {
    public abstract void setListener(OnItemClickSpinnerSearch listener);
}
