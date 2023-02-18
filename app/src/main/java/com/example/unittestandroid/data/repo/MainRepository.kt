package com.example.unittestandroid.data.repo

import com.example.unittestandroid.other.ApiData

class MainRepository {
    fun getValidStatus(): ApiData<Boolean> {
        return ApiData.success(true)
    }
}