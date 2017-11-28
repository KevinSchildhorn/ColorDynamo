package com.kevinschildhorn.colordynamo;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;

import java.util.HashMap;

/**
 * Created by Kevin Schildhorn on 11/21/17.
 */

public class CDFragment extends Fragment {

    @Override
    public void onResume(){
        super.onResume();

        CDAnimator.animateBackgroundColor(getView(),0,CDColors.getInstance(null).getSecondaryColorOld(),CDColors.getInstance(null).getSecondaryColor());
        CDPainter.repaintViewGroup((ViewGroup) getView(),0);
    }
}
