package com.lhyla.p23databinding;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.MyViewHolder> {

    public List<Country> countryList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView countryName;
        public TextView countryCapitalCity;

        public MyViewHolder(View view) {
            super(view);
            countryName = (TextView) view.findViewById(R.id.country_name_text_view);
            countryCapitalCity = (TextView) view.findViewById(R.id.country_capital_city_text_view);
        }
    }

    public CountryAdapter(List<Country> countryList) {
        this.countryList = countryList;
    }

    @Override
    public void onBindViewHolder(CountryAdapter.MyViewHolder holder, int position) {
        Country c = countryList.get(position);
        holder.countryName.setText(c.getName());
        holder.countryCapitalCity.setText(c.getCapitalCity());
    }


    @Override
    public CountryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.country,parent,false);
        return new MyViewHolder(v);
    }


    @Override
    public int getItemCount() {
        return countryList.size();
    }
}
