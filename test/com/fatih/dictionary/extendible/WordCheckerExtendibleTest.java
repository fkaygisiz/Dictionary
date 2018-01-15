package com.fatih.dictionary.extendible;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import com.fatih.dictionary.extendible.WordCheckerExtendible;
import com.fatih.dictionary.extendible.WordFileReaderImpl;
import com.fatih.dictionary.extendible.WordMapComparatorImpl;

public class WordCheckerExtendibleTest {

	@Test
	public void shouldGetOne() {
		WordCheckerExtendible wce = new WordCheckerExtendible(new WordFileReaderImpl("wordlisttest.txt", "Cp1254"),
				new WordMapComparatorImpl());
		Set<String> wordsComposedOfOtherTwoWords = wce.getWordsComposedOfOtherTwoWords();
		assertTrue(1 == wordsComposedOfOtherTwoWords.size());
	}
}
