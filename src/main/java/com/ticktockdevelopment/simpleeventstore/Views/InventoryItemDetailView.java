package com.ticktockdevelopment.simpleeventstore.Views;

import com.ticktockdevelopment.simpleeventstore.Core.InMemoryDatabase;
import com.ticktockdevelopment.simpleeventstore.DAO.InventoryItemDetailsDto;
import com.ticktockdevelopment.simpleeventstore.Events.InventoryItemCreated;
import com.ticktockdevelopment.simpleeventstore.Events.InventoryItemDeactivated;
import com.ticktockdevelopment.simpleeventstore.Infrastructure.IHandles;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/25/13
 * Time: 9:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class InventoryItemDetailView {

    public static class InventoryItemCreatedHandler implements IHandles<InventoryItemCreated>
    {
        @Override
        public <T> boolean CanHandle(T type) {
            return type instanceof InventoryItemCreated;
        }

        @Override
        public  void Handle(InventoryItemCreated message) {
            InMemoryDatabase.inventoryItemDetails.put(String.valueOf(message.Id),new InventoryItemDetailsDto(message.Id,message.name,0,0));
        }
    }

    public static class InventoryItemDeactivatedHandler implements IHandles<InventoryItemDeactivated>
    {
        @Override
        public <T> boolean CanHandle(T type) {
            return type instanceof InventoryItemDeactivated;
        }

        @Override
        public void Handle(InventoryItemDeactivated message) {
            InMemoryDatabase.inventoryItemDetails.remove(String.valueOf(message.Id));
        }
    }
}
