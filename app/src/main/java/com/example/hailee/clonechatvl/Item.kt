package com.example.hailee.clonechatvl


/**
 * Created by hailee on 03/10/17.
 */
data class Item(var PID: Int,
                var USERID: Int,
                var story: String,
                var content: String,
                var tags: String,
                var source: String,
                var nsfw: Int,
                //var pic: Int,
                var youtube_key: String,
                var mecloud_key: String,
                var url: String,
                var time_added: Long,
                var date_added: String,
                var active: Int,
                var phase: Int,
                var favclicks: Int,
                var time_update: Long,
                var mod_yes: Int,
                var mod_no: Int,
                var pip: String,
                var pip2: String?,
                var unfavclick: Int,
                var fix: Int,
                var short: String,
                var likeclicks: Int,
                var shareclicks: Int,
                var views: Int,
                var comments: Int,
                var fullname : String,
                var ttime_text : String


                ) {
}