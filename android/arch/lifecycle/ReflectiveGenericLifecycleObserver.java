package android.arch.lifecycle;

import support.support.asm.ByteVector;
import support.support.asm.ClassWriter;
import support.support.asm.c;
import support.support.asm.d;

public class ReflectiveGenericLifecycleObserver
  implements GenericLifecycleObserver
{
  public final ByteVector d;
  public final Object o;
  
  public ReflectiveGenericLifecycleObserver(Object paramObject)
  {
    o = paramObject;
    d = ClassWriter.b.b(o.getClass());
  }
  
  public void b(d paramD, c paramC)
  {
    d.a(paramD, paramC, o);
  }
}
