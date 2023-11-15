package com.example.recaycleview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    private final LinkedList<String> mWordList;
    private LayoutInflater mInflater;

    public WordListAdapter(LinkedList<String> mWordList) {
        this.mWordList = mWordList;
    }
    class WordViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        public final TextView wordItemView;
        final WordListAdapter mAdapter;
        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = (TextView) itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
// Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
// Use that to access the affected item in mWordList.
            String element = mWordList.get(mPosition);
// Change the word in the mWordList.
            mWordList.set(mPosition, "Clicked! " + element);
// Notify the adapter, that the data has changed so it can
// update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged();
        }
    }
    public WordListAdapter(Context context, LinkedList<String> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }
    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }
}