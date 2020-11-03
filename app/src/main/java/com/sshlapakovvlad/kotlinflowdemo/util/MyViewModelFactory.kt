package com.sshlapakovvlad.kotlinflowdemo.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sshlapakovvlad.kotlinflowdemo.repository.Repository
import com.sshlapakovvlad.kotlinflowdemo.ui.viewmodel.MyViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
class MyViewModelFactory @ExperimentalCoroutinesApi constructor(
    private val repository: Repository
) : ViewModelProvider.NewInstanceFactory() {

    @ExperimentalCoroutinesApi
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = MyViewModel(
        repository
    ) as T
}