package com.sshlapakovvlad.kotlinflowdemo.repository

import com.sshlapakovvlad.kotlinflowdemo.util.DataState
import com.sshlapakovvlad.kotlinflowdemo.data.DataSource
import com.sshlapakovvlad.kotlinflowdemo.ui.state.StateEvent
import com.sshlapakovvlad.kotlinflowdemo.ui.state.ViewState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception


@ExperimentalCoroutinesApi
class Repository {

    fun getObject1(stateEvent: StateEvent): Flow<DataState<ViewState>> {
        
        return flow {

            try{
                val result = DataSource.getObject1()
                emit(
                    DataState.data(
                        data = ViewState(object1 = result),
                        stateEvent = stateEvent
                    )
                )
            }catch (e: Exception){
                e.printStackTrace()
                emit(
                    DataState.error<ViewState>(
                        errorMessage = "Unable to retrieve object 1.\n\nReason: ${e.message}",
                        stateEvent = stateEvent
                    )
                )
            }
        }
    }

    fun getObject2(stateEvent: StateEvent): Flow<DataState<ViewState>> {

        return flow {

            try{
                val result = DataSource.getObject2()

                emit(
                    DataState.data(
                        data = ViewState(object2 = result),
                        stateEvent = stateEvent
                    )
                )
            }catch (e: Exception){
                e.printStackTrace()
                emit(
                    DataState.error<ViewState>(
                        errorMessage = "Unable to retrieve object 2.\n\nReason: ${e.message}",
                        stateEvent = stateEvent
                    )
                )
            }
        }
    }

    fun getObject3(stateEvent: StateEvent): Flow<DataState<ViewState>>{

        return flow {

            try{
                val result = DataSource.getObject3()

                emit(
                    DataState.data(
                        data = ViewState(object3 = result),
                        stateEvent = stateEvent
                    )
                )
            }catch (e: Exception){
                e.printStackTrace()
                emit(
                    DataState.error<ViewState>(
                        errorMessage = "Unable to retrieve object 3.\n\nReason: ${e.message}",
                        stateEvent = stateEvent
                        )
                )
            }
        }
    }


}















