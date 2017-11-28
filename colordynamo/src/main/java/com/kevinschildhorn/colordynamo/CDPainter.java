package com.kevinschildhorn.colordynamo;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.support.design.internal.BaselineLayout;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsSeekBar;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.Toolbar;

import java.nio.channels.Selector;
import java.util.HashMap;

/**
 * Created by Kevin Schildhorn on 11/21/17.
 */

public class CDPainter {


    static void repaintViewGroup(ViewGroup vg, int duration){
        for (int i = 0; i < vg.getChildCount(); i++) {
            View v = vg.getChildAt(i);
            if(v instanceof ViewGroup){
                repaintViewGroup((ViewGroup) v,duration);
            }

            // Toolbar
            if( v instanceof android.support.v7.widget.Toolbar){
                android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) v;
                //toolbar.setBackgroundColor(CDColors.getInstance(null).getPrimaryColor());
                CDAnimator.animateBackgroundColor(toolbar,duration,CDColors.getInstance(null).getPrimaryColorOld(),CDColors.getInstance(null).getPrimaryColor());

                //toolbar.getOverflowIcon().setTint(CDColors.getInstance(null).getNavButtonColor());
                CDAnimator.animateTint(toolbar.getOverflowIcon(),duration,CDColors.getInstance(null).getNavButtonColorOld(),CDColors.getInstance(null).getNavButtonColor());

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    //toolbar.setTitleTextColor(CDColors.getInstance(null).getPrimaryTextColor());
                    CDAnimator.animateTitleTextColor(toolbar,duration,CDColors.getInstance(null).getPrimaryTextColorOld(),CDColors.getInstance(null).getPrimaryTextColor());
                }

                for (int j = 0; j < toolbar.getChildCount(); j++) {
                    final View v2 = toolbar.getChildAt(j);

                    if (v2 instanceof ImageButton) {
                        //((ImageButton) v2).setColorFilter(new PorterDuffColorFilter(CDColors.getInstance(null).getNavButtonColor(), PorterDuff.Mode.SRC_ATOP));
                        CDAnimator.animateColorFilter(((ImageButton) v2),duration,CDColors.getInstance(null).getNavButtonColorOld(),CDColors.getInstance(null).getNavButtonColor());
                    }
                }

            }

            // Navigation
            else if(v instanceof BottomNavigationView){
                BottomNavigationView navView = (BottomNavigationView) v;
                //v.setBackgroundColor(CDColors.getInstance(null).getPrimaryColor());
                CDAnimator.animateBackgroundColor(v,duration,CDColors.getInstance(null).getPrimaryColorOld(),CDColors.getInstance(null).getPrimaryColor());
                //navView.setItemIconTintList(ColorStateList.valueOf(CDColors.getInstance(null).getNavButtonColor()));
                CDAnimator.animateItemIconTintList(navView,duration,CDColors.getInstance(null).getNavButtonColorOld(),CDColors.getInstance(null).getNavButtonColor());
                //navView.setItemTextColor(ColorStateList.valueOf(CDColors.getInstance(null).getSecondaryTextColor()));
                CDAnimator.animateItemTextColor(navView,duration,CDColors.getInstance(null).getSecondaryTextColorOld(),CDColors.getInstance(null).getSecondaryTextColor());
            }
            else if(v instanceof NavigationView){
                NavigationView navView = (NavigationView) v;
                //navView.setBackgroundColor(CDColors.getInstance(null).getSecondaryColor());
                CDAnimator.animateBackgroundColor(navView,duration,CDColors.getInstance(null).getSecondaryColorOld(),CDColors.getInstance(null).getSecondaryColor());
                //navView.setItemIconTintList(ColorStateList.valueOf(CDColors.getInstance(null).getNavButtonColor()));
                CDAnimator.animateItemIconTintList(navView,duration,CDColors.getInstance(null).getNavButtonColorOld(),CDColors.getInstance(null).getNavButtonColor());
                //navView.setItemTextColor(ColorStateList.valueOf(CDColors.getInstance(null).getSecondaryTextColor()));
                CDAnimator.animateItemTextColor(navView,duration,CDColors.getInstance(null).getSecondaryTextColorOld(),CDColors.getInstance(null).getSecondaryTextColor());
            }

