package com.sedliarov.learningtable.integration;

import com.sedliarov.learningtable.mapper.GroupMapper;
import com.sedliarov.learningtable.model.dto.GroupDto;
import com.sedliarov.learningtable.model.entity.Group;
import com.sedliarov.learningtable.repository.GroupRepository;
import com.sedliarov.learningtable.utils.GroupFixture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Group integration controller with rest api tests.
 *
 * @author  Kirill Sedliarov
 */
public class GroupControllerIntegrationTests extends RestIntegrationTestBase {

  private static final String GROUPS_URL = "/groups/";

  @Autowired
  private GroupRepository groupRepository;

  // TODO: 9/5/2022 Need to create beans for all Mappers in Configuration class. And use @Autowired in tests.
  @Autowired
  private GroupMapper mapper;

  @Test
  void testGetGroupById() {

    // given
    // TODO: 9/5/2022 Need to implement Fixture{EntityName} static class and use in tests, like this case.
    Group newGroup = GroupFixture.createEntity();
    Group savedGroup = groupRepository.save(newGroup);

    // when
    ResponseEntity<GroupDto> group = exchangeGetWithoutAuth(GROUPS_URL + savedGroup.getGroupId(), GroupDto.class);

    // then
    assertThat(group.getBody()).isEqualTo(mapper.entityToDto(newGroup));
  }
}
