package com.example.android.miwok.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.miwok.R;
import com.example.android.miwok.model.Word;

import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {
    private Context mContext;
    private List<Word> wordList;
    private int colorResourceID;

    public WordAdapter(Context mContext, List<Word> wordList, int colorResourceID) {
        this.mContext = mContext;
        this.wordList = wordList;
        this.colorResourceID = colorResourceID;
    }

    @NonNull
    @Override
    public WordAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WordAdapter.ViewHolder holder, int position) {
        Word word = wordList.get(position);
        holder.wordLayout.setBackgroundColor(ContextCompat.getColor(mContext, colorResourceID));
        holder.defaultWord.setText(word.getDefaultWord());
        holder.miwokWord.setText(word.getMiwokWord());
        if (word.hasImage()) {
            holder.itemImage.setVisibility(View.VISIBLE);
            holder.itemImage.setImageResource(word.getImageResource());
        } else {
            holder.itemImage.setVisibility(View.GONE);
        }
    }


    @Override
    public int getItemCount() {
        return wordList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView defaultWord, miwokWord;
        ImageView itemImage;
        View wordLayout;

        ViewHolder(View itemView) {
            super(itemView);
            wordLayout = itemView.findViewById(R.id.word_layout);
            defaultWord = itemView.findViewById(R.id.english_word);
            miwokWord = itemView.findViewById(R.id.miwok_word);
            itemImage = itemView.findViewById(R.id.imageView);
        }
    }
}