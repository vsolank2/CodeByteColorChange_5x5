package com.codebyte.codebytecolorchange;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.codebyte.codebytecolorchange.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
        ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(binding.etNo.getText().toString())>1 && Integer.parseInt(binding.etNo.getText().toString())<21){
                    Intent intent= new Intent(MainActivity.this,MyGridActivity.class);
                    intent.putExtra("MyNo",Integer.parseInt(binding.etNo.getText().toString()));
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "Enter Value between 1 to 21.", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        binding.etNo.setText("");
    }
}