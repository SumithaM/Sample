package searching_sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class SortTest {

	private static List<String> merged = new ArrayList<>();
	
	public static void main(String[] args) {
		List<String> l1 = new ArrayList<String>();
		l1.add("02:30:00");
		l1.add("10:30:00");
		l1.add("11:00:00");
		l1.add("00:15:00");
		
		List<String> l2 = new ArrayList<String>();
		l2.add("09:30:00");
		l2.add("10:30:00");
		l2.add("11:00:00");
		l2.add("12:15:00"); 
		
		Stream.concat(l1.stream(), l2.stream()).sorted(byTime).map(formatterFunction).forEach(System.out::println);
		
	}
	
	static UnaryOperator<String> formatterFunction = new UnaryOperator<String>() {
		@Override
		public String apply(String arg0) {
			if (arg0.startsWith("24:")) {
				arg0 = arg0.replace("24:", "00:");
				return arg0;
			}
			return arg0;
		}
	};
	
	static Comparator<String> byTime = new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {
			
			if (o1.startsWith("00:")) {
				o1 = o1.replace("00:", "24:");
			}
			if (o2.startsWith("00:")) {
				o2 = o2.replace("00:", "24:");
			}
			return o1.compareTo(o2);
		}
	};
	 

}
