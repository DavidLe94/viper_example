package com.android.haule.android_viper_example.presenter;

import android.content.Context;
import com.android.haule.android_viper_example.contracts.MainContracts;
import com.android.haule.android_viper_example.entity.Item;
import com.android.haule.android_viper_example.interactor.MainInteractor;
import com.android.haule.android_viper_example.router.MainRouter;
import java.util.ArrayList;

/**
 * Created by Hau Le on 2018-10-09.
 */
public class MainPresenter implements MainContracts.Presenter, MainContracts.InteractorOutput {
    private MainContracts.View view;
    private MainContracts.Router router;
    private MainContracts.Interactor interactor = new MainInteractor(this);

    public MainPresenter(MainContracts.View view) {
        this.view = view;
        router = new MainRouter((Context) view);
    }

    @Override
    public void actionLoadListAnswer() {
        view.showLoading();
        interactor.doLoadListAnswers();
    }

    @Override
    public void actionItemClick(Item item) {
        router.navItemDetails(item);
    }

    @Override
    public void onGetAnswerListSuccess(ArrayList<Item> list) {
        view.hiddenLoading();
        view.showListAnswer(list);
    }

    @Override
    public void onGetAnswerListFailed(String message) {
        view.hiddenLoading();
        view.showError(message);
    }
}
