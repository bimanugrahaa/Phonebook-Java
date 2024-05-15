package com.polytron.phonebook.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import com.polytron.phonebook.R;
import com.polytron.phonebook.databinding.ActivityAddPhonebookBinding;
import com.polytron.phonebook.databinding.ActivityUserDetailPhonebookBinding;
import com.polytron.phonebook.model.Phonebook;
import com.polytron.phonebook.modelview.PhonebookViewModel;

public class UserDetailPhonebookActivity extends AppCompatActivity {

    ActivityUserDetailPhonebookBinding activityUserDetailPhonebookBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityUserDetailPhonebookBinding = ActivityUserDetailPhonebookBinding.inflate(getLayoutInflater());
        View view = activityUserDetailPhonebookBinding.getRoot();
        setContentView(view);

        PhonebookViewModel phonebookViewModel = new PhonebookViewModel(this.getApplication());
        phonebookViewModel.getUserDetail(getIntent().getIntExtra("user_id", 0)).observe(this, phonebook -> {
            activityUserDetailPhonebookBinding.userName.setText(phonebook.getFirstName());
            activityUserDetailPhonebookBinding.primaryNumber.setText(phonebook.getPrimaryPhone());
            activityUserDetailPhonebookBinding.secondaryNumber.setText(phonebook.getSecondaryPhone());
        });
    }
}