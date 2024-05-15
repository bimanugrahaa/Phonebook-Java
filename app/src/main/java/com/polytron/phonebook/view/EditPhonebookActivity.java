package com.polytron.phonebook.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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
    int user_id;
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

            Intent replyIntent = new Intent();
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(first_name);
            arrayList.add(middle_name);
            arrayList.add(last_name);
            arrayList.add(primary_phone);
            arrayList.add(secondary_phone);
            arrayList.add(group);

            Phonebook phonebook = new Phonebook(arrayList.get(0), arrayList.get(2), arrayList.get(3), arrayList.get(1), arrayList.get(4), arrayList.get(5));
            phonebook.PhonebookUpdate(user_id, phonebook);
            Log.d("phonebookUpdate", String.valueOf(phonebook));
            phonebookViewModel.updatePhonebook(phonebook);
            finish();
        });

    }
}