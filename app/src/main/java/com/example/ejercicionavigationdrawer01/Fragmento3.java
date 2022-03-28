package com.example.ejercicionavigationdrawer01;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Fragmento3 extends Fragment {

    Button btnEven;

    public Fragmento3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragmento3, container, false);

        btnEven = v.findViewById(R.id.btnEvent);

        btnEven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Event", Toast.LENGTH_SHORT).show();
            }
        });

        // Inflate the layout for this fragment
        return v;
    }
}