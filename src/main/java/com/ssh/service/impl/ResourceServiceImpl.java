package com.ssh.service.impl;

import com.ssh.entity.LyResources;
import com.ssh.entity.LyUser;
import com.ssh.repository.ResourceRepository;
import com.ssh.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by XRog
 * On 2/2/2017.2:40 PM
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public List<LyResources> findAll(){
        return   resourceRepository.findAll();
    }

}