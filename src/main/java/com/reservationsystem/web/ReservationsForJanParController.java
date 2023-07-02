package com.reservationsystem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Controller
public class ReservationsForJanParController {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ReservationsForJanParController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/ReservationsForJan")
    public String showReservationsForJanDetails(Model model) {
        String sqlStatement = "SELECT * FROM reservations_january";
        List<ReservationsForJanPar> ReservationsForJanDetails = jdbcTemplate.query(sqlStatement, (resultSet, rowNum) -> {
            Integer id = resultSet.getInt("id");
            Date reservationday = resultSet.getDate("reservationday");
            Integer userid = resultSet.getInt("userid");


            return new ReservationsForJanPar(id, reservationday,userid);
        });

        model.addAttribute("janParDetails", ReservationsForJanDetails);
        return "ReservationsForJan";
    }
}
