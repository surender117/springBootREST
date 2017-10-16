package poc.springboot.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.springboot.SearchFileController;
import com.springboot.service.WordSearchInFilesService;

import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class TestSearchFileController {

	private static final String[][] String = null;
	

	@SuppressWarnings("unchecked")
	@Test
	public void testSearchWordsInFile() {
		WordSearchInFilesService wordSearchInFilesService=new WordSearchInFilesService();
		String[] stringArray = { "Future", "took" };
		boolean fileFound=wordSearchInFilesService.searchWordsInFile(new File("E:\\javafiles\\FileScanner.java").toPath(),	stringArray);
        assertTrue(fileFound);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testSearchWordsInDirectory() throws IOException {
		WordSearchInFilesService wordSearchInFilesService=new WordSearchInFilesService();
		String[] stringArray = { "Future", "took" };
		List<Path> filesFound=wordSearchInFilesService.searchWordsInPath("E:\\files",stringArray);
		assertEquals(2, filesFound.size());
	
	}
}
