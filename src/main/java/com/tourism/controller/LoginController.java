package com.tourism.controller;


import org.springframework.stereotype.Controller;

@Controller
public class LoginController {
    /*
    @Autowired
    UserService userService;
     */

    /**
     *
     * @param model 用来填充视图数据
     * @param username 用户名
     * @param password 密码
     * @param phone 注册的手机号码
     * @return 返回一个 html 页面
     */

    /*
    @RequestMapping(path = "/reg", method = RequestMethod.POST)
    public String register(Model model, @RequestParam("username") String username,
                           @RequestParam("password")String password, @RequestParam("phone")String phone){
        Map<String, Object> map = userService.register(username, password, phone);
        if (map.containsKey("msg")) {
            model.addAttribute("msg", map.get("msg"));
            System.out.println("出错了");
            return "/register";
        }
      User user = userService.getUserByName(username);
        System.out.println(user + "   " + user.getName());
        model.addAttribute("user", user);
        //注册成功跳转到个人中心
        return "home";
    }

    public String login(Model model, @RequestParam("username") String username,
                        @RequestParam("password") String password) {
        Map<String, Object> map = userService.login(username, password);
        if (map.containsKey("msg")) {
            model.addAttribute("msg", map.get("msg"));
            return "/checklogin";
        }
        model.addAttribute("user", map.get("user"));
        //登陆成功跳转到个人中心
        return "home";
    }*/
}
