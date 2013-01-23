package com.ticktockdevelopment.simpleeventstore.Core;

import com.ticktockdevelopment.simpleeventstore.Domain.InventoryItem;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

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
    public void testSave() throws Exception {

    }

    @Test
    public void When_Getting_Aggregrate_Root_By_Id_Should_Not_Be_Null_If_It_Exists() throws Exception {
        InventoryItem inventoryItem =repository.GetById(InventoryItem.class,1);
        Assert.assertTrue(inventoryItem != null);

    }
}
