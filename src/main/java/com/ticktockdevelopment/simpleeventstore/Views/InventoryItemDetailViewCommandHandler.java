package com.ticktockdevelopment.simpleeventstore.Views;

import com.ticktockdevelopment.simpleeventstore.Core.InMemoryDatabase;
import com.ticktockdevelopment.simpleeventstore.Events.InventoryItemDeactivated;
import com.ticktockdevelopment.simpleeventstore.Infrastructure.IHandles;

public class InventoryItemDetailViewCommandHandler implements IHandles<InventoryItemDeactivated>
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
