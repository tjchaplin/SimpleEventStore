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


    //TODO: This breaks SRP+More and needs to be reworked
    private static  <T extends AggregateRoot> T create(Class<T> type) {

        try {
            return type.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


        return null;
    }
}
