package com.kevinschildhorn.colordynamo;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

/**
 * Created by Kevin Schildhorn on 11/21/17.
 */

public class CDAnimator {


    static public void animateBackgroundColor(final View view, int duration, int colorFrom, int colorTo){
        if(duration != 0) {
            ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
            colorAnimation.setDuration(duration); // milliseconds
            colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                @Override
                public void onAnimationUpdate(ValueAnimator animator) {
                    view.setBackgroundColor((int) animator.getAnimatedValue());
                }

            });
            colorAnimation.start();
        }else{
            view.setBackgroundColor(colorTo);
        }
    }

    static public void animateItemIconTintList(final View view, int duration, int colorFrom, int colorTo){
        if(duration != 0) {
            ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
            colorAnimation.setDuration(duration); // milliseconds
            colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                @Override
                public void onAnimationUpdate(ValueAnimator animator) {
                    if (view instanceof NavigationView) {
                        ((NavigationView) view).setItemIconTintList(ColorStateList.valueOf((int) animator.getAnimatedValue()));
                    } else if (view instanceof BottomNavigationView) {
                        ((BottomNavigationView) view).setItemIconTintList(ColorStateList.valueOf((int) animator.getAnimatedValue()));
                    }

                }

            });
            colorAnimation.start();
        }
        else{
            if (view instanceof NavigationView) {
                ((NavigationView) view).setItemIconTintList(ColorStateList.valueOf(colorTo));
            } else if (view instanceof BottomNavigationView) {
                ((BottomNavigationView) view).setItemIconTintList(ColorStateList.valueOf(colorTo));
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    static public void animateBackgroundTintList(final ImageButton view, int duration, int colorFrom, int colorTo){
        if(duration != 0) {
            ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
            colorAnimation.setDuration(duration); // milliseconds
            colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                @Override
                public void onAnimationUpdate(ValueAnimator animator) {
                    view.setBackgroundTintList(ColorStateList.valueOf((int) animator.getAnimatedValue()));
                }

            });
            colorAnimation.start();
        }
        else{
            view.setBackgroundTintList(ColorStateList.valueOf(colorTo));
        }
    }



    static public void animateItemTextColor(final View view, int duration, int colorFrom, int colorTo){
        if(duration != 0) {
            ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
            colorAnimation.setDuration(duration); // milliseconds
            colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                @Override
                public void onAnimationUpdate(ValueAnimator animator) {
                    if (view instanceof NavigationView) {
                        ((NavigationView) view).setItemTextColor(ColorStateList.valueOf((int) animator.getAnimatedValue()));
                    } else if (view instanceof BottomNavigationView) {
                        ((BottomNavigationView) view).setItemTextColor(ColorStateList.valueOf((int) animator.getAnimatedValue()));
                    }

                }

            });
            colorAnimation.start();
        }
        else{
            if (view instanceof NavigationView) {
                ((NavigationView) view).setItemTextColor(ColorStateList.valueOf(colorTo));
            } else if (view instanceof BottomNavigationView) {
                ((BottomNavigationView) view).setItemTextColor(ColorStateList.valueOf(colorTo));
            }
        }
    }

    static public void animateTitleTextColor(final View view, int duration, int colorFrom, int colorTo){
        if(duration != 0) {
            ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
            colorAnimation.setDuration(duration); // milliseconds
            colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                @Override
                public void onAnimationUpdate(ValueAnimator animator) {
                    ((android.support.v7.widget.Toolbar)view).setTitleTextColor((int) animator.getAnimatedValue());

                }

            });
            colorAnimation.start();
        }
        else{
            ((android.support.v7.widget.Toolbar)view).setTitleTextColor(colorTo);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    static public void animateButtonTintList(final CompoundButton view, int duration, int colorFrom, int colorTo){
        if(duration != 0) {
            ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
            colorAnimation.setDuration(duration); // milliseconds
            colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                @Override
                public void onAnimationUpdate(ValueAnimator animator) {
                    view.setButtonTintList(ColorStateList.valueOf((int) animator.getAnimatedValue()));
                }

            });
            colorAnimation.start();
        }
        else{
            view.setButtonTintList(ColorStateList.valueOf(colorTo));
        }
    }


    static public void animateTextColor(final TextView view, int duration, int colorFrom, int colorTo){
        if(duration != 0) {
            ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
            colorAnimation.setDuration(duration); // milliseconds
            colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                @Override
                public void onAnimationUpdate(ValueAnimator animator) {
                    view.setTextColor((Integer) animator.getAnimatedValue());
                }

            });
            colorAnimation.start();
        }
        else{
            view.setTextColor(colorTo);
        }
    }

    static public void animateColorFilter(final Drawable view, int duration, int colorFrom, int colorTo){
        if(duration != 0) {
            ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
            colorAnimation.setDuration(duration); // milliseconds
            colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                @Override
                public void onAnimationUpdate(ValueAnimator animator) {
                    view.setColorFilter((Integer) animator.getAnimatedValue(), PorterDuff.Mode.MULTIPLY);
                }

            });
            colorAnimation.start();
        }
        else{
            view.setColorFilter(colorTo, PorterDuff.Mode.MULTIPLY);
        }
    }

    static public void animateColorFilter(final ImageButton view, int duration, int colorFrom, int colorTo){
        if(duration != 0) {
            ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
            colorAnimation.setDuration(duration); // milliseconds
            colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                @Override
                public void onAnimationUpdate(ValueAnimator animator) {
                    view.setColorFilter(new PorterDuffColorFilter((Integer) animator.getAnimatedValue(), PorterDuff.Mode.MULTIPLY));
                }

            });
            colorAnimation.start();
        }
        else{
            view.setColorFilter(new PorterDuffColorFilter(colorTo, PorterDuff.Mode.MULTIPLY));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    static public void animateTint(final Drawable view, int duration, int colorFrom, int colorTo){
        if(duration != 0) {
            ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
            colorAnimation.setDuration(duration); // milliseconds
            colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                @Override
                public void onAnimationUpdate(ValueAnimator animator) {
                    view.setTint((Integer) animator.getAnimatedValue());
                }

            });
            colorAnimation.start();
        }
        else{
            view.setTint(colorTo);
        }
    }

}
