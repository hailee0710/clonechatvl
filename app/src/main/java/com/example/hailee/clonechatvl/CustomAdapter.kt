package com.example.hailee.clonechatvl

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by hailee on 03/10/17.
 */
class CustomAdapter(var context: Context, var mangmonan : ArrayList<MonAn>) : BaseAdapter(){
    class ViewHolder(row : View){
        var textviewitem: TextView
        var imageviewitem : ImageView

        init {
            textviewitem = row.findViewById<TextView>(R.id.textviewmonan)
            imageviewitem = row.findViewById<ImageView>(R.id.imageviewmonan)
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
        viewholder.textviewmonan.text = monan.ten
        viewholder.imageviewmonan.setImageResource(monan.hinhanh)
        return view as View
    }

    override fun getItem(position: Int): Any {
        return mangmonan.get(position)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return mangmonan.size
    }
}