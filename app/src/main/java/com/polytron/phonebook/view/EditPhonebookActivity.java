package com.polytron.phonebook.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.polytron.phonebook.R;
import com.polytron.phonebook.databinding.ActivityEditPhonebookBinding;
import com.polytron.phonebook.databinding.ActivityUserDetailPhonebookBinding;
import com.polytron.phonebook.model.Phonebook;
import com.polytron.phonebook.modelview.PhonebookViewModel;

import java.util.ArrayList;

public class EditPhonebookActivity extends AppCompatActivity {

    ActivityEditPhonebookBinding activityEditPhonebookBinding;
    private int user_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityEditPhonebookBinding = ActivityEditPhonebookBinding.inflate(getLayoutInflater());
        View view = activityEditPhonebookBinding.getRoot();
        setContentView(view);

        PhonebookViewModel phonebookViewModel = new PhonebookViewModel(this.getApplication());
        phonebookViewModel.getUserDetail(getIntent().getIntExtra("user_id", 0)).observe(this, phonebook -> {
            user_id = phonebook.getUserId();
            activityEditPhonebookBinding.firstNameEditText.setText(phonebook.getFirstName());
            activityEditPhonebookBinding.middleNameEditText.setText(phonebook.getMiddleName());
            activityEditPhonebookBinding.lastNameEditText.setText(phonebook.getLastName());
            activityEditPhonebookBinding.primaryPhoneEditText.setText(phonebook.getPrimaryPhone());
            activityEditPhonebookBinding.secondaryPhoneEditText.setText(phonebook.getSecondaryPhone());
            activityEditPhonebookBinding.groupsEditText.setText(phonebook.getGroup());
        });

        activityEditPhonebookBinding.buttonSave.setOnClickListener(v -> {
            String first_name = activityEditPhonebookBinding.firstNameEditText.getText().toString();
            String middle_name = activityEditPhonebookBinding.middleNameEditText.getText().toString();
            String last_name = activityEditPhonebookBinding.lastNameEditText.getText().toString();
            String primary_phone = activityEditPhonebookBinding.primaryPhoneEditText.getText().toString();
            String secondary_phone = activityEditPhonebookBinding.secondaryPhoneEditText.getText().toString();
            String group = activityEditPhonebookBinding.groupsEditText.getText().toString();

            if (TextUtils.isEmpty(activityEditPhonebookBinding.firstNameEditText.getText().toString())){
                Toast.makeText(
                        getApplicationContext(),
                        "First Name can not be blank.",
                        Toast.LENGTH_LONG
                ).show();
            } else if (TextUtils.isEmpty(activityEditPhonebookBinding.lastNameEditText.getText().toString())){
                Toast.makeText(
                        getApplicationContext(),
                        "Last Name can not be blank.",
                        Toast.LENGTH_LONG
                ).show();
            } else if (TextUtils.isEmpty(activityEditPhonebookBinding.primaryPhoneEditText.getText().toString())){
                Toast.makeText(
                        getApplicationContext(),
                        "Primary phone can not be blank.",
                        Toast.LENGTH_LONG
                ).show();
            } else {
                Phonebook phonebook = new Phonebook(first_name, middle_name, last_name, group, primary_phone, secondary_phone);
                phonebook.PhonebookUpdate(user_id, phonebook);
                phonebookViewModel.updatePhonebook(phonebook);
                finish();
            }
        });

        activityEditPhonebookBinding.buttonCancel.setOnClickListener(v -> finish());

    }
}