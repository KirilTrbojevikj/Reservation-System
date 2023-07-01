package com.reservationsystem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteMeetingRoomReservation {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DeleteMeetingRoomReservation(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/DeleteMeetingRoomReservation")
    public String showDeleteMeetingRoomReservationForm() {
        return "DeleteMeetingRoomReservation";
    }

    @PostMapping("/DeleteMeetingRoomReservation")
    public String DeleteDeskReservation(
            @RequestParam("MeetingID") Integer MeetingID

    ) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("CALL  DeleteMeetingRoomReservation( %d);", MeetingID));

        String sqlStatement = sb.toString();

        try {
            jdbcTemplate.execute(sqlStatement);
        } catch (Exception e) {
            // Handle exceptions
        }

        return "redirect:/home";
    }
}
