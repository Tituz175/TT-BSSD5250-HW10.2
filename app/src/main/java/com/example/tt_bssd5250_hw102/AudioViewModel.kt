package com.example.tt_bssd5250_hw102

import androidx.lifecycle.ViewModel

class AudioViewModel : ViewModel() {

    private var currentTime:Int = 0

    fun setCurrentTime(time: Int) {
        currentTime = time;
    }

    fun getCurrentTime():Int{
        return currentTime;
    }
}