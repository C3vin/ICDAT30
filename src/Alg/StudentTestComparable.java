package Alg;

import java.util.ArrayList;
import java.util.Collections;

public class StudentTestComparable {
	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student(201, "John", 10));
		students.add(new Student(302, "Mary", 50));
		students.add(new Student(103, "Bill", 30));
		
		Collections.sort(students); //compare with age
		for(Student student: students)	
			System.out.println(student.rollno + " " + student.name + " " + student.age);
	}
}
