package edu.cmu.cs.cs214.rec04;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the InheritanceSortedIntList class.
 *
 * @author Nora Shoemaker
 *
 */
public class InheritanceSortedIntListTest {
    private InheritanceSortedIntList list1;
    private InheritanceSortedIntList list2;

    /**
     * Called before each test.
     */
    @Before
    public void setUp() {
        list1 = new InheritanceSortedIntList();
        list2 = new InheritanceSortedIntList();
    }

    /**
     * Tests for the add() method.
     */
    @Test
    public void testAdd() {
        // add 5 elements to our list.
        list1.add(1);
        list1.add(3);
        list1.add(2);
        list1.add(4);
        list1.add(2);
        System.out.println(list1.getTotalAdded());
        // check that the total number of elements added is 5.
        assertTrue(list1.getTotalAdded() == 5);
        printList(list1);
    }

    /**
     * Tests for the addAll() method.
     */
    @Test
    public void testAddAll() {
        // add 5 elements to our first list.
        list1.add(1);
        list1.add(3);
        list1.add(2);
        list1.add(4);
        list1.add(2);

        // check that the total number of elements added is 5.
        assertTrue(list1.getTotalAdded() == 5);

        // add 2 elements to a second list.
        list2.add(3);
        list2.add(0);

        // check that the total number of elements added is 2.
        assertTrue(list2.getTotalAdded() == 2);

        // add the first list (5 elements) to our second list (2 elements).
        list2.addAll(list1);

        // check that the total number of elements added to our second list is 7.
        assertTrue(list2.getTotalAdded() == 7);
    }

    /**
     * Tests for remove() method to ensure it does NOT affect getTotalAdded().
     */
    @Test
    public void testRemove() {
        // Add elements
        list1.add(10);
        list1.add(20);
        list1.add(30);

        // Ensure total added count is correct
        assertEquals(3, list1.getTotalAdded());

        // Remove an element
        list1.remove(20);

        // Ensure removing an element does NOT affect the total added count.
        assertEquals(3, list1.getTotalAdded());

        // Remove an element that doesn't exist
        list1.remove(100);

        // Total added should remain the same
        assertEquals(3, list1.getTotalAdded());
    }

    /**
     * Tests for removeAll() method to ensure it does NOT affect getTotalAdded().
     */
    @Test
    public void testRemoveAll() {
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        // Add elements to list2
        list2.add(2);
        list2.add(4);

        // Ensure total added count before removing
        assertEquals(5, list1.getTotalAdded());

        // Remove elements of list2 from list1
        list1.removeAll(list2);

        // Ensure removing elements does NOT affect the total added count.
        assertEquals(5, list1.getTotalAdded());
    }

    /**
     * A helper function that prints out the contents of an IntegerList.
     * @param list IntegerList to be printed out.
     */
    private void printList(IntegerList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            System.out.print(", ");
        }
        System.out.println();
    }
}