package com.lingkai.customviewdemo;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private CoordinatorLayout mainCoord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainCoord = findViewById(R.id.main_coord);

        final BottomSheetBehavior<View> bottomSheetBehavior = BottomSheetBehavior.from(findViewById(R.id.design_bottom_sheet1));
        //BottomSheetBehavior的基本使用
        //baseUserBottomSheetBehavior(bottomSheetBehavior);
        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialogFragmenttest bottomSheetDialogFragmenttest = new BottomSheetDialogFragmenttest();
                bottomSheetDialogFragmenttest.show(getSupportFragmentManager(), BottomSheetDialogFragment.class.getSimpleName());
            }
        });

    }

    private void baseUserBottomSheetBehavior(final BottomSheetBehavior<View> bottomSheetBehavior) {
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_HIDDEN) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                } else if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                }
            }
        });

        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View view, int i) {
                //拖动变化
            }

            @Override
            public void onSlide(@NonNull View view, float v) {
                //状态变化
                Snackbar.make(mainCoord,"状态改变： " + bottomSheetBehavior.getState(), Snackbar.LENGTH_LONG).show();
            }
        });
    }
}
