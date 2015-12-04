package com.dataart.rbublyk.service;

import com.dataart.rbublyk.domain.AccountStatus;
import com.dataart.rbublyk.dto.AccountStatusDTO;

import java.util.List;
import java.util.UUID;

public interface AccountStatusService {
    public AccountStatusDTO findOneByAccountId(UUID id);
    public Iterable<AccountStatus> findAll();
    public void update(AccountStatus status, int id);
    public void save(AccountStatus status);
    public void delete(int id);
}
