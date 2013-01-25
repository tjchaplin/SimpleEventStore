package com.ticktockdevelopment.simpleeventstore.DAO;

/**
 * Created with IntelliJ IDEA.
 * User: tchaplin
 * Date: 1/25/13
 * Time: 9:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class InventoryItemListDto {
    public int Id;
    public String Name;

    public InventoryItemListDto(int id, String name) {
        Id = id;
        Name = name;
    }
}
