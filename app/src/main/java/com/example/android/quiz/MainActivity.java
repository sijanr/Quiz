package com.example.android.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private LinkedList<QuizList> quizLists = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private QuizListAdapter quizAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


//      set a listener to floating action button
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Correct: " + (quizAdapter.getTotalCorrect()) + "/" + (quizLists.size()) + "\nSelect reset button above to reset the game", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

//      lists of quiz questions, options, and answerID
        quizLists.add(new QuizList("‘Christ the Redeemer’ is located in which place?", "Rio De Janeiro", "Salvador", "Brasilia", "Porto Alegre", R.id.option1));
        quizLists.add(new QuizList("Which country did Britain fight in the War of Jenkins’ Ear?", "France", "Ireland", "Spain", "Wales", R.id.option3));
        quizLists.add(new QuizList("Name the other house of the Parliament of US other than the House of Representatives?", "Selicate", "Democratic Party", "Senate", "House of Commons", R.id.option3));
        quizLists.add(new QuizList("Which among the following is a symbol for Peace?", "Green eyed monster", "Jade", "Olive Branch", "Heart", R.id.option3));
        quizLists.add(new QuizList("Who is known as the ‘Father of Biology’?", "Galen", "Aristotle", "Socrates", "Avicena", R.id.option2));
        quizLists.add(new QuizList("Which is the tallest waterfall in the world?", "Niagara Falls", "Angel Falls", "Iguazu Falls", "Jog Falls", R.id.option2));
        quizLists.add(new QuizList("Which tennis player, famous for her two-handed backhand and baseline-dominated play was nicknamed ‘The Ice Maiden’?", "Steffi Graf", "Chris Evert", "Evonne Cawley", "Kim Clijsters", R.id.option2));


        mRecyclerView = findViewById(R.id.recyclerview);

//      create recycler view adapter and pass the quiz lists
        quizAdapter = new QuizListAdapter(quizLists);

//      set the recycler view adapter to populate the view with the quiz lists
        mRecyclerView.setAdapter(quizAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


    //  create an action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    //  reset the game when 'Reset' option clicked in the action bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_rename) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();

        }

        return true;

    }


}
