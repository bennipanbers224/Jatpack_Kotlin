package uas2019.develops.stud11417025.testing_jetpack

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.StrictMode
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast



class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel : MainViewModel
    private lateinit var adapter : MainAdapter
    private lateinit var progress:ProgressBar
    private lateinit var recycler:RecyclerView
    private lateinit var gridLayoutManager : GridLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (android.os.Build.VERSION.SDK_INT > 9) {
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }

        gridLayoutManager = GridLayoutManager(applicationContext,3, LinearLayoutManager.VERTICAL, false)
        recycler = findViewById(R.id.recycler)
        progress = findViewById(R.id.progressBar)

        setUpUI()
        setUpViewModel()
        setUpOberserver()
    }
    private fun setUpUI() {
        recycler.layoutManager = gridLayoutManager
        adapter = MainAdapter(this,arrayListOf())
        recycler.adapter = adapter

    }

    private fun setUpOberserver() {
        mainViewModel.getDatas().observe(this, Observer {
            when(it!!.status){
                Status.SUCCESS->{
                    progress.visibility = View.GONE
                    it.data?.let { datas-> renderList(datas) }
                    recycler.visibility = View.VISIBLE
                }
                Status.LOADING->{
                    progress.visibility = View.VISIBLE
                    recycler.visibility = View.GONE
                }
                Status.ERROR->{
                    progress.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun renderList(datas: List<DataModel>) {
        adapter.addData(datas)
        adapter.notifyDataSetChanged()
    }

    private fun setUpViewModel() {
        mainViewModel = ViewModelProviders.of(
            this, ViewModelFactory(ApiHelper(ApiServiceImpl()))
        ).get(MainViewModel::class.java)
    }
}
