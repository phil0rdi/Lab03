package com.example.philippe.lab08;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import static com.example.philippe.lab08.R.id.textViewBanana;
import static com.example.philippe.lab08.R.id.textViewName;

/**
 * Created by Philippe on 2017-12-02.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private List<Unite> mData = Collections.emptyList();
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    //CLICKING
    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    //VIEW
    // data is passed into the constructor
    public MyRecyclerViewAdapter(Context context, List<Unite> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.uniterow, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // binds the data to the textview in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.myTextView1.setText(mData.get(position).getName());
        holder.myTextView2.setText(mData.get(position).getNbBananas());

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView myTextView1;
        public TextView myTextView2;

        public ViewHolder(View itemView) {
            super(itemView);
            myTextView1 = (TextView) itemView.findViewById(textViewName);
            myTextView2 = (TextView) itemView.findViewById(textViewBanana);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            System.out.println("1");
            if (mClickListener != null) {
                System.out.println("2");
                mClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    // convenience method for getting data at click position
    public float getNbBananes(int id) {
        //return mData.get(id).getNbBananas();
        return Float.parseFloat(mData.get(id).getNbBananas());
    }

    public String getUnites(int id) {
        //return mData.get(id).getNbBananas();
        return mData.get(id).getName();
    }


}
