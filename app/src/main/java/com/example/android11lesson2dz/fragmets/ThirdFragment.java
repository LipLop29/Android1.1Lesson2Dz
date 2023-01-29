package com.example.android11lesson2dz.fragmets;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.android11lesson2dz.R;


public class ThirdFragment extends Fragment {

    private EditText etLogin, etPsw;
    private Button btnInput;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etLogin = view.findViewById(R.id.et_login);
        etPsw = view.findViewById(R.id.et_psw);
        btnInput = view.findViewById(R.id.btn_input);
        click();
    }

    private void click() {
        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login = etLogin.getText().toString().trim();
                String password = etPsw.getText().toString().trim();

                if (!login.equals("admin") || !password.equals("admin")) {
                    if (!login.equals("admin")) {
                        etLogin.setError("Не правельный логин");
                    }
                    if (!password.equals("admin")) {
                        etPsw.setError("Не правельный пароль");
                    }
                } else {
                    getParentFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container_view, new FirstFragment())
                            .addToBackStack(ThirdFragment.class.getName())
                            .commit();
                }
            }
        });
    }
}