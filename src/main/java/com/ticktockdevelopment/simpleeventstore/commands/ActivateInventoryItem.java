package com.ticktockdevelopment.simpleeventstore.Commands;

public class ActivateInventoryItem extends Command
{
    public int InventoryItemId;
    public int OriginalVersion;

    public ActivateInventoryItem(int inventoryItemId, int originalVersion) {
        InventoryItemId = inventoryItemId;
        OriginalVersion = originalVersion;
    }
}
