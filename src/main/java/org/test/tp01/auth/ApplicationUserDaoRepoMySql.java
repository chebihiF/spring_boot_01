package org.test.tp01.auth;

import org.springframework.stereotype.Repository;

@Repository
public class ApplicationUserDaoRepoMySql implements ApplicationUserDao{
    @Override
    public ApplicationUserDetail getUserByUsername(String username) {
        return null;
    }
}
