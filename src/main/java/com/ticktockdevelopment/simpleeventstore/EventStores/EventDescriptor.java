package com.ticktockdevelopment.simpleeventstore.EventStores;

import com.ticktockdevelopment.simpleeventstore.Messaging.Events.Event;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/23/13
 * Time: 10:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class EventDescriptor {
    public int id;
    public Event event;
    public int version;

    public EventDescriptor(int id, Event event, int version) {
        this.id = id;
        this.event = event;
        this.version = version;
    }
}
