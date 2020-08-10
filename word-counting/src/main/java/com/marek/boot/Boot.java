package com.marek.boot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.marek.wordanalyzer.WordAnalyzer;

public class Boot {
	
	public static void main( String[] args ) throws IOException {
		WordAnalyzer.startAnalyze(
				"C:\\Users\\michcmar\\Documents\\My Received Files\\sourceFile.txt");
		
		
		
		
	}

}
