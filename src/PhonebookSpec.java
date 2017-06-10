/**
 * Created by shalev on 10/01/2017.
 */
public class PhonebookSpec
{
	public static void main(String[] args)
	{
		Phonebook pb=new Phonebook();
		
		// add
		printWithNL("add new PhoneEntry: "+pb.add(new PhoneEntry("name", 123)));
		printWithNL("check if inserted(by Name): "+pb.exportNames());
		printWithNL("check if inserted(by Number): "+pb.exportNumbers());
		printWithNL("add new PhoneEntry with same name: "+pb.add(new PhoneEntry("name", 124)));
		printWithNL("add new PhoneEntry with same number: "+pb.add(new PhoneEntry("name2",
		                                                                          123)));
		
		try
		{
			System.out.print("add(null): ");
			pb.add(null);
			printWithNL("No Exception");
		}
		catch (Exception ex)
		{
			System.out.println(ex.getClass());
		}
		
		// delete
		pb.add(new PhoneEntry("nameb", 111));
		printWithNL("add new PhoneEntry: "+pb.exportNames());
		printWithNL("delete PhoneEntry(by Name): "+pb.delete("nameb"));
		printWithNL("check if removed(by Name): "+pb.exportNames());
		printWithNL("check if removed(by Number): "+pb.exportNumbers());
		
		pb.add(new PhoneEntry("nameb", 111));
		printWithNL("add new PhoneEntry: "+pb.exportNames());
		printWithNL("delete PhoneEntry(by Name): "+pb.delete(111));
		printWithNL("check if removed(by Name): "+pb.exportNames());
		printWithNL("check if removed(by Number): "+pb.exportNumbers());
	}
	
	public static void printWithNL(String str)
	{
		System.out.println(str.replace(System.getProperty("line.separator"), "\\n"));
	}
}