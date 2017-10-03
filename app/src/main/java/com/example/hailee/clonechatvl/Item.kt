package com.example.hailee.clonechatvl

import java.net.URL
import java.sql.Timestamp
import java.util.*

/**
 * Created by hailee on 03/10/17.
 */
data class Item(var PID: Int,
                var USERID: Int,
                var story: String,
                var content: String,
                var tags: String,
                var source: String,
                var nsfw: Boolean,
                var pic: Int,
                var youtube_key: String,
                var mecloud_key: String,
                var url: URL,
                var timeadded: Timestamp,
                var dateadded: Date,
                var active: Boolean,
                var phase: Int,
                var favclicks: Int,
                var timeupdate: Timestamp,
                var mod_yes: Boolean,
                var mod_no: Boolean,
                var pip: URL,
                var pip2: URL?,
                var unfavclick: Int,
                var fix: Boolean,
                var short: String,
                var likeclicks: Int,
                var shareclicks: Int,
                var views: Int,
                var comments: Int


                ) {
}