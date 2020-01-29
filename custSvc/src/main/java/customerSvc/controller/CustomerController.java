package customerSvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import customerSvc.custSvc.CustomerSvc;
import customerSvc.model.Customer;

public class CustomerController implements CustomerSvc{
    
	public ArrayList<Customer> parseJSON(String filePath) throws IOException {
		return this.parseJsonFromFile(filePath);
	}
	
	public ArrayList<Customer> getDistFromCoordinates( ArrayList<Customer> custList, double distInKm ) { 
		 return this.findCustWithinDist(custList, distInKm);
	}
	
	public boolean writeToFile(String filePath, ArrayList<Customer> sortedCustList) throws IOException {
		return this.writeToOutputFile(filePath, sortedCustList);
	}
}
