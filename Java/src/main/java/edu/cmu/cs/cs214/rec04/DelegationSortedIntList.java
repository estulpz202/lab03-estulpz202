package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList {
    // SortedIntList instance for delegation.
    private final SortedIntList sortedList;
    // Ttracks the number of attempted additions.
    private int totalAdded;

    /**
     * Constructs a new DelegationSortedIntList.
     */
    public DelegationSortedIntList() {
        this.sortedList = new SortedIntList();
        this.totalAdded = 0;
    }

    /**
     * Adds the specified int to the sorted list.
     * Updates counter.
     *
     * @param num an integer to be added to the list
     * @return true if the list is changed as a result of the call
     */
    @Override
    public boolean add(int num) {
        totalAdded++;
        return sortedList.add(num);
    }

    /**
     * Adds all of the elements of the IntegerList to the list.
     * Updates counter.
     *
     * @param list IntegerList containing elements to be added to the list
     * @return true if the list changed as a result of the call
     */
    @Override
    public boolean addAll(IntegerList list) {
        totalAdded += list.size();
        return sortedList.addAll(list);
    }

    /**
     * Returns the total number of attempted additions.
     *
     * @return total number of elements attempted to be added
     */
    public int getTotalAdded() {
        return totalAdded;
    }

    // Delegate remaining methods to sortedList

    @Override
    public int get(int index) {
        return sortedList.get(index);
    }

    @Override
    public boolean remove(int num) {
        return sortedList.remove(num);
    }

    @Override
    public boolean removeAll(IntegerList list) {
        return sortedList.removeAll(list);
    }

    @Override
    public int size() {
        return sortedList.size();
    }
}