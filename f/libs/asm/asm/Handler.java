package f.libs.asm.asm;

import f.c.a.a.I;
import f.c.a.a.ca;

public class Handler
  extends I<ca>
{
  public static final String EXTRA_START_METHOD = "method";
  public static final String EXTRA_SUCCESS_FLAG = "success";
  public static final String start = "signUp";
  
  public Handler() {}
  
  public Handler a(String paramString)
  {
    c.add("method", paramString);
    return this;
  }
  
  public Handler a(boolean paramBoolean)
  {
    c.add("success", Boolean.toString(paramBoolean));
    return this;
  }
  
  public String getId()
  {
    return "signUp";
  }
}
