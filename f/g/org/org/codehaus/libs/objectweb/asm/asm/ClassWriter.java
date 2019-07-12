package f.g.org.org.codehaus.libs.objectweb.asm.asm;

import java.util.AbstractList;

public final class ClassWriter
  extends AbstractList<Object>
{
  public ClassWriter(Object[] paramArrayOfObject, Object paramObject1, Object paramObject2) {}
  
  public Object get(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return a[(paramInt - 2)];
      }
      return c;
    }
    return v;
  }
  
  public int size()
  {
    return a.length + 2;
  }
}
