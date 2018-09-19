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

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(getString(R.string.en_number_one), getString(R.string.mi_number_one), R.drawable.number_one, R.raw.number_one));
        words.add(new Word(getString(R.string.en_number_two), getString(R.string.mi_number_two), R.drawable.number_two, R.raw.number_two));
        words.add(new Word(getString(R.string.en_number_three), getString(R.string.mi_number_three), R.drawable.number_three, R.raw.number_three));
        words.add(new Word(getString(R.string.en_number_four), getString(R.string.mi_number_four), R.drawable.number_four, R.raw.number_four));
        words.add(new Word(getString(R.string.en_number_five), getString(R.string.mi_number_five), R.drawable.number_five, R.raw.number_five));
        words.add(new Word(getString(R.string.en_number_six), getString(R.string.mi_number_six), R.drawable.number_six, R.raw.number_six));
        words.add(new Word(getString(R.string.en_number_seven), getString(R.string.mi_number_seven), R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word(getString(R.string.en_number_eight), getString(R.string.mi_number_eight), R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word(getString(R.string.en_number_nine), getString(R.string.mi_number_nine), R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word(getString(R.string.en_number_ten), getString(R.string.mi_number_ten), R.drawable.number_ten, R.raw.number_ten));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.

        RecyclerView itemList = findViewById(R.id.item_list_view);
        itemList.setAdapter(adapter);
        itemList.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }
}
