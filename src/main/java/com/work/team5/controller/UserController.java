package com.work.team5.controller;

import com.work.team5.dto.UserDto;
import com.work.team5.model.User;
import com.work.team5.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * UserController 클래스
 * - 사용자 관련 요청을 처리하는 컨트롤러
 */
@Controller
@RequestMapping("/users")
public class UserController {

    /**
     * UserService 인스턴스를 자동으로 주입받음
     */
    @Autowired
    private UserService userService;

    /**
     * 홈 페이지를 보여주는 메소드
     * - 인증된 사용자 정보를 이용하여 환영 메시지를 표시
     *
     * @param model       모델 객체
     * @param userDetails 인증된 사용자 정보
     * @return            홈 페이지 뷰 이름
     */
    @GetMapping("/home")
    public String showHome(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails != null) {
            User user = userService.getUserByUserid(userDetails.getUsername());
            if (user != null) {
                model.addAttribute("name", user.getName());
                return "home";
            }
        }
        return "redirect:/users/login";
    }

    /**
     * 회원가입 폼을 보여주는 메소드
     *
     * @param model 모델 객체
     * @return      회원가입 페이지 뷰 이름
     */
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "userAccount/register";
    }

    /**
     * 로그인 폼을 보여주는 메소드
     *
     * @param model 모델 객체
     * @return      로그인 페이지 뷰 이름
     */
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "userAccount/login";
    }

    /**
     * 사용자 등록을 처리하는 메소드
     *
     * @param userDto 사용자 데이터 전송 객체
     * @param model   모델 객체
     * @return        로그인 페이지 뷰 이름
     */
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") UserDto userDto, Model model) {
        User registeredUser = userService.registerUser(userDto);
        if (registeredUser != null) {
            model.addAttribute("registeredUserName", registeredUser.getName());
            model.addAttribute("registrationSuccess", true);
        } else {
            model.addAttribute("registrationFailure", true);
        }
        return "userAccount/login";
    }

    /**
     * 사용자 로그인을 처리하는 메소드
     *
     * @param userDto      사용자 데이터 전송 객체
     * @param model        모델 객체
     * @param userDetails  인증된 사용자 정보
     * @return             홈 페이지로 리다이렉트 또는 로그인 페이지 뷰 이름
     */
    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") UserDto userDto, Model model, @AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails != null) {
            User user = userService.getUserByUserid(userDetails.getUsername());
            if (user != null) {
                model.addAttribute("name", user.getName());
                return "redirect:/users/home";
            }
        }
        model.addAttribute("loginFailure", true);
        return "userAccount/login";
    }
}
