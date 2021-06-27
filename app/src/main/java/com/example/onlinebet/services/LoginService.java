package com.example.onlinebet.services;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.onlinebet.constants.Constants;
import com.example.onlinebet.models.User;

public class LoginService {
    private SharedPreferences sharedPreferences;

    public LoginService(Context context) {
        sharedPreferences = context.getSharedPreferences(Constants.PREFERENCES, Context.MODE_PRIVATE);
    }

    public boolean isConnected() {
        return sharedPreferences.getLong("ID", 0) != 0;
    }

    public void logout() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("ID");
        editor.remove("EMAIL");
        editor.remove("USERNAME");
        editor.apply();
    }

    public User getUser() {
       User user = new User();

        if (sharedPreferences.getInt("ID", 0) != 0) {
            user.setId(sharedPreferences.getInt("ID", 0));
            user.setEmail(sharedPreferences.getString("EMAIL", null));
            user.setUsername(sharedPreferences.getString("USERNAME", null));

            return user;
        }

        return null;
    }
}
