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

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.example.android.miwok.R;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_category.xml.xml layout file
        setContentView(R.layout.activity_category);
        // Find the View that shows the numbers category
        TextView numbers = findViewById(R.id.numbers);
        numbers.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link NumbersActivity}
                openActivity(CategoryActivity.this, NumbersActivity.class);
            }
        });
        // Find the View that shows the family category
        TextView family = findViewById(R.id.family);
        family.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity(CategoryActivity.this, FamilyActivity.class);
            }
        });
        // Find the View that shows the colors category
        TextView colors = findViewById(R.id.colors);
        colors.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link ColorsActivity}
                openActivity(CategoryActivity.this, ColorsActivity.class);
            }
        });
        // Find the View that shows the phrases category
        TextView phrases = findViewById(R.id.phrases);
        phrases.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link PhrasesActivity}
                openActivity(CategoryActivity.this, PhrasesActivity.class);
            }
        });
    }

    /**
     * This method will be responsible for opening a new activity
     *
     * @param packageContext is the current package for {@link CategoryActivity}
     * @param cls            is the activity needed to be opened.
     */
    private void openActivity(Context packageContext, Class<?> cls) {
        Intent intent = new Intent(packageContext, cls);
        startActivity(intent);
    }
}
