package com.mit.controller;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mit.bean.Car;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRMapArrayDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;
import com.mit.service.ICarService;
import org.springframework.web.servlet.view.jasperreports.JasperReportsXlsView;

import javax.sql.DataSource;

@ResponseBody
@Controller
public class MyController {

    @Autowired
    private ApplicationContext appContext;

    @Autowired
    private ICarService carService;

    @Autowired
    private DataSource dbsoruce;

    @RequestMapping(path = "/pdf", method = RequestMethod.GET)
    public ModelAndView report() {

        JasperReportsPdfView view = new JasperReportsPdfView();
        view.setUrl("classpath:report2.jrxml");
        view.setApplicationContext(appContext);

        Map<String, Object> params = new HashMap<>();
        params.put("datasource", dbsoruce);
        params.put("whereParam", "SELECT cars.`ID` AS cars_ID,\n" +
                "\tcars.`Name` AS cars_Name,\n" +
                "\tcars.`PRICE` AS cars_PRICE\n" +
                "FROM cars WHERE cars.`PRICE` > 10000 ");

        return new ModelAndView(view, params);

        //return new ModelAndView(view);
    }

    @RequestMapping( value = "/excel", method = RequestMethod.GET )
    public ModelAndView reportXLS() throws IOException {

        JasperReportsXlsView view = new JasperReportsXlsView();
        view.setUrl("classpath:report2.jrxml");
        view.setApplicationContext(appContext);

        Map<String, Object> params = new HashMap<>();
        params.put("datasource", dbsoruce);
        params.put("whereParam", "SELECT cars.`ID` AS cars_ID,\n" +
                "\tcars.`Name` AS cars_Name,\n" +
                "\tcars.`PRICE` AS cars_PRICE\n" +
                "FROM cars WHERE cars.`PRICE` > 10000 ");
        return new ModelAndView(view, params);


    }
}
