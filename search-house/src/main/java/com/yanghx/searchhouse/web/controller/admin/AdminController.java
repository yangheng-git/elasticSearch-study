package com.yanghx.searchhouse.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author yangHX
 * createTime  2019/5/22 18:18
 */
@Controller
public class AdminController {

    /**
     * 后台管理中心
     *
     */
    @GetMapping("/admin/center")
    public String adminCenterPage() {
        return "admin/center";
    }

    /**
     * 欢迎页
     *
     */
    @GetMapping("/admin/welcome")
    public String welcomePage() {
        return "admin/welcome";
    }

    /**
     * 管理员登录页
     *
     */
    @GetMapping("/admin/login")
    public String adminLoginPage() {
        return "admin/login";
    }

    /**
     * 房源列表页
     *
     */
    @GetMapping("admin/house/list")
    public String houseListPage() {
        return "admin/house-list";
    }


}
