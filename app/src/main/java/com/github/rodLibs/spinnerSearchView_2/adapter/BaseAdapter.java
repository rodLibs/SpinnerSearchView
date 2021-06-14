package com.github.rodLibs.spinnerSearchView_2.adapter;

import android.widget.Filterable;
import androidx.recyclerview.widget.RecyclerView;

import com.github.rodLibs.spinnerSearchView_2.listener.OnItemClickSpinnerSearch;


/**
 * @BaseAdapter abstract class, which will be used to be extended in the creation of
 * customized adapters, which will be used in the component.
 *
 * This class extends the RecyclerView.Adapter by typing the custom ViewHolder called BaseViewHolder.
 * Implements the Filterable interface for filtering the adapter.
 * It declares an abstract method to set the click listerner inside the adapter.
 */
public abstract class BaseAdapter extends RecyclerView.Adapter<BaseViewHolder> implements Filterable {
    public abstract void setListener(OnItemClickSpinnerSearch listener);
}
