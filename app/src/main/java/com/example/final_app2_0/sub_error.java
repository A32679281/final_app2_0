package com.example.final_app2_0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link sub_error#newInstance} factory method to
 * create an instance of this fragment.
 */
public class sub_error extends Fragment implements View.OnClickListener {


    ImageButton btn;

    private MediaPlayer mediaPlayer;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public sub_error() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment4.
     */
    // TODO: Rename and change types and number of parameters
    public static sub_error newInstance(String param1, String param2) {
        sub_error fragment = new sub_error();
        Bundle args = new Bundle();


        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }




    }

    private void playMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.woodfish);
        mediaPlayer.start();
    }
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.sub_error, container, false);

        btn = view.findViewById(R.id.knock1);
        btn.setOnClickListener(this);


        return view;

    }

    @Override
    public void onClick(View v) {

        Vibrator vb = (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);
        vb.vibrate(VibrationEffect.EFFECT_HEAVY_CLICK);
        //VibrationEffect ve = VibrationEffect.createOneShot(1000, VibrationEffect.EFFECT_HEAVY_CLICK);
        //vb.vibrate(VibrationEffect.createOneShot(1000, VibrationEffect.EFFECT_HEAVY_CLICK));
        vb.cancel();
        btn.setImageResource(R.drawable.wood_fish_down);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                btn.setImageResource(R.drawable.wood_fish_on);
            }
        }, 100);

        playMusic();


    }
}