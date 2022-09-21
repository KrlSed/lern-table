package com.sedliarov.learningtable.service;

import com.sedliarov.learningtable.model.enums.MessageCode;

/**
 * Message service for handling exception.
 *
 * @author  Kirill Sedliarov
 */
public interface MessageService {

  String getMessage(MessageCode code, Object... args);
}
