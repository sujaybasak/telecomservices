package com.deloitte.telcom.service;

import java.util.Map;

import org.junit.*;

import com.deloitte.telcom.dao.CustomerAccountDaoImpl;
import com.deloitte.telcom.entities.CustomerAccount;


public class AccountServiceImplTest {
	
	@Test
	public void testCreateAccount_1() {
		CustomerAccountServiceImpl service = new CustomerAccountServiceImpl(new CustomerAccountDaoImpl());
		String mobileNo ="1234567890";
		double balance =1000;
		String name ="Satya";
		String accountType ="prepaid";
		CustomerAccount account = service.addCustomerDetails(mobileNo,name,accountType,balance);
		Assert.assertNotNull(account);
		Assert.assertEquals(name,account.getName());
		Map<String,CustomerAccount>store = service.getDao().getStore();
		CustomerAccount expected =store.get(mobileNo);
		Assert.assertEquals(expected,account);
	}
	@Test
	public void testCreateAccount_2() {
		CustomerAccountServiceImpl service = new CustomerAccountServiceImpl(new CustomerAccountDaoImpl());
		String mobileNo ="1234567890";
		double balance =1000;
		String name ="Satya";
		String accountType ="prepaid";
		CustomerAccount account = new CustomerAccount(mobileNo,name,accountType,balance);
		Map<String,CustomerAccount>store = service.getDao().getStore();
		store.put(mobileNo,account);
		CustomerAccount result =service.getAccountDetails(mobileNo);
		Assert.assertEquals(account, result);
	}
	

}
