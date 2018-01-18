package com.fatih.dictionary.readable;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class WordCheckerReadable {

	private List<String> sixOrLessLetterWords;
	private List<String> selectedWords;

	public void readFromFileFindWordsAndPrint() {
		this.readFromFile();
		this.findSixLetterWordsComposedOfOtherTwoWords();
		this.printWords();
		System.out.println("selectedWords size: " + selectedWords.size());
	}

	private void printWords() {
		selectedWords.stream().forEach(System.out::println);
	}

	private void findSixLetterWordsComposedOfOtherTwoWords() {
		selectedWords = new ArrayList<>();
		for (String firstSmallLetter : sixOrLessLetterWords) {
			for (String secondSmallLetter : sixOrLessLetterWords) {
				String newWord = firstSmallLetter + secondSmallLetter;
				if (newWord.length() == 6 && sixOrLessLetterWords.contains(newWord)) {
					selectedWords.add(newWord);
				}
			}
		}

	}

	private void readFromFile() {
		try {
			sixOrLessLetterWords = FileReaderReadable.readFromFile();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}
}
