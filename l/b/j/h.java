package l.b.j;

import java.util.Comparator;
import java.util.concurrent.Callable;
import l.b.G;
import l.b.g.e.e.d;
import l.b.g.e.e.e;
import l.b.g.e.e.i;
import l.b.g.e.e.l;
import l.b.g.e.e.n;
import l.b.g.e.e.s;
import l.b.g.j.w;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

@l.b.b.c
public abstract class h<T>
{
  public h() {}
  
  public static h a(Publisher paramPublisher, int paramInt1, int paramInt2)
  {
    l.b.g.b.b.a(paramPublisher, "source");
    l.b.g.b.b.a(paramInt1, "parallelism");
    l.b.g.b.b.a(paramInt2, "prefetch");
    return l.b.k.a.a((h)new l.b.g.e.e.j(paramPublisher, paramInt1, paramInt2));
  }
  
  public static h a(Publisher... paramVarArgs)
  {
    if (paramVarArgs.length != 0) {
      return l.b.k.a.a((h)new i(paramVarArgs));
    }
    throw new IllegalArgumentException("Zero publishers not supported");
  }
  
  public static h c(Publisher paramPublisher)
  {
    return a(paramPublisher, Runtime.getRuntime().availableProcessors(), l.b.h.a);
  }
  
  public static h c(Publisher paramPublisher, int paramInt)
  {
    return a(paramPublisher, paramInt, l.b.h.a);
  }
  
  public final l.b.h a()
  {
    return c(l.b.h.a);
  }
  
  public final l.b.h a(int paramInt)
  {
    l.b.g.b.b.a(paramInt, "prefetch");
    return l.b.k.a.a((l.b.h)new l.b.g.e.e.k(this, paramInt, true));
  }
  
  public final l.b.h a(Comparator paramComparator)
  {
    return c(paramComparator, 16);
  }
  
  public final l.b.h a(Comparator paramComparator, int paramInt)
  {
    l.b.g.b.b.a(paramComparator, "comparator is null");
    l.b.g.b.b.a(paramInt, "capacityHint");
    return l.b.k.a.a(a(l.b.g.b.a.a(paramInt / d() + 1), l.b.g.j.o.a).a(new w(paramComparator)).a(new l.b.g.j.p(paramComparator)));
  }
  
