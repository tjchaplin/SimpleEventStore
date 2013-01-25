package com.ticktockdevelopment.simpleeventstore.Commands;

public class DeactivateInventoryItem extends Command
{
    public int InventoryItemId;
    public int OriginalVersion;

    public DeactivateInventoryItem(int inventoryItemId, int originalVersion) {
        InventoryItemId = inventoryItemId;
        OriginalVersion = originalVersion;
    }
}
