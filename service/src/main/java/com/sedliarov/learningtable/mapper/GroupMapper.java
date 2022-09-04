package com.sedliarov.learningtable.mapper;

import com.sedliarov.learningtable.model.dto.GroupDto;
import com.sedliarov.learningtable.model.entity.Group;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper for {@link GroupDto} and {@link Group}.
 *
 * @author  Kirill Sedliarov
 */
@Mapper
public interface GroupMapper {

  /**
   * Creating instance to group mapper
   */
  GroupMapper INSTANCE = Mappers.getMapper(GroupMapper.class);

  Group dtoToEntity(GroupDto groupDto);

  GroupDto entityToDto(Group group);
}
