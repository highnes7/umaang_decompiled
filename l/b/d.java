package l.b;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import l.b.f.o;
import l.b.g.e.c.B;
import l.b.g.e.c.C;
import l.b.g.e.c.D;
import l.b.g.e.c.E;
import l.b.g.e.c.F;
import l.b.g.e.c.H;
import l.b.g.e.c.I;
import l.b.g.e.c.J;
import l.b.g.e.c.K;
import l.b.g.e.c.L;
import l.b.g.e.c.M;
import l.b.g.e.c.N;
import l.b.g.e.c.P;
import l.b.g.e.c.S;
import l.b.g.e.c.T;
import l.b.g.e.c.U;
import l.b.g.e.c.V;
import l.b.g.e.c.W;
import l.b.g.e.c.X;
import l.b.g.e.c.Y;
import l.b.g.e.c.Z;
import l.b.g.e.c.aa;
import l.b.g.e.c.ba;
import l.b.g.e.c.ca;
import l.b.g.e.c.ea;
import l.b.g.e.c.f;
import l.b.g.e.c.fa;
import l.b.g.e.c.ga;
import l.b.g.e.c.ha;
import l.b.g.e.c.ia;
import l.b.g.e.c.ja;
import l.b.g.e.c.ka;
import l.b.g.e.c.la;
import l.b.g.e.c.ma;
import l.b.g.e.c.na;
import l.b.g.e.c.oa;
import l.b.g.e.c.p;
import l.b.g.e.c.pa;
import l.b.g.e.c.q;
import l.b.g.e.c.qa;
import l.b.g.e.c.ra;
import l.b.g.e.c.sa;
import l.b.g.e.c.ta;
import l.b.g.e.c.x;
import l.b.g.e.c.z;
import l.b.i.u.a;
import org.reactivestreams.Publisher;

