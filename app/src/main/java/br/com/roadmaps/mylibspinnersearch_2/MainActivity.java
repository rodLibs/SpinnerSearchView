package br.com.roadmaps.mylibspinnersearch_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.roadmaps.mylibspinnersearch_2.listener.OnItemClickSpinnerSearch;
import br.com.roadmaps.mylibspinnersearch_2.test.AdapterTest;

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
        spinner.setPopulateRecycleViewANDSetAdapter(new AdapterTest(list, this));
        spinner.setOnItemClickSpinner(this);
    }



    @Override
    public void onItemClickSpinner(String iten, int position) {
        Log.i("ITEM", "ACTIVITY_NEW"+iten +"  "+ position);
    }
}
