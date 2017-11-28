package com.kevinschildhorn.colordynamo;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

/**
 * Created by Kevin Schildhorn on 11/21/17.
 */

public class CDActivity extends AppCompatActivity {

    @Override
    protected void onResume(){
        super.onResume();

        repaintActivity();
    }

    public void setStyleDefaultDark(){
        CDColors.getInstance(this).setStyleDefaultDark();
        repaintActivity();
    }

    public void setStyleDefaultLight(){
        CDColors.getInstance(this).setStyleDefaultLight();
        repaintActivity();
    }

    public void animateStyleDefaultDark(int duration){
        CDColors.getInstance(this).setStyleDefaultDark();
        repaintActivityAnimated(duration);
    }

    public void animateStyleDefaultLight(int duration){
        CDColors.getInstance(this).setStyleDefaultLight();
        repaintActivityAnimated(duration);
    }

    public void setStyleRes(int primRes, int secRes, int accRes, int primTextRes, int secTextRes){
        CDColors.getInstance(this).setStyleRes(primRes,secRes,accRes,primTextRes,secTextRes);
        repaintActivity();
    }

    public void setStyle(int prim, int sec,int acc, int primText, int secText){
        CDColors.getInstance(this).setStyle(prim,sec,acc,primText,secText);
        repaintActivity();
    }

    public void repaintActivity(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(CDColors.getInstance(this).getNavBarColor());
            getWindow().setNavigationBarColor(CDColors.getInstance(this).getNavBarColor());
        }
        ViewGroup vg = getWindow().getDecorView().findViewById(android.R.id.content);
        vg.setBackgroundColor(CDColors.getInstance(null).getSecondaryColor());
        CDPainter.repaintViewGroup(vg,0);
    }

    public void repaintActivityAnimated(int duration){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(CDColors.getInstance(this).getNavBarColor());
            getWindow().setNavigationBarColor(CDColors.getInstance(this).getNavBarColor());
        }
        ViewGroup vg = getWindow().getDecorView().findViewById(android.R.id.content);

        // TODO
        CDAnimator.animateBackgroundColor(vg,duration,CDColors.getInstance(null).getSecondaryColorOld(),CDColors.getInstance(null).getSecondaryColor());

        CDPainter.repaintViewGroup(vg,duration);
    }
}
