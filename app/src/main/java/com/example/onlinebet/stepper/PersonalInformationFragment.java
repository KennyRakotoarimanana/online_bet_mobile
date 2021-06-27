 package com.example.onlinebet.stepper;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.onlinebet.R;
import com.example.onlinebet.activities.RegisterActivity;
import com.example.onlinebet.models.User;

import java.util.Calendar;

public class PersonalInformationFragment extends Fragment {
    DatePickerDialog picker;
    EditText birth_date;
    EditText name;
    EditText address;
    EditText email;
    EditText phone;
    Button button_next;

    public PersonalInformationFragment() {
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
        View view = inflater.inflate(R.layout.fragment_personal_information, container, false);
        RegisterActivity registerActivity = ((RegisterActivity) getActivity());
        name = (EditText) view.findViewById(R.id.name);
        address = (EditText) view.findViewById(R.id.address);
        email = (EditText) view.findViewById(R.id.email);
        phone = (EditText) view.findViewById(R.id.phone);
        birth_date = (EditText) view.findViewById(R.id.birth_date);
        birth_date.setInputType(InputType.TYPE_NULL);
        button_next = (Button) view.findViewById(R.id.next_button);
        button_next.setEnabled(registerActivity.getUser().getName() != null);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerActivity.getUser().setName(name.getText().toString());
                registerActivity.getUser().setBirth_date(birth_date.getText().toString());
                registerActivity.getUser().setAddress(address.getText().toString());
                registerActivity.getUser().setEmail(email.getText().toString());
                registerActivity.getUser().setPhone(phone.getText().toString());
                registerActivity.nextStep();

            }
        });
        birth_date.setOnClickListener(
                new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          final Calendar cldr = Calendar.getInstance();
                          int day = cldr.get(Calendar.DAY_OF_MONTH);
                          int month = cldr.get(Calendar.MONTH);
                          int year = cldr.get(Calendar.YEAR);
                          // date picker dialog
                          picker = new DatePickerDialog(getContext(),
                                  new DatePickerDialog.OnDateSetListener() {
                                      @Override
                                      public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                          birth_date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                                      }
                                  }, year, month, day);
                          picker.getDatePicker().setCalendarViewShown(false);
                          picker.show();
                      }
                  }

        );
        initForm();

        return view;
    }

    private void initForm() {
        User user = ((RegisterActivity) getActivity()).getUser();
        name.setText(user.getName());
        birth_date.setText(user.getBirth_date());
        address.setText(user.getAddress());
        phone.setText(user.getPhone());
        email.setText(user.getEmail());
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
                for(EditText editText: new EditText[] {name, address, birth_date, email, phone}) {
                    if (editText.getText().toString().trim().length() == 0) {
                        button_next.setEnabled(false);
                        return;
                    }
                    button_next.setEnabled(true);
                }
            }
        };
        name.addTextChangedListener(textWatcher);
        address.addTextChangedListener(textWatcher);
        birth_date.addTextChangedListener(textWatcher);
        email.addTextChangedListener(textWatcher);
        phone.addTextChangedListener(textWatcher);
    }
}