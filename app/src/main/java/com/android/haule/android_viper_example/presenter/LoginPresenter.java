package com.android.haule.android_viper_example.presenter;

import android.content.Context;

import com.android.haule.android_viper_example.LoginContracts;
import com.android.haule.android_viper_example.entity.User;
import com.android.haule.android_viper_example.interactor.LoginInteractor;
import com.android.haule.android_viper_example.router.LoginRouter;

/**
 * Created by Hau Le on 2018-10-08.
 */
public class LoginPresenter implements LoginContracts.Presenter, LoginContracts.InteractorOutput{
    private LoginContracts.View view;
    private LoginContracts.Interactor interactor = new LoginInteractor(this);
    private LoginContracts.Router router;

    public LoginPresenter(LoginContracts.View view) {
        this.view = view;
        router = new LoginRouter((Context) view);
    }

    @Override
    public void onDestroy() {
        view = null;
        interactor.unregister();
        interactor = null;
    }

    @Override
    public void onLoginButtonPressed(String username, String password) {
        interactor.login(username, password);
    }

    @Override
    public void onLoginSuccess(User user) {
        router.presentHomeScreen(user);
    }

    @Override
    public void onLoginFailed(String message) {
        view.showError(message);
    }
}
