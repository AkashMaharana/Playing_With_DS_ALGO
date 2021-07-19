import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
	
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Stack<String> s=new Stack<>();
        String finalString="";
        s.push(finalString);
        int typeOfOperation;
        int noOfOperations=Integer.parseInt(sc.nextLine());
        String temp="";
        List<String> l=new ArrayList<>();
        while(noOfOperations>=0){
            l.add(sc.nextLine());
            noOfOperations--;
        }
        for(int i=0;i<l.size()-1;i++){
        	typeOfOperation=Integer.parseInt(l.get(i).substring(0,1));
        	switch(typeOfOperation){
        		case 1:
        			temp=temp+l.get(i).substring(2);
        			s.push(temp);
        			break;
        		case 2:
        			temp=temp.substring(0,temp.length()-Integer.parseInt(l.get(i).substring(2)));
        			s.push(temp);
        			break;
        		case 3:
        			System.out.println(s.peek().charAt(Integer.parseInt(l.get(i).substring(2))-1));
        			break;
        		case 4:
        			if(s.size()>=2){
        				s.pop();
        				finalString=s.peek();
        			}
        			else{
        				finalString=s.peek();
        			}
        			break;
        		default:
        			break;
        	}
        }
    }

}
