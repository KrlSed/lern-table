package com.sedliarov.learningtable.integration;

import com.sedliarov.learningtable.mapper.GroupMapper;
import com.sedliarov.learningtable.model.dto.GroupDto;
import com.sedliarov.learningtable.model.entity.Group;
import com.sedliarov.learningtable.repository.GroupRepository;
import com.sedliarov.learningtable.utils.GroupFixture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

/**
 * Integration tests for {@link com.sedliarov.learningtable.controller.GroupController}.
 *
 * @author Kirill Sedliarov
 */
public class GroupControllerIntegrationTests extends RestIntegrationTestBase {

  private static final String GROUPS_URL = "/groups/";

  private static final String NOT_FOUND_PREFIX = "Status 404: ";

  private static final String GROUP_WITH_ID = "Group with id ";

  private static final String GROUP = "Group ";

  private static final String NOT_FOUND = " not found";

  private static final String NOT_CREATED_BECAUSE_ALREADY_EXIST = " not created because already exist";

  private static final UUID NOT_EXISTING_GROUP_ID = UUID.fromString("3e1e6d16-451b-4748-b6a0-8f4a84a0a53a");

  private static final String NAME_022222 = "0222222";

  private static final String NAME_011111 = "0111111";

  @Autowired
  private GroupRepository groupRepository;

  @Autowired
  private GroupMapper mapper;

  @Test
  void testGetGroupById() {
    // given
    Group groupForSave = GroupFixture.createEntity();
    Group savedGroup = groupRepository.save(groupForSave);
    GroupDto expectedGroup = mapper.entityToDto(savedGroup);

    // when
    ResponseEntity<GroupDto> response =
        exchangeGetWithoutAuth(GROUPS_URL + savedGroup.getGroupId(), GroupDto.class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).isEqualTo(expectedGroup);
  }

  @Test
  void testGetGroupByIdIfNotExist() {
    // when
    ResponseEntity<Error> response =
        exchangeGetWithoutAuth(GROUPS_URL + NOT_EXISTING_GROUP_ID, Error.class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    assertThat(response.getBody().getMessage()).isEqualTo(NOT_FOUND_PREFIX + GROUP_WITH_ID
        + NOT_EXISTING_GROUP_ID + NOT_FOUND);
  }

  @Test
  void testGetGroups() {
    // given
    Group group = groupRepository.save(GroupFixture
        .createEntityWithName(NAME_011111));
    Group group1 = groupRepository.save(GroupFixture
        .createEntityWithName(NAME_022222));
    List<GroupDto> expectedGroups = List.of(mapper.entityToDto(group), mapper.entityToDto(group1));

    // when
    ResponseEntity<GroupDto[]> response = exchangeGetWithoutAuth(GROUPS_URL, GroupDto[].class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).containsExactlyElementsOf(expectedGroups);
  }

  @Test
  void testGetGroupsIfNotExist() {
    // when
    ResponseEntity<GroupDto[]> response = exchangeGetWithoutAuth(GROUPS_URL, GroupDto[].class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getBody()).containsExactlyElementsOf(Collections.emptyList());
  }

  @Test
  void testCreateGroup() {
    // given
    GroupDto groupForCreate = GroupFixture.createDto();

    // when
    ResponseEntity<GroupDto> response =
        exchangePostWithoutAuth(GROUPS_URL, groupForCreate, GroupDto.class);

    // then
    groupForCreate.setGroupId(response.getBody().getGroupId());
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    assertThat(response.getBody()).isEqualTo(groupForCreate);
  }

  @Test
  void testCreateGroupIfExist() {
    // given
    Group groupForSave = GroupFixture.createEntity();
    groupRepository.save(groupForSave);
    GroupDto expectedGroup = mapper.entityToDto(groupForSave);

    // when
    ResponseEntity<Error> response =
        exchangePostWithoutAuth(GROUPS_URL, expectedGroup, Error.class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    assertThat(response.getBody().getMessage())
        .isEqualTo(GROUP + expectedGroup.getName() + NOT_CREATED_BECAUSE_ALREADY_EXIST);
  }

  @Test
  void testDeleteGroup() {
    // given
    Group groupForSave = GroupFixture.createEntity();
    Group savedGroup = groupRepository.save(groupForSave);

    // when
    ResponseEntity<GroupDto> response =
        exchangeDeleteWithoutAuth(GROUPS_URL + savedGroup.getGroupId(), GroupDto.class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
  }

  @Test
  void testDeleteGroupIfNotExist() {
    // when
    ResponseEntity<Error> response =
        exchangeDeleteWithoutAuth(GROUPS_URL + NOT_EXISTING_GROUP_ID, Error.class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    assertThat(response.getBody().getMessage()).isEqualTo(GROUP_WITH_ID + NOT_EXISTING_GROUP_ID + NOT_FOUND);
  }

  @Test
  void testUpdateGroup() {
    // given
    Group savedGroup = groupRepository.save(GroupFixture.createEntity());
    GroupDto groupDtoForUpdate = GroupFixture.createDtoWithName(NAME_011111);

    // when
    ResponseEntity<GroupDto> response =
        exchangePutWithoutAuth(GROUPS_URL + savedGroup.getGroupId(), groupDtoForUpdate, GroupDto.class);

    // then
    GroupDto updatedGroup = response.getBody();
    assertSoftly(softly -> {
      softly.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
      softly.assertThat(updatedGroup.getGroupId()).isEqualTo(savedGroup.getGroupId());
      softly.assertThat(updatedGroup.getName()).isEqualTo(groupDtoForUpdate.getName());
      softly.assertThat(updatedGroup.getTeacher()).isEqualTo(groupDtoForUpdate.getTeacher());
      softly.assertThat(updatedGroup.getStudents()).isEqualTo(groupDtoForUpdate.getStudents());
    });
  }

  @Test
  void testUpdateGroupIfNotExist() {
    // given
    GroupDto groupDtoToCheck = GroupFixture.createDtoWithName(NAME_022222);

    // when
    ResponseEntity<Error> response =
        exchangePutWithoutAuth(GROUPS_URL + NOT_EXISTING_GROUP_ID, groupDtoToCheck, Error.class);

    // then
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    assertThat(response.getBody().getMessage()).isEqualTo(GROUP_WITH_ID + NOT_EXISTING_GROUP_ID + NOT_FOUND);
  }
}
