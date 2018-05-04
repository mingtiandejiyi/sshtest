package com.ssh.controller;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    /**
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public String login(Model model) {
        model.addAttribute("error","");
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST, produces = "text/html; charset=utf-8")
    @Transactional
    public String login(String username, String password, Model model) {
        try {
            if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
                model.addAttribute("error","用户名或密码不能为空！");
                return "login";
            }
            // 想要得到 SecurityUtils.getSubject()　的对象．．访问地址必须跟ｓｈｉｒｏ的拦截地址内．不然后会报空指针
            Subject user = SecurityUtils.getSubject();
            // 用户输入的账号和密码,,存到UsernamePasswordToken对象中..然后由shiro内部认证对比,
            // 认证执行者交由ShiroDbRealm中doGetAuthenticationInfo处理
            // 当以上认证成功后会向下执行,认证失败会抛出异常
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            try {
                user.login(token);
            } catch (LockedAccountException lae) {
                token.clear();
                model.addAttribute("error", "用户已经被锁定不能登录，请与管理员联系！");
                return "login";
            } catch (ExcessiveAttemptsException e) {
                token.clear();
                model.addAttribute("error", "账号：" + username + " 登录失败次数过多,锁定10分钟!");
                return "login";
            } catch (AuthenticationException e) {
                token.clear();
                model.addAttribute("error", "用户或密码不正确！");
                return "login";
            }
            Session session = SecurityUtils.getSubject().getSession();
            model.addAttribute("error","");
        } catch (Exception e) {
            logger.error("登录异常",e);
            model.addAttribute("error", "登录异常，请联系管理员！");
            return "login";
        }
        return "redirect:index.shtml";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout() {
        // 使用权限管理工具进行用户的退出，注销登录
        SecurityUtils.getSubject().logout(); // session
        // 会销毁，在SessionListener监听session销毁，清理权限缓存
        return "redirect:login.shtml";
    }
}
