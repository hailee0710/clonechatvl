package com.example.hailee.clonechatvl


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jaedongchicken.ytplayer.JLog
import com.jaedongchicken.ytplayer.YoutubePlayerView
import com.jaedongchicken.ytplayer.model.YTParams
import com.pierfrancescosoffritti.youtubeplayer.player.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayer
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayerInitListener
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayerView
import kotlinx.android.synthetic.main.fragment_post_detail.*
import android.R.attr.duration
import android.content.Context
import android.support.v4.app.FragmentActivity
import android.widget.Toast


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class PostDetail : Fragment() {

    private var youTubePlayer: YouTubePlayer? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        youtube_player_view.initialize(object: YouTubePlayerInitListener {
            override fun onInitSuccess(initializedYouTubePlayer: YouTubePlayer?) {

            youTubePlayer = initializedYouTubePlayer!!

            initializedYouTubePlayer.addListener(object : AbstractYouTubePlayerListener() {
                override fun onReady() {
                    initializedYouTubePlayer.loadVideo("6JYIGclVQdw", 0f)
                }

            })
        }}, true)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post_detail, container, false)


    }


    override fun onDestroy() {
        super.onDestroy()

        youtube_player_view.release()
    }



}
