package com.example.android.quiz;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class QuizListAdapter extends RecyclerView.Adapter<QuizListAdapter.WordViewHolder> {

    private LinkedList<QuizList> mQuizList = new LinkedList<>();
    private int mTotalCorrect = 0;


    class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView questionView;
        private final CheckBox option1;
        private final CheckBox option2;
        private final CheckBox option3;
        private final CheckBox option4;


        /**
         * Get the view ids of the custom view for items in the recycler view
         */
        public WordViewHolder(final View itemView) {
            super(itemView);
            questionView = itemView.findViewById(R.id.question_textview);
            option1 = itemView.findViewById(R.id.option1);
            option2 = itemView.findViewById(R.id.option2);
            option3 = itemView.findViewById(R.id.option3);
            option4 = itemView.findViewById(R.id.option4);

            //set click listener for option 1
            option1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //uncheck the option that may have been selected before
                    option2.setChecked(false);
                    option3.setChecked(false);
                    option4.setChecked(false);

                    int position = getAdapterPosition();
                    //update the score on its correctness
                    boolean scoreGiven = mQuizList.get(position).isScoreGiven();
                    if (!scoreGiven && option1.getId() == mQuizList.get(position).getAnswerID()) {
                        mTotalCorrect++;
                        mQuizList.get(position).setScoreGiven(true);
                    } else if (scoreGiven && option1.getId() != mQuizList.get(position).getAnswerID()) {
                        mTotalCorrect--;
                        mQuizList.get(position).setScoreGiven(false);
                    } else if (scoreGiven && option1.getId() == mQuizList.get(position).getAnswerID()) {
                        mTotalCorrect--;
                        mQuizList.get(position).setScoreGiven(false);
                    }
                }
            });

            //set click listener for option 2
            option2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //uncheck the option that may have been selected before
                    option1.setChecked(false);
                    option3.setChecked(false);
                    option4.setChecked(false);

                    int position = getAdapterPosition();
                    //update the score on its correctness
                    boolean scoreGiven = mQuizList.get(position).isScoreGiven();
                    if (!scoreGiven && option2.getId() == mQuizList.get(position).getAnswerID()) {
                        mTotalCorrect++;
                        mQuizList.get(position).setScoreGiven(true);
                    } else if (scoreGiven && option2.getId() != mQuizList.get(position).getAnswerID()) {
                        mTotalCorrect--;
                        mQuizList.get(position).setScoreGiven(false);
                    } else if (scoreGiven && option2.getId() == mQuizList.get(position).getAnswerID()) {
                        mTotalCorrect--;
                        mQuizList.get(position).setScoreGiven(false);
                    }
                }
            });

            //click listener for item 3
            option3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //uncheck the option that may have been selected before
                    option2.setChecked(false);
                    option1.setChecked(false);
                    option4.setChecked(false);

                    int position = getAdapterPosition();
                    //update the score on its correctness
                    boolean scoreGiven = mQuizList.get(position).isScoreGiven();
                    if (!scoreGiven && option3.getId() == mQuizList.get(position).getAnswerID()) {
                        mTotalCorrect++;
                        mQuizList.get(position).setScoreGiven(true);
                    } else if (scoreGiven && option3.getId() != mQuizList.get(position).getAnswerID()) {
                        mTotalCorrect--;
                        mQuizList.get(position).setScoreGiven(false);
                    } else if (scoreGiven && option3.getId() == mQuizList.get(position).getAnswerID()) {
                        mTotalCorrect--;
                        mQuizList.get(position).setScoreGiven(false);
                    }
                }
            });

            //click listener for item 4
            option4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //uncheck the option that may have been selected before
                    option2.setChecked(false);
                    option1.setChecked(false);
                    option3.setChecked(false);

                    int position = getAdapterPosition();
                    //update the score on its correctness
                    boolean scoreGiven = mQuizList.get(position).isScoreGiven();
                    if (!scoreGiven && option4.getId() == mQuizList.get(position).getAnswerID()) {
                        mTotalCorrect++;
                        mQuizList.get(position).setScoreGiven(true);
                    } else if (scoreGiven && option4.getId() != mQuizList.get(position).getAnswerID()) {
                        mTotalCorrect--;
                        mQuizList.get(position).setScoreGiven(false);
                    } else if (scoreGiven && option4.getId() == mQuizList.get(position).getAnswerID()) {
                        mTotalCorrect--;
                        mQuizList.get(position).setScoreGiven(false);
                    }
                }
            });
        }
    }


    public QuizListAdapter(LinkedList<QuizList> quizLists) {
        mQuizList = quizLists;
    }


    /**
     * Inflate the view of the recycler view with a custom layout that will display the quiz data
     */
    @NonNull
    @Override
    public QuizListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mItemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.template_layout, viewGroup, false);
        return new WordViewHolder(mItemView);
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
