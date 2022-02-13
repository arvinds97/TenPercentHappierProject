package com.example.tenpercenthappier.models;

/**
 * Interface that represents a topic from the list of topics.
 */
public interface Topic {

    /**
     * Method to get the title of the topic.
     *
     * @return the title
     */
    String getTitle();

    /**
     * Method to get the count of meditations.
     *
     * @return the count
     */
    int getMeditationsCount();

    /**
     * Method to get the description of the topic.
     *
     * @return the description
     */
    String getDescriptionShort();

    /**
     * Method to get the color for the topic.
     *
     * @return the color
     */
    String getColor();

    /**
     * Method to get the position of the topic in the list.
     *
     * @return the position
     */
    int getPosition();

    /**
     * Method to get the uuid of the topic.
     *
     * @return the uuid
     */
    String getUuid();


}
