package android.arch.lifecycle;

import b.b.a.N;
import support.support.asm.Attribute;
import support.support.asm.a;
import support.support.asm.c;
import support.support.asm.d;

@N({b.b.a.N.a.b})
public class CompositeGeneratedAdaptersObserver
  implements GenericLifecycleObserver
{
  public final Attribute[] a;
  
  public CompositeGeneratedAdaptersObserver(Attribute[] paramArrayOfAttribute)
  {
    a = paramArrayOfAttribute;
  }
  
  public void b(d paramD, c paramC)
  {
    a localA = new a();
    Attribute[] arrayOfAttribute = a;
    int k = arrayOfAttribute.length;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      arrayOfAttribute[i].a(paramD, paramC, false, localA);
      i += 1;
    }
    arrayOfAttribute = a;
    k = arrayOfAttribute.length;
    i = j;
    while (i < k)
    {
      arrayOfAttribute[i].a(paramD, paramC, true, localA);
      i += 1;
    }
  }
}
