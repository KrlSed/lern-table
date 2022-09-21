package com.sedliarov.learningtable.service.impl;

import com.sedliarov.learningtable.model.enums.MessageCode;
import com.sedliarov.learningtable.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * Implementation for {@link MessageService}.
 *
 * @author Kirill Sedliarov
 */
@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

  private final MessageSource messageSource;

  @Override
  public String getMessage(MessageCode code, Object... args) {
    return messageSource.getMessage(code.getMessage(), args, Locale.ENGLISH);
  }
}
