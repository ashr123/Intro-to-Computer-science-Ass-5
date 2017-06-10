import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryTreeInOrderIterator implements Iterator
{
	private Stack stack;
	
	public BinaryTreeInOrderIterator(BinaryNode root)//Builds an iterator
	{
		//throw new UnsupportedOperationException();
		stack=new StackAsDynamicArray();
//		stack.push(root);
//		stack.push(prepare());
		while (root!=null)
		{
			stack.push(root);
			root=root.left;
		}
	}
	
	public boolean hasNext()//Checks if the stack isn't empty
	{
		//throw new UnsupportedOperationException();
		return !stack.isEmpty();
	}
	
	public Object next()//Returns a node's data
	{
		//throw new UnsupportedOperationException();
		if (!hasNext())
			throw new NoSuchElementException();
//		return ((BinaryNode)stack.pop()).data;
		BinaryNode node=(BinaryNode)stack.pop();
		Object output=node.data;
		if (node.right!=null)
		{
			node=node.right;
			while (node!=null)
			{
				stack.push(node);
				node=node.left;
			}
		}
		return output;
	}
	
/*	private Object prepare()
	{
		BinaryNode node=(BinaryNode)stack.pop();
		if (node.right!=null)
		{
			stack.push(node.right);
			stack.push(prepare());
		}
		stack.push(node);
		if (node.left!=null)
		{
			stack.push(node.left);
			stack.push(prepare());
		}
		return stack.pop();
	}*/
	
	public void remove()
	{
		throw new UnsupportedOperationException("remove");
	}
}