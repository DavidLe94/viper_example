package com.android.haule.android_viper_example.router;

import android.app.Activity;
import android.content.Context;

import com.android.haule.android_viper_example.contracts.ItemDetailContracts;

/**
 * Created by Hau Le on 2018-10-10.
 */
public class ItemDetailRouter implements ItemDetailContracts.Router {
    private Context context;

    public ItemDetailRouter(Context context) {
        this.context = context;
    }

    @Override
    public void onBackPress() {
        ((Activity)context).onBackPressed();
    }
}
