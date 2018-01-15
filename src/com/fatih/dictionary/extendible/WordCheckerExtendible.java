package com.fatih.dictionary.extendible;

import java.util.Set;

public class WordCheckerExtendible {

	private WordFileReader wordFileReader;
	private WordMapComparator wordMapComparator;

	public WordCheckerExtendible(WordFileReader wordFileReader, WordMapComparator wordMapComparator) {
		this.wordFileReader = wordFileReader;
		this.wordMapComparator = wordMapComparator;
	}

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		WordCheckerExtendible wce = new WordCheckerExtendible(new WordFileReaderImpl("wordlist.txt", "Cp1254"),
				new WordMapComparatorImpl());
		Set<String> composedWords = wce.getWordsComposedOfOtherTwoWords();
		WordFileProcessor wfp = new WordFileProcessorImpl();
		wfp.process(composedWords);
		System.out.println("selectedWords size: " + composedWords.size());
		System.out.println(System.nanoTime() - startTime);
	}

	public Set<String> getWordsComposedOfOtherTwoWords() {
		return wordMapComparator.getWordsComposedOfOtherTwoWords(wordFileReader.readFromFile(6));
	}

}
