package com.example.android.quiz;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.LinkedList;

public class QuizListAdapter extends RecyclerView.Adapter<QuizListAdapter.WordViewHolder> {

    private LinkedList<QuizList> mQuizList = new LinkedList<>();
    private LayoutInflater mInflater;
    private int mTotalCorrect = 0;


    class WordViewHolder extends RecyclerView.ViewHolder {
        final QuizListAdapter mAdapter;
        private final TextView questionView;
        private final CheckBox option1;
        private final CheckBox option2;
        private final CheckBox option3;
        private final CheckBox option4;


        /**
         * Get the view ids of the custom view for items in the recycler view
         */
        public WordViewHolder(View itemView, QuizListAdapter adapter) {
            super(itemView);
            questionView = itemView.findViewById(R.id.question_textview);
            option1 = itemView.findViewById(R.id.option1);
            option2 = itemView.findViewById(R.id.option2);
            option3 = itemView.findViewById(R.id.option3);
            option4 = itemView.findViewById(R.id.option4);
            this.mAdapter = adapter;
        }
    }


    public QuizListAdapter(Context context, LinkedList<QuizList> quizLists) {
        mInflater = LayoutInflater.from(context);
        mQuizList = quizLists;
    }


    /**
     * Inflate the view of the recycler view with a custom layout that will display the quiz data
     */
    @NonNull
    @Override
    public QuizListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = mInflater.inflate(R.layout.template_layout, viewGroup, false);
        return new WordViewHolder(mItemView, this);
    }


    /**
     * Populate the view at certain position with the quiz data
     *
     * @param wordViewHolder Contains the View information for the template layout
     * @param i              The recycler item view position to be populated with quiz data
     */
    @Override
    public void onBindViewHolder(@NonNull final QuizListAdapter.WordViewHolder wordViewHolder, final int i) {

        wordViewHolder.questionView.setText(mQuizList.get(i).getQuestion());
        wordViewHolder.option1.setText(mQuizList.get(i).getOption1());
        wordViewHolder.option2.setText(mQuizList.get(i).getOption2());
        wordViewHolder.option3.setText(mQuizList.get(i).getOption3());
        wordViewHolder.option4.setText(mQuizList.get(i).getOption4());

//      check if the first option is the correct option and if it is the correct one add the score value
        wordViewHolder.option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (wordViewHolder.option2.isChecked()) {
                    wordViewHolder.option2.setChecked(false);
                }

                if (wordViewHolder.option3.isChecked()) {
                    wordViewHolder.option3.setChecked(false);
                }

                if (wordViewHolder.option4.isChecked()) {
                    wordViewHolder.option4.setChecked(false);
                }

                wordViewHolder.option1.setChecked(true);

                if (wordViewHolder.option1.getId() == mQuizList.get(i).getAnswerID()) {
                    mTotalCorrect++;
                    mQuizList.get(i).setScoreGiven(true);
                } else if (mQuizList.get(i).isScoreGiven()) {
                    mTotalCorrect--;
                    mQuizList.get(i).setScoreGiven(false);
                }
            }
        });

//      check if the second option is the correct option and if it is the correct one add the score value
        wordViewHolder.option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (wordViewHolder.option1.isChecked()) {
                    wordViewHolder.option1.setChecked(false);
                }

                if (wordViewHolder.option3.isChecked()) {
                    wordViewHolder.option3.setChecked(false);
                }

                if (wordViewHolder.option4.isChecked()) {
                    wordViewHolder.option4.setChecked(false);
                }

                wordViewHolder.option2.setChecked(true);

                if (wordViewHolder.option2.getId() == mQuizList.get(i).getAnswerID()) {
                    mTotalCorrect++;
                    mQuizList.get(i).setScoreGiven(true);
                } else if (mQuizList.get(i).isScoreGiven()) {
                    mTotalCorrect--;
                    mQuizList.get(i).setScoreGiven(false);
                }
            }
        });


        //      check if the third option is the correct option and if it is the correct one add the score value
        wordViewHolder.option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (wordViewHolder.option2.isChecked()) {
                    wordViewHolder.option2.setChecked(false);
                }

                if (wordViewHolder.option1.isChecked()) {
                    wordViewHolder.option1.setChecked(false);
                }

                if (wordViewHolder.option4.isChecked()) {
                    wordViewHolder.option4.setChecked(false);
                }

                wordViewHolder.option3.setChecked(true);

                if (wordViewHolder.option3.getId() == mQuizList.get(i).getAnswerID()) {
                    mTotalCorrect++;
                    mQuizList.get(i).setScoreGiven(true);
                } else if (mQuizList.get(i).isScoreGiven()) {
                    mTotalCorrect--;
                    mQuizList.get(i).setScoreGiven(false);
                }
            }
        });


        //      check if the fourth option is the correct option and if it is the correct one add the score value
        wordViewHolder.option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (wordViewHolder.option2.isChecked()) {
                    wordViewHolder.option2.setChecked(false);
                }

                if (wordViewHolder.option3.isChecked()) {
                    wordViewHolder.option3.setChecked(false);
                }

                if (wordViewHolder.option1.isChecked()) {
                    wordViewHolder.option1.setChecked(false);
                }

                wordViewHolder.option4.setChecked(true);

                if (wordViewHolder.option4.getId() == mQuizList.get(i).getAnswerID()) {
                    mTotalCorrect++;
                    mQuizList.get(i).setScoreGiven(true);
                } else if (mQuizList.get(i).isScoreGiven()) {
                    mTotalCorrect--;
                    mQuizList.get(i).setScoreGiven(false);
                }
            }
        });

    }


    /**
     * Get the total number of quiz items that will be populating the
     * recycler view
     */
    @Override
    public int getItemCount() {
        return mQuizList.size();
    }


    /**
     * Returns the total number of correct answer that the user provided
     */
    public int getTotalCorrect() {
        return this.mTotalCorrect;
    }
}
