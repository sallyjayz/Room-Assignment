package com.sallyjayz.contactlistwithroomdatabase.user

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.sallyjayz.contactlistwithroomdatabase.database.UserRepository
import com.sallyjayz.contactlistwithroomdatabase.model.Contact
import com.sallyjayz.contactlistwithroomdatabase.model.User
import kotlinx.coroutines.launch

class UserViewModel (private val repository: UserRepository) : ViewModel() {

    private var _count = MutableLiveData<Int>()
    val count:LiveData<Int>
        get() = _count



    fun findFilledEmailPassword(email:String, password:String) =
        viewModelScope.launch {
            _count.value = repository.findFilledEmailPassword(email, password)
            Log.d("Userviewmodel", "findFilledEmailPassword: ${_count.value.toString()}")
        }


    fun insert(user: User) = viewModelScope.launch {
        repository.insert(user)
    }
}

class UserViewModelFactory(private val repository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}