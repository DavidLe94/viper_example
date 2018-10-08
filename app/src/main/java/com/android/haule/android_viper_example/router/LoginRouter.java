package com.android.haule.android_viper_example.router;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.android.haule.android_viper_example.LoginContracts;
import com.android.haule.android_viper_example.entity.User;
import com.android.haule.android_viper_example.view.MainActivity;

/**
 * Created by Hau Le on 2018-10-08.
 */
public class LoginRouter implements LoginContracts.Router{
    private Context context;

    public LoginRouter(Context context) {
        this.context = context;
    }

    @Override
    public void presentHomeScreen(User user) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("User", user);
        context.startActivity(intent);
        ((Activity)context).finish();
    }
}
