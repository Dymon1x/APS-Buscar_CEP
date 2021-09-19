package com.leonardo.aps.model

import com.google.gson.annotations.SerializedName
import java.util.ArrayList

class ResultCEP(
    @SerializedName("result") val result: List<CEP>
)