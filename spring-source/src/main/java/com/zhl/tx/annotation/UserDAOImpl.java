package com.zhl.tx.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *
 * @author zhl
 * @since 2024-06-07 16:56
 */
@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(User user) {
        jdbcTemplate.update("insert into t_user (name, version) values (?, ?)", user.getName(), user.getVersion());
    }

    @Override
    public void update(User user) {
        jdbcTemplate.update("update t_user set name=?, version=? where id = ?", user.getName(), user.getVersion(), user.getId());
    }

}
