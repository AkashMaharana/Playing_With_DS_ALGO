package fibonacciSeries;

public class Application {
	
	public static void main(String[] args) {
		Fibonacci fibonacci=new Fibonacci();
		System.out.println(fibonacci.fibonacciDP(1000));
		System.out.println(fibonacci.fibonacciRecursion(1000));
	}


}
