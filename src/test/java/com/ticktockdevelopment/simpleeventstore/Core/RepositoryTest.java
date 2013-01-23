package com.ticktockdevelopment.simpleeventstore.Core;

import com.ticktockdevelopment.simpleeventstore.Domain.AggregateRootTest;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/23/13
 * Time: 8:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class RepositoryTest {

    private IEventStore eventStore;
    private Repository repository;

    @Before
    public void setUp() throws Exception {
        eventStore = mock(EventStore.class);
        repository = new Repository(eventStore);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void When_Saving_Saving_Event_Should_Store_In_Event_Store() throws Exception {
        int testAggregateRootId = 1;
        AggregateRootTest aggregateRootTest = new AggregateRootTest();
        repository.Save(aggregateRootTest,testAggregateRootId);
        verify(eventStore).SaveEvents(anyInt(),anyList(),anyInt());
    }

    @Test
    public void When_Getting_Aggregrate_Root_By_Id_Should_Not_Be_Null() throws Exception {
        AggregateRootTest aggregateRootTest =repository.GetById(AggregateRootTest.class,1);
        Assert.assertTrue(aggregateRootTest != null);
    }

    @Test
    public void When_Getting_Aggregrate_Root_By_Id_Should_Get_Events_From_Event_Store() throws Exception {
        repository.GetById(AggregateRootTest.class,1);
        verify(eventStore).GetEventsForAggregate(anyInt());
    }

    @Test
    public void When_Getting_Aggregrate_Root_By_Id_Should_Get_Populate_Events_Into_Aggregate() throws Exception {
        AggregateRootTest aggregateRootTest = repository.GetById(AggregateRootTest.class,1);
        Assert.assertTrue(aggregateRootTest.didLoadFromHistory);
    }
}
