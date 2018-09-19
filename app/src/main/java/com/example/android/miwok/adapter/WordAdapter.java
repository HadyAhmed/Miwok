package com.example.android.miwok.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
    private MediaPlayer mediaPlayer;

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
        final Word word = wordList.get(position);
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        holder.wordLayout.setBackgroundColor(ContextCompat.getColor(mContext, colorResourceID));
        holder.defaultWord.setText(word.getDefaultWord());
        holder.miwokWord.setText(word.getMiwokWord());
        if (word.hasImage()) {
            holder.itemImage.setVisibility(View.VISIBLE);
            holder.itemImage.setImageResource(word.getImageResource());
        } else {
            holder.itemImage.setVisibility(View.GONE);
        }
        holder.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(mContext, word.getAudioResourceID());
                mediaPlayer.start();
            }
        });
    }


    @Override
    public int getItemCount() {
        return wordList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView defaultWord, miwokWord;
        ImageView itemImage;
        View wordLayout;
        ImageButton play;

        ViewHolder(View itemView) {
            super(itemView);
            wordLayout = itemView.findViewById(R.id.word_layout);
            defaultWord = itemView.findViewById(R.id.default_word);
            miwokWord = itemView.findViewById(R.id.miwok_word);
            play = itemView.findViewById(R.id.play_btn);
            itemImage = itemView.findViewById(R.id.imageView);
        }
    }
}