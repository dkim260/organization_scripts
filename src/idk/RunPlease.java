package idk;

import java.util.*;
import java.io.*;
public class RunPlease {
	public static void main (String args[]) throws IOException
	{
		Scanner input = new Scanner (new File ("idk.txt"));
		FileWriter output = new FileWriter (new File ("idk3.txt"));
		
		while (input.hasNext()) 
		{
			String words [] = input.nextLine().split(" ");

			
			output.write("(\"Chapter ");

			for (int x = 1; x< words.length; x++)
			{
				if (x == words.length-1)
					output.write(words[x]);
				else
					output.write(words[x]+" ");
			}
			output.write("\"\n \"");
			output.write("#");
			if (words.length >0) {
				if (!words[0].equals(""))
					output.write((Integer.parseInt(words[0])+23)+"");
				else
					output.write(words[0]);

				output.write("\")\n");
			}
		}
		
		input.close();
		output.close();
	}
}
