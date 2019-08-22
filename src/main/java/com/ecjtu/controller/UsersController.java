package com.ecjtu.controller;

import com.ecjtu.entity.Users;
import com.ecjtu.service.UsersService;
import com.ecjtu.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Mr Wu
 * @create: 2019-08-22 10:21
 */
@Controller
@RequestMapping("users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("users.action")
    public String getUsers(ModelAndView modelAndView){
        List<Users> users = usersService.getUsers();
        modelAndView.addObject("users",users);
        return "admin/admin";
    }

    @RequestMapping("create.action")
    @ResponseBody
    public Message create(Users users){
        if(usersService.addUser(users)>0){
            return Message.success();
        }else{
            return Message.fail();
        }
    }

    @RequestMapping("delete.action")
    @ResponseBody
    public Message deleteUsers(Integer id){
        if(usersService.deleteUser(id)>0){
            return Message.fail();
        }else{
            return Message.fail();
        }
    }

    @RequestMapping("update.action")
    @ResponseBody
    public Message updateUser(Users users){
        if(usersService.updateUser(users)>0){
            return Message.success();
        }else{
            return Message.fail();
        }
    }

    @RequestMapping("findById")
    @ResponseBody
    public Users findById(Integer id){
        Users user = usersService.findById(id);
        if(user!=null){
            return user;
        }else{
            return null;
        }
    }


    @RequestMapping("findByName.acation")
    @ResponseBody
    public Users findByName(String userName){
        Users byName = usersService.findByName(userName);
        if(byName!=null){
            return byName;
        }else{
            return null;
        }
    }


    @RequestMapping("login.action")
    @ResponseBody
    public String login(Users users,ModelAndView modelAndView){
        Users users1 = usersService.loginUser(users);
        if(users1!=null){
            return "users/getUsers.action";
        }else {
            modelAndView.addObject("msg","账号和密码有误，请重新登录！");
            return "index";
        }
    }


}