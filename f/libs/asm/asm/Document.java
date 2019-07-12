package f.libs.asm.asm;

import f.c.a.a.D;
import f.c.a.a.I;

public class Document
  extends I<D>
{
  public static final String EXTRA_START_METHOD = "method";
  public static final String location = "invite";
  
  public Document() {}
  
  public String getId()
  {
    return "invite";
  }
  
  public Document write(String paramString)
  {
    c.add("method", paramString);
    return this;
  }
}
