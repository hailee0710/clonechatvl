package com.example.hailee.clonechatvl

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.Date
import java.util.concurrent.TimeUnit

/**
 * Created by hailee on 03/10/17.
 */
class CustomAdapter(var context: Context, var arrayItem : ArrayList<Item>) : BaseAdapter(){
    class ViewHolder(row : View){
        var textviewStory: TextView
        var textviewAuthor : TextView
        var imageviewContent : ImageView
        var textviewView : TextView

        init {
            textviewStory = row.findViewById<TextView>(R.id.tvStory)
            textviewAuthor = row.findViewById<TextView>(R.id.tvAuthor)
            imageviewContent = row.findViewById<ImageView>(R.id.imContent)
            textviewView = row.findViewById<TextView>(R.id.tvView)

        }
    }
    override fun getView(position: Int, convertview: View?, p2: ViewGroup?): View {
        var view: View?
        var viewholder: ViewHolder

        if (convertview == null){
            var layoutinflater: LayoutInflater = LayoutInflater.from(context)
            view = layoutinflater.inflate(R.layout.item, null)
            viewholder = ViewHolder(view)
            view.tag = viewholder
        }else{
            view = convertview
            viewholder = convertview.tag as ViewHolder
        }

        var item : Item = getItem(position) as Item

        var currenttime : Long = System.currentTimeMillis()/1000
        var timeuploaded : Long = currenttime - item.time_added
        var converttime : Long = TimeUnit.MILLISECONDS.toMinutes(timeuploaded)
        Toast.makeText(this.context, "" + converttime, Toast.LENGTH_LONG )

        viewholder.textviewStory.text = item.story
        viewholder.textviewAuthor.text = "bởi " + item.USERID + " " + converttime + " phút trước"
        viewholder.imageviewContent.setImageResource(R.drawable.abc_btn_radio_to_on_mtrl_015)
        viewholder.textviewView.text = "Lượt xem: " + item.views + " Thích: " + item.favclicks + " Comments: " + item.comments
        return view as View
    }

    override fun getItem(position: Int): Any {
        return arrayItem.get(position)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return arrayItem.size
    }
}


