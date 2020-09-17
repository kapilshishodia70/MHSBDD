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
	private  String jsonDataPath;
	private List<Login> LoginList;
	/**
	 * @param loginList
	 */
	public JsonDataProvider() {
		
		LoginList = getLoginData();
	}
	private List<Login> getLoginData() {
		// TODO Auto-generated method stub
		jsonDataPath= "src\\test\\resources\\givebloodtestdata.json";
		Gson gson =new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(jsonDataPath));
			System.out.println("buffer reader initialised");
			Login[] login = gson.fromJson(bufferReader, Login[].class);
			System.out.println("eturning array as list");
			return Arrays.asList(login);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("json file not found");
			throw new RuntimeException("Json file not found at path : " + jsonDataPath);
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
			System.out.println(login);
			System.out.println(login.Emailid + " "+ login.Password);
			if(login.Emailid.equalsIgnoreCase(email))
				return login;
		}
		return null;
	}
	
	
	
	

}
