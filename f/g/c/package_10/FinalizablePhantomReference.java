package f.g.c.package_10;

import f.g.c.b.F;
import java.lang.ref.PhantomReference;

public abstract class FinalizablePhantomReference<T>
  extends PhantomReference<T>
  implements F
{
  public FinalizablePhantomReference(Object paramObject, FinalizableReferenceQueue paramFinalizableReferenceQueue)
  {
    super(paramObject, queue);
    paramFinalizableReferenceQueue.cleanUp();
  }
}
