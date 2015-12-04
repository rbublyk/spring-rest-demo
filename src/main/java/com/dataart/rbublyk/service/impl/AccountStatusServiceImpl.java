package com.dataart.rbublyk.service.impl;

import com.dataart.rbublyk.dao.AccountStatusDao;
import com.dataart.rbublyk.domain.AccountStatus;
import com.dataart.rbublyk.dto.AccountStatusDTO;
import com.dataart.rbublyk.service.AccountStatusService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.UUID;

@Service("accountStatusService")
public class AccountStatusServiceImpl implements AccountStatusService {

    @Inject
    private AccountStatusDao accountStatusDao;

    @Override
    public AccountStatusDTO findOneByAccountId(UUID id){
        AccountStatus status = accountStatusDao.findOneByAccountId(id);
        AccountStatusDTO statusDTO = new AccountStatusDTO(status, id);
        return statusDTO;
    }

    @Override
    public Iterable<AccountStatus> findAll() {
        return accountStatusDao.findAll();
    }

    @Override
    public void update(AccountStatus status, int id) {
        AccountStatus currentStatus = accountStatusDao.findOne(id);
        accountStatusDao.update(status);
    }

    @Override
    public void save(AccountStatus status) {
        accountStatusDao.save(status);
    }

    @Override
    public void delete(int id) {
        accountStatusDao.delete(id);
    }
}
