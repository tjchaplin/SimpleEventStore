package com.ticktockdevelopment.simpleeventstore.Views;

import com.ticktockdevelopment.simpleeventstore.Infrastructure.InMemoryDatabase;
import com.ticktockdevelopment.simpleeventstore.Messaging.Events.InventoryItemCreated;
import com.ticktockdevelopment.simpleeventstore.Views.handlers.InventoryItemListViewInventoryItemCreatedHandler;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventoryItemListViewEventHandlerTest {
    private InventoryItemListViewInventoryItemCreatedHandler inventoryItemListViewInventoryItemCreatedHandler;
    private InventoryItemCreated inventoryItemCreated;
    private int testId;
    private String testName;

    @Before
    public void setUp() throws Exception {
        testId = 1;
        testName = "testName";
        inventoryItemListViewInventoryItemCreatedHandler = new InventoryItemListViewInventoryItemCreatedHandler();
        inventoryItemCreated = new InventoryItemCreated(testId,testName);
    }

    @After
    public void tearDown() throws Exception {
        InMemoryDatabase.inventoryItemList.clear();
    }

    @Test
    public void When_Event_Is_Inventory_Item_Created_Should_Return_True() throws Exception {
        boolean result = inventoryItemListViewInventoryItemCreatedHandler.CanHandle(inventoryItemCreated);
        Assert.assertTrue(result);
    }

    @Test
    public void When_Hanlding_Inventory_Item_Created_Should_Add_To_Database() throws Exception {
        inventoryItemListViewInventoryItemCreatedHandler.Handle(inventoryItemCreated);

        Assert.assertTrue(InMemoryDatabase.inventoryItemDetails.size() == 1);
    }
}
