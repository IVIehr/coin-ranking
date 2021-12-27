package com.application.coin_ranking.features.country
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.application.coin_ranking.data.model.Country
import com.application.coin_ranking.data.repo.CountryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CountryViewModel : ViewModel() {
    private val _countryLiveData = MutableLiveData<List<Country>>()
    val countryLiveData: LiveData<List<Country>> get() = _countryLiveData
    private val repository = CountryRepository()

    fun returnFilteredList() {
        viewModelScope.launch (Dispatchers.IO){
            _countryLiveData.postValue(repository.sendData())
        }
    }


}