package com.example.healthhealth;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        GifImageView gif;
        Random r;
        r = new Random();
         gif = (GifImageView) getView().findViewById(R.id.gifImageView2);
        Integer [] images={R.drawable.gif1,R.drawable.gif2,R.drawable.gif3,R.drawable.gif4};
        gif.setImageResource(images[r.nextInt(images.length)]);

        TextView age,callories,sleep,steps;

        age=(TextView) getView().findViewById(R.id.age);
        callories=(TextView) getView().findViewById(R.id.callories);
        sleep=(TextView) getView().findViewById(R.id.sleep);
        steps=(TextView) getView().findViewById(R.id.steps);



        int ageget  = Integer.parseInt(getActivity().getIntent().getExtras().getString("age"));
        int weight = Integer.parseInt(getActivity().getIntent().getExtras().getString("weight"));
        int height = Integer.parseInt(getActivity().getIntent().getExtras().getString("height"));
        Double cal = 10*weight+6.25*height-5*ageget+5+638.4;
        String username = getActivity().getIntent().getExtras().getString("username");
        String lastname =getActivity().getIntent().getExtras().getString("lastname");
        callories.setText("Callories "+cal);
        if(ageget>0 && ageget<=11){
            steps.setText("Steps 13000");
            sleep.setText("Sleep 9h - 12h");
        }else if(ageget>11 && ageget<=19){
            steps.setText("Steps 10000");
            sleep.setText("Sleep 8h - 10h");

        }else if (ageget>19&& ageget<=65){
            steps.setText("Steps 7000");
            sleep.setText("Sleep 7h - 9h");

        }
        TextView txtv = (TextView) getView().findViewById(R.id.txtv);
        txtv.setText(username);
        age.setText(ageget+" years old");

       txtv.setText(username);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}