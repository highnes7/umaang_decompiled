package f.libs.asm.asm;

import f.c.a.a.F;
import f.c.a.a.I;

public class ExtensionData
  extends I<F>
{
  public static final String COLUMN_SCORE = "score";
  public static final String KEY_CLICK_INTENT = "success";
  public static final String KEY_ICON = "levelName";
  public static final String e = "levelEnd";
  
  public ExtensionData() {}
  
  public ExtensionData a(Number paramNumber)
  {
    c.add("score", paramNumber);
    return this;
  }
  
  public ExtensionData a(String paramString)
  {
    c.add("levelName", paramString);
    return this;
  }
  
  public ExtensionData a(boolean paramBoolean)
  {
    c localC = c;
    String str;
    if (paramBoolean) {
      str = "true";
    } else {
      str = "false";
    }
    localC.add("success", str);
    return this;
  }
  
  public String getId()
  {
    return "levelEnd";
  }
}
