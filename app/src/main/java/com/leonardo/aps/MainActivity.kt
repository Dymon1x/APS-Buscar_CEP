package com.leonardo.aps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.leonardo.aps.databinding.ActivityMainBinding
import com.leonardo.aps.fragments.Communicator
import com.leonardo.aps.fragments.FragmentDetails
import com.leonardo.aps.fragments.FragmentHome
import com.leonardo.aps.webservices.serviceWEB

@Suppress("CAST_NEVER_SUCCEEDS")
class MainActivity : AppCompatActivity() {
    
    private lateinit var bind: ActivityMainBinding
    var searchText : String = ""


    private val viewModel by viewModels<HomeViewModel>{
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelCLass: Class<T>): T {
                return HomeViewModel(serviceWEB) as T
            }
        }
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

/*        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)*/

/*        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        setupActionBarWithNavController(navController)*/

/*
        bind.btnSearch.setOnClickListener {
            val searchAdress = bind.editSearch.text

            val intent = Intent(this, DetailsActivity::class.java).apply {
                putExtra("CEP", searchAdress)
            }
            startActivity(intent)
        }
*/
/*
        val fragHome = FragmentHome()
        supportFragmentManager.beginTransaction().replace(R.id.content_id, fragHome).commit()
*/

        bind.textSearchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                searchText = query
                goFragDetails()
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                searchText = newText
                return false
            }
        })
            }


    private fun goFragDetails(){
        val frag = FragmentDetails.newInstance()
        val bundle = Bundle()
        bundle.putString("search", searchText)
        frag.arguments = bundle

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragSearch, frag)
            commit()
        }
    }


/*    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }*/

}
