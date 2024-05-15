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
    ItemPhonebookBinding itemPhonebookBinding;
    PhonebookViewModel phonebookViewModel;
    public TextView userName;
    public ImageButton btnDelete;
    public ImageButton btnEdit;

    public PhonebookViewHolder(@NonNull View itemView) {
        super(itemView);
//        TextView userName = itemPhonebookBinding.userName;

        userName = itemView.findViewById(R.id.user_name);
        btnDelete = itemView.findViewById(R.id.delete_button_rv);
        btnEdit = itemView.findViewById(R.id.edit_button_rv);
    }
    public void bind(String text) {
        userName.setText(text);
    }
    public static PhonebookViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_phonebook, parent, false);

        return new PhonebookViewHolder(view);
    }
}
