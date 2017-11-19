import java.util.*;
import java.io.*;

public class DjVuBookMarkFormatter {
	public static void main(String args[]) throws IOException {
		Scanner input = new Scanner(new File(args[0].toString()));

		StringBuilder output2 = new StringBuilder();

		// I couldn't figure out how to do it on the run. Parse through the file once
		while (input.hasNext()) {
			String words[] = input.nextLine().split(" ");// Split the line up into words

			output2.append(words[words.length - 1] + " ");// Add the last word which should be a number to the front.

			for (int x = 0; x < words.length - 1; x++)// Add the other words.
			{
				output2.append(words[x] + " ");
			}
			output2.append("\n");
		}
		input.close();

		input = new Scanner(output2.toString()); // Parse through some of the rearrangements.
		FileWriter output = new FileWriter(
				new File(args[0].toString().substring(0, args[0].toString().indexOf(".")) + "2.txt"));

		output.write("(bookmarks\n");// how every djvused bookmark file starts
		while (input.hasNext()) {
			String words[] = input.nextLine().split(" "); // have to split the words again

			try {
				if (words.length > 0) {
					int test = Integer.parseInt(words[0]) + 23;// I had to add 23 as the offset for book pages.
					output.write("\t(\"Chapter ");

					for (int x = 1; x < words.length; x++) {
						if (x == words.length - 1)
							output.write(words[x]);
						else
							output.write(words[x] + " ");
					}

					output.write("\"\n\t\""); // More formatting
					output.write("#");
					if (!words[0].equals("")) {
						output.write(test + "");
						output.write("\")\n");
					}
				}
			} catch (NumberFormatException e) {
				output.write("\t(\"");// When entries don't have a number as the first word. E.g. Table of Contents,
										// Title, etc.
				output.write(words[0]);
				output.write("\"\n\t\"");// Added some tabs to make it look easier to read if you want to make
											// adjustments.
				output.write("\")\n");
			}
		}
		output.write(")");// Closing bracket
		input.close();
		output.close();
	}
}
