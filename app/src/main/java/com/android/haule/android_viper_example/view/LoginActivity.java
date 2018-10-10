package com.android.haule.android_viper_example.view;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.android.haule.android_viper_example.contracts.LoginContracts;
import com.android.haule.android_viper_example.R;
import com.android.haule.android_viper_example.presenter.LoginPresenter;
import com.android.haule.android_viper_example.view.base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity
        implements LoginContracts.View {
    @BindView(R.id.edt_username) EditText edtUsername;
    @BindView(R.id.edt_password) EditText edtPassword;
    @BindView(R.id.layout_wrapper) RelativeLayout loWrapper;

    private LoginContracts.Presenter presenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hiddenKeySoft( this, loWrapper);
        presenter = new LoginPresenter(this);

    }

    @Override
    protected int getResourceLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_login)
    public void loginButtonClicked(){
        presenter.onLoginButtonPressed(edtUsername.getText().toString(), edtPassword.getText().toString());
    }


    @Override
    protected void onDestroy() {
        presenter = null;
        super.onDestroy();
    }
}
