package com.android.haule.android_viper_example.contracts;

import android.content.Context;
import android.content.Intent;
import com.android.haule.android_viper_example.entity.Item;

/**
 * Created by Hau Le on 2018-10-10.
 */
public interface ItemDetailContracts {
    interface View{
        void getItemDetailSuccess(Item item);
        void getItemDetailFailed(String message);
    }

    interface Presenter{
        void actionGetItemDetail(Intent intent);
        void actionOnBackPress();
    }

    interface Interactor{
        void doGetItemDetail(Intent intent);
    }

    interface InteractorOutput{
        void onSuccess(Item item);
        void onFailed(String message);
    }

    interface Router{
        void onBackPress();
    }
}
