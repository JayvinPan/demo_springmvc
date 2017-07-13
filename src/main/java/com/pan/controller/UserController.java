package com.pan.controller;

import com.pan.exception.UserException;
import com.pan.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pan on 2017/7/13.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private Map<String,User> Userlist = new HashMap<String,User>();
    public UserController() {
        Userlist.put("asdf", new User("asdf", "asdf", "asdf", "adsf"));
        Userlist.put("qwer", new User("qwer", "qwer", "qwer", "qwer"));
        Userlist.put("zxcv", new User("zxcv", "zxcv", "zxcv", "zxcv"));
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("users",Userlist);
        return "/user/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new User());
        return "/user/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Validated User newuser, BindingResult br) throws IOException {//紧跟
        if(br.hasErrors()) {
            return "/user/add";
        }
        //String realpath = req.getSession().getServletContext().getRealPath("/resources/upload");
        //System.out.println(realpath);
        //for (MultipartFile attach : attachs) {
        //    if (attach.isEmpty()) {
        //        continue;
        //    }
        //    File f = new File(realpath + "/" + attach.getOriginalFilename());
        //    FileUtils.copyInputStreamToFile(attach.getInputStream(), f);
        //}
        //System.out.println(attach.getName() + "," + attach.getOriginalFilename() + "," + attach.getContentType()) ;
        Userlist.put(newuser.getUsername(),newuser);
        return "redirect:/user/users";
    }
    @RequestMapping(value = "/{username}",method = RequestMethod.GET)
    public String show(@PathVariable String username, Model model) {
        model.addAttribute(Userlist.get(username));
        return "/user/show";
    }

    //返回json格式
    @RequestMapping(value = "/{username}",method = RequestMethod.GET, params = "json")
    @ResponseBody
    public User show(@PathVariable String username) {
        return Userlist.get(username);
    }
    /*
     *局部异常处理，仅仅处理本控制器中的异常
     */
    //@ExceptionHandler(value = {UserException.class})
    //public String handleException(UserException userex, HttpServletRequest req) {
    //    req.setAttribute("userex", userex);
    //    return "error";
    //}

    @RequestMapping(value = "/{username}/update", method = RequestMethod.GET)
    public String update(@PathVariable String username,Model model) {
        model.addAttribute(Userlist.get(username));
        return "/user/update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@Validated User user, BindingResult br) {
        if (br.hasErrors()) {
            return "/user/update";
        } else {
            Userlist.put(user.getUsername(),user);
            return  "redirect:/user/users";
        }
    }

    @RequestMapping(value = "/{username}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable String username) {
        Userlist.remove(username);
        return "redirect:/user/users";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password, HttpSession session) {

        if (!Userlist.containsKey(username)) {
            throw new UserException("用户名不存在！");
        }
        User u = Userlist.get(username);
        if (!u.getPassword().equals(password)) {
            throw new UserException("用户密码不正确！");
        }
        session.setAttribute("loginUser", u);
        return "redirect:/user/users";
    }
}
