package poc.springboot.test;

import java.io.File;
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

//@RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class TestSearchFileController {

	private static final String[][] String = null;

	// @InjectMocks annotation is used to create and inject the mock object
	@InjectMocks
	SearchFileController SearchFileController = new SearchFileController();

	@Mock
	WordSearchInFilesService wordSearchInFilesService;

	@SuppressWarnings("unchecked")
	@Test
	public void test() {

		/*
		 * String[] stringArray = {"word","foundation","journal"}; List result=
		 * new ArrayList();
		 * 
		 * Assert.assertTrue(output.contains("Quizlet.htm"));
		 */

		String[] stringArray = { "Future", "took" };
		when(
				wordSearchInFilesService.searchWordsInFile(new File(
						"E:\\javafiles\\FileScanner.java").toPath(),
						stringArray)).thenReturn(true);

	}

}
