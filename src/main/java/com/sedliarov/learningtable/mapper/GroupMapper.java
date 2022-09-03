package com.sedliarov.learningtable.mapper;

import com.sedliarov.learningtable.model.dto.GroupDto;
import com.sedliarov.learningtable.model.entity.Group;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GroupMapper {
    GroupMapper INSTANCE = Mappers.getMapper(GroupMapper.class);

    Group dtoToEntity(GroupDto groupDto);

    GroupDto entityToDto(Group group);
}
