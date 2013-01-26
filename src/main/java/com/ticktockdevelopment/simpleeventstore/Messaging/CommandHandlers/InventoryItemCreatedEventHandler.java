package com.ticktockdevelopment.simpleeventstore.Messaging.CommandHandlers;

import com.ticktockdevelopment.simpleeventstore.Domain.InventoryItem;
import com.ticktockdevelopment.simpleeventstore.Infrastructure.IHandler;
import com.ticktockdevelopment.simpleeventstore.Infrastructure.IRepository;
import com.ticktockdevelopment.simpleeventstore.Messaging.Events.InventoryItemCreated;

public class InventoryItemCreatedEventHandler implements IHandler<InventoryItemCreated>
{
    private IRepository repository;

    public InventoryItemCreatedEventHandler(IRepository repository) {
            this.repository = repository;
    }

    @Override
    public <Y> boolean CanHandle(Y type) {
        return type instanceof InventoryItemCreated;
    }

    public void Handle(InventoryItemCreated message)
    {
        InventoryItem inventoryItem = new InventoryItem(message.Id,message.name);
        repository.Save(inventoryItem,-1);
    }
}
