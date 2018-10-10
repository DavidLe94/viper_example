package com.android.haule.android_viper_example.presenter;

import android.content.Context;
import android.content.Intent;

import com.android.haule.android_viper_example.contracts.ItemDetailContracts;
import com.android.haule.android_viper_example.entity.Item;
import com.android.haule.android_viper_example.interactor.ItemDetailInteractor;
import com.android.haule.android_viper_example.router.ItemDetailRouter;

/**
 * Created by Hau Le on 2018-10-10.
 */
public class ItemDetailPresenter implements ItemDetailContracts.Presenter, ItemDetailContracts.InteractorOutput {
    private ItemDetailContracts.View view;
    private ItemDetailContracts.Router router;
    private ItemDetailContracts.Interactor output = new ItemDetailInteractor(this);

    public ItemDetailPresenter(ItemDetailContracts.View view) {
        this.view = view;
        router = new ItemDetailRouter((Context) view);
    }

    @Override
    public void actionGetItemDetail(Intent intent) {
        output.doGetItemDetail(intent);
    }

    @Override
    public void actionOnBackPress() {
        router.onBackPress();
    }

    @Override
    public void onSuccess(Item item) {
        view.getItemDetailSuccess(item);
    }

    @Override
    public void onFailed(String message) {
        view.getItemDetailFailed(message);
    }
}
