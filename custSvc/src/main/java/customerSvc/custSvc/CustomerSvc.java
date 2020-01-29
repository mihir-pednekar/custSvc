package customerSvc.custSvc;

import java.io.IOException;
import java.util.ArrayList;
import customerSvc.model.Customer;
import customerSvc.utility.DistanceUtility;
import customerSvc.utility.JsonUtility;

public interface CustomerSvc {
	
	//method to parse Json Txt File
	default ArrayList<Customer> parseJsonFromFile(String filePath) throws IOException
	{
		return JsonUtility.parseJsonFromFile(filePath);
	}
	
	//method to find Customers within the passed distance argument
	default ArrayList<Customer> findCustWithinDist(ArrayList<Customer> custList, double distInKm)
	{
		return DistanceUtility.findCustWithinDist(custList, distInKm);
	}
	
	default boolean writeToOutputFile(String filePath, ArrayList<Customer> sortedCustList) throws IOException {
		return JsonUtility.writeToFile(filePath, sortedCustList);
	}
}
