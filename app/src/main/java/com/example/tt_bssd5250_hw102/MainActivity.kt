package com.example.tt_bssd5250_hw102

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class MainActivity : AppCompatActivity() {
    private val STEP_TAG:String = "step_tag"
    private val PIANO_TAG:String = "piano_tag"
    private val MELODY_TAG:String = "melody_tag"
    private val LLID:Int = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val ll = LinearLayoutCompat(this).apply {
            orientation = LinearLayoutCompat.VERTICAL
            layoutParams = LinearLayoutCompat.LayoutParams(
                LinearLayoutCompat.LayoutParams.MATCH_PARENT,
                LinearLayoutCompat.LayoutParams.MATCH_PARENT
            )
            id = LLID
        }
        setContentView(ll)

        if (savedInstanceState == null){
            supportFragmentManager.commit{
                replace(ll.id, AudioFragment.newInstance(R.raw.step, "Step.wav"), STEP_TAG)
                replace(ll.id, AudioFragment.newInstance(R.raw.piano, "Piano.wav"), PIANO_TAG)
                replace(ll.id, AudioFragment.newInstance(R.raw.melody, "Melody.wav"), MELODY_TAG)
            }
        } else {
            val stepFragment = supportFragmentManager.findFragmentByTag(STEP_TAG) as AudioFragment
            supportFragmentManager.commit{
                replace(ll.id, stepFragment, STEP_TAG)
            }
            val pianoFragment = supportFragmentManager.findFragmentByTag(PIANO_TAG) as AudioFragment
            supportFragmentManager.commit{
                replace(ll.id, pianoFragment, PIANO_TAG)
            }
            val melodyFragment = supportFragmentManager.findFragmentByTag(MELODY_TAG) as AudioFragment
            supportFragmentManager.commit{
                replace(ll.id, melodyFragment, MELODY_TAG)
            }
        }
    }
}