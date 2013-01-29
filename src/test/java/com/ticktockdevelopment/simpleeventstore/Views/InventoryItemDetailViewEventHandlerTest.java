package com.ticktockdevelopment.simpleeventstore.Views;

import com.ticktockdevelopment.simpleeventstore.Infrastructure.InMemoryDatabase;
import com.ticktockdevelopment.simpleeventstore.Messaging.Events.InventoryItemCreated;
import com.ticktockdevelopment.simpleeventstore.Views.handlers.InventoryItemDetailViewInventoryItemCreatedHandler;
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
    private InventoryItemDetailViewInventoryItemCreatedHandler inventoryItemDetailViewInventoryItemCreatedHandler;
    private InventoryItemCreated inventoryItemCreated;
    private int testId;
    private String testName;

    @Before
    public void setUp() throws Exception {
        testId = 1;
        testName = "testName";
        inventoryItemDetailViewInventoryItemCreatedHandler = new InventoryItemDetailViewInventoryItemCreatedHandler();
        inventoryItemCreated = new InventoryItemCreated(testId,testName);
    }

    @After
    public void tearDown() throws Exception {
        InMemoryDatabase.inventoryItemDetails.clear();
    }

    @Test
    public void When_Event_Is_Inventory_Item_Created_Should_Return_True() throws Exception {
        boolean result = inventoryItemDetailViewInventoryItemCreatedHandler.CanHandle(inventoryItemCreated);
        Assert.assertTrue(result);
    }

    @Test
    public void When_Hanlding_Inventory_Item_Created_Should_Add_To_Database() throws Exception {
        inventoryItemDetailViewInventoryItemCreatedHandler.Handle(inventoryItemCreated);

        Assert.assertTrue(InMemoryDatabase.inventoryItemDetails.size() == 1);
    }
}


