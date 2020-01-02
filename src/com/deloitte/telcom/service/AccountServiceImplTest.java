package com.deloitte.telecom.*;
import org.junit.*;


public class AccountServiceImplTest {
	
	@Test
	public void testCreateAccount_1() {
		CustomerAccountServiceImpl service = new CustomerAccountServiceImpl(new CustomerAccountDaoImpl());
		String mobileNo ="1234567890";
		double balance =1000;
		String name ="Satya";
		String accountType ="prepaid";
		CustomerAccount account = service.addCustomerDetails(String mobileNo, String name, String accountType, double balance);
		Assert.assertNotNull(account);
		Assert.assertEquals(name,account.getName());
		Map<String,CustomerAccount>store = service.getCustomerAccountDaoImpl().getStore();
		CustomerAccount expected =store.get(mobileNo);
		Assert.assertEquals(expected,account);
	}
	

}
