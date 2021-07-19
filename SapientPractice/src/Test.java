import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		Employee e1=new Employee("Akash",20);
		Employee e2=new Employee("Akash",20);
		
		Map<Employee,String> map=new HashMap<>();
		map.put(e1, "Akash");
		map.put(e2, "Akash");
		
		map.keySet().stream().forEach(System.out::println);
		
		List<Employee> list=new ArrayList<>();
		list.add(e1);
		list.add(e2);
		Collections.sort(list);
	}

}
