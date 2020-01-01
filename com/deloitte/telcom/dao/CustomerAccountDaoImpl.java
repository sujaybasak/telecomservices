package com.deloitte.telcom.dao;

import java.util.HashMap;
import java.util.Map;


import com.deloitte.telcom.entities.CustomerAccount;
import com.deloitte.telcom.exception.CustomerNotFoundException;

public class CustomerAccountDaoImpl implements ICustomerAccountDao {
	Map<String,CustomerAccount> store =new HashMap<>();
	@Override
	public CustomerAccount findByMobileNo(String mobileNo) {
		CustomerAccount c = store.get(mobileNo);
		if (c==null)
		{
			throw new CustomerNotFoundException("Customer not found for this id"+mobileNo);
		}
		return c;
		
	}

	@Override
	public void rechargeAccount(CustomerAccount cust, double amt) {
		cust.addBalance(amt);
		
	}

	@Override
	public void addCustomerDetails(CustomerAccount c) {
		store.put(c.getMobileNo(), c);
		
	}

	

	

}