            // Button
            else if(v instanceof Switch){
                Switch swtch = (Switch) v;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    //swtch.setButtonTintList(ColorStateList.valueOf(CDColors.getInstance(null).getButtonColor()));
                    CDAnimator.animateButtonTintList(swtch,duration,CDColors.getInstance(null).getButtonColorOld(),CDColors.getInstance(null).getButtonColor());
                    //swtch.setTextColor(CDColors.getInstance(null).getPrimaryTextColor());
                    CDAnimator.animateTextColor(swtch,duration,CDColors.getInstance(null).getPrimaryTextColorOld(),CDColors.getInstance(null).getPrimaryTextColor());
                    //swtch.getThumbDrawable().setColorFilter(CDColors.getInstance(null).getSelectedColor(), PorterDuff.Mode.MULTIPLY);
                    CDAnimator.animateColorFilter(swtch.getThumbDrawable(),duration,CDColors.getInstance(null).getSelectedColorOld(),CDColors.getInstance(null).getSelectedColor());
                    //swtch.getTrackDrawable().setColorFilter(CDColors.getInstance(null).getSelectedColor(), PorterDuff.Mode.MULTIPLY);
                    CDAnimator.animateColorFilter(swtch.getTrackDrawable(),duration,CDColors.getInstance(null).getSelectedColorOld(),CDColors.getInstance(null).getSelectedColor());
                }
            }
            else if(v instanceof ToggleButton){
                ToggleButton toggle = (ToggleButton) v;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    //toggle.setButtonTintList(ColorStateList.valueOf(CDColors.getInstance(null).getButtonColor()));
                    CDAnimator.animateButtonTintList(toggle,duration,CDColors.getInstance(null).getButtonColorOld(),CDColors.getInstance(null).getButtonColor());
                    //toggle.setTextColor(CDColors.getInstance(null).getButtonTextColor());
                    CDAnimator.animateTextColor(toggle,duration,CDColors.getInstance(null).getButtonTextColorOld(),CDColors.getInstance(null).getButtonTextColor());
                    toggle.setBackgroundDrawable(makeToggleButtonSelector());
                }
            }
            else if(v instanceof CompoundButton){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    //((CompoundButton)v).setButtonTintList(ColorStateList.valueOf(CDColors.getInstance(null).getSelectedColor()));
                    CDAnimator.animateButtonTintList(((CompoundButton)v),duration,CDColors.getInstance(null).getSelectedColorOld(),CDColors.getInstance(null).getSelectedColor());
                    //((Button) v).setTextColor(CDColors.getInstance(null).getSecondaryTextColor());
                    CDAnimator.animateTextColor(((Button) v),duration,CDColors.getInstance(null).getSecondaryTextColorOld(),CDColors.getInstance(null).getSecondaryTextColor());
                }
            }
            else if(v instanceof FloatingActionButton){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    //v.setBackgroundTintList(ColorStateList.valueOf(CDColors.getInstance(null).getAccentColor()));
                    CDAnimator.animateBackgroundTintList((ImageButton) v,duration,CDColors.getInstance(null).getAccentColorOld(),CDColors.getInstance(null).getAccentColor());
                }
            }
            else if(v instanceof Button){
                //v.setBackgroundColor(CDColors.getInstance(null).getButtonColor());
                CDAnimator.animateBackgroundColor(v,duration,CDColors.getInstance(null).getButtonColorOld(),CDColors.getInstance(null).getButtonColor());
                //((Button) v).setTextColor(CDColors.getInstance(null).getButtonTextColor());
                CDAnimator.animateTextColor(((Button) v),duration,CDColors.getInstance(null).getButtonTextColorOld(),CDColors.getInstance(null).getButtonTextColor());
            }

            // Text
            else if(v instanceof AbsSeekBar){
                AbsSeekBar seekBar = (AbsSeekBar) v;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    //seekBar.getProgressDrawable().setColorFilter(CDColors.getInstance(null).getSelectedColor(), PorterDuff.Mode.SRC_IN);
                    CDAnimator.animateColorFilter(seekBar.getProgressDrawable(),duration,CDColors.getInstance(null).getSelectedColorOld(),CDColors.getInstance(null).getSelectedColor());
                    if(seekBar.getThumb() != null) {
                        //seekBar.getThumb().setColorFilter(CDColors.getInstance(null).getSelectedColor(), PorterDuff.Mode.SRC_IN);
                        CDAnimator.animateColorFilter(seekBar.getThumb(),duration,CDColors.getInstance(null).getSelectedColorOld(),CDColors.getInstance(null).getSelectedColor());
                    }
                }
            }
            else if(v instanceof ProgressBar){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    //((ProgressBar)v).getIndeterminateDrawable().setColorFilter(CDColors.getInstance(null).getSelectedColor(), PorterDuff.Mode.MULTIPLY);
                    CDAnimator.animateColorFilter(((ProgressBar)v).getIndeterminateDrawable(),duration,CDColors.getInstance(null).getSelectedColorOld(),CDColors.getInstance(null).getSelectedColor());
                }
            }
            else if(v instanceof TextView){
                v.setBackgroundColor(Color.TRANSPARENT);
                //((TextView) v).setTextColor(CDColors.getInstance(null).getPrimaryTextColor());
                CDAnimator.animateTextColor(((TextView) v),duration,CDColors.getInstance(null).getPrimaryTextColorOld(),CDColors.getInstance(null).getPrimaryTextColor());
            }
            else if(v instanceof ImageView ||
                    v instanceof BaselineLayout){

            }
            else{
            }
        }
    }

    public static StateListDrawable makeToggleButtonSelector() {
        StateListDrawable res = new StateListDrawable();
        res.addState(new int[]{android.R.attr.state_checked}, new ColorDrawable(CDColors.getInstance(null).getSelectedColor()));
        res.addState(new int[]{android.R.attr.state_checked}, new ColorDrawable(CDColors.getInstance(null).getButtonColor()));
        return res;
    }

    public static StateListDrawable makeSwitchSelector() {
        StateListDrawable res = new StateListDrawable();
        res.addState(new int[]{android.R.attr.state_activated}, new ColorDrawable(CDColors.getInstance(null).getPrimaryColor()));
        res.addState(new int[]{-android.R.attr.state_activated}, new ColorDrawable(CDColors.getInstance(null).getPrimaryColor()));
        res.addState(new int[]{}, new ColorDrawable(CDColors.getInstance(null).getSecondaryTextColor())); // this one has to come last
        return res;
    }

}
