package com.example.android.miwok.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.miwok.R;
import com.example.android.miwok.model.Word;

import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {
    private int backgroundColor;

    public WordAdapter(@NonNull Context context, List<Word> words, int backgroundColor) {
        super(context, R.layout.list_item, words);
        this.backgroundColor = backgroundColor;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_item, parent, false);

            Word model = getItem(position);

            View wordLayout = listItemView.findViewById(R.id.word_layout);
            TextView defaultWord = listItemView.findViewById(R.id.english_word);
            TextView miwokWord = listItemView.findViewById(R.id.miwok_word);
            ImageView itemImage = listItemView.findViewById(R.id.imageView);

            assert model != null;
            wordLayout.setBackgroundColor(ContextCompat.getColor(getContext(), backgroundColor));
            defaultWord.setText(model.getDefaultWord());
            miwokWord.setText(model.getMiwokWord());
            if (model.hasImage()) {
                itemImage.setImageResource(model.getImageResource());
                itemImage.setVisibility(View.VISIBLE);
            } else {
                itemImage.setVisibility(View.GONE);
            }
        }
        return listItemView;
    }

}
