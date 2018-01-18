package com.fatih.dictionary.performance;

import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WordCheckerPerformance {

	private static Map<Character, List<String>> fiveOrLessLetterWords;
	private static Map<Character, List<String>> sixLetterWords;
	private static Set<String> selectedWords = new HashSet<>();

	public static void printWords() {
		selectedWords.stream().forEach(System.out::println);
		System.out.println("selectedWords size: " + selectedWords.size());
	}

	public static void findSixLetterWordsComposedOfOtherTwoWords() {
		for (Entry<Character, List<String>> charStringList : sixLetterWords.entrySet()) {
			checkIfSmallWordsConstructBigWord(charStringList, fiveOrLessLetterWords, selectedWords);
		}

	}

	private static void checkIfSmallWordsConstructBigWord(Entry<Character, List<String>> bigStringEntry,
			Map<Character, List<String>> smallWordsMap, Set<String> selectedWords) {
		Character key = bigStringEntry.getKey();
		List<String> bigStrings = bigStringEntry.getValue();
		List<String> smallBegingKeys = smallWordsMap.get(key);
		for (String bigString : bigStrings) {
			for (String smallStringStart : smallBegingKeys) {
				if (bigString.indexOf(smallStringStart) == 0) {
					findComplementaryWord(smallWordsMap, selectedWords, bigString, smallStringStart);
				}
			}
		}

	}

	private static void findComplementaryWord(Map<Character, List<String>> smallWordsMap, Set<String> selectedWords,
			String bigString, String smallStartString) {
		List<String> complementaryList = smallWordsMap.get(bigString.charAt(smallStartString.length()));
		if (complementaryList != null) {
			for (String complementaryString : complementaryList) {
				if (bigString.equals(smallStartString + complementaryString)) {
					selectedWords.add(bigString);
				}
			}
		}
	}

	public static void readFromFile() throws URISyntaxException {
		Map<String, Map<Character, List<String>>> words = FileReaderPerformance.readFromFile();
		fiveOrLessLetterWords = words.get(FileReaderPerformance.FIVE_OR_LESS_LETTER_WORDS);
		sixLetterWords = words.get(FileReaderPerformance.SIX_LETTER_WORDS);

	}
}
