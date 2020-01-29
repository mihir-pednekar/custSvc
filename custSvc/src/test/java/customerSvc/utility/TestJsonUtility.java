package customerSvc.utility;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import customerSvc.constants.TestCustomerConstants;
import customerSvc.model.Customer;

@RunWith(MockitoJUnitRunner.class)
public class TestJsonUtility {
	
	@Test
	public void parseJsonFromFileIfFilePathIsEmpty() throws IOException {
		String filePath = "";
		ArrayList<Customer> custList = JsonUtility.parseJsonFromFile(filePath );
		Assert.assertNull(custList);
	}
	
	@Test
	public void parseJsonFromFileIfFilePathIsNull() throws IOException {
		String filePath = null;
		ArrayList<Customer> custList = JsonUtility.parseJsonFromFile(filePath );
		Assert.assertNull(custList);
	}
	
	@Test
	public void parseJsonFromFileIsSuccess() throws IOException {
		ArrayList<Customer> custList = JsonUtility.parseJsonFromFile(TestCustomerConstants.INPUT_FILE_PATH );
		Assert.assertNotNull(custList);
	}
	
	@Test
	public void parseJsonFromFileIsFailure() throws IOException {
		ArrayList<Customer> custList = JsonUtility.parseJsonFromFile(TestCustomerConstants.WRONG_INPUT_FILE_PATH );
		Assert.assertNull(custList);
	}
	
	@Test
	public void writeToFileIfFilePathIsEmpty() throws IOException {
		ArrayList<Customer> custList = JsonUtility.parseJsonFromFile(TestCustomerConstants.INPUT_FILE_PATH );
		String filePath = "";
		boolean success = JsonUtility.writeToFile(filePath , custList);
		Assert.assertEquals(false, success);
	}
	
	@Test
	public void writeToFileIfFilePathIsNull() throws IOException {
		ArrayList<Customer> custList = JsonUtility.parseJsonFromFile(TestCustomerConstants.INPUT_FILE_PATH );
		String filePath = "";
		boolean success = JsonUtility.writeToFile(filePath , custList);
		Assert.assertEquals(false, success);
	}
	
	@Test
	public void writeToFileIfFilePathIsSuccess() throws IOException {
		ArrayList<Customer> custList = JsonUtility.parseJsonFromFile(TestCustomerConstants.INPUT_FILE_PATH );
		String filePath = TestCustomerConstants.OUTPUT_FILE_PATH;
		boolean success = JsonUtility.writeToFile(filePath , custList);
		Assert.assertEquals(true, success);
	}
	
	@Test
	public void writeToFileIfFilePathIsFailure() throws IOException {
		ArrayList<Customer> custList = JsonUtility.parseJsonFromFile(TestCustomerConstants.INPUT_FILE_PATH );
		String filePath = TestCustomerConstants.WRONG_OUTPUT_FILE_PATH;
		boolean success = JsonUtility.writeToFile(filePath , custList);
		Assert.assertEquals(true, success);
	}
}
