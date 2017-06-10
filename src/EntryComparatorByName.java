import java.util.Comparator;

public class EntryComparatorByName implements Comparator
{
	public int compare(Object o1, Object o2)//Compares between two phone entries names
	{
		//throw new UnsupportedOperationException();
		if (!(o1 instanceof PhoneEntry) || !(o2 instanceof PhoneEntry))
			throw new ClassCastException();
		return ((PhoneEntry)o1).getName().compareTo(((PhoneEntry)o2).getName());
	}
}