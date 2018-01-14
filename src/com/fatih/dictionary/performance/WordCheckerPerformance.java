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

		int cnt = 0;
		for (Entry<Character, List<String>> charStringList : sixLetterWords.entrySet()) {
			checkIfSmallWordsConstructBigWord(charStringList, fiveOrLessLetterWords, selectedWords);
			System.out.println("cnt : " + cnt);
			cnt++;
		}
		System.out.println(System.nanoTime() - startTime);

	}

	private static void checkIfSmallWordsConstructBigWord(Entry<Character, List<String>> bigStringEntry,
			Map<Character, List<String>> fiveOrLessLetterWords2, Set<String> selectedWords2) {
		Character key = bigStringEntry.getKey();
		List<String> bigStrings = bigStringEntry.getValue();
		List<String> smallBegingKeys = fiveOrLessLetterWords2.get(key);
		for (String bigString : bigStrings) {
			for (String smallStringStart : smallBegingKeys) {
				if (bigString.indexOf(smallStringStart) == 0) {
					List<String> complementaryList = fiveOrLessLetterWords2.get(bigString.charAt(smallStringStart.length()));
					if(complementaryList != null) {
						for (String complementaryString : complementaryList) {
							if(bigString.equals(smallStringStart + complementaryString)) {
								selectedWords2.add(bigString);
							}
						}
					}
				}
			}
		}
		

	}

	private static void readFromFile() throws URISyntaxException {
		Map<String, Map<Character, List<String>>> words = FileReaderPerformance.readFromFile();
		fiveOrLessLetterWords = words.get(FileReaderPerformance.FIVE_OR_LESS_LETTER_WORDS);
		sixLetterWords = words.get(FileReaderPerformance.SIX_LETTER_WORDS);
		System.out.println("fiveOrLessLetterWords.size(): " + fiveOrLessLetterWords.size());
		System.out.println("sixLetterWords.size(): " + sixLetterWords.size());

	}
}
