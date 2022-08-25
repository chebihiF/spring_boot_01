package org.test.tp01.auth;

public interface ApplicationUserDao {
    ApplicationUserDetail getUserByUsername(String username);
}
