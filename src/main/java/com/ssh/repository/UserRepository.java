package com.ssh.repository;

import com.ssh.entity.LyResources;
import com.ssh.entity.LyUser;

/**
 * Created by XRog
 * On 2/2/2017.2:25 PM
 */
public interface UserRepository extends DomainRepository<LyUser,Long> {

    LyUser findByName(String userName);


}