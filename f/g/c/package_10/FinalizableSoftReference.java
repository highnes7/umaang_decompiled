package f.g.c.package_10;

import f.g.c.b.F;
import java.lang.ref.SoftReference;

public abstract class FinalizableSoftReference<T>
  extends SoftReference<T>
  implements F
{
  public FinalizableSoftReference(Object paramObject, FinalizableReferenceQueue paramFinalizableReferenceQueue)
  {
    super(paramObject, queue);
    paramFinalizableReferenceQueue.cleanUp();
  }
}
