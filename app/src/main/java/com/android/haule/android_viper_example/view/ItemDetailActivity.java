package com.android.haule.android_viper_example.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.haule.android_viper_example.R;
import com.android.haule.android_viper_example.contracts.ItemDetailContracts;
import com.android.haule.android_viper_example.entity.Item;
import com.android.haule.android_viper_example.presenter.ItemDetailPresenter;
import com.android.haule.android_viper_example.view.base.BaseActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import butterknife.BindView;
import butterknife.OnClick;

public class ItemDetailActivity extends BaseActivity implements ItemDetailContracts.View{
    @BindView(R.id.tv_display_name) TextView tvDisplayName;
    @BindView(R.id.img_profile_image) ImageView imgProfileImage;

    private ItemDetailPresenter presenter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new ItemDetailPresenter(this);
        presenter.actionGetItemDetail(getIntent());
    }

    @Override
    protected int getResourceLayoutId() {
        return R.layout.activity_item_detail;
    }

    @Override
    public void getItemDetailSuccess(Item item) {
        tvDisplayName.setText(item.getOwner().getDisplayName());
        Glide.with(this)
                .load(item.getOwner().getProfileImage())
                .apply(
                        new RequestOptions()
                                .placeholder(R.mipmap.ic_launcher)
                                .error(R.mipmap.ic_launcher)
                                .diskCacheStrategy(DiskCacheStrategy.ALL)

                )
                .into(imgProfileImage);
    }

    @Override
    public void getItemDetailFailed(String message) {
        Log.d("TAG", "getItemDetailFailed: " + message);
    }

    @OnClick(R.id.img_close)
    public void actionBack(){
        presenter.actionOnBackPress();
    }
}
