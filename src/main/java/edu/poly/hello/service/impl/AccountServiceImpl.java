package edu.poly.hello.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.poly.hello.dao.AccountDAO;
import edu.poly.hello.entiry.Account;
import edu.poly.hello.service.AccountService;
@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	AccountDAO adao;

	@Override
	public Account findById(String username) {

		return adao.findById(username).get();
	}


}
