package f.libs.asm.asm;

import f.c.a.a.G;
import f.c.a.a.I;

public class FieldWriter
  extends I<G>
{
  public static final String signature = "levelStart";
  public static final String value = "levelName";
  
  public FieldWriter() {}
  
  public FieldWriter a(String paramString)
  {
    c.add("levelName", paramString);
    return this;
  }
  
  public String getId()
  {
    return "levelStart";
  }
}
