package com.thawfeeqstudios.sahamedthawfeeq.curvettest;

import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {
    public static Activity mmm;
    private View view;
    private FloatingActionButton ff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        view=(View)Main2Activity.mmm.findViewById(R.id.vv);
        ff = (FloatingActionButton)Main2Activity.mmm.findViewById(R.id.fab);
        view.setVisibility(View.INVISIBLE);
        ff.setX(ff.getX()*2 - getty());
        ff.setY(ff.getY()*2 - getty() +getss());
    }
    private float getty(){
        return (float)getResources().getDimension(R.dimen.mar);
    }
    private int getss(){
        return(int)getResources().getDimension(R.dimen.sts);
    }
}
