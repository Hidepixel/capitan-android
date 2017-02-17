package client;

import java.util.List;

import models.Product;
import models.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by dinom on 18/03/2016.
 */
public interface UserEndpointInterface {


    @GET("users.json")
    public Call<List<User>> getUsers();

    @GET("products.json")
    public Call<List<Product>> getProducts();
}
