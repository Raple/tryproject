package com.lyp.easy.trys.service.impl;

import com.lyp.easy.trys.dao.AccountDao;
import com.lyp.easy.trys.entity.Account;
import com.lyp.easy.trys.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lyp on 2016/10/8.
 */
@Service
public class AccountServiceImpl implements AccountService{
    private static Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class.getPackage().getName());

    @Autowired
    private AccountDao accountDao;

    @Override
   public Account selectByPrimaryKey(int id)
    {

        Account account=accountDao.selectByPrimaryKey(id);
        logger.info("service:",account);
        return account;
    }
}
