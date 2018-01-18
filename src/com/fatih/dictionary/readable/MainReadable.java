package com.fatih.dictionary.readable;

import java.net.URISyntaxException;

public class MainReadable {

	/**
	 * Needs approximately 117000 seconds to complete
	 * 
	 * @param args
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) throws URISyntaxException {

		long startTime = System.nanoTime();
		WordCheckerReadable wcr = new WordCheckerReadable();
		wcr.readFromFileFindWordsAndPrint();
		System.out.println(System.nanoTime() - startTime);
	}
}
