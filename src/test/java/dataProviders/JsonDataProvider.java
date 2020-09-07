package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import testDatatype.Login;

public class JsonDataProvider {
	private final String loginDataPath= "src\\test\\resources\\givebloodtestdata.json";
	private List<Login> LoginList;
	/**
	 * @param loginList
	 */
	public JsonDataProvider() {
		
		LoginList = getLoginData();
	}
	private List<Login> getLoginData() {
		// TODO Auto-generated method stub
		Gson gson =new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(loginDataPath));
			Login[] login = gson.fromJson(bufferReader, Login[].class);
			return Arrays.asList(login);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Json file not found at path : " + loginDataPath);
		}
		finally {
			try{if(bufferReader!= null)
				bufferReader.close();
			}
			catch(IOException ignore) {}
		}
	
	}
	
	public final Login getLoginByEmail(String email)
	{
		//lambda function
		//return LoginList.stream().filter(x->x.emailId.equalsIgnoreCase(email)).findAny().get();
		//normal method
		for(Login login : LoginList) {
			if(login.emailId.equalsIgnoreCase(email))
				return login;
		}
		return null;
	}
	
	
	
	

}
