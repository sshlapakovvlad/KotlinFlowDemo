package com.sshlapakovvlad.kotlinflowdemo.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sshlapakovvlad.kotlinflowdemo.util.ErrorState

class ErrorStack: ArrayList<ErrorState>(){

    private val _errorState: MutableLiveData<ErrorState> = MutableLiveData()

    val errorState: LiveData<ErrorState> = _errorState

    override fun add(element: ErrorState): Boolean {
        if (this.size == 0) {
            setErrorState(errorState = element)
        }
        return super.add(element)
    }

    override fun removeAt(index: Int): ErrorState {
        val transaction = super.removeAt(index)
        if (this.size > 0) {
            setErrorState(errorState = this[0])
        }
        return transaction
    }

    private fun setErrorState(errorState: ErrorState){
        _errorState.value = errorState
    }
}