package com.example.listofhistoricalfigures

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

class MyObserverLifecycle : LifecycleObserver
{
    /** Логирование каждого события жизненного цикла */
    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun loggingLifecycle(source: LifecycleOwner, event: Lifecycle.Event)
    {
        // Логирование для отладки
        Log.d("TAG", event.toString())
    }
}