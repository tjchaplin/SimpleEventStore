package com.ticktockdevelopment.simpleeventstore.Views;

import com.ticktockdevelopment.simpleeventstore.DAO.InventoryItemDetailsDto;
import com.ticktockdevelopment.simpleeventstore.Infrastructure.InMemoryDatabase;

import java.util.ArrayList;
import java.util.List;

public class InventoryItemDetailView {

    public List<InventoryItemDetailsDto> GetView()
    {
        List<InventoryItemDetailsDto> details =new ArrayList<InventoryItemDetailsDto>(InMemoryDatabase.inventoryItemDetails.values());
        return details;
    }
}

