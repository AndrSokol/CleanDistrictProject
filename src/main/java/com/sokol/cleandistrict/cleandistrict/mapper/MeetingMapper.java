package com.sokol.cleandistrict.cleandistrict.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.sokol.cleandistrict.cleandistrict.entity.MeetingEntity;
import com.sokol.cleandistrict.cleandistrict.model.Meeting;

@Mapper
public interface MeetingMapper {

    MeetingMapper INSTANCE = Mappers.getMapper(MeetingMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "title", target = "title"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "organizer.id", target = "organizer_id"),
            @Mapping(source = "comments", target = "comments"),
            @Mapping(source = "users", target = "users")
    })
    Meeting meetingEntityToMeeting(MeetingEntity meetingEntity);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "title", target = "title"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "organizer_id", target = "organizer.id"),
            @Mapping(source = "comments", target = "comments"),
            @Mapping(source = "users", target = "users")
    })
    MeetingEntity meetingToMeetingEntity(Meeting meeting);
}
