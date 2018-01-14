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

		readFromFile();
		findSixLetterWordsComposedOfOtherTwoWords();
		printWords();
	}

	private static void printWords() {
		System.out.println("selectedWords size: " + selectedWords.size());
		selectedWords.stream().forEach(System.out::println);
	}

	private static void findSixLetterWordsComposedOfOtherTwoWords() {
		long startTime = System.nanoTime();
		System.out.println("findSixLetterWordsComposedOfOtherTwoWords started: ");
		selectedWords = new ArrayList<>();
		int cnt = 0;
		for (String string1 : allWords) {
			for (String string2 : allWords) {
				String newWord = string1 + string2;
				if (newWord.length() == 6 && allWords.contains(newWord)) {
					selectedWords.add(newWord);
				}
			}
			System.out.println("cnt : " + cnt);
			cnt++;
		}
		System.out.println(System.nanoTime() - startTime);

	}

	private static void readFromFile() throws URISyntaxException {
		allWords = FileReaderReadable.readFromFile();
		System.out.println("allWords.size: " + allWords.size());

	}
}
