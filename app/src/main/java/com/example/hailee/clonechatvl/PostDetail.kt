package com.example.hailee.clonechatvl


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.*
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;
import kotlinx.android.synthetic.main.fragment_post_detail.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class PostDetail : YouTubePlayerSupportFragment() {

    private var activePlayer : YouTubePlayer? = null

    fun newInstance(url : String) : PostDetail{
        var postDetail : PostDetail = PostDetail()

        var bundle : Bundle = Bundle()
        bundle.putString("url", url)

        postDetail.setArguments(bundle)

        postDetail.init()

        return postDetail
    }

    private fun init(){
        initialize("AIzaSyCORYM4N7aUrjXIzUj3yEg8EIMkSWWLLNE", object: OnInitializedListener{
            override fun onInitializationSuccess(p0: Provider?, player: YouTubePlayer?, wasRestored: Boolean) {
                activePlayer = player
                activePlayer?.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT)
                activePlayer?.setOnFullscreenListener { b -> false }

                if (!wasRestored) {
                    activePlayer?.loadVideo(getArguments().getString("url"), 0)

                }
            }

            override fun onInitializationFailure(p0: Provider?, p1: YouTubeInitializationResult?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }

    override fun onDestroy() {
        activePlayer?.release()
        super.onDestroy()
    }


}

