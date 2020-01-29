package customerSvc.custSvc;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import customerSvc.constants.TestCustomerConstants;
import customerSvc.controller.CustomerController;
import customerSvc.model.Customer;

/**
 * Unit test for simple App.
 */
@RunWith(MockitoJUnitRunner.class)
public class AppTest 
{
	@Test
    public void testMain() throws IOException
    {
		CustomerController custCtrl = new CustomerController();
    	ArrayList<Customer> custListSortedWithinDist1 = custCtrl.findCustWithinDist(custCtrl.parseJSON(TestCustomerConstants.INPUT_FILE_PATH), 
    			TestCustomerConstants.DIST_IN_KM);
    	custCtrl.writeToFile(TestCustomerConstants.OUTPUT_FILE_PATH, custListSortedWithinDist1);
        System.out.println( "App Closed" );
        Assert.assertNotNull(custListSortedWithinDist1);
    }
}
