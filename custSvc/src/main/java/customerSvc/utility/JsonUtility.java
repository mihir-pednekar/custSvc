package customerSvc.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import customerSvc.constants.CustomerConstants;
import customerSvc.model.Customer;

public class JsonUtility {
	
	public static ArrayList<Customer> parseJsonFromFile(String filePath) throws IOException 
	{
		JSONParser parser = new JSONParser();
		String currentLine;
		ArrayList<Customer> custList = null;
		BufferedReader bufferReader = null;
		 
        try 
        {	
        	if(null!=filePath && !filePath.isEmpty()) {
        		bufferReader = new BufferedReader(new FileReader(filePath));
            	custList = new ArrayList<Customer>();
            	
            	while( (currentLine = bufferReader.readLine() ) != null) {
            		Object objString = parser.parse(currentLine);
            		JSONObject json = (JSONObject) objString;
            		custList.add(new Customer( (String)json.get(CustomerConstants.LATITUDE), 
            				(Long)json.get(CustomerConstants.USER_ID),
            				(String)json.get(CustomerConstants.NAME),
            				(String)json.get(CustomerConstants.LONGITUDE)));
            	}
            	System.out.println("Parsed JSON File succesfully to "+filePath);
        	}else {
        		throw new Exception("JsonUtility: filePath is null or empty");
        	}
        	
        }
        catch(Exception e) 
        {
        	System.out.println(e);
        }
        finally {
        	if(null!=bufferReader)
        		bufferReader.close();
        }
        return custList;
	}
	
	public static boolean writeToFile(String filePath, ArrayList<Customer> sortedCustList) throws IOException {
		FileWriter writer = null;
        BufferedWriter bufferedWriter = null;
        boolean success = false;
		try {
        	if(null != filePath && !filePath.isEmpty() && null != sortedCustList && !sortedCustList.isEmpty()) {
        		writer = new FileWriter(filePath);
                bufferedWriter = new BufferedWriter(writer);
                for(Customer cust : sortedCustList) {
                    bufferedWriter.write(cust.getName()+","+cust.getUser_id());
                    bufferedWriter.newLine();
                }
                success = true; //file written successfully.
                System.out.println("File written succesfully to "+filePath);
        	}else {
        		if(null != sortedCustList && !sortedCustList.isEmpty())
        			throw new Exception("JsonUtility: filePath is null or empty");
        		else if(null != filePath && !filePath.isEmpty())
        			throw new Exception("JsonUtility: sortedCustList is null or empty");
        	}
        } catch (Exception e) {
            e.printStackTrace();
        }
		finally {
        	if(null!=bufferedWriter)
        		bufferedWriter.close();
        }
		return success;
	}

}
