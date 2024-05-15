package com.polytron.phonebook.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.polytron.phonebook.R;
import com.polytron.phonebook.databinding.ItemPhonebookBinding;
import com.polytron.phonebook.modelview.PhonebookViewModel;

import de.hdodenhof.circleimageview.CircleImageView;

public class PhonebookViewHolder extends RecyclerView.ViewHolder {
    public ItemPhonebookBinding itemPhonebookBinding;
    public PhonebookViewHolder(@NonNull View itemView) {
        super(itemView);
        itemPhonebookBinding = ItemPhonebookBinding.bind(itemView);
    }
    public void bind(String text) {
        itemPhonebookBinding.userName.setText(text);
    }
    public static PhonebookViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_phonebook, parent, false);

        return new PhonebookViewHolder(view);
    }
}
