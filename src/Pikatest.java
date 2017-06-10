import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Pikatest implements Tester
{
	//The int value is how many tests have succeeded and how many have failed.
	public static void print(Object s)
	{
		System.out.println(s);
	}
	
	public static String inOrder(BinaryNode node)
	{
		String answer="";
		if (node.left!=null)
			answer=answer+inOrder(node.left);
		answer=answer+node.data.toString();
		if (node.right!=null)
			answer=answer+inOrder(node.right);
		return answer;
	}
	
	public int EntryComparatorTestByName()
	{
		/*
		 Cases to take into consideration: one of them is null,
		 both are null, first is bigger than last, using numbers,
		 the word "null" and it's variations testing the same name more than once,
		 sending the same word but with different capital letters.
		 */
		int SuccessfulTest=0;
		Comparator CompTest=new EntryComparatorByName();
		PhoneEntry StringToTest1=new PhoneEntry("Null", 15);
		PhoneEntry StringToTest2=new PhoneEntry("null", 15);
		PhoneEntry StringToTest3=new PhoneEntry("a", 20);
		PhoneEntry StringToTest4=new PhoneEntry("a", 5);
		PhoneEntry StringToTest5=new PhoneEntry("b", 5);
		Integer fail=5;
		try
		{
			CompTest.compare(null, null);
			System.out.println("The Entry Comparator allows 2 nulls to be compared!");
		}
		catch (ClassCastException dfgd)
		{
			SuccessfulTest++;
		}
		try
		{
			CompTest.compare(null, StringToTest1);
			System.out.println("The Entry Comparator allows left to be null to be compared!");
		}
		catch (ClassCastException dfgd)
		{
			SuccessfulTest++;
		}
		try
		{
			CompTest.compare(StringToTest1, null);
			System.out.println("The Entry Comparator allows right to be null to be compared!");
		}
		catch (ClassCastException dfgd)
		{
			SuccessfulTest++;
		}
		int CompResult1=CompTest.compare(StringToTest1, StringToTest2);
		int CompResult2=CompTest.compare(StringToTest2, StringToTest1);
		int CompResult3=CompTest.compare(StringToTest3, StringToTest3);
		int CompResult4=CompTest.compare(StringToTest3, StringToTest4);
		int CompResult5=CompTest.compare(StringToTest5, StringToTest4);
		if (CompResult1>=0 || CompResult2<=0 || CompResult3!=0 || CompResult4!=0 || CompResult5==0)
			System.out.println("String Comparator is not working properly.");
		else
			SuccessfulTest++;
		try
		{
			CompTest.compare(fail, StringToTest5);
			System.out.println("String Comparator doesn't throw exception when trying to compare 2 different types");
		}
		catch (ClassCastException df)
		{
			SuccessfulTest++;
		}
		
		try
		{
			CompTest.compare(StringToTest5, fail);
			System.out.println("String Comparator doesn't throw exception when trying to compare 2 different types");
		}
		catch (ClassCastException df)
		{
			SuccessfulTest++;
		}
		
		try
		{
			CompTest.compare(fail, fail);
			System.out.println(
				"String Comparator doesn't throw exception when trying to compare the same type but with the wrong instance");
		}
		catch (ClassCastException df)
		{
			SuccessfulTest++;
		}
		
		return SuccessfulTest;
	}
	
	@Override
	public int EntryComparatorByNumber()
	{
		/*
		 Cases to test: first is null, second is null, both are null,
		 first is bigger, second is bigger, sending an integer, sending an int,
		 s0ending equals and making should you get a 0.
		 */
		int SuccessfulTest=0;
		Comparator CompTest=new EntryComparatorByNumber();
		PhoneEntry NumToTest1=new PhoneEntry("null", 15);
		PhoneEntry NumToTest2=new PhoneEntry("null", 18);
		PhoneEntry NumToTest3=new PhoneEntry("a", 17);
		PhoneEntry NumToTest4=new PhoneEntry("a", 21);
		PhoneEntry NumToTest5=new PhoneEntry("b", 21);
		Integer fail=5;
		try
		{
			CompTest.compare(null, null);
			System.out.println("The Number Comparator allows 2 nulls to be compared!");
		}
		
		catch (ClassCastException dfgd)
		{
			SuccessfulTest++;
		}
		
		try
		{
			CompTest.compare(null, NumToTest1);
			System.out.println("The Number Comparator allows left to be null to be compared!");
		}
		catch (ClassCastException dfgd)
		{
			SuccessfulTest++;
		}
		
		try
		{
			CompTest.compare(NumToTest1, null);
			System.out.println("The Number Comparator allows right to be null to be compared!");
		}
		catch (ClassCastException dfgd)
		{
			SuccessfulTest++;
		}
		int CompResult1=CompTest.compare(NumToTest1, NumToTest2);
		int CompResult2=CompTest.compare(NumToTest2, NumToTest1);
		int CompResult3=CompTest.compare(NumToTest3, NumToTest3);
		int CompResult4=CompTest.compare(NumToTest3, NumToTest4);
		int CompResult5=CompTest.compare(NumToTest5, NumToTest4);
		if (CompResult1>=0 || CompResult2<=0 || CompResult3!=0 || CompResult4==0 || CompResult5!=0)
			System.out.println("The Number Comparator is not working properly.");
		else
			SuccessfulTest++;
		
		try
		{
			CompTest.compare(fail, NumToTest5);
			System.out.println("Number Comparator doesn't throw exception when trying to compare 2 different types");
		}
		catch (ClassCastException df)
		{
			SuccessfulTest++;
		}
		
		try
		{
			CompTest.compare(NumToTest5, fail);
			System.out.println("Number Comparator doesn't throw exception when trying to compare 2 different types");
		}
		catch (ClassCastException df)
		{
			SuccessfulTest++;
		}
		
		try
		{
			CompTest.compare(fail, fail);
			System.out.println(
				"Number Comparator doesn't throw exception when trying to compare the same type but wrong instance");
		}
		catch (ClassCastException df)
		{
			SuccessfulTest++;
		}
		
		return SuccessfulTest;
	}
	
	@Override
	public int GetComparatorTest()
	{
		int SuccessfulTest=0;
		Comparator CompTest=new EntryComparatorByNumber();
		
		Comparator CompTest1=new EntryComparatorByName();
		
		BinarySearchTree CompGetTest=new BinarySearchTree(CompTest);
		
		BinarySearchTree CompGetTest1=new BinarySearchTree(CompTest1);
		
		if (CompGetTest.getComparator()!=CompTest || CompGetTest1.getComparator()!=CompTest1 ||
		    CompGetTest.getComparator()==CompGetTest1.getComparator())
			System.out.println("Get Comparator is not returning the correct comparator.");
		else
			SuccessfulTest++;
		
		return SuccessfulTest;
	}
	
	@Override
	public int InsertionTest()
	{
		int SuccessfulTest=0;
		Comparator c2=new NumberComparator();
		BinarySearchTree t1=new BinarySearchTree(c2);
		BinarySearchTree t2=new BinarySearchTree(c2);
		BinarySearchTree t3=new BinarySearchTree(c2);
		BinarySearchTree t4=new BinarySearchTree(c2);
		try
		{
			t1.insert(null);
			System.out.println("Insertion allows null items to be inserted.");
		}
		catch (NullPointerException fgh)
		{
			SuccessfulTest++;
		}
		
		t1.insert(200);
		t1.insert(150);
		t1.insert(250);
		t1.insert(300);
		t2.insert(200);
		t2.insert(150);
		t2.insert(250);
		t2.insert(300);
		if (t1.equals(t2))
			SuccessfulTest++;
		else
			System.out.println("Insertion in Binary Search Tree is not consistant.");
		
		try
		{
			t1.insert("Fail");
			System.out.println("Insertion allows a different instances to be entered to the same search tree");
		}
		catch (ClassCastException sdf)
		{
			SuccessfulTest++;
		}
		
		t2.insert(200);
		if (!t1.equals(t2))
			System.out.println("Insertion allows the same entry to be inserted.");
		else
			SuccessfulTest++;
		
		
		for (int i=0; i<500; i=i+100)
		{
			t3.insert(i);
			t4.insert(i);
		}
		if (t3.equals(t2) || t3.equals(t1))
			System.out.println("Insertion creates false positive for equals");
		else
			SuccessfulTest++;
		
		if (t3.equals(t4))
			SuccessfulTest++;
		else
			System.out.println("Insertion in Binary Search Tree is not consistant.");
		
		if (t3.equals(t4))
			SuccessfulTest++;
		else
			System.out.println("Insertion in Binary Search Tree is not consistant.");
		
		BinarySearchTree t5=new BinarySearchTree(c2);
		t5.insert(50);
		if (!t5.isEmpty())
			SuccessfulTest++;
		else
			System.out.println("Insertion to the first element is not working properly");
		BinarySearchTree t6=new BinarySearchTree(c2);
		t6.root=new BinarySearchNode(50, c2);
		t6.root.left=new BinarySearchNode(0, c2);
		t5.insert(0);
		if (t5.equals(t6))
			SuccessfulTest++;
		else
			System.out.println("Insertion to the left element is not working properly");
		t5.insert(100);
		t6.root.right=new BinarySearchNode(100, c2);
		if (t5.equals(t6))
			SuccessfulTest++;
		else
			System.out.println("Insertion to the right element is not working properly");
		
		
		return SuccessfulTest;
	}
	
	public int RemoveTest()
	{
		int SuccessfulTest=0;
		Comparator c2=new NumberComparator();
		BinarySearchTree t1=new BinarySearchTree(c2);
		BinarySearchTree t2=new BinarySearchTree(c2);
		t1.insert(200);
		t2.insert(200);
		try
		{
			t1.remove(null);
			System.out.println("Remove function allows null to be entered as an element to be removed.");
		}
		catch (NullPointerException sdkf)
		{
			SuccessfulTest++;
		}
		
		
		t1.remove(100);
		if (!t1.equals(t2))
			System.out.println(
				"Remove function doesn't throw an exception when an element desired to be removed is not in the tree.");
		else
			SuccessfulTest++;
		
		t1.remove(200);
		if (t1.equals(t2))
			System.out.println("Remove doesn't remove the root of the tree when there's only one element");
		else
			SuccessfulTest++;
		
		t1.insert(200);
		if (t1.equals(t2))
			SuccessfulTest++;
		else
			System.out.println("Doesn't insert elements properly after removing the root of the tree");
		
		t1.root.left=new BinarySearchNode(100, c2);
		t1.remove(100);
		
		if (t1.size()!=1)
			System.out.println("Doesn't remove left node when it's the last one in the branch");
		else
			SuccessfulTest++;
		
		t1.root.right=new BinarySearchNode(300, c2);
		t1.remove(300);
		if (t1.size()!=1)
			System.out.println("Doesn't remove right node when it's the last in the branch");
		else
			SuccessfulTest++;
		
		t1.root.left=new BinarySearchNode(100, c2);
		t1.root.right=new BinarySearchNode(300, c2);
		t1.insert(150);
		t1.insert(75);
		t1.insert(250);
		t1.insert(350);
		t1.insert(83);
		t1.insert(63);
		t1.insert(267);
		t1.insert(238);
		t1.insert(362);
		t1.insert(338);
		t1.insert(162);
		t1.insert(138);
		BinarySearchTree t3=new BinarySearchTree(t1);
		BinarySearchTree t4=new BinarySearchTree(t1);
		t3.remove(100);
		if (t3.size()!=14)
			System.out.println("The size should be 14 but it's "+t3.size()+
			                   "meaning it removed too many items or not at all from the left node");
		else
			SuccessfulTest++;
		
		t4.remove(300);
		if (t4.size()!=14)
			System.out.println("The size should be 14 but it's "+t4.size()+
			                   "meaning it removed too many items or not at all from the right node");
		else
			SuccessfulTest++;
		if (!(t4.toString().equals("      63\n    75\n      83\n  100\n      138\n"
		                           +"    150\n      162\n200\n      238\n    250\n      267\n"
		                           +"  338\n    350\n      362\n")))
			System.out.println("The order of the tree is not maintained when removed an element.\n"
			                   +"Note: this test uses build perfect tree, fill the nodes,iterator and toString");
		else
			SuccessfulTest++;
		
		t4.remove(100);
		if (t4.size()!=13)
			System.out.println("The size should be 13 but it's "+t4.size()+
			                   "meaning it removed too many items or not at all from the right node");
		else
			SuccessfulTest++;
		
		if (!(t4.toString().equals("      63\n    75\n      83\n  138\n    150\n      162\n"
		                           +"200\n      238\n    250\n      267\n  338\n    350\n      362\n")))
			System.out.println("The order of the tree is not maintained when removed an element.\n"
			                   +"Note: this test uses build perfect tree, fill the nodes,iterator and toString");
		else
			SuccessfulTest++;
		
		t4.remove(1);
		if (!(t4.toString().equals("      63\n    75\n      83\n  138\n    150\n      162\n"
		                           +"200\n      238\n    250\n      267\n  338\n    350\n      362\n")))
			System.out
				.println("The order of the tree is not maintained when trying to remove an element not in the tree.\n"
				         +"Note: this test uses build perfect tree, fill the nodes,iterator and toString");
		else
			SuccessfulTest++;
		
		return SuccessfulTest;
	}
	
	@Override
	public int ToStringTest()
	{
		int SuccesfulTest=0;
		BinaryTree t1=new BinaryTree();
		t1.root=new BinaryNode(50);
		if (t1.toString().equals("50\n")) //Assumes you need space on the last line.
			SuccesfulTest++;
		else
		{
			System.out.println("To String doesn't return a single element string correctly");
			System.out.println(
				"This test assumes you need a space on the last line. On the forum they said it doesn't matter");
		}
		
		t1.root.left=new BinaryNode(75);
		
		if (t1.toString().equals("  75\n50\n"))
			SuccesfulTest++;
		else
		{
			System.out.println("To String doesn't return a left element string correctly");
			System.out.println(
				"This test assumes you need a space on the last line. On the forum they said it doesn't matter");
		}
		
		t1.root.right=new BinaryNode(75);
		
		if (t1.toString().equals("  75\n50\n  75\n"))
			SuccesfulTest++;
		else
		{
			System.out.println("To String doesn't return a right element string correctly");
			System.out.println(
				"This test assumes you need a space on the last line. On the forum they said it doesn't matter");
		}
		
		t1.root.right.left=new BinaryNode(50);
		if (t1.toString().equals("  75\n50\n    50\n  75\n"))
			SuccesfulTest++;
		else
		{
			System.out.println("To String doesn't return a string correctly");
			System.out.println(
				"This test assumes you need a space on the last line. On the forum they said it doesn't matter");
		}
		t1.root.right.right=new BinaryNode(100);
		if (t1.toString().equals("  75\n50\n    50\n  75\n    100\n"))
			SuccesfulTest++;
		else
		{
			System.out.println("To String doesn't return a string correctly");
			System.out.println(
				"This test assumes you need a space on the last line. On the forum they said it doesn't matter");
		}
		
		t1.root.left.left=new BinaryNode(150);
		if (t1.toString().equals("    150\n  75\n50\n    50\n  75\n    100\n"))
			SuccesfulTest++;
		else
		{
			System.out.println("To String doesn't return a string correctly");
			System.out.println(
				"This test assumes you need a space on the last line. On the forum they said it doesn't matter");
		}
		
		t1.root.left.left.left=new BinaryNode(200);
		if (t1.toString().equals("      200\n    150\n  75\n50\n    50\n  75\n    100\n"))
			SuccesfulTest++;
		else
		{
			System.out.println("To String doesn't return a string correctly");
			System.out.println(
				"This test assumes you need a space on the last line. On the forum they said it doesn't matter");
		}
		return SuccesfulTest;
	}
	
	@Override
	public int ContainsTest()
	{
		int SuccesfulTest=0;
		Comparator c1=new NumberComparator();
		BinarySearchTree t1=new BinarySearchTree(c1);
		BinarySearchTree t2=new BinarySearchTree(c1);
		BinarySearchTree t3=new BinarySearchTree(c1);
		
		t1.insert(200);
		t1.insert(180);
		t1.insert(220);
		t1.insert(160);
		t1.insert(210);
		t1.insert(230);
		t1.insert(190);
		
		for (int i=0; i<=1000; i+=100)
			t2.insert(i);
		for (int j=2000; j>=1000; j-=100)
			t3.insert(j);
		
		try
		{
			t1.contains(null);
			System.out.println("Contains allows null to be compared!");
		}
		catch (NullPointerException dfg)
		{
			SuccesfulTest++;
		}
		
		if (!(t2.contains(1000)))
			System.out.println("Contains doesn't find the element in the right most node");
		else
			SuccesfulTest++;
		
		if (!(t3.contains(1000)))
			System.out.println("Contains doesn't find the element in the left most node");
		else
			SuccesfulTest++;
		
		if (!(t1.contains(160) || !(t1.contains(220))))
			System.out.println("Contains doesn't find elements in the middle nodes");
		else SuccesfulTest++;
		
		try
		{
			t1.contains("Fail");
			System.out.println("Contains allows for incompatible types to be compared");
		}
		catch (ClassCastException dfg)
		{
			SuccesfulTest++;
		}
		return SuccesfulTest;
	}
	
	@Override
	public int PerfectTreeTest()
	{
		//------------------
		//linear tree
		int answer=0;
		PhoneEntry p1=new PhoneEntry("g", 1);
		PhoneEntry p2=new PhoneEntry("f", 2);
		PhoneEntry p3=new PhoneEntry("e", 3);
		PhoneEntry p4=new PhoneEntry("d", 4);
		PhoneEntry p5=new PhoneEntry("c", 5);
		PhoneEntry p6=new PhoneEntry("b", 6);
		PhoneEntry p7=new PhoneEntry("a", 7);
		Comparator comp=new EntryComparatorByName();
		BinarySearchTree tree=new BinarySearchTree(comp);
		tree.insert(p1);
		tree.insert(p2);
		tree.insert(p3);
		tree.insert(p4);
		tree.insert(p5);
		tree.insert(p6);
		tree.insert(p7);
		BinarySearchTree newtree1=new BinarySearchTree(tree);
		if (newtree1.height()==3 & newtree1.size()==7 & (inOrder(newtree1.root).equals(inOrder(tree.root))))
		{
			answer=answer+1;
		}
		else
			print("error 1");
		//---
		//checks the iterators of the tree's return same things
		Iterator it1=tree.iterator();
		Iterator it2=newtree1.iterator();
		boolean flag=true;
		while (flag & it1.hasNext() & it2.hasNext())
		{
			if (!(it1.next().equals(it2.next())))
			{
				print("error 2");
				flag=false;
			}
			else
				answer=answer+1;
		}
		return answer;
	}
	
	@Override
	public int PhonebookAddTest()
	{
		int answer=0;
		Phonebook book=new Phonebook();
		//try to add null
		try
		{
			book.add(null);
			print("No Exception2");
		}
		catch (Exception ex)
		{
			Exception e1x=new NullPointerException();
			if (ex.getClass()!=e1x.getClass())
				print("IllegalArgumentException excpected");
			else
				answer=answer+1;
		}
		PhoneEntry p1=new PhoneEntry("g", 1);
		PhoneEntry p2=new PhoneEntry("g", 2);
		PhoneEntry p3=new PhoneEntry("e", 1);
		PhoneEntry p4=new PhoneEntry("d", 4);
		PhoneEntry p5=new PhoneEntry("c", 5);
		PhoneEntry p6=new PhoneEntry("b", 6);
		
		if (book.add(p1))
		{
			BinaryTree t=(BinaryTree)book.exportNames();
			BinaryTree t1=(BinaryTree)book.exportNumbers();
			if (t1.contains(p1) & t.contains(p1))
				answer=answer+1;
			else
				print("tree add error 1");
		}
		//trying to add an existing phoneEntry
		if (book.add(p1) | book.add(p2) | book.add(p3))
			print("testing add to phonebook- adding an existing phone entry should  return false");
		else
			answer=answer+1;
		//------
		
		return answer;
	}
	
	@Override
	public int PhonebookDeletionTest()
	{
		int answer=0;
		PhoneEntry p1=new PhoneEntry("g", 1);
		PhoneEntry p2=new PhoneEntry("f", 2);
		PhoneEntry p3=new PhoneEntry("e", 3);
		PhoneEntry p4=new PhoneEntry("d", 4);
		PhoneEntry p5=new PhoneEntry("c", 5);
		PhoneEntry p6=new PhoneEntry("b", 6);
		PhoneEntry p7=new PhoneEntry("a", 7);
		Comparator comp=new EntryComparatorByName();
		Phonebook book=new Phonebook();
		//----------------------------
		//trying to remove item from an empty tree
		if (!(book.delete("g")))
			answer=answer+1;
		else
			print("error 1");
		if (!(book.delete(1)))
			answer=answer+1;
		else
			print("error 1.1");
		//------------------------------
		//trying to remove item from a tree that contains only this specific item
		book.add(p1);
		if (book.delete("g") && book.lookUp("g")==null &&
		    book.lookUp(1)==null)//makes sure the data is not in both trees
			answer=answer+1;
		else
			print("error 2");
		book.add(p1);
		if (book.delete(1) && book.lookUp(1)==null)//makes sure the data is not in both trees
			answer=answer+1;
		else
			print("error 2.1");
		//-----------------------------
		//trying to remove item from the middle of the tree
		book.add(p1);
		book.add(p2);
		book.add(p3);
		book.add(p4);
		book.add(p5);
		book.add(p6);
		book.add(p7);
		if (book.delete("d") && book.lookUp("d")==null &&
		    book.lookUp(4)==null)//makes sure the data is not in both trees
			answer=answer+1;
		else
			print("error 3");
		book.add(p4);
		if (book.delete(4) && book.lookUp("d")==null && book.lookUp(4)==null)//makes sure the data is not in both trees
			answer=answer+1;
		else
			print("error 3.1");
		//----------------------
		//trying to remove the prime node and makes sure all the rest of the nodes are there.
		if (book.delete("g") && book.lookUp("a")!=null && book.lookUp("b")!=null && book.lookUp("c")!=null &&
		    book.lookUp("e")!=null && book.lookUp("f")!=null && book.lookUp("g")==null)
			answer=answer+1;
		else
			print("error 4");
		book.add(p1);
		if (book.delete(1) && book.lookUp(7)!=null && book.lookUp(6)!=null && book.lookUp(5)!=null &&
		    book.lookUp(3)!=null && book.lookUp(2)!=null && book.lookUp(1)==null)
			answer=answer+1;
		else
			print("error 4.1");
		
		//------------------------------
		//deleting the last item in the phone book
		if (book.delete("a") && book.lookUp("a")==null && book.lookUp("b")!=null && book.lookUp("c")!=null &&
		    book.lookUp("e")!=null && book.lookUp("f")!=null && book.lookUp("g")==null)
			answer=answer+1;
		else
			print("error 5");
		book.add(p7);
		if (book.delete(7) && book.lookUp(7)==null && book.lookUp(6)!=null && book.lookUp(5)!=null &&
		    book.lookUp(3)!=null && book.lookUp(2)!=null && book.lookUp(1)==null)
			answer=answer+1;
		else
			print("error 5.1");
		
		//--------------------------
		//trying to remove the whole tree
		book.delete("a");
		book.delete("b");
		book.delete("c");
		book.delete("d");
		book.delete("e");
		book.delete("f");
		book.delete("g");
		if (book.lookUp("a")==null && book.lookUp("b")==null && book.lookUp("c")==null && book.lookUp("d")==null &&
		    book.lookUp("e")==null && book.lookUp("f")==null && book.lookUp("g")==null)
			answer=answer+1;
		else
			print("error 6");
		book.add(p1);
		book.add(p2);
		book.add(p3);
		book.add(p4);
		book.add(p5);
		book.add(p6);
		book.add(p7);
		book.delete(1);
		book.delete(2);
		book.delete(3);
		book.delete(4);
		book.delete(5);
		book.delete(6);
		book.delete(7);
		if (book.lookUp(1)==null && book.lookUp(2)==null && book.lookUp(3)==null && book.lookUp(4)==null &&
		    book.lookUp(5)==null && book.lookUp(6)==null && book.lookUp(7)==null)
			answer=answer+1;
		else
			print("error 6.1");
		return answer;
	}
	
	@Override
	public int IteratorTest()
	{
		int answer=0;
		PhoneEntry p1=new PhoneEntry("g", 1);
		PhoneEntry p2=new PhoneEntry("f", 2);
		PhoneEntry p3=new PhoneEntry("e", 3);
		PhoneEntry p4=new PhoneEntry("d", 4);
		PhoneEntry p5=new PhoneEntry("c", 5);
		PhoneEntry p6=new PhoneEntry("b", 6);
		PhoneEntry p7=new PhoneEntry("a", 7);
		Comparator comp=new EntryComparatorByNumber();
		BinarySearchTree tree=new BinarySearchTree(comp);
		Iterator it1=tree.iterator();
		
		//----------------
		//exception checking
		try
		{
			it1.next();
			print("No Exception2");
		}
		catch (Exception ex)
		{
			Exception e1x=new NoSuchElementException();
			if (ex.getClass()!=e1x.getClass())
				print("empty tree next call should return NoSuchElementException");
			else
				answer=answer+1;
		}
		
		//-----------
		//calls hasNext with an empty iterator- should return false
		try
		{
			if (!it1.hasNext()) ;
			answer=answer+1;
		}
		catch (Exception ex)
		{
			print("empty tree iterator hasnext call should return false");
		}
		//-------------
		tree.insert(p1);
		tree.insert(p2);
		tree.insert(p3);
		tree.insert(p4);
		tree.insert(p5);
		tree.insert(p6);
		tree.insert(p7);
		//inordercheck
		Iterator it2=tree.iterator();
		for (int i=0; i<7; i=i+1)
		{
			PhoneEntry book=(PhoneEntry)it2.next();
			if (book.getNumber()!=i+1)
				print("iterator error");
			else
				answer=answer+1;
		}
		return answer;
	}
}