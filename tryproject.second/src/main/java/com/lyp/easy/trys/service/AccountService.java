package com.lyp.easy.trys.service;

import com.lyp.easy.trys.entity.Account;

/**
 * Created by lyp on 2016/10/8.
 */
public interface AccountService {

    Account selectByPrimaryKey(int id);
}
