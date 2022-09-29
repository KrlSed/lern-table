package com.sedliarov.learningtable.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

/**
 * This object is group DTO.
 *
 * @author Kirill Sedliarov
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto implements Serializable {

  private UUID groupId;

  private String name;

  private UUID teacherId;

  private Set<UUID> studentIds;
}
