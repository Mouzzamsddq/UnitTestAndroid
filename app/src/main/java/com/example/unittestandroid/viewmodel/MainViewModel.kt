package com.example.unittestandroid.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unittestandroid.data.repo.MainRepository
import com.example.unittestandroid.other.ApiData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {
    private val _validStatus = MutableLiveData<ApiData<Boolean>>()
    val validStatus: LiveData<ApiData<Boolean>> = _validStatus

    fun setValidStatus() = viewModelScope.launch(Dispatchers.Main) {
        val response = mainRepository.getValidStatus()
        _validStatus.postValue(response)
    }
}
