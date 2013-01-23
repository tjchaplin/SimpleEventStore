package com.ticktockdevelopment.simpleeventstore.Core;

import com.ticktockdevelopment.simpleeventstore.Infrastructure.IEventPublisher;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/23/13
 * Time: 10:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class EventStoreTest {

    private IEventPublisher publisher;
    private EventStore eventStore;

    @Before
    public void setUp() throws Exception {
        publisher = mock(IEventPublisher.class);
        eventStore = new EventStore(publisher);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void When_Saving_Events_For_Correct_Version_Should_Publish_Events(){
        Event testEvent = new Event();
        List<Event> events = Arrays.asList(testEvent);
        eventStore.SaveEvents(1,events,-1);
        verify(publisher).Publish(testEvent);
    }

    @Test
    public void When_Saving_Events_For_incorrect_Version_Should_Not_Publish(){
        Event testEvent = new Event();
        List<Event> events = Arrays.asList(testEvent);
        eventStore.SaveEvents(1,events,1);
        verify(publisher, never()).Publish(testEvent);
    }

    @Test
    public void When_Getting_Events_For_Aggregate_Root_Should_Return_Events() {
        Event testEvent = new Event();
        List<Event> events = Arrays.asList(testEvent);
        eventStore.SaveEvents(1,events,-1);

        List<Event> retrievedEvents = eventStore.GetEventsForAggregate(1);
        Assert.assertTrue(retrievedEvents.contains(testEvent));
    }

    @Test
    public void When_Getting_Events_For_Aggregate_Root_Should_Return_Empty_List_If_None_Exist() {
        List<Event> retrievedEvents = eventStore.GetEventsForAggregate(1);
        Assert.assertTrue(retrievedEvents.isEmpty());
    }
}
