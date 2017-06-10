public class Phonebook
{
	private BinarySearchTree namesTree;
	private BinarySearchTree numbersTree;
	
	public Phonebook()
	{
		namesTree=new BinarySearchTree(new EntryComparatorByName());
		numbersTree=new BinarySearchTree(new EntryComparatorByNumber());
	}
	
	public PhoneEntry lookUp(String name)
	{
		// create an Entry with the given name and a "dummy" number (1)
		// This "dummy" number will be ignored when executing getData
		PhoneEntry lookFor=new PhoneEntry(name, 1);
		return (PhoneEntry)namesTree.findData(lookFor);
	}
	
	public PhoneEntry lookUp(int number)
	{
		// create an Entry with a "dummy" name and the given number
		// This "dummy" name will be ignored when executing getData
		PhoneEntry lookFor=new PhoneEntry("dummy", number);
		return (PhoneEntry)numbersTree.findData(lookFor);
	}
	
	public void balance()
	{
		namesTree=new BinarySearchTree(namesTree);
		numbersTree=new BinarySearchTree(numbersTree);
	}
	
	public Object exportNames()
	{
		return this.namesTree;
	}
	
	public Object exportNumbers()
	{
		return this.numbersTree;
	}
	
	// Complete the following methods:
	public boolean add(PhoneEntry newEntry)//Adds a new entry to the two trees
	{
		//throw new UnsupportedOperationException();
//		if (newEntry==null)
//			return false;
		if (!(((BinarySearchTree)exportNames()).contains(newEntry)) && !(((BinarySearchTree)exportNumbers())
			                                                                 .contains(newEntry)))
		{
			((BinarySearchTree)exportNames()).insert(newEntry);
			((BinarySearchTree)exportNumbers()).insert(newEntry);
			return true;
		}
		return false;
	}
	
	public boolean delete(String name)//Deletes an node that has the same name & number according to the given name
	{
		PhoneEntry toRemove=lookUp(name);
		/* Enter you code here:*/
		//throw new UnsupportedOperationException();
		if (toRemove!=null)
		{
			((BinarySearchTree)exportNames()).remove(toRemove);
			((BinarySearchTree)exportNumbers()).remove(toRemove);
			return true;
		}
		return false;
	}
	
	public boolean delete(int number)//Deletes an node that has the same name & number according to the given number
	{
		PhoneEntry toRemove=lookUp(number);
		/* Enter you code here:*/
		//throw new UnsupportedOperationException();
		if (toRemove!=null)
		{
			((BinarySearchTree)exportNumbers()).remove(toRemove);
			((BinarySearchTree)exportNames()).remove(toRemove);
			return true;
		}
		return false;
	}
}