package com;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
	private static final String BUNDLE_NAME = "messages";
	private static ResourceBundle RESOURCE_BUNDLE=ResourceBundle.getBundle(BUNDLE_NAME,new Locale("en","EN"));

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
