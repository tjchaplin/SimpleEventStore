package com.ticktockdevelopment.simpleeventstore.CommandHandlers;

import com.ticktockdevelopment.simpleeventstore.Domain.InventoryItem;
import com.ticktockdevelopment.simpleeventstore.Events.InventoryItemCreated;
import com.ticktockdevelopment.simpleeventstore.Events.InventoryItemDeactivated;
import com.ticktockdevelopment.simpleeventstore.Infrastructure.IRepository;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/25/13
 * Time: 9:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class InventoryCommandHandlers {
    private IRepository repository;

    public InventoryCommandHandlers(IRepository repository) {
        this.repository = repository;
    }

    public void Handle(InventoryItemCreated message)
    {
        InventoryItem inventoryItem = new InventoryItem(message.Id,message.name);
        repository.Save(inventoryItem,-1);
    }

    public void Handle(InventoryItemDeactivated message)
    {
        InventoryItem inventoryItem = repository.GetById(InventoryItem.class,message.Id);
        inventoryItem.Deactivate();
    }
}
