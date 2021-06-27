package com.example.onlinebet.stepper;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlinebet.R;
import com.example.onlinebet.activities.RegisterActivity;
import com.example.onlinebet.models.User;

public class LoginInformationFragment extends Fragment {
    EditText username;
    EditText password;
    EditText confirmPassword;

    Button button_prev;
    Button button_next;


    public LoginInformationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_information, container, false);
        RegisterActivity registerActivity = ((RegisterActivity) getActivity());
        username = (EditText) view.findViewById(R.id.username);
        password = (EditText) view.findViewById(R.id.password);
        confirmPassword = (EditText) view.findViewById(R.id.confirm_password);
        button_prev = (Button) view.findViewById(R.id.previous_button);
        button_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillUserInformation(registerActivity.getUser());
                registerActivity.prevStep();
            }
        });
        button_next = (Button) view.findViewById(R.id.next_button);
        button_next.setEnabled(false);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password.getText().toString().compareTo(confirmPassword.getText().toString()) != 0) {
                    Toast toast = Toast.makeText(getContext(), "Passwords not identical", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                fillUserInformation(registerActivity.getUser());
                registerActivity.nextStep();

            }
        });
        initForm();

        return view;
    }

    public void fillUserInformation(User user) {
        user.setUsername(username.getText().toString());
        user.setPassword(password.getText().toString());
    }

    public void initForm() {
        User user = ((RegisterActivity) getActivity()).getUser();
        username.setText(user.getUsername());
        password.setText(user.getPassword());

        addValidator();
    }

    private void addValidator() {
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                for(EditText editText: new EditText[] {username, password, confirmPassword}) {
                    if (editText.getText().toString().trim().length() == 0) {
                        button_next.setEnabled(false);
                        return;
                    }
                    // button_next.setEnabled(true);
                }
                button_next.setEnabled(true);
            }
        };
        username.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);
        confirmPassword.addTextChangedListener(textWatcher);
    }
}