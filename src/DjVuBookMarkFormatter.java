import java.util.*;
import java.io.*;
public class DjVuBookMarkFormatter {
	public static void main (String args[]) throws IOException
	{
		Scanner input = new Scanner (new File (args[0].toString()));
		
		StringBuilder output2 = new StringBuilder();
		
		while (input.hasNext()) 
		{
			String words [] = input.nextLine().split(" ");
			
			output2.append(words[words.length-1]+" ");
					
			for (int x =0; x< words.length-1; x++)
			{
				output2.append(words[x] + " ");
			}
			output2.append("\n");
		}
		input.close();
		
		input = new Scanner (output2.toString());
		FileWriter output = new FileWriter (new File (args[0].toString()+"2"));

		output.write("(bookmarks\n");
		while (input.hasNext()) 
		{
			String words [] = input.nextLine().split(" ");
			
			try 
			{
				if (words.length >0) 
				{
					int test = Integer.parseInt(words[0])+23;
					output.write("\t(\"Chapter ");
	
					for (int x = 1; x< words.length; x++)
					{
						if (x == words.length-1)
							output.write(words[x]);
						else
							output.write(words[x]+" ");
					}
	
					output.write("\"\n\t\"");
					output.write("#");
					if (!words[0].equals(""))
					{
						output.write(test+"");
						output.write("\")\n");
					}
				}
			}
			catch (NumberFormatException e) 
			{
				output.write("\t(\"");
				output.write(words[0]);
				output.write("\"\n\t\"");
				output.write("\")\n");
			}
		}
		output.write(")");
		
		input.close();
		output.close();
	}
}
