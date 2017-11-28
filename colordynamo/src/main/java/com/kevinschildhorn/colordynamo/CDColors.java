package com.kevinschildhorn.colordynamo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Kevin Schildhorn on 11/21/17.
 */

public class CDColors {

    public static final String CD_PREFERENCES               = "CD_PREFERENCES";
    public static final String COLOR_PRIMARY                = "COLOR_PRIMARY";
    public static final String COLOR_SECONDARY              = "COLOR_SECONDARY";
    public static final String COLOR_ACCENT                 = "COLOR_ACCENT";
    public static final String TEXT_COLOR_PRIMARY           = "TEXT_COLOR_PRIMARY";
    public static final String TEXT_COLOR_SECONDARY         = "TEXT_COLOR_SECONDARY";
    public static final String NAVBAR_COLOR                 = "NAVBAR_COLOR";
    public static final String NAVBAR_ICONS_COLOR           = "NAVBAR_ICONS_COLOR";
    public static final String BUTTON_COLOR                 = "BUTTON_COLOR";
    public static final String BUTTON_TEXT_COLOR            = "BUTTON_TEXT_COLOR";
    public static final String SELECTED_COLOR               = "SELECTED_COLOR";
    public static final String OLD                          = "_OLD";

    private static CDColors instance = null;
    SharedPreferences mSharedPrefs;
    Context ctx;

    public static CDColors getInstance(Context ctx) {
        if(instance == null){
            instance = new CDColors();
            instance.ctx = ctx;
            instance.mSharedPrefs = ctx.getSharedPreferences(CD_PREFERENCES,Context.MODE_PRIVATE);
            instance.mSharedPrefs.registerOnSharedPreferenceChangeListener(instance.listener);
        }
        return instance;
    }

