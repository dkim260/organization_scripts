import java.util.*;
import java.io.*;
public class Math1090grades {

	public static void main(String[] args) throws IOException
	{

		Scanner input = new Scanner (new File (args[0]));
		double average=0;
		double numOfStudents=0;
		while (input.hasNextLine()) 
		{
			int name = input.nextInt();
			double grade = input.nextDouble();
			
			average +=grade;
			numOfStudents++;
			
			System.out.println(name + "\t" + grade);
		}
		input.close();
		System.out.println(average/numOfStudents);
	}

}