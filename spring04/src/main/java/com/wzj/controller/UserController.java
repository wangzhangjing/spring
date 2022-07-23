package com.wzj.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wzj.domain.User;
import com.wzj.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    //http://localhost:8080/spring04_war_exploded/user/quick

//    @RequestMapping(//指定请求url
//    value="/quick",
// 指定请求方式
// method = RequestMethod.GET,
// 请求参数必须有username
//    params = {"username"})
//    表示请求参数中age不能是100
//    params = {"age！100"}//
    @RequestMapping(value = "/quick",params = {"username"})//请求映射
    public String nb(){
        System.out.println("牛逼，正在运行");
        return "success";
    }
    @RequestMapping(value = "/quick2")//请求映射
    public ModelAndView nb2(){
        System.out.println("牛逼，正在运行");
       ModelAndView modelAndView = new ModelAndView();//Model模型，用来封装数据  View视图展示数据
        //设置视图名称
        modelAndView.addObject("username","wzj");
        modelAndView.setViewName("success");
        return modelAndView;
    }
    @RequestMapping(value = "/quick3")//请求映射
    public ModelAndView nb3(ModelAndView modelAndView){
        modelAndView.addObject("username","欢迎爸爸");
        modelAndView.setViewName("success");
        return modelAndView;
    }
    @RequestMapping(value = "/quick4")//请求映射
    public String nb4(Model model){
       model.addAttribute("username","dfjj");
        return "success";
    }
    @RequestMapping(value = "/quick5")//请求映射
    public String nb5(HttpServletRequest request){
        request.setAttribute("username","斯柯达");
        return "success";
    }
    @RequestMapping(value = "/quick6")//请求映射
    public void nb6(HttpServletResponse response) throws IOException {
        response.getWriter().println("hello wzj");

    }
    @RequestMapping(value = "/quick7")//请求映射
    @ResponseBody//
    //重点
    // 告诉springMVC不进行视图跳转 直接进行数据响应
    public String nb7() throws IOException {
      return "hello wzj";

    }
    @RequestMapping(value = "/quick8")//请求映射
    @ResponseBody//
    //重点
    // 告诉springMVC不进行视图跳转 直接进行数据响应
    public String nb8() throws IOException {
        return "{\"username\":\"zhuangsan\",\"age\":18}";

    }
    @RequestMapping(value = "/quick9")//请求映射
    @ResponseBody//
    //重点
    // 告诉springMVC不进行视图跳转 直接进行数据响应
    public String nb9() throws IOException {
        User user =new User();
        user.setUsername("lisi");
        user.setAge(23);
        //使用json转换工具将对象转换成json字符串格式返回
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(user);


        return s;

    }
    @RequestMapping(value = "/quick10")//请求映射
    @ResponseBody//
    //重点
    // 告诉springMVC不进行视图跳转 直接进行数据响应
    public User nb10() throws IOException {
        User user =new User();
        user.setUsername("lisi21");
        user.setAge(231);
        return user;

    }
    @RequestMapping(value = "/quick11")//请求映射
    @ResponseBody
    public void nb11(String username , int age) throws IOException {
       System.out.println(username);
       System.out.println(age);

    }
    @RequestMapping(value = "/quick12")//请求映射
    @ResponseBody
    public void nb12(User user) throws IOException {
        System.out.println(user);


    }
    @RequestMapping(value = "/quick13")//请求映射
    @ResponseBody
    public void nb13(String[] strs) throws IOException {
        System.out.println(Arrays.toString(strs));


    }
    @RequestMapping(value = "/quick14")//请求映射
    @ResponseBody
    public void nb14(VO vo) throws IOException {
        System.out.println(vo);


    }
    @RequestMapping(value = "/quick15")//请求映射
    @ResponseBody
    public void nb15(@RequestBody List<User> userList) throws IOException {
        System.out.println(userList);


    }
    @RequestMapping(value = "/quick16")//请求映射
    @ResponseBody
    public void nb16(@RequestParam(value = "name",required = false ,defaultValue = "meimou") String username) throws IOException {
        System.out.println(username);


    }
    @RequestMapping(value = "/quick17/{username}")//请求映射
    @ResponseBody
    public void nb17(@PathVariable(value = "username") String username) throws IOException {
        System.out.println(username);


    }
    @RequestMapping(value = "/quick18")
    @ResponseBody
    public void nb18(Date date) throws IOException {
        System.out.println(date);


    }
    @RequestMapping(value = "/quick19")
    @ResponseBody
    public void nb19(HttpServletRequest request, HttpServletResponse response , HttpSession session) throws IOException {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);

    }
    @RequestMapping(value = "/quick20")
    @ResponseBody
    public void nb20(@RequestHeader(value = "User-Agent",required = false) String user_agent) throws IOException {
        System.out.println(user_agent);

    }
    @RequestMapping(value = "/quick21")
    @ResponseBody
    public void nb21(@CookieValue(value = "JSESSIONID") String jsessionId) throws IOException {
        System.out.println(jsessionId);

    }
    @RequestMapping(value="/quick22")
    @ResponseBody
    public void nb22(String username, MultipartFile uploadFile ,MultipartFile uploadFile2) throws IOException {
        System.out.println(username);
        //获得上传文件的名称
        String originalFilename = uploadFile.getOriginalFilename();
        uploadFile.transferTo(new File("D:\\Download\\"+originalFilename));
        String originalFilename2 = uploadFile2.getOriginalFilename();
        uploadFile2.transferTo(new File("D:\\Download\\"+originalFilename2));
    }
    @RequestMapping(value="/quick23")
    @ResponseBody
    public void nb23(String username, MultipartFile[] uploadFile ) throws IOException {
        System.out.println(username);
        //获得上传文件的名称
        for (MultipartFile multipartFile :uploadFile){
            String originalFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("D:\\Download\\"+originalFilename));
        }


    }
}
