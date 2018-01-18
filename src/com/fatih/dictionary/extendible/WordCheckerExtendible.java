package com.fatih.dictionary.extendible;

import java.util.Set;

public class WordCheckerExtendible {

	private WordFileReader wordFileReader;
	private WordMapComparator wordMapComparator;

	public WordCheckerExtendible(WordFileReader wordFileReader, WordMapComparator wordMapComparator) {
		this.wordFileReader = wordFileReader;
		this.wordMapComparator = wordMapComparator;
	}

	public Set<String> getWordsComposedOfOtherTwoWords() {
		return wordMapComparator.getWordsComposedOfOtherTwoWords(wordFileReader.readFromFile(6));
	}

}
