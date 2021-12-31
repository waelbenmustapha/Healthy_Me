package com.example.healthhealth;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Diet#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Diet extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Diet() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Diet.
     */
    // TODO: Rename and change types and number of parameters
    public static Diet newInstance(String param1, String param2) {
        Diet fragment = new Diet();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        CardView diet2000,diet1500,diet1000,dietcostum;

        MyListData[] myListData = new MyListData[] {
                new MyListData(getContext().getResources().getString(R.string.description2000), R.drawable.diet3,"2000 Calories Diet","#fa5912"),
                new MyListData(getContext().getResources().getString(R.string.description1500),R.drawable.diet2,"1500 Calories Diet","#ff7a6b"),
                new MyListData(getContext().getResources().getString(R.string.description1000),R.drawable.diet1,"1000 Calories Diet","#ffa831"),
                new MyListData(getContext().getResources().getString(R.string.descriptionCostum), R.drawable.custom,"Custom diet","#1cc08e"),
                new MyListData(getContext().getResources().getString(R.string.descriptionCostum), R.drawable.custom,"Custom diet","#1cc08e"),
        };

        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerView);
        MyListAdapter adapter = new MyListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
       /* diet2000 = (CardView) getView().findViewById(R.id.diet2000);
        diet1500 = (CardView) getView().findViewById(R.id.diet1500);
        diet1000 = (CardView) getView().findViewById(R.id.diet1000);
        dietcostum = (CardView) getView().findViewById(R.id.dietcostum);
        diet2000.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "2000 callories clicked", Toast.LENGTH_SHORT).show();
            }
        });

        diet1500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "1500 callories clicked", Toast.LENGTH_SHORT).show();
            }
        });

        diet1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "1000 callories clicked", Toast.LENGTH_SHORT).show();
            }
        });

        dietcostum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "costum diet clicked", Toast.LENGTH_SHORT).show();
            }
        });

        String username = getActivity().getIntent().getExtras().getString("username");

*/
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
        return inflater.inflate(R.layout.fragment_diet, container, false);
    }
}