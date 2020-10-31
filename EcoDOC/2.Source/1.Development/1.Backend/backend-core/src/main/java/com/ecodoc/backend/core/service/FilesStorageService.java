package com.ecodoc.backend.core.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FilesStorageService {
	private final Path root = Paths.get("uploads");
	private final Path deletePath = Paths.get("delete");

	public FilesStorageService() {
		if (!Files.exists(root) || !Files.exists(deletePath)) {
			this.init();
		}
	}

	public void init() {
		try {
			Files.createDirectories(root);
			Files.createDirectories(deletePath);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize folder for upload!");
		}
	}

	public static String origin(String parse) {
		if (parse == null) {
			return null;
		}
		return parse.replaceAll("__\\d+$", "");
	}

	public static String parse(String origin) {
		if (origin == null) {
			return null;
		}
		return origin + "__" + new Date().getTime();
	}

	// save file into root folder
	public void saveToSystem(MultipartFile file, String fileName) {
		Path path = root.resolve(fileName);
		try {
			InputStream inputStream = file.getInputStream();
			Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
		}
	}

	public static String getFileName(MultipartFile file) {
		Path tmp = Paths.get(file.getOriginalFilename());
		return tmp.getFileName().toString();
	}

	public String save(MultipartFile file) {
		String filename = FilesStorageService.parse(FilesStorageService.getFileName(file));
		log.error("filename: {}", filename);
		saveToSystem(file, filename);
		return filename;
	}

	// replace
	public String replace(MultipartFile file, String fileName) {
		fileName = StringUtils.cleanPath(fileName);
		deleteFile(fileName);
		String newfileName = save(file);
		log.info("Replace {} by {}", fileName, newfileName);
		return newfileName;
	}

	public Resource load(String filename) {
		try {
			Path file = root.resolve(filename);
			System.out.println(file.toString());
			Resource resource = new UrlResource(file.toUri());

			if (resource.exists() || resource.isReadable()) {
				return resource;
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
		return null;
	}

	public Path getPath(String fileName) {
		fileName = StringUtils.cleanPath(fileName);
		return root.resolve(fileName);
	}

	public File getFile(String fileName) {
		return getPath(fileName).toFile();
	}

	public boolean existFile(String fileName) {
		try {
			Path file = root.resolve(fileName);
			if (Files.exists(file)) {
				return true;
			}
		} catch (Exception e) {}
		return false;
	}

	public boolean replaceFiles(String fileName, String replaceToFile) {
		try {
			Files.move(root.resolve(fileName), root.resolve(replaceToFile), StandardCopyOption.REPLACE_EXISTING);
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	public boolean deleteFile(String fileName) {
		fileName = StringUtils.cleanPath(fileName);
		try {
			Files.move(root.resolve(fileName), deletePath.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	public boolean copyFile(String fileNameFrom, String fileNameTo) {
		try {
			Files.copy(root.resolve(fileNameFrom), root.resolve(fileNameTo), StandardCopyOption.REPLACE_EXISTING);
			return true;
		} catch (IOException e) {
			return false;
		}
	}

//	public void deleteAll() {
//		FileSystemUtils.deleteRecursively(root.toFile());
//	}

	public Stream<Path> loadAll() {
		try {
			return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Could not load the files!");
		}
	}
}
