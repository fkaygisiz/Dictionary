package com.fatih.dictionary.extendible;

import java.util.List;
import java.util.Map;

public class WordMapHolder {

	Map<Character, List<String>> bigWordMap;
	Map<Character, List<String>> smallWordsMap;

	public WordMapHolder(Map<Character, List<String>> bigWordMap, Map<Character, List<String>> smallWordsMap) {
		super();
		this.bigWordMap = bigWordMap;
		this.smallWordsMap = smallWordsMap;
	}

	public Map<Character, List<String>> getBigWordMap() {
		return bigWordMap;
	}

	public Map<Character, List<String>> getSmallWordsMap() {
		return smallWordsMap;
	}

}
