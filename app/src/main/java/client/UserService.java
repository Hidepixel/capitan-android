package client;

import android.util.Log;

import java.util.List;



import models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by dinom on 18/03/2016.
 */
public class UserService {

    private ApiService service;

    public UserService(ApiService service) {
        this.service = service;
    }

    public void getUsers(final SuccessCallback callback) {
        List<User> resultUsers;
        Retrofit retrofit = service.getRetrofit();
        UserEndpointInterface service = retrofit.create(UserEndpointInterface.class);
        Call<List<User>> call = service.getUsers();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                   List<User> userList = response.body();
                    callback.result(true, userList);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                callback.result(false, null);
            }
        });
    }

    public interface SuccessCallback {
        void result(boolean status, List<User> users);
    }

}
