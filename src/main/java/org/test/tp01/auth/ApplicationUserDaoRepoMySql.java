package org.test.tp01.auth;

import org.springframework.stereotype.Repository;
import org.test.tp01.user.AuthorityRepository;
import org.test.tp01.user.UserRepository;

@Repository
public class ApplicationUserDaoRepoMySql implements ApplicationUserDao{

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    public ApplicationUserDaoRepoMySql(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public ApplicationUserDetail getUserByUsername(String username) {



        return null;
    }
}
