package com.leonardo.aps

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.*
import com.leonardo.aps.databinding.ActivityDetailsBinding
import com.leonardo.aps.webservices.serviceWEB

class DetailsActivity : AppCompatActivity() {

    private lateinit var bind: ActivityDetailsBinding

    @Suppress("UNCHECKED_CAST")
    private val viewModel by viewModels<HomeViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelCLass: Class<T>): T {
                return HomeViewModel(serviceWEB) as T
            }
        }
    }

/*    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_details)

        bind = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(bind.root)

        //val cep = intent.getStringExtra("CEP") as CEP
        val cep = intent.getStringExtra("CEP")
        

        //viewModel.getCEP(cep)


        bind.resCep.text = cep
        bind.resRua.text = cep
        *//*   bind.resEstado.text = cep
           bind.resCidade.text = cep
           bind.resBairro.text = cep
           bind.resLongi.text = cep
           bind.resLati.text = cep*//*


    }*/
}