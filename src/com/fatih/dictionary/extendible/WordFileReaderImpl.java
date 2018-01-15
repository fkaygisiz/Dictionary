package com.fatih.dictionary.extendible;

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

public class WordFileReaderImpl implements WordFileReader {

	private String fileName;
	private String characterEncoding;

	public WordFileReaderImpl(String fileName, String characterEncoding) {
		super();
		this.fileName = fileName;
		this.characterEncoding = characterEncoding;
	}

	public WordMapHolder readFromFile(int wordLetterCount) {
		System.out.println("Read is started");
		Map<Character, List<String>> sixLetterWords = new HashMap<>();
		Map<Character, List<String>> fiveOrLessLetterWords = new HashMap<>();
		try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource(fileName).toURI()),
				Charset.forName(characterEncoding))) {
			stream.forEach(e -> {
				if (e.length() == wordLetterCount) {
					putToMap(sixLetterWords, e);
				} else if (e.length() < wordLetterCount) {
					putToMap(fiveOrLessLetterWords, e);
				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}

		return new WordMapHolder(sixLetterWords, fiveOrLessLetterWords);
	}

	private void putToMap(Map<Character, List<String>> mainMap, String e) {
		List<String> letterList = mainMap.get(e.charAt(0));
		if (letterList == null) {
			letterList = new ArrayList<>();
			mainMap.put(e.charAt(0), letterList);
		}
		letterList.add(e);
	}

}
