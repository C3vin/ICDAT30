package Alg;

public class Student implements Comparable<Student> {

	int rollno;
	String name;
	int age;
	
	Student(int rollno1, String name1, int age1) {
		this.rollno = rollno1;
		this.name = name1;
		this.age = age1;
	}
	
	@Override
	public int compareTo(Student st) {
		if(age == st.age)
			return 0;
		else if(age > st.age) 
			return 1;
		else 
			return -1;
	}
}

//Comparable 
//https://www.mkyong.com/java/java-object-sorting-example-comparable-and-comparator/
//http://beginnersbook.com/2013/12/java-arraylist-of-object-sort-example-comparable-and-comparator/