/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.miwok.R;
import com.example.android.miwok.adapter.WordAdapter;
import com.example.android.miwok.model.Word;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    private WordAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word);

        // Create a list of words
        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(getString(R.string.en_color_red), getString(R.string.mi_color_red), R.drawable.color_red, R.raw.color_red));
        words.add(new Word(getString(R.string.en_color_mustard_yellow), getString(R.string.mi_color_mustard_yellow), R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
        words.add(new Word(getString(R.string.en_color_dusty_yellow), getString(R.string.mi_color_dusty_yellow), R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word(getString(R.string.en_color_green), getString(R.string.mi_color_green), R.drawable.color_green, R.raw.color_green));
        words.add(new Word(getString(R.string.en_color_brown), getString(R.string.mi_color_brown), R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word(getString(R.string.en_color_gray), getString(R.string.mi_color_gray), R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word(getString(R.string.en_color_black), getString(R.string.mi_color_black), R.drawable.color_black, R.raw.color_black));
        words.add(new Word(getString(R.string.en_color_white), getString(R.string.mi_color_white), R.drawable.color_white, R.raw.color_white));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        adapter = new WordAdapter(this, words, R.color.category_colors);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        // Find The View That Shows The Item List For The Phrases
        RecyclerView itemList = findViewById(R.id.item_list_view);
        itemList.setAdapter(adapter);
        itemList.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }

    @Override
    protected void onPause() {
        super.onPause();
        adapter.releaseMediaPlayer();
    }
}
