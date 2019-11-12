package com.song.demo.controller;

import com.song.demo.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class ExcelController {
    @Autowired
    private ExcelService excelService;

    @RequestMapping("/excel")
    @ResponseBody
    public String getListGrade() throws IOException, IllegalAccessException {
        String excel = excelService.excel();
        return excel;
    }
}
