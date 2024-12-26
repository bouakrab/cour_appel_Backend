package com.pvs.security.service;

import com.pvs.security.entities.AppRole;
import com.pvs.security.entities.AppUser;
public interface AccountService {
    public AppUser saveUser(String username, String password, String confirmedPassword);
    public AppRole save(AppRole role);
    public AppUser loadUserByUsername(String username);
    public void addRoleToUser(String username,String rolename);
}
