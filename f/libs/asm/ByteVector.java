package f.libs.asm;

import f.libs.asm.asm.e;
import f.libs.asm.menu.Paint;
import f.libs.asm.menu.TDoubleCollection;
import f.libs.asm.menu.f;
import f.libs.asm.menu.fa.a;

public class ByteVector
{
  public e a;
  public fa.a b;
  public f.libs.asm.signature.b e;
  public f f;
  
  public ByteVector() {}
  
  private fa.a putByte()
  {
    try
    {
      if (b == null) {
        b = new fa.a();
      }
      fa.a localA = b;
      return localA;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public ByteVector a(float paramFloat)
  {
    putByte().a(paramFloat);
    return this;
  }
  
  public ByteVector a(e paramE)
  {
    if (paramE != null)
    {
      if (a == null)
      {
        a = paramE;
        return this;
      }
      throw new IllegalStateException("Answers Kit already set.");
    }
    throw new NullPointerException("Answers Kit must not be null.");
  }
  
  public ByteVector a(Paint paramPaint)
  {
    putByte().a(paramPaint);
    return this;
  }
  
  public ByteVector a(f paramF)
  {
    if (paramF != null)
    {
      if (f == null)
      {
        f = paramF;
        return this;
      }
      throw new IllegalStateException("CrashlyticsCore Kit already set.");
    }
    throw new NullPointerException("CrashlyticsCore Kit must not be null.");
  }
  
  public ByteVector a(f.libs.asm.signature.b paramB)
  {
    if (paramB != null)
    {
      if (e == null)
      {
        e = paramB;
        return this;
      }
      throw new IllegalStateException("Beta Kit already set.");
    }
    throw new NullPointerException("Beta Kit must not be null.");
  }
  
  public ByteVector a(boolean paramBoolean)
  {
    putByte().a(paramBoolean);
    return this;
  }
  
  public b a()
  {
    fa.a localA = b;
    if (localA != null) {
      if (f == null) {
        f = localA.a();
      } else {
        throw new IllegalStateException("Must not use Deprecated methods delay(), disabled(), listener(), pinningInfoProvider() with core()");
      }
    }
    if (a == null) {
      a = new e();
    }
    if (e == null) {
      e = new f.libs.asm.signature.b();
    }
    if (f == null) {
      f = new f();
    }
    return new b(a, e, f);
  }
  
  public ByteVector putByte(TDoubleCollection paramTDoubleCollection)
  {
    putByte().a(paramTDoubleCollection);
    return this;
  }
}
