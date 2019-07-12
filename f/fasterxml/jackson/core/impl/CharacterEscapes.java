package f.fasterxml.jackson.core.impl;

import f.fasterxml.jackson.core.SerializableString;
import java.io.Serializable;

public abstract class CharacterEscapes
  implements Serializable
{
  public static final int ESCAPE_CUSTOM = -2;
  public static final int ESCAPE_NONE = 0;
  public static final int ESCAPE_STANDARD = -1;
  public static final long serialVersionUID = 1L;
  
  public CharacterEscapes() {}
  
  public static int[] standardAsciiEscapesForJSON()
  {
    int[] arrayOfInt1 = Utf8StreamParser.sOutputEscapes128;
    int[] arrayOfInt2 = new int[arrayOfInt1.length];
    System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, arrayOfInt1.length);
    return arrayOfInt2;
  }
  
  public abstract int[] getEscapeCodesForAscii();
  
  public abstract SerializableString getEscapeSequence(int paramInt);
}
