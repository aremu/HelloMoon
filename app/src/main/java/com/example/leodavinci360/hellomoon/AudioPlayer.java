package com.example.leodavinci360.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {
    private MediaPlayer mPlayer;
    private int position = 0;

    // releases mediaplayer once done with it
    public void stop() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }

    // pauses the mediaplayer and gets it's current postion so you can resume it later
    public void pause() {
        mPlayer.pause();
        position = mPlayer.getCurrentPosition();
    }

    public void play(Context c) {
        stop();

        mPlayer = MediaPlayer.create(c, R.raw.one_small_step);

        // stops the MediaPlayer once the song is done
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });

        // starts the mediaplayer and resumes it from where it left off.
        mPlayer.seekTo(position);
        mPlayer.start();

    }
}
