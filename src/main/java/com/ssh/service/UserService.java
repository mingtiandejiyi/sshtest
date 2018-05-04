package com.ssh.service;

import com.ssh.entity.LyUser;

/**
 * Created by XRog
 * On 2/2/2017.2:39 PM
 */
public interface UserService {
    LyUser findByName(String userName);
    Long save();

}