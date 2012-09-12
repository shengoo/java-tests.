package epub;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipInputStream;

import nl.siegmann.epublib.domain.Author;
import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.InputStreamResource;
import nl.siegmann.epublib.domain.Section;
import nl.siegmann.epublib.epub.EpubReader;
import nl.siegmann.epublib.epub.EpubWriter;

import com.simontuffs.onejar.OneJarFile;


public class EpubTest {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		// read epub file
		EpubReader epubReader = new EpubReader();
		File file = new File("dracula.epub");
		ZipInputStream zipin = new ZipInputStream(new FileInputStream(file));
		Book book = epubReader.readEpub(zipin);
		 
		// print the first title
		List<String> titles = book.getMetadata().getTitles();
		System.out.println("book title:" + (titles.isEmpty() ? "book has no title" : titles.get(0)));
//		System.out.println(book.getSpineSections().size());
//		System.out.println(book.getTocSections().size());
		for(int i=0;i<book.getSpineSections().size();i++){
			System.out.println(book.getSpineSections().get(i).getResource().getId());
		}
		for (int j = 0; j < book.getTocSections().size(); j++) {
			Section section = book.getTocSections().get(j);
			System.out.println(section.getTitle());
			if (!section.getChildren().isEmpty()) {
				for (int k = 0; k < section.getChildren().size(); k++) {
					System.out.println(section.getChildren().get(k).getTitle());
				}
			}
		}
		
	}

}
