package com.example.onlinebet.stepper;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.onlinebet.R;
import com.example.onlinebet.activities.RegisterActivity;

public class RegisterValidationFragment extends Fragment {

    TextView name;
    TextView birth_date;
    TextView address;
    TextView email;
    TextView phone;
    TextView username;



    public RegisterValidationFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register_validation, container, false);
        RegisterActivity registerActivity = (RegisterActivity) getActivity();
        name = (TextView) view.findViewById(R.id.name);
        name.setText(registerActivity.getUser().getName());
        birth_date = (TextView) view.findViewById(R.id.birth_date);
        birth_date.setText(registerActivity.getUser().getBirth_date());
        address = (TextView) view.findViewById(R.id.address);
        address.setText(registerActivity.getUser().getAddress());
        email = (TextView) view.findViewById(R.id.email);
        email.setText(registerActivity.getUser().getEmail());
        phone = (TextView) view.findViewById(R.id.phone);
        phone.setText(registerActivity.getUser().getPhone());
        username = (TextView) view.findViewById(R.id.username);
        username.setText(registerActivity.getUser().getUsername());


        return  view;
    }
}