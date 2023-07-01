package com.reservationsystem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class MakeDeskReservationController {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MakeDeskReservationController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/MakeDeskReservation")
    public String showMakeDeskReservationForm() {
        return "MakeDeskReservation";
    }

    @PostMapping("/MakeDeskReservation")
    public String makeDeskReservation(
            @RequestParam("deskReservationDate") @DateTimeFormat(pattern = "yyyy-mm-dd") Date deskReservationDate,
            @RequestParam("deskReservationUsername") String deskReservationUsername,
            @RequestParam("deskReservationDeskNumber") Integer deskReservationDeskNumber
    ) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("CALL CreateDeskReservation('%s', '%s','%d');",
                deskReservationDate.toString(),
                deskReservationUsername,
                deskReservationDeskNumber
        ));

        String sqlStatement = sb.toString();

        jdbcTemplate.execute(sqlStatement);

        return "redirect:/home";
    }
}

