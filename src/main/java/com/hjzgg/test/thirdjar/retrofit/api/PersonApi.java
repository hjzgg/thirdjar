package com.hjzgg.test.thirdjar.retrofit.api;

import com.hjzgg.test.thirdjar.web.controller.vo.PersonVo;
import com.hjzgg.test.thirdjar.web.controller.vo.Result;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PersonApi {
  @POST("person/findOne")
  Call<Result<PersonVo>> findOne(@Query("username") String username, @Query("password") String password);

  @POST("person/findOne2")
  Call<Result<PersonVo>> findOne2(@Body PersonVo personVo);
}
