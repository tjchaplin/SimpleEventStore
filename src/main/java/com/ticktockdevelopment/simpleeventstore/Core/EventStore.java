package com.ticktockdevelopment.simpleeventstore.Core;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/23/13
 * Time: 8:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class EventStore implements IEventStore{
    @Override
    public void SaveEvents(int aggregateId, List<Event> events, int expectedVersion) {
        //TODO: Add method
    }

    @Override
    public List<Event> GetEventsForAggregate(int aggregateId) {
        //TODO: Add Method
        return null;
    }
}
