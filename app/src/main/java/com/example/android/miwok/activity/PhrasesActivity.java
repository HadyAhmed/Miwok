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

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word);

        // Create a list of words
        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(getString(R.string.en_phrase_where_are_you_going), getString(R.string.mi_phrase_where_are_you_going), R.raw.phrase_where_are_you_going));
        words.add(new Word(getString(R.string.en_phrase_whats_your_name), getString(R.string.mi_phrase_whats_your_name), R.raw.phrase_what_is_your_name));
        words.add(new Word(getString(R.string.en_phrase_my_name_is), getString(R.string.mi_phrase_my_name_is), R.raw.phrase_my_name_is));
        words.add(new Word(getString(R.string.en_phrase_how_are_you_feeling), getString(R.string.mi_phrase_how_are_you_feeling), R.raw.phrase_how_are_you_feeling));
        words.add(new Word(getString(R.string.en_phrase_iam_feeling_good), getString(R.string.mi_phrase_iam_feeling_good), R.raw.phrase_im_feeling_good));
        words.add(new Word(getString(R.string.en_phrase_are_you_coming), getString(R.string.mi_phrase_are_you_coming), R.raw.phrase_are_you_coming));
        words.add(new Word(getString(R.string.en_phrase_yes_iam_coming), getString(R.string.mi_phrase_yes_iam_coming), R.raw.phrase_yes_im_coming));
        words.add(new Word(getString(R.string.en_phrase_iam_coming), getString(R.string.mi_phrase_iam_coming), R.raw.phrase_im_coming));
        words.add(new Word(getString(R.string.en_phrase_lets_go), getString(R.string.mi_phrase_lets_go), R.raw.phrase_lets_go));
        words.add(new Word(getString(R.string.en_phrase_come_here), getString(R.string.mi_phrase_come_here), R.raw.phrase_come_here));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        // Find The View That Shows The Item List For The Phrases
        RecyclerView itemList = findViewById(R.id.item_list_view);
        itemList.setAdapter(adapter);
        itemList.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }
}
