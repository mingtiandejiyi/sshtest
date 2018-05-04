package com.ssh.service.impl;

import com.ssh.dao.UserDAO;
import com.ssh.entity.LyUser;
import com.ssh.repository.UserRepository;
import com.ssh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by XRog
 * On 2/2/2017.2:40 PM
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDAO userDAO;

    /**
     * 通过用户名查找用户信息
     *
     * @param username
     * @return
     */
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public LyUser findByName(String username) {
        LyUser lyUser=new LyUser();
        try {
            Map<String, Object> params = new HashMap();
            params.put("name", username);
            lyUser = userDAO.findUniqueResult("from LyUser u where u.accountName = :name", params);
        }
        catch (Exception ex)
        {
            String s=ex.toString();
        }
        return lyUser;
    }

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