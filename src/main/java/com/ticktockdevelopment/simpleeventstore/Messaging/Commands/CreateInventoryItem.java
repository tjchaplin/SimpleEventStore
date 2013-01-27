package com.ticktockdevelopment.simpleeventstore.Messaging.Commands;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/27/13
 * Time: 9:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class CreateInventoryItem extends Command {
    public int inventoryItemId;
    public String name;

    public CreateInventoryItem(int inventoryItemId, String name) {
        this.inventoryItemId = inventoryItemId;
        this.name = name;
    }
}
