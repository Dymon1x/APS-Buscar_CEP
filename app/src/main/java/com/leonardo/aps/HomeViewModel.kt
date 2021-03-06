package com.leonardo.aps

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leonardo.aps.model.CEP
import com.leonardo.aps.webservices.Services
import kotlinx.coroutines.launch

class HomeViewModel(private val services: Services) : ViewModel() {

    var homeView = MutableLiveData<CEP>()


    fun getCEP(cep: String) {
        viewModelScope.launch {
            homeView.value = services.getInfoCEP(cep).apply {

                    this.street = cep.let { services.getInfoCEP(it).street }
                    this.state = cep.let { services.getInfoCEP(it).state }
                    this.city = cep.let { services.getInfoCEP(it).city }
                    this.neighborhood = cep.let { services.getInfoCEP(it).neighborhood }
                    this.service = cep.let { services.getInfoCEP(it).service }

            }

        }
    }
}

