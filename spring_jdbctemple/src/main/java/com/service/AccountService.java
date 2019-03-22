package com.service;

import java.util.List;

public interface AccountService {

void transfer(String sourceName, String targetName, Long money);


    public void save(Account account);

    public void update(Account account);

    public void delete(Account account);

    public List<Account> findAll();

    public Account findByName(String targetName);

    public Object findCount();
}
