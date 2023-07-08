package com.example.lab15

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.util.Date
import java.util.UUID

class CrimeListViewModel (application : Application) : AndroidViewModel(application) {

    val crimes = mutableListOf<Crime>()
    init {
        viewModelScope.launch {
            crimes += loadCrimes()
        }
    }

    suspend fun loadCrimes(): List<Crime> {
        val result = mutableListOf<Crime>()
        for (i in 0 until 100) {
            val crime = Crime(
                id = UUID.randomUUID(), title = "Crime #$i", date = Date(), isSolved = i % 2 == 0
            )
            result += crime
        }
        return result
    }
}
