// Aman Bhatt 19105013
class Myclass {
	
	static int a = 20;
	Myclass() {
		a++;
	}
	void m1() {
		a++;
		System.out.println(a);
	}
	
}

public class Question4{
	public static void main(String[]
	args)
	{
		Myclass obj = new Myclass();
		Myclass obj2 = new Myclass();
		Myclass obj3 = new Myclass();
		obj3.m1();
	}
}

// the above code snippet outputs 24