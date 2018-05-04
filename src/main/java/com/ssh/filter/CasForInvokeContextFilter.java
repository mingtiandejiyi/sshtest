package com.ssh.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ssh.entity.LyUser;
import com.ssh.service.UserService;
import com.ssh.util.SpringContextHolder;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 该过滤器用户从CAS认证服务器中获取登录用户用户名，并填充必要的Session.
 * @author jiarong_cheng
 * @created 2012-7-12
 */

public class CasForInvokeContextFilter implements Filter {


    @JsonIgnore
    @Autowired
    public transient UserService userService;

    private void getCommonDAO(){
        if (userService == null) {
            userService = SpringContextHolder.getBean("userService");
        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpSession httpSession = ((HttpServletRequest) request).getSession();
        if (((HttpServletRequest) request).getUserPrincipal() != null) {
            //如果session中没有用户信息，则填充用户信息
            if (SecurityUtils.getSubject().getPrincipal() == null) {
                //从Cas服务器获取登录账户的用户名
                Assertion assertion = AssertionHolder.getAssertion();
                String username = assertion.getPrincipal().getName();

                try {
                    //根据单点登录的账户的用户名，从数据库用户表查找用户信息， 填充到session中
                    //User user = UserDao.getUserByName(userName);
                    //session.setAttribute("username", userName);
                    //session.setAttribute("userId", user.getId());

                    getCommonDAO();
                    LyUser lyUser = userService.findByName(username);
                    if (lyUser!=null) {
                        if ("2".equals(lyUser.getLocked())) {
                            throw new LockedAccountException(); // 帐号锁定
                        }
                        // 想要得到 SecurityUtils.getSubject()　的对象．．访问地址必须跟ｓｈｉｒｏ的拦截地址内．不然后会报空指针
                        Subject user = SecurityUtils.getSubject();
                        // 用户输入的账号和密码,,存到UsernamePasswordToken对象中..然后由shiro内部认证对比,
                        // 认证执行者交由ShiroDbRealm中doGetAuthenticationInfo处理
                        // 当以上认证成功后会向下执行,认证失败会抛出异常
                        UsernamePasswordToken token = new UsernamePasswordToken(username, "123456");
                        try {
                            user.login(token);
                        } catch (LockedAccountException lae) {
                            token.clear();
                            //model.addAttribute("error", "用户已经被锁定不能登录，请与管理员联系！");
                            //return "login";
                        } catch (ExcessiveAttemptsException e) {
                            token.clear();
                            //model.addAttribute("error", "账号：" + username + " 登录失败次数过多,锁定10分钟!");
                            //return "login";
                        } catch (AuthenticationException e) {
                            token.clear();
                            //model.addAttribute("error", "用户或密码不正确！");
                            //return "login";
                        }
                        Session session = SecurityUtils.getSubject().getSession();

                        httpSession.setAttribute("userId", lyUser.getId());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
    }
}
