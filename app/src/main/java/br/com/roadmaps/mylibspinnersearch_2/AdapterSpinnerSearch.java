package br.com.roadmaps.mylibspinnersearch_2;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rodd on 03/08/2020.
 */


public class AdapterSpinnerSearch extends RecyclerView.Adapter<AdapterSpinnerSearch.ViewHolder> implements Filterable{

    private List<String> listOrigi;
    private List<String> listFiltered;
    private Context context;
    private LayoutInflater inflater;
    private float sizeFontItem;
    private int colorItem;
    private Typeface typefaceItem;
    private ItemFilter mFilter = new ItemFilter();
    private OnItemClickSpinnerSearch listener;



    public AdapterSpinnerSearch(List<String> listOrigi, Context context) {
        this.listOrigi = listOrigi;
        this.listFiltered = listOrigi;
        this.context = context;
        this.sizeFontItem = 13f;
        colorItem = Color.BLACK;
        typefaceItem = Typeface.DEFAULT;
        this.inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.adapter_spinner_search, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final String item = listFiltered.get(position);
        holder.myTextView.setText(item);
        holder.myTextView.setTypeface(typefaceItem);
        holder.myTextView.setTextSize(sizeFontItem);
        holder.myTextView.setTextColor(colorItem);
        holder.myTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null){
                    listener.onItemClickSpinner(item, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (listFiltered != null) {
            return listFiltered.size();
        } else {
            return 0;
        }
    }


    public void setSizeFontItem(float size){
        sizeFontItem = size;
    }
    public void setColorItem(int color){
        colorItem = color;
    }
    public void setTypefaceItem(Typeface type){
        typefaceItem = type;
    }
    public void setListener(OnItemClickSpinnerSearch listener){
        this.listener = listener;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView myTextView;
        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.txtItem);
        }
    }


    @Override
    public ItemFilter getFilter() {
        return mFilter;
    }

    public class ItemFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String filterString = constraint.toString().toLowerCase();
            FilterResults results = new FilterResults();
            final List<String> list = listOrigi;
            int count = list.size();
            List<String> eventos = new ArrayList<>();
            String n;

            for (int i = 0; i < count; i++) {
                String item = list.get(i);
                n = item;
                if (item.toLowerCase().contains(filterString) || item.toLowerCase().contains(filterString)) {
                    eventos.add(n);
                }
            }
            results.values = eventos;
            results.count = eventos.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            listFiltered = (ArrayList<String>) results.values;
            notifyDataSetChanged();
        }
    }
}