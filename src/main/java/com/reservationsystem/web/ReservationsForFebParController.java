package com.reservationsystem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;
@Controller
public class ReservationsForFebParController {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ReservationsForFebParController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/ReservationsForFebPar")
    public String showReservationsForFebParDetails(Model model) {
        String sqlStatement = "SELECT * FROM reservations_february";
        List<ReservationsForFebPar> ReservationsForFebParDetails = jdbcTemplate.query(sqlStatement, (resultSet, rowNum) -> {
            Integer id = resultSet.getInt("id");
            Date reservationday = resultSet.getDate("reservationday");
            Integer userid = resultSet.getInt("userid");


            return new ReservationsForFebPar(id, reservationday,userid);
        });

        model.addAttribute("febParDetails",ReservationsForFebParDetails);
        return "ReservationsForFebPar";
    }
}
