package com.kevinschildhorn.colordynamoexample;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kevinschildhorn.colordynamo.CDColors;

/**
 * Created by Kevin Schildhorn on 11/21/17.
 */

public class SettingsAdapter extends BaseAdapter {

    public static class ViewHolder {
        public TextView textView1;
        public TextView textView2;
        public ImageView imageView;

    }
    LayoutInflater mInflater;
    Context mContext;
    public SettingsAdapter(Context context) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mContext = context;

    }

    @Override
    public int getCount() {
        return 13;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        convertView = mInflater.inflate(R.layout.view_holder, null);
        holder.textView1 = (TextView) convertView.findViewById(R.id.settings_row_1_text);
        holder.imageView = (ImageView) convertView.findViewById(R.id.settings_row_1_icon);
        holder.textView2 = (TextView) convertView.findViewById(R.id.settings_row_1_text2);

        holder.imageView.setVisibility(View.VISIBLE);
        switch (position) {
            case 0:
                holder.textView1.setText("Save Current Preset");
                holder.imageView.setVisibility(View.GONE);
                break;
            case 1:
                holder.textView1.setText("Load Current Preset");
                holder.imageView.setVisibility(View.GONE);
                break;
            case 2:
                holder.textView1.setText("Dark Preset");
                holder.imageView.setVisibility(View.GONE);
                break;
            case 3:
                holder.textView1.setText("Light Preset");
                holder.imageView.setVisibility(View.GONE);
                break;
            case 4:
                holder.textView1.setText("Primary Color");
                holder.imageView.setBackgroundColor(CDColors.getInstance(mContext).getPrimaryColor());
                break;
            case 5:
                holder.textView1.setText("Secondary Color");
                holder.imageView.setBackgroundColor(CDColors.getInstance(mContext).getSecondaryColor());
                break;
            case 6:
                holder.textView1.setText("Accent Color");
                holder.imageView.setBackgroundColor(CDColors.getInstance(mContext).getAccentColor());
                break;
            case 7:
                holder.textView1.setText("Primary Text Color");
                holder.imageView.setBackgroundColor(CDColors.getInstance(mContext).getPrimaryTextColor());
                break;
            case 8:
                holder.textView1.setText("Secondary Text Color");
                holder.imageView.setBackgroundColor(CDColors.getInstance(mContext).getSecondaryTextColor());
                break;
            case 9:
                holder.textView1.setText("NavBar Color");
                holder.imageView.setBackgroundColor(CDColors.getInstance(mContext).getNavBarColor());
                break;
            case 10:
                holder.textView1.setText("NavBar Button Color");
                holder.imageView.setBackgroundColor(CDColors.getInstance(mContext).getNavButtonColor());
                break;
            case 11:
                holder.textView1.setText("Button Color");
                holder.imageView.setBackgroundColor(CDColors.getInstance(mContext).getButtonColor());
                break;
            case 12:
                holder.textView1.setText("Button Text Color");
                holder.imageView.setBackgroundColor(CDColors.getInstance(mContext).getButtonTextColor());
                break;
            case 13:
                holder.textView1.setText("Selected Color");
                holder.imageView.setBackgroundColor(CDColors.getInstance(mContext).getSelectedColor());
                break;
        }

        return convertView;
    }
}
