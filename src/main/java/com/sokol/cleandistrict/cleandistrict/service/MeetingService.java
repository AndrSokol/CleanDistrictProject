package com.sokol.cleandistrict.cleandistrict.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sokol.cleandistrict.cleandistrict.convertor.MeetingConverter;
import com.sokol.cleandistrict.cleandistrict.entity.CommentEntity;
import com.sokol.cleandistrict.cleandistrict.entity.MeetingEntity;
import com.sokol.cleandistrict.cleandistrict.exception.MeetingNotFoundException;
import com.sokol.cleandistrict.cleandistrict.mapper.CommentMapper;
import com.sokol.cleandistrict.cleandistrict.mapper.MeetingMapper;
import com.sokol.cleandistrict.cleandistrict.model.Comment;
import com.sokol.cleandistrict.cleandistrict.model.Meeting;
import com.sokol.cleandistrict.cleandistrict.model.User;
import com.sokol.cleandistrict.cleandistrict.repository.CommentRepository;
import com.sokol.cleandistrict.cleandistrict.repository.MeetingRepository;

@Service
public class MeetingService {

    @Autowired
    private MeetingRepository meetingRepository;

    @Autowired
    private MeetingConverter meetingConverter;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentRepository commentRepository;

    public List<Meeting> getAllMeetings() {
        List<MeetingEntity> meetingEntities = meetingRepository.findAll();

        return meetingConverter.getMeetings(meetingEntities);
    }

    public Meeting getById(int id) {
        return meetingConverter.getMeeting(getMeetingEntity(id));
    }

    private MeetingEntity getMeetingEntity(int id) {
        Optional<MeetingEntity> meetingEntity = meetingRepository.findById(id);

        if(! meetingEntity.isPresent()){
            throw new MeetingNotFoundException(String.format("Meeting with id=%s not found", id));
        }
        return meetingEntity.get();
    }

    public Meeting createMeeting(Meeting meeting) {
        //TODO: make it more beautiful
        userService.getById(meeting.getOrganizer_id());

        MeetingEntity meetingEntity = meetingConverter.getMeetingEntity(meeting);

        return meetingConverter.getMeeting(meetingRepository.save(meetingEntity));
    }

    public List<Comment> getCommentsForMeeting(int id) {
        return meetingConverter.getMeeting(getMeetingEntity(id)).getComments();
    }

    public Comment createCommentForMeeting(int id, Comment comment) {

        CommentEntity commentEntity = CommentMapper.INSTANCE.commentToCommentEntity(comment);
        commentEntity.setMeeting(meetingConverter.getMeetingEntity(getById(id)));

        return CommentMapper.INSTANCE.commentEntityToComment(commentRepository.save(commentEntity));

    }
}
