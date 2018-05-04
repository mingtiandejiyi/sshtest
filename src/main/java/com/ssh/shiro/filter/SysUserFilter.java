package com.ssh.shiro.filter;

import org.apache.shiro.web.filter.PathMatchingFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SysUserFilter extends PathMatchingFilter {

//	@Inject
//	private IUserService userService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

//        String username = (String)SecurityUtils.getSubject().getPrincipal();
//
//        List<LyUser> ls = userService.findbyAccountName(username);
        /*request.setAttribute("user", Common.findUserSession());*/
        return true;
    }
}