package com.android.haule.android_viper_example.interactor;

import android.content.Intent;

import com.android.haule.android_viper_example.contracts.ItemDetailContracts;
import com.android.haule.android_viper_example.entity.Item;

/**
 * Created by Hau Le on 2018-10-10.
 */
public class ItemDetailInteractor implements ItemDetailContracts.Interactor {
    private ItemDetailContracts.InteractorOutput output;

    public ItemDetailInteractor(ItemDetailContracts.InteractorOutput output) {
        this.output = output;
    }

    @Override
    public void doGetItemDetail(Intent intent) {
        if(intent.getSerializableExtra("Item")!=null){
            output.onSuccess((Item) intent.getSerializableExtra("Item"));
        }else{
            output.onFailed("Intent not found!!!!!");
        }
    }
}
