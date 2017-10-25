package com.example.hailee.clonechatvl

import android.os.AsyncTask
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.widget.SwipeRefreshLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


var customadapter: CustomAdapter? = null


class MainActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {

    val urlTrending : String = "http://chatvl.com/api/trending.php?time="

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Khoi tao adapter
        customadapter = CustomAdapter(this, arrayPost)
        lvmain. adapter= customadapter

        //Lay data
        ReadContent().execute(urlTrending)

        //Đăng ký sự kiện Swipe to refresh
        swiperefresh.setOnRefreshListener(this)

        //Su kien item click listener
        lvmain.setOnItemClickListener { parent,
                                        view,
                                        position,
                                        id
            ->  Toast.makeText(this, "Vi tri " + arrayPost.get(position).PID, Toast.LENGTH_SHORT).show()}


        //su kien loadmore
        lvmain.setOnLoadMoreListener {
                LoadDataTask().execute()
        }

    }

    override fun onRefresh() {
        swiperefresh.isRefreshing = true

        arrayPost.clear()
        ReadContent().execute(urlTrending)
        customadapter?.notifyDataSetChanged()

        swiperefresh.isRefreshing = false
    }

    private inner class LoadDataTask : AsyncTask<Void?, Void?, Void?>() {

        override fun doInBackground(vararg params: Void?): Void? {
            // Simulates a background task
            if(isCancelled){
                return null
            }
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
            }


            return null

        }

        override fun onPostExecute(result: Void?) {
           // Toast.makeText(this@MainActivity, ""+urlTrending+ next_time, Toast.LENGTH_SHORT).show()

            ReadContent().execute(urlTrending+ next_time)

            //Toast.makeText(this@MainActivity, "Loadmore completed!" , Toast.LENGTH_SHORT).show()

            // We need notify the adapter that the data have been changed
            customadapter?.notifyDataSetChanged()

            // Call onLoadMoreComplete when the LoadMore task, has finished
            lvmain.onLoadMoreComplete()

            super.onPostExecute(result)
        }

        override fun onCancelled() {
            // Notify the loading more operation has finished
            lvmain.onLoadMoreComplete()
        }
    }




}

