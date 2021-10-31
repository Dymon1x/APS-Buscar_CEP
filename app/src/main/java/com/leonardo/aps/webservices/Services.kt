package com.leonardo.aps.webservices

import com.leonardo.aps.model.CEP
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface Services {
    @GET(value = "cep/v1/{cep}")
    suspend fun getInfoCEP(
        @Path("cep")name : String
    ): CEP

}

const val services = "https://brasilapi.com.br/api/"

val getService: Retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(services)
    .build()

val serviceWEB: Services = getService.create(Services::class.java)







