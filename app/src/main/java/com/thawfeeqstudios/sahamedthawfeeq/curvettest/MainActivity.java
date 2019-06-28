package com.thawfeeqstudios.sahamedthawfeeq.curvettest;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Path;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewAnimationUtils;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton fab;
    private DisplayMetrics mds;
    private View vv;
    private float mx,my,mfx,mfy,cx1,cy1,cx2,cy2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Main2Activity.mmm = this;
        fab = (FloatingActionButton)findViewById(R.id.fab);
        vv = (View)findViewById(R.id.vv);
        mds = this.getResources().getDisplayMetrics();
        mfx = (mds.widthPixels)/2-(mds.density*28);
        mfy = (mds.heightPixels)/2-(mds.density*28)-(mds.density*24);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curvy();
            }
        });
    }
    private void curvy(){
        Path path = new Path();
        cx1= (fab.getX() - ((mds.widthPixels*3)/8) );
        cy1 = fab.getY();
        cy2= (mfy + 10 );
        cx2=mfx;
        path.moveTo(fab.getX(),fab.getY());
        path.cubicTo(cx1,cy1,cx2,cy2,mfx,mfy);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(fab,View.X,View.Y,path);
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                reveal();

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        objectAnimator.setDuration(500);
        objectAnimator.start();
    }
    private void reveal(){
        int cx =mds.widthPixels/2;
        int cy = (int) (mds.heightPixels/2 -(mds.density*24));
        int sr = 0;
        int fr = (int)Math.hypot(vv.getWidth(),vv.getHeight());
        Animator animator = ViewAnimationUtils.createCircularReveal(vv,cx,cy,sr,fr);
        vv.setVisibility(View.VISIBLE);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                nexty();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        animator.setDuration(350);
        animator.start();
    }
    private void nexty(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        },0);
    }
}
