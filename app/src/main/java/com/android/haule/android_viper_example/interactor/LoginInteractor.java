package com.android.haule.android_viper_example.interactor;

import com.android.haule.android_viper_example.LoginContracts;
import com.android.haule.android_viper_example.entity.User;

/**
 * Created by Hau Le on 2018-10-08.
 */
public class LoginInteractor implements LoginContracts.Interactor{
    private LoginContracts.InteractorOutput output;

    public LoginInteractor(LoginContracts.InteractorOutput output) {
        this.output = output;
    }

    @Override
    public void unregister() {
        output = null;
    }

    @Override
    public void login(String username, String password) {
        User user = new User();
        user.setUsername("Hau le");
        user.setPassword("123456");

        if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
            output.onLoginSuccess(user);
        }else{
            output.onLoginFailed("Login Failed!!!!!!!!");
        }
    }
}
