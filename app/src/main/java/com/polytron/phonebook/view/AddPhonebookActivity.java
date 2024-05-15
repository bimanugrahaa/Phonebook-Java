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

import com.polytron.phonebook.R;
import com.polytron.phonebook.databinding.ActivityAddPhonebookBinding;
import com.polytron.phonebook.databinding.ActivityMainBinding;
import com.polytron.phonebook.model.Phonebook;
import com.polytron.phonebook.modelview.PhonebookViewModel;

import java.util.ArrayList;

public class AddPhonebookActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.polytron.phonebook.REPLY";
    private PhonebookViewModel phonebookViewModel;
    ActivityAddPhonebookBinding activityAddPhonebookBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAddPhonebookBinding = ActivityAddPhonebookBinding.inflate(getLayoutInflater());
        View view = activityAddPhonebookBinding.getRoot();
        setContentView(view);

        activityAddPhonebookBinding.buttonSave.setOnClickListener(v -> {
            String first_name = activityAddPhonebookBinding.firstNameEditText.getText().toString();
            String middle_name = activityAddPhonebookBinding.middleNameEditText.getText().toString();
            String last_name = activityAddPhonebookBinding.lastNameEditText.getText().toString();
            String primary_phone = activityAddPhonebookBinding.primaryPhoneEditText.getText().toString();
            String secondary_phone = activityAddPhonebookBinding.secondaryPhoneEditText.getText().toString();
            String group = activityAddPhonebookBinding.groupsEditText.getText().toString();

            Intent replyIntent = new Intent();
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(first_name);
            arrayList.add(middle_name);
            arrayList.add(last_name);
            arrayList.add(primary_phone);
            arrayList.add(secondary_phone);
            arrayList.add(group);

            if (TextUtils.isEmpty(activityAddPhonebookBinding.firstNameEditText.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
//                replyIntent.putExtra(EXTRA_REPLY, arrayList);

                replyIntent.putStringArrayListExtra(EXTRA_REPLY, arrayList);
                setResult(RESULT_OK, replyIntent);
            }
            finish();

//            Phonebook phonebook = new Phonebook(first_name, last_name, primary_phone, middle_name, group, secondary_phone);
//
//            Log.d("Phonebook", phonebook.firstName);
//            phonebookViewModel.insertPhonebook(phonebook);
        });
    }
}