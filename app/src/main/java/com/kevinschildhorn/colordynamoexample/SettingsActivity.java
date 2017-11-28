package com.kevinschildhorn.colordynamoexample;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.IntentCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import com.jaredrummler.android.colorpicker.ColorPickerDialogListener;
import com.kevinschildhorn.colordynamo.CDActivity;
import com.kevinschildhorn.colordynamo.CDColors;

public class SettingsActivity extends CDActivity implements ColorPickerDialogListener {
    ListView listView;
    SettingsAdapter adapter;

    int mLastPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = findViewById(R.id.listView);
        adapter = new SettingsAdapter(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mLastPosition = position;
                switch (position) {
                    case 0:
                        //saveDialog();
                        CDColors.getInstance(SettingsActivity.this).removeAllStyles();
                        break;
                    case 1:
                        loadDialog();
                        break;
                    case 2:
                        setStyleDefaultDark();
                        adapter.notifyDataSetChanged();
                        break;
                    case 3:
                        setStyleDefaultLight();
                        adapter.notifyDataSetChanged();
                        break;
                    case 4:
                        ColorPickerDialog.newBuilder().setColor(CDColors.getInstance(SettingsActivity.this).getPrimaryColor()).show(SettingsActivity.this);
                        break;
                    case 5:
                        ColorPickerDialog.newBuilder().setColor(CDColors.getInstance(SettingsActivity.this).getSecondaryColor()).show(SettingsActivity.this);
                        break;
                    case 6:
                        ColorPickerDialog.newBuilder().setColor(CDColors.getInstance(SettingsActivity.this).getAccentColor()).show(SettingsActivity.this);
                        break;
                    case 7:
                        ColorPickerDialog.newBuilder().setColor(CDColors.getInstance(SettingsActivity.this).getPrimaryTextColor()).show(SettingsActivity.this);
                        break;
                    case 8:
                        ColorPickerDialog.newBuilder().setColor(CDColors.getInstance(SettingsActivity.this).getSecondaryTextColor()).show(SettingsActivity.this);
                        break;
                    case 9:
                        ColorPickerDialog.newBuilder().setColor(CDColors.getInstance(SettingsActivity.this).getNavBarColor()).show(SettingsActivity.this);
                        break;
                    case 10:
                        ColorPickerDialog.newBuilder().setColor(CDColors.getInstance(SettingsActivity.this).getNavButtonColor()).show(SettingsActivity.this);
                        break;
                    case 11:
                        ColorPickerDialog.newBuilder().setColor(CDColors.getInstance(SettingsActivity.this).getButtonColor()).show(SettingsActivity.this);
                        break;
                    case 12:
                        ColorPickerDialog.newBuilder().setColor(CDColors.getInstance(SettingsActivity.this).getButtonTextColor()).show(SettingsActivity.this);
                        break;
                    case 13:
                        ColorPickerDialog.newBuilder().setColor(CDColors.getInstance(SettingsActivity.this).getSelectedColor()).show(SettingsActivity.this);
                        break;
                }

            }
        });

    }

    @Override
    public void onColorSelected(int dialogId, int color) {
        switch (mLastPosition) {
            case 4:
                CDColors.getInstance(SettingsActivity.this).setPrimaryColor(color);
                break;
            case 5:
                CDColors.getInstance(SettingsActivity.this).setSecondaryColor(color);
                break;
            case 6:
                CDColors.getInstance(SettingsActivity.this).setAccentColor(color);
                break;
            case 7:
                CDColors.getInstance(SettingsActivity.this).setPrimaryTextColor(color);
                break;
            case 8:
                CDColors.getInstance(SettingsActivity.this).setSecondaryTextColor(color);
                break;
            case 9:
                CDColors.getInstance(SettingsActivity.this).setNavBarColor(color);
                break;
            case 10:
                CDColors.getInstance(SettingsActivity.this).setNavButtonColor(color);
                break;
            case 11:
                CDColors.getInstance(SettingsActivity.this).setButtonColor(color);
                break;
            case 12:
                CDColors.getInstance(SettingsActivity.this).setButtonTextColor(color);
                break;
            case 13:
                CDColors.getInstance(SettingsActivity.this).setSelectedColor(color);
                break;
        }

        adapter.notifyDataSetChanged();
        repaintActivityAnimated(1000);
    }

    @Override
    public void onDialogDismissed(int dialogId) {

    }

    void saveDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Save Preset");

        // Set up the input
        final EditText input = new EditText(this);
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String m_Text = input.getText().toString();
                CDColors.getInstance(SettingsActivity.this).saveStyle(m_Text);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    void loadDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Load Preset");

        // Set up the input
        final EditText input = new EditText(this);
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String m_Text = input.getText().toString();
                CDColors.getInstance(SettingsActivity.this).loadStyle(m_Text);
                SettingsActivity.this.repaintActivity();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}
