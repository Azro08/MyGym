package com.azrosk.data.repository

import com.azrosk.data.remote.BodyPartExerciseApi
import javax.inject.Inject

class BodyPartExerciseRepository @Inject constructor(private val apiService : BodyPartExerciseApi) {
    suspend fun loadExercise (bodyPart : String) = apiService.loadExercise(bodyPart)
}