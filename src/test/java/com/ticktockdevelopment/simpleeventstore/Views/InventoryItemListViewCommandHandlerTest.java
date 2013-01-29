package com.ticktockdevelopment.simpleeventstore.Views;

import com.ticktockdevelopment.simpleeventstore.DAO.InventoryItemListDto;
import com.ticktockdevelopment.simpleeventstore.Infrastructure.InMemoryDatabase;
import com.ticktockdevelopment.simpleeventstore.Messaging.Events.InventoryItemDeactivated;
import com.ticktockdevelopment.simpleeventstore.Views.handlers.InventoryItemListViewInventoryItemDeactivatedHandler;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventoryItemListViewCommandHandlerTest {

    private InventoryItemListViewInventoryItemDeactivatedHandler inventoryItemListViewInventoryItemDeactivatedHandler;
    private InventoryItemDeactivated inventoryItemDeactivated;
    private int testId;

    @Before
    public void setUp() throws Exception {
        testId = 1;
        inventoryItemListViewInventoryItemDeactivatedHandler = new InventoryItemListViewInventoryItemDeactivatedHandler();
        inventoryItemDeactivated = new InventoryItemDeactivated(testId);
        InMemoryDatabase.inventoryItemList.add(new InventoryItemListDto(1,"TestName"));
    }

    @After
    public void tearDown() throws Exception {
        InMemoryDatabase.inventoryItemList.clear();
    }

    @Test
    public void When_Command_Is_Inventory_Item_Deactivated_Should_Return_True() throws Exception {
        boolean result = inventoryItemListViewInventoryItemDeactivatedHandler.CanHandle(inventoryItemDeactivated);
        Assert.assertTrue(result);
    }

    @Test
    public void When_Hanlding_Inventory_Item_Deactivated_Should_Remove_To_Database() throws Exception {
        inventoryItemListViewInventoryItemDeactivatedHandler.Handle(inventoryItemDeactivated);

        Assert.assertTrue(InMemoryDatabase.inventoryItemList.size() == 0);
    }
}
