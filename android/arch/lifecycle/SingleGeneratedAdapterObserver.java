package android.arch.lifecycle;

import b.b.a.N;
import support.support.asm.Attribute;
import support.support.asm.c;
import support.support.asm.d;

@N({b.b.a.N.a.b})
public class SingleGeneratedAdapterObserver
  implements GenericLifecycleObserver
{
  public final Attribute j;
  
  public SingleGeneratedAdapterObserver(Attribute paramAttribute)
  {
    j = paramAttribute;
  }
  
  public void b(d paramD, c paramC)
  {
    j.a(paramD, paramC, false, null);
    j.a(paramD, paramC, true, null);
  }
}
