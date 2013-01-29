package com.ticktockdevelopment.simpleeventstore.Views;

import com.ticktockdevelopment.simpleeventstore.DAO.InventoryItemDetailsDto;
import com.ticktockdevelopment.simpleeventstore.Infrastructure.InMemoryDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/29/13
 * Time: 10:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class InventoryItemDetailView {

    public List<InventoryItemDetailsDto> GetView()
    {
        List<InventoryItemDetailsDto> details =new ArrayList<InventoryItemDetailsDto>(InMemoryDatabase.inventoryItemDetails.values());
        return details;
    }
}

