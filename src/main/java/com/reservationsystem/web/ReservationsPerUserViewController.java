package com.reservationsystem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReservationsPerUserViewController {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ReservationsPerUserViewController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/ReservationsPerUser")
    public String showReservationsPerUser(Model model) {
        String sqlStatement = "SELECT * FROM reservations_per_user";
        List<ReservationsPerUserView> reservationsPerUser = jdbcTemplate.query(sqlStatement, (resultSet, rowNum) -> {
            String firstname = resultSet.getString("firstname");
            String lastname = resultSet.getString("lastname");
            Integer userid = resultSet.getInt("userid");
            Integer total_reservations = resultSet.getInt("total_reservations");

            return new ReservationsPerUserView(firstname, lastname, userid, total_reservations);
        });

        model.addAttribute("reservationsPerUser", reservationsPerUser);
        return "ReservationsPerUser";
    }
}
