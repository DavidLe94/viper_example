package com.android.haule.android_viper_example.router;

import android.content.Context;
import android.content.Intent;
import com.android.haule.android_viper_example.contracts.MainContracts;
import com.android.haule.android_viper_example.entity.Item;
import com.android.haule.android_viper_example.view.ItemDetailActivity;

/**
 * Created by Hau Le on 2018-10-09.
 */
public class MainRouter implements MainContracts.Router {
    private Context context;

    public MainRouter(Context context) {
        this.context = context;
    }

    @Override
    public void navItemDetails(Item item) {
        Intent intent = new Intent(context, ItemDetailActivity.class);
        intent.putExtra("Item", item);
        context.startActivity(intent);
    }
}
