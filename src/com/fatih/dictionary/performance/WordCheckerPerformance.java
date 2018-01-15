package com.fatih.dictionary.performance;

import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WordCheckerPerformance {

	static Map<Character, List<String>> fiveOrLessLetterWords;
	static Map<Character, List<String>> sixLetterWords;
	static Set<String> selectedWords = new HashSet<>();

	/**
	 * 3.068.114 seconds ~ 3 seconds
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
		for (Entry<Character, List<String>> charStringList : sixLetterWords.entrySet()) {
			checkIfSmallWordsConstructBigWord(charStringList, fiveOrLessLetterWords, selectedWords);
		}

	}

	private static void checkIfSmallWordsConstructBigWord(Entry<Character, List<String>> bigStringEntry,
			Map<Character, List<String>> fiveOrLessLetterWords2, Set<String> selectedWords2) {
		Character key = bigStringEntry.getKey();
		List<String> bigStrings = bigStringEntry.getValue();
		List<String> smallBegingKeys = fiveOrLessLetterWords2.get(key);
		for (String bigString : bigStrings) {
			for (String smallStringStart : smallBegingKeys) {
				if (bigString.indexOf(smallStringStart) == 0) {
					findComplementaryWord(fiveOrLessLetterWords2, selectedWords2, bigString, smallStringStart);
				}
			}
		}

	}

	private static void findComplementaryWord(Map<Character, List<String>> fiveOrLessLetterWords2,
			Set<String> selectedWords2, String bigString, String smallStringStart) {
		List<String> complementaryList = fiveOrLessLetterWords2.get(bigString.charAt(smallStringStart.length()));
		if (complementaryList != null) {
			for (String complementaryString : complementaryList) {
				if (bigString.equals(smallStringStart + complementaryString)) {
					selectedWords2.add(bigString);
				}
			}
		}
	}

	private static void readFromFile() throws URISyntaxException {
		Map<String, Map<Character, List<String>>> words = FileReaderPerformance.readFromFile();
		fiveOrLessLetterWords = words.get(FileReaderPerformance.FIVE_OR_LESS_LETTER_WORDS);
		sixLetterWords = words.get(FileReaderPerformance.SIX_LETTER_WORDS);

	}
}
