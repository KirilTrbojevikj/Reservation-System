package com.reservationsystem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class AvailableDesksCurrDateViewController {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AvailableDesksCurrDateViewController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/AvailableDeskCurrentDate")
    public String showAvailableDesks(Model model) {
        String sqlStatement = "SELECT * FROM available_desks_for_current_date";
        List<AvailableDesksCurrDateView> availableDesks = jdbcTemplate.query(sqlStatement, (resultSet, rowNum) -> {
            Integer id = resultSet.getInt("id");
            String floorMap = resultSet.getString("floormap");
            String department = resultSet.getString("department");
            String address = resultSet.getString("address");
            String city = resultSet.getString("city");
            Date date = resultSet.getDate("date");

            return new AvailableDesksCurrDateView(id, floorMap, department, address, city, date);
        });

        model.addAttribute("availableDesks", availableDesks);
        return "AvailableDeskCurrentDate";
    }
}
