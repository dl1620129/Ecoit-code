package com.ecodoc.backend.core.common;

import java.io.IOException;
import java.util.List;

import com.ecodoc.backend.core.domain.Preferences;

public class ExtensionCommon {

	public static String getExtension(String fileName) throws IOException {
		String extension = "";
		int i = fileName.lastIndexOf('.');
		if (i > 0) {
			extension = fileName.substring(i + 1);
		}
		return extension;
	}

	public static boolean checkExtension(List<Preferences> data, String ext, Long size) throws Exception {
		for (Preferences pre : data) {
			if ((pre.getExtension().equals(ext)) && (pre.getMaxSize()*1024 >= size)) {
				return true;
			}
		}
		return false;
	}
	
}
