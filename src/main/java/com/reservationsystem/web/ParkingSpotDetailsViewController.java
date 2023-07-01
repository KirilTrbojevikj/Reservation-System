package com.reservationsystem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class ParkingSpotDetailsViewController {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ParkingSpotDetailsViewController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/ParkingSpotDetails")
    public String showParkingSpotDetails(Model model) {
        String sqlStatement = "SELECT * FROM parking_spot_details";
        List<ParkingSpotDetailsView> parkingSpotDetails = jdbcTemplate.query(sqlStatement, (resultSet, rowNum) -> {
            Integer parking_spot_id = resultSet.getInt("parking_spot_id");
            Integer width = resultSet.getInt("width");
            Integer length = resultSet.getInt("length");
            Integer parking_level_id = resultSet.getInt("parking_level_id");
            Integer parking_level = resultSet.getInt("parking_level");
            Integer building_id = resultSet.getInt("building_id");
            String building_address = resultSet.getString("building_address");

            return new ParkingSpotDetailsView(parking_spot_id, width, length, parking_level_id, parking_level, building_id, building_address);
        });

        model.addAttribute("parkingSpotDetails", parkingSpotDetails);
        return "ParkingSpotDetails";
    }
}