  public final l.b.h a(l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramC, "reducer");
    return l.b.k.a.a((l.b.h)new l.b.g.e.e.q(this, paramC));
  }
  
  public final h a(Callable paramCallable, l.b.f.b paramB)
  {
    l.b.g.b.b.a(paramCallable, "collectionSupplier is null");
    l.b.g.b.b.a(paramB, "collector is null");
    return l.b.k.a.a((h)new l.b.g.e.e.a(this, paramCallable, paramB));
  }
  
  public final h a(Callable paramCallable, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramCallable, "initialSupplier");
    l.b.g.b.b.a(paramC, "reducer");
    return l.b.k.a.a((h)new l.b.g.e.e.p(this, paramCallable, paramC));
  }
  
  public final h a(l.b.f.a paramA)
  {
    l.b.g.b.b.a(paramA, "onComplete is null");
    l.b.f.g localG = l.b.g.b.a.d;
    return l.b.k.a.a((h)new l.b.g.e.e.o(this, localG, localG, localG, paramA, l.b.g.b.a.c, l.b.g.b.a.d, l.b.g.b.a.g, l.b.g.b.a.c));
  }
  
  public final h a(l.b.f.g paramG)
  {
    l.b.g.b.b.a(paramG, "onAfterNext is null");
    l.b.f.g localG = l.b.g.b.a.d;
    l.b.f.a localA = l.b.g.b.a.c;
    return l.b.k.a.a((h)new l.b.g.e.e.o(this, localG, paramG, localG, localA, localA, l.b.g.b.a.d, l.b.g.b.a.g, l.b.g.b.a.c));
  }
  
  public final h a(l.b.f.g paramG, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramG, "onNext is null");
    l.b.g.b.b.a(paramC, "errorHandler is null");
    return l.b.k.a.a((h)new d(this, paramG, paramC));
  }
  
  public final h a(l.b.f.g paramG, a paramA)
  {
    l.b.g.b.b.a(paramG, "onNext is null");
    l.b.g.b.b.a(paramA, "errorHandler is null");
    return l.b.k.a.a((h)new d(this, paramG, paramA));
  }
  
  public final h a(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "mapper");
    return l.b.k.a.a((h)new l(this, paramO));
  }
  
  public final h a(l.b.f.o paramO, int paramInt)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    l.b.g.b.b.a(paramInt, "prefetch");
    return l.b.k.a.a((h)new l.b.g.e.e.b(this, paramO, paramInt, l.b.g.j.j.a));
  }
  
  public final h a(l.b.f.o paramO, int paramInt, boolean paramBoolean)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    l.b.g.b.b.a(paramInt, "prefetch");
    l.b.g.j.j localJ;
    if (paramBoolean) {
      localJ = l.b.g.j.j.c;
    } else {
      localJ = l.b.g.j.j.b;
    }
    return l.b.k.a.a((h)new l.b.g.e.e.b(this, paramO, paramInt, localJ));
  }
  
  public final h a(l.b.f.o paramO, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramO, "mapper");
    l.b.g.b.b.a(paramC, "errorHandler is null");
    return l.b.k.a.a((h)new n(this, paramO, paramC));
  }
  
  public final h a(l.b.f.o paramO, a paramA)
  {
    l.b.g.b.b.a(paramO, "mapper");
    l.b.g.b.b.a(paramA, "errorHandler is null");
    return l.b.k.a.a((h)new n(this, paramO, paramA));
  }
  
  public final h a(l.b.f.o paramO, boolean paramBoolean)
  {
    return a(paramO, paramBoolean, Integer.MAX_VALUE, l.b.h.a);
  }
  
  public final h a(l.b.f.o paramO, boolean paramBoolean, int paramInt)
  {
    return a(paramO, paramBoolean, paramInt, l.b.h.a);
  }
  
  public final h a(l.b.f.o paramO, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    l.b.g.b.b.a(paramInt1, "maxConcurrency");
    l.b.g.b.b.a(paramInt2, "prefetch");
    return l.b.k.a.a((h)new l.b.g.e.e.h(this, paramO, paramBoolean, paramInt1, paramInt2));
  }
  
  public final h a(l.b.f.q paramQ)
  {
    l.b.g.b.b.a(paramQ, "onRequest is null");
    l.b.f.g localG = l.b.g.b.a.d;
    l.b.f.a localA = l.b.g.b.a.c;
    return l.b.k.a.a((h)new l.b.g.e.e.o(this, localG, localG, localG, localA, localA, l.b.g.b.a.d, paramQ, l.b.g.b.a.c));
  }
  
  public final h a(l.b.f.r paramR)
  {
    l.b.g.b.b.a(paramR, "predicate");
    return l.b.k.a.a((h)new e(this, paramR));
  }
  
  public final h a(l.b.f.r paramR, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramR, "predicate");
    l.b.g.b.b.a(paramC, "errorHandler is null");
    return l.b.k.a.a((h)new l.b.g.e.e.g(this, paramR, paramC));
  }
  
  public final h a(l.b.f.r paramR, a paramA)
  {
    l.b.g.b.b.a(paramR, "predicate");
    l.b.g.b.b.a(paramA, "errorHandler is null");
    return l.b.k.a.a((h)new l.b.g.e.e.g(this, paramR, paramA));
  }
  
  public final h a(c paramC)
  {
    l.b.g.b.b.a(paramC, "composer is null");
    return l.b.k.a.a(((c)paramC).a(this));
  }
  
  public final boolean a(Subscriber[] paramArrayOfSubscriber)
  {
    int i = d();
    if (paramArrayOfSubscriber.length != i)
    {
      Object localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("parallelism = ", i, ", subscribers = ");
      ((StringBuilder)localObject).append(paramArrayOfSubscriber.length);
      localObject = new IllegalArgumentException(((StringBuilder)localObject).toString());
      int j = paramArrayOfSubscriber.length;
      i = 0;
      while (i < j)
      {
        l.b.g.i.g.a((Throwable)localObject, paramArrayOfSubscriber[i]);
        i += 1;
      }
      return false;
    }
    return true;
  }
  
  public final h b(l.b.f.a paramA)
  {
    l.b.g.b.b.a(paramA, "onCancel is null");
    l.b.f.g localG = l.b.g.b.a.d;
    l.b.f.a localA = l.b.g.b.a.c;
    return l.b.k.a.a((h)new l.b.g.e.e.o(this, localG, localG, localG, localA, localA, l.b.g.b.a.d, l.b.g.b.a.g, paramA));
  }
  
  public final h b(l.b.f.g paramG)
  {
    l.b.g.b.b.a(paramG, "onError is null");
    l.b.f.g localG = l.b.g.b.a.d;
    l.b.f.a localA = l.b.g.b.a.c;
    return l.b.k.a.a((h)new l.b.g.e.e.o(this, localG, localG, paramG, localA, localA, l.b.g.b.a.d, l.b.g.b.a.g, l.b.g.b.a.c));
  }
  
  public final h b(l.b.f.o paramO)
  {
    return a(paramO, false, Integer.MAX_VALUE, l.b.h.a);
  }
  
  public final l.b.h c()
  {
    return a(l.b.h.a);
  }
  
  public final l.b.h c(int paramInt)
  {
    l.b.g.b.b.a(paramInt, "prefetch");
    return l.b.k.a.a((l.b.h)new l.b.g.e.e.k(this, paramInt, false));
  }
  
  public final l.b.h c(Comparator paramComparator)
  {
    return a(paramComparator, 16);
  }
  
  public final l.b.h c(Comparator paramComparator, int paramInt)
  {
    l.b.g.b.b.a(paramComparator, "comparator is null");
    l.b.g.b.b.a(paramInt, "capacityHint");
    return l.b.k.a.a((l.b.h)new s(a(l.b.g.b.a.a(paramInt / d() + 1), l.b.g.j.o.a).a(new w(paramComparator)), paramComparator));
  }
  
  public final h c(G paramG)
  {
    return c(paramG, l.b.h.a);
  }
  
  public final h c(G paramG, int paramInt)
  {
    l.b.g.b.b.a(paramG, "scheduler");
    l.b.g.b.b.a(paramInt, "prefetch");
    return l.b.k.a.a((h)new l.b.g.e.e.r(this, paramG, paramInt));
  }
  
  public final h c(l.b.f.a paramA)
  {
    l.b.g.b.b.a(paramA, "onAfterTerminate is null");
    l.b.f.g localG = l.b.g.b.a.d;
    return l.b.k.a.a((h)new l.b.g.e.e.o(this, localG, localG, localG, l.b.g.b.a.c, paramA, l.b.g.b.a.d, l.b.g.b.a.g, l.b.g.b.a.c));
  }
  
  public final h c(l.b.f.g paramG)
  {
    l.b.g.b.b.a(paramG, "onNext is null");
    l.b.f.g localG = l.b.g.b.a.d;
    l.b.f.a localA = l.b.g.b.a.c;
    return l.b.k.a.a((h)new l.b.g.e.e.o(this, paramG, localG, localG, localA, localA, l.b.g.b.a.d, l.b.g.b.a.g, l.b.g.b.a.c));
  }
  
  public final h c(l.b.f.o paramO)
  {
    return a(paramO, 2);
  }
  
  public final h c(l.b.f.o paramO, boolean paramBoolean)
  {
    return a(paramO, 2, paramBoolean);
  }
  
  public abstract int d();
  
  public final h d(l.b.f.g paramG)
  {
    l.b.g.b.b.a(paramG, "onSubscribe is null");
    l.b.f.g localG = l.b.g.b.a.d;
    l.b.f.a localA = l.b.g.b.a.c;
    return l.b.k.a.a((h)new l.b.g.e.e.o(this, localG, localG, localG, localA, localA, paramG, l.b.g.b.a.g, l.b.g.b.a.c));
  }
  
  public abstract void notifyDataSetChanged(Subscriber[] paramArrayOfSubscriber);
  
  public final Object run(l.b.f.o paramO)
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
}
