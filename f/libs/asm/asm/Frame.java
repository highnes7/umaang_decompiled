package f.libs.asm.asm;

import java.util.Map;

public class Frame
{
  public Map<String, String> a;
  public final TextOrientationType b;
  public Map<String, Object> c;
  public final long d;
  public String e;
  public String f;
  public Map<String, Object> g;
  
  public Frame(TextOrientationType paramTextOrientationType)
  {
    b = paramTextOrientationType;
    d = System.currentTimeMillis();
    a = null;
    f = null;
    c = null;
    e = null;
    g = null;
  }
  
  public Frame a(Map paramMap)
  {
    c = paramMap;
    return this;
  }
  
  public Label a(m paramM)
  {
    return new Label(paramM, d, b, a, f, c, e, g);
  }
  
  public Frame b(String paramString)
  {
    f = paramString;
    return this;
  }
  
  public Frame b(Map paramMap)
  {
    a = paramMap;
    return this;
  }
  
  public Frame init(String paramString)
  {
    e = paramString;
    return this;
  }
  
  public Frame init(Map paramMap)
  {
    g = paramMap;
    return this;
  }
}
