package com.example.leodavinci360.hellomoon;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;


public class HelloMoonFragment extends Fragment {

    private AudioPlayer mPlayer = new AudioPlayer();
    private Button mPlayButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hello_moon, parent, false);


        mPlayButton = (Button) v.findViewById(R.id.hellomoon_playButton);
        mPlayButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // plays the sound
                if (mPlayButton.getText().equals("Play")) {
                    mPlayer.play(getActivity());
                    mPlayButton.setText("Pause");
                }
                // pauses the sound
                else if (mPlayButton.getText().equals("Pause")) {
                    mPlayer.pause();
                    mPlayButton.setText("Play");
                }
            }

        });
        return v;
    }
}

