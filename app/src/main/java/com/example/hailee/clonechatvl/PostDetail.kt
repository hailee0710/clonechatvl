package com.example.hailee.clonechatvl


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast


import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayer.Provider
import com.google.android.youtube.player.YouTubePlayerView
import kotlinx.android.synthetic.main.fragment_post_detail.*
import com.google.android.youtube.player.internal.i
import com.google.android.youtube.player.YouTubePlayerFragment
import com.google.android.youtube.player.YouTubePlayerSupportFragment






// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class PostDetail : Fragment(){


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post_detail, container, false)

    }

    private fun initYouTube() : YouTubePlayer.OnInitializedListener {

        val youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance()
        val transaction = childFragmentManager.beginTransaction()
        transaction.add(R.id.youtube_frag, youTubePlayerFragment).commit()

        if (youtube_frag == null) {

            (object : YouTubePlayer.OnInitializedListener {
                override fun onInitializationSuccess(provider: YouTubePlayer.Provider, player: YouTubePlayer, wasRestored: Boolean) {

                    // Don't do full screen
                    player.setFullscreen(false)
                    if (!wasRestored) {
                        player.cueVideo("fhWaJi1Hsfo")
                    }
                }

                override fun onInitializationFailure(provider: YouTubePlayer.Provider, youTubeInitializationResult: YouTubeInitializationResult) {

                    if (youTubeInitializationResult.isUserRecoverableError) {
                        youTubeInitializationResult.getErrorDialog(activity, REQuest).show()
                    } else {
                        Toast.makeText(activity, youTubeInitializationResult.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }

}


