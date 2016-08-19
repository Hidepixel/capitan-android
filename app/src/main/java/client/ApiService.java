package client;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dinom on 18/03/2016.
 */
public class ApiService {

    public static final String ROOT_URL = "http://10.0.17.168:3000/";
    private Retrofit retrofit;
    private OkHttpClient client;

    public ApiService() {
        client = new OkHttpClient();
        retrofit = new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public OkHttpClient getClient() {
        return client;
    }
}
