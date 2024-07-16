package com.example.recyclercompose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recyclercompose.models.DataModel
import com.example.recyclercompose.network.ApiService
import com.example.recyclercompose.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
class DataViewModel(private val apiService: ApiService = RetrofitInstance.apiService) : ViewModel() {
    val _data = MutableStateFlow<List<DataModel>>(emptyList())
    val data: StateFlow<List<DataModel>> = _data

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = apiService.fetchData()
                _data.value = response
            } catch (e: IOException) {
                // Handle network error
                e.printStackTrace()
            } catch (e: HttpException) {
                // Handle HTTP error (like 404)
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun getItemById(itemId: String): DataModel? {
        return _data.value.find { it.id.toString() == itemId }
    }
}