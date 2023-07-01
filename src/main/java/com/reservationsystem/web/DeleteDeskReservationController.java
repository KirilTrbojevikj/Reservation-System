package com.reservationsystem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class DeleteDeskReservationController {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DeleteDeskReservationController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/DeleteDeskReservation")
    public String showDeleteDeskReservationForm() {
        return "DeleteDeskReservation";
    }

    @PostMapping("/DeleteDeskReservation")
    public String DeleteDeskReservation(
            @RequestParam("DeskID") Integer DeskID

    ) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("CALL  DeleteDeskReservation( %d);", DeskID));

        String sqlStatement = sb.toString();

        try {
            jdbcTemplate.execute(sqlStatement);
        } catch (Exception e) {
            // Handle exceptions
        }

        return "redirect:/home";
    }
}
