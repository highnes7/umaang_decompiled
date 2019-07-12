package android.arch.lifecycle;

import support.support.asm.c;
import support.support.asm.d;

public class FullLifecycleObserverAdapter
  implements GenericLifecycleObserver
{
  public final FullLifecycleObserver o;
  
  public FullLifecycleObserverAdapter(FullLifecycleObserver paramFullLifecycleObserver)
  {
    o = paramFullLifecycleObserver;
  }
  
  public void b(d paramD, c paramC)
  {
    switch (paramC.ordinal())
    {
    default: 
      return;
    case 6: 
      throw new IllegalArgumentException("ON_ANY must not been send by anybody");
    case 5: 
      o.a(paramD);
      return;
    case 4: 
      o.f(paramD);
      return;
    case 3: 
      o.l(paramD);
      return;
    case 2: 
      o.d(paramD);
      return;
    case 1: 
      o.c(paramD);
      return;
    }
    o.b(paramD);
  }
}
