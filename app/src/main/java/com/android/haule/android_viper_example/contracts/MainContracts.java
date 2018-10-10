package com.android.haule.android_viper_example.contracts;

import com.android.haule.android_viper_example.entity.Item;

import java.util.ArrayList;

/**
 * Created by Hau Le on 2018-10-09.
 */
public interface MainContracts {
    interface View{
        void showListAnswer(ArrayList<Item> list);
        void showError(String message);
        void showLoading();
        void hiddenLoading();
    }

    interface Presenter{
        void actionLoadListAnswer();
        void actionItemClick(Item item);
    }

    interface Interactor{
        void doLoadListAnswers();
    }

    interface InteractorOutput{
        void onGetAnswerListSuccess(ArrayList<Item> list);
        void onGetAnswerListFailed(String message);
    }

    interface Router{
        void navItemDetails(Item item);
    }
}
