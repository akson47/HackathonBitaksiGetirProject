package com.yusufakson.hackathonbitaksigetirproject.interfaces;

import com.yusufakson.hackathonbitaksigetirproject.model.Elements;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by lenovo on 20.3.2017.
 *
 * @author yusuf akson
 */

public interface IService {

    @FormUrlEncoded
    @POST("/getElements")
    Call<Elements> element(@Field("name") String name, @Field("email") String email, @Field("gsm") String gsm);
}
