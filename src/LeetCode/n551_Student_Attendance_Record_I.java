package LeetCode;

/*
You are given a string representing an attendance record for a student. The record only contains the following three characters:
'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 */
public class n551_Student_Attendance_Record_I {
	public boolean checkRecord(String s) {
		char[] student = s.toCharArray();
		int countA = 0;
		int countL = 0;

		for(int i=0; i<student.length; i++) {
			if(student[i] == 'A') {
				countA++;
				if(countA > 1)
					return false;
			}
			if(student[i] == 'L') {
				countL++;
				if(countL > 2) {
					return false;
				} 
			} else						//why need in "else", because that means not continuous 'L'
				countL = 0;
		}
		return true;
	}
	public static void main(String[] args) {
		n551_Student_Attendance_Record_I obj = new n551_Student_Attendance_Record_I();
		String s = "PPALLP";
		String s1 = "PALLL";
		System.out.println(obj.checkRecord(s));
		System.out.println(obj.checkRecord(s1));
	}
}
