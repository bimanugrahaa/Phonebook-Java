package com.polytron.phonebook.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.polytron.phonebook.R;
import com.polytron.phonebook.databinding.ActivityAddPhonebookBinding;
import com.polytron.phonebook.databinding.ActivityUserDetailPhonebookBinding;
import com.polytron.phonebook.modelview.PhonebookViewModel;

public class UserDetailPhonebookActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.polytron.phonebook.REPLY";
    ActivityUserDetailPhonebookBinding activityUserDetailPhonebookBinding;
    PhonebookViewModel phonebookViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityUserDetailPhonebookBinding = ActivityUserDetailPhonebookBinding.inflate(getLayoutInflater());
        View view = activityUserDetailPhonebookBinding.getRoot();
        setContentView(view);

        phonebookViewModel = new ViewModelProvider(UserDetailPhonebookActivity.this).get(PhonebookViewModel.class);

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