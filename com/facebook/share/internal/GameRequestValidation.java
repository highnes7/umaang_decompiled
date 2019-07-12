package com.facebook.share.internal;

import com.facebook.internal.Validate;
import com.facebook.share.model.GameRequestContent;
import com.facebook.share.model.GameRequestContent.ActionType;

public class GameRequestValidation
{
  public GameRequestValidation() {}
  
  public static void validate(GameRequestContent paramGameRequestContent)
  {
    Validate.notNull(paramGameRequestContent.getMessage(), "message");
    String str = paramGameRequestContent.getObjectId();
    int k = 0;
    int i;
    if (str != null) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if ((paramGameRequestContent.getActionType() != GameRequestContent.ActionType.ASKFOR) && (paramGameRequestContent.getActionType() != GameRequestContent.ActionType.SEND)) {
      j = 0;
    } else {
      j = 1;
    }
    if ((i ^ j) == 0)
    {
      j = k;
      if (paramGameRequestContent.getTo() != null) {
        j = 1;
      }
      i = j;
      if (paramGameRequestContent.getSuggestions() != null) {
        i = j + 1;
      }
      j = i;
      if (paramGameRequestContent.getFilters() != null) {
        j = i + 1;
      }
      if (j <= 1) {
        return;
      }
      throw new IllegalArgumentException("Parameters to, filters and suggestions are mutually exclusive");
    }
    throw new IllegalArgumentException("Object id should be provided if and only if action type is send or askfor");
  }
}
