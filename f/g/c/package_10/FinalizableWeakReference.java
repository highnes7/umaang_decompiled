package f.g.c.package_10;

import f.g.c.b.F;
import java.lang.ref.WeakReference;

public abstract class FinalizableWeakReference<T>
  extends WeakReference<T>
  implements F
{
  public FinalizableWeakReference(Object paramObject, FinalizableReferenceQueue paramFinalizableReferenceQueue)
  {
    super(paramObject, queue);
    paramFinalizableReferenceQueue.cleanUp();
  }
}
