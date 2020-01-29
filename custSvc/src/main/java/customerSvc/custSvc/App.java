package customerSvc.custSvc;

import java.util.ArrayList;

import customerSvc.constants.CustomerConstants;
import customerSvc.controller.CustomerController;
import customerSvc.model.Customer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	CustomerController custCtrl = new CustomerController();
    	boolean success = false;
    	ArrayList<Customer> custListSortedWithinDist = custCtrl.findCustWithinDist(custCtrl.parseJSON(CustomerConstants.INPUT_FILE_PATH), 
    			CustomerConstants.DIST_IN_KM);
    	if(null!=custListSortedWithinDist && !custListSortedWithinDist.isEmpty()) {
    		success = custCtrl.writeToFile(CustomerConstants.OUTPUT_FILE_PATH, custListSortedWithinDist);
    		if(success)
    			System.out.println("File writting Success.");
    		else
    			System.out.println("File writting Failure.");
    	}
    	else
    		throw new Exception("No Customers found within the distance specified.");
        System.out.println( "App Closed" );
    }
}
