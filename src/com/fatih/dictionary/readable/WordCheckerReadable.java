package com.fatih.dictionary.readable;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class WordCheckerReadable {

	static List<String> allWords;
	static List<String> selectedWords;

	/**
	 * Needs approximately 117000 seconds to complete
	 * 
	 * @param args
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) throws URISyntaxException {

		long startTime = System.nanoTime();
		readFromFile();
		findSixLetterWordsComposedOfOtherTwoWords();
		printWords();
		System.out.println("selectedWords size: " + selectedWords.size());
		System.out.println(System.nanoTime() - startTime);
	}

	private static void printWords() {
		selectedWords.stream().forEach(System.out::println);
	}

	private static void findSixLetterWordsComposedOfOtherTwoWords() {
		selectedWords = new ArrayList<>();
		for (String string1 : allWords) {
			for (String string2 : allWords) {
				String newWord = string1 + string2;
				if (newWord.length() == 6 && allWords.contains(newWord)) {
					selectedWords.add(newWord);
				}
			}
		}

	}

	private static void readFromFile() throws URISyntaxException {
		allWords = FileReaderReadable.readFromFile();

	}
}
