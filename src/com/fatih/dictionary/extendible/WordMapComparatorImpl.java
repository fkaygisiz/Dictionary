package com.fatih.dictionary.extendible;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class WordMapComparatorImpl implements WordMapComparator {

	public Set<String> getWordsComposedOfOtherTwoWords(WordMapHolder wordMaps) {
		Set<String> selectedWords = new HashSet<>();
		for (Entry<Character, List<String>> charStringList : wordMaps.getBigWordMap().entrySet()) {
			checkIfSmallWordsConstructBigWord(charStringList, wordMaps.getSmallWordsMap(), selectedWords);
		}
		return selectedWords;
	}

	private void checkIfSmallWordsConstructBigWord(Entry<Character, List<String>> bigStringEntry,
			Map<Character, List<String>> fiveOrLessLetterWords2, Set<String> selectedWords) {
		Character key = bigStringEntry.getKey();
		List<String> bigStrings = bigStringEntry.getValue();
		List<String> smallBegingKeys = fiveOrLessLetterWords2.get(key);
		for (String bigString : bigStrings) {
			for (String smallStringStart : smallBegingKeys) {
				if (bigString.indexOf(smallStringStart) == 0) {
					findComplementaryWord(fiveOrLessLetterWords2, selectedWords, bigString, smallStringStart);
				}
			}
		}

	}

	private void findComplementaryWord(Map<Character, List<String>> fiveOrLessLetterWords, Set<String> selectedWords,
			String bigString, String smallStringStart) {
		List<String> complementaryList = fiveOrLessLetterWords.get(bigString.charAt(smallStringStart.length()));
		if (complementaryList != null) {
			for (String complementaryString : complementaryList) {
				if (bigString.equals(smallStringStart + complementaryString)) {
					selectedWords.add(bigString);
				}
			}
		}
	}
}
