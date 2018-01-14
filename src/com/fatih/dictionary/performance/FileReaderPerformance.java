package com.fatih.dictionary.performance;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class FileReaderPerformance {
	public static final String SIX_LETTER_WORDS = "sixLetterWords";
	public static final String FIVE_OR_LESS_LETTER_WORDS = "fiveOrLessLetterWords";

	public static Map<String, Map<Character, List<String>>> readFromFile() throws URISyntaxException {
		System.out.println("Read is started");
		Map<Character, List<String>> sixLetterWords = new HashMap<>();
		Map<Character, List<String>> fiveOrLessLetterWords = new HashMap<>();
		try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource("wordlist.txt").toURI()),
				Charset.forName("Cp1254"))) {
			stream.forEach(e -> {
				if (e.length() == 6) {
					putToMap(sixLetterWords, e);
				} else if (e.length() < 6) {
					putToMap(fiveOrLessLetterWords, e);
				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
		Map<String, Map<Character, List<String>>> result = new HashMap<>();
		result.put(SIX_LETTER_WORDS, sixLetterWords);
		result.put(FIVE_OR_LESS_LETTER_WORDS, fiveOrLessLetterWords);
		return result;
	}

	private static void putToMap(Map<Character, List<String>> mainMap, String e) {
		List<String> letterList = mainMap.get(e.charAt(0));
		if (letterList == null) {
			letterList = new ArrayList<>();
			mainMap.put(e.charAt(0), letterList);
		}
		letterList.add(e);
	}
}
