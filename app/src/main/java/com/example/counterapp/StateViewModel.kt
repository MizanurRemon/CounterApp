package com.example.counterapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class StateViewModel : ViewModel() {
    private var _counter: MutableStateFlow<Int> = MutableStateFlow(0)
    var cnt: StateFlow<Int> = _counter

    fun incrementFunc() {
        _counter.value++
    }

    fun decrementFunc() {
        _counter.value--
    }
}