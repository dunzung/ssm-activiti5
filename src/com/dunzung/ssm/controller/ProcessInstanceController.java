package com.dunzung.ssm.controller;

import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Wooola on 2019/5/22.
 */
@Controller
@RequestMapping("/procinst")
public class ProcessInstanceController {

    @Autowired
    private RuntimeService runtimeService;

    @RequestMapping("/startup/{definitionKey}")
    public void startup(@PathVariable("definitionKey") String definitionKey, HttpServletResponse response) throws IOException {
        runtimeService.startProcessInstanceByKey(definitionKey);
        response.getWriter().write(definitionKey + "::OK");
    }

}
