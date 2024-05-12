package com.polytron.phonebook.adapter;

import android.annotation.SuppressLint;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.polytron.phonebook.model.Phonebook;
import com.polytron.phonebook.viewholder.PhonebookViewHolder;

public class PhonebookListAdapter extends ListAdapter<Phonebook, PhonebookViewHolder> {
    public PhonebookListAdapter(@NonNull DiffUtil.ItemCallback<Phonebook> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public PhonebookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return PhonebookViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull PhonebookViewHolder holder, int position) {
        Phonebook current = getItem(position);
        holder.bind(current.getFirstName(), current.getUserId());
    }

    public static class PhonebookDiff extends DiffUtil.ItemCallback<Phonebook> {

        @Override
        public boolean areItemsTheSame(@NonNull Phonebook oldItem, @NonNull Phonebook newItem) {
            return oldItem == newItem;
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Phonebook oldItem, @NonNull Phonebook newItem) {
            return oldItem.equals(newItem);
        }
    }
}
