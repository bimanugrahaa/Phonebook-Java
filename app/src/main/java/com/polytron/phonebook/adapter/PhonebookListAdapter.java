package com.polytron.phonebook.adapter;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.polytron.phonebook.R;
import com.polytron.phonebook.databinding.ActivityEditPhonebookBinding;
import com.polytron.phonebook.databinding.ActivityMainBinding;
import com.polytron.phonebook.model.Phonebook;
import com.polytron.phonebook.modelview.PhonebookViewModel;
import com.polytron.phonebook.view.AddPhonebookActivity;
import com.polytron.phonebook.view.EditPhonebookActivity;
import com.polytron.phonebook.view.MainActivity;
import com.polytron.phonebook.view.UserDetailPhonebookActivity;
import com.polytron.phonebook.viewholder.PhonebookViewHolder;

public class PhonebookListAdapter extends ListAdapter<Phonebook, PhonebookViewHolder> {
    private final PhonebookViewModel phonebookViewModel;
    public PhonebookListAdapter(@NonNull DiffUtil.ItemCallback<Phonebook> diffCallback, Application application) {
        super(diffCallback);
        phonebookViewModel = new PhonebookViewModel(application);
    }

    @NonNull
    @Override
    public PhonebookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return PhonebookViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull PhonebookViewHolder holder, int position) {
        Phonebook current = getItem(position);
        holder.bind(current.getFirstName());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), UserDetailPhonebookActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("user_id", current.getUserId());
            intent.putExtras(bundle);
            v.getContext().startActivity(intent, bundle);
        });

        holder.btnDelete.setOnClickListener(v -> {
            phonebookViewModel.deleteUser(current);
        });

        holder.btnEdit.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), EditPhonebookActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("user_id", current.getUserId());
            intent.putExtras(bundle);
            v.getContext().startActivity(intent, bundle);
        });

    }

    public static class PhonebookDiff extends DiffUtil.ItemCallback<Phonebook> {

        @Override
        public boolean areItemsTheSame(@NonNull Phonebook oldItem, @NonNull Phonebook newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Phonebook oldItem, @NonNull Phonebook newItem) {
            return oldItem.userId == newItem.userId;
        }
    }
}
