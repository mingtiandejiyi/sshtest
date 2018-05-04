package com.ssh.service.impl;

import com.ssh.entity.LyUser;
import com.ssh.repository.UserRepository;
import com.ssh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by XRog
 * On 2/2/2017.2:40 PM
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public Long save() {
        LyUser user = new LyUser();
        user.setUserName("admin");
        user.setAccountName("admin");
        user.setPassword("admin");
        user.setCredentialsSalt("");
        user.setDescription("超管测试");
        user.setDeletestatus(1);
        user.setLocked("1");
        return userRepository.save(user);
    }
}