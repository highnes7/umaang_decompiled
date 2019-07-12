package f.g.org.org.util;

import f.g.org.org.codehaus.libs.objectweb.asm.asm.f;

public final class Element
{
  public final f tag;
  
  public Element(f paramF)
  {
    tag = paramF;
  }
  
  public static Element append(char paramChar)
  {
    return new Element(f.a(paramChar));
  }
  
  public final String toString(Iterable paramIterable)
  {
    return tag.toString(paramIterable);
  }
}
