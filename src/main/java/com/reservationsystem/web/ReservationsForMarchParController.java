package com.reservationsystem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Controller
public class ReservationsForMarchParController {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ReservationsForMarchParController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/ReservationsForMarchPar")
    public String showReservationsForFebParDetails(Model model) {
        String sqlStatement = "SELECT * FROM reservations_march";
        List<ReservationsForMarchPar> ReservationsForMarchParDetails = jdbcTemplate.query(sqlStatement, (resultSet, rowNum) -> {
            Integer id = resultSet.getInt("id");
            Date reservationday = resultSet.getDate("reservationday");
            Integer userid = resultSet.getInt("userid");


            return new ReservationsForMarchPar(id, reservationday,userid);
        });

        model.addAttribute("marchParDetails",ReservationsForMarchParDetails);
        return "ReservationsForMarchPar";
    }
}
