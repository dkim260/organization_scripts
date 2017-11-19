import java.util.*;
import java.io.*;
public class AverageCalculator {

	public static void main(String[] args) throws IOException
	{

		Scanner input = new Scanner (new File (args[0]));
		double average=0;
		double numOfStudents=0;
		while (input.hasNextLine()) //Go through each line of input
		{
			int name = input.nextInt(); //Get the student id
			double grade = input.nextDouble(); //Get their grade
			
			average +=grade; //Add their grade to a sum
			numOfStudents++; //Increase the number of students			
		}
		input.close();
		System.out.println(average/numOfStudents);//Print out the average = sum of class / num of students.
	}

}
