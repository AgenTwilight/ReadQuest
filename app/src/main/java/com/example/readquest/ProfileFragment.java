package com.example.readquest;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class ProfileFragment extends Fragment {
    private ImageButton btnLogin;
    TextView ProfileName;
    TextView ProfileUsername;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        ProfileName = view.findViewById(R.id.Profile_name);
        ProfileUsername = view.findViewById(R.id.Profile_username);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("preferences", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "");
        String username = sharedPreferences.getString("username", "");

        ProfileName.setText(name);
        ProfileUsername.setText(username);


        btnLogin = view.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getContext().getSharedPreferences("preferencesLogin", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("checkLogin", false);
                editor.apply();

                Intent toLogin = new Intent(getContext(), LoginActivity.class);
                startActivity(toLogin);
                getActivity().finish();
            }
        });
        return view;
    }
}