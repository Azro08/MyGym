package com.azrosk.data.remote

import com.azrosk.data.remote.model.BodyPartExerciseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BodyPartExerciseApi {

    @GET("bodyPart/{bodyPart}?rapidapi-key=0a470e5d1cmsh07e773acc29730dp13c6e2jsn828fa9257993")
    suspend fun loadExercise(@Path("bodyPart") bodyPart : String) : Response<BodyPartExerciseResponse>

}