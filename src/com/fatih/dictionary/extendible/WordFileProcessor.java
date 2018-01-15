package com.fatih.dictionary.extendible;

import java.util.Collection;

public interface WordFileProcessor {
	public <T> void process(Collection<T> list);
}
