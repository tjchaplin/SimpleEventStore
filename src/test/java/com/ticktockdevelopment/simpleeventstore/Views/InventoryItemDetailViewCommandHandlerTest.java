package com.ticktockdevelopment.simpleeventstore.Views;

import com.ticktockdevelopment.simpleeventstore.Core.InMemoryDatabase;
import com.ticktockdevelopment.simpleeventstore.DAO.InventoryItemDetailsDto;
import com.ticktockdevelopment.simpleeventstore.Events.InventoryItemDeactivated;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/26/13
 * Time: 5:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class InventoryItemDetailViewCommandHandlerTest {

    private InventoryItemDetailViewCommandHandler inventoryItemDetailViewCommandHandler;
    private InventoryItemDeactivated inventoryItemDeactivated;
    private int testId;

    @Before
    public void setUp() throws Exception {
        testId = 1;
        inventoryItemDetailViewCommandHandler = new InventoryItemDetailViewCommandHandler();
        inventoryItemDeactivated = new InventoryItemDeactivated(testId);
        InMemoryDatabase.inventoryItemDetails.put(String.valueOf(testId),new InventoryItemDetailsDto(1,"TestName",0,0));
    }

    @After
    public void tearDown() throws Exception {
        InMemoryDatabase.inventoryItemDetails.clear();
    }

    @Test
    public void When_Command_Is_Inventory_Item_Deactivated_Should_Return_True() throws Exception {
        boolean result = inventoryItemDetailViewCommandHandler.CanHandle(inventoryItemDeactivated);
        Assert.assertTrue(result);
    }

    @Test
    public void When_Hanlding_Inventory_Item_Deactivated_Should_Remove_To_Database() throws Exception {
        inventoryItemDetailViewCommandHandler.Handle(inventoryItemDeactivated);

        Assert.assertTrue(InMemoryDatabase.inventoryItemDetails.size() == 0);
    }
}

