package SimpleEventStore.Infrastructure;

import SimpleEventStore.Domain.AggregateRoot;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/22/13
 * Time: 9:05 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IRepository {

    void Save(AggregateRoot aggregateRoot, int expectedVersion);

    <T extends AggregateRoot> T GetById(int id);
}
