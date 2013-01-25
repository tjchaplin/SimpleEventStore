package com.ticktockdevelopment.simpleeventstore.Views;

import com.ticktockdevelopment.simpleeventstore.DAO.InventoryItemDetailsDto;
import com.ticktockdevelopment.simpleeventstore.DAO.InventoryItemListDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryDatabase
{
    public static Map<String,InventoryItemDetailsDto> inventoryItemDetails = new HashMap<String,InventoryItemDetailsDto>();
    public static List<InventoryItemListDto> inventoryItemList = new ArrayList<InventoryItemListDto>();
}
