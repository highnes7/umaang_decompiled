package l.b;

import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import l.b.g.e.b.da;
import l.b.g.e.b.nb;
import l.b.g.e.d.Za;
import l.b.g.e.f.B;
import l.b.g.e.f.C;
import l.b.g.e.f.D;
import l.b.g.e.f.E.a;
import l.b.g.e.f.E.b;
import l.b.g.e.f.E.e;
import l.b.g.e.f.F;
import l.b.g.e.f.H;
import l.b.g.e.f.I;
import l.b.g.e.f.O;
import l.b.g.e.f.P;
import l.b.g.e.f.Q;
import l.b.g.e.f.S;
import l.b.g.e.f.T;
import l.b.g.e.f.U;
import l.b.g.e.f.V;
import l.b.g.e.f.W;
import l.b.g.e.f.f;
import l.b.g.e.f.p;
import l.b.g.e.f.q;
import l.b.g.e.f.t;
import l.b.g.e.f.w;
import l.b.g.e.f.z;
import l.b.i.u.a;
import org.reactivestreams.Publisher;

public abstract class ExtensionData<T>
  implements M<T>
{
  public ExtensionData() {}
  
  public static ByteVector a(Label paramLabel)
  {
    l.b.g.b.b.a(paramLabel, "sources is null");
    return l.b.k.a.a((ByteVector)new l.b.g.e.d.v(paramLabel, E.e.a, 2, l.b.g.j.j.a));
  }
  
  public static ExtensionData a(long paramLong, TimeUnit paramTimeUnit)
  {
    return b(paramLong, paramTimeUnit, l.b.m.a.a());
  }
  
  private ExtensionData a(long paramLong, TimeUnit paramTimeUnit, G paramG, Number paramNumber)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((ExtensionData)new O(this, paramLong, paramTimeUnit, paramG, paramNumber));
  }
  
  public static ExtensionData a(Iterable paramIterable, l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "zipper is null");
    l.b.g.b.b.a(paramIterable, "sources is null");
    return l.b.k.a.a((ExtensionData)new W(paramIterable, paramO));
  }
  
  public static ExtensionData a(Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "value is null");
    return l.b.k.a.a((ExtensionData)new F(paramObject));
  }
  
  public static ExtensionData a(Throwable paramThrowable)
  {
    l.b.g.b.b.a(paramThrowable, "error is null");
    return a(l.b.g.b.a.b(paramThrowable));
  }
  
  public static ExtensionData a(Callable paramCallable)
  {
    l.b.g.b.b.a(paramCallable, "errorSupplier is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.f.u(paramCallable));
  }
  
  public static ExtensionData a(Callable paramCallable, l.b.f.o paramO, l.b.f.g paramG)
  {
    return a(paramCallable, paramO, paramG, true);
  }
  
  public static ExtensionData a(Callable paramCallable, l.b.f.o paramO, l.b.f.g paramG, boolean paramBoolean)
  {
    l.b.g.b.b.a(paramCallable, "resourceSupplier is null");
    l.b.g.b.b.a(paramO, "singleFunction is null");
    l.b.g.b.b.a(paramG, "disposer is null");
    return l.b.k.a.a((ExtensionData)new U(paramCallable, paramO, paramG, paramBoolean));
  }
  
  public static ExtensionData a(Future paramFuture)
  {
    return a(h.a(paramFuture));
  }
  
  public static ExtensionData a(Future paramFuture, long paramLong, TimeUnit paramTimeUnit)
  {
    return a(h.a(paramFuture, paramLong, paramTimeUnit));
  }
  
  public static ExtensionData a(Future paramFuture, long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return a(h.a(paramFuture, paramLong, paramTimeUnit, paramG));
  }
  
  public static ExtensionData a(Future paramFuture, G paramG)
  {
    return a(h.c(paramFuture, paramG));
  }
  
  public static ExtensionData a(K paramK)
  {
    l.b.g.b.b.a(paramK, "source is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.f.d(paramK));
  }
  
  public static ExtensionData a(Number paramNumber)
  {
    l.b.g.b.b.a(paramNumber, "source is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.f.v(paramNumber, l.b.g.b.a.a));
  }
  
  public static ExtensionData a(Number paramNumber1, Number paramNumber2, Number paramNumber3, Number paramNumber4, Number paramNumber5, Number paramNumber6, Number paramNumber7, Number paramNumber8, Number paramNumber9, l.b.f.n paramN)
  {
    l.b.g.b.b.a(paramNumber1, "source1 is null");
    l.b.g.b.b.a(paramNumber2, "source2 is null");
    l.b.g.b.b.a(paramNumber3, "source3 is null");
    l.b.g.b.b.a(paramNumber4, "source4 is null");
    l.b.g.b.b.a(paramNumber5, "source5 is null");
    l.b.g.b.b.a(paramNumber6, "source6 is null");
    l.b.g.b.b.a(paramNumber7, "source7 is null");
    l.b.g.b.b.a(paramNumber8, "source8 is null");
    l.b.g.b.b.a(paramNumber9, "source9 is null");
    return a(l.b.g.b.a.a(paramN), new Number[] { paramNumber1, paramNumber2, paramNumber3, paramNumber4, paramNumber5, paramNumber6, paramNumber7, paramNumber8, paramNumber9 });
  }
  
  public static ExtensionData a(Number paramNumber1, Number paramNumber2, Number paramNumber3, Number paramNumber4, Number paramNumber5, Number paramNumber6, Number paramNumber7, Number paramNumber8, l.b.f.m paramM)
  {
    l.b.g.b.b.a(paramNumber1, "source1 is null");
    l.b.g.b.b.a(paramNumber2, "source2 is null");
    l.b.g.b.b.a(paramNumber3, "source3 is null");
    l.b.g.b.b.a(paramNumber4, "source4 is null");
    l.b.g.b.b.a(paramNumber5, "source5 is null");
    l.b.g.b.b.a(paramNumber6, "source6 is null");
    l.b.g.b.b.a(paramNumber7, "source7 is null");
    l.b.g.b.b.a(paramNumber8, "source8 is null");
    return a(l.b.g.b.a.a(paramM), new Number[] { paramNumber1, paramNumber2, paramNumber3, paramNumber4, paramNumber5, paramNumber6, paramNumber7, paramNumber8 });
  }
  
  public static ExtensionData a(Number paramNumber1, Number paramNumber2, Number paramNumber3, Number paramNumber4, Number paramNumber5, Number paramNumber6, Number paramNumber7, l.b.f.l paramL)
  {
    l.b.g.b.b.a(paramNumber1, "source1 is null");
    l.b.g.b.b.a(paramNumber2, "source2 is null");
    l.b.g.b.b.a(paramNumber3, "source3 is null");
    l.b.g.b.b.a(paramNumber4, "source4 is null");
    l.b.g.b.b.a(paramNumber5, "source5 is null");
    l.b.g.b.b.a(paramNumber6, "source6 is null");
    l.b.g.b.b.a(paramNumber7, "source7 is null");
    return a(l.b.g.b.a.a(paramL), new Number[] { paramNumber1, paramNumber2, paramNumber3, paramNumber4, paramNumber5, paramNumber6, paramNumber7 });
  }
  
  public static ExtensionData a(Number paramNumber1, Number paramNumber2, Number paramNumber3, Number paramNumber4, Number paramNumber5, Number paramNumber6, l.b.f.k paramK)
  {
    l.b.g.b.b.a(paramNumber1, "source1 is null");
    l.b.g.b.b.a(paramNumber2, "source2 is null");
    l.b.g.b.b.a(paramNumber3, "source3 is null");
    l.b.g.b.b.a(paramNumber4, "source4 is null");
    l.b.g.b.b.a(paramNumber5, "source5 is null");
    l.b.g.b.b.a(paramNumber6, "source6 is null");
    return a(l.b.g.b.a.a(paramK), new Number[] { paramNumber1, paramNumber2, paramNumber3, paramNumber4, paramNumber5, paramNumber6 });
  }
  
  public static ExtensionData a(Number paramNumber1, Number paramNumber2, Number paramNumber3, Number paramNumber4, Number paramNumber5, l.b.f.j paramJ)
  {
    l.b.g.b.b.a(paramNumber1, "source1 is null");
    l.b.g.b.b.a(paramNumber2, "source2 is null");
    l.b.g.b.b.a(paramNumber3, "source3 is null");
    l.b.g.b.b.a(paramNumber4, "source4 is null");
    l.b.g.b.b.a(paramNumber5, "source5 is null");
    return a(l.b.g.b.a.a(paramJ), new Number[] { paramNumber1, paramNumber2, paramNumber3, paramNumber4, paramNumber5 });
  }
  
  public static ExtensionData a(Number paramNumber1, Number paramNumber2, Number paramNumber3, Number paramNumber4, l.b.f.i paramI)
  {
    l.b.g.b.b.a(paramNumber1, "source1 is null");
    l.b.g.b.b.a(paramNumber2, "source2 is null");
    l.b.g.b.b.a(paramNumber3, "source3 is null");
    l.b.g.b.b.a(paramNumber4, "source4 is null");
    return a(l.b.g.b.a.a(paramI), new Number[] { paramNumber1, paramNumber2, paramNumber3, paramNumber4 });
  }
  
  public static ExtensionData a(Number paramNumber1, Number paramNumber2, Number paramNumber3, l.b.f.h paramH)
  {
    l.b.g.b.b.a(paramNumber1, "source1 is null");
    l.b.g.b.b.a(paramNumber2, "source2 is null");
    l.b.g.b.b.a(paramNumber3, "source3 is null");
    return a(l.b.g.b.a.a(paramH), new Number[] { paramNumber1, paramNumber2, paramNumber3 });
  }
  
  public static ExtensionData a(Number paramNumber1, Number paramNumber2, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramNumber1, "source1 is null");
    l.b.g.b.b.a(paramNumber2, "source2 is null");
    return a(l.b.g.b.a.a(paramC), new Number[] { paramNumber1, paramNumber2 });
  }
  
  public static ExtensionData a(l.b.f.o paramO, Number... paramVarArgs)
  {
    l.b.g.b.b.a(paramO, "zipper is null");
    l.b.g.b.b.a(paramVarArgs, "sources is null");
    if (paramVarArgs.length == 0) {
      return a(new NoSuchElementException());
    }
    return l.b.k.a.a((ExtensionData)new V(paramVarArgs, paramO));
  }
  
  public static ExtensionData a(h paramH)
  {
    return l.b.k.a.a((ExtensionData)new nb(paramH, null));
  }
  
  public static h a(Iterable paramIterable)
  {
    return b(h.a(paramIterable));
  }
  
  public static h a(Number paramNumber1, Number paramNumber2)
  {
    l.b.g.b.b.a(paramNumber1, "source1 is null");
    l.b.g.b.b.a(paramNumber2, "source2 is null");
    return b(h.a(new Number[] { paramNumber1, paramNumber2 }));
  }
  
  public static h a(Number paramNumber1, Number paramNumber2, Number paramNumber3)
  {
    l.b.g.b.b.a(paramNumber1, "source1 is null");
    l.b.g.b.b.a(paramNumber2, "source2 is null");
    l.b.g.b.b.a(paramNumber3, "source3 is null");
    return b(h.a(new Number[] { paramNumber1, paramNumber2, paramNumber3 }));
  }
  
  public static h a(Number paramNumber1, Number paramNumber2, Number paramNumber3, Number paramNumber4)
  {
    l.b.g.b.b.a(paramNumber1, "source1 is null");
    l.b.g.b.b.a(paramNumber2, "source2 is null");
    l.b.g.b.b.a(paramNumber3, "source3 is null");
    l.b.g.b.b.a(paramNumber4, "source4 is null");
    return b(h.a(new Number[] { paramNumber1, paramNumber2, paramNumber3, paramNumber4 }));
  }
  
  public static h a(Publisher paramPublisher)
  {
    l.b.g.b.b.a(paramPublisher, "sources is null");
    return l.b.k.a.a((h)new da(paramPublisher, E.b.a, false, Integer.MAX_VALUE, h.a));
  }
  
  public static h a(Publisher paramPublisher, int paramInt)
  {
    l.b.g.b.b.a(paramPublisher, "sources is null");
    l.b.g.b.b.a(paramInt, "prefetch");
    return l.b.k.a.a((h)new l.b.g.e.b.A(paramPublisher, E.b.a, paramInt, l.b.g.j.j.a));
  }
  
  public static h a(Number... paramVarArgs)
  {
    return l.b.k.a.a((h)new l.b.g.e.b.x(h.a(paramVarArgs), E.b.a, 2, l.b.g.j.j.b));
  }
  
  public static ExtensionData b(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((ExtensionData)new P(paramLong, paramTimeUnit, paramG));
  }
  
  public static ExtensionData b(Iterable paramIterable)
  {
    l.b.g.b.b.a(paramIterable, "sources is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.f.a(null, paramIterable));
  }
  
  public static ExtensionData b(Callable paramCallable)
  {
    l.b.g.b.b.a(paramCallable, "callable is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.f.A(paramCallable));
  }
  
  public static ExtensionData b(Number paramNumber)
  {
    l.b.g.b.b.a(paramNumber, "source is null");
    if ((paramNumber instanceof ExtensionData)) {
      return l.b.k.a.a((ExtensionData)paramNumber);
    }
    return l.b.k.a.a((ExtensionData)new C(paramNumber));
  }
  
  public static ExtensionData b(Number paramNumber1, Number paramNumber2)
  {
    l.b.g.b.b.a(paramNumber1, "first is null");
    l.b.g.b.b.a(paramNumber2, "second is null");
    return l.b.k.a.a((ExtensionData)new t(paramNumber1, paramNumber2));
  }
  
  public static ExtensionData b(Number... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return a((Callable)E.a.a);
    }
    if (paramVarArgs.length == 1) {
      return b(paramVarArgs[0]);
    }
    return l.b.k.a.a((ExtensionData)new l.b.g.e.f.a(paramVarArgs, null));
  }
  
  public static h b(Publisher paramPublisher)
  {
    return a(paramPublisher, 2);
  }
  
  public static ExtensionData c(Callable paramCallable)
  {
    l.b.g.b.b.a(paramCallable, "singleSupplier is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.f.e(paramCallable));
  }
  
  public static ExtensionData c(Label paramLabel)
  {
    l.b.g.b.b.a(paramLabel, "observableSource is null");
    return l.b.k.a.a((ExtensionData)new Za(paramLabel, null));
  }
  
  public static h c(Iterable paramIterable)
  {
    return a(h.a(paramIterable));
  }
  
  public static h c(Number paramNumber1, Number paramNumber2)
  {
    l.b.g.b.b.a(paramNumber1, "source1 is null");
    l.b.g.b.b.a(paramNumber2, "source2 is null");
    return a(h.a(new Number[] { paramNumber1, paramNumber2 }));
  }
  
  public static h c(Number paramNumber1, Number paramNumber2, Number paramNumber3)
  {
    l.b.g.b.b.a(paramNumber1, "source1 is null");
    l.b.g.b.b.a(paramNumber2, "source2 is null");
    l.b.g.b.b.a(paramNumber3, "source3 is null");
    return a(h.a(new Number[] { paramNumber1, paramNumber2, paramNumber3 }));
  }
  
  public static h c(Number paramNumber1, Number paramNumber2, Number paramNumber3, Number paramNumber4)
  {
    l.b.g.b.b.a(paramNumber1, "source1 is null");
    l.b.g.b.b.a(paramNumber2, "source2 is null");
    l.b.g.b.b.a(paramNumber3, "source3 is null");
    l.b.g.b.b.a(paramNumber4, "source4 is null");
    return a(h.a(new Number[] { paramNumber1, paramNumber2, paramNumber3, paramNumber4 }));
  }
  
  public static ExtensionData d()
  {
    return l.b.k.a.a(I.a);
  }
  
  public static ExtensionData d(Publisher paramPublisher)
  {
    l.b.g.b.b.a(paramPublisher, "publisher is null");
    return l.b.k.a.a((ExtensionData)new B(paramPublisher));
  }
  
  public static ExtensionData setValue(Number paramNumber)
  {
    l.b.g.b.b.a(paramNumber, "onSubscribe is null");
    if (!(paramNumber instanceof ExtensionData)) {
      return l.b.k.a.a((ExtensionData)new C(paramNumber));
    }
    throw new IllegalArgumentException("unsafeCreate(Single) should be upgraded");
  }
  
  public final ExtensionData a(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return b(ByteVector.a(paramLong, paramTimeUnit, paramG));
  }
  
  public final ExtensionData a(long paramLong, TimeUnit paramTimeUnit, G paramG, boolean paramBoolean)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((ExtensionData)new f(this, paramLong, paramTimeUnit, paramG, paramBoolean));
  }
  
  public final ExtensionData a(long paramLong, TimeUnit paramTimeUnit, Number paramNumber)
  {
    l.b.g.b.b.a(paramNumber, "other is null");
    return a(paramLong, paramTimeUnit, l.b.m.a.a(), paramNumber);
  }
  
  public final ExtensionData a(long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean)
  {
    return a(paramLong, paramTimeUnit, l.b.m.a.a(), paramBoolean);
  }
  
  public final ExtensionData a(Class paramClass)
  {
    l.b.g.b.b.a(paramClass, "clazz is null");
    return b(l.b.g.b.a.a(paramClass));
  }
  
  public final ExtensionData a(Object paramObject, l.b.f.d paramD)
  {
    l.b.g.b.b.a(paramObject, "value is null");
    l.b.g.b.b.a(paramD, "comparer is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.f.c(this, paramObject, paramD));
  }
  
  public final ExtensionData a(ExtensionData paramExtensionData)
  {
    l.b.g.b.b.a(paramExtensionData, "resumeSingleInCaseOfError is null");
    return d(l.b.g.b.a.c(paramExtensionData));
  }
  
  public final ExtensionData a(G paramG)
  {
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.f.J(this, paramG));
  }
  
  public final ExtensionData a(Item paramItem)
  {
    l.b.g.b.b.a(paramItem, "other is null");
    return c((Publisher)new l.b.g.e.a.L(paramItem));
  }
  
  public final ExtensionData a(L paramL)
  {
    l.b.g.b.b.a(paramL, "onLift is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.f.G(this, paramL));
  }
  
  public final ExtensionData a(N paramN)
  {
    l.b.g.b.b.a(paramN, "transformer is null");
    return b(((N)paramN).a(this));
  }
  
  public final ExtensionData a(Number paramNumber, l.b.f.c paramC)
  {
    return a(this, paramNumber, paramC);
  }
  
  public final ExtensionData a(l.b.f.a paramA)
  {
    l.b.g.b.b.a(paramA, "onFinally is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.f.n(this, paramA));
  }
  
  public final ExtensionData a(l.b.f.b paramB)
  {
    l.b.g.b.b.a(paramB, "onEvent is null");
    return l.b.k.a.a((ExtensionData)new q(this, paramB));
  }
  
  public final ExtensionData a(l.b.f.d paramD)
  {
    return a(a().a(paramD));
  }
  
  public final l.b.c.c a(l.b.f.g paramG)
  {
    return a(paramG, l.b.g.b.a.f);
  }
  
  public final l.b.c.c a(l.b.f.g paramG1, l.b.f.g paramG2)
  {
    l.b.g.b.b.a(paramG1, "onSuccess is null");
    l.b.g.b.b.a(paramG2, "onError is null");
    paramG1 = new l.b.g.d.k(paramG1, paramG2);
    a(paramG1);
    return paramG1;
  }
  
  public final c a(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    return l.b.k.a.a((c)new w(this, paramO));
  }
  
  public final d a(l.b.f.r paramR)
  {
    l.b.g.b.b.a(paramR, "predicate is null");
    return l.b.k.a.a((d)new l.b.g.e.c.y(this, paramR));
  }
  
  public final h a()
  {
    if ((this instanceof l.b.g.c.b)) {
      return ((l.b.g.c.b)this).c();
    }
    return l.b.k.a.a((h)new Q(this));
  }
  
  public final h a(long paramLong)
  {
    return a().c(paramLong);
  }
  
  public final h a(l.b.f.e paramE)
  {
    return a().c(paramE);
  }
  
  public final l.b.i.u a(boolean paramBoolean)
  {
    l.b.i.u localU = new l.b.i.u(u.a.a);
    if (paramBoolean) {
      localU.cancel();
    }
    a(localU);
    return localU;
  }
  
  public final void a(J paramJ)
  {
    l.b.g.b.b.a(paramJ, "subscriber is null");
    paramJ = l.b.k.a.a(this, paramJ);
    l.b.g.b.b.a(paramJ, "subscriber returned by the RxJavaPlugins hook is null");
    try
    {
      b(paramJ);
      return;
    }
    catch (Throwable paramJ)
    {
      l.b.d.b.b(paramJ);
      NullPointerException localNullPointerException = new NullPointerException("subscribeActual failed");
      localNullPointerException.initCause(paramJ);
      throw localNullPointerException;
    }
    catch (NullPointerException paramJ)
    {
      throw paramJ;
    }
  }
  
  public final ExtensionData add(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return a(paramLong, paramTimeUnit, paramG, false);
  }
  
  public final ExtensionData addSubMenu(l.b.f.g paramG)
  {
    l.b.g.b.b.a(paramG, "onError is null");
    return l.b.k.a.a((ExtensionData)new p(this, paramG));
  }
  
  public final ByteVector b()
  {
    if ((this instanceof l.b.g.c.d)) {
      return ((l.b.g.c.d)this).a();
    }
    return l.b.k.a.a((ByteVector)new S(this));
  }
  
  public final ExtensionData b(long paramLong)
  {
    return a(a().b(paramLong));
  }
  
  public final ExtensionData b(long paramLong, TimeUnit paramTimeUnit)
  {
    return a(paramLong, paramTimeUnit, l.b.m.a.a());
  }
  
  public final ExtensionData b(long paramLong, TimeUnit paramTimeUnit, G paramG, Number paramNumber)
  {
    l.b.g.b.b.a(paramNumber, "other is null");
    return a(paramLong, paramTimeUnit, paramG, paramNumber);
  }
  
  public final ExtensionData b(Object paramObject)
  {
    return a(paramObject, l.b.g.b.b.a);
  }
  
  public final ExtensionData b(G paramG)
  {
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.f.M(this, paramG));
  }
  
  public final ExtensionData b(Label paramLabel)
  {
    l.b.g.b.b.a(paramLabel, "other is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.f.h(this, paramLabel));
  }
  
  public final ExtensionData b(l.b.f.a paramA)
  {
    l.b.g.b.b.a(paramA, "onAfterTerminate is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.f.m(this, paramA));
  }
  
  public final ExtensionData b(l.b.f.g paramG)
  {
    l.b.g.b.b.a(paramG, "onSuccess is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.f.s(this, paramG));
  }
  
  public final ExtensionData b(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    return l.b.k.a.a((ExtensionData)new H(this, paramO));
  }
  
  public final ExtensionData b(l.b.f.r paramR)
  {
    return a(a().c(paramR));
  }
  
  public abstract void b(J paramJ);
  
  public final ExtensionData c(long paramLong, TimeUnit paramTimeUnit)
  {
    return a(paramLong, paramTimeUnit, l.b.m.a.a(), null);
  }
  
  public final ExtensionData c(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return a(paramLong, paramTimeUnit, paramG, null);
  }
  
  public final ExtensionData c(Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "value is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.f.K(this, null, paramObject));
  }
  
  public final ExtensionData c(G paramG)
  {
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((ExtensionData)new T(this, paramG));
  }
  
  public final ExtensionData c(Item paramItem)
  {
    l.b.g.b.b.a(paramItem, "other is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.f.g(this, paramItem));
  }
  
  public final ExtensionData c(Number paramNumber)
  {
    l.b.g.b.b.a(paramNumber, "other is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.f.j(this, paramNumber));
  }
  
  public final ExtensionData c(l.b.f.a paramA)
  {
    l.b.g.b.b.a(paramA, "onDispose is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.f.o(this, paramA));
  }
  
  public final ExtensionData c(l.b.f.g paramG)
  {
    l.b.g.b.b.a(paramG, "doAfterSuccess is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.f.l(this, paramG));
  }
  
  public final ExtensionData c(Publisher paramPublisher)
  {
    l.b.g.b.b.a(paramPublisher, "other is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.f.N(this, paramPublisher));
  }
  
  public final l.b.c.c c(l.b.f.b paramB)
  {
    l.b.g.b.b.a(paramB, "onCallback is null");
    paramB = new l.b.g.d.d(paramB);
    a(paramB);
    return paramB;
  }
  
  public final h c()
  {
    return a().next();
  }
  
  public final h c(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    return l.b.k.a.a((h)new l.b.g.e.f.x(this, paramO));
  }
  
  public final J clean(J paramJ)
  {
    a(paramJ);
    return paramJ;
  }
  
  public final ExtensionData d(long paramLong, TimeUnit paramTimeUnit)
  {
    return a(paramLong, paramTimeUnit, l.b.m.a.a(), false);
  }
  
  public final ExtensionData d(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "resumeFunctionInCaseOfError is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.f.L(this, paramO));
  }
  
  public final h d(Number paramNumber)
  {
    return a(this, paramNumber);
  }
  
  public final l.b.i.u equals()
  {
    l.b.i.u localU = new l.b.i.u(u.a.a);
    a(localU);
    return localU;
  }
  
  public final ExtensionData findItem()
  {
    return a(a().getItem());
  }
  
  public final c getElementType()
  {
    return l.b.k.a.a((c)new l.b.g.e.a.u(this));
  }
  
  public final d getItem()
  {
    if ((this instanceof l.b.g.c.c)) {
      return ((l.b.g.c.c)this).d();
    }
    return l.b.k.a.a((d)new l.b.g.e.c.M(this));
  }
  
  public final ExtensionData getPixelValue()
  {
    return l.b.k.a.a((ExtensionData)new l.b.g.e.f.b(this));
  }
  
  public final h i(l.b.f.o paramO)
  {
    return a().i(paramO);
  }
  
  public final h next(Number paramNumber)
  {
    return c(this, paramNumber);
  }
  
  public final ExtensionData onConfigurationChanged(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "resumeFunction is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.f.K(this, paramO, null));
  }
  
  public final ExtensionData onConfigurationChanged(Publisher paramPublisher)
  {
    l.b.g.b.b.a(paramPublisher, "other is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.f.i(this, paramPublisher));
  }
  
  public final ExtensionData onCreate()
  {
    return l.b.k.a.a((ExtensionData)new l.b.g.e.f.k(this));
  }
  
  public final ExtensionData onCreate(l.b.f.g paramG)
  {
    l.b.g.b.b.a(paramG, "onSubscribe is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.f.r(this, paramG));
  }
  
  public final d onCreate(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    return l.b.k.a.a((d)new z(this, paramO));
  }
  
  public final ExtensionData onCreateView(Number paramNumber)
  {
    l.b.g.b.b.a(paramNumber, "other is null");
    return b(new Number[] { this, paramNumber });
  }
  
  public final ByteVector onCreateViewHolder(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    return l.b.k.a.a((ByteVector)new l.b.g.e.f.y(this, paramO));
  }
  
  public final ExtensionData onOptionsItemSelected(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.f.v(this, paramO));
  }
  
  public final Future put()
  {
    return (Future)clean(new l.b.g.d.s());
  }
  
  public final ByteVector putInt(l.b.f.o paramO)
  {
    return b().put(paramO);
  }
  
  public final h putShort(l.b.f.o paramO)
  {
    return a().putShort(paramO);
  }
  
  public final Object run(l.b.f.o paramO)
  {
    try
    {
      l.b.g.b.b.a(paramO, "convert is null");
      paramO = ((l.b.f.o)paramO).apply(this);
      return paramO;
    }
    catch (Throwable paramO)
    {
      l.b.d.b.b(paramO);
      throw l.b.g.j.k.c(paramO);
    }
  }
  
  public final ExtensionData run(Number paramNumber)
  {
    l.b.g.b.b.a(paramNumber, "other is null");
    return c((Publisher)new Q(paramNumber));
  }
  
  public final ExtensionData setActionView()
  {
    return l.b.k.a.a((ExtensionData)new D(this));
  }
  
  public final l.b.c.c setChecked()
  {
    return a(l.b.g.b.a.d, l.b.g.b.a.f);
  }
  
  public final Object setIcon()
  {
    l.b.g.d.h localH = new l.b.g.d.h();
    a(localH);
    return localH.a();
  }
  
  public final ExtensionData startSupportActionMode(l.b.f.o paramO)
  {
    return a(a().a(paramO));
  }
}
