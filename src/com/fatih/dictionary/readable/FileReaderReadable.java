package com.fatih.dictionary.readable;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaderReadable {

	public static List<String> readFromFile() throws URISyntaxException {
		// read file into stream, try-with-resources
		System.out.println("Read is started");
		try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource("wordlist.txt").toURI()),
				Charset.forName("Cp1254"))) {
			return stream.filter(e -> e.length() <= 6 ).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
