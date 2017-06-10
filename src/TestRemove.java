public class TestRemove
{
	public static void main(String[] args)
	{
		BinarySearchTree tree=new BinarySearchTree(new NumberComparator());
		tree.insert(5);
		tree.insert(2);
		tree.insert(7);
		tree.insert(9);
		tree.insert(4);
		tree.insert(3);
		tree.insert(8);
		tree.insert(1);
		System.out.println(tree+"\n\n\n\n\n");
		tree.remove(2);
		//tree.remove(2);
		System.out.println(tree);
	}
}