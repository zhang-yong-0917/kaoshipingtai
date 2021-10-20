package kaoshipingtai.controller;

import kaoshipingtai.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import kaoshipingtai.serviceimpl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/")
    public String index() {
        return "index.html";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "/login.html";
    }

    @RequestMapping(value = "loginn")
    @ResponseBody
    public String login(String username, String password) {
        System.out.println(username);

        User user = userService.findByNameAndPassword(username, password);

        if (user.getUserid() == 0 || user.getPassword() == null) {
            return "error";
        } else {
            return "success";
        }

    }

    @RequestMapping(value = "/registry")
    public ModelAndView register() {
        return new ModelAndView("/page/registry.html");
    }

    @PostMapping(value = "/registrys")
    @ResponseBody
    public String register(String username, String password, String id) {
        System.out.println("duan dian 1");
        User user = userService.findByName(username);
        System.out.println(user.getUsername());
        if (user.getUsername() == null) {
//            personService.register(id);
            userService.insertUser(username, password);
            return "Y";
        }
        return "N";
    }
}
