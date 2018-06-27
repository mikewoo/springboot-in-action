package com.mikewoo.study.web;

import com.mikewoo.study.domain.User;
import com.mikewoo.study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户控制器
 *
 * @auther Phantom Gui
 * @date 2018/6/25 19:26
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 获取用户列表
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView findUsers(Model model) {
        model.addAttribute("userList", userRepository.findUsers());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * 根据用户ID查询用户信息
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/{id}")
    public ModelAndView findById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userRepository.findById(id));
        model.addAttribute("title", "用户详情");
        return new ModelAndView("users/view", "userModel", model);
    }

    /**
     * 获取创建用户表单信息
     * @param model
     * @return
     */
    @GetMapping("/form")
    public ModelAndView userForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model);
    }

    /**
     * 创建或更新用户信息
     * @param user
     * @param model
     * @return
     */
    @PostMapping
    public ModelAndView saveUser(User user, Model model) {
        user = userRepository.save(user);
        model.addAttribute("userList", userRepository.findUsers());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * 根据ID删除用户
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public ModelAndView deleteById(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
        return new ModelAndView("redirect:/users");
    }

    /**
     * 获取修改用户的界面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/modify/{id}")
    public ModelAndView modifyUser(@PathVariable("id") Long id, Model model) {
        User user = userRepository.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form", "userModel", model);
    }
}
