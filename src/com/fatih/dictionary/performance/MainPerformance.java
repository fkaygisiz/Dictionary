package com.fatih.dictionary.performance;

import java.net.URISyntaxException;

public class MainPerformance {
	/**
	 * ~ 2.5 - 3 seconds
	 * 
	 * @param args
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) throws URISyntaxException {

		long startTime = System.nanoTime();
		WordCheckerPerformance.readFromFile();
		WordCheckerPerformance.findSixLetterWordsComposedOfOtherTwoWords();
		WordCheckerPerformance.printWords();
		System.out.println(System.nanoTime() - startTime);
	}
}
