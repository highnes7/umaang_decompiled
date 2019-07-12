package l.b;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import l.b.g.e.a.A;
import l.b.g.e.a.B;
import l.b.g.e.a.C;
import l.b.g.e.a.D;
import l.b.g.e.a.F;
import l.b.g.e.a.H;
import l.b.g.e.a.I;
import l.b.g.e.a.K;
import l.b.g.e.a.L;
import l.b.g.e.a.M;
import l.b.g.e.a.N;
import l.b.g.e.a.O;
import l.b.g.e.a.l;
import l.b.g.e.a.m;
import l.b.g.e.a.n;
import l.b.g.e.a.p;
import l.b.g.e.a.q;
import l.b.g.e.a.s;
import l.b.g.e.a.t;
import l.b.g.e.a.v;
import l.b.g.e.a.w;
import l.b.g.e.a.x;
import l.b.g.e.a.y;
import l.b.g.e.a.z;
import l.b.i.u.a;
import org.reactivestreams.Publisher;

public abstract class c
  implements Item
{
  public c() {}
  
  public static c a(long paramLong, TimeUnit paramTimeUnit)
  {
    return a(paramLong, paramTimeUnit, l.b.m.a.a());
  }
  
  public static c a(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((c)new K(paramLong, paramTimeUnit, paramG));
  }
  
  private c a(long paramLong, TimeUnit paramTimeUnit, G paramG, Item paramItem)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((c)new l.b.g.e.a.J(this, paramLong, paramTimeUnit, paramG, paramItem));
  }
  
  public static c a(Iterable paramIterable)
  {
    l.b.g.b.b.a(paramIterable, "sources is null");
    return l.b.k.a.a((c)new l.b.g.e.a.e(paramIterable));
  }
  
  public static c a(Runnable paramRunnable)
  {
    l.b.g.b.b.a(paramRunnable, "run is null");
    return l.b.k.a.a((c)new t(paramRunnable));
  }
  
  public static c a(Throwable paramThrowable)
  {
    l.b.g.b.b.a(paramThrowable, "error is null");
    return l.b.k.a.a((c)new n(paramThrowable));
  }
  
  public static c a(Callable paramCallable)
  {
    l.b.g.b.b.a(paramCallable, "completableSupplier");
    return l.b.k.a.a((c)new l.b.g.e.a.g(paramCallable));
  }
  
  public static c a(Callable paramCallable, l.b.f.o paramO, l.b.f.g paramG)
  {
    return a(paramCallable, paramO, paramG, true);
  }
  
  public static c a(Callable paramCallable, l.b.f.o paramO, l.b.f.g paramG, boolean paramBoolean)
  {
    l.b.g.b.b.a(paramCallable, "resourceSupplier is null");
    l.b.g.b.b.a(paramO, "completableFunction is null");
    l.b.g.b.b.a(paramG, "disposer is null");
    return l.b.k.a.a((c)new O(paramCallable, paramO, paramG, paramBoolean));
  }
  
  public static c a(Future paramFuture)
  {
    l.b.g.b.b.a(paramFuture, "future is null");
    return a(l.b.g.b.a.a(paramFuture));
  }
  
  public static c a(Item paramItem)
  {
    l.b.g.b.b.a(paramItem, "source is null");
    if ((paramItem instanceof c)) {
      return l.b.k.a.a((c)paramItem);
    }
    return l.b.k.a.a((c)new v(paramItem));
  }
  
  public static c a(Label paramLabel)
  {
    l.b.g.b.b.a(paramLabel, "observable is null");
    return l.b.k.a.a((c)new l.b.g.e.a.r(paramLabel));
  }
  
  public static c a(Number paramNumber)
  {
    l.b.g.b.b.a(paramNumber, "single is null");
    return l.b.k.a.a((c)new l.b.g.e.a.u(paramNumber));
  }
  
  public static c a(l.b.f.a paramA)
  {
    l.b.g.b.b.a(paramA, "run is null");
    return l.b.k.a.a((c)new p(paramA));
  }
  
  private c a(l.b.f.g paramG1, l.b.f.g paramG2, l.b.f.a paramA1, l.b.f.a paramA2, l.b.f.a paramA3, l.b.f.a paramA4)
  {
    l.b.g.b.b.a(paramG1, "onSubscribe is null");
    l.b.g.b.b.a(paramG2, "onError is null");
    l.b.g.b.b.a(paramA1, "onComplete is null");
    l.b.g.b.b.a(paramA2, "onTerminate is null");
    l.b.g.b.b.a(paramA3, "onAfterTerminate is null");
    l.b.g.b.b.a(paramA4, "onDispose is null");
    return l.b.k.a.a((c)new l.b.g.e.a.G(this, paramG1, paramG2, paramA1, paramA2, paramA3, paramA4));
  }
  
  public static c a(f paramF)
  {
    l.b.g.b.b.a(paramF, "source is null");
    return l.b.k.a.a((c)new l.b.g.e.a.f(paramF));
  }
  
  public static c a(Publisher paramPublisher)
  {
    l.b.g.b.b.a(paramPublisher, "publisher is null");
    return l.b.k.a.a((c)new s(paramPublisher));
  }
  
  public static c a(Publisher paramPublisher, int paramInt)
  {
    l.b.g.b.b.a(paramPublisher, "sources is null");
    l.b.g.b.b.a(paramInt, "prefetch");
    return l.b.k.a.a((c)new l.b.g.e.a.c(paramPublisher, paramInt));
  }
  
  public static c a(Publisher paramPublisher, int paramInt, boolean paramBoolean)
  {
    l.b.g.b.b.a(paramPublisher, "sources is null");
    l.b.g.b.b.a(paramInt, "maxConcurrency");
    return l.b.k.a.a((c)new y(paramPublisher, paramInt, paramBoolean));
  }
  
  public static c a(Item... paramVarArgs)
  {
    l.b.g.b.b.a(paramVarArgs, "sources is null");
    if (paramVarArgs.length == 0) {
      return c();
    }
    if (paramVarArgs.length == 1) {
      return a(paramVarArgs[0]);
    }
    return l.b.k.a.a((c)new z(paramVarArgs));
  }
  
  public static c add(Publisher paramPublisher)
  {
    return a(paramPublisher, Integer.MAX_VALUE, true);
  }
  
  public static c b(Iterable paramIterable)
  {
    l.b.g.b.b.a(paramIterable, "sources is null");
    return l.b.k.a.a((c)new C(paramIterable));
  }
  
  public static c b(Callable paramCallable)
  {
    l.b.g.b.b.a(paramCallable, "callable is null");
    return l.b.k.a.a((c)new q(paramCallable));
  }
  
  public static c b(Item paramItem)
  {
    l.b.g.b.b.a(paramItem, "source is null");
    if (!(paramItem instanceof c)) {
      return l.b.k.a.a((c)new v(paramItem));
    }
    throw new IllegalArgumentException("Use of unsafeCreate(Completable)!");
  }
  
  public static c b(Item... paramVarArgs)
  {
    l.b.g.b.b.a(paramVarArgs, "sources is null");
    if (paramVarArgs.length == 0) {
      return c();
    }
    if (paramVarArgs.length == 1) {
      return a(paramVarArgs[0]);
    }
    return l.b.k.a.a((c)new l.b.g.e.a.d(paramVarArgs));
  }
  
  public static c c()
  {
    return l.b.k.a.a(m.a);
  }
  
  public static c c(Iterable paramIterable)
  {
    l.b.g.b.b.a(paramIterable, "sources is null");
    return l.b.k.a.a((c)new B(paramIterable));
  }
  
  public static c c(Callable paramCallable)
  {
    l.b.g.b.b.a(paramCallable, "errorSupplier is null");
    return l.b.k.a.a((c)new l.b.g.e.a.o(paramCallable));
  }
  
  public static c c(Item... paramVarArgs)
  {
    l.b.g.b.b.a(paramVarArgs, "sources is null");
    if (paramVarArgs.length == 0) {
      return c();
    }
    if (paramVarArgs.length == 1) {
      return a(paramVarArgs[0]);
    }
    return l.b.k.a.a((c)new l.b.g.e.a.a(paramVarArgs, null));
  }
  
  public static c d(Iterable paramIterable)
  {
    l.b.g.b.b.a(paramIterable, "sources is null");
    return l.b.k.a.a((c)new l.b.g.e.a.a(null, paramIterable));
  }
  
  public static c d(Item... paramVarArgs)
  {
    l.b.g.b.b.a(paramVarArgs, "sources is null");
    return l.b.k.a.a((c)new A(paramVarArgs));
  }
  
  public static c findItem(Publisher paramPublisher, int paramInt)
  {
    return a(paramPublisher, paramInt, true);
  }
  
  public static c getItem(Publisher paramPublisher)
  {
    return a(paramPublisher, 2);
  }
  
  public static c getItem(Publisher paramPublisher, int paramInt)
  {
    return a(paramPublisher, paramInt, false);
  }
  
  public static NullPointerException handleError(Throwable paramThrowable)
  {
    NullPointerException localNullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
    localNullPointerException.initCause(paramThrowable);
    return localNullPointerException;
  }
  
  public static c onCreateView(Publisher paramPublisher)
  {
    return a(paramPublisher, Integer.MAX_VALUE, false);
  }
  
  public static c setShowAsActionFlags()
  {
    return l.b.k.a.a(D.a);
  }
  
  public final ByteVector a(ByteVector paramByteVector)
  {
    l.b.g.b.b.a(paramByteVector, "other is null");
    return paramByteVector.c(b());
  }
  
  public final ExtensionData a(java.lang.Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "completionValue is null");
    return l.b.k.a.a((ExtensionData)new N(this, null, paramObject));
  }
  
  public final l.b.c.c a(l.b.f.a paramA, l.b.f.g paramG)
  {
    l.b.g.b.b.a(paramG, "onError is null");
    l.b.g.b.b.a(paramA, "onComplete is null");
    paramA = new l.b.g.d.j(paramG, paramA);
    a(paramA);
    return paramA;
  }
  
  public final c a(long paramLong)
  {
    return a(a().b(paramLong));
  }
  
  public final c a(long paramLong, TimeUnit paramTimeUnit, G paramG, boolean paramBoolean)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((c)new l.b.g.e.a.h(this, paramLong, paramTimeUnit, paramG, paramBoolean));
  }
  
  public final c a(long paramLong, TimeUnit paramTimeUnit, Item paramItem)
  {
    l.b.g.b.b.a(paramItem, "other is null");
    return a(paramLong, paramTimeUnit, l.b.m.a.a(), paramItem);
  }
  
  public final c a(G paramG)
  {
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((c)new l.b.g.e.a.j(this, paramG));
  }
  
  public final c a(l.b.f.d paramD)
  {
    return a(a().a(paramD));
  }
  
  public final c a(l.b.f.e paramE)
  {
    return a(a().c(paramE));
  }
  
  public final c a(l.b.f.g paramG)
  {
    l.b.f.g localG = l.b.g.b.a.d;
    l.b.f.a localA = l.b.g.b.a.c;
    return a(paramG, localG, localA, localA, localA, localA);
  }
  
  public final c a(l.b.f.o paramO)
  {
    return a(a().i(paramO));
  }
  
  public final c a(l.b.f.r paramR)
  {
    l.b.g.b.b.a(paramR, "predicate is null");
    return l.b.k.a.a((c)new F(this, paramR));
  }
  
  public final c a(g paramG)
  {
    l.b.g.b.b.a(paramG, "onLift is null");
    return l.b.k.a.a((c)new x(this, paramG));
  }
  
  public final c a(i paramI)
  {
    l.b.g.b.b.a(paramI, "transformer is null");
    return a(((i)paramI).a(this));
  }
  
  public final d a(Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "next is null");
    return l.b.k.a.a((d)new l.b.g.e.c.o(paramObject, this));
  }
  
  public final h a()
  {
    if ((this instanceof l.b.g.c.b)) {
      return ((l.b.g.c.b)this).c();
    }
    return l.b.k.a.a((h)new L(this));
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
  
  public final void a(e paramE)
  {
    l.b.g.b.b.a(paramE, "s is null");
    try
    {
      b(l.b.k.a.a(this, paramE));
      return;
    }
    catch (Throwable paramE)
    {
      l.b.d.b.b(paramE);
      l.b.k.a.b(paramE);
      throw handleError(paramE);
    }
    catch (NullPointerException paramE)
    {
      throw paramE;
    }
  }
  
  public final c add(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return a(paramLong, paramTimeUnit, paramG, false);
  }
  
  public final c add(long paramLong, TimeUnit paramTimeUnit, G paramG, Item paramItem)
  {
    l.b.g.b.b.a(paramItem, "other is null");
    return a(paramLong, paramTimeUnit, paramG, paramItem);
  }
  
  public final c add(l.b.f.a paramA)
  {
    l.b.f.g localG = l.b.g.b.a.d;
    l.b.f.a localA = l.b.g.b.a.c;
    return a(localG, localG, localA, localA, paramA, localA);
  }
  
  public final boolean add(long paramLong, TimeUnit paramTimeUnit)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.d.h localH = new l.b.g.d.h();
    a(localH);
    return localH.a(paramLong, paramTimeUnit);
  }
  
  public final l.b.c.c addIntentOptions()
  {
    l.b.g.d.o localO = new l.b.g.d.o();
    a(localO);
    return localO;
  }
  
  public final l.b.i.u addSubMenu()
  {
    l.b.i.u localU = new l.b.i.u(u.a.a);
    a(localU);
    return localU;
  }
  
  public final ByteVector b()
  {
    if ((this instanceof l.b.g.c.d)) {
      return ((l.b.g.c.d)this).a();
    }
    return l.b.k.a.a((ByteVector)new M(this));
  }
  
  public final ByteVector b(Label paramLabel)
  {
    l.b.g.b.b.a(paramLabel, "next is null");
    return l.b.k.a.a((ByteVector)new l.b.g.e.d.E(paramLabel, b()));
  }
  
  public final ExtensionData b(Number paramNumber)
  {
    l.b.g.b.b.a(paramNumber, "next is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.f.g(paramNumber, this));
  }
  
  public final c b(long paramLong)
  {
    return a(a().c(paramLong));
  }
  
  public final c b(long paramLong, TimeUnit paramTimeUnit)
  {
    return a(paramLong, paramTimeUnit, l.b.m.a.a(), null);
  }
  
  public final c b(G paramG)
  {
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((c)new I(this, paramG));
  }
  
  public final c b(l.b.f.a paramA)
  {
    l.b.f.g localG = l.b.g.b.a.d;
    l.b.f.a localA = l.b.g.b.a.c;
    return a(localG, localG, paramA, localA, localA, localA);
  }
  
  public final c b(l.b.f.g paramG)
  {
    l.b.f.g localG = l.b.g.b.a.d;
    l.b.f.a localA = l.b.g.b.a.c;
    return a(localG, paramG, localA, localA, localA, localA);
  }
  
  public final c b(l.b.f.o paramO)
  {
    return a(a().a(paramO));
  }
  
  public abstract void b(e paramE);
  
  public final c c(G paramG)
  {
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((c)new l.b.g.e.a.E(this, paramG));
  }
  
  public final c c(Item paramItem)
  {
    l.b.g.b.b.a(paramItem, "other is null");
    return a(new Item[] { this, paramItem });
  }
  
  public final c c(l.b.f.a paramA)
  {
    l.b.g.b.b.a(paramA, "onFinally is null");
    return l.b.k.a.a((c)new l.b.g.e.a.k(this, paramA));
  }
  
  public final c c(l.b.f.g paramG)
  {
    l.b.g.b.b.a(paramG, "onEvent is null");
    return l.b.k.a.a((c)new l(this, paramG));
  }
  
  public final c c(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "errorMapper is null");
    return l.b.k.a.a((c)new H(this, paramO));
  }
  
  public final c c(l.b.f.r paramR)
  {
    return a(a().c(paramR));
  }
  
  public final h c(Publisher paramPublisher)
  {
    l.b.g.b.b.a(paramPublisher, "next is null");
    return l.b.k.a.a((h)new l.b.g.e.b.J(paramPublisher, a()));
  }
  
  public final c close(l.b.f.a paramA)
  {
    l.b.f.g localG = l.b.g.b.a.d;
    l.b.f.a localA = l.b.g.b.a.c;
    return a(localG, localG, localA, paramA, localA, localA);
  }
  
  public final c compare()
  {
    return l.b.k.a.a((c)new w(this));
  }
  
  public final ExtensionData d(Callable paramCallable)
  {
    l.b.g.b.b.a(paramCallable, "completionValueSupplier is null");
    return l.b.k.a.a((ExtensionData)new N(this, paramCallable, null));
  }
  
  public final c d(long paramLong, TimeUnit paramTimeUnit)
  {
    return a(paramLong, paramTimeUnit, l.b.m.a.a(), false);
  }
  
  public final d d()
  {
    if ((this instanceof l.b.g.c.c)) {
      return ((l.b.g.c.c)this).d();
    }
    return l.b.k.a.a((d)new l.b.g.e.c.J(this));
  }
  
  public final c findItem()
  {
    return a(a().next());
  }
  
  public final c findItem(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return a(paramLong, paramTimeUnit, paramG, null);
  }
  
  public final c getItem()
  {
    return a(a().getItem());
  }
  
  public final e getItem(e paramE)
  {
    a(paramE);
    return paramE;
  }
  
  public final c getPixelValue()
  {
    return l.b.k.a.a((c)new l.b.g.e.a.b(this));
  }
  
  public final Throwable onCreateView()
  {
    l.b.g.d.h localH = new l.b.g.d.h();
    a(localH);
    return localH.b();
  }
  
  public final Throwable onCreateView(long paramLong, TimeUnit paramTimeUnit)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.d.h localH = new l.b.g.d.h();
    a(localH);
    return localH.b(paramLong, paramTimeUnit);
  }
  
  public final l.b.c.c onCreateView(l.b.f.a paramA)
  {
    l.b.g.b.b.a(paramA, "onComplete is null");
    paramA = new l.b.g.d.j(paramA);
    a(paramA);
    return paramA;
  }
  
  public final c onCreateView(Item paramItem)
  {
    l.b.g.b.b.a(paramItem, "other is null");
    return b(new Item[] { this, paramItem });
  }
  
  public final c performCreateView(Item paramItem)
  {
    return onCreateView(paramItem);
  }
  
  public final h removeGroup(Publisher paramPublisher)
  {
    l.b.g.b.b.a(paramPublisher, "other is null");
    return a().getItem(paramPublisher);
  }
  
  public final void removeGroup()
  {
    l.b.g.d.h localH = new l.b.g.d.h();
    a(localH);
    localH.a();
  }
  
  public final c removeItem(Item paramItem)
  {
    l.b.g.b.b.a(paramItem, "other is null");
    return c(new Item[] { this, paramItem });
  }
  
  public final java.lang.Object run(l.b.f.o paramO)
  {
    try
    {
      l.b.g.b.b.a(paramO, "converter is null");
      paramO = ((l.b.f.o)paramO).apply(this);
      return paramO;
    }
    catch (Throwable paramO)
    {
      l.b.d.b.b(paramO);
      throw l.b.g.j.k.c(paramO);
    }
  }
  
  public final c run()
  {
    return a(l.b.g.b.a.h);
  }
  
  public final c run(Item paramItem)
  {
    l.b.g.b.b.a(paramItem, "other is null");
    return b(new Item[] { paramItem, this });
  }
  
  public final c run(l.b.f.a paramA)
  {
    l.b.f.g localG = l.b.g.b.a.d;
    l.b.f.a localA = l.b.g.b.a.c;
    return a(localG, localG, localA, localA, localA, paramA);
  }
  
  public final c setActionView()
  {
    return l.b.k.a.a((c)new l.b.g.e.a.i(this));
  }
}
