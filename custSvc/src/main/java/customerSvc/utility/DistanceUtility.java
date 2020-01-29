package customerSvc.utility;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import customerSvc.constants.CustomerConstants;
import customerSvc.model.Customer;

public class DistanceUtility {
	public static Double getDistInKmFromLatLong(String latitude1, String longitude1, 
			String latitude2, String longitude2)
	{	
		int radiusOfEarth = 6371; //mean radius of earth
		double y = 1;
		
		try {
			if(null!=latitude1 && null!= longitude1 && null!= latitude2 && null!= longitude2) {
				double diffInLat = degToRad( Double.parseDouble(latitude2) - Double.parseDouble(latitude1) );
				double diffInLong = degToRad(Double.parseDouble(longitude2) - Double.parseDouble(longitude1));
				double x = Math.sin(diffInLat / 2) * Math.sin(diffInLat / 2)
						+ Math.cos(degToRad(Double.parseDouble(latitude1))) * Math.cos(degToRad(Double.parseDouble(latitude2)))
						* Math.sin(diffInLong / 2) * Math.sin(diffInLong / 2);
				y = 2 * Math.atan2(Math.sqrt(x), Math.sqrt(1-x));
			}else {
				throw new Exception();
			}
		}
		catch (Exception e) {
			System.out.println("DistanceUtility: "+e);
			return null;
		}
		return new Double(radiusOfEarth * y);
	}
	
	public static double degToRad(double degree) {
		return degree * (Math.PI / 180);
	}
	
	public static ArrayList<Customer> findCustWithinDist(ArrayList<Customer> custList, double distInKm){
		ArrayList<Customer> custSortedWithinDistList = null;
		if(null!=custList && !custList.isEmpty()) {
			custSortedWithinDistList = (ArrayList<Customer>) custList.stream()
					.filter(cust-> null!= DistanceUtility.getDistInKmFromLatLong(CustomerConstants.DUBLIN_OFFICE_LATITUDE, CustomerConstants.DUBLIN_OFFICE_LONGITUDE,
							cust.getLatitude(), cust.getLongitude()) &&
					DistanceUtility.getDistInKmFromLatLong(CustomerConstants.DUBLIN_OFFICE_LATITUDE, CustomerConstants.DUBLIN_OFFICE_LONGITUDE,
							cust.getLatitude(), cust.getLongitude()) <= distInKm)
					.sorted(Comparator
					.comparing(Customer::getUser_id))
					.collect(Collectors.toList());
		}
		return custSortedWithinDistList;
	}
}
