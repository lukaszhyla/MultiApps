package com.lhyla.p23databinding;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountriesActivity extends AppCompatActivity {

    @BindView(R.id.countries_act_countries_list_linear_layout)
    LinearLayout countriesLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);
        ButterKnife.bind(this);

        String[] panstwa = {"Polska", "Francja", "Włochy", "Szkocja", "Szwecja",
                "Rosja", "Czechy", "Usa", "Australia", "Belgia",
                "Irlandia", "Portugalia", "Hiszpania", "Anglia", "Brazylia", "Argentyna"};

        ArrayList<String> panstwaL = new ArrayList<String>();
        panstwaL.addAll(Arrays.asList(panstwa));

        for (int i = 0; i < panstwa.length; i++) {
            TextView textView = new TextView(this);
            textView.setText(panstwa[i]);
            textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            textView.setTextSize(22f);
            countriesLinearLayout.addView(textView);

        }


        // ustawiamy domyslny wyglad listy
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, panstwaL);

        // ustawaimy wlasny adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.country_row, panstwaL);

//        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                // odnosze sie do kontrolki Textview w moim R.layout.row
//                TextView selectedTextView = ((TextView) view.findViewById(R.id.mojTextView));
//                selectedTextView.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.accent));
//
//                // pobieram wartosc tekstowa kliknietego elemenut za pomoca getItemAtPosition
//                String tekst = (String) parent.getItemAtPosition(position);
//
//                Toast.makeText(getApplicationContext(), tekst, Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
