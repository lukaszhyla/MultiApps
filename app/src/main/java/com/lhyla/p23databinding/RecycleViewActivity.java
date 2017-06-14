package com.lhyla.p23databinding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

public class RecycleViewActivity extends AppCompatActivity {

    private final static String TAG = "LH";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        Log.d(TAG,"RecycleViewAct Started");

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycle_act_recycle_view);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        List<Country> countries = Arrays.asList(
                new Country("Poland", "Warsaw"),
                new Country("Germany", "Berlin"),
                new Country("Russia", "Moscov"),
                new Country("France", "Paris")
        );

        CountryAdapter ca = new CountryAdapter(countries);
        recyclerView.setAdapter(ca);
    }
}
