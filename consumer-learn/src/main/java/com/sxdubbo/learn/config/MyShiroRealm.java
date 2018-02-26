package com.sxdubbo.learn.config;


import com.sxdubbo.learn.controller.UserController;
import com.sxdubboapi.learn.domain.User;
import com.sxdubboapi.learn.service.RedisService;
import com.sxdubboapi.learn.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyShiroRealm extends AuthorizingRealm {
    @Resource
    private UserService userService;

    @Resource
    private RedisService redisService;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);

    private User user = new User();

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User userInfo = (User) principals.getPrimaryPrincipal();
        BeanUtils.copyProperties(userInfo, user);
//        for (SysRole role : user.getRoleList()) {
//            authorizationInfo.addRole(role.getRole());
//            for (SysPermission p : role.getPermissions()) {
//                authorizationInfo.addStringPermission(p.getPermission());
//            }
//        }
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号.
        String username = (String) token.getPrincipal();
        System.out.println(token.getCredentials() + "_-------------------------");
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        User user = userService.findByUsername(username);
//        BeanUtils.copyProperties(user,user);

        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        session.setAttribute("userInfo", user);
        if (user.getUserStatus() == 2 || user.getUserStatus() == 3) {
            return null;
        } else {
            System.out.println("----->>userInfo=" + user.getUsername());
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    user, //用户名
                    user.getPassword(), //密码
//                ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt
                    getName()  //realm name
            );
            if (authenticationInfo != null) {
//            redisService.setStr("username",username);
                redisService.setObj("user", user);
                User user_redis = new User();
                user_redis = (User) redisService.getObj("user");

            } else {
                System.out.println("erro **********************");
            }
            return authenticationInfo;
        }
    }

}