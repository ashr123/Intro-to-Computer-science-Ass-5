/**
 * Created by shalev on 09/01/2017.
 */
public class BinarySearchNodeSpec
{
	public static void main(String[] args)
	{
		NumberComparator comp=new NumberComparator();
		BinarySearchNode bsn=new BinarySearchNode(2, comp);
		
		// getComparator
		System.out.println("getComparator: "+bsn.getComparator().equals(comp));
		
		// insert
		printWithNL("one node: "+bsn);
		bsn.insert(2);
		printWithNL("one node again: "+bsn);
		bsn.insert(4);
		printWithNL("two nodes: "+bsn);
		bsn.insert(3);
		printWithNL("in the middle: "+bsn);
		bsn.insert(1);
		printWithNL("in the beginning: "+bsn);
		bsn.insert(5);
		printWithNL("in the end: "+bsn);
		bsn.insert(-1);
		bsn.insert(-2);
		printWithNL("two more left: "+bsn);
		
		// contains
		System.out.println("contains root: "+bsn.contains(2));
		System.out.println("contains leaf: "+bsn.contains(-2));
		System.out.println("contains middle: "+bsn.contains(3));
		// Error: should be not contains: false
		System.out.println("not contains: "+bsn.contains(0));
		
		// buildPerfectTree & fillTheNodes
		BinarySearchNode nbsn=new BinarySearchNode(bsn, new BinaryTreeInOrderIterator(bsn));
		printWithNL("before buildPerfectTree & fillTheNodes: "+bsn);
		printWithNL("after  buildPerfectTree & fillTheNodes: "+nbsn);
		
		// remove
		bsn.remove(-2);
		printWithNL("remove from the end: "+bsn);
		bsn.remove(1);
		printWithNL("remove from the middle: "+bsn);
		bsn.remove(2);
		printWithNL("remove root: "+bsn);
	}
	
	public static void printWithNL(String str)
	{
		System.out.println(str.replace(System.getProperty("line.separator"), "\\n"));
	}
}