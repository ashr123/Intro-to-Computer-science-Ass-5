public class ApplyingTests
{
	public static void main(String args[])
	{
		int SuccesfulTests=0;
		Pikatest tester=new Pikatest();
		SuccesfulTests+=tester.EntryComparatorTestByName(); //7 tests here.
		SuccesfulTests+=tester.EntryComparatorByNumber(); //7 tests here.
		SuccesfulTests+=tester.GetComparatorTest(); //1 test here.
		SuccesfulTests+=tester.InsertionTest(); //9 tests here.
		SuccesfulTests+=tester.RemoveTest(); //12 tests here.
		SuccesfulTests+=tester.ToStringTest(); //7 tests here.
		SuccesfulTests+=tester.ContainsTest(); //5 tests here.
		SuccesfulTests+=tester.PerfectTreeTest();//8 tests
		SuccesfulTests+=tester.PhonebookDeletionTest();//12 tests
		SuccesfulTests+=tester.IteratorTest();//9 tests
		SuccesfulTests+=tester.PhonebookAddTest();//3 tests
		//Sum of tests to this point: 78
		if (SuccesfulTests==81)
			System.out.println("All tests have passed succesfully!");
		else
			System.out.println("Some tests have failed. Please refer to the printed messeges for more info.");
	}
}