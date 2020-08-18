package br.com.roadmaps.mylibspinnersearch_2.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import br.com.roadmaps.mylibspinnersearch_2.R;
import br.com.roadmaps.mylibspinnersearch_2.listener.OnItemClickSpinnerSearch;

/**
 * Created by rodd on 03/08/2020.
 *
 * @Class Default adapter used by the component.
 * Extends the BaseAdapter class.
 */
public class AdapterSpinnerSearch extends BaseAdapter{

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
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.adapter_spinner_search, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, final int position) {
        final String item = listFiltered.get(position);
        if (holder instanceof MyViewHolder){
            holder.bind(item);
        }
    }



    @Override
    public int getItemCount() {
        if (listFiltered != null) {
            return listFiltered.size();
        } else {
            return 0;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void setListener(OnItemClickSpinnerSearch listener) {
        this.listener = listener;
    }



    class MyViewHolder extends BaseViewHolder<String> {
        TextView myTextView;
        MyViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.txtItem);
        }

        @Override
        public void bind(final String item) {
            myTextView.setText(item);
            myTextView.setTypeface(typefaceItem);
            myTextView.setTextSize(sizeFontItem);
            myTextView.setTextColor(colorItem);
            myTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null){
                        listener.onItemClickSpinner(item, getAdapterPosition());
                    }
                }
            });
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