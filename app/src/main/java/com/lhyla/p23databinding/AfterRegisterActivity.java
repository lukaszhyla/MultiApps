package com.lhyla.p23databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.lhyla.p23databinding.databinding.ActivityAfterRegisterBinding;

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

        ActivityAfterRegisterBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_after_register);

        User user = (User) getIntent().getSerializableExtra("extraUser");


        binding.setUser(user);


    }
}
