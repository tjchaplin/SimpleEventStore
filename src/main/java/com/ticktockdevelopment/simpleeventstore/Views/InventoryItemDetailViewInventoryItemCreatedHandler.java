package com.ticktockdevelopment.simpleeventstore.Views;

import com.ticktockdevelopment.simpleeventstore.DAO.InventoryItemDetailsDto;
import com.ticktockdevelopment.simpleeventstore.Infrastructure.IHandler;
import com.ticktockdevelopment.simpleeventstore.Infrastructure.InMemoryDatabase;
import com.ticktockdevelopment.simpleeventstore.Messaging.Commands.CreateInventoryItem;
import com.ticktockdevelopment.simpleeventstore.Messaging.Events.InventoryItemCreated;

public class InventoryItemDetailViewInventoryItemCreatedHandler  implements IHandler<InventoryItemCreated>
{
    @Override
    public <T> boolean CanHandle(T type) {
        return type instanceof CreateInventoryItem;
    }

    @Override
    public void Handle(InventoryItemCreated message) {
        InMemoryDatabase.inventoryItemDetails.put(String.valueOf(message.Id),new InventoryItemDetailsDto(message.Id,message.name,0,0));
    }

}
