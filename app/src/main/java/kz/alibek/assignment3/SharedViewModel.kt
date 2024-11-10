package kz.alibek.assignment3

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val inputText = MutableLiveData<String>()
}
