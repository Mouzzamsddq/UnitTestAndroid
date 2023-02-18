package com.example.unittestandroid.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.unittestandroid.MainCoroutineRule
import com.example.unittestandroid.data.repo.MainRepository
import com.example.unittestandroid.getOrAwaitValueTest
import com.example.unittestandroid.other.ApiData
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Before
    fun setup() {
    }

    @Test
    fun `valid status should equal to success`() {
        val mainRepository = mockk<MainRepository>()
        val mainViewModel = MainViewModel(mainRepository)
        coEvery { mainRepository.getValidStatus() } returns ApiData.success(null)
        mainViewModel.setValidStatus()
        mainCoroutineRule.dispatcher.scheduler.advanceUntilIdle()
        val result = mainViewModel.validStatus.getOrAwaitValueTest()
        assertThat(result.status).isEqualTo(ApiData.Status.SUCCESS)
    }
}
