package com.fatih.dictionary.extendible;

import java.net.URISyntaxException;
import java.util.Set;

public class MainExtendible {

	/**
	 * ~ 2.5 - 3 seconds
	 * 
	 * @param args
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		WordCheckerExtendible wce = new WordCheckerExtendible(new WordFileReaderImpl("wordlist.txt", "Cp1254"),
				new WordMapComparatorImpl());
		Set<String> composedWords = wce.getWordsComposedOfOtherTwoWords();
		WordFileProcessor wfp = new WordFileProcessorImpl();
		wfp.process(composedWords);
		System.out.println(System.nanoTime() - startTime);
	}

}
