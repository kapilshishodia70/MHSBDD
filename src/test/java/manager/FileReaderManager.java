package manager;
import dataProviders.JsonDataProvider;

public class FileReaderManager {
	
	 private static FileReaderManager fileReaderManager = new FileReaderManager(); 
	private static JsonDataProvider jsonDataReader;
	 
	public static FileReaderManager getInstance( ) {
	       return fileReaderManager;
	 }
	
	public JsonDataProvider getJsonReader(){
		 return (jsonDataReader == null) ? new JsonDataProvider() : jsonDataReader;
		 }

}
