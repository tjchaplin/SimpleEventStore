package SimpleEventStore.Core;

import SimpleEventStore.Domain.AggregateRoot;
import SimpleEventStore.Domain.InventoryItem;
import SimpleEventStore.Infrastructure.IRepository;

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
    public <T extends AggregateRoot> T GetById(int id) {
        T newAggregateRoot = null;
        newAggregateRoot = create(newAggregateRoot);
        List<Event> historicEvents = eventStore.GetEventsForAggregate(id);
        newAggregateRoot.LoadsFromHistory(historicEvents);
        return newAggregateRoot;
    }


    //TODO: This breaks SRP+More and needs to be reworked
    private static  <T extends AggregateRoot> T create(T aggregateRoot) {
        if (aggregateRoot instanceof InventoryItem)
            return  (T) new InventoryItem();

        return null;
    }


}
