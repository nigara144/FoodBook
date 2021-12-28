package com.example.foodbook.rest;

import com.example.foodbook.model.MainData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface RestInterface {

    //User REST Commands
    @GET("/iob/users/login/{userDomain}/{userEmail}")
    Call<MainData> loginUserAndRetrieve();

    @PUT("/iob/users/{userDomain}/{userEmail}")
    Call<MainData> updateUser();

    @POST("/iob/users")
    Call<MainData> createNewUser();

    //Admin REST Commands
    @GET("/iob/admin/users/{userDomain}/{userEmail}")
    Call<MainData> exportAllUsers();

    @PUT("/iob/admin/activities/{userDomain}/{userEmail}")
    Call<MainData> exportAllActivities();

    @DELETE("/iob/admin/users/{userDomain}/{userEmail}")
    Call<MainData> deleteAllUsersInDomain();

    @DELETE("/iob/admin/instances/{userDomain}/{userEmail}")
    Call<MainData> deleteAllInstancesInDomain();

    @DELETE("/iob/admin/activities/{userDomain}/{userEmail}")
    Call<MainData> deleteAllActivitiesInDomain();

    //Instances REST Commands
    @POST("/iob/instances/{userDomain}/{userEmail}")
    Call<MainData> createNewInstance();

    @PUT("/iob/instances/{userDomain}/{userEmail}/{instanceDomain}/{instanceId}")
    Call<MainData> updateInstance();

    @GET("/iob/instances/{userDomain}/{userEmail}/{instanceDomain}/{instanceId}")
    Call<MainData> retrieveInstance();

    @GET("/iob/instances/{userDomain}/{userEmail}")
    Call<MainData> getAllInstances();

    @DELETE("/iob/instances/{userDomain}/{userEmail}")
    Call<MainData> deleteAllInstances();

    @GET("/iob/instances/{userDomain}/{userEmail}/search/byName/{name}")
    Call<MainData> getAllNamesLikeName();

    @GET("/iob/instances/{userDomain}/{userEmail}/search/byType/{type}")
    Call<MainData> getAllTypesLikeType();

    @GET("/iob/instances/{userDomain}/{userEmail}/search/near/{lat}/{lng}/{distance}")
    Call<MainData> getAllByLocation();

    @GET("/iob/instances/{userDomain}/{userEmail}/search/created/{creationWindow}")
    Call<MainData> getAllByCreationWindow();


}