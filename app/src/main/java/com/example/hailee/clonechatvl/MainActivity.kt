package com.example.hailee.clonechatvl

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

var customadapter: CustomAdapter? = null


class MainActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {

    val urlGetData : String = "http://chatvl.com/api/trending.php"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        customadapter = CustomAdapter(this, arrayPost)
        lvmain. adapter= customadapter
        ReadContent().execute(urlGetData)

        Toast.makeText(this, ""+ arrayPost, Toast.LENGTH_LONG).show()

        swiperefresh.setOnRefreshListener(this)


    }

    override fun onRefresh() {
        swiperefresh.isRefreshing = true

        arrayPost.clear()
        ReadContent().execute(urlGetData)
        customadapter?.notifyDataSetChanged()
        Toast.makeText(this, ""+ arrayPost, Toast.LENGTH_LONG).show()

        swiperefresh.isRefreshing = false
    }






}
