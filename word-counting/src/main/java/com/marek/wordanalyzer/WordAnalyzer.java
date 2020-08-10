package com.marek.wordanalyzer;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class WordAnalyzer {

	
	
	public static void startAnalyze( String pathToFile ) {
		analyzeTextFromFile( pathToFile );
	}
	
	private static void analyzeTextFromFile( String pathToFile ) {
		
		Path path = Paths.get( pathToFile );
		
		try {
			
			FileInputStream stream = new FileInputStream(pathToFile);
			
			
			
			List<String> fileContent = Files.readAllLines( path, Charset.forName("UTF-8"));
			System.out.println( fileContent.get(1));
//			Stream< String > stream = Files.lines(path);
//			stream.forEach( e -> System.out.println( e ));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
