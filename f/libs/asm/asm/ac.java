package f.libs.asm.asm;

import f.c.a.a.H;
import f.c.a.a.I;

public class ac
  extends I<H>
{
  public static final String EXTRA_START_METHOD = "method";
  public static final String EXTRA_SUCCESS_FLAG = "success";
  public static final String URL_LOGIN = "login";
  
  public ac() {}
  
  public ac a(String paramString)
  {
    c.add("method", paramString);
    return this;
  }
  
  public ac a(boolean paramBoolean)
  {
    c.add("success", Boolean.toString(paramBoolean));
    return this;
  }
  
  public String getId()
  {
    return "login";
  }
}
