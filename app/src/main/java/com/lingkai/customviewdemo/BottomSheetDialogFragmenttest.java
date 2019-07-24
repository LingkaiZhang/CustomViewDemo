package com.lingkai.customviewdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * description ： 扩展（BottomSheetDialogFragment实现底部弹窗）
 * author : lingkai
 * date : 2019/7/24 09:55
 */
public class BottomSheetDialogFragmenttest extends BottomSheetDialogFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.test,container,false);
    }
}
