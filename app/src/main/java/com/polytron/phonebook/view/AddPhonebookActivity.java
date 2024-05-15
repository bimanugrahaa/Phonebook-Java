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
import com.polytron.phonebook.databinding.ActivityAddPhonebookBinding;
import com.polytron.phonebook.databinding.ActivityMainBinding;
import com.polytron.phonebook.model.Phonebook;
import com.polytron.phonebook.modelview.PhonebookViewModel;

import java.util.ArrayList;

public class AddPhonebookActivity extends AppCompatActivity {
    ActivityAddPhonebookBinding activityAddPhonebookBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityAddPhonebookBinding = ActivityAddPhonebookBinding.inflate(getLayoutInflater());
        View view = activityAddPhonebookBinding.getRoot();
        setContentView(view);

        PhonebookViewModel phonebookViewModel = new PhonebookViewModel(this.getApplication());

        activityAddPhonebookBinding.buttonSave.setOnClickListener(v -> {
            String first_name = activityAddPhonebookBinding.firstNameEditText.getText().toString();
            String middle_name = activityAddPhonebookBinding.middleNameEditText.getText().toString();
            String last_name = activityAddPhonebookBinding.lastNameEditText.getText().toString();
            String primary_phone = activityAddPhonebookBinding.primaryPhoneEditText.getText().toString();
            String secondary_phone = activityAddPhonebookBinding.secondaryPhoneEditText.getText().toString();
            String group = activityAddPhonebookBinding.groupsEditText.getText().toString();

            if (TextUtils.isEmpty(activityAddPhonebookBinding.firstNameEditText.getText().toString())){
                Toast.makeText(
                        getApplicationContext(),
                        "First Name can not be blank.",
                        Toast.LENGTH_LONG
                ).show();
            } else if (TextUtils.isEmpty(activityAddPhonebookBinding.lastNameEditText.getText().toString())){
                Toast.makeText(
                        getApplicationContext(),
                        "Last Name can not be blank.",
                        Toast.LENGTH_LONG
                ).show();
            } else if (TextUtils.isEmpty(activityAddPhonebookBinding.primaryPhoneEditText.getText().toString())){
                Toast.makeText(
                        getApplicationContext(),
                        "Primary phone can not be blank.",
                        Toast.LENGTH_LONG
                ).show();
            } else {
                Phonebook phonebook = new Phonebook(first_name, middle_name, last_name, group, primary_phone, secondary_phone);
                phonebookViewModel.insertPhonebook(phonebook);
                finish();
            }
        });
    }
}