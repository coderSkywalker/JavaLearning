package rozdzial.pietnasty.Boot;

import java.io.IOException;

import rozdzial.pietnasty.pierwszy.CreateTextFile;
import rozdzial.pietnasty.pierwszy.FileAndDirectoryInfo;
import rozdzial.pietnasty.pierwszy.MakeDirectoryAndFile;
import rozdzial.pietnasty.pierwszy.ReadTextFile;
import rozdzial.pietnasty.studiumprzypadku.CreditInquiry;
//import rozdzial.pietnasty.studiumprzypadku.firstcopy.CreditInquiry;

public class Boot {
	
	public static void main( String[] args ) throws IOException {
		
//		try {
//			FileAndDirectoryInfo.getFileAndDirectoryInfo();
//		} catch (IOException e) {
//
//			e.printStackTrace();
//		}
		
//		CreateTextFile.createTextFile();
		
//		MakeDirectoryAndFile.makeDirAndFile();
		
//		ReadTextFile.readTextFromFile();
		
		CreditInquiry.start();
		
//		CreditInquiry.startApp();
		
	}

}
