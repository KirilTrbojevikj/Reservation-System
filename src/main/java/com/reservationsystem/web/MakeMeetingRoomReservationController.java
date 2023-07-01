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
public class MakeMeetingRoomReservationController {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MakeMeetingRoomReservationController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/MakeMeetingRoomReservation")
    public String showMakeMeetingRoomReservationForm() {
        return "MakeMeetingRoomReservation";
    }

    @PostMapping("/MakeMeetingRoomReservation")
    public String makeMeetingRoomReservation(
            @RequestParam("meetingRoomReservationDate") @DateTimeFormat(pattern = "yyyy-mm-dd") Date meetingRoomReservationDate,
            @RequestParam("meetingRoomReservationUsername") String meetingRoomReservationUsername,
            @RequestParam("meetingRoomReservationRoomNumber") Integer meetingRoomReservationRoomNumber,
            @RequestParam("meetingRoomReservationStartTime") String meetingRoomReservationStartTime,
            @RequestParam("meetingRoomReservationEndTime") String meetingRoomReservationEndTime

    ) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("CALL CreateMeetingRoomReservation('%s', '%s', '%d','%s','%s');",
                meetingRoomReservationDate.toString(),
                meetingRoomReservationUsername,
                meetingRoomReservationRoomNumber,
                meetingRoomReservationStartTime,
                meetingRoomReservationEndTime
        ));

        String sqlStatement = sb.toString();

        jdbcTemplate.execute(sqlStatement);

        return "redirect:/home";
    }
}
