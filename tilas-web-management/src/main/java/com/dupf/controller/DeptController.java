package com.dupf.controller;

import com.dupf.pojo.Dept;
import com.dupf.pojo.Result;
import com.dupf.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    // @RequestMapping(value = "/depts",method = RequestMethod.GET)

    // 查询部门
    @GetMapping("/depts")
    public Result list() {
        System.out.println("查询全部部门");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    // 删除部门
    /*
        获取请求参数
        方式一：基于HttpServletRequest请求实现
     */
//    @DeleteMapping("/depts")
//    public Result delete(HttpServletRequest request) {
//        String idStr = request.getParameter("id");
//        int id = Integer.parseInt(idStr);
//        System.out.println("根据ID删除部门:" + id);
//        return Result.success();
//    }


    // 方式二：@RequestParam
//    // 注意事项：一旦声明了RequestParam，该参数在请求时必须传递，如果不传递会报错，因为默认 required 为 true
//    @DeleteMapping("/depts")
//    public Result delete(@RequestParam(value = "id", required = false) Integer deptId) {
//        System.out.println("根据ID删除部门:" + deptId);
//        return Result.success();
//    }

    // 方式三：省略@RequestParam(前端传递的请求参数名与服务端方法形参名一致时)
    @DeleteMapping("/depts")
    public Result delete(Integer id) {
        System.out.println("根据ID删除部门:" + id);
        deptService.deleteById(id);
        return Result.success();
    }


}
