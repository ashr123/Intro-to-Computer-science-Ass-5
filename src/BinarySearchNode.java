import java.util.Comparator;
import java.util.Iterator;

public class BinarySearchNode extends BinaryNode
{
	private Comparator treeComparator;
	
	public BinarySearchNode(Object data, Comparator myComparator)
	{
		super(data);
		this.treeComparator=myComparator;
	}
	
	// assume otherTreeRoot.size()>0
	public BinarySearchNode(BinarySearchNode otherTreeRoot, Iterator otherTreeIterator)
	{
		super("dummy");
		treeComparator=otherTreeRoot.getComparator();
		buildPerfectTree(otherTreeRoot.size());
		fillTheNodes(this, otherTreeIterator);
	}
	
	// element is an Entry with one "dummy" field
	public Object findData(Object element)
	{
		if (treeComparator.compare(data, element)>0)
		{
			if (left!=null)
				return ((BinarySearchNode)left).findData(element);
			else
				return null;
		}
		else
			if (treeComparator.compare(data, element)<0)
			{
				if (right!=null)
					return ((BinarySearchNode)right).findData(element);
				else
					return null;
			}
			else
				return this.data;
	}
	
	public Object findMin()
	{
		BinaryNode currNode=this;
		while (currNode.left!=null)
		{
			currNode=currNode.left;
		}
		return currNode.data;
	}
	
	// Complete the following methods:
	private void buildPerfectTree(int size)//Builds a balanced tree with data="dummy"
	{
		Queue q=new QueueAsLinkedList();
		q.enqueue(this);
		//create the remaining size-1 nodes in the tree
		/*Enter you code here:*/
		for (int i=1; i<size; i++)
		{
			BinarySearchNode n=(BinarySearchNode)q.dequeue();
			q.enqueue(n.left=new BinarySearchNode("dummy", getComparator()));
			if (++i>=size)
				break;
			q.enqueue(n.right=new BinarySearchNode("dummy", getComparator()));
		}
		// now this is the root of a tree with size dummy nodes
	}
	
	private void fillTheNodes(BinarySearchNode root,
	                          Iterator treeIterator)//Fills the balanced tree with the original tree's data
	{
		//throw new UnsupportedOperationException();
		boolean flag=true;
		if (root.left!=null)
		{
			//((BinarySearchNode)root.left).fillTheNodes(root, treeIterator);
			fillTheNodes((BinarySearchNode)root.left, treeIterator);
			if (treeIterator.hasNext()/* && flag*/)
			{
				root.data=treeIterator.next();
				flag=false;
			}
			if (root.right!=null)
				fillTheNodes((BinarySearchNode)root.right, treeIterator);
		}
		else
			if (root.right!=null)
				fillTheNodes((BinarySearchNode)root.right, treeIterator);
		if (treeIterator.hasNext() && flag)
			root.data=treeIterator.next();
	}
	
	public Comparator getComparator()//Returns a Comperator Object (treeComperator)
	{
		//throw new UnsupportedOperationException();
		return treeComparator;
	}
	
	public void insert(Object toInsert)//Inserts an object toInsert to the right location according to the tree comperator
	{
		//throw new UnsupportedOperationException();
		if (toInsert==null)
			throw new NullPointerException("Argument is null");
		if (getComparator().compare(data, toInsert)>0)
			if (left!=null)
				left.insert(toInsert);
			else
				left=new BinarySearchNode(toInsert, getComparator());
		else
			if (getComparator().compare(data, toInsert)<0)
				if (right!=null)
					right.insert(toInsert);
				else
					right=new BinarySearchNode(toInsert, getComparator());
	}
	
	public boolean contains(Object element)//Checks if a given element exists in the tree
	{
		//throw new UnsupportedOperationException();
		if (element==null)
			return false;
		boolean output=false;
		if (getComparator().compare(data, element)>0)//if element<data
		{
			if (left!=null)
				output=left.contains(element);
		}
		else
			if (getComparator().compare(data, element)<0)//if element>data
			{
				if (right!=null)
					output=right.contains(element);
			}
			else//if (element==data)
				output=true;
		return output;
	}
	
	public BinaryNode remove(Object toRemove)//Removes a given Object from the tree
	{
		//throw new UnsupportedOperationException();
		if (toRemove==null)
			throw new NullPointerException("Argument is null");
		if (getComparator().compare(data, toRemove)>0)
		{
			if (left!=null)
				left=((BinarySearchNode)left).remove(toRemove);
		}
		else
			//Need to remove the data in this node
			if (getComparator().compare(data, toRemove)<0)
			{
				if (right!=null)
					right=((BinarySearchNode)right).remove(toRemove);
			}
			else
				//the base cases...
				if (left==null || right==null)
					if (left==null)
						return right;
					else
						return left;
				else
				{//If this node has two children
					data=((BinarySearchNode)right).findMin();
					right=((BinarySearchNode)right).remove(data);
				}
		return this;
	}
}