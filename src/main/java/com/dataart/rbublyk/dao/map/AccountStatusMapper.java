package com.dataart.rbublyk.dao.map;

import com.dataart.rbublyk.domain.AccountStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountStatusMapper implements RowMapper<AccountStatus> {
    @Override
    public AccountStatus mapRow(ResultSet rs, int i) throws SQLException {
        AccountStatus accountStatus = new AccountStatus();
        accountStatus.setId(rs.getInt("id"));
        accountStatus.setActive(rs.getBoolean("active"));
        accountStatus.setExchangeLossLimit(rs.getDouble("exchange_loss_limit"));
        accountStatus.setCurrency(rs.getString("currency"));
        accountStatus.setExchangeExposureLimit(rs.getDouble("exchange_exposure_limit"));
        accountStatus.setExchangeSelfExcluded(rs.getBoolean("exchange_self_excluded"));
        return accountStatus;
    }
}
