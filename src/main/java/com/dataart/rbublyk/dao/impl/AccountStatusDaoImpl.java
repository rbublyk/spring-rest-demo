package com.dataart.rbublyk.dao.impl;

import com.dataart.rbublyk.dao.AccountStatusDao;
import com.dataart.rbublyk.dao.map.AccountStatusMapper;
import com.dataart.rbublyk.domain.AccountStatus;
import com.dataart.rbublyk.exception.NotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@Repository("accountStatusDao")
public class AccountStatusDaoImpl implements AccountStatusDao {

    @Inject
    private JdbcTemplate jdbcTemplate;

    @Override
    public AccountStatus findOne(Integer id) throws NotFoundException {
        AccountStatus status;
        String query =
                "SELECT *\n" +
                        "FROM rituala.account_status\n" +
                        "WHERE id=(?)";
        try {
            status = jdbcTemplate.queryForObject(query, new Object[]{id}, new AccountStatusMapper());
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("Account not found");
        }
        return status;
    }

    @Override
    public AccountStatus findOneByAccountId(UUID id) throws NotFoundException {
        AccountStatus status;
        String query =
                "SELECT s.*\n" +
                        "FROM rituala.account_status AS s\n" +
                        "JOIN rituala.account AS a ON a.status_id=s.id\n" +
                        "WHERE a.id=(?)";
        try {
            status = jdbcTemplate.queryForObject(query, new Object[]{id}, new AccountStatusMapper());
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("Account not found");
        }
        return status;
    }

    @Override
    public Iterable<AccountStatus> findAll() {
        List<AccountStatus> statuses;
        String query =
                "SELECT *\n" +
                        "FROM rituala.account_status";
        try {
            AccountStatusMapper mapper = new AccountStatusMapper();
            statuses = jdbcTemplate.query(query, (rs, rowNum) -> {
                return mapper.mapRow(rs, rowNum);
            });
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("Accounts not found");
        }
        return statuses;
    }

    @Override
    public void delete(Integer id) {
        String sql =
                "DELETE\n" +
                        "FROM rituala.account_status\n" +
                        "WHERE id=(?)";
        if (jdbcTemplate.update(sql, new Object[]{id}) == 0) throw new NotFoundException("No rows was found");
    }

    @Override
    public void save(AccountStatus status) {
        String sql =
                "INSERT INTO rituala.account_status (active, currency, exchange_self_excluded, exchange_loss_limit, exchange_exposure_limit)\n" +
                        "VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, status.isActive(), status.getCurrency(), status.isExchangeSelfExcluded(),
                status.getExchangeLossLimit(), status.getExchangeExposureLimit());
    }

    @Override
    public void update(AccountStatus status) {
        System.out.println("Update was called");
        String sql =
                "UPDATE rituala.account_status\n" +
                        "SET active = ?, currency = ?, exchange_self_excluded = ?, exchange_loss_limit = ?, exchange_exposure_limit = ?\n" +
                        "WHERE id=?";
        jdbcTemplate.update(sql, status.isActive(), status.getCurrency(), status.isExchangeSelfExcluded(), status.getExchangeLossLimit(), status.getExchangeExposureLimit(), status.getId());
    }
}
