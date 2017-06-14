package com.lhyla.p23databinding;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SimpleListViewActivity extends AppCompatActivity {


    @BindView(R.id.listView)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list_view);
        ButterKnife.bind(this);

        String[] panstwa = {"Polska", "Francja", "Włochy", "Szkocja", "Szwecja", "Rosja", "Czechy", "Usa", "Australia", "Belgia", "Irlandia", "Portugalia", "Hiszpania", "Anglia", "Brazylia", "Argentyna"};

        ArrayList<String> panstwaL = new ArrayList<String>();
        panstwaL.addAll(Arrays.asList(panstwa));

        // ustawaimy wlasny adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.row, panstwaL);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // odnosze sie do kontrolki Textview w moim R.layout.row
                TextView selectedTextView = ((TextView) view.findViewById(R.id.mojTextView));
                selectedTextView.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.accent));

                // pobieram wartosc tekstowa kliknietego elemenut za pomoca getItemAtPosition
                String tekst = (String) parent.getItemAtPosition(position);

                Toast.makeText(getApplicationContext(), tekst, Toast.LENGTH_SHORT).show();


            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String tekst = (String) parent.getItemAtPosition(position);
                tekst = "Long: " + tekst;
                Toast.makeText(getApplicationContext(), tekst, Toast.LENGTH_SHORT).show();


                return false;
            }
        });
    }
}