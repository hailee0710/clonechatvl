/*
package com.example.hailee.clonechatvl

import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import android.util.Log
import android.widget.ProgressBar
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.ProtocolException
import java.net.URL


import kotlin.collections.ArrayList

*/
/**
 * Created by hailee on 03/10/17.
 *//*

*/
/*var arrayPost: ArrayList<Item> = ArrayList()
var next_time: String = ""*//*



class ReadContent: AsyncTask<String, Void, String>() {


    override fun doInBackground(vararg params: String?): String? {
        var content: StringBuilder = StringBuilder()
        try {

            val url: URL = URL(params[0])
            val urlconnection: HttpURLConnection = url.openConnection() as HttpURLConnection
            val statusCode: Int = urlconnection.getResponseCode()
            val inputstreamreader: InputStreamReader = InputStreamReader(urlconnection.inputStream)
            val bufferedreader: BufferedReader = BufferedReader(inputstreamreader)


            if (statusCode == 200) {
                var line: String? = ""

                do {
                    line = bufferedreader.readLine()
                    if (line != null) {
                        content.append(line)
                    }
                } while (line != null)

                bufferedreader.close()
            }
        } catch (e: Exception) {
            Log.d("aaa", e.toString())
        } catch (e: ProtocolException) {
            e.printStackTrace()
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return content.toString()
    }
    //Lấy data từ JSON Object và load vào Object Item.
    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)

        try {


                var objectPosts: JSONObject = JSONObject(result)
                next_time = objectPosts.getString("next_time")
                var jsonArray: JSONArray = objectPosts.getJSONArray("posts")

                var PID: Int
                var USERID: Int
                var story: String
                var content: String?
                var tags: String?
                var source: String?
                var nsfw: Int
                //var pic: Int?
                var youtube_key: String
                var mecloud_key: String?
                var url: String
                var time_added: Long
                var date_added: String
                var active: Int
                var phase: Int
                var favclicks: Int
                var time_update: Long
                var mod_yes: Int
                var mod_no: Int
                var pip: String
                var pip2: String?
                var unfavclick: Int
                var fix: Int
                var short: String
                var likeclicks: Int
                var shareclicks: Int
                var views: Int
                var comments: Int
                var fullname: String
                var ttime_text: String

                for (i in 0..jsonArray.length() - 1) {
                    var post: JSONObject = jsonArray.getJSONObject(i)
                    PID = post.getInt("PID")
                    USERID = post.getInt("USERID")
                    story = post.getString("story")
                    content = post.getString("content")
                    tags = post.getString("tags")
                    source = post.getString("source")
                    nsfw = post.getInt("nsfw")
                    //pic = post.getInt("pic")
                    youtube_key = post.getString("youtube_key")
                    mecloud_key = post.getString("mecloud_key")
                    url = post.getString("url")
                    time_added = post.getLong("time_added")
                    date_added = post.getString("date_added")
                    active = post.getInt("active")
                    phase = post.getInt("phase")
                    favclicks = post.getInt("favclicks")
                    time_update = post.getLong("time_update")
                    mod_yes = post.getInt("mod_yes")
                    mod_no = post.getInt("mod_no")
                    pip = post.getString("pip")
                    pip2 = post.getString("pip2")
                    unfavclick = post.getInt("unfavclicks")
                    fix = post.getInt("fix")
                    short = post.getString("short")
                    likeclicks = post.getInt("likeclicks")
                    shareclicks = post.getInt("shareclicks")
                    views = post.getInt("views")
                    comments = post.getInt("comments")
                    fullname = post.getString("fullname")
                    ttime_text = post.getString("ttime_text")

                    arrayPost.add(Item(PID,
                            USERID,
                            story,
                            content,
                            tags,
                            source,
                            nsfw,
                            //pic,
                            youtube_key,
                            mecloud_key,
                            url,
                            time_added,
                            date_added,
                            active,
                            phase,
                            favclicks,
                            time_update,
                            mod_yes,
                            mod_no,
                            pip,
                            pip2,
                            unfavclick,
                            fix,
                            short,
                            likeclicks,
                            shareclicks,
                            views,
                            comments,
                            fullname,
                            ttime_text))


                }


                customadapter?.notifyDataSetChanged()
           // }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

}


*/
