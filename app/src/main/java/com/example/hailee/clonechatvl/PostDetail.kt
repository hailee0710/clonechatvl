package com.example.hailee.clonechatvl


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pierfrancescosoffritti.youtubeplayer.player.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayer
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayerInitListener
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayerView
import kotlinx.android.synthetic.main.fragment_post_detail.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class PostDetail : Fragment() {

    var youtubePlayer : YouTubePlayer? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        youtube_player_view.initialize(object : YouTubePlayerInitListener {
            override fun onInitSuccess(initializedYouTubePlayer : YouTubePlayer?) {
                youtubePlayer = initializedYouTubePlayer
                initializedYouTubePlayer?.addListener(object : AbstractYouTubePlayerListener(){
                    override fun onReady() {
                        initializedYouTubePlayer.loadVideo("6JYIGclVQdw", 0F)
                    }
                })
            }
        }, true)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post_detail, container, false)


    }

    override fun onDestroy() {
        super.onDestroy()

        youtube_player_view.release()
    }


}
