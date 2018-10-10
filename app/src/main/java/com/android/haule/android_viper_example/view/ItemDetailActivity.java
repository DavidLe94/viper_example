package com.android.haule.android_viper_example.view;

import android.os.Bundle;
import com.android.haule.android_viper_example.R;
import com.android.haule.android_viper_example.view.base.BaseActivity;

public class ItemDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getResourceLayoutId() {
        return R.layout.activity_item_detail;
    }
}
