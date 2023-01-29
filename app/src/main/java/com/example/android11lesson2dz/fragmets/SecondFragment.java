package com.example.android11lesson2dz.fragmets;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android11lesson2dz.R;

public class SecondFragment extends Fragment {

    private TextView tvGo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize(view);
        setupListener();
    }

    private void initialize(View view) {
        tvGo = view.findViewById(R.id.tv_go);
    }

    private void setupListener() {
        tvGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_view, new ThirdFragment())
                        .addToBackStack("SecondFragment")
                        .commit();
            }
        });
    }
}