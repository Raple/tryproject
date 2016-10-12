package com.lyp.easy.trys.dao;
import com.lyp.easy.trys.entity.Account;

/**
 * Created by lyp on 2016/10/8.
 */
public interface AccountDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}
