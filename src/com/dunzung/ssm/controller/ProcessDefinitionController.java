package com.dunzung.ssm.controller;

import com.dunzung.ssm.entity.UserEntity;
import com.dunzung.ssm.service.UserService;
import org.activiti.engine.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Wooola on 2019/5/22.
 */
@Controller
@RequestMapping("/procdef")
public class ProcessDefinitionController {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private UserService userService;

    @RequestMapping
    public void hello(HttpServletResponse response) throws IOException {
        UserEntity user = userService.getUserById("1001");
        response.getWriter().write("hello world..." + user.toString());
    }

}
