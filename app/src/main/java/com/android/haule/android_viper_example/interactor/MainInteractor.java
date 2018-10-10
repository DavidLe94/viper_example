package com.android.haule.android_viper_example.interactor;

import com.android.haule.android_viper_example.api.ApiServices;
import com.android.haule.android_viper_example.api.ApiUtils;
import com.android.haule.android_viper_example.contracts.MainContracts;
import com.android.haule.android_viper_example.entity.Item;
import com.android.haule.android_viper_example.entity.ResAnswer;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Hau Le on 2018-10-09.
 */
public class MainInteractor implements MainContracts.Interactor {
    private MainContracts.InteractorOutput output;
    private ApiServices apiServices;

    public MainInteractor(MainContracts.InteractorOutput output) {
        this.output = output;
        apiServices = ApiUtils.getApiService();
    }

    @Override
    public void doLoadListAnswers() {
        apiServices.getListAnswer().enqueue(new Callback<ResAnswer>() {
            @Override
            public void onResponse(Call<ResAnswer> call, Response<ResAnswer> response) {
                output.onGetAnswerListSuccess((ArrayList<Item>) response.body().getItems());
            }

            @Override
            public void onFailure(Call<ResAnswer> call, Throwable t) {
                output.onGetAnswerListFailed(t.getMessage());
            }
        });
    }
}
