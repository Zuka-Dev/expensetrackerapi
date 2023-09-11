package com.mazi.expensetrackerapi.users;

public interface UserRepository{
//    Create new User
    Integer create( String firstName, String lastName, String email, String password) throws UserAuthException;
//    Find by Email and password bascially login
    User findByEmailAndPassword( String email, String password) throws UserAuthException;

//    To know if Email has been Used before
    Integer getCountByEmail(String email);

//    Find user by unique id
    User findById(Integer userId) ;
}
