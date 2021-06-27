package com.example.onlinebet.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.onlinebet.R;
import com.example.onlinebet.models.User;
import com.example.onlinebet.stepper.LoginInformationFragment;
import com.example.onlinebet.stepper.PersonalInformationFragment;
import com.example.onlinebet.stepper.RegisterValidationFragment;
import com.shuhart.stepview.StepView;

public class RegisterActivity extends AppCompatActivity {
    User user = new User();
    StepView stepView;
    TextView stepTextView;
    TextView stepContentTextView;

    int stepIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        stepView = findViewById(R.id.step_view);
        stepView.getState()
                .animationType(StepView.ANIMATION_ALL)
                .stepsNumber(3)
                .animationDuration(getResources().getInteger(android.R.integer.config_shortAnimTime))
                .commit();

        if (savedInstanceState == null) {
            changeFragment(PersonalInformationFragment.class);
        }
    }

    public void nextStep() {
        stepIndex++;
        goToStep();
    }

    public void prevStep() {
        stepIndex--;
        goToStep();
    }

    public void goToStep() {
        switch (stepIndex) {
            case 1:
                changeFragment(LoginInformationFragment.class);
                break;
            /*case 2:
                changeFragment(RegisterValidationFragment.class);
                break; */
            default:
                changeFragment(RegisterValidationFragment.class);
                break;

        }
        stepView.go(stepIndex, true);
    }

    private void changeFragment(Class classe) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container_view, classe, null)
                .commit();
    }

    public User getUser() {
        return user;
    }
}