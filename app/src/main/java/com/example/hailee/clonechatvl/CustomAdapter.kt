package com.example.hailee.clonechatvl

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

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

       /* var currenttime : Long = System.currentTimeMillis()
        var timeuploaded : Long =  (currenttime/1000) - item.time_added
        var converttime : Long = TimeUnit.MILLISECONDS.toMinutes(timeuploaded)*/


        viewholder.textviewStory.text = item.story
        viewholder.textviewAuthor.text = "đăng bởi " + Html.fromHtml(item.fullname).toString()   + "  " + item.ttime_text
        Picasso.with(context)
                .load("http://img.youtube.com/vi/${item.youtube_key}/0.jpg")
                .resize(1000, 700)
                .centerCrop()
                .into(viewholder.imageviewContent)
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


