package com.fatih.dictionary.extendible;

import java.util.Set;

public interface WordMapComparator {

	public Set<String> getWordsComposedOfOtherTwoWords(WordMapHolder wordMaps);
}
