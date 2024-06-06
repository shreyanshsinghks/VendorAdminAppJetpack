package com.hello.venderadminapp.screens.allUsers

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hello.venderadminapp.api.API_Builder
import com.hello.venderadminapp.api.RetrofitInstance
import com.hello.venderadminapp.api.UserDataClassItem
import kotlinx.coroutines.launch

class AllUsersViewModel : ViewModel() {
    var state = mutableStateOf("")

    val res = mutableStateOf<List<UserDataClassItem?>>(emptyList())

    init {
        viewModelScope.launch {
            state.value = State.LOADING.name
            try {
                res.value = getAllUsers()
            } catch (e: Exception) {
                state.value = State.DEFAULT.name
            } finally {
                state.value = State.SUCCESS.name
            }
        }
    }


    private suspend fun getAllUsers(): List<UserDataClassItem?> {
        return RetrofitInstance.api.getAllUsers()
    }

    fun updateUserAccess(userId: String, approved: Int, blocked: Int) {
        viewModelScope.launch {
            RetrofitInstance.api.updateUserAccess(
                userId = userId,
                approved = approved,
                blocked = blocked
            )
        }
    }


}


sealed class State(var name: String) {
    object DEFAULT : State("DEFAULT")
    object FAILED : State("FAILED")
    object SUCCESS : State("SUCCESS")
    object LOADING : State("LOADING")
}