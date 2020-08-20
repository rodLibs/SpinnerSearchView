package br.com.roadmaps.testespinnersearch2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.TextView
import com.github.rodlibs.mylibspinnersearch_2.R
import com.github.rodlibs.mylibspinnersearch_2.adapter.BaseAdapter
import com.github.rodlibs.mylibspinnersearch_2.adapter.BaseViewHolder
import com.github.rodlibs.mylibspinnersearch_2.listener.OnItemClickSpinnerSearch
import java.util.*


class AdapterCustomized(list: List<String>) : BaseAdapter() {

    var listOrigi = list
    var listFiltered = list
    val mFilter: ItemFilter = ItemFilter()
    var myListener: OnItemClickSpinnerSearch? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.adapter_spinner_search, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val item = listFiltered[position]
        (holder as? MyViewHolder)?.bind(item)
    }

    override fun getItemCount(): Int {
        return listFiltered.size
    }


    override fun setListener(listener: OnItemClickSpinnerSearch?) {
        this.myListener = listener
    }


    inner class MyViewHolder(itemView: View) : BaseViewHolder<String>(itemView) {
        private var myTextView: TextView = itemView.findViewById(R.id.txtItem)

        override fun bind(item: String?) {
            myTextView.text = item
            myTextView.setOnClickListener {
                if (myListener != null) {
                    myListener?.onItemClickSpinner(item, adapterPosition)
                }
            }
        }
    }


    override fun getFilter(): Filter {
       return mFilter
    }




   inner class ItemFilter : Filter() {
        override fun performFiltering(constraint: CharSequence): FilterResults {
            val filterString = constraint.toString().toLowerCase()
            val results = FilterResults()
            val list: List<String> = listOrigi
            val count = list.size
            val eventos: MutableList<String> = ArrayList()
            var n: String
            for (i in 0 until count) {
                val item = list[i]
                n = item
                if (item.toLowerCase().contains(filterString) || item.toLowerCase().contains(filterString)) {
                    eventos.add(n)
                }
            }
            results.values = eventos
            results.count = eventos.size
            return results
        }

        override fun publishResults(constraint: CharSequence, results: FilterResults) {
            listFiltered = results.values as List<String>
            notifyDataSetChanged()
        }
    }
}