public abstract class d<T>
  implements v<T>
{
  public d() {}
  
  public static ExtensionData a(Object paramObject1, Object paramObject2, l.b.f.d paramD)
  {
    l.b.g.b.b.a(paramObject1, "source1 is null");
    l.b.g.b.b.a(paramObject2, "source2 is null");
    l.b.g.b.b.a(paramD, "isEqual is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.c.u(paramObject1, paramObject2, paramD));
  }
  
  public static d a(Iterable paramIterable)
  {
    l.b.g.b.b.a(paramIterable, "sources is null");
    return l.b.k.a.a((d)new l.b.g.e.c.b(null, paramIterable));
  }
  
  public static d a(Iterable paramIterable, o paramO)
  {
    l.b.g.b.b.a(paramO, "zipper is null");
    l.b.g.b.b.a(paramIterable, "sources is null");
    return l.b.k.a.a((d)new ta(paramIterable, paramO));
  }
  
  public static d a(Runnable paramRunnable)
  {
    l.b.g.b.b.a(paramRunnable, "run is null");
    return l.b.k.a.a((d)new L(paramRunnable));
  }
  
  public static d a(Throwable paramThrowable)
  {
    l.b.g.b.b.a(paramThrowable, "exception is null");
    return l.b.k.a.a((d)new l.b.g.e.c.v(paramThrowable));
  }
  
  public static d a(Callable paramCallable)
  {
    l.b.g.b.b.a(paramCallable, "maybeSupplier is null");
    return l.b.k.a.a((d)new l.b.g.e.c.k(paramCallable));
  }
  
  public static d a(Callable paramCallable, o paramO, l.b.f.g paramG)
  {
    return a(paramCallable, paramO, paramG, true);
  }
  
  public static d a(Callable paramCallable, o paramO, l.b.f.g paramG, boolean paramBoolean)
  {
    l.b.g.b.b.a(paramCallable, "resourceSupplier is null");
    l.b.g.b.b.a(paramO, "sourceSupplier is null");
    l.b.g.b.b.a(paramG, "disposer is null");
    return l.b.k.a.a((d)new ra(paramCallable, paramO, paramG, paramBoolean));
  }
  
  public static d a(Future paramFuture)
  {
    l.b.g.b.b.a(paramFuture, "future is null");
    return l.b.k.a.a((d)new K(paramFuture, 0L, null));
  }
  
  public static d a(Future paramFuture, long paramLong, TimeUnit paramTimeUnit)
  {
    l.b.g.b.b.a(paramFuture, "future is null");
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    return l.b.k.a.a((d)new K(paramFuture, paramLong, paramTimeUnit));
  }
  
  public static d a(Item paramItem)
  {
    l.b.g.b.b.a(paramItem, "completableSource is null");
    return l.b.k.a.a((d)new J(paramItem));
  }
  
  public static d a(Number paramNumber)
  {
    l.b.g.b.b.a(paramNumber, "singleSource is null");
    return l.b.k.a.a((d)new M(paramNumber));
  }
  
  public static d a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8, Object paramObject9, l.b.f.n paramN)
  {
    l.b.g.b.b.a(paramObject1, "source1 is null");
    l.b.g.b.b.a(paramObject2, "source2 is null");
    l.b.g.b.b.a(paramObject3, "source3 is null");
    l.b.g.b.b.a(paramObject4, "source4 is null");
    l.b.g.b.b.a(paramObject5, "source5 is null");
    l.b.g.b.b.a(paramObject6, "source6 is null");
    l.b.g.b.b.a(paramObject7, "source7 is null");
    l.b.g.b.b.a(paramObject8, "source8 is null");
    l.b.g.b.b.a(paramObject9, "source9 is null");
    return a(l.b.g.b.a.a(paramN), new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7, paramObject8, paramObject9 });
  }
  
  public static d a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8, l.b.f.m paramM)
  {
    l.b.g.b.b.a(paramObject1, "source1 is null");
    l.b.g.b.b.a(paramObject2, "source2 is null");
    l.b.g.b.b.a(paramObject3, "source3 is null");
    l.b.g.b.b.a(paramObject4, "source4 is null");
    l.b.g.b.b.a(paramObject5, "source5 is null");
    l.b.g.b.b.a(paramObject6, "source6 is null");
    l.b.g.b.b.a(paramObject7, "source7 is null");
    l.b.g.b.b.a(paramObject8, "source8 is null");
    return a(l.b.g.b.a.a(paramM), new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7, paramObject8 });
  }
  
  public static d a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, l.b.f.l paramL)
  {
    l.b.g.b.b.a(paramObject1, "source1 is null");
    l.b.g.b.b.a(paramObject2, "source2 is null");
    l.b.g.b.b.a(paramObject3, "source3 is null");
    l.b.g.b.b.a(paramObject4, "source4 is null");
    l.b.g.b.b.a(paramObject5, "source5 is null");
    l.b.g.b.b.a(paramObject6, "source6 is null");
    l.b.g.b.b.a(paramObject7, "source7 is null");
    return a(l.b.g.b.a.a(paramL), new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7 });
  }
  
  public static d a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, l.b.f.k paramK)
  {
    l.b.g.b.b.a(paramObject1, "source1 is null");
    l.b.g.b.b.a(paramObject2, "source2 is null");
    l.b.g.b.b.a(paramObject3, "source3 is null");
    l.b.g.b.b.a(paramObject4, "source4 is null");
    l.b.g.b.b.a(paramObject5, "source5 is null");
    l.b.g.b.b.a(paramObject6, "source6 is null");
    return a(l.b.g.b.a.a(paramK), new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6 });
  }
  
  public static d a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, l.b.f.j paramJ)
  {
    l.b.g.b.b.a(paramObject1, "source1 is null");
    l.b.g.b.b.a(paramObject2, "source2 is null");
    l.b.g.b.b.a(paramObject3, "source3 is null");
    l.b.g.b.b.a(paramObject4, "source4 is null");
    l.b.g.b.b.a(paramObject5, "source5 is null");
    return a(l.b.g.b.a.a(paramJ), new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5 });
  }
  
  public static d a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, l.b.f.i paramI)
  {
    l.b.g.b.b.a(paramObject1, "source1 is null");
    l.b.g.b.b.a(paramObject2, "source2 is null");
    l.b.g.b.b.a(paramObject3, "source3 is null");
    l.b.g.b.b.a(paramObject4, "source4 is null");
    return a(l.b.g.b.a.a(paramI), new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 });
  }
  
  public static d a(Object paramObject1, Object paramObject2, Object paramObject3, l.b.f.h paramH)
  {
    l.b.g.b.b.a(paramObject1, "source1 is null");
    l.b.g.b.b.a(paramObject2, "source2 is null");
    l.b.g.b.b.a(paramObject3, "source3 is null");
    return a(l.b.g.b.a.a(paramH), new Object[] { paramObject1, paramObject2, paramObject3 });
  }
  
  public static d a(Object paramObject1, Object paramObject2, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramObject1, "source1 is null");
    l.b.g.b.b.a(paramObject2, "source2 is null");
    return a(l.b.g.b.a.a(paramC), new Object[] { paramObject1, paramObject2 });
  }
  
  public static d a(o paramO, Object... paramVarArgs)
  {
    l.b.g.b.b.a(paramVarArgs, "sources is null");
    if (paramVarArgs.length == 0) {
      return b();
    }
    l.b.g.b.b.a(paramO, "zipper is null");
    return l.b.k.a.a((d)new sa(paramVarArgs, paramO));
  }
  
  public static d a(t paramT)
  {
    l.b.g.b.b.a(paramT, "onSubscribe is null");
    return l.b.k.a.a((d)new l.b.g.e.c.j(paramT));
  }
  
  public static h a(Object paramObject1, Object paramObject2)
  {
    l.b.g.b.b.a(paramObject1, "source1 is null");
    l.b.g.b.b.a(paramObject2, "source2 is null");
    return b(new Object[] { paramObject1, paramObject2 });
  }
  
  public static h a(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    l.b.g.b.b.a(paramObject1, "source1 is null");
    l.b.g.b.b.a(paramObject2, "source2 is null");
    l.b.g.b.b.a(paramObject3, "source3 is null");
    return c(new Object[] { paramObject1, paramObject2, paramObject3 });
  }
  
  public static h a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    l.b.g.b.b.a(paramObject1, "source1 is null");
    l.b.g.b.b.a(paramObject2, "source2 is null");
    l.b.g.b.b.a(paramObject3, "source3 is null");
    l.b.g.b.b.a(paramObject4, "source4 is null");
    return b(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 });
  }
  
  public static h a(Publisher paramPublisher, int paramInt)
  {
    l.b.g.b.b.a(paramPublisher, "sources is null");
    l.b.g.b.b.a(paramInt, "prefetch");
    return l.b.k.a.a((h)new l.b.g.e.b.A(paramPublisher, na.a, paramInt, l.b.g.j.j.a));
  }
  
  public static h a(Object... paramVarArgs)
  {
    l.b.g.b.b.a(paramVarArgs, "sources is null");
    if (paramVarArgs.length == 0) {
      return h.c();
    }
    if (paramVarArgs.length == 1) {
      return l.b.k.a.a((h)new la(paramVarArgs[0]));
    }
    return l.b.k.a.a((h)new W(paramVarArgs));
  }
  
  public static ExtensionData b(Object paramObject1, Object paramObject2)
  {
    return a(paramObject1, paramObject2, l.b.g.b.b.a);
  }
  
  public static d b()
  {
    return l.b.k.a.a((d)l.b.g.e.c.t.a);
  }
  
  public static d b(Object paramObject)
  {
    if ((paramObject instanceof d)) {
      return l.b.k.a.a((d)paramObject);
    }
    l.b.g.b.b.a(paramObject, "onSubscribe is null");
    return l.b.k.a.a((d)new pa(paramObject));
  }
  
  public static h b(Iterable paramIterable)
  {
    return h.a(paramIterable).a(na.a, true);
  }
  
  public static h b(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    l.b.g.b.b.a(paramObject1, "source1 is null");
    l.b.g.b.b.a(paramObject2, "source2 is null");
    l.b.g.b.b.a(paramObject3, "source3 is null");
    l.b.g.b.b.a(paramObject4, "source4 is null");
    return c(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 });
  }
  
  public static h b(Publisher paramPublisher)
  {
    return c(paramPublisher, Integer.MAX_VALUE);
  }
  
  public static h b(Object... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return h.c();
    }
    return h.a(paramVarArgs).a(na.a, true, paramVarArgs.length);
  }
  
  public static d c(Callable paramCallable)
  {
    l.b.g.b.b.a(paramCallable, "errorSupplier is null");
    return l.b.k.a.a((d)new l.b.g.e.c.w(paramCallable));
  }
  
  public static d c(l.b.f.a paramA)
  {
    l.b.g.b.b.a(paramA, "run is null");
    return l.b.k.a.a((d)new H(paramA));
  }
  
  public static h c(Iterable paramIterable)
  {
    l.b.g.b.b.a(paramIterable, "sources is null");
    return l.b.k.a.a((h)new l.b.g.e.c.g(paramIterable));
  }
  
  public static h c(Object paramObject1, Object paramObject2)
  {
    l.b.g.b.b.a(paramObject1, "source1 is null");
    l.b.g.b.b.a(paramObject2, "source2 is null");
    return c(new Object[] { paramObject1, paramObject2 });
  }
  
  public static h c(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    l.b.g.b.b.a(paramObject1, "source1 is null");
    l.b.g.b.b.a(paramObject2, "source2 is null");
    l.b.g.b.b.a(paramObject3, "source3 is null");
    return a(new Object[] { paramObject1, paramObject2, paramObject3 });
  }
  
  public static h c(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    l.b.g.b.b.a(paramObject1, "source1 is null");
    l.b.g.b.b.a(paramObject2, "source2 is null");
    l.b.g.b.b.a(paramObject3, "source3 is null");
    l.b.g.b.b.a(paramObject4, "source4 is null");
    return a(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 });
  }
  
  public static h c(Publisher paramPublisher)
  {
    return h.a(paramPublisher).c(na.a);
  }
  
  public static h c(Publisher paramPublisher, int paramInt)
  {
    l.b.g.b.b.a(paramPublisher, "source is null");
    l.b.g.b.b.a(paramInt, "maxConcurrency");
    return l.b.k.a.a((h)new l.b.g.e.b.da(paramPublisher, na.a, false, paramInt, h.a));
  }
  
  public static h c(Object... paramVarArgs)
  {
    l.b.g.b.b.a(paramVarArgs, "sources is null");
    if (paramVarArgs.length == 0) {
      return h.c();
    }
    if (paramVarArgs.length == 1) {
      return l.b.k.a.a((h)new la(paramVarArgs[0]));
    }
    return l.b.k.a.a((h)new l.b.g.e.c.e(paramVarArgs));
  }
  
  public static d d(long paramLong, TimeUnit paramTimeUnit)
  {
    return d(paramLong, paramTimeUnit, l.b.m.a.a());
  }
  
  public static d d(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((d)new ka(Math.max(0L, paramLong), paramTimeUnit, paramG));
  }
  
  public static d d(java.lang.Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "item is null");
    return l.b.k.a.a((d)new T(paramObject));
  }
  
  public static d d(Callable paramCallable)
  {
    l.b.g.b.b.a(paramCallable, "callable is null");
    return l.b.k.a.a((d)new I(paramCallable));
  }
  
  public static d d(Object... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return b();
    }
    if (paramVarArgs.length == 1) {
      return b(paramVarArgs[0]);
    }
    return l.b.k.a.a((d)new l.b.g.e.c.b(paramVarArgs, null));
  }
  
  public static h d(Iterable paramIterable)
  {
    return b(h.a(paramIterable));
  }
  
  public static h d(Object paramObject1, Object paramObject2)
  {
    l.b.g.b.b.a(paramObject1, "source1 is null");
    l.b.g.b.b.a(paramObject2, "source2 is null");
    return a(new Object[] { paramObject1, paramObject2 });
  }
  
  public static h d(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    l.b.g.b.b.a(paramObject1, "source1 is null");
    l.b.g.b.b.a(paramObject2, "source2 is null");
    l.b.g.b.b.a(paramObject3, "source3 is null");
    return b(new Object[] { paramObject1, paramObject2, paramObject3 });
  }
  
  public static h e(Iterable paramIterable)
  {
    return h.a(paramIterable).e(na.a);
  }
  
  public static h e(Publisher paramPublisher)
  {
    return h.a(paramPublisher).e(na.a);
  }
  
  public static h e(Object... paramVarArgs)
  {
    return h.a(paramVarArgs).e(na.a);
  }
  
  public static h findItem(Publisher paramPublisher)
  {
    return h.a(paramPublisher).a(na.a, true);
  }
  
  public static h i(Object... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return h.c();
    }
    if (paramVarArgs.length == 1) {
      return l.b.k.a.a((h)new la(paramVarArgs[0]));
    }
    return l.b.k.a.a((h)new f(paramVarArgs));
  }
  
  public static d onClick()
  {
    return l.b.k.a.a((d)X.a);
  }
  
  public static h onClick(Iterable paramIterable)
  {
    l.b.g.b.b.a(paramIterable, "sources is null");
    return h.a(paramIterable).c(na.a);
  }
  
  public static d onCreate(Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "source is null");
    return l.b.k.a.a((d)new l.b.g.e.c.G(paramObject, l.b.g.b.a.a));
  }
  
  public static h onCreateView(Publisher paramPublisher)
  {
    return a(paramPublisher, 2);
  }
  
  public static d setValue(Object paramObject)
  {
    if (!(paramObject instanceof d))
    {
      l.b.g.b.b.a(paramObject, "onSubscribe is null");
      return l.b.k.a.a((d)new pa(paramObject));
    }
    throw new IllegalArgumentException("unsafeCreate(Maybe) should be upgraded");
  }
  
  public final l.b.c.c a(l.b.f.g paramG1, l.b.f.g paramG2)
  {
    return a(paramG1, paramG2, l.b.g.b.a.c);
  }
  
  public final l.b.c.c a(l.b.f.g paramG1, l.b.f.g paramG2, l.b.f.a paramA)
  {
    l.b.g.b.b.a(paramG1, "onSuccess is null");
    l.b.g.b.b.a(paramG2, "onError is null");
    l.b.g.b.b.a(paramA, "onComplete is null");
    return (l.b.c.c)d(new l.b.g.e.c.d(paramG1, paramG2, paramA));
  }
  
  public final d a(long paramLong, TimeUnit paramTimeUnit)
  {
    return b(paramLong, paramTimeUnit, l.b.m.a.a());
  }
  
  public final d a(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return a(h.add(paramLong, paramTimeUnit, paramG));
  }
  
  public final d a(long paramLong, TimeUnit paramTimeUnit, G paramG, Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "fallback is null");
    return add(d(paramLong, paramTimeUnit, paramG), paramObject);
  }
  
  public final d a(long paramLong, TimeUnit paramTimeUnit, Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "other is null");
    return a(paramLong, paramTimeUnit, l.b.m.a.a(), paramObject);
  }
  
  public final d a(long paramLong, l.b.f.r paramR)
  {
    return a().a(paramLong, paramR).a();
  }
  
  public final d a(Class paramClass)
  {
    l.b.g.b.b.a(paramClass, "clazz is null");
    return b(l.b.g.b.a.a(paramClass));
  }
  
  public final d a(java.lang.Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "item is null");
    return a(d(paramObject));
  }
  
  public final d a(G paramG)
  {
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((d)new Y(this, paramG));
  }
  
  public final d a(Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "other is null");
    return l.b.k.a.a((d)new ea(this, paramObject));
  }
  
  public final d a(Object paramObject, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramObject, "other is null");
    return a(this, paramObject, paramC);
  }
  
  public final d a(l.b.f.a paramA)
  {
    l.b.f.g localG = l.b.g.b.a.d;
    l.b.f.a localA = l.b.g.b.a.c;
    l.b.g.b.b.a(paramA, "onAfterTerminate is null");
    return l.b.k.a.a((d)new ca(this, localG, localG, localG, localA, (l.b.f.a)paramA, l.b.g.b.a.c));
  }
  
  public final d a(l.b.f.b paramB)
  {
    l.b.g.b.b.a(paramB, "onEvent is null");
    return l.b.k.a.a((d)new l.b.g.e.c.s(this, paramB));
  }
  
  public final d a(l.b.f.d paramD)
  {
    return a().a(paramD).a();
  }
  
  public final d a(l.b.f.e paramE)
  {
    l.b.g.b.b.a(paramE, "stop is null");
    return a(Long.MAX_VALUE, l.b.g.b.a.a(paramE));
  }
  
  public final d a(l.b.f.g paramG)
  {
    l.b.f.g localG1 = l.b.g.b.a.d;
    l.b.g.b.b.a(paramG, "onSubscribe is null");
    paramG = (l.b.f.g)paramG;
    l.b.f.g localG2 = l.b.g.b.a.d;
    l.b.f.a localA = l.b.g.b.a.c;
    return l.b.k.a.a((d)new ca(this, localG1, paramG, localG2, localA, localA, localA));
  }
  
  public final d a(o paramO)
  {
    l.b.g.b.b.a(paramO, "resumeFunction is null");
    return l.b.k.a.a((d)new aa(this, paramO, true));
  }
  
  public final d a(o paramO, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    l.b.g.b.b.a(paramC, "resultSelector is null");
    return l.b.k.a.a((d)new z(this, paramO, paramC));
  }
  
  public final d a(o paramO1, o paramO2, Callable paramCallable)
  {
    l.b.g.b.b.a(paramO1, "onSuccessMapper is null");
    l.b.g.b.b.a(paramO2, "onErrorMapper is null");
    l.b.g.b.b.a(paramCallable, "onCompleteSupplier is null");
    return l.b.k.a.a((d)new D(this, paramO1, paramO2, paramCallable));
  }
  
  public final d a(l.b.f.r paramR)
  {
    l.b.g.b.b.a(paramR, "predicate is null");
    return l.b.k.a.a((d)new x(this, paramR));
  }
  
  public final d a(u paramU)
  {
    l.b.g.b.b.a(paramU, "onLift is null");
    return l.b.k.a.a((d)new U(this, paramU));
  }
  
  public final d a(w paramW)
  {
    l.b.g.b.b.a(paramW, "transformer is null");
    return b(((w)paramW).a(this));
  }
  
  public final d a(Publisher paramPublisher)
  {
    l.b.g.b.b.a(paramPublisher, "subscriptionIndicator is null");
    return l.b.k.a.a((d)new l.b.g.e.c.n(this, paramPublisher));
  }
  
  public final d a(Publisher paramPublisher, Object paramObject)
  {
    l.b.g.b.b.a(paramPublisher, "timeoutIndicator is null");
    l.b.g.b.b.a(paramObject, "fallback is null");
    return l.b.k.a.a((d)new ja(this, paramPublisher, paramObject));
  }
  
  public final h a()
  {
    if ((this instanceof l.b.g.c.b)) {
      return ((l.b.g.c.b)this).c();
    }
    return l.b.k.a.a((h)new la(this));
  }
  
  public final h a(long paramLong)
  {
    return a().c(paramLong);
  }
  
  public final l.b.i.u a(boolean paramBoolean)
  {
    l.b.i.u localU = new l.b.i.u(u.a.a);
    if (paramBoolean) {
      localU.cancel();
    }
    c(localU);
    return localU;
  }
  
  public final d add(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return add(d(paramLong, paramTimeUnit, paramG));
  }
  
  public final d add(Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "timeoutIndicator is null");
    return l.b.k.a.a((d)new ia(this, paramObject, null));
  }
  
  public final d add(Object paramObject1, Object paramObject2)
  {
    l.b.g.b.b.a(paramObject1, "timeoutIndicator is null");
    l.b.g.b.b.a(paramObject2, "fallback is null");
    return l.b.k.a.a((d)new ia(this, paramObject1, paramObject2));
  }
  
  public final d addSubMenu()
  {
    return l.b.k.a.a((d)new p(this));
  }
  
  public final java.lang.Object b(java.lang.Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "defaultValue is null");
    l.b.g.d.h localH = new l.b.g.d.h();
    c(localH);
    return localH.a(paramObject);
  }
  
  public final d b(long paramLong)
  {
    return a(paramLong, l.b.g.b.a.h);
  }
  
  public final d b(long paramLong, TimeUnit paramTimeUnit)
  {
    return a(paramLong, paramTimeUnit, l.b.m.a.a());
  }
  
  public final d b(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((d)new l.b.g.e.c.l(this, Math.max(0L, paramLong), paramTimeUnit, paramG));
  }
  
  public final d b(l.b.f.a paramA)
  {
    l.b.f.g localG = l.b.g.b.a.d;
    l.b.g.b.b.a(paramA, "onComplete is null");
    paramA = (l.b.f.a)paramA;
    l.b.f.a localA = l.b.g.b.a.c;
    return l.b.k.a.a((d)new ca(this, localG, localG, localG, paramA, localA, localA));
  }
  
  public final d b(l.b.f.g paramG)
  {
    l.b.g.b.b.a(paramG, "doAfterSuccess is null");
    return l.b.k.a.a((d)new q(this, paramG));
  }
  
  public final d b(o paramO)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    return l.b.k.a.a((d)new V(this, paramO));
  }
  
  public final d b(l.b.f.r paramR)
  {
    l.b.g.b.b.a(paramR, "predicate is null");
    return l.b.k.a.a((d)new Z(this, paramR));
  }
  
  public abstract void b(s paramS);
  
  public final ExtensionData c(java.lang.Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "defaultValue is null");
    return l.b.k.a.a((ExtensionData)new oa(this, paramObject));
  }
  
  public final ExtensionData c(Number paramNumber)
  {
    l.b.g.b.b.a(paramNumber, "other is null");
    return l.b.k.a.a((ExtensionData)new fa(this, paramNumber));
  }
  
  public final l.b.c.c c()
  {
    return a(l.b.g.b.a.d, l.b.g.b.a.f, l.b.g.b.a.c);
  }
  
  public final l.b.c.c c(l.b.f.g paramG)
  {
    return a(paramG, l.b.g.b.a.f, l.b.g.b.a.c);
  }
  
  public final d c(G paramG)
  {
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((d)new qa(this, paramG));
  }
  
  public final h c(Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "other is null");
    return c(this, paramObject);
  }
  
  public final h c(l.b.f.e paramE)
  {
    return a().c(paramE);
  }
  
  public final h c(o paramO)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    return l.b.k.a.a((h)new B(this, paramO));
  }
  
  public final void c(s paramS)
  {
    l.b.g.b.b.a(paramS, "observer is null");
    paramS = l.b.k.a.a(this, paramS);
    l.b.g.b.b.a(paramS, "observer returned by the RxJavaPlugins hook is null");
    try
    {
      b(paramS);
      return;
    }
    catch (Throwable paramS)
    {
      l.b.d.b.b(paramS);
      NullPointerException localNullPointerException = new NullPointerException("subscribeActual failed");
      localNullPointerException.initCause(paramS);
      throw localNullPointerException;
    }
    catch (NullPointerException paramS)
    {
      throw paramS;
    }
  }
  
  public final ExtensionData createFromParcel()
  {
    return l.b.k.a.a((ExtensionData)new S(this));
  }
  
  public final ByteVector d()
  {
    if ((this instanceof l.b.g.c.d)) {
      return ((l.b.g.c.d)this).a();
    }
    return l.b.k.a.a((ByteVector)new ma(this));
  }
  
  public final ExtensionData d(o paramO)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    return l.b.k.a.a((ExtensionData)new E(this, paramO));
  }
  
  public final d d(Class paramClass)
  {
    l.b.g.b.b.a(paramClass, "clazz is null");
    return a(l.b.g.b.a.b(paramClass)).a(paramClass);
  }
  
  public final d d(G paramG)
  {
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((d)new l.b.g.e.c.da(this, paramG));
  }
  
  public final d d(l.b.f.a paramA)
  {
    l.b.f.g localG = l.b.g.b.a.d;
    l.b.f.a localA = l.b.g.b.a.c;
    l.b.g.b.b.a(paramA, "onDispose is null");
    return l.b.k.a.a((d)new ca(this, localG, localG, localG, localA, localA, (l.b.f.a)paramA));
  }
  
  public final d d(l.b.f.g paramG)
  {
    l.b.f.g localG = l.b.g.b.a.d;
    l.b.g.b.b.a(paramG, "onError is null");
    paramG = (l.b.f.g)paramG;
    l.b.f.a localA = l.b.g.b.a.c;
    return l.b.k.a.a((d)new ca(this, localG, localG, paramG, localA, localA, localA));
  }
  
  public final d d(l.b.f.r paramR)
  {
    return a(Long.MAX_VALUE, paramR);
  }
  
  public final d d(Publisher paramPublisher)
  {
    l.b.g.b.b.a(paramPublisher, "delayIndicator is null");
    return l.b.k.a.a((d)new l.b.g.e.c.m(this, paramPublisher));
  }
  
  public final h d(Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "other is null");
    return d(this, paramObject);
  }
  
  public final s d(s paramS)
  {
    c(paramS);
    return paramS;
  }
  
  public final ExtensionData e()
  {
    return l.b.k.a.a((ExtensionData)new l.b.g.e.c.i(this));
  }
  
  public final ExtensionData e(java.lang.Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "item is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.c.h(this, paramObject));
  }
  
  public final c e(o paramO)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    return l.b.k.a.a((c)new l.b.g.e.c.A(this, paramO));
  }
  
  public final d e(Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "other is null");
    return l.b.k.a.a((d)new ga(this, paramObject));
  }
  
  public final d e(l.b.f.g paramG)
  {
    l.b.g.b.b.a(paramG, "onSubscribe is null");
    paramG = (l.b.f.g)paramG;
    l.b.f.g localG = l.b.g.b.a.d;
    l.b.f.a localA = l.b.g.b.a.c;
    return l.b.k.a.a((d)new ca(this, paramG, localG, localG, localA, localA, localA));
  }
  
  public final h getMenu()
  {
    return a(Long.MAX_VALUE);
  }
  
  public final ByteVector getPixelValue(o paramO)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    return l.b.k.a.a((ByteVector)new C(this, paramO));
  }
  
  public final d getPixelValue()
  {
    return l.b.k.a.a((d)new N(this));
  }
  
  public final d getSubMenu()
  {
    return l.b.k.a.a((d)new l.b.g.e.c.c(this));
  }
  
  public final ExtensionData i()
  {
    return l.b.k.a.a((ExtensionData)new oa(this, null));
  }
  
  public final d i(java.lang.Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "item is null");
    return i(l.b.g.b.a.c(paramObject));
  }
  
  public final d i(Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "next is null");
    return l.b.k.a.a((d)new aa(this, l.b.g.b.a.c(paramObject), false));
  }
  
  public final d i(o paramO)
  {
    l.b.g.b.b.a(paramO, "valueSupplier is null");
    return l.b.k.a.a((d)new ba(this, paramO));
  }
  
  public final d onConfigurationChanged(Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "next is null");
    return a(l.b.g.b.a.c(paramObject));
  }
  
  public final d onConfigurationChanged(o paramO)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    return l.b.k.a.a((d)new F(this, paramO));
  }
  
  public final d onCreate(l.b.f.a paramA)
  {
    l.b.g.b.b.a(paramA, "onFinally is null");
    return l.b.k.a.a((d)new l.b.g.e.c.r(this, paramA));
  }
  
  public final d onCreate(o paramO)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    return l.b.k.a.a((d)new l.b.g.e.c.G(this, paramO));
  }
  
  public final d onCreate(Publisher paramPublisher)
  {
    l.b.g.b.b.a(paramPublisher, "other is null");
    return l.b.k.a.a((d)new ha(this, paramPublisher));
  }
  
  public final d onCreateView()
  {
    return b(l.b.g.b.a.h);
  }
  
  public final d onCreateView(o paramO)
  {
    return a().a(paramO).a();
  }
  
  public final d onOptionsItemSelected(o paramO)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    return l.b.k.a.a((d)new l.b.g.e.c.G(this, paramO));
  }
  
  public final d onOptionsItemSelected(Publisher paramPublisher)
  {
    l.b.g.b.b.a(paramPublisher, "timeoutIndicator is null");
    return l.b.k.a.a((d)new ja(this, paramPublisher, null));
  }
  
  public final l.b.i.u onPageScrolled()
  {
    l.b.i.u localU = new l.b.i.u(u.a.a);
    c(localU);
    return localU;
  }
  
  public final ByteVector putInt(o paramO)
  {
    return d().put(paramO);
  }
  
  public final h putShort(o paramO)
  {
    return a().putShort(paramO);
  }
  
  public final java.lang.Object run(o paramO)
  {
    try
    {
      l.b.g.b.b.a(paramO, "convert is null");
      paramO = ((o)paramO).apply(this);
      return paramO;
    }
    catch (Throwable paramO)
    {
      l.b.d.b.b(paramO);
      throw l.b.g.j.k.c(paramO);
    }
  }
  
  public final d set(long paramLong, TimeUnit paramTimeUnit)
  {
    return add(paramLong, paramTimeUnit, l.b.m.a.a());
  }
  
  public final c setActionView()
  {
    return l.b.k.a.a((c)new P(this));
  }
  
  public final java.lang.Object setTitle()
  {
    l.b.g.d.h localH = new l.b.g.d.h();
    c(localH);
    return localH.a();
  }
  
  public final d setTitle(Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "other is null");
    return d(new Object[] { this, paramObject });
  }
  
  public final d updateMenuView()
  {
    return a(Long.MAX_VALUE, l.b.g.b.a.h);
  }
  
  public final h updateMenuView(o paramO)
  {
    return a().i(paramO);
  }
}
