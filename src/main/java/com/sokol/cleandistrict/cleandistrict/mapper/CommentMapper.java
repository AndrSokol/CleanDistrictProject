package com.sokol.cleandistrict.cleandistrict.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.sokol.cleandistrict.cleandistrict.entity.CommentEntity;
import com.sokol.cleandistrict.cleandistrict.model.Comment;

@Mapper
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "text", target = "text")
    })
    Comment commentEntityToComment(CommentEntity commentEntity);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "text", target = "text")
    })
    CommentEntity commentToCommentEntity(Comment comment);
}
