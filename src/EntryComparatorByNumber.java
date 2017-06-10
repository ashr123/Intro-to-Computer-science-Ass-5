import java.util.Comparator;

public class EntryComparatorByNumber implements Comparator
{
	public int compare(Object o1, Object o2)//Compares between two phone entries numbers
	{
		//throw new UnsupportedOperationException();
		if (!(o1 instanceof PhoneEntry) || !(o2 instanceof PhoneEntry))
			throw new ClassCastException();
		return ((PhoneEntry)o1).getNumber()-((PhoneEntry)o2).getNumber();
	}
}