package com.ticktockdevelopment.simpleeventstore.Messaging.Events;


import com.ticktockdevelopment.simpleeventstore.Messaging.Message;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/21/13
 * Time: 10:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class Event implements Message {
    public int Version;

    @Override
    public String toString() {
        return "Event - "+"Version:"+Version;
    }
}

