package com.ssh.service;

import com.ssh.entity.LyResources;

import java.util.List;

/**
 * Created by XRog
 * On 2/2/2017.2:39 PM
 */
public interface ResourceService {
    List<LyResources> findAll();
}