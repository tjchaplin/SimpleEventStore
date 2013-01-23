package com.ticktockdevelopment.simpleeventstore.Infrastructure;

import com.ticktockdevelopment.simpleeventstore.Domain.AggregateRoot;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/22/13
 * Time: 9:05 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IRepository {

    void Save(AggregateRoot aggregateRoot, int expectedVersion);

    <T extends AggregateRoot> T GetById(Class<T> type, int id);
}
