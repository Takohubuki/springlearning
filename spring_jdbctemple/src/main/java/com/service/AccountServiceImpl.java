package com.service;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AccountServiceImpl implements AccountService {


    private JdbcTemplate jdbcTemplate;
//transfer
    @Override
    public void transfer(String sourceName, String targetName, Long money) {
        Account source = findByName(sourceName);
        Account target = findByName(targetName);


        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);

        update(source);
        System.out.println(1/0);
        update(target);
    }

    //save
    @Override
    public void save(Account account) {
        jdbcTemplate.update(" insert into account(name, money) values(? ,?)"
        ,account.getName()
        ,account.getMoney());
    }

    //update
    @Override
    public void update(Account account) {
        jdbcTemplate.update(" update account set money = ? where name = ?"
        ,account.getMoney()
        ,account.getName());
    }

    //delete
    @Override
    public void delete(Account account) {
        jdbcTemplate.update(" delete from account where name = ?"
        ,account.getName());
    }

    //findAll
    @Override
    public List<Account> findAll() {
        return jdbcTemplate.query(" select * from account", new RowMapperImp());
    }
    //RowMapper 实现类
    class RowMapperImp implements RowMapper<Account>{

        @Override
        public Account mapRow(ResultSet resultSet, int i) throws SQLException {
            Account a = new Account();
            a.setMoney(resultSet.getLong("money"));
            a.setName(resultSet.getString("name"));
            return a;
        }
    }
    //findCount
    @Override
    public Object findCount() {
        return jdbcTemplate.queryForObject(" select count(*) from account", Long.class);
    }
    //findByName
    @Override
    public Account findByName(String Name) {
        List<Account> query = jdbcTemplate.query(" select * from account where name = ? ",
                new BeanPropertyRowMapper<Account>(Account.class), Name);

        return query.isEmpty() ? null :query.get(0);
    }


//set  jdbcTemplate
    public void setJdbcTemple(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//get jdbcTemplate
    public JdbcTemplate getJdbcTemple() {
        return jdbcTemplate;
    }


}
