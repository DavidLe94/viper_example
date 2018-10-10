package com.android.haule.android_viper_example.view;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import com.android.haule.android_viper_example.R;
import com.android.haule.android_viper_example.adapter.AnswerAdapter;
import com.android.haule.android_viper_example.callback.OnItemClickListener;
import com.android.haule.android_viper_example.contracts.MainContracts;
import com.android.haule.android_viper_example.entity.Item;
import com.android.haule.android_viper_example.presenter.MainPresenter;
import com.android.haule.android_viper_example.view.base.BaseActivity;
import java.util.ArrayList;
import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainContracts.View{
    @BindView(R.id.list_answer) RecyclerView recyclerView;

    private MainContracts.Presenter presenter = null;
    private ArrayList<Item> list;
    private AnswerAdapter adapter;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataView();
    }

    private void initDataView() {
        presenter = new MainPresenter(this);
        //call api
        presenter.actionLoadListAnswer();
        list = new ArrayList<>();
        adapter = new AnswerAdapter(this, list, new OnItemClickListener() {
            @Override
            public void callback(View view, int position) {
                //TODO: callback onclick item
                presenter.actionItemClick(list.get(position));
            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected int getResourceLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void showListAnswer(ArrayList<Item> list) {
        adapter.notifyData(list);
        this.list= list;
    }

    @Override
    public void showError(String message) {
        Log.d("TAG", "showError: " + message);
    }

    @Override
    public void showLoading() {
        hiddenLoading();
        dialog = showLoadingDialog(this, "Loading...");
        dialog.show();
    }

    @Override
    public void hiddenLoading() {
        if(dialog!=null && dialog.isShowing()){
            dialog.dismiss();
        }
    }
}
