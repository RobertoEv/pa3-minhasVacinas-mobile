package com.betoe.minhasvacinas.rest;

import com.betoe.minhasvacinas.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserEndPoint {
    @GET("{user}/52c40480a8ca59171a4b1a84f78d987b/raw/c418f950a462213489f15b6509201149accc2588/roberto")
    Call<User> getUser(@Path("user") String user);
}
