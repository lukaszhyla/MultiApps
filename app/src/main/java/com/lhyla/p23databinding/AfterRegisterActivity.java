package com.lhyla.p23databinding;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.ButterKnife;


public class AfterRegisterActivity extends AppCompatActivity {
    @BindView(R.id.after_register_act_additional_materials_text_view)
    TextView additionalMaterialsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_register);
        ButterKnife.bind(this);

    }
}
