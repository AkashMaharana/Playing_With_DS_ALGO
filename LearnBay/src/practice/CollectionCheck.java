package practice;

import java.util.ArrayList;
import java.util.List;

public class CollectionCheck {
	
	public static void main(String[] args) {
		List<Integer> l=new ArrayList<>();
		l.add(1);
		l.add(2);
		l.add(3);
		for(Integer i:l){
			if(i==1){
				l.remove(0);
			}
		}
	}

}
