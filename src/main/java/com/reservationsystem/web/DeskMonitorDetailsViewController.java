package com.reservationsystem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Controller
public class DeskMonitorDetailsViewController {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DeskMonitorDetailsViewController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/DeskMonitorDetails")
    public String showADeskMonitorDetails(Model model) {
        String sqlStatement = "SELECT * FROM desk_monitor_details";
        List<DeskMonitorDetailsView> deskMonitor = jdbcTemplate.query(sqlStatement, (resultSet, rowNum) -> {
            Integer desk_id = resultSet.getInt("desk_id");
            Integer monitor_id = resultSet.getInt("monitor_id");
            String manufacturer = resultSet.getString("manufacturer");
            String model1 = resultSet.getString("model");
            Integer size = resultSet.getInt("size");
            Boolean heightadjustable = resultSet.getBoolean("heightadjustable");

            return new DeskMonitorDetailsView(desk_id,monitor_id, manufacturer, model1, size, heightadjustable);
        });

        model.addAttribute("deskMonitor",deskMonitor );
        return "DeskMonitorDetails";
    }

}
