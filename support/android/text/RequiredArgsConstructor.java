package support.android.text;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
public @interface RequiredArgsConstructor
{
  public static final int ATTENDEES_INDEX_RELATIONSHIP = 3;
  public static final int CALENDARS_INDEX_CAN_ORGANIZER_RESPOND = 4;
  public static final int HINT_CONTEXT_CAR_HOME = 2;
  public static final int TRANSACTION_getInfo = 5;
  
  int otherwise();
}
