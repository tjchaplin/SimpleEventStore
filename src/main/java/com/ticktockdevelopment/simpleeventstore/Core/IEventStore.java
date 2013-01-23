package com.ticktockdevelopment.simpleeventstore.Core;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/22/13
 * Time: 9:13 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IEventStore {
    void SaveEvents(int aggregateId,List<Event> events, int expectedVersion);

    List<Event> GetEventsForAggregate(int aggregateId);
}
