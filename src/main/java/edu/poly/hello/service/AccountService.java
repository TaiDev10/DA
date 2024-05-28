package edu.poly.hello.service;

import edu.poly.hello.entiry.Account;

public interface AccountService {
	Account findById(String username);
}
