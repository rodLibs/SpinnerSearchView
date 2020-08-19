package com.github.rodlibs.mylibspinnersearch_2.adapter;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


/**
 * @BaseViewHolder abstract class, which will be used to be extended in the creation of customized ViewHolders,
 * which will be used in the creation of customized adapters in the component.
 *
 * This class extends the RecyclerView.ViewHolder.
 * It has a generic type, which will be passed to the bind () method.
 *
 * It declares an abstract method called bind (),
 * which will be used to bind the values to the component,
 * inside the viewholder on the adapter.
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    abstract public void bind(T item);
}
