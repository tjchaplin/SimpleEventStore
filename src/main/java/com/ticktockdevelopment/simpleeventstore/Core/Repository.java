package com.ticktockdevelopment.simpleeventstore.Core;

import com.ticktockdevelopment.simpleeventstore.Domain.AggregateRoot;
import com.ticktockdevelopment.simpleeventstore.Infrastructure.IRepository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/22/13
 * Time: 9:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class Repository implements IRepository {

    private IEventStore eventStore;

    public Repository(IEventStore eventStore) {
        this.eventStore = eventStore;
    }

    @Override
    public void Save(AggregateRoot aggregateRoot, int expectedVersion) {
        eventStore.SaveEvents(aggregateRoot.Id, aggregateRoot.GetUncommittedChanges(),expectedVersion);
    }

    @Override
    public <T extends AggregateRoot> T GetById(Class<T> type, int id) {
        T newAggregateRoot = create(type);
        List<Event> historicEvents = eventStore.GetEventsForAggregate(id);
        newAggregateRoot.LoadsFromHistory(historicEvents);
        return newAggregateRoot;
    }

    private static  <T extends AggregateRoot> T create(Class<T> type) {

        try {
            return type.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
