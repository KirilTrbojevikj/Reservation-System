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
public class CreateUserController {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CreateUserController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/CreateUser")
    public String showCreateUserForm() {
        return "CreateUser";
    }

    @PostMapping("/CreateUser")
    public String createUser(
            @RequestParam("userFirstName") String userFirstName,
            @RequestParam("userLastName") String userLastName,
            @RequestParam("userUsername") String userUsername,
            @RequestParam("userPassword") String userPassword,
            @RequestParam("userEmail") String userEmail,
            @RequestParam("userRole") Integer userRole

            ) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("SELECT insert_user('%s', '%s', '%s','%s','%s','%d');",
                userFirstName,
                userLastName,
                userUsername,
                userPassword,
                userEmail,
                userRole
        ));

        String sqlStatement = sb.toString();

        jdbcTemplate.execute(sqlStatement);

        return "redirect:/home";
    }
}
