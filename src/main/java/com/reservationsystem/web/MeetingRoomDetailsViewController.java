package com.reservationsystem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Controller
public class MeetingRoomDetailsViewController {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MeetingRoomDetailsViewController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/MeetingRoomDetails")
    public String showMeetingRoomDetails(Model model) {
        String sqlStatement = "SELECT * FROM meeting_room_details";
        List<MeetingRoomDetailsView> meetingRoomDetails = jdbcTemplate.query(sqlStatement, (resultSet, rowNum) -> {
            Integer meeting_room_id = resultSet.getInt("meeting_room_id");
            Integer capacity = resultSet.getInt("capacity");
            Integer floor_id = resultSet.getInt("floor_id");
            Integer floor_number = resultSet.getInt("floor_number");
            Integer building_id = resultSet.getInt("building_id");
            String building_address = resultSet.getString("building_address");


            return new MeetingRoomDetailsView(meeting_room_id,capacity, floor_id,floor_number ,building_id, building_address);
        });

        model.addAttribute("meetingRoomDetails", meetingRoomDetails);
        return "MeetingRoomDetails";
    }
}
