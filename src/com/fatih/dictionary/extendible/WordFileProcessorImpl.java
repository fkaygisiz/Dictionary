package com.fatih.dictionary.extendible;

import java.util.Collection;

public class WordFileProcessorImpl implements WordFileProcessor {

	public <T> void process(Collection<T> list) {
		list.stream().forEach(System.out::println);
		System.out.println("selectedWords size: " + list.size());

	}
}
