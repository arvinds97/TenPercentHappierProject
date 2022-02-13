package com.example.tenpercenthappier.adapters;

import android.view.View;

/**
 * Interface that represents a Listener on a particular topics in the list of topics.
 */
public interface TopicListener {
    /**
     * Method that is called when a topic from the topics list is clicked.
     * @param v the view
     * @param position the position of the topic in the list
     */
     void onTopicClick(View v, int position);
}
