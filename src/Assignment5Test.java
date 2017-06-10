import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by nadav on 1/18/2017.
 */
@SuppressWarnings("WeakerAccess")
public class Assignment5Test
{
	public static void main(String[] args)
	{
		System.out.println("--------------Start of Test--------------");
		EntryComparatorByNameTest();
		EntryComparatorByNumberTest();
		BinaryNodeTest();
		BinarySearchNodeTest();
		BinaryTreeInOrderIterator();
		PhonebookTest();
		System.out.print("--------------End of Test--------------");
	}
	
	public static void EntryComparatorByNameTest()
	{
		String method="EntryByNameComparator-compare";
		EntryComparatorByName byName=new EntryComparatorByName();
		PhoneEntry phoneEntry=new PhoneEntry("aa", 1);
		PhoneEntry phoneEntry1=new PhoneEntry("ab", 1);
		Test(-1, Integer.signum(byName.compare(phoneEntry, phoneEntry1)), method);
		Test(1, Integer.signum(byName.compare(phoneEntry1, phoneEntry)), method);
		Test(0, Integer.signum(byName.compare(phoneEntry, phoneEntry)), method);
	}
	
	
	public static void EntryComparatorByNumberTest()
	{
		String method="EntryByNumberComparator-compare";
		EntryComparatorByNumber byNumber=new EntryComparatorByNumber();
		PhoneEntry phoneEntry=new PhoneEntry("name", 1);
		PhoneEntry phoneEntry1=new PhoneEntry("name", 2);
		Test(-1, Integer.signum(byNumber.compare(phoneEntry, phoneEntry1)), method);
		Test(1, Integer.signum(byNumber.compare(phoneEntry1, phoneEntry)), method);
		Test(0, Integer.signum(byNumber.compare(phoneEntry, phoneEntry)), method);
	}
	
	public static void BinaryNodeTest()
	{
		String method="BinaryNode-toString";
		BinaryNode root=new BinaryNode(1);
		Test("1\n", root.toString(), method);
		BinaryNode Root_Left=new BinaryNode(2);
		root.left=Root_Left;
		Test("  2\n1\n", root.toString(), method);
		BinaryNode Root_Right=new BinaryNode(3);
		root.right=Root_Right;
		Test("  2\n1\n  3\n", root.toString(), method);
		Root_Right.left=new BinaryNode(4);
		Test("  2\n1\n    4\n  3\n", root.toString(), method);
		BinaryNode Root_Left_Right=new BinaryNode(5);
		Root_Left.right=Root_Left_Right;
		Test("  2\n    5\n1\n    4\n  3\n", root.toString(), method);
		Root_Left_Right.left=new BinaryNode(6);
		Test("  2\n      6\n    5\n1\n    4\n  3\n", root.toString(), method);
	}
	
	public static void BinarySearchNodeTest()
	{
		String method="BinarySearchNode-";
		Comparator c=new NumberComparator();
		BinarySearchNode node=new BinarySearchNode(4, c);
		
		//Test getComparator
		Test(c, node.getComparator(), method+"getComparator");
		BinarySearchTree tree=new BinarySearchTree(c);
		//Test insert
		tree.insert(4);
		Test("4\n", tree.toString(), method+"insert");
		tree.insert(4);
		Test("4\n", tree.toString(), method+"insert");
		tree.insert(2);
		Test("  2\n4\n", tree.toString(), method+"insert");
		tree.insert(6);
		Test("  2\n4\n  6\n", tree.toString(), method+"insert");
		tree.insert(1);
		Test("    1\n  2\n4\n  6\n", tree.toString(), method+"insert");
		tree.insert(3);
		Test("    1\n  2\n    3\n4\n  6\n", tree.toString(), method+"insert");
		tree.insert(5);
		Test("    1\n  2\n    3\n4\n    5\n  6\n", tree.toString(), method+"insert");
		tree.insert(7);
		Test("    1\n  2\n    3\n4\n    5\n  6\n    7\n", tree.toString(),
		     method+"insert");
		tree.insert(8);
		Test("    1\n  2\n    3\n4\n    5\n  6\n    7\n      8\n", tree.toString(),
		     method+"insert");
		
		//Test buildPerfectTree and FillTheNodes
		BinarySearchTree balancedTree=new BinarySearchTree(tree);
		Test("      1\n    2\n  3\n    4\n5\n    6\n  7\n    8\n", balancedTree.toString(),
		     method+"buildPerfectTree and FillTheNodes");
		
		//Test contains
		BinarySearchNode binarySNode=new BinarySearchNode(2, c);
		binarySNode.insert(1);
		binarySNode.insert(3);
		binarySNode.insert(4);
		binarySNode.insert(5);
		binarySNode.insert(6);
		Test(true, binarySNode.contains(5), method+"contains");
		Test(false, binarySNode.contains(12), method+"contains");
		
		//Test remove
		BinarySearchNode binarySearchNode=new BinarySearchNode(5, c);
		binarySearchNode.insert(3);
		binarySearchNode.insert(7);
		binarySearchNode.insert(2);
		binarySearchNode.insert(4);
		binarySearchNode.insert(6);
		binarySearchNode.insert(8);
		binarySearchNode.insert(1);
		binarySearchNode.remove(8);
		Test(false, binarySearchNode.contains(8), method+"remove");
		binarySearchNode.remove(2);
		Test(false, binarySearchNode.contains(2), method+"remove");
		binarySearchNode.remove(5);
		Test(false, binarySearchNode.contains(5), method+"remove");
	}
	
