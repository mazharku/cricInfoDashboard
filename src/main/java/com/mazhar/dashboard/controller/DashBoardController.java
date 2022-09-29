package com.mazhar.dashboard.controller;

import com.mazhar.dashboard.model.CricInfoDataModel;
import com.mazhar.dashboard.services.DataFetchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashBoardController {
    private final DataFetchService service;

    public DashBoardController(DataFetchService service) {
        this.service = service;
    }

    @GetMapping({ "/"})
    public ModelAndView getAllEmployees() {
        ModelAndView mav = new ModelAndView("home");
        CricInfoDataModel attributeValue = service.fetchData();
        mav.addObject("data", attributeValue.getItems());
        return mav;
    }
}
