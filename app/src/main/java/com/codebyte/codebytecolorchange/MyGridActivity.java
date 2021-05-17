package com.codebyte.codebytecolorchange;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.codebyte.codebytecolorchange.databinding.ActivityMyGridBinding;

public class MyGridActivity extends AppCompatActivity implements GridAdapter.OnClickListener {
    ActivityMyGridBinding binding;
    int myNo = 0, listCount = 0, listSize = 0;
    ClsBtnPosition[] clsBtnPositionsArray;
    GridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  setContentView(R.layout.activity_my_grid);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_grid);
        Intent intent = getIntent();
        myNo = intent.getIntExtra("MyNo", 0);
        listCount = (myNo * myNo);
        listSize = listCount - 1;
        binding.rvGrid.setLayoutManager(new GridLayoutManager(MyGridActivity.this, myNo));
        Log.d("Check", "onCreate: listSize " + listSize + " listCount " + listCount + " myNo " + myNo);
        clsBtnPositionsArray = new ClsBtnPosition[listCount];

        for (int i = 0; i < listCount; i++) {
            clsBtnPositionsArray[i] = new ClsBtnPosition(i, R.color.gry, listSize - i, false);
        }
        adapter = new GridAdapter(clsBtnPositionsArray, this, MyGridActivity.this);
        binding.rvGrid.setAdapter(adapter);

    }

    @Override
    public void onClick(ClsBtnPosition btnPosition) {
        if(btnPosition.getPosition() == btnPosition.getOppPosition()){
            clsBtnPositionsArray[btnPosition.position].setColor(R.color.teal_200);
        }else {
            if (btnPosition.getColor() == 2131034205) {
                clsBtnPositionsArray[btnPosition.position].setColor(R.color.red);
                clsBtnPositionsArray[btnPosition.oppPosition].setColor(R.color.green);
            } else if (btnPosition.getColor() == 2131034206) {
                clsBtnPositionsArray[btnPosition.position].setColor(R.color.green);
                clsBtnPositionsArray[btnPosition.oppPosition].setColor(R.color.red);
            } else {
                clsBtnPositionsArray[btnPosition.position].setColor(R.color.green);
                clsBtnPositionsArray[btnPosition.oppPosition].setColor(R.color.red);
            }
        }

        Log.d("Check", "onClick: " + new Gson().toJson(clsBtnPositionsArray));

        adapter.notifyItemChanged(btnPosition.getPosition());
        adapter.notifyItemChanged(btnPosition.getOppPosition());
    }
}