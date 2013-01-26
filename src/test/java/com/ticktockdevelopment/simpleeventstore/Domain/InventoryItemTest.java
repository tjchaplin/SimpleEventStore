package com.ticktockdevelopment.simpleeventstore.Domain;

import com.ticktockdevelopment.simpleeventstore.Messaging.Events.Event;
import com.ticktockdevelopment.simpleeventstore.Messaging.Events.InventoryItemCreated;
import com.ticktockdevelopment.simpleeventstore.Messaging.Events.InventoryItemDeactivated;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/23/13
 * Time: 10:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class InventoryItemTest {
    private InventoryItem inventoryItem;

    @Before
    public void setUp() throws Exception {
        inventoryItem = new InventoryItem();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void When_Applying_Activiated_Event_Should_Set_Activated_To_True(){
        Event event = new InventoryItemCreated(1,"test");
        inventoryItem.Apply(event);

        Assert.assertTrue(inventoryItem.isActivated());
    }


    @Test
    public void When_Applying_Deactivated_Event_Should_Set_Activated_To_False(){
        Event event = new InventoryItemDeactivated(1);
        inventoryItem.Apply(event);

        Assert.assertFalse(inventoryItem.isActivated());
    }
}
