package com.ticktockdevelopment.simpleeventstore.Views;

import com.ticktockdevelopment.simpleeventstore.Core.InMemoryDatabase;
import com.ticktockdevelopment.simpleeventstore.Events.InventoryItemCreated;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/26/13
 * Time: 6:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class InventoryItemDetailViewEventHandlerTest {
    private InventoryItemDetailViewEventHandler inventoryItemDetailViewEventHandler;
    private InventoryItemCreated inventoryItemCreated;
    private int testId;
    private String testName;

    @Before
    public void setUp() throws Exception {
        testId = 1;
        testName = "testName";
        inventoryItemDetailViewEventHandler = new InventoryItemDetailViewEventHandler();
        inventoryItemCreated = new InventoryItemCreated(testId,testName);
    }

    @After
    public void tearDown() throws Exception {
        InMemoryDatabase.inventoryItemDetails.clear();
    }

    @Test
    public void When_Event_Is_Inventory_Item_Created_Should_Return_True() throws Exception {
        boolean result = inventoryItemDetailViewEventHandler.CanHandle(inventoryItemCreated);
        Assert.assertTrue(result);
    }

    @Test
    public void When_Hanlding_Inventory_Item_Created_Should_Add_To_Database() throws Exception {
        inventoryItemDetailViewEventHandler.Handle(inventoryItemCreated);

        Assert.assertTrue(InMemoryDatabase.inventoryItemDetails.size() == 1);
    }
}


