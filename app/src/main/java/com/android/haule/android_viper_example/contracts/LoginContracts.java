package com.android.haule.android_viper_example.contracts;

import com.android.haule.android_viper_example.entity.User;

/**
 * Created by Hau Le on 2018-10-08.
 */
public interface LoginContracts {
    interface View{
        void showError(String message);
    }

    interface Presenter{
        void onLoginButtonPressed(String username, String password);
    }

    interface Interactor{
        void login(String username, String password);
    }

    interface InteractorOutput{
        void onLoginSuccess(User user);
        void onLoginFailed(String message);
    }

    interface Router{
        void presentHomeScreen(User user);
    }
}
