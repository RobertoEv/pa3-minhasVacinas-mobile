package com.betoe.minhasvacinas.rest;

import com.betoe.minhasvacinas.model.Pet;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PetEndPoint {
    @GET("{user}/ca20b9dddc9e3e382bab628b03c79b47/raw/c930ecdc3ff9a00d69e03fa363233edf36a1a945/pet")
    Call<List<Pet>> getPet(@Path("user") String name);

}
