package com.mazi.expensetrackerapi.users;

public interface UserService {
    User validateUser(String email,String password) throws UserAuthException;

    User registerUser( String firstName, String lastName, String email, String password) throws UserAuthException;

}
