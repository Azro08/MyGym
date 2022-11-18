package com.azrosk.mygym.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.azrosk.data.remote.model.BodyPartExerciseResponse
import com.azrosk.data.repository.BodyPartExerciseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExerciseViewModel @Inject constructor(private val repository: BodyPartExerciseRepository) : ViewModel(){
    private val _response = MutableLiveData<BodyPartExerciseResponse>()
    val responseExercise : LiveData<BodyPartExerciseResponse>
        get() = _response


    fun loadExercise(bodyPart : String) = viewModelScope.launch {
        repository.loadExercise(bodyPart).let { response ->
            if (response.isSuccessful){
                _response.postValue(response.body())
            }
            else{
                Log.e("error_response", response.message())
            }
        }
    }
}