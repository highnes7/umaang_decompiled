package f.libs.asm.asm;

import f.c.a.a.I;
import f.c.a.a.Q;

public class t
  extends I<Q>
{
  public static final String PARAM_SEARCH = "search";
  public static final String b = "query";
  
  public t() {}
  
  public t a(String paramString)
  {
    c.add("query", paramString);
    return this;
  }
  
  public String getId()
  {
    return "search";
  }
}
