package com.dataart.rbublyk.dao;

import com.dataart.rbublyk.domain.AccountStatus;
import com.dataart.rbublyk.exception.NotFoundException;

import java.util.UUID;

public interface AccountStatusDao extends CrudDao<AccountStatus, Integer> {

    public AccountStatus findOneByAccountId(UUID id) throws NotFoundException;

}
