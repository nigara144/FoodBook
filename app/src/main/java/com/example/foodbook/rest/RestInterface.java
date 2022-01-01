package com.example.foodbook.rest;

import com.example.foodbook.boundary.InstanceBoundary;
import com.example.foodbook.boundary.NewUserBoundary;
import com.example.foodbook.boundary.UserBoundary;
import com.example.foodbook.model.MainData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RestInterface {

    //User REST Commands
    @GET("/iob/users/login/{userDomain}/{userEmail}")
    Call<UserBoundary> loginUserAndRetrieve(@Path("userDomain") String userDomain,
                                            @Path("userEmail") String userEmail);

    @PUT("/iob/users/{userDomain}/{userEmail}")
    Call<MainData> updateUser();

    @POST("/iob/users")
    Call<UserBoundary> createNewUser(@Body NewUserBoundary mainData);

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
    Call<InstanceBoundary> createNewInstance(@Path("userDomain") String userDomain,
                                     @Path("userEmail") String userEmail,
                                     @Body InstanceBoundary instanceBoundary);

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
    Call<InstanceBoundary[]> getAllTypesLikeType(@Path("userDomain") String userDomain,
                                       @Path("userEmail") String userEmail,
                                       @Path("type") String type);

    @GET("/iob/instances/{userDomain}/{userEmail}/search/near/{lat}/{lng}/{distance}")
    Call<InstanceBoundary[]> getAllByLocation();

    @GET("/iob/instances/{userDomain}/{userEmail}/search/created/{creationWindow}")
    Call<MainData> getAllByCreationWindow();


}