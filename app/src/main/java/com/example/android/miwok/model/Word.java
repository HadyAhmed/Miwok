package com.example.android.miwok.model;

public class Word {
    private static final int NO_IMAGE_PROVIDED = -1;
    private String defaultWord, miwokWord;
    private int mImageResource = NO_IMAGE_PROVIDED, audioResourceID;

    /**
     * To Construct Object For {@link com.example.android.miwok.activity.PhrasesActivity}
     */
    public Word(String defaultWord, String miwokWord, int audioResourceID) {
        this.defaultWord = defaultWord;
        this.miwokWord = miwokWord;
        this.audioResourceID = audioResourceID;
    }

    /**
     * To Construct Object For {@link com.example.android.miwok.activity.NumbersActivity,com.example.android.miwok.activity.ColorsActivity,com.example.android.miwok.activity.FamilyActivity}
     */
    public Word(String defaultWord, String miwokWord, int imageResource, int audioResourceID) {
        this(defaultWord, miwokWord, audioResourceID);
        this.mImageResource = imageResource;
    }

    public int getAudioResourceID() {
        return audioResourceID;
    }

    public int getImageResource() {
        return mImageResource;
    }

    public String getDefaultWord() {
        return defaultWord;
    }

    public String getMiwokWord() {
        return miwokWord;
    }

    public boolean hasImage() {
        return mImageResource != NO_IMAGE_PROVIDED;
    }
}
