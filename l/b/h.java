package l.b;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import l.b.f.i;
import l.b.g.e.b.Aa;
import l.b.g.e.b.Ba;
import l.b.g.e.b.Bb;
import l.b.g.e.b.C;
import l.b.g.e.b.Cb;
import l.b.g.e.b.Da;
import l.b.g.e.b.Db;
import l.b.g.e.b.E;
import l.b.g.e.b.Ea;
import l.b.g.e.b.Eb;
import l.b.g.e.b.F;
import l.b.g.e.b.Fa;
import l.b.g.e.b.Fb;
import l.b.g.e.b.Ga;
import l.b.g.e.b.Gb;
import l.b.g.e.b.H;
import l.b.g.e.b.Hb;
import l.b.g.e.b.I;
import l.b.g.e.b.Ia;
import l.b.g.e.b.Ib;
import l.b.g.e.b.J;
import l.b.g.e.b.Ja;
import l.b.g.e.b.K;
import l.b.g.e.b.Kb;
import l.b.g.e.b.L;
import l.b.g.e.b.La;
import l.b.g.e.b.Lb;
import l.b.g.e.b.M;
import l.b.g.e.b.Ma;
import l.b.g.e.b.Mb;
import l.b.g.e.b.N;
import l.b.g.e.b.Na;
import l.b.g.e.b.Nb;
import l.b.g.e.b.O;
import l.b.g.e.b.Oa;
import l.b.g.e.b.Ob;
import l.b.g.e.b.P;
import l.b.g.e.b.Pa;
import l.b.g.e.b.Pb;
import l.b.g.e.b.Q;
import l.b.g.e.b.Qa;
import l.b.g.e.b.Qb;
import l.b.g.e.b.Ra;
import l.b.g.e.b.Rb;
import l.b.g.e.b.S;
import l.b.g.e.b.Sb;
import l.b.g.e.b.Ta;
import l.b.g.e.b.Tb;
import l.b.g.e.b.U;
import l.b.g.e.b.Ua;
import l.b.g.e.b.Ub;
import l.b.g.e.b.V;
import l.b.g.e.b.Va;
import l.b.g.e.b.Vb;
import l.b.g.e.b.W;
import l.b.g.e.b.X;
import l.b.g.e.b.Xa;
import l.b.g.e.b.Y;
import l.b.g.e.b.Ya;
import l.b.g.e.b.Z;
import l.b.g.e.b.Za;
import l.b.g.e.b._a;
import l.b.g.e.b.ab;
import l.b.g.e.b.ba;
import l.b.g.e.b.bb;
import l.b.g.e.b.ca;
import l.b.g.e.b.cb;
import l.b.g.e.b.db;
import l.b.g.e.b.eb;
import l.b.g.e.b.fa;
import l.b.g.e.b.fb;
import l.b.g.e.b.ga;
import l.b.g.e.b.gb;
import l.b.g.e.b.ha;
import l.b.g.e.b.hb;
import l.b.g.e.b.ia;
import l.b.g.e.b.ja;
import l.b.g.e.b.jb;
import l.b.g.e.b.kb;
import l.b.g.e.b.la;
import l.b.g.e.b.ma;
import l.b.g.e.b.mb;
import l.b.g.e.b.na;
import l.b.g.e.b.nb;
import l.b.g.e.b.oa;
import l.b.g.e.b.ob;
import l.b.g.e.b.pa;
import l.b.g.e.b.pb;
import l.b.g.e.b.qa;
import l.b.g.e.b.qb;
import l.b.g.e.b.ra;
import l.b.g.e.b.rb;
import l.b.g.e.b.sa;
import l.b.g.e.b.sa.a;
import l.b.g.e.b.sa.c;
import l.b.g.e.b.sa.e;
import l.b.g.e.b.sa.f;
import l.b.g.e.b.sa.g;
import l.b.g.e.b.sa.h;
import l.b.g.e.b.sa.i;
import l.b.g.e.b.sa.j;
import l.b.g.e.b.sa.k;
import l.b.g.e.b.sa.l;
import l.b.g.e.b.sa.m;
import l.b.g.e.b.sa.n;
import l.b.g.e.b.sa.p;
import l.b.g.e.b.sb;
import l.b.g.e.b.t;
import l.b.g.e.b.ta;
import l.b.g.e.b.tb;
import l.b.g.e.b.ua;
import l.b.g.e.b.ub;
import l.b.g.e.b.v;
import l.b.g.e.b.va;
import l.b.g.e.b.vb;
import l.b.g.e.b.wa;
import l.b.g.e.b.wb;
import l.b.g.e.b.x;
import l.b.g.e.b.xa;
import l.b.g.e.b.xb;
import l.b.g.e.b.y;
import l.b.g.e.b.ya;
import l.b.g.e.b.yb;
import l.b.g.e.b.z;
import l.b.g.e.b.za;
import l.b.g.e.b.zb;
import l.b.o.f;
import l.b.o.f.a;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public abstract class h<T>
  implements Publisher<T>
{
  public static final int a = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());
  
  public h() {}
  
  public static ExtensionData a(Publisher paramPublisher1, Publisher paramPublisher2, int paramInt)
  {
    return a(paramPublisher1, paramPublisher2, l.b.g.b.b.a, paramInt);
  }
  
  public static ExtensionData a(Publisher paramPublisher1, Publisher paramPublisher2, l.b.f.d paramD, int paramInt)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    l.b.g.b.b.a(paramD, "isEqual is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return l.b.k.a.a((ExtensionData)new jb(paramPublisher1, paramPublisher2, paramD, paramInt));
  }
  
  public static h a(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 0)
    {
      if (paramInt2 == 0) {
        return c();
      }
      if (paramInt2 == 1) {
        return a(Integer.valueOf(paramInt1));
      }
      if (paramInt1 + (paramInt2 - 1) <= 2147483647L) {
        return l.b.k.a.a((h)new Qa(paramInt1, paramInt2));
      }
      throw new IllegalArgumentException("Integer overflow");
    }
    throw new IllegalArgumentException(StringBuilder.toString("count >= 0 required but it was ", paramInt2));
  }
  
  public static h a(int paramInt1, int paramInt2, Publisher... paramVarArgs)
  {
    l.b.g.b.b.a(paramVarArgs, "sources is null");
    l.b.g.b.b.a(paramInt1, "maxConcurrency");
    l.b.g.b.b.a(paramInt2, "prefetch");
    paramVarArgs = new ga(paramVarArgs);
    l.b.f.o localO = l.b.g.b.a.a;
    l.b.g.j.j localJ = l.b.g.j.j.a;
    return l.b.k.a.a((h)new y((h)paramVarArgs, localO, paramInt1, paramInt2, localJ));
  }
  
  public static h a(long paramLong1, long paramLong2)
  {
    if (paramLong2 >= 0L)
    {
      if (paramLong2 == 0L) {
        return c();
      }
      if (paramLong2 == 1L) {
        return a(Long.valueOf(paramLong1));
      }
      if ((paramLong1 > 0L) && (paramLong2 - 1L + paramLong1 < 0L)) {
        throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
      }
      return l.b.k.a.a((h)new Ra(paramLong1, paramLong2));
    }
    throw new IllegalArgumentException(StringBuilder.get("count >= 0 required but it was ", paramLong2));
  }
  
  public static h a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, TimeUnit paramTimeUnit, G paramG)
  {
    if (paramLong2 >= 0L)
    {
      if (paramLong2 == 0L) {
        return c().b(paramLong3, paramTimeUnit, paramG);
      }
      paramLong2 = paramLong2 - 1L + paramLong1;
      if ((paramLong1 > 0L) && (paramLong2 < 0L)) {
        throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
      }
      l.b.g.b.b.a(paramTimeUnit, "unit is null");
      l.b.g.b.b.a(paramG, "scheduler is null");
      return l.b.k.a.a((h)new ua(paramLong1, paramLong2, Math.max(0L, paramLong3), Math.max(0L, paramLong4), paramTimeUnit, paramG));
    }
    throw new IllegalArgumentException(StringBuilder.get("count >= 0 required but it was ", paramLong2));
  }
  
  public static h a(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, G paramG)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((h)new ta(Math.max(0L, paramLong1), Math.max(0L, paramLong2), paramTimeUnit, paramG));
  }
  
  private h a(long paramLong, TimeUnit paramTimeUnit, Publisher paramPublisher, G paramG)
  {
    l.b.g.b.b.a(paramTimeUnit, "timeUnit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((h)new Hb(this, paramLong, paramTimeUnit, paramG, paramPublisher));
  }
  
  public static h a(Iterable paramIterable)
  {
    l.b.g.b.b.a(paramIterable, "source is null");
    return l.b.k.a.a((h)new ja(paramIterable));
  }
  
  public static h a(Iterable paramIterable, int paramInt)
  {
    return a(paramIterable).b(l.b.g.b.a.a, paramInt);
  }
  
  public static h a(Iterable paramIterable, int paramInt1, int paramInt2)
  {
    l.b.g.b.b.a(paramIterable, "sources is null");
    l.b.g.b.b.a(paramInt1, "maxConcurrency");
    l.b.g.b.b.a(paramInt2, "prefetch");
    paramIterable = new ja(paramIterable);
    l.b.f.o localO = l.b.g.b.a.a;
    l.b.g.j.j localJ = l.b.g.j.j.a;
    return l.b.k.a.a((h)new y((h)paramIterable, localO, paramInt1, paramInt2, localJ));
  }
  
  public static h a(Iterable paramIterable, l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "zipper is null");
    l.b.g.b.b.a(paramIterable, "sources is null");
    return l.b.k.a.a((h)new Ub(null, paramIterable, paramO, a, false));
  }
  
  public static h a(Iterable paramIterable, l.b.f.o paramO, int paramInt)
  {
    l.b.g.b.b.a(paramIterable, "sources is null");
    l.b.g.b.b.a(paramO, "combiner is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return l.b.k.a.a((h)new l.b.g.e.b.u(paramIterable, paramO, paramInt, false));
  }
  
  public static h a(Iterable paramIterable, l.b.f.o paramO, boolean paramBoolean, int paramInt)
  {
    l.b.g.b.b.a(paramO, "zipper is null");
    l.b.g.b.b.a(paramIterable, "sources is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return l.b.k.a.a((h)new Ub(null, paramIterable, paramO, paramInt, paramBoolean));
  }
  
  public static h a(Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "item is null");
    return l.b.k.a.a((h)new wa(paramObject));
  }
  
  public static h a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    l.b.g.b.b.a(paramObject1, "The first item is null");
    l.b.g.b.b.a(paramObject2, "The second item is null");
    l.b.g.b.b.a(paramObject3, "The third item is null");
    l.b.g.b.b.a(paramObject4, "The fourth item is null");
    l.b.g.b.b.a(paramObject5, "The fifth item is null");
    return a(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5 });
  }
  
  public static h a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    l.b.g.b.b.a(paramObject1, "The first item is null");
    l.b.g.b.b.a(paramObject2, "The second item is null");
    l.b.g.b.b.a(paramObject3, "The third item is null");
    l.b.g.b.b.a(paramObject4, "The fourth item is null");
    l.b.g.b.b.a(paramObject5, "The fifth item is null");
    l.b.g.b.b.a(paramObject6, "The sixth item is null");
    return a(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6 });
  }
  
  public static h a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7)
  {
    l.b.g.b.b.a(paramObject1, "The first item is null");
    l.b.g.b.b.a(paramObject2, "The second item is null");
    l.b.g.b.b.a(paramObject3, "The third item is null");
    l.b.g.b.b.a(paramObject4, "The fourth item is null");
    l.b.g.b.b.a(paramObject5, "The fifth item is null");
    l.b.g.b.b.a(paramObject6, "The sixth item is null");
    l.b.g.b.b.a(paramObject7, "The seventh item is null");
    return a(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7 });
  }
  
  public static h a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8)
  {
    l.b.g.b.b.a(paramObject1, "The first item is null");
    l.b.g.b.b.a(paramObject2, "The second item is null");
    l.b.g.b.b.a(paramObject3, "The third item is null");
    l.b.g.b.b.a(paramObject4, "The fourth item is null");
    l.b.g.b.b.a(paramObject5, "The fifth item is null");
    l.b.g.b.b.a(paramObject6, "The sixth item is null");
    l.b.g.b.b.a(paramObject7, "The seventh item is null");
    l.b.g.b.b.a(paramObject8, "The eighth item is null");
    return a(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7, paramObject8 });
  }
  
  public static h a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8, Object paramObject9)
  {
    l.b.g.b.b.a(paramObject1, "The first item is null");
    l.b.g.b.b.a(paramObject2, "The second item is null");
    l.b.g.b.b.a(paramObject3, "The third item is null");
    l.b.g.b.b.a(paramObject4, "The fourth item is null");
    l.b.g.b.b.a(paramObject5, "The fifth item is null");
    l.b.g.b.b.a(paramObject6, "The sixth item is null");
    l.b.g.b.b.a(paramObject7, "The seventh item is null");
    l.b.g.b.b.a(paramObject8, "The eighth item is null");
    l.b.g.b.b.a(paramObject9, "The ninth is null");
    return a(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7, paramObject8, paramObject9 });
  }
  
  public static h a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8, Object paramObject9, Object paramObject10)
  {
    l.b.g.b.b.a(paramObject1, "The first item is null");
    l.b.g.b.b.a(paramObject2, "The second item is null");
    l.b.g.b.b.a(paramObject3, "The third item is null");
    l.b.g.b.b.a(paramObject4, "The fourth item is null");
    l.b.g.b.b.a(paramObject5, "The fifth item is null");
    l.b.g.b.b.a(paramObject6, "The sixth item is null");
    l.b.g.b.b.a(paramObject7, "The seventh item is null");
    l.b.g.b.b.a(paramObject8, "The eighth item is null");
    l.b.g.b.b.a(paramObject9, "The ninth item is null");
    l.b.g.b.b.a(paramObject10, "The tenth item is null");
    return a(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7, paramObject8, paramObject9, paramObject10 });
  }
  
  public static h a(Callable paramCallable)
  {
    l.b.g.b.b.a(paramCallable, "errorSupplier is null");
    return l.b.k.a.a((h)new X(paramCallable));
  }
  
  public static h a(Callable paramCallable, l.b.f.b paramB, l.b.f.g paramG)
  {
    l.b.g.b.b.a(paramB, "generator is null");
    return a(paramCallable, new sa.j(paramB), paramG);
  }
  
  public static h a(Callable paramCallable, l.b.f.c paramC)
  {
    return a(paramCallable, paramC, l.b.g.b.a.d);
  }
  
  public static h a(Callable paramCallable, l.b.f.c paramC, l.b.f.g paramG)
  {
    l.b.g.b.b.a(paramCallable, "initialState is null");
    l.b.g.b.b.a(paramC, "generator is null");
    l.b.g.b.b.a(paramG, "disposeState is null");
    return l.b.k.a.a((h)new ma(paramCallable, paramC, paramG));
  }
  
  public static h a(Callable paramCallable, l.b.f.o paramO, l.b.f.g paramG)
  {
    return a(paramCallable, paramO, paramG, true);
  }
  
  public static h a(Callable paramCallable, l.b.f.o paramO, l.b.f.g paramG, boolean paramBoolean)
  {
    l.b.g.b.b.a(paramCallable, "resourceSupplier is null");
    l.b.g.b.b.a(paramO, "sourceSupplier is null");
    l.b.g.b.b.a(paramG, "disposer is null");
    return l.b.k.a.a((h)new Mb(paramCallable, paramO, paramG, paramBoolean));
  }
  
  public static h a(Future paramFuture)
  {
    l.b.g.b.b.a(paramFuture, "future is null");
    return l.b.k.a.a((h)new ia(paramFuture, 0L, null));
  }
  
  public static h a(Future paramFuture, long paramLong, TimeUnit paramTimeUnit)
  {
    l.b.g.b.b.a(paramFuture, "future is null");
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    return l.b.k.a.a((h)new ia(paramFuture, paramLong, paramTimeUnit));
  }
  
  public static h a(Future paramFuture, long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    l.b.g.b.b.a(paramG, "scheduler is null");
    return a(paramFuture, paramLong, paramTimeUnit).a(paramG);
  }
  
  public static h a(l.b.f.g paramG)
  {
    l.b.g.b.b.a(paramG, "generator is null");
    return a(l.b.g.b.a.j, new sa.k(paramG), l.b.g.b.a.d);
  }
  
  private h a(l.b.f.g paramG1, l.b.f.g paramG2, l.b.f.a paramA1, l.b.f.a paramA2)
  {
    l.b.g.b.b.a(paramG1, "onNext is null");
    l.b.g.b.b.a(paramG2, "onError is null");
    l.b.g.b.b.a(paramA1, "onComplete is null");
    l.b.g.b.b.a(paramA2, "onAfterTerminate is null");
    return l.b.k.a.a((h)new Q(this, paramG1, paramG2, paramA1, paramA2));
  }
  
  public static h a(l.b.f.o paramO, int paramInt, Publisher... paramVarArgs)
  {
    return c(paramVarArgs, paramO, paramInt);
  }
  
  public static h a(l.b.f.o paramO, boolean paramBoolean, int paramInt, Publisher... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return c();
    }
    l.b.g.b.b.a(paramO, "zipper is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return l.b.k.a.a((h)new Ub(paramVarArgs, null, paramO, paramInt, paramBoolean));
  }
  
  public static h a(l.b.f.o paramO, Publisher... paramVarArgs)
  {
    return a(paramVarArgs, paramO, a);
  }
  
  public static h a(m paramM, b paramB)
  {
    l.b.g.b.b.a(paramM, "source is null");
    l.b.g.b.b.a(paramB, "mode is null");
    return l.b.k.a.a((h)new E(paramM, paramB));
  }
  
  public static h a(Publisher paramPublisher)
  {
    if ((paramPublisher instanceof h)) {
      return l.b.k.a.a((h)paramPublisher);
    }
    l.b.g.b.b.a(paramPublisher, "publisher is null");
    return l.b.k.a.a((h)new la(paramPublisher));
  }
  
  public static h a(Publisher paramPublisher, int paramInt)
  {
    return a(paramPublisher).b(l.b.g.b.a.a, paramInt);
  }
  
  public static h a(Publisher paramPublisher, int paramInt1, int paramInt2)
  {
    l.b.g.b.b.a(paramPublisher, "sources is null");
    l.b.g.b.b.a(paramInt1, "maxConcurrency");
    l.b.g.b.b.a(paramInt2, "prefetch");
    return l.b.k.a.a((h)new z(paramPublisher, l.b.g.b.a.a, paramInt1, paramInt2, l.b.g.j.j.a));
  }
  
  public static h a(Publisher paramPublisher, int paramInt, boolean paramBoolean)
  {
    return a(paramPublisher).a(l.b.g.b.a.a, paramInt, paramBoolean);
  }
  
  public static h a(Publisher paramPublisher, l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "zipper is null");
    return a(paramPublisher).b().putShort(new sa.p(paramO));
  }
  
  private h a(Publisher paramPublisher1, l.b.f.o paramO, Publisher paramPublisher2)
  {
    l.b.g.b.b.a(paramO, "itemTimeoutIndicator is null");
    return l.b.k.a.a((h)new Gb(this, paramPublisher1, paramO, paramPublisher2));
  }
  
  public static h a(Publisher paramPublisher1, Publisher paramPublisher2)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    return a(new Publisher[] { paramPublisher1, paramPublisher2 }).a(l.b.g.b.a.a, true, 2);
  }
  
  public static h a(Publisher paramPublisher1, Publisher paramPublisher2, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    return a(l.b.g.b.a.a(paramC), new Publisher[] { paramPublisher1, paramPublisher2 });
  }
  
  public static h a(Publisher paramPublisher1, Publisher paramPublisher2, l.b.f.c paramC, boolean paramBoolean)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    return a(l.b.g.b.a.a(paramC), paramBoolean, a, new Publisher[] { paramPublisher1, paramPublisher2 });
  }
  
  public static h a(Publisher paramPublisher1, Publisher paramPublisher2, l.b.f.c paramC, boolean paramBoolean, int paramInt)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    return a(l.b.g.b.a.a(paramC), paramBoolean, paramInt, new Publisher[] { paramPublisher1, paramPublisher2 });
  }
  
  public static h a(Publisher paramPublisher1, Publisher paramPublisher2, Publisher paramPublisher3)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    l.b.g.b.b.a(paramPublisher3, "source3 is null");
    return a(new Publisher[] { paramPublisher1, paramPublisher2, paramPublisher3 }).a(l.b.g.b.a.a, false, 3);
  }
  
  public static h a(Publisher paramPublisher1, Publisher paramPublisher2, Publisher paramPublisher3, l.b.f.h paramH)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    l.b.g.b.b.a(paramPublisher3, "source3 is null");
    return a(l.b.g.b.a.a(paramH), new Publisher[] { paramPublisher1, paramPublisher2, paramPublisher3 });
  }
  
  public static h a(Publisher paramPublisher1, Publisher paramPublisher2, Publisher paramPublisher3, Publisher paramPublisher4)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    l.b.g.b.b.a(paramPublisher3, "source3 is null");
    l.b.g.b.b.a(paramPublisher4, "source4 is null");
    return a(new Publisher[] { paramPublisher1, paramPublisher2, paramPublisher3, paramPublisher4 }).a(l.b.g.b.a.a, false, 4);
  }
  
  public static h a(Publisher paramPublisher1, Publisher paramPublisher2, Publisher paramPublisher3, Publisher paramPublisher4, i paramI)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    l.b.g.b.b.a(paramPublisher3, "source3 is null");
    l.b.g.b.b.a(paramPublisher4, "source4 is null");
    return a(l.b.g.b.a.a(paramI), new Publisher[] { paramPublisher1, paramPublisher2, paramPublisher3, paramPublisher4 });
  }
  
  public static h a(Publisher paramPublisher1, Publisher paramPublisher2, Publisher paramPublisher3, Publisher paramPublisher4, Publisher paramPublisher5, l.b.f.j paramJ)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    l.b.g.b.b.a(paramPublisher3, "source3 is null");
    l.b.g.b.b.a(paramPublisher4, "source4 is null");
    l.b.g.b.b.a(paramPublisher5, "source5 is null");
    return a(l.b.g.b.a.a(paramJ), new Publisher[] { paramPublisher1, paramPublisher2, paramPublisher3, paramPublisher4, paramPublisher5 });
  }
  
  public static h a(Publisher paramPublisher1, Publisher paramPublisher2, Publisher paramPublisher3, Publisher paramPublisher4, Publisher paramPublisher5, Publisher paramPublisher6, l.b.f.k paramK)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    l.b.g.b.b.a(paramPublisher3, "source3 is null");
    l.b.g.b.b.a(paramPublisher4, "source4 is null");
    l.b.g.b.b.a(paramPublisher5, "source5 is null");
    l.b.g.b.b.a(paramPublisher6, "source6 is null");
    return a(l.b.g.b.a.a(paramK), new Publisher[] { paramPublisher1, paramPublisher2, paramPublisher3, paramPublisher4, paramPublisher5, paramPublisher6 });
  }
  
  public static h a(Publisher paramPublisher1, Publisher paramPublisher2, Publisher paramPublisher3, Publisher paramPublisher4, Publisher paramPublisher5, Publisher paramPublisher6, Publisher paramPublisher7, l.b.f.l paramL)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    l.b.g.b.b.a(paramPublisher3, "source3 is null");
    l.b.g.b.b.a(paramPublisher4, "source4 is null");
    l.b.g.b.b.a(paramPublisher5, "source5 is null");
    l.b.g.b.b.a(paramPublisher6, "source6 is null");
    l.b.g.b.b.a(paramPublisher7, "source7 is null");
    return a(l.b.g.b.a.a(paramL), new Publisher[] { paramPublisher1, paramPublisher2, paramPublisher3, paramPublisher4, paramPublisher5, paramPublisher6, paramPublisher7 });
  }
  
  public static h a(Publisher paramPublisher1, Publisher paramPublisher2, Publisher paramPublisher3, Publisher paramPublisher4, Publisher paramPublisher5, Publisher paramPublisher6, Publisher paramPublisher7, Publisher paramPublisher8, l.b.f.m paramM)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    l.b.g.b.b.a(paramPublisher3, "source3 is null");
    l.b.g.b.b.a(paramPublisher4, "source4 is null");
    l.b.g.b.b.a(paramPublisher5, "source5 is null");
    l.b.g.b.b.a(paramPublisher6, "source6 is null");
    l.b.g.b.b.a(paramPublisher7, "source7 is null");
    l.b.g.b.b.a(paramPublisher8, "source8 is null");
    return a(l.b.g.b.a.a(paramM), new Publisher[] { paramPublisher1, paramPublisher2, paramPublisher3, paramPublisher4, paramPublisher5, paramPublisher6, paramPublisher7, paramPublisher8 });
  }
  
  public static h a(Publisher paramPublisher1, Publisher paramPublisher2, Publisher paramPublisher3, Publisher paramPublisher4, Publisher paramPublisher5, Publisher paramPublisher6, Publisher paramPublisher7, Publisher paramPublisher8, Publisher paramPublisher9, l.b.f.n paramN)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    l.b.g.b.b.a(paramPublisher3, "source3 is null");
    l.b.g.b.b.a(paramPublisher4, "source4 is null");
    l.b.g.b.b.a(paramPublisher5, "source5 is null");
    l.b.g.b.b.a(paramPublisher6, "source6 is null");
    l.b.g.b.b.a(paramPublisher7, "source7 is null");
    l.b.g.b.b.a(paramPublisher8, "source8 is null");
    l.b.g.b.b.a(paramPublisher9, "source9 is null");
    return a(l.b.g.b.a.a(paramN), new Publisher[] { paramPublisher1, paramPublisher2, paramPublisher3, paramPublisher4, paramPublisher5, paramPublisher6, paramPublisher7, paramPublisher8, paramPublisher9 });
  }
  
  public static h a(Object... paramVarArgs)
  {
    l.b.g.b.b.a(paramVarArgs, "items is null");
    if (paramVarArgs.length == 0) {
      return c();
    }
    if (paramVarArgs.length == 1) {
      return a(paramVarArgs[0]);
    }
    return l.b.k.a.a((h)new ga(paramVarArgs));
  }
  
  public static h a(Publisher... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return c();
    }
    if (paramVarArgs.length == 1) {
      return a(paramVarArgs[0]);
    }
    return l.b.k.a.a((h)new v(paramVarArgs, false));
  }
  
  public static h a(Publisher[] paramArrayOfPublisher, l.b.f.o paramO, int paramInt)
  {
    l.b.g.b.b.a(paramArrayOfPublisher, "sources is null");
    if (paramArrayOfPublisher.length == 0) {
      return c();
    }
    l.b.g.b.b.a(paramO, "combiner is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return l.b.k.a.a((h)new l.b.g.e.b.u(paramArrayOfPublisher, paramO, paramInt, false));
  }
  
  public static h add(long paramLong, TimeUnit paramTimeUnit)
  {
    return add(paramLong, paramTimeUnit, l.b.m.a.a());
  }
  
  public static h add(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((h)new Ib(Math.max(0L, paramLong), paramTimeUnit, paramG));
  }
  
  public static ExtensionData b(Publisher paramPublisher1, Publisher paramPublisher2, l.b.f.d paramD)
  {
    return a(paramPublisher1, paramPublisher2, paramD, a);
  }
  
  public static h b(int paramInt1, int paramInt2, Publisher... paramVarArgs)
  {
    return a(paramVarArgs).a(l.b.g.b.a.a, false, paramInt1, paramInt2);
  }
  
  public static h b(Iterable paramIterable)
  {
    l.b.g.b.b.a(paramIterable, "sources is null");
    return a(paramIterable).a(l.b.g.b.a.a, 2, false);
  }
  
  public static h b(Iterable paramIterable, int paramInt1, int paramInt2)
  {
    return a(paramIterable).a(l.b.g.b.a.a, false, paramInt1, paramInt2);
  }
  
  public static h b(Iterable paramIterable, l.b.f.o paramO)
  {
    return c(paramIterable, paramO, a);
  }
  
  public static h b(Publisher paramPublisher)
  {
    return a(paramPublisher, a);
  }
  
  public static h b(Publisher paramPublisher, int paramInt)
  {
    return a(paramPublisher).a(l.b.g.b.a.a, paramInt);
  }
  
  public static h b(Publisher paramPublisher1, Publisher paramPublisher2)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    return a(new Publisher[] { paramPublisher1, paramPublisher2 }).a(l.b.g.b.a.a, false, 2);
  }
  
  public static h b(Publisher paramPublisher1, Publisher paramPublisher2, Publisher paramPublisher3)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    l.b.g.b.b.a(paramPublisher3, "source3 is null");
    return a(new Publisher[] { paramPublisher1, paramPublisher2, paramPublisher3 }).a(l.b.g.b.a.a, true, 3);
  }
  
  public static h b(Publisher paramPublisher1, Publisher paramPublisher2, Publisher paramPublisher3, Publisher paramPublisher4)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    l.b.g.b.b.a(paramPublisher3, "source3 is null");
    l.b.g.b.b.a(paramPublisher4, "source4 is null");
    return a(new Publisher[] { paramPublisher1, paramPublisher2, paramPublisher3, paramPublisher4 }).a(l.b.g.b.a.a, true, 4);
  }
  
  public static h b(Publisher paramPublisher1, Publisher paramPublisher2, Publisher paramPublisher3, Publisher paramPublisher4, Publisher paramPublisher5, Publisher paramPublisher6, Publisher paramPublisher7, l.b.f.l paramL)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    l.b.g.b.b.a(paramPublisher3, "source3 is null");
    l.b.g.b.b.a(paramPublisher4, "source4 is null");
    l.b.g.b.b.a(paramPublisher5, "source5 is null");
    l.b.g.b.b.a(paramPublisher6, "source6 is null");
    l.b.g.b.b.a(paramPublisher7, "source7 is null");
    return a(l.b.g.b.a.a(paramL), false, a, new Publisher[] { paramPublisher1, paramPublisher2, paramPublisher3, paramPublisher4, paramPublisher5, paramPublisher6, paramPublisher7 });
  }
  
  public static h b(Publisher... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return c();
    }
    if (paramVarArgs.length == 1) {
      return a(paramVarArgs[0]);
    }
    return l.b.k.a.a((h)new v(paramVarArgs, true));
  }
  
  public static h b(Publisher[] paramArrayOfPublisher, l.b.f.o paramO)
  {
    return c(paramArrayOfPublisher, paramO, a);
  }
  
  public static h c()
  {
    return l.b.k.a.a(W.b);
  }
  
  public static h c(int paramInt1, int paramInt2, Publisher... paramVarArgs)
  {
    return a(paramVarArgs).a(l.b.g.b.a.a, true, paramInt1, paramInt2);
  }
  
  public static h c(long paramLong1, long paramLong2, long paramLong3, long paramLong4, TimeUnit paramTimeUnit)
  {
    return a(paramLong1, paramLong2, paramLong3, paramLong4, paramTimeUnit, l.b.m.a.a());
  }
  
  public static h c(Iterable paramIterable)
  {
    l.b.g.b.b.a(paramIterable, "sources is null");
    return a(paramIterable).c(l.b.g.b.a.a);
  }
  
  public static h c(Iterable paramIterable, int paramInt)
  {
    return a(paramIterable).a(l.b.g.b.a.a, true, paramInt);
  }
  
  public static h c(Iterable paramIterable, int paramInt1, int paramInt2)
  {
    return a(paramIterable).a(l.b.g.b.a.a, true, paramInt1, paramInt2);
  }
  
  public static h c(Iterable paramIterable, l.b.f.o paramO, int paramInt)
  {
    l.b.g.b.b.a(paramIterable, "sources is null");
    l.b.g.b.b.a(paramO, "combiner is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return l.b.k.a.a((h)new l.b.g.e.b.u(paramIterable, paramO, paramInt, true));
  }
  
  public static h c(Object paramObject1, Object paramObject2)
  {
    l.b.g.b.b.a(paramObject1, "The first item is null");
    l.b.g.b.b.a(paramObject2, "The second item is null");
    return a(new Object[] { paramObject1, paramObject2 });
  }
  
  public static h c(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    l.b.g.b.b.a(paramObject1, "The first item is null");
    l.b.g.b.b.a(paramObject2, "The second item is null");
    l.b.g.b.b.a(paramObject3, "The third item is null");
    return a(new Object[] { paramObject1, paramObject2, paramObject3 });
  }
  
  public static h c(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    l.b.g.b.b.a(paramObject1, "The first item is null");
    l.b.g.b.b.a(paramObject2, "The second item is null");
    l.b.g.b.b.a(paramObject3, "The third item is null");
    l.b.g.b.b.a(paramObject4, "The fourth item is null");
    return a(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 });
  }
  
  public static h c(Throwable paramThrowable)
  {
    l.b.g.b.b.a(paramThrowable, "throwable is null");
    return a(l.b.g.b.a.b(paramThrowable));
  }
  
  public static h c(Callable paramCallable)
  {
    l.b.g.b.b.a(paramCallable, "supplier is null");
    return l.b.k.a.a((h)new H(paramCallable));
  }
  
  public static h c(Callable paramCallable, l.b.f.b paramB)
  {
    l.b.g.b.b.a(paramB, "generator is null");
    return a(paramCallable, new sa.j(paramB), l.b.g.b.a.d);
  }
  
  public static h c(Future paramFuture, G paramG)
  {
    l.b.g.b.b.a(paramG, "scheduler is null");
    return a(paramFuture).a(paramG);
  }
  
  public static h c(l.b.f.o paramO, Publisher... paramVarArgs)
  {
    return c(paramVarArgs, paramO, a);
  }
  
  public static h c(Publisher paramPublisher1, Publisher paramPublisher2)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    return a(new Publisher[] { paramPublisher1, paramPublisher2 });
  }
  
  public static h c(Publisher paramPublisher1, Publisher paramPublisher2, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    return a(l.b.g.b.a.a(paramC), false, a, new Publisher[] { paramPublisher1, paramPublisher2 });
  }
  
  public static h c(Publisher paramPublisher1, Publisher paramPublisher2, Publisher paramPublisher3)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    l.b.g.b.b.a(paramPublisher3, "source3 is null");
    return a(new Publisher[] { paramPublisher1, paramPublisher2, paramPublisher3 });
  }
  
  public static h c(Publisher paramPublisher1, Publisher paramPublisher2, Publisher paramPublisher3, l.b.f.h paramH)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    l.b.g.b.b.a(paramPublisher3, "source3 is null");
    return a(l.b.g.b.a.a(paramH), false, a, new Publisher[] { paramPublisher1, paramPublisher2, paramPublisher3 });
  }
  
  public static h c(Publisher paramPublisher1, Publisher paramPublisher2, Publisher paramPublisher3, Publisher paramPublisher4)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    l.b.g.b.b.a(paramPublisher3, "source3 is null");
    l.b.g.b.b.a(paramPublisher4, "source4 is null");
    return a(new Publisher[] { paramPublisher1, paramPublisher2, paramPublisher3, paramPublisher4 });
  }
  
  public static h c(Publisher paramPublisher1, Publisher paramPublisher2, Publisher paramPublisher3, Publisher paramPublisher4, i paramI)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    l.b.g.b.b.a(paramPublisher3, "source3 is null");
    l.b.g.b.b.a(paramPublisher4, "source4 is null");
    return a(l.b.g.b.a.a(paramI), false, a, new Publisher[] { paramPublisher1, paramPublisher2, paramPublisher3, paramPublisher4 });
  }
  
  public static h c(Publisher paramPublisher1, Publisher paramPublisher2, Publisher paramPublisher3, Publisher paramPublisher4, Publisher paramPublisher5, l.b.f.j paramJ)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    l.b.g.b.b.a(paramPublisher3, "source3 is null");
    l.b.g.b.b.a(paramPublisher4, "source4 is null");
    l.b.g.b.b.a(paramPublisher5, "source5 is null");
    return a(l.b.g.b.a.a(paramJ), false, a, new Publisher[] { paramPublisher1, paramPublisher2, paramPublisher3, paramPublisher4, paramPublisher5 });
  }
  
  public static h c(Publisher paramPublisher1, Publisher paramPublisher2, Publisher paramPublisher3, Publisher paramPublisher4, Publisher paramPublisher5, Publisher paramPublisher6, l.b.f.k paramK)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    l.b.g.b.b.a(paramPublisher3, "source3 is null");
    l.b.g.b.b.a(paramPublisher4, "source4 is null");
    l.b.g.b.b.a(paramPublisher5, "source5 is null");
    l.b.g.b.b.a(paramPublisher6, "source6 is null");
    return a(l.b.g.b.a.a(paramK), false, a, new Publisher[] { paramPublisher1, paramPublisher2, paramPublisher3, paramPublisher4, paramPublisher5, paramPublisher6 });
  }
  
  public static h c(Publisher paramPublisher1, Publisher paramPublisher2, Publisher paramPublisher3, Publisher paramPublisher4, Publisher paramPublisher5, Publisher paramPublisher6, Publisher paramPublisher7, Publisher paramPublisher8, l.b.f.m paramM)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    l.b.g.b.b.a(paramPublisher3, "source3 is null");
    l.b.g.b.b.a(paramPublisher4, "source4 is null");
    l.b.g.b.b.a(paramPublisher5, "source5 is null");
    l.b.g.b.b.a(paramPublisher6, "source6 is null");
    l.b.g.b.b.a(paramPublisher7, "source7 is null");
    l.b.g.b.b.a(paramPublisher8, "source8 is null");
    return a(l.b.g.b.a.a(paramM), false, a, new Publisher[] { paramPublisher1, paramPublisher2, paramPublisher3, paramPublisher4, paramPublisher5, paramPublisher6, paramPublisher7, paramPublisher8 });
  }
  
  public static h c(Publisher paramPublisher1, Publisher paramPublisher2, Publisher paramPublisher3, Publisher paramPublisher4, Publisher paramPublisher5, Publisher paramPublisher6, Publisher paramPublisher7, Publisher paramPublisher8, Publisher paramPublisher9, l.b.f.n paramN)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    l.b.g.b.b.a(paramPublisher3, "source3 is null");
    l.b.g.b.b.a(paramPublisher4, "source4 is null");
    l.b.g.b.b.a(paramPublisher5, "source5 is null");
    l.b.g.b.b.a(paramPublisher6, "source6 is null");
    l.b.g.b.b.a(paramPublisher7, "source7 is null");
    l.b.g.b.b.a(paramPublisher8, "source8 is null");
    l.b.g.b.b.a(paramPublisher9, "source9 is null");
    return a(l.b.g.b.a.a(paramN), false, a, new Publisher[] { paramPublisher1, paramPublisher2, paramPublisher3, paramPublisher4, paramPublisher5, paramPublisher6, paramPublisher7, paramPublisher8, paramPublisher9 });
  }
  
  public static h c(Publisher... paramVarArgs)
  {
    l.b.g.b.b.a(paramVarArgs, "sources is null");
    int i = paramVarArgs.length;
    if (i == 0) {
      return c();
    }
    if (i == 1) {
      return a(paramVarArgs[0]);
    }
    return l.b.k.a.a((h)new l.b.g.e.b.h(paramVarArgs, null));
  }
  
  public static h c(Publisher[] paramArrayOfPublisher, l.b.f.o paramO)
  {
    return a(paramArrayOfPublisher, paramO, a);
  }
  
  public static h c(Publisher[] paramArrayOfPublisher, l.b.f.o paramO, int paramInt)
  {
    l.b.g.b.b.a(paramArrayOfPublisher, "sources is null");
    l.b.g.b.b.a(paramO, "combiner is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    if (paramArrayOfPublisher.length == 0) {
      return c();
    }
    return l.b.k.a.a((h)new l.b.g.e.b.u(paramArrayOfPublisher, paramO, paramInt, true));
  }
  
  public static h collapseActionView(Publisher paramPublisher)
  {
    return d(paramPublisher, a);
  }
  
  public static ExtensionData d(Publisher paramPublisher1, Publisher paramPublisher2)
  {
    return a(paramPublisher1, paramPublisher2, l.b.g.b.b.a, a);
  }
  
  public static h d(Iterable paramIterable)
  {
    int i = a;
    return a(paramIterable, i, i);
  }
  
  public static h d(Iterable paramIterable, l.b.f.o paramO)
  {
    return a(paramIterable, paramO, a);
  }
  
  public static h d(Publisher paramPublisher)
  {
    int i = a;
    return a(paramPublisher, i, i);
  }
  
  public static h d(Publisher paramPublisher, int paramInt)
  {
    return a(paramPublisher).a(l.b.g.b.a.a, true, paramInt);
  }
  
  public static h d(Publisher... paramVarArgs)
  {
    int i = a;
    return a(i, i, paramVarArgs);
  }
  
  public static h f(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return a(paramLong, paramLong, paramTimeUnit, paramG);
  }
  
  public static h f(Publisher paramPublisher)
  {
    return f(paramPublisher, a);
  }
  
  public static h f(Publisher paramPublisher, int paramInt)
  {
    return a(paramPublisher).f(l.b.g.b.a.a, paramInt);
  }
  
  public static h findItem(long paramLong, TimeUnit paramTimeUnit)
  {
    return a(paramLong, paramLong, paramTimeUnit, l.b.m.a.a());
  }
  
  public static h getActionView()
  {
    return l.b.k.a.a(Ea.b);
  }
  
  public static h getPixelValue(Callable paramCallable)
  {
    l.b.g.b.b.a(paramCallable, "supplier is null");
    return l.b.k.a.a((h)new ha(paramCallable));
  }
  
  public static h i(Iterable paramIterable)
  {
    l.b.g.b.b.a(paramIterable, "sources is null");
    return l.b.k.a.a((h)new l.b.g.e.b.h(null, paramIterable));
  }
  
  public static int m()
  {
    return a;
  }
  
  public static h onCreate(Publisher paramPublisher)
  {
    l.b.g.b.b.a(paramPublisher, "onSubscribe is null");
    if (!(paramPublisher instanceof h)) {
      return l.b.k.a.a((h)new la(paramPublisher));
    }
    throw new IllegalArgumentException("unsafeCreate(Flowable) should be upgraded");
  }
  
  public static h setActionView(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return a(paramLong1, paramLong2, paramTimeUnit, l.b.m.a.a());
  }
  
  public static h setChecked(Iterable paramIterable)
  {
    return a(paramIterable).putShort(l.b.g.b.a.a);
  }
  
  public static h setChecked(Publisher paramPublisher)
  {
    return b(paramPublisher, a);
  }
  
  public static h setChecked(Publisher paramPublisher, int paramInt)
  {
    return a(paramPublisher).setChecked(l.b.g.b.a.a, paramInt);
  }
  
  public static h setChecked(Publisher... paramVarArgs)
  {
    return a(paramVarArgs).b(l.b.g.b.a.a, paramVarArgs.length);
  }
  
  public static h setIcon(Publisher paramPublisher)
  {
    return a(paramPublisher).h(l.b.g.b.a.a);
  }
  
  public static h setVisible(Iterable paramIterable)
  {
    return a(paramIterable).a(l.b.g.b.a.a, true);
  }
  
  public static h setVisible(Publisher paramPublisher)
  {
    return a(paramPublisher, a, true);
  }
  
  public static h setVisible(Publisher... paramVarArgs)
  {
    return a(paramVarArgs).a(l.b.g.b.a.a, true, paramVarArgs.length);
  }
  
  public final ExtensionData a(long paramLong, Object paramObject)
  {
    if (paramLong >= 0L)
    {
      l.b.g.b.b.a(paramObject, "defaultItem is null");
      return l.b.k.a.a((ExtensionData)new V(this, paramLong, paramObject));
    }
    throw new IndexOutOfBoundsException(StringBuilder.get("index >= 0 required but it was ", paramLong));
  }
  
  public final ExtensionData a(Object paramObject, l.b.f.b paramB)
  {
    l.b.g.b.b.a(paramObject, "initialItem is null");
    return a(l.b.g.b.a.b(paramObject), paramB);
  }
  
  public final ExtensionData a(Comparator paramComparator)
  {
    l.b.g.b.b.a(paramComparator, "comparator is null");
    return b().b(l.b.g.b.a.a(paramComparator));
  }
  
  public final ExtensionData a(Comparator paramComparator, int paramInt)
  {
    l.b.g.b.b.a(paramComparator, "comparator is null");
    return b(paramInt).b(l.b.g.b.a.a(paramComparator));
  }
  
  public final ExtensionData a(Callable paramCallable, l.b.f.b paramB)
  {
    l.b.g.b.b.a(paramCallable, "initialItemSupplier is null");
    l.b.g.b.b.a(paramB, "collector is null");
    return l.b.k.a.a((ExtensionData)new t(this, paramCallable, paramB));
  }
  
  public final ExtensionData a(l.b.f.o paramO1, l.b.f.o paramO2)
  {
    l.b.g.b.b.a(paramO1, "keySelector is null");
    l.b.g.b.b.a(paramO2, "valueSelector is null");
    l.b.g.j.m localM = l.b.g.j.m.a;
    paramO1 = l.b.g.b.a.a(paramO1, paramO2);
    return a((Callable)localM, paramO1);
  }
  
  public final l.b.c.c a(l.b.f.g paramG1, l.b.f.g paramG2)
  {
    return a(paramG1, paramG2, l.b.g.b.a.c, (l.b.f.g)sa.i.a);
  }
  
  public final l.b.c.c a(l.b.f.g paramG1, l.b.f.g paramG2, l.b.f.a paramA, l.b.f.g paramG3)
  {
    l.b.g.b.b.a(paramG1, "onNext is null");
    l.b.g.b.b.a(paramG2, "onError is null");
    l.b.g.b.b.a(paramA, "onComplete is null");
    l.b.g.b.b.a(paramG3, "onSubscribe is null");
    paramG1 = new l.b.g.h.m(paramG1, paramG2, paramA, paramG3);
    a(paramG1);
    return paramG1;
  }
  
  public final l.b.c.c a(l.b.f.r paramR, l.b.f.g paramG)
  {
    return a(paramR, paramG, l.b.g.b.a.c);
  }
  
  public final l.b.c.c a(l.b.f.r paramR, l.b.f.g paramG, l.b.f.a paramA)
  {
    l.b.g.b.b.a(paramR, "onNext is null");
    l.b.g.b.b.a(paramG, "onError is null");
    l.b.g.b.b.a(paramA, "onComplete is null");
    paramR = new l.b.g.h.h(paramR, paramG, paramA);
    a(paramR);
    return paramR;
  }
  
  public final d a()
  {
    return l.b.k.a.a((d)new mb(this));
  }
  
  public final d a(l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramC, "reducer is null");
    return l.b.k.a.a((d)new Ta(this, paramC));
  }
  
  public final l.b.e.a a(int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    return a(paramInt, paramLong, paramTimeUnit, l.b.m.a.a());
  }
  
  public final l.b.e.a a(int paramInt, long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    l.b.g.b.b.a(paramInt, "bufferSize");
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return _a.a(this, paramLong, paramTimeUnit, paramG, paramInt);
  }
  
  public final l.b.e.a a(int paramInt, G paramG)
  {
    l.b.g.b.b.a(paramG, "scheduler is null");
    return _a.a(d(paramInt), paramG);
  }
  
  public final h a(int paramInt)
  {
    l.b.g.b.b.a(paramInt, "initialCapacity");
    return l.b.k.a.a((h)new l.b.g.e.b.r(this, paramInt));
  }
  
  public final h a(int paramInt1, int paramInt2, Callable paramCallable)
  {
    l.b.g.b.b.a(paramInt1, "count");
    l.b.g.b.b.a(paramInt2, "skip");
    l.b.g.b.b.a(paramCallable, "bufferSupplier is null");
    return l.b.k.a.a((h)new l.b.g.e.b.m(this, paramInt1, paramInt2, paramCallable));
  }
  
  public final h a(int paramInt, l.b.f.a paramA)
  {
    return a(paramInt, false, false, paramA);
  }
  
  public final h a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    l.b.g.b.b.a(paramInt, "bufferSize");
    return l.b.k.a.a((h)new Ga(this, paramInt, paramBoolean2, paramBoolean1, l.b.g.b.a.c));
  }
  
  public final h a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, l.b.f.a paramA)
  {
    l.b.g.b.b.a(paramA, "onOverflow is null");
    l.b.g.b.b.a(paramInt, "capacity");
    return l.b.k.a.a((h)new Ga(this, paramInt, paramBoolean2, paramBoolean1, paramA));
  }
  
  public final h a(long paramLong)
  {
    if (paramLong >= 0L) {
      return l.b.k.a.a((h)new wb(this, paramLong));
    }
    throw new IllegalArgumentException(StringBuilder.get("count >= 0 required but it was ", paramLong));
  }
  
  public final h a(long paramLong1, long paramLong2, int paramInt)
  {
    l.b.g.b.b.a(paramLong2, "skip");
    l.b.g.b.b.a(paramLong1, "count");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return l.b.k.a.a((h)new Nb(this, paramLong1, paramLong2, paramInt));
  }
  
  public final h a(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return a(paramLong1, paramLong2, paramTimeUnit, l.b.m.a.a(), (Callable)l.b.g.j.b.a);
  }
  
  public final h a(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, G paramG, int paramInt)
  {
    l.b.g.b.b.a(paramInt, "bufferSize");
    l.b.g.b.b.a(paramLong1, "timespan");
    l.b.g.b.b.a(paramLong2, "timeskip");
    l.b.g.b.b.a(paramG, "scheduler is null");
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    return l.b.k.a.a((h)new Rb(this, paramLong1, paramLong2, paramTimeUnit, paramG, Long.MAX_VALUE, paramInt, false));
  }
  
  public final h a(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, G paramG, Callable paramCallable)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    l.b.g.b.b.a(paramCallable, "bufferSupplier is null");
    return l.b.k.a.a((h)new l.b.g.e.b.q(this, paramLong1, paramLong2, paramTimeUnit, paramG, paramCallable, Integer.MAX_VALUE, false));
  }
  
  public final h a(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, G paramG, boolean paramBoolean, int paramInt)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    if (paramLong1 >= 0L) {
      return l.b.k.a.a((h)new zb(this, paramLong1, paramLong2, paramTimeUnit, paramG, paramInt, paramBoolean));
    }
    throw new IndexOutOfBoundsException(StringBuilder.get("count >= 0 required but it was ", paramLong1));
  }
  
  public final h a(long paramLong, TimeUnit paramTimeUnit)
  {
    return a(paramLong, paramTimeUnit, l.b.m.a.a(), Integer.MAX_VALUE);
  }
  
  public final h a(long paramLong, TimeUnit paramTimeUnit, int paramInt)
  {
    return a(paramLong, paramTimeUnit, l.b.m.a.a(), paramInt);
  }
  
  public final h a(long paramLong1, TimeUnit paramTimeUnit, long paramLong2)
  {
    return a(paramLong1, paramTimeUnit, l.b.m.a.a(), paramLong2, false);
  }
  
  public final h a(long paramLong1, TimeUnit paramTimeUnit, long paramLong2, boolean paramBoolean)
  {
    return a(paramLong1, paramTimeUnit, l.b.m.a.a(), paramLong2, paramBoolean);
  }
  
  public final h a(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((h)new l.b.g.e.b.G(this, paramLong, paramTimeUnit, paramG));
  }
  
  public final h a(long paramLong, TimeUnit paramTimeUnit, G paramG, int paramInt)
  {
    return a(paramLong, paramTimeUnit, paramG, paramInt, (Callable)l.b.g.j.b.a, false);
  }
  
  public final h a(long paramLong, TimeUnit paramTimeUnit, G paramG, int paramInt, Callable paramCallable, boolean paramBoolean)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    l.b.g.b.b.a(paramCallable, "bufferSupplier is null");
    l.b.g.b.b.a(paramInt, "count");
    return l.b.k.a.a((h)new l.b.g.e.b.q(this, paramLong, paramLong, paramTimeUnit, paramG, paramCallable, paramInt, paramBoolean));
  }
  
  public final h a(long paramLong1, TimeUnit paramTimeUnit, G paramG, long paramLong2)
  {
    return a(paramLong1, paramTimeUnit, paramG, paramLong2, false);
  }
  
  public final h a(long paramLong1, TimeUnit paramTimeUnit, G paramG, long paramLong2, boolean paramBoolean)
  {
    return a(paramLong1, paramTimeUnit, paramG, paramLong2, paramBoolean, a);
  }
  
  public final h a(long paramLong1, TimeUnit paramTimeUnit, G paramG, long paramLong2, boolean paramBoolean, int paramInt)
  {
    l.b.g.b.b.a(paramInt, "bufferSize");
    l.b.g.b.b.a(paramG, "scheduler is null");
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramLong2, "count");
    return l.b.k.a.a((h)new Rb(this, paramLong1, paramLong1, paramTimeUnit, paramG, paramLong2, paramInt, paramBoolean));
  }
  
  public final h a(long paramLong, TimeUnit paramTimeUnit, G paramG, Publisher paramPublisher)
  {
    l.b.g.b.b.a(paramPublisher, "other is null");
    return a(paramLong, paramTimeUnit, paramPublisher, paramG);
  }
  
  public final h a(long paramLong, TimeUnit paramTimeUnit, G paramG, boolean paramBoolean)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((h)new I(this, Math.max(0L, paramLong), paramTimeUnit, paramG, paramBoolean));
  }
  
  public final h a(long paramLong, TimeUnit paramTimeUnit, G paramG, boolean paramBoolean, int paramInt)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return l.b.k.a.a((h)new qb(this, paramLong, paramTimeUnit, paramG, paramInt << 1, paramBoolean));
  }
  
  public final h a(long paramLong, TimeUnit paramTimeUnit, Publisher paramPublisher)
  {
    l.b.g.b.b.a(paramPublisher, "other is null");
    return a(paramLong, paramTimeUnit, paramPublisher, l.b.m.a.a());
  }
  
  public final h a(long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean)
  {
    return b(paramLong, paramTimeUnit, l.b.m.a.a(), paramBoolean, a);
  }
  
  public final h a(long paramLong, l.b.f.a paramA, a paramA1)
  {
    l.b.g.b.b.a(paramA1, "strategy is null");
    l.b.g.b.b.a(paramLong, "capacity");
    return l.b.k.a.a((h)new Ia(this, paramLong, paramA, paramA1));
  }
  
  public final h a(long paramLong, l.b.f.r paramR)
  {
    if (paramLong >= 0L)
    {
      l.b.g.b.b.a(paramR, "predicate is null");
      return l.b.k.a.a((h)new bb(this, paramLong, paramR));
    }
    throw new IllegalArgumentException(StringBuilder.get("times >= 0 required but it was ", paramLong));
  }
  
  public final h a(Class paramClass)
  {
    l.b.g.b.b.a(paramClass, "clazz is null");
    return b(l.b.g.b.a.a(paramClass));
  }
  
  public final h a(Iterable paramIterable, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramIterable, "other is null");
    l.b.g.b.b.a(paramC, "zipper is null");
    return l.b.k.a.a((h)new Vb(this, paramIterable, paramC));
  }
  
  public final h a(Object paramObject, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramObject, "seed is null");
    return c(l.b.g.b.a.b(paramObject), paramC);
  }
  
  public final h a(Callable paramCallable, int paramInt)
  {
    l.b.g.b.b.a(paramCallable, "boundaryIndicatorSupplier is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return l.b.k.a.a((h)new Qb(this, paramCallable, paramInt));
  }
  
  public final h a(TimeUnit paramTimeUnit)
  {
    return b(paramTimeUnit, l.b.m.a.a());
  }
  
  public final h a(TimeUnit paramTimeUnit, G paramG)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return b(l.b.g.b.a.a(paramTimeUnit, paramG));
  }
  
  public final h a(G paramG)
  {
    l.b.g.b.b.a(paramG, "scheduler is null");
    boolean bool;
    if (!(this instanceof E)) {
      bool = true;
    } else {
      bool = false;
    }
    return c(paramG, bool);
  }
  
  public final h a(G paramG, boolean paramBoolean)
  {
    return a(paramG, paramBoolean, a);
  }
  
  public final h a(G paramG, boolean paramBoolean, int paramInt)
  {
    l.b.g.b.b.a(paramG, "scheduler is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return l.b.k.a.a((h)new Fa(this, paramG, paramBoolean, paramInt));
  }
  
  public final h a(l.b.f.a paramA)
  {
    return a(l.b.g.b.a.d, l.b.g.b.a.g, paramA);
  }
  
  public final h a(l.b.f.d paramD)
  {
    l.b.g.b.b.a(paramD, "predicate is null");
    return l.b.k.a.a((h)new ab(this, paramD));
  }
  
  public final h a(l.b.f.e paramE)
  {
    l.b.g.b.b.a(paramE, "stop is null");
    return a(Long.MAX_VALUE, l.b.g.b.a.a(paramE));
  }
  
  public final h a(l.b.f.g paramG, l.b.f.q paramQ, l.b.f.a paramA)
  {
    l.b.g.b.b.a(paramG, "onSubscribe is null");
    l.b.g.b.b.a(paramQ, "onRequest is null");
    l.b.g.b.b.a(paramA, "onCancel is null");
    return l.b.k.a.a((h)new S(this, paramG, paramQ, paramA));
  }
  
  public final h a(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "handler is null");
    return l.b.k.a.a((h)new cb(this, paramO));
  }
  
  public final h a(l.b.f.o paramO, int paramInt)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    l.b.g.b.b.a(paramInt, "prefetch");
    if ((this instanceof l.b.g.c.m))
    {
      Object localObject = ((l.b.g.c.m)this).call();
      if (localObject == null) {
        return c();
      }
      return fb.a(localObject, paramO);
    }
    return l.b.k.a.a((h)new x(this, paramO, paramInt, l.b.g.j.j.a));
  }
  
  public final h a(l.b.f.o paramO, int paramInt1, int paramInt2)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    l.b.g.b.b.a(paramInt1, "maxConcurrency");
    l.b.g.b.b.a(paramInt2, "prefetch");
    return l.b.k.a.a((h)new y(this, paramO, paramInt1, paramInt2, l.b.g.j.j.a));
  }
  
  public final h a(l.b.f.o paramO, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    l.b.g.b.b.a(paramInt1, "maxConcurrency");
    l.b.g.b.b.a(paramInt2, "prefetch");
    l.b.g.j.j localJ;
    if (paramBoolean) {
      localJ = l.b.g.j.j.c;
    } else {
      localJ = l.b.g.j.j.b;
    }
    return l.b.k.a.a((h)new y(this, paramO, paramInt1, paramInt2, localJ));
  }
  
  public final h a(l.b.f.o paramO, int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    return a(paramO, paramInt, paramLong, paramTimeUnit, l.b.m.a.a());
  }
  
  public final h a(l.b.f.o paramO, int paramInt, long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    l.b.g.b.b.a(paramO, "selector is null");
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return _a.a(sa.a(this, paramInt, paramLong, paramTimeUnit, paramG), paramO);
  }
  
  public final h a(l.b.f.o paramO, int paramInt, G paramG)
  {
    l.b.g.b.b.a(paramO, "selector is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    sa.a localA = new sa.a(this, paramInt);
    paramO = new sa.h(paramO, paramG);
    return _a.a((Callable)localA, paramO);
  }
  
  public final h a(l.b.f.o paramO, int paramInt, boolean paramBoolean)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    l.b.g.b.b.a(paramInt, "prefetch");
    Object localObject;
    if ((this instanceof l.b.g.c.m))
    {
      localObject = ((l.b.g.c.m)this).call();
      if (localObject == null) {
        return c();
      }
      return fb.a(localObject, paramO);
    }
    if (paramBoolean) {
      localObject = l.b.g.j.j.c;
    } else {
      localObject = l.b.g.j.j.b;
    }
    return l.b.k.a.a((h)new x(this, paramO, paramInt, (l.b.g.j.j)localObject));
  }
  
  public final h a(l.b.f.o paramO, long paramLong, TimeUnit paramTimeUnit)
  {
    return a(paramO, paramLong, paramTimeUnit, l.b.m.a.a());
  }
  
  public final h a(l.b.f.o paramO, long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    l.b.g.b.b.a(paramO, "selector is null");
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return _a.a(sa.a(this, paramLong, paramTimeUnit, paramG), paramO);
  }
  
  public final h a(l.b.f.o paramO, Callable paramCallable)
  {
    l.b.g.b.b.a(paramO, "keySelector is null");
    l.b.g.b.b.a(paramCallable, "collectionSupplier is null");
    return l.b.k.a.a((h)new M(this, paramO, paramCallable));
  }
  
  public final h a(l.b.f.o paramO, G paramG)
  {
    l.b.g.b.b.a(paramO, "selector is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    sa.g localG = new sa.g(this);
    paramO = new sa.h(paramO, paramG);
    return _a.a((Callable)localG, paramO);
  }
  
  public final h a(l.b.f.o paramO, l.b.f.c paramC)
  {
    int i = a;
    return a(paramO, paramC, false, i, i);
  }
  
  public final h a(l.b.f.o paramO, l.b.f.c paramC, int paramInt)
  {
    return a(paramO, paramC, false, paramInt, a);
  }
  
  public final h a(l.b.f.o paramO, l.b.f.c paramC, boolean paramBoolean)
  {
    int i = a;
    return a(paramO, paramC, paramBoolean, i, i);
  }
  
  public final h a(l.b.f.o paramO, l.b.f.c paramC, boolean paramBoolean, int paramInt)
  {
    return a(paramO, paramC, paramBoolean, paramInt, a);
  }
  
  public final h a(l.b.f.o paramO, l.b.f.c paramC, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    l.b.g.b.b.a(paramC, "combiner is null");
    l.b.g.b.b.a(paramInt1, "maxConcurrency");
    l.b.g.b.b.a(paramInt2, "bufferSize");
    return a(new sa.e(paramC, paramO), paramBoolean, paramInt1, paramInt2);
  }
  
  public final h a(l.b.f.o paramO1, l.b.f.o paramO2, Callable paramCallable)
  {
    l.b.g.b.b.a(paramO1, "onNextMapper is null");
    l.b.g.b.b.a(paramO2, "onErrorMapper is null");
    l.b.g.b.b.a(paramCallable, "onCompleteSupplier is null");
    return b((Publisher)new Ba(this, paramO1, paramO2, paramCallable));
  }
  
  public final h a(l.b.f.o paramO, h paramH)
  {
    l.b.g.b.b.a(paramH, "other is null");
    return a(null, paramO, paramH);
  }
  
  public final h a(l.b.f.o paramO, boolean paramBoolean)
  {
    int i = a;
    return a(paramO, paramBoolean, i, i);
  }
  
  public final h a(l.b.f.o paramO, boolean paramBoolean, int paramInt)
  {
    return a(paramO, paramBoolean, paramInt, a);
  }
  
  public final h a(l.b.f.o paramO, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    l.b.g.b.b.a(paramInt1, "maxConcurrency");
    l.b.g.b.b.a(paramInt2, "bufferSize");
    if ((this instanceof l.b.g.c.m))
    {
      Object localObject = ((l.b.g.c.m)this).call();
      if (localObject == null) {
        return c();
      }
      return fb.a(localObject, paramO);
    }
    return l.b.k.a.a((h)new Z(this, paramO, paramBoolean, paramInt1, paramInt2));
  }
  
  public final h a(l.b.f.q paramQ)
  {
    return a(l.b.g.b.a.d, paramQ, l.b.g.b.a.c);
  }
  
  public final h a(l.b.f.r paramR)
  {
    l.b.g.b.b.a(paramR, "predicate is null");
    return l.b.k.a.a((h)new Y(this, paramR));
  }
  
  public final h a(h paramH, l.b.f.o paramO)
  {
    return a(paramH, paramO, (Callable)l.b.g.j.b.a);
  }
  
  public final h a(h paramH, l.b.f.o paramO, Callable paramCallable)
  {
    l.b.g.b.b.a(paramH, "openingIndicator is null");
    l.b.g.b.b.a(paramO, "closingIndicator is null");
    l.b.g.b.b.a(paramCallable, "bufferSupplier is null");
    return l.b.k.a.a((h)new l.b.g.e.b.n(this, paramH, paramO, paramCallable));
  }
  
  public final h a(p paramP)
  {
    l.b.g.b.b.a(paramP, "composer is null");
    return a(((p)paramP).a(this));
  }
  
  public final h a(Publisher paramPublisher, Callable paramCallable)
  {
    l.b.g.b.b.a(paramPublisher, "boundaryIndicator is null");
    l.b.g.b.b.a(paramCallable, "bufferSupplier is null");
    return l.b.k.a.a((h)new l.b.g.e.b.p(this, paramPublisher, paramCallable));
  }
  
  public final h a(Publisher paramPublisher, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramPublisher, "other is null");
    return c(this, paramPublisher, paramC);
  }
  
  public final h a(Publisher paramPublisher, l.b.f.c paramC, boolean paramBoolean)
  {
    return a(this, paramPublisher, paramC, paramBoolean);
  }
  
  public final h a(Publisher paramPublisher, l.b.f.c paramC, boolean paramBoolean, int paramInt)
  {
    return a(this, paramPublisher, paramC, paramBoolean, paramInt);
  }
  
  public final h a(Publisher paramPublisher, l.b.f.o paramO, int paramInt)
  {
    l.b.g.b.b.a(paramPublisher, "openingIndicator is null");
    l.b.g.b.b.a(paramO, "closingIndicator is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return l.b.k.a.a((h)new Pb(this, paramPublisher, paramO, paramInt));
  }
  
  public final h a(Publisher paramPublisher, l.b.f.o paramO1, l.b.f.o paramO2, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramPublisher, "other is null");
    l.b.g.b.b.a(paramO1, "leftEnd is null");
    l.b.g.b.b.a(paramO2, "rightEnd is null");
    l.b.g.b.b.a(paramC, "resultSelector is null");
    return l.b.k.a.a((h)new oa(this, paramPublisher, paramO1, paramO2, paramC));
  }
  
  public final h a(Publisher paramPublisher1, Publisher paramPublisher2, Publisher paramPublisher3, i paramI)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    l.b.g.b.b.a(paramPublisher3, "source3 is null");
    paramI = l.b.g.b.a.a(paramI);
    return a(new Publisher[] { paramPublisher1, paramPublisher2, paramPublisher3 }, paramI);
  }
  
  public final h a(Publisher paramPublisher1, Publisher paramPublisher2, Publisher paramPublisher3, Publisher paramPublisher4, l.b.f.j paramJ)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    l.b.g.b.b.a(paramPublisher3, "source3 is null");
    l.b.g.b.b.a(paramPublisher4, "source4 is null");
    paramJ = l.b.g.b.a.a(paramJ);
    return a(new Publisher[] { paramPublisher1, paramPublisher2, paramPublisher3, paramPublisher4 }, paramJ);
  }
  
  public final h a(Subscriber paramSubscriber)
  {
    l.b.g.b.b.a(paramSubscriber, "subscriber is null");
    sa.n localN = new sa.n(paramSubscriber);
    sa.m localM = new sa.m(paramSubscriber);
    paramSubscriber = new sa.l(paramSubscriber);
    l.b.f.a localA = l.b.g.b.a.c;
    return a((l.b.f.g)localN, (l.b.f.g)localM, paramSubscriber, localA);
  }
  
  public final h a(Publisher[] paramArrayOfPublisher, l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramArrayOfPublisher, "others is null");
    l.b.g.b.b.a(paramO, "combiner is null");
    return l.b.k.a.a((h)new Tb(this, paramArrayOfPublisher, paramO));
  }
  
  public final f a(long paramLong, boolean paramBoolean)
  {
    f localF = new f(f.a.a, paramLong);
    if (paramBoolean) {
      localF.cancel();
    }
    a(localF);
    return localF;
  }
  
  public final void a(l.b.f.g paramG1, l.b.f.g paramG2, l.b.f.a paramA)
  {
    l.b.g.e.b.l.a(this, paramG1, paramG2, paramA);
  }
  
  public final void a(o paramO)
  {
    l.b.g.b.b.a(paramO, "s is null");
    try
    {
      paramO = l.b.k.a.a(this, paramO);
      l.b.g.b.b.a(paramO, "Plugin returned null Subscriber");
      setTitle(paramO);
      return;
    }
    catch (Throwable paramO)
    {
      l.b.d.b.b(paramO);
      l.b.k.a.b(paramO);
      NullPointerException localNullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
      localNullPointerException.initCause(paramO);
      throw localNullPointerException;
    }
    catch (NullPointerException paramO)
    {
      throw paramO;
    }
  }
  
  public final Object add()
  {
    Object localObject = new l.b.g.h.d();
    a((o)localObject);
    localObject = ((l.b.g.h.c)localObject).a();
    if (localObject != null) {
      return localObject;
    }
    throw new NoSuchElementException();
  }
  
  public final Object add(Object paramObject)
  {
    Object localObject = new l.b.g.h.d();
    a((o)localObject);
    localObject = ((l.b.g.h.c)localObject).a();
    if (localObject != null) {
      return localObject;
    }
    return paramObject;
  }
  
  public final h add(Publisher paramPublisher)
  {
    l.b.g.b.b.a(paramPublisher, "other is null");
    return l.b.k.a.a((h)new Bb(this, paramPublisher));
  }
  
  public final h addRange(long paramLong, TimeUnit paramTimeUnit)
  {
    return add(add(paramLong, paramTimeUnit));
  }
  
  public final h addRange(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return add(add(paramLong, paramTimeUnit, paramG));
  }
  
  public final h addSubMenu()
  {
    return l.b.k.a.a((h)new kb(this));
  }
  
  public final h addSubMenu(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "debounceIndicator is null");
    return l.b.k.a.a((h)new F(this, paramO));
  }
  
  public final h addSubMenu(l.b.f.r paramR)
  {
    l.b.g.b.b.a(paramR, "stopPredicate is null");
    return l.b.k.a.a((h)new Cb(this, paramR));
  }
  
  public final h addSubMenu(Publisher paramPublisher)
  {
    l.b.g.b.b.a(paramPublisher, "sampler is null");
    return l.b.k.a.a((h)new db(this, paramPublisher, false));
  }
  
  public final ExtensionData b()
  {
    return l.b.k.a.a((ExtensionData)new Kb(this));
  }
  
  public final ExtensionData b(int paramInt)
  {
    l.b.g.b.b.a(paramInt, "capacityHint");
    return l.b.k.a.a((ExtensionData)new Kb(this, l.b.g.b.a.a(paramInt)));
  }
  
  public final ExtensionData b(Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "defaultItem");
    return l.b.k.a.a((ExtensionData)new ya(this, paramObject));
  }
  
  public final ExtensionData b(Callable paramCallable)
  {
    l.b.g.b.b.a(paramCallable, "collectionSupplier is null");
    return l.b.k.a.a((ExtensionData)new Kb(this, paramCallable));
  }
  
  public final ExtensionData b(Callable paramCallable, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramCallable, "seedSupplier is null");
    l.b.g.b.b.a(paramC, "reducer is null");
    return l.b.k.a.a((ExtensionData)new Va(this, paramCallable, paramC));
  }
  
  public final ExtensionData b(l.b.f.o paramO1, l.b.f.o paramO2)
  {
    l.b.g.j.m localM = l.b.g.j.m.a;
    l.b.g.j.b localB = l.b.g.j.b.a;
    return c(paramO1, paramO2, (Callable)localM, localB);
  }
  
  public final ExtensionData b(l.b.f.o paramO1, l.b.f.o paramO2, Callable paramCallable)
  {
    return c(paramO1, paramO2, paramCallable, l.b.g.j.b.a);
  }
  
  public final ExtensionData b(l.b.f.r paramR)
  {
    l.b.g.b.b.a(paramR, "predicate is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.b.g(this, paramR));
  }
  
  public final l.b.c.c b(l.b.f.g paramG)
  {
    return a(paramG, l.b.g.b.a.f, l.b.g.b.a.c, (l.b.f.g)sa.i.a);
  }
  
  public final c b(l.b.f.o paramO, boolean paramBoolean, int paramInt)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    l.b.g.b.b.a(paramInt, "maxConcurrency");
    return l.b.k.a.a((c)new ba(this, paramO, paramBoolean, paramInt));
  }
  
  public final l.b.e.a b(G paramG)
  {
    l.b.g.b.b.a(paramG, "scheduler is null");
    return _a.a(readUTF8(), paramG);
  }
  
  public final h b(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2, (Callable)l.b.g.j.b.a);
  }
  
  public final h b(long paramLong)
  {
    return a(paramLong, l.b.g.b.a.h);
  }
  
  public final h b(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return a(paramLong1, paramLong2, paramTimeUnit, l.b.m.a.a(), false, a);
  }
  
  public final h b(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, G paramG)
  {
    return a(paramLong1, paramLong2, paramTimeUnit, paramG, (Callable)l.b.g.j.b.a);
  }
  
  public final h b(long paramLong, TimeUnit paramTimeUnit)
  {
    return a(paramLong, paramTimeUnit, l.b.m.a.a());
  }
  
  public final h b(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return a(paramLong, paramTimeUnit, paramG, false);
  }
  
  public final h b(long paramLong, TimeUnit paramTimeUnit, G paramG, boolean paramBoolean)
  {
    return a(paramLong, paramTimeUnit, paramG, paramBoolean, a);
  }
  
  public final h b(long paramLong, TimeUnit paramTimeUnit, G paramG, boolean paramBoolean, int paramInt)
  {
    return a(Long.MAX_VALUE, paramLong, paramTimeUnit, paramG, paramBoolean, paramInt);
  }
  
  public final h b(long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean)
  {
    return c(paramLong, paramTimeUnit, l.b.m.a.a(), paramBoolean);
  }
  
  public final h b(TimeUnit paramTimeUnit, G paramG)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((h)new Fb(this, paramTimeUnit, paramG));
  }
  
  public final h b(l.b.f.a paramA)
  {
    return a(l.b.g.b.a.d, l.b.g.b.a.a(paramA), paramA, l.b.g.b.a.c);
  }
  
  public final h b(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    return l.b.k.a.a((h)new Aa(this, paramO));
  }
  
  public final h b(l.b.f.o paramO, int paramInt)
  {
    return a(paramO, false, paramInt, a);
  }
  
  public h b(l.b.f.o paramO, int paramInt, boolean paramBoolean)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    if ((this instanceof l.b.g.c.m))
    {
      Object localObject = ((l.b.g.c.m)this).call();
      if (localObject == null) {
        return c();
      }
      return fb.a(localObject, paramO);
    }
    return l.b.k.a.a((h)new vb(this, paramO, paramInt, paramBoolean));
  }
  
  public final h b(l.b.f.o paramO, boolean paramBoolean)
  {
    return c(paramO, l.b.g.b.a.a, paramBoolean, a);
  }
  
  public final h b(Publisher paramPublisher, l.b.f.o paramO)
  {
    return a(paramPublisher, paramO, a);
  }
  
  public final void b(l.b.f.g paramG1, l.b.f.g paramG2)
  {
    l.b.g.e.b.l.a(this, paramG1, paramG2, l.b.g.b.a.c);
  }
  
  public final ExtensionData c(Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "defaultItem is null");
    return l.b.k.a.a((ExtensionData)new nb(this, paramObject));
  }
  
  public final ExtensionData c(Object paramObject, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramObject, "seed is null");
    l.b.g.b.b.a(paramC, "reducer is null");
    return l.b.k.a.a((ExtensionData)new Ua(this, paramObject, paramC));
  }
  
  public final ExtensionData c(l.b.f.o paramO1, l.b.f.o paramO2, Callable paramCallable)
  {
    l.b.g.b.b.a(paramO1, "keySelector is null");
    l.b.g.b.b.a(paramO2, "valueSelector is null");
    return a(paramCallable, l.b.g.b.a.a(paramO1, paramO2));
  }
  
  public final ExtensionData c(l.b.f.o paramO1, l.b.f.o paramO2, Callable paramCallable, l.b.f.o paramO3)
  {
    l.b.g.b.b.a(paramO1, "keySelector is null");
    l.b.g.b.b.a(paramO2, "valueSelector is null");
    l.b.g.b.b.a(paramCallable, "mapSupplier is null");
    l.b.g.b.b.a(paramO3, "collectionFactory is null");
    return a(paramCallable, l.b.g.b.a.a(paramO1, paramO2, paramO3));
  }
  
  public final l.b.c.c c(l.b.f.g paramG1, l.b.f.g paramG2, l.b.f.a paramA)
  {
    return a(paramG1, paramG2, paramA, (l.b.f.g)sa.i.a);
  }
  
  public final h c(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt == 0) {
        return l.b.k.a.a((h)new qa(this));
      }
      if (paramInt == 1) {
        return l.b.k.a.a((h)new yb(this));
      }
      return l.b.k.a.a((h)new xb(this, paramInt));
    }
    throw new IndexOutOfBoundsException(StringBuilder.toString("count >= 0 required but it was ", paramInt));
  }
  
  public final h c(int paramInt, Callable paramCallable)
  {
    return a(paramInt, paramInt, paramCallable);
  }
  
  public final h c(int paramInt, boolean paramBoolean)
  {
    return a(paramInt, paramBoolean, false);
  }
  
  public final h c(long paramLong)
  {
    if (paramLong >= 0L)
    {
      if (paramLong == 0L) {
        return c();
      }
      return l.b.k.a.a((h)new Xa(this, paramLong));
    }
    throw new IllegalArgumentException(StringBuilder.get("times >= 0 required but it was ", paramLong));
  }
  
  public final h c(long paramLong1, long paramLong2)
  {
    return a(paramLong1, paramLong2, a);
  }
  
  public final h c(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return a(paramLong1, paramLong2, paramTimeUnit, l.b.m.a.a(), a);
  }
  
  public final h c(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, G paramG)
  {
    return a(paramLong1, paramLong2, paramTimeUnit, paramG, a);
  }
  
  public final h c(long paramLong, TimeUnit paramTimeUnit)
  {
    return a(paramLong, paramTimeUnit, l.b.m.a.a(), false, a);
  }
  
  public final h c(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((h)new eb(this, paramLong, paramTimeUnit, paramG, false));
  }
  
  public final h c(long paramLong, TimeUnit paramTimeUnit, G paramG, boolean paramBoolean)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((h)new eb(this, paramLong, paramTimeUnit, paramG, paramBoolean));
  }
  
  public final h c(long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean)
  {
    return a(paramLong, paramTimeUnit, l.b.m.a.a(), paramBoolean, a);
  }
  
  public final h c(Class paramClass)
  {
    l.b.g.b.b.a(paramClass, "clazz is null");
    return a(l.b.g.b.a.b(paramClass)).a(paramClass);
  }
  
  public final h c(Iterable paramIterable, l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramIterable, "others is null");
    l.b.g.b.b.a(paramO, "combiner is null");
    return l.b.k.a.a((h)new Tb(this, paramIterable, paramO));
  }
  
  public final h c(Comparator paramComparator)
  {
    l.b.g.b.b.a(paramComparator, "sortFunction");
    return b().a().b(l.b.g.b.a.a(paramComparator)).setChecked(l.b.g.b.a.a);
  }
  
  public final h c(Callable paramCallable1, Callable paramCallable2)
  {
    l.b.g.b.b.a(paramCallable1, "boundaryIndicatorSupplier is null");
    l.b.g.b.b.a(paramCallable2, "bufferSupplier is null");
    return l.b.k.a.a((h)new l.b.g.e.b.o(this, paramCallable1, paramCallable2));
  }
  
  public final h c(Callable paramCallable, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramCallable, "seedSupplier is null");
    l.b.g.b.b.a(paramC, "accumulator is null");
    return l.b.k.a.a((h)new hb(this, paramCallable, paramC));
  }
  
  public final h c(TimeUnit paramTimeUnit)
  {
    return a(paramTimeUnit, l.b.m.a.a());
  }
  
  public final h c(G paramG)
  {
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((h)new Lb(this, paramG));
  }
  
  public final h c(G paramG, boolean paramBoolean)
  {
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((h)new tb(this, paramG, paramBoolean));
  }
  
  public final h c(l.b.f.a paramA)
  {
    l.b.g.b.b.a(paramA, "onFinally is null");
    return l.b.k.a.a((h)new P(this, paramA));
  }
  
  public final h c(l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramC, "accumulator is null");
    return l.b.k.a.a((h)new gb(this, paramC));
  }
  
  public final h c(l.b.f.d paramD)
  {
    l.b.g.b.b.a(paramD, "comparer is null");
    return l.b.k.a.a((h)new N(this, l.b.g.b.a.a, paramD));
  }
  
  public final h c(l.b.f.e paramE)
  {
    l.b.g.b.b.a(paramE, "stop is null");
    return l.b.k.a.a((h)new Ya(this, paramE));
  }
  
  public final h c(l.b.f.g paramG)
  {
    l.b.g.b.b.a(paramG, "onAfterNext is null");
    return l.b.k.a.a((h)new O(this, paramG));
  }
  
  public final h c(l.b.f.o paramO)
  {
    return a(paramO, 2, true);
  }
  
  public final h c(l.b.f.o paramO, int paramInt)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    l.b.g.b.b.a(paramInt, "prefetch");
    return l.b.k.a.a((h)new fa(this, paramO, paramInt));
  }
  
  public final h c(l.b.f.o paramO, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    l.b.g.b.b.a(paramC, "resultSelector is null");
    paramO = new sa.c(paramO);
    int i = a;
    return a(paramO, paramC, false, i, i);
  }
  
  public final h c(l.b.f.o paramO, l.b.f.c paramC, int paramInt)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    l.b.g.b.b.a(paramC, "resultSelector is null");
    return a(new sa.c(paramO), paramC, false, a, paramInt);
  }
  
  public final h c(l.b.f.o paramO1, l.b.f.o paramO2)
  {
    return c(paramO1, paramO2, false, a);
  }
  
  public final h c(l.b.f.o paramO1, l.b.f.o paramO2, Callable paramCallable, int paramInt)
  {
    l.b.g.b.b.a(paramO1, "onNextMapper is null");
    l.b.g.b.b.a(paramO2, "onErrorMapper is null");
    l.b.g.b.b.a(paramCallable, "onCompleteSupplier is null");
    return a((Publisher)new Ba(this, paramO1, paramO2, paramCallable), paramInt);
  }
  
  public final h c(l.b.f.o paramO1, l.b.f.o paramO2, boolean paramBoolean)
  {
    return c(paramO1, paramO2, paramBoolean, a);
  }
  
  public final h c(l.b.f.o paramO1, l.b.f.o paramO2, boolean paramBoolean, int paramInt)
  {
    l.b.g.b.b.a(paramO1, "keySelector is null");
    l.b.g.b.b.a(paramO2, "valueSelector is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return l.b.k.a.a((h)new na(this, paramO1, paramO2, paramInt, paramBoolean));
  }
  
  public final h c(l.b.f.o paramO, boolean paramBoolean)
  {
    int i = a;
    return a(paramO, i, i, paramBoolean);
  }
  
  public final h c(l.b.f.o paramO, boolean paramBoolean, int paramInt)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    l.b.g.b.b.a(paramInt, "maxConcurrency");
    return l.b.k.a.a((h)new ca(this, paramO, paramBoolean, paramInt));
  }
  
  public final h c(l.b.f.r paramR)
  {
    return a(Long.MAX_VALUE, paramR);
  }
  
  public final h c(n paramN)
  {
    l.b.g.b.b.a(paramN, "lifter is null");
    return l.b.k.a.a((h)new za(this, paramN));
  }
  
  public final h c(Publisher paramPublisher)
  {
    l.b.g.b.b.a(paramPublisher, "next is null");
    return l.b.k.a.a((h)new Ma(this, l.b.g.b.a.c(paramPublisher), true));
  }
  
  public final h c(Publisher paramPublisher, int paramInt)
  {
    l.b.g.b.b.a(paramPublisher, "boundaryIndicator is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return l.b.k.a.a((h)new Ob(this, paramPublisher, paramInt));
  }
  
  public final h c(Publisher paramPublisher, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramPublisher, "other is null");
    l.b.g.b.b.a(paramC, "combiner is null");
    return l.b.k.a.a((h)new Sb(this, paramC, paramPublisher));
  }
  
  public final h c(Publisher paramPublisher, l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramPublisher, "firstTimeoutIndicator is null");
    return a(paramPublisher, paramO, null);
  }
  
  public final h c(Publisher paramPublisher, l.b.f.o paramO1, l.b.f.o paramO2, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramPublisher, "other is null");
    l.b.g.b.b.a(paramO1, "leftEnd is null");
    l.b.g.b.b.a(paramO2, "rightEnd is null");
    l.b.g.b.b.a(paramC, "resultSelector is null");
    return l.b.k.a.a((h)new va(this, paramPublisher, paramO1, paramO2, paramC));
  }
  
  public final h c(Publisher paramPublisher1, l.b.f.o paramO, Publisher paramPublisher2)
  {
    l.b.g.b.b.a(paramPublisher1, "firstTimeoutSelector is null");
    l.b.g.b.b.a(paramPublisher2, "other is null");
    return a(paramPublisher1, paramO, paramPublisher2);
  }
  
  public final h c(Publisher paramPublisher1, Publisher paramPublisher2, l.b.f.h paramH)
  {
    l.b.g.b.b.a(paramPublisher1, "source1 is null");
    l.b.g.b.b.a(paramPublisher2, "source2 is null");
    paramH = l.b.g.b.a.a(paramH);
    return a(new Publisher[] { paramPublisher1, paramPublisher2 }, paramH);
  }
  
  public final h c(Publisher paramPublisher, boolean paramBoolean)
  {
    l.b.g.b.b.a(paramPublisher, "sampler is null");
    return l.b.k.a.a((h)new db(this, paramPublisher, paramBoolean));
  }
  
  public final h c(boolean paramBoolean)
  {
    return a(a, paramBoolean, true);
  }
  
  public final h c(Object... paramVarArgs)
  {
    paramVarArgs = a(paramVarArgs);
    if (paramVarArgs == c()) {
      return l.b.k.a.a(this);
    }
    return a(new Publisher[] { paramVarArgs, this });
  }
  
  public final l.b.j.h c(int paramInt1, int paramInt2)
  {
    l.b.g.b.b.a(paramInt1, "parallelism");
    l.b.g.b.b.a(paramInt2, "prefetch");
    return l.b.j.h.a(this, paramInt1, paramInt2);
  }
  
  public final Subscriber call(Subscriber paramSubscriber)
  {
    subscribe(paramSubscriber);
    return paramSubscriber;
  }
  
  public final d collapseActionView()
  {
    return d(0L);
  }
  
  public final h collapseActionView(l.b.f.o paramO)
  {
    return d(paramO, false, Integer.MAX_VALUE);
  }
  
  public final ExtensionData createFromParcel()
  {
    return l.b.k.a.a((ExtensionData)new C(this));
  }
  
  public final ExtensionData d(l.b.f.r paramR)
  {
    l.b.g.b.b.a(paramR, "predicate is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.b.j(this, paramR));
  }
  
  public final d d(long paramLong)
  {
    if (paramLong >= 0L) {
      return l.b.k.a.a((d)new U(this, paramLong));
    }
    throw new IndexOutOfBoundsException(StringBuilder.get("index >= 0 required but it was ", paramLong));
  }
  
  public final l.b.e.a d(int paramInt)
  {
    l.b.g.b.b.a(paramInt, "bufferSize");
    return _a.a(this, paramInt);
  }
  
  public final l.b.e.a d(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return _a.a(this, paramLong, paramTimeUnit, paramG);
  }
  
  public final h d()
  {
    return l.b.k.a.a((h)new L(this));
  }
  
  public final h d(long paramLong, TimeUnit paramTimeUnit)
  {
    return a(paramLong, paramTimeUnit, l.b.m.a.a(), false);
  }
  
  public final h d(long paramLong, TimeUnit paramTimeUnit, G paramG, boolean paramBoolean)
  {
    return b(paramLong, paramTimeUnit, paramG, paramBoolean, a);
  }
  
  public final h d(long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean)
  {
    return a(paramLong, paramTimeUnit, l.b.m.a.a(), paramBoolean);
  }
  
  public final h d(Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "item is null");
    return d(l.b.g.b.a.c(paramObject));
  }
  
  public final h d(Callable paramCallable)
  {
    return a(paramCallable, a);
  }
  
  public final h d(G paramG)
  {
    return a(paramG, false, a);
  }
  
  public final h d(l.b.f.g paramG)
  {
    l.b.g.b.b.a(paramG, "consumer is null");
    return a(l.b.g.b.a.c(paramG), l.b.g.b.a.b(paramG), l.b.g.b.a.a(paramG), l.b.g.b.a.c);
  }
  
  public final h d(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "valueSupplier is null");
    return l.b.k.a.a((h)new Na(this, paramO));
  }
  
  public final h d(l.b.f.o paramO, int paramInt)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return l.b.k.a.a((h)new fa(this, paramO, paramInt));
  }
  
  public final h d(l.b.f.o paramO, boolean paramBoolean, int paramInt)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    l.b.g.b.b.a(paramInt, "maxConcurrency");
    return l.b.k.a.a((h)new l.b.g.e.b.ea(this, paramO, paramBoolean, paramInt));
  }
  
  public final ExtensionData e(Object paramObject)
  {
    return a(0L, paramObject);
  }
  
  public final l.b.e.a e()
  {
    return e(a);
  }
  
  public final l.b.e.a e(int paramInt)
  {
    l.b.g.b.b.a(paramInt, "bufferSize");
    return Oa.a(this, paramInt);
  }
  
  public final h e(long paramLong)
  {
    return a(paramLong, paramLong, a);
  }
  
  public final h e(long paramLong, TimeUnit paramTimeUnit)
  {
    return b(paramLong, paramTimeUnit, l.b.m.a.a(), false, a);
  }
  
  public final h e(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return a(paramLong, paramTimeUnit, paramG, false, a);
  }
  
  public final h e(Callable paramCallable)
  {
    return c(paramCallable, (Callable)l.b.g.j.b.a);
  }
  
  public final h e(l.b.f.o paramO)
  {
    int i = a;
    return a(paramO, i, i);
  }
  
  public final h e(l.b.f.o paramO, int paramInt)
  {
    l.b.g.b.b.a(paramO, "selector is null");
    l.b.g.b.b.a(paramInt, "prefetch");
    return l.b.k.a.a((h)new Pa(this, paramO, paramInt, false));
  }
  
  public final h e(Publisher paramPublisher)
  {
    return a(paramPublisher, (Callable)l.b.g.j.b.a);
  }
  
  public final void e(l.b.f.g paramG)
  {
    l.b.g.e.b.l.a(this, paramG, l.b.g.b.a.f, l.b.g.b.a.c);
  }
  
  public final void e(Subscriber paramSubscriber)
  {
    l.b.g.e.b.l.a(this, paramSubscriber);
  }
  
  public final h expandActionView(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return c(paramLong, paramTimeUnit, paramG);
  }
  
  public final h expandActionView(l.b.f.o paramO)
  {
    return c(paramO, false, Integer.MAX_VALUE);
  }
  
  public final h expandActionView(Publisher paramPublisher)
  {
    return c(paramPublisher, a);
  }
  
  public final l.b.j.h expandActionView()
  {
    return l.b.j.h.c(this);
  }
  
  public final l.b.e.a f(long paramLong, TimeUnit paramTimeUnit)
  {
    return d(paramLong, paramTimeUnit, l.b.m.a.a());
  }
  
  public final h f(Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "item is null");
    return a(new Publisher[] { a(paramObject), this });
  }
  
  public final h f(l.b.f.g paramG)
  {
    return a(paramG, l.b.g.b.a.g, l.b.g.b.a.c);
  }
  
  public final h f(l.b.f.o paramO)
  {
    return f(paramO, a);
  }
  
  public final h f(l.b.f.o paramO, int paramInt)
  {
    return b(paramO, paramInt, true);
  }
  
  public final l.b.j.h f(int paramInt)
  {
    l.b.g.b.b.a(paramInt, "parallelism");
    return l.b.j.h.c(this, paramInt);
  }
  
  public final f f()
  {
    f localF = new f();
    a(localF);
    return localF;
  }
  
  public final f f(long paramLong)
  {
    f localF = new f(f.a.a, paramLong);
    a(localF);
    return localF;
  }
  
  public final h findItem(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return a(paramLong, paramTimeUnit, null, paramG);
  }
  
  public final h getActionView(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "selector is null");
    return _a.a((Callable)new sa.g(this), paramO);
  }
  
  public final h getCount(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, G paramG)
  {
    return a(paramLong1, paramLong2, paramTimeUnit, paramG, false, a);
  }
  
  public final h getCount(long paramLong, TimeUnit paramTimeUnit)
  {
    return k(paramLong, paramTimeUnit);
  }
  
  public final h getCount(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return a(paramLong, paramTimeUnit, paramG, Integer.MAX_VALUE, (Callable)l.b.g.j.b.a, false);
  }
  
  public final h getElementType()
  {
    return l.b.k.a.a((h)new Da(this));
  }
  
  public final Object getItem(Object paramObject)
  {
    Object localObject = new l.b.g.h.e();
    a((o)localObject);
    localObject = ((l.b.g.h.c)localObject).a();
    if (localObject != null) {
      return localObject;
    }
    return paramObject;
  }
  
  public final ExtensionData getItem(long paramLong)
  {
    if (paramLong >= 0L) {
      return l.b.k.a.a((ExtensionData)new V(this, paramLong, null));
    }
    throw new IndexOutOfBoundsException(StringBuilder.get("index >= 0 required but it was ", paramLong));
  }
  
  public final h getItem()
  {
    return a(Long.MAX_VALUE, l.b.g.b.a.h);
  }
  
  public final h getItem(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt == 0) {
        return l.b.k.a.a(this);
      }
      return l.b.k.a.a((h)new pb(this, paramInt));
    }
    throw new IndexOutOfBoundsException(StringBuilder.toString("count >= 0 required but it was ", paramInt));
  }
  
  public final h getItem(long paramLong, TimeUnit paramTimeUnit)
  {
    return a(paramLong, paramTimeUnit, null, l.b.m.a.a());
  }
  
  public final h getItem(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return a(paramLong, paramTimeUnit, paramG, Long.MAX_VALUE, false);
  }
  
  public final h getItem(Iterable paramIterable)
  {
    return a(new Publisher[] { a(paramIterable), this });
  }
  
  public final h getItem(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "itemDelayIndicator is null");
    return putShort(new sa.f(paramO));
  }
  
  public final h getItem(l.b.f.o paramO, int paramInt)
  {
    l.b.g.b.b.a(paramO, "selector is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return _a.a((Callable)new sa.a(this, paramInt), paramO);
  }
  
  public final h getItem(Publisher paramPublisher)
  {
    l.b.g.b.b.a(paramPublisher, "other is null");
    return a(new Publisher[] { paramPublisher, this });
  }
  
  public final h getItem(Publisher paramPublisher, l.b.f.o paramO)
  {
    return set(paramPublisher).getItem(paramO);
  }
  
  public final ExtensionData getItemView()
  {
    return getItem(0L);
  }
  
  public final c getPixelValue()
  {
    return l.b.k.a.a((c)new ra(this));
  }
  
  public final Object getSubMenu()
  {
    Object localObject = new l.b.g.h.e();
    a((o)localObject);
    localObject = ((l.b.g.h.c)localObject).a();
    if (localObject != null) {
      return localObject;
    }
    throw new NoSuchElementException();
  }
  
  public final h getSupportActionBar()
  {
    return a(16);
  }
  
  public final Iterable getView()
  {
    return initialize(a);
  }
  
  public final Object getView(Object paramObject)
  {
    return c(paramObject).setIcon();
  }
  
  public final h getView(l.b.f.o paramO)
  {
    return e(paramO, a);
  }
  
  public final h getView(Publisher paramPublisher)
  {
    l.b.g.b.b.a(paramPublisher, "other is null");
    return c(this, paramPublisher);
  }
  
  public final h h(l.b.f.o paramO)
  {
    return setChecked(paramO, a);
  }
  
  public final h i()
  {
    return l.b.k.a.a((h)new La(this));
  }
  
  public final h i(long paramLong)
  {
    if (paramLong <= 0L) {
      return l.b.k.a.a(this);
    }
    return l.b.k.a.a((h)new ob(this, paramLong));
  }
  
  public final h i(long paramLong, TimeUnit paramTimeUnit)
  {
    return i(paramLong, paramTimeUnit, l.b.m.a.a());
  }
  
  public final h i(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((h)new Eb(this, paramLong, paramTimeUnit, paramG));
  }
  
  public final h i(Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "item is null");
    return i(a(paramObject));
  }
  
  public final h i(l.b.f.g paramG)
  {
    l.b.g.b.b.a(paramG, "onDrop is null");
    return l.b.k.a.a((h)new Ja(this, paramG));
  }
  
  public final h i(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "handler is null");
    return l.b.k.a.a((h)new Za(this, paramO));
  }
  
  public final h i(l.b.f.r paramR)
  {
    l.b.g.b.b.a(paramR, "predicate is null");
    return l.b.k.a.a((h)new sb(this, paramR));
  }
  
  public final h i(Publisher paramPublisher)
  {
    l.b.g.b.b.a(paramPublisher, "other is null");
    return l.b.k.a.a((h)new ub(this, paramPublisher));
  }
  
  public final Iterable initialize(int paramInt)
  {
    l.b.g.b.b.a(paramInt, "bufferSize");
    return (Iterable)new l.b.g.e.b.b(this, paramInt);
  }
  
  public final h initialize(long paramLong, TimeUnit paramTimeUnit)
  {
    return setActionView(add(paramLong, paramTimeUnit));
  }
  
  public final h k()
  {
    return l.b.k.a.a((h)new K(this));
  }
  
  public final h k(long paramLong, TimeUnit paramTimeUnit)
  {
    return c(paramLong, paramTimeUnit, l.b.m.a.a());
  }
  
  public final h next()
  {
    return c(Long.MAX_VALUE);
  }
  
  public final void notifyDataSetChanged()
  {
    l.b.g.e.b.l.a(this);
  }
  
  public final h onBindViewHolder()
  {
    return a(TimeUnit.MILLISECONDS, l.b.m.a.a());
  }
  
  public final h onBindViewHolder(G paramG)
  {
    return a(TimeUnit.MILLISECONDS, paramG);
  }
  
  public final h onClick()
  {
    return onClick(l.b.g.b.a.a);
  }
  
  public final h onClick(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "keySelector is null");
    return l.b.k.a.a((h)new N(this, paramO, l.b.g.b.b.a));
  }
  
  public final void onClick(Subscriber paramSubscriber)
  {
    l.b.g.b.b.a(paramSubscriber, "s is null");
    if ((paramSubscriber instanceof l.b.o.d))
    {
      a((l.b.o.d)paramSubscriber);
      return;
    }
    a(new l.b.o.d(paramSubscriber));
  }
  
  public final h onConfigurationChanged(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "resumeFunction is null");
    return l.b.k.a.a((h)new Ma(this, paramO, false));
  }
  
  public final h onConfigurationChanged(Publisher paramPublisher)
  {
    l.b.g.b.b.a(paramPublisher, "next is null");
    return onConfigurationChanged(l.b.g.b.a.c(paramPublisher));
  }
  
  public final ExtensionData onCreate(Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "item is null");
    return d(l.b.g.b.a.a(paramObject));
  }
  
  public final h onCreate()
  {
    return e().X();
  }
  
  public final h onCreate(l.b.f.r paramR)
  {
    l.b.g.b.b.a(paramR, "predicate is null");
    return l.b.k.a.a((h)new Db(this, paramR));
  }
  
  public final Iterable onCreateView()
  {
    return (Iterable)new l.b.g.e.b.e(this);
  }
  
  public final c onCreateView(l.b.f.o paramO)
  {
    return b(paramO, false, Integer.MAX_VALUE);
  }
  
  public final h onCreateView(Publisher paramPublisher)
  {
    l.b.g.b.b.a(paramPublisher, "other is null");
    return b(this, paramPublisher);
  }
  
  public final void onStop(l.b.f.g paramG)
  {
    Iterator localIterator = getView().iterator();
    while (localIterator.hasNext()) {
      try
      {
        paramG.accept(localIterator.next());
      }
      catch (Throwable paramG)
      {
        l.b.d.b.b(paramG);
        ((l.b.c.c)localIterator).dispose();
        throw l.b.g.j.k.c(paramG);
      }
    }
  }
  
  public final h onSubMenuSelected()
  {
    return l.b.k.a.a((h)new Ja(this));
  }
  
  public final h prepareMenuItems()
  {
    return l.b.k.a.a((h)new pa(this));
  }
  
  public final h putShort(l.b.f.o paramO)
  {
    int i = a;
    return a(paramO, false, i, i);
  }
  
  public final ByteVector putUTF8()
  {
    return l.b.k.a.a((ByteVector)new l.b.g.e.d.ea(this));
  }
  
  public final l.b.e.a readUTF8()
  {
    return _a.a(this);
  }
  
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
  
  public final Future schedule()
  {
    return (Future)call(new l.b.g.h.j());
  }
  
  public final h set(long paramLong, TimeUnit paramTimeUnit)
  {
    return set(paramLong, paramTimeUnit, l.b.m.a.a());
  }
  
  public final h set(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return set(add(paramLong, paramTimeUnit, paramG));
  }
  
  public final h set(Publisher paramPublisher)
  {
    l.b.g.b.b.a(paramPublisher, "subscriptionIndicator is null");
    return l.b.k.a.a((h)new J(this, paramPublisher));
  }
  
  public final ExtensionData setActionView()
  {
    return l.b.k.a.a((ExtensionData)new nb(this, null));
  }
  
  public final ExtensionData setActionView(int paramInt)
  {
    return a(l.b.g.b.a.f(), paramInt);
  }
  
  public final ExtensionData setActionView(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "keySelector is null");
    l.b.g.j.m localM = l.b.g.j.m.a;
    paramO = l.b.g.b.a.a(paramO);
    return a((Callable)localM, paramO);
  }
  
  public final h setActionView(long paramLong, TimeUnit paramTimeUnit)
  {
    return a(paramLong, paramTimeUnit, l.b.m.a.a(), Long.MAX_VALUE, false);
  }
  
  public final h setActionView(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return setActionView(add(paramLong, paramTimeUnit, paramG));
  }
  
  public final h setActionView(Publisher paramPublisher)
  {
    l.b.g.b.b.a(paramPublisher, "other is null");
    return l.b.k.a.a((h)new rb(this, paramPublisher));
  }
  
  public final h setActionView(Publisher paramPublisher, int paramInt)
  {
    l.b.g.b.b.a(paramInt, "initialCapacity");
    return a(paramPublisher, l.b.g.b.a.a(paramInt));
  }
  
  public final ExtensionData setCheckable(l.b.f.o paramO)
  {
    l.b.f.o localO = l.b.g.b.a.a;
    l.b.g.j.m localM = l.b.g.j.m.a;
    l.b.g.j.b localB = l.b.g.j.b.a;
    return c(paramO, localO, (Callable)localM, localB);
  }
  
  public final l.b.c.c setCheckable()
  {
    return a(l.b.g.b.a.d, l.b.g.b.a.f, l.b.g.b.a.c, (l.b.f.g)sa.i.a);
  }
  
  public final l.b.c.c setChecked(l.b.f.r paramR)
  {
    return a(paramR, l.b.g.b.a.f, l.b.g.b.a.c);
  }
  
  public final h setChecked()
  {
    return b().a().b(l.b.g.b.a.a(l.b.g.b.a.f())).setChecked(l.b.g.b.a.a);
  }
  
  public final h setChecked(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return b(paramLong, paramTimeUnit, paramG, false, a);
  }
  
  public final h setChecked(l.b.f.a paramA)
  {
    l.b.f.g localG = l.b.g.b.a.d;
    return a(localG, localG, paramA, l.b.g.b.a.c);
  }
  
  public final h setChecked(l.b.f.g paramG)
  {
    l.b.f.g localG = l.b.g.b.a.d;
    l.b.f.a localA = l.b.g.b.a.c;
    return a(paramG, localG, localA, localA);
  }
  
  public final h setChecked(l.b.f.o paramO)
  {
    return d(paramO, a);
  }
  
  public final h setChecked(l.b.f.o paramO, int paramInt)
  {
    return b(paramO, paramInt, false);
  }
  
  public final h setEnabled()
  {
    return a(l.b.g.b.a.a, l.b.g.b.a.c());
  }
  
  public final Object setIcon()
  {
    return setActionView().setIcon();
  }
  
  public final h setIcon(l.b.f.o paramO)
  {
    return c(paramO, l.b.g.b.a.a, false, a);
  }
  
  public final ExtensionData setShortcut()
  {
    return a(l.b.g.b.a.f());
  }
  
  public final h setShortcut(l.b.f.o paramO)
  {
    return c(paramO, 2);
  }
  
  public final l.b.c.c setShowAsActionFlags(l.b.f.g paramG)
  {
    return b(paramG);
  }
  
  public final h setShowAsActionFlags()
  {
    return b(TimeUnit.MILLISECONDS, l.b.m.a.a());
  }
  
  public final h setShowAsActionFlags(int paramInt)
  {
    return b(paramInt, paramInt);
  }
  
  public final h setShowAsActionFlags(long paramLong, TimeUnit paramTimeUnit)
  {
    return b(paramLong, paramTimeUnit);
  }
  
  public final h setShowAsActionFlags(G paramG)
  {
    return b(TimeUnit.MILLISECONDS, paramG);
  }
  
  public final h setShowAsActionFlags(l.b.f.o paramO)
  {
    return a(paramO, l.b.g.b.a.c());
  }
  
  public final ExtensionData setSupportActionProvider()
  {
    return l.b.k.a.a((ExtensionData)new ya(this, null));
  }
  
  public final Iterable setTitle(Object paramObject)
  {
    return (Iterable)new l.b.g.e.b.d(this, paramObject);
  }
  
  public final ExtensionData setTitle()
  {
    return b(l.b.g.b.a.i);
  }
  
  public final h setTitle(int paramInt)
  {
    return a(l.b.g.g.e.b, true, paramInt);
  }
  
  public final h setTitle(l.b.f.a paramA)
  {
    l.b.f.g localG = l.b.g.b.a.d;
    return a(localG, localG, l.b.g.b.a.c, paramA);
  }
  
  public final h setTitle(l.b.f.g paramG)
  {
    l.b.f.g localG = l.b.g.b.a.d;
    l.b.f.a localA = l.b.g.b.a.c;
    return a(localG, paramG, localA, localA);
  }
  
  public final h setTitle(l.b.f.o paramO)
  {
    return a(paramO, 2);
  }
  
  public final h setTitle(Publisher paramPublisher)
  {
    l.b.g.b.b.a(paramPublisher, "other is null");
    return c(new Publisher[] { this, paramPublisher });
  }
  
  public abstract void setTitle(Subscriber paramSubscriber);
  
  public final h setVisible()
  {
    return a(a, false, true);
  }
  
  public final h setVisible(int paramInt)
  {
    return a(paramInt, false, false);
  }
  
  public final h setVisible(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return a(paramLong, paramTimeUnit, paramG);
  }
  
  public final h setVisible(l.b.f.o paramO)
  {
    return a(null, paramO, null);
  }
  
  public final d startSupportActionMode()
  {
    return l.b.k.a.a((d)new xa(this));
  }
  
  public final void subscribe(Subscriber paramSubscriber)
  {
    if ((paramSubscriber instanceof o))
    {
      a((o)paramSubscriber);
      return;
    }
    l.b.g.b.b.a(paramSubscriber, "s is null");
    a(new l.b.g.h.u(paramSubscriber));
  }
  
  public final Iterable withIndex()
  {
    return (Iterable)new l.b.g.e.b.c(this);
  }
}
