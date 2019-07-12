package support.support.asm;

import android.arch.lifecycle.GenericLifecycleObserver;

public class e
{
  public f a;
  public GenericLifecycleObserver b;
  
  public e(MethodVisitor paramMethodVisitor, f paramF)
  {
    b = Frame.a(paramMethodVisitor);
    a = paramF;
  }
  
  public void a(d paramD, c paramC)
  {
    f localF = MethodWriter.a(paramC);
    a = MethodWriter.a(a, localF);
    b.b(paramD, paramC);
    a = localF;
  }
}
