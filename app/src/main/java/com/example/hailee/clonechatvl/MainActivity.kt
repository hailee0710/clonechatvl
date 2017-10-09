package com.example.hailee.clonechatvl


import android.app.Dialog
import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.util.Log

import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {

    val urlGetData : String = "http://chatvl.com/api/trending.php"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        ReadContent().execute(urlGetData)
        lvmain. adapter= CustomAdapter(this, arrayPost)

        swiperefresh.setOnRefreshListener(this)


    }

    override fun onRefresh() {
        swiperefresh.isRefreshing = true

        arrayPost.clear()
        ReadContent().execute(urlGetData)
        customadapter = CustomAdapter(this, arrayPost)
        lvmain. adapter= customadapter

        swiperefresh.isRefreshing = false
    }






}
