package dev.rishab.library.util;

import java.util.UUID;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Generator {

	public static String generateIsbn() {
		String isbn = UUID.randomUUID().toString();
		log.debug("Generated ISBN: " + isbn);
		return isbn;

	}

}
