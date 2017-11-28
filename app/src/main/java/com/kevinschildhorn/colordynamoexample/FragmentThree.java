package com.kevinschildhorn.colordynamoexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kevinschildhorn.colordynamo.CDFragment;

public class FragmentThree extends CDFragment {
        public static FragmentThree newInstance() {
            FragmentThree fragment = new FragmentThree();
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_achievements, container, false);
        }
    }