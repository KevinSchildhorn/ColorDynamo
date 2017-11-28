package com.kevinschildhorn.colordynamoexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kevinschildhorn.colordynamo.CDFragment;

public class FragmentTwo extends CDFragment {

        public static FragmentTwo newInstance() {
            FragmentTwo fragment = new FragmentTwo();
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_finished, container, false);
        }
    }