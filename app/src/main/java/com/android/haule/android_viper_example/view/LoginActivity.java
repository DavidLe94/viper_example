package com.android.haule.android_viper_example.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.haule.android_viper_example.LoginContracts;
import com.android.haule.android_viper_example.R;
import com.android.haule.android_viper_example.presenter.LoginPresenter;

public class LoginActivity extends Activity
        implements LoginContracts.View, View.OnClickListener {
    private EditText edtUsername, edtPassword;
    private Button btnLogin;
    private LoginContracts.Presenter presenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        presenter = new LoginPresenter(this);

    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                onLoginButtonClicked();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        presenter = null;
        super.onDestroy();
    }

    private void initView() {
        //init view
        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);

        //set event
        btnLogin.setOnClickListener(this);
    }

    private void onLoginButtonClicked(){
        presenter.onLoginButtonPressed(edtUsername.getText().toString(), edtPassword.getText().toString());
    }
}
