package br.com.roadmaps.mylibspinnersearch_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickSpinnerSearch {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            list.add("Item "+i);
        }
        SpinnerSearch spinner = findViewById(R.id.spinnerSearch2);
        spinner.setPopulateRecycleView(list);
        spinner.setOnItemClickSpinner(this);
    }

    @Override
    public void onItemClickSpinner(String iten, int position) {
        Log.i("ITEM", "ACTIVITY  "+iten +"  "+ position);
    }
}
