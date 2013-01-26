package com.ticktockdevelopment.simpleeventstore.Views;

import com.ticktockdevelopment.simpleeventstore.Core.InMemoryDatabase;
import com.ticktockdevelopment.simpleeventstore.DAO.InventoryItemDetailsDto;
import com.ticktockdevelopment.simpleeventstore.Events.InventoryItemCreated;
import com.ticktockdevelopment.simpleeventstore.Infrastructure.IHandles;

public class InventoryItemDetailViewEventHandler  implements IHandles<InventoryItemCreated>
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
