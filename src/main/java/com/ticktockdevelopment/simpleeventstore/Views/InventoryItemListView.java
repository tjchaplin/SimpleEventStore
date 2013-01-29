package com.ticktockdevelopment.simpleeventstore.Views;

import com.ticktockdevelopment.simpleeventstore.DAO.InventoryItemListDto;
import com.ticktockdevelopment.simpleeventstore.Infrastructure.InMemoryDatabase;

import java.util.List;

public class InventoryItemListView
{
    public List<InventoryItemListDto> GetView()
    {
        return InMemoryDatabase.inventoryItemList;
    }
}
