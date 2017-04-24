package com.trump.controller;

import com.trump.config.Constant;
import com.trump.domain.ParamMode;
import com.trump.domain.User;
import com.trump.service.impl.UserServiceImpl;
import com.trump.util.FileUtil;
import com.trump.util.StringUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    private UserServiceImpl mUserService; //自动载入Service对象

    @RequestMapping(value = "findUser", method = RequestMethod.GET,
            produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public String getUserById(HttpServletRequest request) throws Exception {
        Map<String, Object> resultMap = new HashMap();
        String resultStr = "";


        String uid = getParameter(request, "uid");

        if (StringUtil.isEmpty(uid)) {
            resultStr = "uid不能为空";
        } else {
            User user = mUserService.findOneById(uid);
            if (null != user) {
//                查到了
                resultStr = user.toString();
            } else {
                resultStr = "用户不存在";
            }
        }

        return resultStr;
    }

    /**
     * 直接返回json
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "login",
            produces = {"application/json; charset=utf-8"})
    @ResponseBody
    public String login(HttpServletRequest request, ParamMode paramMode, HttpSession session) throws Exception {

        if (StringUtil.isEmpty(paramMode.getName()))
            return getNullParamReturn("用户名不能为空");

        if (StringUtil.isEmpty(paramMode.getPass()))
            return getNullParamReturn("密码不能为空");

        User user = mUserService.findUserByName(paramMode.getName());

        if (null == user)
            return getCommonReturn(Constant.Response.USER_NOT_EXIST, "用户不存在");

        if (!paramMode.getPass().equals(user.getPassword())) {
            return getCommonReturn(Constant.Response.WRONG_PASS, "密码错误");
        } else {
            session.setAttribute("uid", user.getId());
            session.setAttribute("uname", user.getUsername());
            return getCommonReturn(Constant.Response.OK, "登录成功", user);
        }
    }

    @RequestMapping(value = "/uploadPic", method = RequestMethod.POST,
            produces = "application/json; charset=utf-8")
    @ResponseBody
    public String uploadPic(@RequestParam MultipartFile file, HttpSession session) {
        //在这里面文件存储的方案一般是：
        // 收到文件→获取文件名→在本地存储目录建立防重名文件→写入文件→返回成功信息
        //如果上面的步骤中在结束前任意一步失败，那就直接失败了。

        if (file == null || file.getOriginalFilename().equals(""))
            return getNullParamReturn("文件不能为空");

        String realPath = session.getServletContext().getRealPath("/images");
        FileUtil.createIfNotExist(new File(realPath));

        //生成一个uuid 的文件名
        UUID randomUUID = UUID.randomUUID();
        //获取文件的后缀名
        String fileName = file.getOriginalFilename();
        int i = fileName.lastIndexOf(".");
        String uuidName = randomUUID.toString() + fileName.substring(i);
        String path = realPath + "/" + uuidName;
        try {
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(realPath, uuidName));
            return getCommonReturn(Constant.Response.OK, path);
        } catch (Exception e) {
            logger.error("/uploadPic接口出错 -->", e.getMessage());
            return getCommonReturn(Constant.Response.UNKNOWN_ERROR, "接口出错cause=" + e.getMessage());
        }
    }

    @RequestMapping(value = "addUser",
            produces = {"application/json; charset=utf-8"})
    public ModelAndView addUser(HttpServletRequest req, User user) {
        ModelAndView mav = new ModelAndView("form");  //创建一个jsp页面对象

        if (user == null)
            return mav.addObject("message", "用户信息不能为空");
        if (StringUtil.isEmpty(user.getUsername()))
            return mav.addObject("message", "用户名不能为空");
        if (StringUtil.isEmpty(user.getPassword()))
            return mav.addObject("message", "用户密码不能为空");
        if (StringUtil.isEmpty(String.valueOf(user.getSex())))
            return mav.addObject("message", "用户名性别不能为空");
        if (StringUtil.isEmpty(user.getDescription()))
            return mav.addObject("message", "描述不能为空");

        try {
            mUserService.add(user);
        } catch (Exception e) {
            e.printStackTrace();
            return mav.addObject("message", "异常");
        }
        mav.setViewName("home");
        mav.addObject("code", Constant.Response.OK);
        mav.addObject("message", "恭喜,注册成功");
        return mav;
    }

    @RequestMapping(value = "findAll", produces = {"application/json;charset=utf-8"})
//    @ResponseBody
    public ModelAndView findAll(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("home");
        try {
            List<User> list_user = mUserService.findAll();
            request.getSession().setAttribute("list_user", list_user);
            mav.addObject("list_user", list_user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }


}
