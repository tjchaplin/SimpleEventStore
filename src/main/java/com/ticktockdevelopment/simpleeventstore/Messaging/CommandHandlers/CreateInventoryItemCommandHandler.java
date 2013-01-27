package com.ticktockdevelopment.simpleeventstore.Messaging.CommandHandlers;

import com.ticktockdevelopment.simpleeventstore.Domain.InventoryItem;
import com.ticktockdevelopment.simpleeventstore.Infrastructure.IHandler;
import com.ticktockdevelopment.simpleeventstore.Infrastructure.IRepository;
import com.ticktockdevelopment.simpleeventstore.Messaging.Commands.CreateInventoryItem;

public class CreateInventoryItemCommandHandler implements IHandler<CreateInventoryItem>
{
    private IRepository repository;

    public CreateInventoryItemCommandHandler(IRepository repository) {
            this.repository = repository;
    }

    @Override
    public <Y> boolean CanHandle(Y type) {
        return type instanceof CreateInventoryItem;
    }

    public void Handle(CreateInventoryItem message)
    {
        InventoryItem inventoryItem = new InventoryItem(message.inventoryItemId,message.name);
        repository.Save(inventoryItem,-1);
    }
}
