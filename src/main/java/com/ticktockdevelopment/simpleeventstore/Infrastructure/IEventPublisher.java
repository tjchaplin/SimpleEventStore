package com.ticktockdevelopment.simpleeventstore.Infrastructure;

import com.ticktockdevelopment.simpleeventstore.Messaging.Events.Event;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/21/13
 * Time: 10:28 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IEventPublisher {
    <T extends Event> void Publish(T event);
}
