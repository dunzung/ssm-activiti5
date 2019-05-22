package com.dunzung.ssm.controller;

import org.activiti.engine.HistoryService;
import org.activiti.engine.history.HistoricDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Wooola on 2019/5/22.
 */
@Controller
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @RequestMapping
    public void hist(HttpServletResponse response) throws IOException {
        List<HistoricDetail> list = historyService.createHistoricDetailQuery().list();
        response.getWriter().write("hist::size::" + list.size());
    }

}
