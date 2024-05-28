//package edu.poly.hello.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class SecurityController {
//	@RequestMapping("/securiry/login/form")
//	public String loginForm(Model model) {
//		model.addAttribute("message", "vui lòng đăng nhập");
//		return "/security/login";
//	}
//	@RequestMapping("/securiry/success")
//	public String loginSuccess(Model model) {
//		model.addAttribute("message", "Đăng nhập thành công");
//		return "/security/login";
//	}
//	@RequestMapping("/securiry/login/error")
//	public String loginErorr(Model model) {
//		model.addAttribute("message", "Sai thông tin đăng nhập");
//		return "/security/login";
//	}
//	@RequestMapping("/securiry/unauthoried")
//	public String unauthoried(Model model) {
//		model.addAttribute("message", "Không có quyền truy cập");
//		return "/security/login";
//	}
//}
