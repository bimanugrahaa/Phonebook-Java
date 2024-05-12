package com.polytron.phonebook.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.polytron.phonebook.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class PhonebookViewHolder extends RecyclerView.ViewHolder {
    private final TextView userName;
    private final CircleImageView userImage;
    public PhonebookViewHolder(@NonNull View itemView) {
        super(itemView);

        userName = itemView.findViewById(R.id.user_name);
        userImage = itemView.findViewById(R.id.user_image);
    }
    public void bind(String text, int resId) {
        userName.setText(text);
        userImage.setImageResource(resId);
    }
    public static PhonebookViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_phonebook, parent, false);

        return new PhonebookViewHolder(view);
    }
}
