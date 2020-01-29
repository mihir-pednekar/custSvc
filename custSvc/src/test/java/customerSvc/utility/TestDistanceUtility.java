package customerSvc.utility;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import customerSvc.model.Customer;

@RunWith(MockitoJUnitRunner.class)
public class TestDistanceUtility {
	
	@Test
	public void testGetDistInKmFromLatLongIfLatLongIsNull() {
		
		String latitude1=null;
		String longitude1=null;
		String latitude2=null;
		String longitude2=null;
		Double dist = DistanceUtility.getDistInKmFromLatLong(latitude1, longitude1, latitude2, longitude2);
		Assert.assertNull(dist);
	}
	
	@Test
	public void testGetDistInKmFromLatLongIfLatLongIsEmpty() {
		
		String latitude1="";
		String longitude1="";
		String latitude2="";
		String longitude2="";
		Double dist = DistanceUtility.getDistInKmFromLatLong(latitude1, longitude1, latitude2, longitude2);
		Assert.assertNull(dist);
	}
	
//	@Test
//	public void testDegToRad(double degree) {
//		No need to test as it is covered in above tests
//	}
//	
	
	@Test
	public void testFindCustWithinDistIfCustListIsNull(){
		ArrayList<Customer> custUnsortedList = null;
		double distInKm = 100;
		ArrayList<Customer> custSortedList = DistanceUtility.findCustWithinDist(custUnsortedList, distInKm);
		Assert.assertNull(custSortedList);
	}
	
	@Test
	public void testFindCustWithinDistIfCustListIsEmpty(){
		ArrayList<Customer> custUnsortedList = new ArrayList<>();
		double distInKm = 100;
		ArrayList<Customer> custSortedList = DistanceUtility.findCustWithinDist(custUnsortedList, distInKm);
		Assert.assertNull(custSortedList);
	}
}
