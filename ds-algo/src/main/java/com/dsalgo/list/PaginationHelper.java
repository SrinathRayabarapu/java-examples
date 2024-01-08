package com.dsalgo.list;

import java.util.List;

public class PaginationHelper<I> {

    private List<I> collection;
    private int itemsPerPage;

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return collection.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return (collection.size() / itemsPerPage) + ((collection.size() % itemsPerPage) > 0 ? 1 : 0);
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {

        if(pageIndex < collection.size() / itemsPerPage)
            return itemsPerPage;

        if(pageIndex == collection.size() / itemsPerPage)
            return collection.size() % itemsPerPage;

        return -1;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {

        if(itemIndex < 0 || collection.size() <= itemIndex)
            return -1;

        return itemIndex / itemsPerPage;
    }

}
