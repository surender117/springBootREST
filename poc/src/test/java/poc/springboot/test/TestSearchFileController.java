package poc.springboot.test;

import java.util.ArrayList;

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

	//@InjectMocks annotation is used to create and inject the mock object
	 @InjectMocks
	 SearchFileController SearchFileController = new  SearchFileController();
	
	 @Mock
	 WordSearchInFilesService wordSearchInFilesService ;
	 
	 @Test
	 public void test(){
		 
		 String[] stringArray = {"word","foundation","journal"};		 								
		 when(wordSearchInFilesService.listDirectory("c:\\Backup-31-July-2017", 0,stringArray )).thenReturn(null);
		 
		 String wordsToSearch= "word";
		
				 Assert.assertEquals(SearchFileController.WordSearchInFiles(wordsToSearch),null);
				 
	 }
	 
}
