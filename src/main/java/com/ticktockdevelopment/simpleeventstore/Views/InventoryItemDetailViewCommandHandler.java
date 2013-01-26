package com.ticktockdevelopment.simpleeventstore.Views;

import com.ticktockdevelopment.simpleeventstore.Infrastructure.IHandler;
import com.ticktockdevelopment.simpleeventstore.Infrastructure.InMemoryDatabase;
import com.ticktockdevelopment.simpleeventstore.Messaging.Events.InventoryItemDeactivated;

public class InventoryItemDetailViewCommandHandler implements IHandler<InventoryItemDeactivated>
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
