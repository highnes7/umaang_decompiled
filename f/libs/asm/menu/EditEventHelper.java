package f.libs.asm.menu;

public final class EditEventHelper
{
  public static final int ALIGNMENT = 16;
  public static final int ATTENDEES_INDEX_EMAIL = 2;
  public static final int ATTENDEES_INDEX_RELATIONSHIP = 3;
  public static final int CALENDARS_INDEX_ACCESS_LEVEL = 5;
  public static final int CALENDARS_INDEX_CAN_ORGANIZER_RESPOND = 4;
  public static final int CALENDARS_INDEX_COLOR = 3;
  public static final int CALENDARS_INDEX_DISPLAY_NAME = 1;
  public static final int CALENDARS_INDEX_OWNER_ACCOUNT = 2;
  public static final int CODE_PLAYLISTMEMBER = 11;
  public static final int COLORS_INDEX_COLOR = 3;
  public static final int COLORS_INDEX_COLOR_KEY = 1;
  public static final int DOES_NOT_REPEAT = 0;
  public static final int STATE_PAUSED_ROAMING = 12;
  public static final int TRANSACTION_addSpeechFile = 7;
  public static final int TextView_maxEms = 26;
  
  public EditEventHelper() {}
  
  public static int a(int paramInt)
  {
    return paramInt >>> 3;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 << 3 | paramInt2;
  }
  
  public static int getCharUnit(int paramInt)
  {
    return paramInt & 0x7;
  }
}
