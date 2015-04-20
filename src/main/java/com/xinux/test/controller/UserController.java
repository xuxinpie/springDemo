package com.xinux.test.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xinux.test.model.Email;
import com.xinux.test.model.User;
import com.xinux.test.model.UserRegisterInfo;
import com.xinux.test.service.EmailService;
import com.xinux.test.service.UserService;
import com.xinux.test.user.exception.InvalidPasswordException;
import com.xinux.test.user.exception.UserNotFoundException;

/**
 * User 控制器
 * 
 * @author hanlin.xx
 * @version $Id: UserController.java, v 0.1 2015-4-9 下午3:10:17 hanlin.xx Exp $
 */

@Controller
@RequestMapping("/UserController")
public class UserController {

    @Resource(name = "userService")
    private UserService  userService;
    @Resource(name = "emailService")
    private EmailService emailService;

    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest request, Model model) {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "showUser";

    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    //参数为User对象，要求表单中的名字与User Bean的属性名相同，即可通过Bean来接收参数
    //设置HttpSession，将对象写入Session
    public ModelAndView loginUser(Model model, HttpServletRequest request, HttpSession httpSession) {
        //        String name = request.getParameter("userName");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        System.out.println("userName is: " + userName);
        System.out.println("password is: " + password);

        try {
            User userResult = userService.loginUser(userName, password);
            httpSession.setAttribute("user", userResult);
            model.addAttribute("userName", userName);
        } catch (UserNotFoundException e) {
            model.addAttribute("message1", "用户不存在");
            return new ModelAndView("login");
        } catch (InvalidPasswordException e) {
            model.addAttribute("message2", "密码错误");
            model.addAttribute("userName", userName);
            return new ModelAndView("login");
        }
        return new ModelAndView("loginSuccess");
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        System.out.println(user);
        httpSession.removeAttribute("user");
        //删除所有session
        //httpSession.invalidate();
        return "logoutSuccess";
    }

    @RequestMapping(value = "/homePage")
    public String requestHomePage(Model model, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        if (null == user) {
            model.addAttribute("message", "用户尚未登录");
            return "error";
        } else {
            model.addAttribute("user", user);
            return "homePage";
        }
    }

    @RequestMapping(value = "/delete")
    public ModelAndView deleteUser(HttpServletRequest request, Model model) {
        int userId = Integer.parseInt(request.getParameter("id"));
        boolean result = userService.deleteUserById(userId);
        if (result) {
            return new ModelAndView("redirect:list");
        } else {
            model.addAttribute("message", "删除用户失败!");
            return new ModelAndView("error");
        }

    }

    //也可以利用@RequestParam来实现参数绑定
    /*    @RequestMapping(value = "/delete")
        public ModelAndView deleteUser(#RequestParam("id") String id, Model model) {
            int userId = Integer.parseInt(id);
            boolean result = userService.deleteUserById(userId);
            if (result) {
                return new ModelAndView("redirect:list");
            } else {
                model.addAttribute("message", "删除用户失败!");
                return new ModelAndView("error");
            }
            
        }
    */
    @RequestMapping(value = "/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/add")
    public String add(UserRegisterInfo usertemp, Model model) {
        System.out.println(usertemp);
        User user = new User();
        user.setUserName(usertemp.getUserName());
        user.setPassword(usertemp.getPassword());
        user.setAge(usertemp.getAge());
        user.setEmail(usertemp.getEmail());
        if (userService.createUser(user)) {
            Email email = new Email();
            email.setFrom("xuxinpie@gmail.com");
            email.setTo(new String[] { user.getEmail() });
            email.setSubject("注册确认邮件");
            email.setText("Thanks for your resistration " + user.getUserName());
            emailService.send(email);
            return "passTest";
        } else {
            model.addAttribute("message", "插入新用户失败！");
            return "error";
        }
    }

    @RequestMapping(value = "/list")
    public ModelAndView list() {
        List<User> users = userService.getAllUsers();
        /*for (User user : users) {
            System.out.println(user.getUserName());
        }*/
        ModelAndView mav = new ModelAndView();
        mav.setViewName("listUsers");
        mav.addObject("userList", users);
        return mav;
    }

    @RequestMapping(value = "/update")
    public ModelAndView update(User user, Model model) {
        boolean result = userService.updateUserInfo(user);
        if (result) {
            /*
             * 用redirect来实现,这样viewResolver认为是重定向操作,
             * 不再渲染该视图,而是直接向客户端发出redirect响应
             * 
             * redirect../list表示返回上级目录下的list页面
             * 实现页面跳转附加参数return new ModelAndView("redirect:list?id="+id);
             */
            //return new ModelAndView("redirect:../list");
            return new ModelAndView("redirect:list");
        } else {
            model.addAttribute("message", "用户更新失败");
            return new ModelAndView("error");
        }

    }

    @RequestMapping(value = "/edit")
    public String edit(HttpServletRequest request, Model model) {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "update";
    }

}
