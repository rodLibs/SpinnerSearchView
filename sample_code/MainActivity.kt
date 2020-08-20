package br.com.roadmaps.testespinnersearch2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.rodlibs.mylibspinnersearch_2.SpinnerSearch
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val list = arrayListOf<String>()
        for (i in 1..20) {
            list.add("item $i")
        }
        val spinner = findViewById<SpinnerSearch>(R.id.spinner)
        spinner.setPopulateRecycleView(list)
        spinner.setPopulateRecycleViewANDSetAdapter(AdapterCustomized(list))
        spinner.setOnItemClickSpinner { item, _ ->
            Log.i("SPINNER", item)
        }
    }
}
