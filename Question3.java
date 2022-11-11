// Aman Bhatt 19105013
import java.util.*;
class Marks{
	String name;
	int rollNo;
	int marks;

	Marks(String name, int rollNo, int marks){
		this.name = name;
		this.rollNo = rollNo;
		this.marks = marks;
	}
}


class Physics extends Marks{

	Physics(String name, int rollNo, int marks){
		super(name, rollNo, marks);
	}
}

class Chemistry extends Marks{

	Chemistry(String name, int rollNo, int marks){
		super(name, rollNo, marks);
	}
}

class Maths extends Marks{

	Maths(String name, int rollNo, int marks){
		super(name, rollNo, marks);
	}
}



public class Question3{
	public static int totalMarks(Marks []marks){
		int sum = 0;
		for(Marks m:marks){
			sum += m.marks;
		}

		return sum;
	}
	public static void main(String args[]){

		Scanner sc = new Scanner(System.in); 

		int numberOfStudents = sc.nextInt(); 
		
		Physics [] physicsRegister = new Physics[numberOfStudents];
		Chemistry [] chemistryRegister = new Chemistry[numberOfStudents];
		Maths [] mathsRegister = new Maths[numberOfStudents]; 


		for(int i=1;i<=numberOfStudents;i++){

			System.out.println("Enter the name of the student: "); 
			String name = sc.next(); 
			System.out.println("Enter the marks in Physics: ");
			int physics = sc.nextInt(); 
			System.out.println("Enter the marks in Chemistry: ");
			int chem = sc.nextInt(); 
			System.out.println("Enter the marks in Maths: ");
			int math = sc.nextInt(); 


			Physics p = new Physics(name, i, physics); 
			Chemistry c = new Chemistry(name,i,chem);
			Maths m = new Maths(name,i,math); 

			physicsRegister[i-1] = p;
			chemistryRegister[i-1] = c;
			mathsRegister[i-1] = m;

		}

		int totalPhysics = totalMarks(physicsRegister);
		int totalChemistry = totalMarks(chemistryRegister);
		int totalMaths = totalMarks(mathsRegister); 

		System.out.println("Physics Average: " + (float)totalPhysics/(float)numberOfStudents);
		System.out.println("Chemistry Average: " + (float)totalChemistry/(float)numberOfStudents);
		System.out.println("Maths Average: " + (float)totalMaths/(float)numberOfStudents);
	}
}