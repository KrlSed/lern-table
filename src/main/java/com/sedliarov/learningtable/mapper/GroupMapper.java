package com.sedliarov.learningtable.mapper;

import com.sedliarov.learningtable.model.dto.GroupDto;
import com.sedliarov.learningtable.model.entity.Group;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GroupMapper {
    GroupMapper INSTANCE = Mappers.getMapper(GroupMapper.class);

    @Mapping(source = "role", target = "role")
    Group dtoToGroup(GroupDto groupDto);

    @Mapping(source = "role", target = "role")
    GroupDto groupToDto(Group group);
}
