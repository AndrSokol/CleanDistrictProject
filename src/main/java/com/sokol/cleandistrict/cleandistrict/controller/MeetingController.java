package com.sokol.cleandistrict.cleandistrict.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sokol.cleandistrict.cleandistrict.model.Comment;
import com.sokol.cleandistrict.cleandistrict.model.Meeting;
import com.sokol.cleandistrict.cleandistrict.service.MeetingService;

@RestController
public class MeetingController {

    @Autowired
    private MeetingService meetingService;

    @GetMapping("/meetings")
    public List<Meeting> getAll(){
        return meetingService.getAllMeetings();
    }

    @GetMapping("/meetings/{id}")
    public Meeting getMeetingById(@PathVariable int id){
        return meetingService.getById(id);
    }

    @PostMapping("/meetings")
    public Meeting createMeeting(@RequestBody Meeting meeting){
        return meetingService.createMeeting(meeting);
    }

    @GetMapping("/meetings/{id}/comments")
    public List<Comment> getCommentsForMeeting(@PathVariable int id){
        return meetingService.getCommentsForMeeting(id);
    }

    @PostMapping("/meetings/{id}/comments")
    public Comment createComment(@PathVariable int id, @RequestBody Comment comment, @RequestParam int user_id){
        // TODO: Add comment for user from request param
        return meetingService.createCommentForMeeting(id, comment);
    }
}