    SharedPreferences.OnSharedPreferenceChangeListener listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            mSharedPrefs = sharedPreferences;
        }
    };


    void clearSavedColors() {
        SharedPreferences.Editor editor = mSharedPrefs.edit();
        editor.remove(COLOR_PRIMARY);
        editor.remove(COLOR_SECONDARY);
        editor.remove(COLOR_ACCENT);
        editor.remove(TEXT_COLOR_PRIMARY);
        editor.remove(TEXT_COLOR_SECONDARY);
        editor.remove(NAVBAR_COLOR);
        editor.remove(NAVBAR_ICONS_COLOR);
        editor.remove(BUTTON_COLOR);
        editor.remove(BUTTON_TEXT_COLOR);
        editor.remove(SELECTED_COLOR);
        editor.apply();
    }


    /// Styles

    void setStyleDefaultDark(){
        clearSavedColors();
        setStyleRes(R.color.CDDarkThemeColorPrimary,
                    R.color.CDDarkThemeColorSecondary,
                    R.color.CDDarkThemeColorAccent,
                    R.color.CDDarkThemeTextColorPrimary,
                    R.color.CDDarkThemeTextColorSecondary);

    }

    void setStyleDefaultLight(){
        clearSavedColors();
        setStyleRes(R.color.CDLightThemeColorPrimary,
                R.color.CDLightThemeColorSecondary,
                R.color.CDLightThemeColorAccent,
                R.color.CDLightThemeTextColorPrimary,
                R.color.CDLightThemeTextColorSecondary);

    }

    void setStyleRes(int primRes, int secRes, int accRes, int primTextRes, int secTextRes){
        int prim = ContextCompat.getColor(ctx,primRes);
        int sec = ContextCompat.getColor(ctx,secRes);
        int acc = ContextCompat.getColor(ctx,accRes);
        int primText = ContextCompat.getColor(ctx,primTextRes);
        int secText = ContextCompat.getColor(ctx,secTextRes);

        setStyle(prim,sec,acc,primText,secText);
    }

    void setStyle(int prim, int sec, int acc, int primText, int secText){
        setPrimaryColor(prim);
        setSecondaryColor(sec);
        setAccentColor(acc);
        setPrimaryTextColor(primText);
        setSecondaryTextColor(secText);
    }

    public void saveStyle(String name){

        HashMap<String,Integer> colors = new HashMap<String, Integer>();
        colors.put(COLOR_PRIMARY,getPrimaryColor());
        colors.put(COLOR_SECONDARY,getSecondaryColor());
        colors.put(COLOR_ACCENT,getAccentColor());
        colors.put(TEXT_COLOR_PRIMARY,getPrimaryTextColor());
        colors.put(TEXT_COLOR_SECONDARY,getSecondaryTextColor());
        colors.put(NAVBAR_COLOR,getNavBarColor());
        colors.put(NAVBAR_ICONS_COLOR,getNavButtonColor());
        colors.put(BUTTON_COLOR,getButtonColor());
        colors.put(BUTTON_TEXT_COLOR,getButtonTextColor());
        colors.put(SELECTED_COLOR,getSelectedColor());

        Gson gson = new Gson();
        String style = gson.toJson(colors,HashMap.class);

        SharedPreferences.Editor editor = mSharedPrefs.edit();
        editor.putString(name,style);
        editor.apply();
    }

    public boolean loadStyle(String name){

        Gson gson = new Gson();
        String colorsStr = mSharedPrefs.getString(name,"");
        HashMap<String,Double> colors = gson.fromJson(colorsStr,HashMap.class);

        if(colors != null) {
            int prim = colors.get(COLOR_PRIMARY).intValue();
            setPrimaryColor(prim);
            int sec = colors.get(COLOR_SECONDARY).intValue();
            setSecondaryColor(sec);
            int acc = colors.get(COLOR_ACCENT).intValue();
            setAccentColor(acc);
            int textPrim = colors.get(TEXT_COLOR_PRIMARY).intValue();
            setPrimaryTextColor(textPrim);
            int textSec = colors.get(TEXT_COLOR_SECONDARY).intValue();
            setSecondaryTextColor(textSec);
            int nav = colors.get(NAVBAR_COLOR).intValue();
            setNavBarColor(nav);
            int navBut = colors.get(NAVBAR_ICONS_COLOR).intValue();
            setNavButtonColor(navBut);
            int but = colors.get(BUTTON_COLOR).intValue();
            setButtonColor(but);
            int textBut = colors.get(BUTTON_TEXT_COLOR).intValue();
            setButtonTextColor(textBut);
            int sel = colors.get(SELECTED_COLOR).intValue();
            setSelectedColor(sel);

            return true;
        }
        return false;
    }

    public void removeStyle(String name){

        SharedPreferences.Editor editor = mSharedPrefs.edit();
        editor.remove(name);
        editor.apply();
    }

    public void removeAllStyles(){

        HashMap<String,Integer> colors = new HashMap<String, Integer>();
        colors.put(COLOR_PRIMARY,getPrimaryColor());
        colors.put(COLOR_SECONDARY,getSecondaryColor());
        colors.put(COLOR_ACCENT,getAccentColor());
        colors.put(TEXT_COLOR_PRIMARY,getPrimaryTextColor());
        colors.put(TEXT_COLOR_SECONDARY,getSecondaryTextColor());
        colors.put(NAVBAR_COLOR,getNavBarColor());
        colors.put(NAVBAR_ICONS_COLOR,getNavButtonColor());
        colors.put(BUTTON_COLOR,getButtonColor());
        colors.put(BUTTON_TEXT_COLOR,getButtonTextColor());
        colors.put(SELECTED_COLOR,getSelectedColor());

        colors.put(COLOR_PRIMARY + OLD,getPrimaryColorOld());
        colors.put(COLOR_SECONDARY + OLD,getSecondaryColorOld());
        colors.put(COLOR_ACCENT + OLD,getAccentColorOld());
        colors.put(TEXT_COLOR_PRIMARY + OLD,getPrimaryTextColorOld());
        colors.put(TEXT_COLOR_SECONDARY + OLD,getSecondaryTextColorOld());
        colors.put(NAVBAR_COLOR + OLD,getNavBarColorOld());
        colors.put(NAVBAR_ICONS_COLOR + OLD,getNavButtonColorOld());
        colors.put(BUTTON_COLOR + OLD,getButtonColorOld());
        colors.put(BUTTON_TEXT_COLOR + OLD,getButtonTextColorOld());
        colors.put(SELECTED_COLOR + OLD,getSelectedColorOld());

        SharedPreferences.Editor editor = mSharedPrefs.edit();
        editor.clear();

        for(String key : colors.keySet()){
            editor.putInt(key,colors.get(key));
        }

        editor.apply();
    }

    /// Background Colors

    public Integer getPrimaryColor(){
        return mSharedPrefs.getInt(COLOR_PRIMARY,ContextCompat.getColor(ctx,R.color.CDDarkThemeColorPrimary));
    }

    public Integer getPrimaryColorOld(){
        return mSharedPrefs.getInt(COLOR_PRIMARY + OLD,ContextCompat.getColor(ctx,R.color.CDDarkThemeColorPrimary));
    }

    public void setPrimaryColor(Integer prim){
        SharedPreferences.Editor edit = mSharedPrefs.edit();
        edit.putInt(COLOR_PRIMARY + OLD,getPrimaryColor());
        edit.putInt(COLOR_PRIMARY,prim);
        edit.commit();
    }

    public Integer getSecondaryColor(){
        return  mSharedPrefs.getInt(COLOR_SECONDARY,ContextCompat.getColor(ctx,R.color.CDDarkThemeColorSecondary));
    }

    public Integer getSecondaryColorOld(){
        return  mSharedPrefs.getInt(COLOR_SECONDARY + OLD,ContextCompat.getColor(ctx,R.color.CDDarkThemeColorSecondary));
    }

    public void setSecondaryColor(Integer sec){
        SharedPreferences.Editor edit = mSharedPrefs.edit();
        edit.putInt(COLOR_SECONDARY + OLD,getSecondaryColor());
        edit.putInt(COLOR_SECONDARY,sec);
        edit.commit();
    }

    public Integer getAccentColor(){
        return  mSharedPrefs.getInt(COLOR_ACCENT,ContextCompat.getColor(ctx,R.color.CDDarkThemeColorAccent));
    }

    public Integer getAccentColorOld(){
        return  mSharedPrefs.getInt(COLOR_ACCENT + OLD,ContextCompat.getColor(ctx,R.color.CDDarkThemeColorAccent));
    }

    public void setAccentColor(Integer acc){
        SharedPreferences.Editor edit = mSharedPrefs.edit();
        edit.putInt(COLOR_ACCENT + OLD,getAccentColor());
        edit.putInt(COLOR_ACCENT,acc);
        edit.commit();
    }

    /// Text Colors

    public Integer getPrimaryTextColor(){
        return mSharedPrefs.getInt(TEXT_COLOR_PRIMARY,ContextCompat.getColor(ctx,R.color.CDDarkThemeTextColorPrimary));
    }

    public Integer getPrimaryTextColorOld(){
        return mSharedPrefs.getInt(TEXT_COLOR_PRIMARY + OLD,ContextCompat.getColor(ctx,R.color.CDDarkThemeTextColorPrimary));
    }

    public void setPrimaryTextColor(Integer prim){
        SharedPreferences.Editor edit = mSharedPrefs.edit();
        edit.putInt(TEXT_COLOR_PRIMARY + OLD,getPrimaryTextColor());
        edit.putInt(TEXT_COLOR_PRIMARY,prim);
        edit.commit();
    }

    public Integer getSecondaryTextColor(){
        return mSharedPrefs.getInt(TEXT_COLOR_SECONDARY,ContextCompat.getColor(ctx,R.color.CDDarkThemeTextColorSecondary));
    }

    public Integer getSecondaryTextColorOld(){
        return mSharedPrefs.getInt(TEXT_COLOR_SECONDARY + OLD,ContextCompat.getColor(ctx,R.color.CDDarkThemeTextColorSecondary));
    }

    public void setSecondaryTextColor(Integer sec){
        SharedPreferences.Editor edit = mSharedPrefs.edit();
        edit.putInt(TEXT_COLOR_SECONDARY + OLD,getSecondaryTextColor());
        edit.putInt(TEXT_COLOR_SECONDARY,sec);
        edit.commit();
    }



    /// Custom Colors

    public Integer getNavBarColor(){
        Integer navBar = mSharedPrefs.getInt(NAVBAR_COLOR,-1);
        if(navBar == -1){
            return getPrimaryColor();
        }
        return navBar;
    }

    public Integer getNavBarColorOld(){
        Integer navBar = mSharedPrefs.getInt(NAVBAR_COLOR + OLD,-1);
        if(navBar == -1){
            return getPrimaryColorOld();
        }
        return navBar;
    }

    public void setNavBarColor(Integer sec){
        SharedPreferences.Editor edit = mSharedPrefs.edit();
        edit.putInt(NAVBAR_COLOR + OLD,getNavBarColor());
        edit.putInt(NAVBAR_COLOR,sec);
        edit.commit();
    }

    public Integer getNavButtonColor(){
        Integer navBar = mSharedPrefs.getInt(NAVBAR_ICONS_COLOR,-1);
        if(navBar == -1){
            return getPrimaryTextColor();
        }
        return navBar;
    }

    public Integer getNavButtonColorOld(){
        Integer navBar = mSharedPrefs.getInt(NAVBAR_ICONS_COLOR + OLD,-1);
        if(navBar == -1){
            return getPrimaryTextColorOld();
        }
        return navBar;
    }

    public void setNavButtonColor(Integer sec){
        SharedPreferences.Editor edit = mSharedPrefs.edit();
        edit.putInt(NAVBAR_ICONS_COLOR + OLD,getNavButtonColor());
        edit.putInt(NAVBAR_ICONS_COLOR,sec);
        edit.commit();
    }


    public Integer getButtonColor(){
        Integer button = mSharedPrefs.getInt(BUTTON_COLOR,-1);
        if(button == -1){
            return getPrimaryColor();
        }
        return button;
    }

    public Integer getButtonColorOld(){
        Integer button = mSharedPrefs.getInt(BUTTON_COLOR + OLD,-1);
        if(button == -1){
            return getPrimaryColorOld();
        }
        return button;
    }

    public void setButtonColor(Integer button){
        SharedPreferences.Editor edit = mSharedPrefs.edit();
        edit.putInt(BUTTON_COLOR + OLD,getButtonColor());
        edit.putInt(BUTTON_COLOR,button);
        edit.commit();
    }

    public Integer getButtonTextColor(){
        Integer button = mSharedPrefs.getInt(BUTTON_TEXT_COLOR,-1);
        if(button == -1){
            return getPrimaryTextColor();
        }
        return button;
    }

    public Integer getButtonTextColorOld(){
        Integer button = mSharedPrefs.getInt(BUTTON_TEXT_COLOR + OLD,-1);
        if(button == -1){
            return getSelectedColorOld();
        }
        return button;
    }

    public void setButtonTextColor(Integer button){
        SharedPreferences.Editor edit = mSharedPrefs.edit();
        edit.putInt(BUTTON_TEXT_COLOR + OLD,getButtonTextColor());
        edit.putInt(BUTTON_TEXT_COLOR,button);
        edit.commit();
    }


    public Integer getSelectedColor(){
        Integer select = mSharedPrefs.getInt(SELECTED_COLOR,-1);
        if(select == -1){
            return getAccentColor();
        }
        return select;
    }

    public Integer getSelectedColorOld(){
        Integer select = mSharedPrefs.getInt(SELECTED_COLOR + OLD,-1);
        if(select == -1){
            return getAccentColorOld();
        }
        return select;
    }

    public void setSelectedColor(Integer select){
        SharedPreferences.Editor edit = mSharedPrefs.edit();
        edit.putInt(SELECTED_COLOR + OLD,getSelectedColor());
        edit.putInt(SELECTED_COLOR,select);
        edit.commit();
    }
}