	public static void BinaryTreeInOrderIterator()
	{
		String method="BinaryTreeInOrderIterator";
		Comparator c=new NumberComparator();
		BinarySearchTree t2=new BinarySearchTree(c);
		t2.insert(5);
		t2.insert(2);
		t2.insert(6);
		t2.insert(1);
		t2.insert(4);
		t2.insert(7);
		t2.insert(3);
		t2.insert(8);
		Iterator iterator=t2.iterator();
		for (int i=1; i<=8; i++)
			Test(i, iterator.next(), method);
	}
	
	public static void PhonebookTest()
	{
		String method="Phonebook-";
		PhoneEntry phoneEntry=new PhoneEntry("aaa", 11);
		PhoneEntry phoneEntry1=new PhoneEntry("bbb", 12);
		PhoneEntry phoneEntry2=new PhoneEntry("ccc", 13);
		PhoneEntry phoneEntry3=new PhoneEntry("ddd", 14);
		PhoneEntry phoneEntry4=new PhoneEntry("eee", 15);
		PhoneEntry phoneEntry5=new PhoneEntry("fff", 16);
		PhoneEntry phoneEntry6=new PhoneEntry("ggg", 17);
		PhoneEntry phoneEntry9=new PhoneEntry("jjj", 20);
		PhoneEntry phoneEntry10=new PhoneEntry("aaa", 87);
		PhoneEntry phoneEntry11=new PhoneEntry("yyy", 13);
		Phonebook myPhonebook=new Phonebook();
		
		//Test add
		Test(true, myPhonebook.add(phoneEntry5), method+"add");
		Test(true, myPhonebook.add(phoneEntry), method+"add");
		Test(true, myPhonebook.add(phoneEntry9), method+"add");
		Test(true, myPhonebook.add(phoneEntry1), method+"add");
		Test(false, myPhonebook.add(phoneEntry5), method+"add");
		Test(true, myPhonebook.add(phoneEntry3), method+"add");
		Test(true, myPhonebook.add(phoneEntry2), method+"add");
		Test(true, myPhonebook.add(phoneEntry4), method+"add");
		Test(true, myPhonebook.add(phoneEntry6), method+"add");
		Test(false, myPhonebook.add(phoneEntry10), method+"add");
		Test(false, myPhonebook.add(phoneEntry11), method+"add");
		
		//Test delete by name
		Test(phoneEntry4, myPhonebook.lookUp("eee"), method+"delete by name");
		Test(true, myPhonebook.delete("eee"), method+"delete by name");
		Test(null, myPhonebook.lookUp("eee"), method+"delete by name");
		Test(false, myPhonebook.delete("rfgv"), method+"delete by name");
		Test(true, myPhonebook.add(phoneEntry4), method+"delete by name");
		
		//Test delete by number
		Test(phoneEntry4, myPhonebook.lookUp(15), method+"delete by number");
		Test(true, myPhonebook.delete(15), method+"delete by number");
		Test(null, myPhonebook.lookUp(15), method+"delete by number");
		Test(false, myPhonebook.delete(567), method+"delete by number");
		Test(true, myPhonebook.add(phoneEntry4), method+"delete by number");
	}
	
	private static <T> void Test(T expected, T actual, String CallingMethod)
	{
		if (expected==null)
		{
			if (actual!=null)
				System.out.println(CallingMethod+": was <"+actual+"> BUT should be <"+null+">");
			return;
		}
		if (!(actual.equals(expected)))
			System.out.println(CallingMethod+": was <"+actual+"> but should be <"+expected+">");
		else
			System.out.println(CallingMethod+": was <"+true+">");
	}
}