package dev.rishab.library.util;

public final class Str {
	private static final String EMPTY = "";

	public static Boolean isNullorEmpty(String value) {
		return value == null || EMPTY.equals(value.trim());
	}

}
