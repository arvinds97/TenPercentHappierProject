package com.example.tenpercenthappier.models;

import java.util.List;

/**
 * Class that represents a Topic. It represents one topic which is part of the JSONArray. Consists
 * of uuid, color, description, meditations, title, position and whether it is featured or not.
 * Implements the Topic interface.
 */
public class TopicImpl implements Topic {

    private final String uuid;
    private final String color;
    private final String description_short;
    private final List<String> meditations;
    private final String title;
    private final int position;
    private final boolean featured;

    /**
     * Constructor for the class that initializes all the members.
     *
     * @param uuid              the uuid of the topic
     * @param color             the color code for the topic.
     * @param description_short the description for the topic.
     * @param meditations       the list of uuids of meditations for the topic.
     * @param title             the title for the topic
     * @param position          the position of the topic
     * @param featured          whether the topic is featured or not
     */
    public TopicImpl(String uuid, String color, String description_short, List<String> meditations,
                     String title, int position, boolean featured) {
        this.uuid = uuid;
        this.color = color;
        this.description_short = description_short;
        this.meditations = meditations;
        this.title = title;
        this.position = position;
        this.featured = featured;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getMeditationsCount() {
        return meditations.size();
    }

    @Override
    public String getDescriptionShort() {
        return description_short;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public String getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "uuid='" + uuid + '\'' +
                ", color='" + color + '\'' +
                ", description_short='" + description_short + '\'' +
                ", meditations=" + meditations +
                ", title='" + title + '\'' +
                ", position=" + position +
                ", featured=" + featured +
                '}';
    }
}
