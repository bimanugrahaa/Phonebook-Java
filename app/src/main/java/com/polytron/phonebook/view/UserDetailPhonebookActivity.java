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

    public static final String EXTRA_REPLY = "com.polytron.phonebook.REPLY";
    ActivityUserDetailPhonebookBinding activityUserDetailPhonebookBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityUserDetailPhonebookBinding = ActivityUserDetailPhonebookBinding.inflate(getLayoutInflater());
        View view = activityUserDetailPhonebookBinding.getRoot();
        setContentView(view);

        PhonebookViewModel phonebookViewModel = new PhonebookViewModel(this.getApplication());
//        Intent intent = new Intent();
//        Phonebook phonebook = phonebookViewModel.getUserDetail(bundle.getInt("user_id"));
        phonebookViewModel.getUserDetail(getIntent().getIntExtra("user_id", 0)).observe(this, phonebook -> {
            activityUserDetailPhonebookBinding.userName.setText(phonebook.getFirstName());
            activityUserDetailPhonebookBinding.primaryNumber.setText(phonebook.getPrimaryPhone());
            activityUserDetailPhonebookBinding.secondaryNumber.setText(phonebook.getSecondaryPhone());
        });

//        Log.d("phonebook", String.valueOf(phonebook));
//        activityUserDetailPhonebookBinding.userName.setText(phonebook.getFirstName());
//        activityUserDetailPhonebookBinding.primaryNumber.setText(phonebook.getPrimaryPhone());
//        activityUserDetailPhonebookBinding.secondaryNumber.setText(phonebook.getSecondaryPhone());

//        phonebookViewModel = new ViewModelProvider(UserDetailPhonebookActivity.this).get(PhonebookViewModel.class);

//        activityUserDetailPhonebookBinding.deleteButton.setOnClickListener(v -> {
////            Intent replyIntent = new Intent();
////            Bundle bundle = new Bundle();
////            bundle.putString("message", "Contact delete success!");
////            replyIntent.putExtras(bundle);
////            setResult(DELETE_OK, replyIntent);
////
////            finish();
//
//            int userId;
//            Bundle bundle = new Bundle();
//
//            userId = bundle.getInt("user_id");
//
//            if(phonebookViewModel.deleteUser(userId) != 0){
//                finish();
////                Intent intent = new Intent(v.getContext(), MainActivity.class);
////                startActivity(intent);
//            }
//
//        });
    }

}