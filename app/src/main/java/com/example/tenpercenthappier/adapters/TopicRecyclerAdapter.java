package com.example.tenpercenthappier.adapters;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tenpercenthappier.R;
import com.example.tenpercenthappier.models.TopicImpl;

import java.util.List;

/**
 * Class that represents the Recycler Adapter for the Recycler View.
 * Will consist of a list of cards that represent topics.
 */
public class TopicRecyclerAdapter extends
        RecyclerView.Adapter<TopicRecyclerAdapter.RecyclerViewHolder> {

    private final List<TopicImpl> topicList;
    private final TopicListener topicListener;

    /**
     * Constructor for the class.
     * @param topicList the list of topics from the json
     * @param topicListener the listener on the topics
     */
    public TopicRecyclerAdapter(List<TopicImpl> topicList, TopicListener topicListener) {
        this.topicList = topicList;
        this.topicListener = topicListener;
        sortListAccordingToPosition();
    }

    //private method to sort the topics in the list according to position.
    private void sortListAccordingToPosition() {
        topicList.sort((o1, o2) -> {
            if (o1.getPosition() < o2.getPosition()) {
                return -1;
            } else if (o1.getPosition() > o2.getPosition()){
                return 1;
            } else {
                return 0;
            }
        });
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.topic_card_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        TopicImpl topic = topicList.get(position);
        holder.title.setText(topic.getTitle());
        holder.count.setText(String.valueOf(topic.getMeditationsCount()));
        try {
            holder.colorCoding.setBackgroundColor(Color.parseColor(topic.getColor()));
        } catch (IllegalArgumentException illegalArgumentException) {
            holder.colorCoding.setBackgroundColor(Color.blue(100));
        }

    }

    @Override
    public int getItemCount() {
        return topicList.size();
    }


    /**
     * CLass the represents the ViewHolder in the adapter.
     */
    public class RecyclerViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        private final TextView title;
        private final TextView count;
        private final RelativeLayout colorCoding;

        /**
         * Constructor that initializes the components of the holder.
         * @param itemView the view
         */
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_title);
            count = itemView.findViewById(R.id.item_meditation_count);
            colorCoding = itemView.findViewById(R.id.colorCode);
            itemView.setClickable(true);
            itemView.setOnClickListener(v -> topicListener.onTopicClick(v,getLayoutPosition()));
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void onClick(View v) {
            Log.d("ViewHolder","Clicked the view");
            topicListener.onTopicClick(v,getLayoutPosition());
        }
    }
}
