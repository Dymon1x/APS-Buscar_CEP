package com.leonardo.aps.model

import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.CoroutineScope
import java.io.Serializable

data class CEP(
    @SerializedName("cep") val cep: String= "",
    @SerializedName("city") var city: String= "",
    @SerializedName("neighborhood") var neighborhood: String= "",
    @SerializedName("state") var state: String= "",
    @SerializedName("street") var street: String= "",
    @SerializedName("service") var service: String= ""
): Serializable

