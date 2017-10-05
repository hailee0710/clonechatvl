package com.example.hailee.clonechatvl

import android.os.AsyncTask
import android.util.Log
import android.widget.Toast
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.sql.Timestamp
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by hailee on 03/10/17.
 */
public var arrayPost: ArrayList<Item> = ArrayList()

class ReadContent: AsyncTask<String, Void, String>() {


    override fun doInBackground(vararg params: String?): String? {
        var content : StringBuilder = StringBuilder()
        val url : URL = URL(params[0])
        val urlconnection : HttpURLConnection = url.openConnection() as HttpURLConnection
        val inputstreamreader : InputStreamReader = InputStreamReader(urlconnection.inputStream)
        val bufferedreader : BufferedReader = BufferedReader(inputstreamreader)

        try {

            var line : String? = ""

            do {
                line = bufferedreader.readLine()
                if (line != null) {
                    content.append(line)
                }
            }while (line != null)

            bufferedreader.close()

        }catch (e : Exception){
            Log.d("aaa", e.toString())
        }

        return content.toString()
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)

        var objectPosts : JSONObject = JSONObject(result)
        var jsonArray : JSONArray = JSONArray(objectPosts.getJSONArray("posts"))

        var PID: Int
        var USERID: Int
        var story: String
        var content: String?
        var tags: String?
        var source: String?
        var nsfw: Boolean
        var pic: Int?
        var youtube_key: String
        var mecloud_key: String?
        var url: URL
        var timeadded: Timestamp
        var dateadded: Date
        var active: Boolean
        var phase: Int
        var favclicks: Int
        var timeupdate: Timestamp
        var mod_yes: Boolean
        var mod_no: Boolean
        var pip: URL
        var pip2: URL?
        var unfavclick: Int
        var fix: Boolean
        var short: String
        var likeclicks: Int
        var shareclicks: Int
        var views: Int
        var comments: Int

        for (i in 0..jsonArray.length()-1){
            var post : JSONObject = jsonArray.getJSONObject(i)
            PID = post.getInt("PID")
            USERID = post.getInt("USERID")
            story = post.getString("story")
            content = post.getString("content")
            tags = post.getString("tags")
            source = post.getString("source")
            nsfw = post.getBoolean("nsfw")
            pic = post.getInt("pic")
            youtube_key = post.getString("youtube_key")
            mecloud_key = post.getString("mecloud_key")
            url = post.get("url") as URL
            timeadded = post.get("timeadded") as Timestamp
            dateadded = post.get("dateadded") as Date
            active = post.getBoolean("active")
            phase = post.getInt("phase")
            favclicks = post.getInt("favclicks")
            timeupdate = post.get("timeupdate") as Timestamp
            mod_yes = post.getBoolean("mod_yes")
            mod_no = post.getBoolean("mod_no")
            pip = post.get("pip") as URL
            pip2 = post.get("pip2") as URL
            unfavclick = post.getInt("unfavclick")
            fix = post.getBoolean("fix")
            short = post.getString("short")
            likeclicks = post.getInt("likeclicks")
            shareclicks = post.getInt("shareclicks")
            views = post.getInt("views")
            comments = post.getInt("comments")

            arrayPost.add(Item(PID,
                    USERID,
                    story,
                    content,
                    tags,
                    source,
                    nsfw,
                    pic,
                    youtube_key,
                    mecloud_key,
                    url,
                    timeadded,
                    dateadded,
                    active,
                    phase,
                    favclicks,
                    timeupdate,
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
                    comments))


        }



    }

}


