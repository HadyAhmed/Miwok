package com.example.android.miwok.adapter;

import android.content.Context;
import android.media.AudioManager;
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

import com.example.android.miwok.R;
import com.example.android.miwok.model.Word;

import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {
    private Context mContext;
    private List<Word> wordList;
    private int colorResourceID;
    private MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener completionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    private AudioManager mAudioManager;
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT
                    || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);// To Hear The Word From The Beginning.
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // Resume Playback
                mediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };

    public WordAdapter(Context mContext, List<Word> wordList, int colorResourceID) {
        this.mContext = mContext;
        this.wordList = wordList;
        this.colorResourceID = colorResourceID;
        mAudioManager = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
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
                releaseMediaPlayer();
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC
                        // Request Permanent Focus.
                        , AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer = MediaPlayer.create(mContext, word.getAudioResourceID());
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(completionListener);
                }
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

    /**
     * This method will free up the media player resources in the current activity
     */
    public void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }
}