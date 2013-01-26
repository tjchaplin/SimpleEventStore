package com.ticktockdevelopment.simpleeventstore.Views;

import com.ticktockdevelopment.simpleeventstore.DAO.InventoryItemListDto;
import com.ticktockdevelopment.simpleeventstore.Infrastructure.IHandler;
import com.ticktockdevelopment.simpleeventstore.Infrastructure.InMemoryDatabase;
import com.ticktockdevelopment.simpleeventstore.Messaging.Events.InventoryItemCreated;

public class InventoryItemListViewEventHandler implements IHandler<InventoryItemCreated> {

    @Override
    public <Y> boolean CanHandle(Y type) {
        return type instanceof InventoryItemCreated;
    }

    @Override
    public void Handle(InventoryItemCreated message) {
        InMemoryDatabase.inventoryItemList.add(new InventoryItemListDto(message.Id,message.name));
    }
}
