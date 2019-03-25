package com.sokol.cleandistrict.cleandistrict.convertor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sokol.cleandistrict.cleandistrict.entity.MeetingEntity;
import com.sokol.cleandistrict.cleandistrict.mapper.MeetingMapper;
import com.sokol.cleandistrict.cleandistrict.model.Meeting;

@Service
public class MeetingConverter {

    public List<Meeting> getMeetings(List<MeetingEntity> meetingEntities){
        List<Meeting> meetings = new ArrayList<>();

        meetingEntities.forEach(meetingEntity -> {
            meetings.add(getMeeting(meetingEntity));
        });

        return meetings;
    }

    public Meeting getMeeting(MeetingEntity meetingEntity) {
        return MeetingMapper.INSTANCE.meetingEntityToMeeting(meetingEntity);
    }

    public MeetingEntity getMeetingEntity(Meeting meeting) {
        return MeetingMapper.INSTANCE.meetingToMeetingEntity(meeting);
    }
}
