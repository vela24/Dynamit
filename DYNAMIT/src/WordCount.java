import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.*;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream("Paragraph.txt");
		Scanner fileInput = new Scanner(file);

		HashMap<String, Integer> wordCount = new HashMap<String, Integer>();

		while (fileInput.hasNext()) {
			String words = fileInput.next().replaceAll("[^a-zA-Z0-9]", "");
			if (wordCount.containsKey(words)) { // check if word exists in map
				wordCount.put(words.toLowerCase(), wordCount.get(words) + 1);
			} else { // if word does not exist in map
				wordCount.put(words.toLowerCase(), 1);
			}
		} // close the while loop
		fileInput.close();
		file.close();

		//I was able to get this to print out occurances but not in descending order
		//Below is the completed version of how to print out the count in descending order
		List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(wordCount.entrySet());

		Collections.sort(list, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {

				return o2.getValue().compareTo(o1.getValue());
			}
		});
		for (Entry<String, Integer> item : list) {
			System.out.println(item.getKey() + " has been used " + item.getValue() + " time(s)!");
		}
	}
};
