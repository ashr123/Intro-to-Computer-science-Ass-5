import java.util.Comparator;
import java.util.Iterator;

public interface Tester
{
	
	public int EntryComparatorTestByName(); //Tests the PhoneBook comparator by name.
	
	/*
	 Cases to take into consideration: one of them is null,
	 both are null, first is bigger than last, using numbers,
	 the word "null" and it's variations testing the same name more than once,
	 sending the same word but with different capital letters.
	 */
	public int EntryComparatorByNumber(); 
	/*
	 Cases to test: first is null, second is null, both are null,
	 first is bigger, second is bigger, sending an integer, sending an int,
	 s0ending equals and making should you get a 0.
	 */
	
	public int GetComparatorTest();
	/*
	 Makes sure it returns the correct comparator. Check cases for different trees and different comps.
	 */
	
	public int InsertionTest();
	/*
	 Makes sure all elements are inserted in the correct order. Attempt to enter null or the same element.
	 Check if it changes the height or size of the tree after every expected false insertion.
	 */
	
	public int ToStringTest();
	
	/*
	 Just try a couple of inputs to makes sure that it strings it correctly. Have a string variable that is identical to the output you expect and
	 compare it to what the function has given. If the tree is null, if there is only one node, if there are 3, if the nodes are only on one side, 
	 a balanced tree.
	 */
	public int PerfectTreeTest();
	/*
	 Cases that are interesting to test - What if the order is linear, what if there are different objects but with the same comparator, 
	 Attempt to enter a new object to the tree with the same address, what happens with every iteration of the perfect tree builder.
	 */
	
	public int IteratorTest();
	/*
	 * Check if the root is null, check if it does it truly in order, regardless of tree composition.
	 * Throw exception if iterator attempts to go to the next element without making sure that it has next.
	 * 
	 */
	
	public int ContainsTest();
	/*
	 Stuff to check: containing null, checking for other types that are stored within the tree, check if it finds it regardless of levels.
	 */
	
	public int RemoveTest();
	/*
	 * Trying to remove an element that isn't there, trying to remove from an empty tree, trying to remove the same element twice,
	 * Trying to remove with 1 left node, 1 right node and both nodes, build a perfect tree with 4/5 levels and wrecking it.
	 */
	
	public int PhonebookAddTest();
	/*
	 * Attempt to add non consecutive entries. Try to add null. Try to add illegal numbers.
	 * Make sure the order is correct. Try to add identical number but different name and vice versa.
	 * Making sure that the true or false to the addition is correct.
	 */
	
	public int PhonebookDeletionTest();
	/*
	 * Time to wreck shit! Make sure that you can destroy a tree with remove. Make sure the PhoneNumber is ruined in both trees, 
	 * Try to remove something that isn't in the tree, try to input something that isn't a String or Int, try to remove something from the middle of a tree,
	 * the prime node, a last node. deleting from an empty tree, from tree with a single element, from tree with the desired string/number and trying to do it again.
	 */
}