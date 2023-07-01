package com.reservationsystem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class MakeParkingReservationController {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MakeParkingReservationController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/MakeParkingReservation")
    public String showMakeParkingReservationForm() {

        return "MakeParkingReservation";
    }

    @PostMapping("/MakeParkingReservation")
    public String makeParkingReservation(
            @RequestParam("parkingReservationDate") @DateTimeFormat(pattern = "yyyy-mm-dd") Date parkingReservationDate,
            @RequestParam("parkingReservationUsername") String parkingReservationUsername,
            @RequestParam("parkingReservationParkingSpot") Integer parkingReservationParkingSpot
    ) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("CALL CreateParkingReservation('%s', '%s','%d');",
                parkingReservationDate.toString(),
                parkingReservationUsername,
                parkingReservationParkingSpot
        ));

        String sqlStatement = sb.toString();

        jdbcTemplate.execute(sqlStatement);

        return "redirect:/home";
    }
}
