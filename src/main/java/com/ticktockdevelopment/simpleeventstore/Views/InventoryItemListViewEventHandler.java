package com.ticktockdevelopment.simpleeventstore.Views;

import com.ticktockdevelopment.simpleeventstore.Core.InMemoryDatabase;
import com.ticktockdevelopment.simpleeventstore.DAO.InventoryItemListDto;
import com.ticktockdevelopment.simpleeventstore.Events.InventoryItemCreated;
import com.ticktockdevelopment.simpleeventstore.Infrastructure.IHandles;

public class InventoryItemListViewEventHandler implements IHandles<InventoryItemCreated> {

    @Override
    public <Y> boolean CanHandle(Y type) {
        return type instanceof InventoryItemCreated;
    }

    @Override
    public void Handle(InventoryItemCreated message) {
        InMemoryDatabase.inventoryItemList.add(new InventoryItemListDto(message.Id,message.name));
    }
}
