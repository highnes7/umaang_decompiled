package l.b;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import l.b.f.i;
import l.b.g.d.f;
import l.b.g.e.d.A;
import l.b.g.e.d.Aa;
import l.b.g.e.d.Ab;
import l.b.g.e.d.Ba;
import l.b.g.e.d.Bb;
import l.b.g.e.d.Ca;
import l.b.g.e.d.Cb;
import l.b.g.e.d.Da;
import l.b.g.e.d.Db;
import l.b.g.e.d.Ea;
import l.b.g.e.d.Eb;
import l.b.g.e.d.Fa;
import l.b.g.e.d.Fb;
import l.b.g.e.d.Ga;
import l.b.g.e.d.H;
import l.b.g.e.d.Ha;
import l.b.g.e.d.I;
import l.b.g.e.d.J;
import l.b.g.e.d.Ja;
import l.b.g.e.d.K;
import l.b.g.e.d.L;
import l.b.g.e.d.La;
import l.b.g.e.d.M;
import l.b.g.e.d.Ma;
import l.b.g.e.d.Na;
import l.b.g.e.d.O;
import l.b.g.e.d.Oa;
import l.b.g.e.d.P;
import l.b.g.e.d.Pa;
import l.b.g.e.d.Q;
import l.b.g.e.d.Qa;
import l.b.g.e.d.Ra;
import l.b.g.e.d.S;
import l.b.g.e.d.Sa;
import l.b.g.e.d.T;
import l.b.g.e.d.Ta;
import l.b.g.e.d.U;
import l.b.g.e.d.Ua;
import l.b.g.e.d.W;
import l.b.g.e.d.Wa;
import l.b.g.e.d.X;
import l.b.g.e.d.Xa;
import l.b.g.e.d.Y;
import l.b.g.e.d.Ya;
import l.b.g.e.d.Z;
import l.b.g.e.d.Za;
import l.b.g.e.d._a;
import l.b.g.e.d.aa;
import l.b.g.e.d.ab;
import l.b.g.e.d.ba;
import l.b.g.e.d.bb;
import l.b.g.e.d.ca;
import l.b.g.e.d.cb;
import l.b.g.e.d.da;
import l.b.g.e.d.db;
import l.b.g.e.d.ea;
import l.b.g.e.d.eb;
import l.b.g.e.d.fa;
import l.b.g.e.d.fb;
import l.b.g.e.d.ga;
import l.b.g.e.d.gb;
import l.b.g.e.d.ha;
import l.b.g.e.d.hb;
import l.b.g.e.d.ia;
import l.b.g.e.d.ib;
import l.b.g.e.d.ja;
import l.b.g.e.d.jb;
import l.b.g.e.d.kb;
import l.b.g.e.d.la;
import l.b.g.e.d.lb;
import l.b.g.e.d.ma;
import l.b.g.e.d.ma.a;
import l.b.g.e.d.ma.d;
import l.b.g.e.d.ma.f;
import l.b.g.e.d.ma.g;
import l.b.g.e.d.ma.j;
import l.b.g.e.d.ma.k;
import l.b.g.e.d.ma.l;
import l.b.g.e.d.ma.n;
import l.b.g.e.d.ma.o;
import l.b.g.e.d.ma.q;
import l.b.g.e.d.ma.r;
import l.b.g.e.d.ma.t;
import l.b.g.e.d.mb;
import l.b.g.e.d.na;
import l.b.g.e.d.nb;
import l.b.g.e.d.oa;
import l.b.g.e.d.ob;
import l.b.g.e.d.pa;
import l.b.g.e.d.pb;
import l.b.g.e.d.q;
import l.b.g.e.d.qa;
import l.b.g.e.d.qb;
import l.b.g.e.d.ra;
import l.b.g.e.d.rb;
import l.b.g.e.d.sa;
import l.b.g.e.d.sb;
import l.b.g.e.d.t;
import l.b.g.e.d.ta;
import l.b.g.e.d.tb;
import l.b.g.e.d.ua;
import l.b.g.e.d.ub;
import l.b.g.e.d.va;
import l.b.g.e.d.vb;
import l.b.g.e.d.w;
import l.b.g.e.d.wa;
import l.b.g.e.d.wb;
import l.b.g.e.d.xa;
import l.b.g.e.d.xb;
import l.b.g.e.d.y;
import l.b.g.e.d.ya;
import l.b.g.e.d.yb;
import l.b.g.e.d.z;
import l.b.g.e.d.za;
import l.b.g.e.d.zb;
import l.b.i.s;
import l.b.i.u.a;
import org.reactivestreams.Publisher;

public abstract class ByteVector<T>
  implements D<T>
{
  public ByteVector() {}
  
  public static ByteVector a()
  {
    return l.b.k.a.a(Q.a);
  }
  
  public static ByteVector a(int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 0)
    {
      if (paramInt2 == 0) {
        return a();
      }
      if (paramInt2 == 1) {
        return a(Integer.valueOf(paramInt1));
      }
      if (paramInt1 + (paramInt2 - 1) <= 2147483647L) {
        return l.b.k.a.a((ByteVector)new Da(paramInt1, paramInt2));
      }
      throw new IllegalArgumentException("Integer overflow");
    }
    throw new IllegalArgumentException(StringBuilder.toString("count >= 0 required but it was ", paramInt2));
  }
  
  public static ByteVector a(int paramInt1, int paramInt2, Label... paramVarArgs)
  {
    return a(paramVarArgs).a(l.b.g.b.a.a, paramInt1, paramInt2, false);
  }
  
  public static ByteVector a(long paramLong1, long paramLong2)
  {
    if (paramLong2 >= 0L)
    {
      if (paramLong2 == 0L) {
        return a();
      }
      if (paramLong2 == 1L) {
        return a(Long.valueOf(paramLong1));
      }
      if ((paramLong1 > 0L) && (paramLong2 - 1L + paramLong1 < 0L)) {
        throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
      }
      return l.b.k.a.a((ByteVector)new Ea(paramLong1, paramLong2));
    }
    throw new IllegalArgumentException(StringBuilder.get("count >= 0 required but it was ", paramLong2));
  }
  
  public static ByteVector a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, TimeUnit paramTimeUnit, G paramG)
  {
    if (paramLong2 >= 0L)
    {
      if (paramLong2 == 0L) {
        return a().putShort(paramLong3, paramTimeUnit, paramG);
      }
      paramLong2 = paramLong2 - 1L + paramLong1;
      if ((paramLong1 > 0L) && (paramLong2 < 0L)) {
        throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
      }
      l.b.g.b.b.a(paramTimeUnit, "unit is null");
      l.b.g.b.b.a(paramG, "scheduler is null");
      return l.b.k.a.a((ByteVector)new oa(paramLong1, paramLong2, Math.max(0L, paramLong3), Math.max(0L, paramLong4), paramTimeUnit, paramG));
    }
    throw new IllegalArgumentException(StringBuilder.get("count >= 0 required but it was ", paramLong2));
  }
  
  public static ByteVector a(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, G paramG)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((ByteVector)new na(Math.max(0L, paramLong1), Math.max(0L, paramLong2), paramTimeUnit, paramG));
  }
  
  public static ByteVector a(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((ByteVector)new sb(Math.max(paramLong, 0L), paramTimeUnit, paramG));
  }
  
  private ByteVector a(long paramLong, TimeUnit paramTimeUnit, Label paramLabel, G paramG)
  {
    l.b.g.b.b.a(paramTimeUnit, "timeUnit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((ByteVector)new rb(this, paramLong, paramTimeUnit, paramG, paramLabel));
  }
  
  public static ByteVector a(Iterable paramIterable)
  {
    l.b.g.b.b.a(paramIterable, "source is null");
    return l.b.k.a.a((ByteVector)new da(paramIterable));
  }
  
  public static ByteVector a(Iterable paramIterable, int paramInt1, int paramInt2)
  {
    l.b.g.b.b.a(Integer.valueOf(paramInt1), "maxConcurrency is null");
    l.b.g.b.b.a(Integer.valueOf(paramInt2), "prefetch is null");
    return a(paramIterable).a(l.b.g.b.a.a, paramInt1, paramInt2, false);
  }
  
  public static ByteVector a(Iterable paramIterable, l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "zipper is null");
    l.b.g.b.b.a(paramIterable, "sources is null");
    return l.b.k.a.a((ByteVector)new Eb(null, paramIterable, paramO, h.a, false));
  }
  
  public static ByteVector a(Iterable paramIterable, l.b.f.o paramO, int paramInt)
  {
    l.b.g.b.b.a(paramIterable, "sources is null");
    l.b.g.b.b.a(paramO, "combiner is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return l.b.k.a.a((ByteVector)new l.b.g.e.d.u(null, paramIterable, paramO, paramInt << 1, false));
  }
  
  public static ByteVector a(Iterable paramIterable, l.b.f.o paramO, boolean paramBoolean, int paramInt)
  {
    l.b.g.b.b.a(paramO, "zipper is null");
    l.b.g.b.b.a(paramIterable, "sources is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return l.b.k.a.a((ByteVector)new Eb(null, paramIterable, paramO, paramInt, paramBoolean));
  }
  
  public static ByteVector a(Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "The item is null");
    return l.b.k.a.a((ByteVector)new qa(paramObject));
  }
  
  public static ByteVector a(Object paramObject1, Object paramObject2)
  {
    l.b.g.b.b.a(paramObject1, "The first item is null");
    l.b.g.b.b.a(paramObject2, "The second item is null");
    return a(new Object[] { paramObject1, paramObject2 });
  }
  
  public static ByteVector a(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    l.b.g.b.b.a(paramObject1, "The first item is null");
    l.b.g.b.b.a(paramObject2, "The second item is null");
    l.b.g.b.b.a(paramObject3, "The third item is null");
    return a(new Object[] { paramObject1, paramObject2, paramObject3 });
  }
  
  public static ByteVector a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4)
  {
    l.b.g.b.b.a(paramObject1, "The first item is null");
    l.b.g.b.b.a(paramObject2, "The second item is null");
    l.b.g.b.b.a(paramObject3, "The third item is null");
    l.b.g.b.b.a(paramObject4, "The fourth item is null");
    return a(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4 });
  }
  
  public static ByteVector a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5)
  {
    l.b.g.b.b.a(paramObject1, "The first item is null");
    l.b.g.b.b.a(paramObject2, "The second item is null");
    l.b.g.b.b.a(paramObject3, "The third item is null");
    l.b.g.b.b.a(paramObject4, "The fourth item is null");
    l.b.g.b.b.a(paramObject5, "The fifth item is null");
    return a(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5 });
  }
  
  public static ByteVector a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6)
  {
    l.b.g.b.b.a(paramObject1, "The first item is null");
    l.b.g.b.b.a(paramObject2, "The second item is null");
    l.b.g.b.b.a(paramObject3, "The third item is null");
    l.b.g.b.b.a(paramObject4, "The fourth item is null");
    l.b.g.b.b.a(paramObject5, "The fifth item is null");
    l.b.g.b.b.a(paramObject6, "The sixth item is null");
    return a(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6 });
  }
  
  public static ByteVector a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7)
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
  
  public static ByteVector a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8)
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
  
  public static ByteVector a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8, Object paramObject9)
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
    return a(new Object[] { paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7, paramObject8, paramObject9 });
  }
  
  public static ByteVector a(Object paramObject1, Object paramObject2, Object paramObject3, Object paramObject4, Object paramObject5, Object paramObject6, Object paramObject7, Object paramObject8, Object paramObject9, Object paramObject10)
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
  
  public static ByteVector a(Throwable paramThrowable)
  {
    l.b.g.b.b.a(paramThrowable, "e is null");
    return b(l.b.g.b.a.b(paramThrowable));
  }
  
  public static ByteVector a(Callable paramCallable)
  {
    l.b.g.b.b.a(paramCallable, "supplier is null");
    return l.b.k.a.a((ByteVector)new ba(paramCallable));
  }
  
  public static ByteVector a(Callable paramCallable, l.b.f.b paramB, l.b.f.g paramG)
  {
    l.b.g.b.b.a(paramB, "generator  is null");
    return a(paramCallable, new ma.q(paramB), paramG);
  }
  
  public static ByteVector a(Callable paramCallable, l.b.f.c paramC, l.b.f.g paramG)
  {
    l.b.g.b.b.a(paramCallable, "initialState is null");
    l.b.g.b.b.a(paramC, "generator  is null");
    l.b.g.b.b.a(paramG, "disposeState is null");
    return l.b.k.a.a((ByteVector)new ga(paramCallable, paramC, paramG));
  }
  
  public static ByteVector a(Callable paramCallable, l.b.f.o paramO, l.b.f.g paramG)
  {
    return a(paramCallable, paramO, paramG, true);
  }
  
  public static ByteVector a(Callable paramCallable, l.b.f.o paramO, l.b.f.g paramG, boolean paramBoolean)
  {
    l.b.g.b.b.a(paramCallable, "resourceSupplier is null");
    l.b.g.b.b.a(paramO, "sourceSupplier is null");
    l.b.g.b.b.a(paramG, "disposer is null");
    return l.b.k.a.a((ByteVector)new wb(paramCallable, paramO, paramG, paramBoolean));
  }
  
  public static ByteVector a(Future paramFuture)
  {
    l.b.g.b.b.a(paramFuture, "future is null");
    return l.b.k.a.a((ByteVector)new ca(paramFuture, 0L, null));
  }
  
  public static ByteVector a(Future paramFuture, long paramLong, TimeUnit paramTimeUnit)
  {
    l.b.g.b.b.a(paramFuture, "future is null");
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    return l.b.k.a.a((ByteVector)new ca(paramFuture, paramLong, paramTimeUnit));
  }
  
  public static ByteVector a(Future paramFuture, long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    l.b.g.b.b.a(paramG, "scheduler is null");
    return a(paramFuture, paramLong, paramTimeUnit).b(paramG);
  }
  
  public static ByteVector a(Future paramFuture, G paramG)
  {
    l.b.g.b.b.a(paramG, "scheduler is null");
    return a(paramFuture).b(paramG);
  }
  
  public static ByteVector a(B paramB)
  {
    l.b.g.b.b.a(paramB, "source is null");
    return l.b.k.a.a((ByteVector)new z(paramB));
  }
  
  public static ByteVector a(Label paramLabel)
  {
    l.b.g.b.b.a(paramLabel, "source is null");
    if ((paramLabel instanceof ByteVector)) {
      return l.b.k.a.a((ByteVector)paramLabel);
    }
    return l.b.k.a.a((ByteVector)new fa(paramLabel));
  }
  
  public static ByteVector a(Label paramLabel, int paramInt)
  {
    l.b.g.b.b.a(paramLabel, "sources is null");
    l.b.g.b.b.a(paramInt, "prefetch");
    return l.b.k.a.a((ByteVector)new l.b.g.e.d.v(paramLabel, l.b.g.b.a.a, paramInt, l.b.g.j.j.a));
  }
  
  public static ByteVector a(Label paramLabel, int paramInt1, int paramInt2)
  {
    l.b.g.b.b.a(Integer.valueOf(paramInt1), "maxConcurrency is null");
    l.b.g.b.b.a(Integer.valueOf(paramInt2), "prefetch is null");
    return a(paramLabel).a(l.b.g.b.a.a, paramInt1, paramInt2);
  }
  
  public static ByteVector a(Label paramLabel, int paramInt, boolean paramBoolean)
  {
    l.b.g.b.b.a(paramLabel, "sources is null");
    l.b.g.b.b.a(paramInt, "prefetch is null");
    l.b.f.o localO = l.b.g.b.a.a;
    l.b.g.j.j localJ;
    if (paramBoolean) {
      localJ = l.b.g.j.j.c;
    } else {
      localJ = l.b.g.j.j.b;
    }
    return l.b.k.a.a((ByteVector)new l.b.g.e.d.v(paramLabel, localO, paramInt, localJ));
  }
  
  public static ByteVector a(Label paramLabel1, Label paramLabel2)
  {
    l.b.g.b.b.a(paramLabel1, "source1 is null");
    l.b.g.b.b.a(paramLabel2, "source2 is null");
    return a(new Label[] { paramLabel1, paramLabel2 }).a(l.b.g.b.a.a, true, 2);
  }
  
  public static ByteVector a(Label paramLabel1, Label paramLabel2, Label paramLabel3)
  {
    l.b.g.b.b.a(paramLabel1, "source1 is null");
    l.b.g.b.b.a(paramLabel2, "source2 is null");
    l.b.g.b.b.a(paramLabel3, "source3 is null");
    return a(new Label[] { paramLabel1, paramLabel2, paramLabel3 }).a(l.b.g.b.a.a, false, 3);
  }
  
  public static ByteVector a(Label paramLabel1, Label paramLabel2, Label paramLabel3, Label paramLabel4)
  {
    l.b.g.b.b.a(paramLabel1, "source1 is null");
    l.b.g.b.b.a(paramLabel2, "source2 is null");
    l.b.g.b.b.a(paramLabel3, "source3 is null");
    l.b.g.b.b.a(paramLabel4, "source4 is null");
    return a(new Label[] { paramLabel1, paramLabel2, paramLabel3, paramLabel4 }).a(l.b.g.b.a.a, true, 4);
  }
  
  public static ByteVector a(Label paramLabel1, Label paramLabel2, Label paramLabel3, Label paramLabel4, Label paramLabel5, Label paramLabel6, Label paramLabel7, Label paramLabel8, Label paramLabel9, l.b.f.n paramN)
  {
    l.b.g.b.b.a(paramLabel1, "source1 is null");
    l.b.g.b.b.a(paramLabel2, "source2 is null");
    l.b.g.b.b.a(paramLabel3, "source3 is null");
    l.b.g.b.b.a(paramLabel4, "source4 is null");
    l.b.g.b.b.a(paramLabel5, "source5 is null");
    l.b.g.b.b.a(paramLabel6, "source6 is null");
    l.b.g.b.b.a(paramLabel7, "source7 is null");
    l.b.g.b.b.a(paramLabel8, "source8 is null");
    l.b.g.b.b.a(paramLabel9, "source9 is null");
    paramN = l.b.g.b.a.a(paramN);
    int i = h.a;
    return b(new Label[] { paramLabel1, paramLabel2, paramLabel3, paramLabel4, paramLabel5, paramLabel6, paramLabel7, paramLabel8, paramLabel9 }, paramN, i);
  }
  
  public static ByteVector a(Label paramLabel1, Label paramLabel2, Label paramLabel3, Label paramLabel4, Label paramLabel5, Label paramLabel6, Label paramLabel7, Label paramLabel8, l.b.f.m paramM)
  {
    l.b.g.b.b.a(paramLabel1, "source1 is null");
    l.b.g.b.b.a(paramLabel2, "source2 is null");
    l.b.g.b.b.a(paramLabel3, "source3 is null");
    l.b.g.b.b.a(paramLabel4, "source4 is null");
    l.b.g.b.b.a(paramLabel5, "source5 is null");
    l.b.g.b.b.a(paramLabel6, "source6 is null");
    l.b.g.b.b.a(paramLabel7, "source7 is null");
    l.b.g.b.b.a(paramLabel8, "source8 is null");
    paramM = l.b.g.b.a.a(paramM);
    int i = h.a;
    return b(new Label[] { paramLabel1, paramLabel2, paramLabel3, paramLabel4, paramLabel5, paramLabel6, paramLabel7, paramLabel8 }, paramM, i);
  }
  
  public static ByteVector a(Label paramLabel1, Label paramLabel2, Label paramLabel3, Label paramLabel4, Label paramLabel5, Label paramLabel6, Label paramLabel7, l.b.f.l paramL)
  {
    l.b.g.b.b.a(paramLabel1, "source1 is null");
    l.b.g.b.b.a(paramLabel2, "source2 is null");
    l.b.g.b.b.a(paramLabel3, "source3 is null");
    l.b.g.b.b.a(paramLabel4, "source4 is null");
    l.b.g.b.b.a(paramLabel5, "source5 is null");
    l.b.g.b.b.a(paramLabel6, "source6 is null");
    l.b.g.b.b.a(paramLabel7, "source7 is null");
    paramL = l.b.g.b.a.a(paramL);
    int i = h.a;
    return b(new Label[] { paramLabel1, paramLabel2, paramLabel3, paramLabel4, paramLabel5, paramLabel6, paramLabel7 }, paramL, i);
  }
  
  public static ByteVector a(Label paramLabel1, Label paramLabel2, Label paramLabel3, Label paramLabel4, Label paramLabel5, Label paramLabel6, l.b.f.k paramK)
  {
    l.b.g.b.b.a(paramLabel1, "source1 is null");
    l.b.g.b.b.a(paramLabel2, "source2 is null");
    l.b.g.b.b.a(paramLabel3, "source3 is null");
    l.b.g.b.b.a(paramLabel4, "source4 is null");
    l.b.g.b.b.a(paramLabel5, "source5 is null");
    l.b.g.b.b.a(paramLabel6, "source6 is null");
    paramK = l.b.g.b.a.a(paramK);
    int i = h.a;
    return b(new Label[] { paramLabel1, paramLabel2, paramLabel3, paramLabel4, paramLabel5, paramLabel6 }, paramK, i);
  }
  
  public static ByteVector a(Label paramLabel1, Label paramLabel2, Label paramLabel3, Label paramLabel4, Label paramLabel5, l.b.f.j paramJ)
  {
    l.b.g.b.b.a(paramLabel1, "source1 is null");
    l.b.g.b.b.a(paramLabel2, "source2 is null");
    l.b.g.b.b.a(paramLabel3, "source3 is null");
    l.b.g.b.b.a(paramLabel4, "source4 is null");
    l.b.g.b.b.a(paramLabel5, "source5 is null");
    paramJ = l.b.g.b.a.a(paramJ);
    int i = h.a;
    return b(new Label[] { paramLabel1, paramLabel2, paramLabel3, paramLabel4, paramLabel5 }, paramJ, i);
  }
  
  public static ByteVector a(Label paramLabel1, Label paramLabel2, Label paramLabel3, Label paramLabel4, i paramI)
  {
    l.b.g.b.b.a(paramLabel1, "source1 is null");
    l.b.g.b.b.a(paramLabel2, "source2 is null");
    l.b.g.b.b.a(paramLabel3, "source3 is null");
    l.b.g.b.b.a(paramLabel4, "source4 is null");
    paramI = l.b.g.b.a.a(paramI);
    int i = h.a;
    return b(new Label[] { paramLabel1, paramLabel2, paramLabel3, paramLabel4 }, paramI, i);
  }
  
  public static ByteVector a(Label paramLabel1, Label paramLabel2, Label paramLabel3, l.b.f.h paramH)
  {
    l.b.g.b.b.a(paramLabel1, "source1 is null");
    l.b.g.b.b.a(paramLabel2, "source2 is null");
    l.b.g.b.b.a(paramLabel3, "source3 is null");
    paramH = l.b.g.b.a.a(paramH);
    int i = h.a;
    return b(new Label[] { paramLabel1, paramLabel2, paramLabel3 }, paramH, i);
  }
  
  public static ByteVector a(Label paramLabel1, Label paramLabel2, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramLabel1, "source1 is null");
    l.b.g.b.b.a(paramLabel2, "source2 is null");
    paramC = l.b.g.b.a.a(paramC);
    int i = h.a;
    return b(new Label[] { paramLabel1, paramLabel2 }, paramC, i);
  }
  
  public static ByteVector a(Label paramLabel1, Label paramLabel2, l.b.f.c paramC, boolean paramBoolean)
  {
    l.b.g.b.b.a(paramLabel1, "source1 is null");
    l.b.g.b.b.a(paramLabel2, "source2 is null");
    return a(l.b.g.b.a.a(paramC), paramBoolean, h.a, new Label[] { paramLabel1, paramLabel2 });
  }
  
  public static ByteVector a(Label paramLabel1, Label paramLabel2, l.b.f.c paramC, boolean paramBoolean, int paramInt)
  {
    l.b.g.b.b.a(paramLabel1, "source1 is null");
    l.b.g.b.b.a(paramLabel2, "source2 is null");
    return a(l.b.g.b.a.a(paramC), paramBoolean, paramInt, new Label[] { paramLabel1, paramLabel2 });
  }
  
  private ByteVector a(l.b.f.g paramG1, l.b.f.g paramG2, l.b.f.a paramA1, l.b.f.a paramA2)
  {
    l.b.g.b.b.a(paramG1, "onNext is null");
    l.b.g.b.b.a(paramG2, "onError is null");
    l.b.g.b.b.a(paramA1, "onComplete is null");
    l.b.g.b.b.a(paramA2, "onAfterTerminate is null");
    return l.b.k.a.a((ByteVector)new L(this, paramG1, paramG2, paramA1, paramA2));
  }
  
  public static ByteVector a(l.b.f.o paramO, int paramInt, Label... paramVarArgs)
  {
    return b(paramVarArgs, paramO, paramInt);
  }
  
  public static ByteVector a(l.b.f.o paramO, boolean paramBoolean, int paramInt, Label... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return a();
    }
    l.b.g.b.b.a(paramO, "zipper is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return l.b.k.a.a((ByteVector)new Eb(paramVarArgs, null, paramO, paramInt, paramBoolean));
  }
  
  public static ByteVector a(Publisher paramPublisher)
  {
    l.b.g.b.b.a(paramPublisher, "publisher is null");
    return l.b.k.a.a((ByteVector)new ea(paramPublisher));
  }
  
  public static ByteVector a(Object... paramVarArgs)
  {
    l.b.g.b.b.a(paramVarArgs, "items is null");
    if (paramVarArgs.length == 0) {
      return a();
    }
    if (paramVarArgs.length == 1) {
      return a(paramVarArgs[0]);
    }
    return l.b.k.a.a((ByteVector)new aa(paramVarArgs));
  }
  
  public static ByteVector a(Label... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return a();
    }
    if (paramVarArgs.length == 1) {
      return a(paramVarArgs[0]);
    }
    return l.b.k.a.a((ByteVector)new l.b.g.e.d.v(a(paramVarArgs), l.b.g.b.a.a, h.a, l.b.g.j.j.b));
  }
  
  public static ByteVector a(Label[] paramArrayOfLabel, l.b.f.o paramO, int paramInt)
  {
    l.b.g.b.b.a(paramInt, "bufferSize");
    l.b.g.b.b.a(paramO, "combiner is null");
    if (paramArrayOfLabel.length == 0) {
      return a();
    }
    return l.b.k.a.a((ByteVector)new l.b.g.e.d.u(paramArrayOfLabel, null, paramO, paramInt << 1, true));
  }
  
  public static ExtensionData a(Label paramLabel1, Label paramLabel2, int paramInt)
  {
    return a(paramLabel1, paramLabel2, l.b.g.b.b.a, paramInt);
  }
  
  public static ExtensionData a(Label paramLabel1, Label paramLabel2, l.b.f.d paramD)
  {
    return a(paramLabel1, paramLabel2, paramD, h.a);
  }
  
  public static ExtensionData a(Label paramLabel1, Label paramLabel2, l.b.f.d paramD, int paramInt)
  {
    l.b.g.b.b.a(paramLabel1, "source1 is null");
    l.b.g.b.b.a(paramLabel2, "source2 is null");
    l.b.g.b.b.a(paramD, "isEqual is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return l.b.k.a.a((ExtensionData)new Wa(paramLabel1, paramLabel2, paramD, paramInt));
  }
  
  public static ByteVector add(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return a(paramLong1, paramLong2, paramTimeUnit, l.b.m.a.a());
  }
  
  public static ByteVector add(long paramLong, TimeUnit paramTimeUnit)
  {
    return a(paramLong, paramTimeUnit, l.b.m.a.a());
  }
  
  public static ByteVector add(Iterable paramIterable)
  {
    int i = h.a;
    return a(paramIterable, i, i);
  }
  
  public static ByteVector add(Iterable paramIterable, int paramInt1, int paramInt2)
  {
    return a(paramIterable).a(l.b.g.b.a.a, false, paramInt1, paramInt2);
  }
  
  public static ByteVector b(int paramInt1, int paramInt2, Label... paramVarArgs)
  {
    return a(paramVarArgs).a(l.b.g.b.a.a, true, paramInt1, paramInt2);
  }
  
  public static ByteVector b(long paramLong1, long paramLong2, long paramLong3, long paramLong4, TimeUnit paramTimeUnit)
  {
    return a(paramLong1, paramLong2, paramLong3, paramLong4, paramTimeUnit, l.b.m.a.a());
  }
  
  public static ByteVector b(Iterable paramIterable)
  {
    l.b.g.b.b.a(paramIterable, "sources is null");
    return a(paramIterable).a(l.b.g.b.a.a, h.a, false);
  }
  
  public static ByteVector b(Iterable paramIterable, int paramInt)
  {
    return a(paramIterable).a(l.b.g.b.a.a, true, paramInt);
  }
  
  public static ByteVector b(Iterable paramIterable, int paramInt1, int paramInt2)
  {
    return a(paramIterable).a(l.b.g.b.a.a, true, paramInt1, paramInt2);
  }
  
  public static ByteVector b(Iterable paramIterable, l.b.f.o paramO)
  {
    return a(paramIterable, paramO, h.a);
  }
  
  public static ByteVector b(Iterable paramIterable, l.b.f.o paramO, int paramInt)
  {
    l.b.g.b.b.a(paramIterable, "sources is null");
    l.b.g.b.b.a(paramO, "combiner is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return l.b.k.a.a((ByteVector)new l.b.g.e.d.u(null, paramIterable, paramO, paramInt << 1, true));
  }
  
  public static ByteVector b(Callable paramCallable)
  {
    l.b.g.b.b.a(paramCallable, "errorSupplier is null");
    return l.b.k.a.a((ByteVector)new S(paramCallable));
  }
  
  public static ByteVector b(Callable paramCallable, l.b.f.b paramB)
  {
    l.b.g.b.b.a(paramB, "generator  is null");
    return a(paramCallable, new ma.q(paramB), l.b.g.b.a.d);
  }
  
  public static ByteVector b(Callable paramCallable, l.b.f.c paramC)
  {
    return a(paramCallable, paramC, l.b.g.b.a.d);
  }
  
  public static ByteVector b(Label paramLabel)
  {
    l.b.g.b.b.a(paramLabel, "sources is null");
    return l.b.k.a.a((ByteVector)new U(paramLabel, l.b.g.b.a.a, false, Integer.MAX_VALUE, h.a));
  }
  
  public static ByteVector b(Label paramLabel, int paramInt)
  {
    l.b.g.b.b.a(paramLabel, "sources is null");
    l.b.g.b.b.a(paramInt, "maxConcurrency");
    return l.b.k.a.a((ByteVector)new U(paramLabel, l.b.g.b.a.a, true, paramInt, h.a));
  }
  
  public static ByteVector b(Label paramLabel1, Label paramLabel2)
  {
    l.b.g.b.b.a(paramLabel1, "source1 is null");
    l.b.g.b.b.a(paramLabel2, "source2 is null");
    return a(new Label[] { paramLabel1, paramLabel2 }).a(l.b.g.b.a.a, false, 2);
  }
  
  public static ByteVector b(Label paramLabel1, Label paramLabel2, Label paramLabel3)
  {
    l.b.g.b.b.a(paramLabel1, "source1 is null");
    l.b.g.b.b.a(paramLabel2, "source2 is null");
    l.b.g.b.b.a(paramLabel3, "source3 is null");
    return a(new Label[] { paramLabel1, paramLabel2, paramLabel3 }).a(l.b.g.b.a.a, true, 3);
  }
  
  public static ByteVector b(Label paramLabel1, Label paramLabel2, Label paramLabel3, Label paramLabel4)
  {
    l.b.g.b.b.a(paramLabel1, "source1 is null");
    l.b.g.b.b.a(paramLabel2, "source2 is null");
    l.b.g.b.b.a(paramLabel3, "source3 is null");
    l.b.g.b.b.a(paramLabel4, "source4 is null");
    return a(new Label[] { paramLabel1, paramLabel2, paramLabel3, paramLabel4 }).a(l.b.g.b.a.a, false, 4);
  }
  
  public static ByteVector b(Label paramLabel1, Label paramLabel2, Label paramLabel3, Label paramLabel4, Label paramLabel5, Label paramLabel6, Label paramLabel7, Label paramLabel8, Label paramLabel9, l.b.f.n paramN)
  {
    l.b.g.b.b.a(paramLabel1, "source1 is null");
    l.b.g.b.b.a(paramLabel2, "source2 is null");
    l.b.g.b.b.a(paramLabel3, "source3 is null");
    l.b.g.b.b.a(paramLabel4, "source4 is null");
    l.b.g.b.b.a(paramLabel5, "source5 is null");
    l.b.g.b.b.a(paramLabel6, "source6 is null");
    l.b.g.b.b.a(paramLabel7, "source7 is null");
    l.b.g.b.b.a(paramLabel8, "source8 is null");
    l.b.g.b.b.a(paramLabel9, "source9 is null");
    return a(l.b.g.b.a.a(paramN), false, h.a, new Label[] { paramLabel1, paramLabel2, paramLabel3, paramLabel4, paramLabel5, paramLabel6, paramLabel7, paramLabel8, paramLabel9 });
  }
  
  public static ByteVector b(Label paramLabel1, Label paramLabel2, Label paramLabel3, Label paramLabel4, Label paramLabel5, Label paramLabel6, Label paramLabel7, Label paramLabel8, l.b.f.m paramM)
  {
    l.b.g.b.b.a(paramLabel1, "source1 is null");
    l.b.g.b.b.a(paramLabel2, "source2 is null");
    l.b.g.b.b.a(paramLabel3, "source3 is null");
    l.b.g.b.b.a(paramLabel4, "source4 is null");
    l.b.g.b.b.a(paramLabel5, "source5 is null");
    l.b.g.b.b.a(paramLabel6, "source6 is null");
    l.b.g.b.b.a(paramLabel7, "source7 is null");
    l.b.g.b.b.a(paramLabel8, "source8 is null");
    return a(l.b.g.b.a.a(paramM), false, h.a, new Label[] { paramLabel1, paramLabel2, paramLabel3, paramLabel4, paramLabel5, paramLabel6, paramLabel7, paramLabel8 });
  }
  
  public static ByteVector b(Label paramLabel1, Label paramLabel2, Label paramLabel3, Label paramLabel4, Label paramLabel5, Label paramLabel6, Label paramLabel7, l.b.f.l paramL)
  {
    l.b.g.b.b.a(paramLabel1, "source1 is null");
    l.b.g.b.b.a(paramLabel2, "source2 is null");
    l.b.g.b.b.a(paramLabel3, "source3 is null");
    l.b.g.b.b.a(paramLabel4, "source4 is null");
    l.b.g.b.b.a(paramLabel5, "source5 is null");
    l.b.g.b.b.a(paramLabel6, "source6 is null");
    l.b.g.b.b.a(paramLabel7, "source7 is null");
    return a(l.b.g.b.a.a(paramL), false, h.a, new Label[] { paramLabel1, paramLabel2, paramLabel3, paramLabel4, paramLabel5, paramLabel6, paramLabel7 });
  }
  
  public static ByteVector b(Label paramLabel1, Label paramLabel2, Label paramLabel3, Label paramLabel4, Label paramLabel5, Label paramLabel6, l.b.f.k paramK)
  {
    l.b.g.b.b.a(paramLabel1, "source1 is null");
    l.b.g.b.b.a(paramLabel2, "source2 is null");
    l.b.g.b.b.a(paramLabel3, "source3 is null");
    l.b.g.b.b.a(paramLabel4, "source4 is null");
    l.b.g.b.b.a(paramLabel5, "source5 is null");
    l.b.g.b.b.a(paramLabel6, "source6 is null");
    return a(l.b.g.b.a.a(paramK), false, h.a, new Label[] { paramLabel1, paramLabel2, paramLabel3, paramLabel4, paramLabel5, paramLabel6 });
  }
  
  public static ByteVector b(Label paramLabel1, Label paramLabel2, Label paramLabel3, Label paramLabel4, Label paramLabel5, l.b.f.j paramJ)
  {
    l.b.g.b.b.a(paramLabel1, "source1 is null");
    l.b.g.b.b.a(paramLabel2, "source2 is null");
    l.b.g.b.b.a(paramLabel3, "source3 is null");
    l.b.g.b.b.a(paramLabel4, "source4 is null");
    l.b.g.b.b.a(paramLabel5, "source5 is null");
    return a(l.b.g.b.a.a(paramJ), false, h.a, new Label[] { paramLabel1, paramLabel2, paramLabel3, paramLabel4, paramLabel5 });
  }
  
  public static ByteVector b(Label paramLabel1, Label paramLabel2, Label paramLabel3, Label paramLabel4, i paramI)
  {
    l.b.g.b.b.a(paramLabel1, "source1 is null");
    l.b.g.b.b.a(paramLabel2, "source2 is null");
    l.b.g.b.b.a(paramLabel3, "source3 is null");
    l.b.g.b.b.a(paramLabel4, "source4 is null");
    return a(l.b.g.b.a.a(paramI), false, h.a, new Label[] { paramLabel1, paramLabel2, paramLabel3, paramLabel4 });
  }
  
  public static ByteVector b(Label paramLabel1, Label paramLabel2, Label paramLabel3, l.b.f.h paramH)
  {
    l.b.g.b.b.a(paramLabel1, "source1 is null");
    l.b.g.b.b.a(paramLabel2, "source2 is null");
    l.b.g.b.b.a(paramLabel3, "source3 is null");
    return a(l.b.g.b.a.a(paramH), false, h.a, new Label[] { paramLabel1, paramLabel2, paramLabel3 });
  }
  
  public static ByteVector b(Label paramLabel1, Label paramLabel2, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramLabel1, "source1 is null");
    l.b.g.b.b.a(paramLabel2, "source2 is null");
    return a(l.b.g.b.a.a(paramC), false, h.a, new Label[] { paramLabel1, paramLabel2 });
  }
  
  private ByteVector b(Label paramLabel1, l.b.f.o paramO, Label paramLabel2)
  {
    l.b.g.b.b.a(paramO, "itemTimeoutIndicator is null");
    return l.b.k.a.a((ByteVector)new qb(this, paramLabel1, paramO, paramLabel2));
  }
  
  public static ByteVector b(l.b.f.g paramG)
  {
    l.b.g.b.b.a(paramG, "generator  is null");
    return a(l.b.g.b.a.j, new ma.r(paramG), l.b.g.b.a.d);
  }
  
  public static ByteVector b(l.b.f.o paramO, int paramInt, Label... paramVarArgs)
  {
    return a(paramVarArgs, paramO, paramInt);
  }
  
  public static ByteVector b(Label... paramVarArgs)
  {
    l.b.g.b.b.a(paramVarArgs, "sources is null");
    int i = paramVarArgs.length;
    if (i == 0) {
      return a();
    }
    if (i == 1) {
      return a(paramVarArgs[0]);
    }
    return l.b.k.a.a((ByteVector)new l.b.g.e.d.h(paramVarArgs, null));
  }
  
  public static ByteVector b(Label[] paramArrayOfLabel, l.b.f.o paramO)
  {
    return b(paramArrayOfLabel, paramO, h.a);
  }
  
  public static ByteVector b(Label[] paramArrayOfLabel, l.b.f.o paramO, int paramInt)
  {
    l.b.g.b.b.a(paramArrayOfLabel, "sources is null");
    if (paramArrayOfLabel.length == 0) {
      return a();
    }
    l.b.g.b.b.a(paramO, "combiner is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return l.b.k.a.a((ByteVector)new l.b.g.e.d.u(paramArrayOfLabel, null, paramO, paramInt << 1, false));
  }
  
  public static ByteVector c(Iterable paramIterable)
  {
    l.b.g.b.b.a(paramIterable, "sources is null");
    return l.b.k.a.a((ByteVector)new l.b.g.e.d.h(null, paramIterable));
  }
  
  public static ByteVector c(Label paramLabel, int paramInt)
  {
    l.b.g.b.b.a(paramLabel, "sources is null");
    l.b.g.b.b.a(paramInt, "maxConcurrency");
    return l.b.k.a.a((ByteVector)new U(paramLabel, l.b.g.b.a.a, false, paramInt, h.a));
  }
  
  public static ByteVector c(Label paramLabel1, Label paramLabel2)
  {
    l.b.g.b.b.a(paramLabel1, "source1 is null");
    l.b.g.b.b.a(paramLabel2, "source2 is null");
    return a(new Label[] { paramLabel1, paramLabel2 });
  }
  
  public static ByteVector c(Label paramLabel, l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "zipper is null");
    l.b.g.b.b.a(paramLabel, "sources is null");
    paramLabel = new tb(paramLabel, 16);
    paramO = new ma.t(paramO);
    return l.b.k.a.a(((ByteVector)paramLabel).put(paramO));
  }
  
  public static ByteVector d(Iterable paramIterable, l.b.f.o paramO)
  {
    return b(paramIterable, paramO, h.a);
  }
  
  public static ByteVector d(Callable paramCallable)
  {
    l.b.g.b.b.a(paramCallable, "supplier is null");
    return l.b.k.a.a((ByteVector)new l.b.g.e.d.C(paramCallable));
  }
  
  public static ExtensionData d(Label paramLabel1, Label paramLabel2)
  {
    return a(paramLabel1, paramLabel2, l.b.g.b.b.a, h.a);
  }
  
  public static ByteVector encodeUTF8()
  {
    return l.b.k.a.a(xa.a);
  }
  
  public static ByteVector encodeUTF8(int paramInt1, int paramInt2, Label... paramVarArgs)
  {
    return a(paramVarArgs).a(l.b.g.b.a.a, false, paramInt1, paramInt2);
  }
  
  public static ByteVector encodeUTF8(long paramLong, TimeUnit paramTimeUnit)
  {
    return a(paramLong, paramLong, paramTimeUnit, l.b.m.a.a());
  }
  
  public static ByteVector encodeUTF8(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return a(paramLong, paramLong, paramTimeUnit, paramG);
  }
  
  public static ByteVector encodeUTF8(Label paramLabel)
  {
    int i = h.a;
    return a(paramLabel, i, i);
  }
  
  public static ByteVector encodeUTF8(Label... paramVarArgs)
  {
    int i = h.a;
    return a(i, i, paramVarArgs);
  }
  
  public static ByteVector get(Label paramLabel)
  {
    return set(paramLabel, h.a);
  }
  
  public static int m()
  {
    return h.a;
  }
  
  public static ByteVector putByteArray(Label paramLabel)
  {
    return a(paramLabel, h.a);
  }
  
  public static ByteVector putInt(Iterable paramIterable)
  {
    return a(paramIterable).put(l.b.g.b.a.a);
  }
  
  public static ByteVector putInt(Label paramLabel1, Label paramLabel2, Label paramLabel3)
  {
    l.b.g.b.b.a(paramLabel1, "source1 is null");
    l.b.g.b.b.a(paramLabel2, "source2 is null");
    l.b.g.b.b.a(paramLabel3, "source3 is null");
    return a(new Label[] { paramLabel1, paramLabel2, paramLabel3 });
  }
  
  public static ByteVector putInt(Label paramLabel1, Label paramLabel2, Label paramLabel3, Label paramLabel4)
  {
    l.b.g.b.b.a(paramLabel1, "source1 is null");
    l.b.g.b.b.a(paramLabel2, "source2 is null");
    l.b.g.b.b.a(paramLabel3, "source3 is null");
    l.b.g.b.b.a(paramLabel4, "source4 is null");
    return a(new Label[] { paramLabel1, paramLabel2, paramLabel3, paramLabel4 });
  }
  
  public static ByteVector putLong(Iterable paramIterable)
  {
    return a(paramIterable).add(l.b.g.b.a.a, true);
  }
  
  public static ByteVector putShort(Iterable paramIterable)
  {
    l.b.g.b.b.a(paramIterable, "sources is null");
    return putShort(a(paramIterable));
  }
  
  public static ByteVector putShort(Iterable paramIterable, int paramInt)
  {
    return a(paramIterable).putShort(l.b.g.b.a.a, paramInt);
  }
  
  public static ByteVector putShort(Label paramLabel)
  {
    return a(paramLabel, h.a, true);
  }
  
  public static ByteVector putShort(Label... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return a();
    }
    if (paramVarArgs.length == 1) {
      return a(paramVarArgs[0]);
    }
    return putShort(a(paramVarArgs));
  }
  
  public static ByteVector putUTF8(Label... paramVarArgs)
  {
    return a(paramVarArgs).a(l.b.g.b.a.a, true, paramVarArgs.length);
  }
  
  public static ByteVector putUTF8(Label[] paramArrayOfLabel, l.b.f.o paramO)
  {
    return a(paramArrayOfLabel, paramO, h.a);
  }
  
  public static ByteVector read(Label... paramVarArgs)
  {
    return a(paramVarArgs).putShort(l.b.g.b.a.a, paramVarArgs.length);
  }
  
  public static ByteVector set(Label paramLabel)
  {
    l.b.g.b.b.a(paramLabel, "source is null");
    l.b.g.b.b.a(paramLabel, "onSubscribe is null");
    if (!(paramLabel instanceof ByteVector)) {
      return l.b.k.a.a((ByteVector)new fa(paramLabel));
    }
    throw new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
  }
  
  public static ByteVector set(Label paramLabel, int paramInt)
  {
    l.b.g.b.b.a(paramLabel, "sources is null");
    l.b.g.b.b.a(paramInt, "prefetch");
    return l.b.k.a.a((ByteVector)new gb(paramLabel, l.b.g.b.a.a, paramInt, true));
  }
  
  public static ByteVector setEnabled(Label paramLabel)
  {
    l.b.g.b.b.a(paramLabel, "sources is null");
    return l.b.k.a.a((ByteVector)new U(paramLabel, l.b.g.b.a.a, true, Integer.MAX_VALUE, h.a));
  }
  
  public static ByteVector write(Label paramLabel)
  {
    return write(paramLabel, h.a);
  }
  
  public static ByteVector write(Label paramLabel, int paramInt)
  {
    l.b.g.b.b.a(paramLabel, "sources is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return l.b.k.a.a((ByteVector)new gb(paramLabel, l.b.g.b.a.a, paramInt, false));
  }
  
  public final ByteVector a(int paramInt1, int paramInt2, Callable paramCallable)
  {
    l.b.g.b.b.a(paramInt1, "count");
    l.b.g.b.b.a(paramInt2, "skip");
    l.b.g.b.b.a(paramCallable, "bufferSupplier is null");
    return l.b.k.a.a((ByteVector)new l.b.g.e.d.m(this, paramInt1, paramInt2, paramCallable));
  }
  
  public final ByteVector a(long paramLong)
  {
    if (paramLong >= 0L) {
      return l.b.k.a.a((ByteVector)new hb(this, paramLong));
    }
    throw new IllegalArgumentException(StringBuilder.get("count >= 0 required but it was ", paramLong));
  }
  
  public final ByteVector a(long paramLong1, long paramLong2, int paramInt)
  {
    l.b.g.b.b.a(paramLong1, "count");
    l.b.g.b.b.a(paramLong2, "skip");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return l.b.k.a.a((ByteVector)new xb(this, paramLong1, paramLong2, paramInt));
  }
  
  public final ByteVector a(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return a(paramLong1, paramLong2, paramTimeUnit, l.b.m.a.a(), (Callable)l.b.g.j.b.a);
  }
  
  public final ByteVector a(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, G paramG, int paramInt)
  {
    l.b.g.b.b.a(paramLong1, "timespan");
    l.b.g.b.b.a(paramLong2, "timeskip");
    l.b.g.b.b.a(paramInt, "bufferSize");
    l.b.g.b.b.a(paramG, "scheduler is null");
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    return l.b.k.a.a((ByteVector)new Bb(this, paramLong1, paramLong2, paramTimeUnit, paramG, Long.MAX_VALUE, paramInt, false));
  }
  
  public final ByteVector a(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, G paramG, Callable paramCallable)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    l.b.g.b.b.a(paramCallable, "bufferSupplier is null");
    return l.b.k.a.a((ByteVector)new q(this, paramLong1, paramLong2, paramTimeUnit, paramG, paramCallable, Integer.MAX_VALUE, false));
  }
  
  public final ByteVector a(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, G paramG, boolean paramBoolean, int paramInt)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    if (paramLong1 >= 0L) {
      return l.b.k.a.a((ByteVector)new kb(this, paramLong1, paramLong2, paramTimeUnit, paramG, paramInt, paramBoolean));
    }
    throw new IndexOutOfBoundsException(StringBuilder.get("count >= 0 required but it was ", paramLong1));
  }
  
  public final ByteVector a(long paramLong, TimeUnit paramTimeUnit)
  {
    return b(paramLong, paramTimeUnit, l.b.m.a.a(), Integer.MAX_VALUE);
  }
  
  public final ByteVector a(long paramLong, TimeUnit paramTimeUnit, int paramInt)
  {
    return b(paramLong, paramTimeUnit, l.b.m.a.a(), paramInt);
  }
  
  public final ByteVector a(long paramLong1, TimeUnit paramTimeUnit, long paramLong2)
  {
    return a(paramLong1, paramTimeUnit, l.b.m.a.a(), paramLong2, false);
  }
  
  public final ByteVector a(long paramLong1, TimeUnit paramTimeUnit, long paramLong2, boolean paramBoolean)
  {
    return a(paramLong1, paramTimeUnit, l.b.m.a.a(), paramLong2, paramBoolean);
  }
  
  public final ByteVector a(long paramLong, TimeUnit paramTimeUnit, G paramG, int paramInt, Callable paramCallable, boolean paramBoolean)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    l.b.g.b.b.a(paramCallable, "bufferSupplier is null");
    l.b.g.b.b.a(paramInt, "count");
    return l.b.k.a.a((ByteVector)new q(this, paramLong, paramLong, paramTimeUnit, paramG, paramCallable, paramInt, paramBoolean));
  }
  
  public final ByteVector a(long paramLong1, TimeUnit paramTimeUnit, G paramG, long paramLong2, boolean paramBoolean)
  {
    return a(paramLong1, paramTimeUnit, paramG, paramLong2, paramBoolean, h.a);
  }
  
  public final ByteVector a(long paramLong1, TimeUnit paramTimeUnit, G paramG, long paramLong2, boolean paramBoolean, int paramInt)
  {
    l.b.g.b.b.a(paramInt, "bufferSize");
    l.b.g.b.b.a(paramG, "scheduler is null");
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramLong2, "count");
    return l.b.k.a.a((ByteVector)new Bb(this, paramLong1, paramLong1, paramTimeUnit, paramG, paramLong2, paramInt, paramBoolean));
  }
  
  public final ByteVector a(long paramLong, TimeUnit paramTimeUnit, G paramG, Label paramLabel)
  {
    l.b.g.b.b.a(paramLabel, "other is null");
    return a(paramLong, paramTimeUnit, paramLabel, paramG);
  }
  
  public final ByteVector a(long paramLong, TimeUnit paramTimeUnit, G paramG, boolean paramBoolean)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((ByteVector)new l.b.g.e.d.D(this, paramLong, paramTimeUnit, paramG, paramBoolean));
  }
  
  public final ByteVector a(long paramLong, TimeUnit paramTimeUnit, G paramG, boolean paramBoolean, int paramInt)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return l.b.k.a.a((ByteVector)new bb(this, paramLong, paramTimeUnit, paramG, paramInt << 1, paramBoolean));
  }
  
  public final ByteVector a(long paramLong, TimeUnit paramTimeUnit, Label paramLabel)
  {
    l.b.g.b.b.a(paramLabel, "other is null");
    return a(paramLong, paramTimeUnit, paramLabel, l.b.m.a.a());
  }
  
  public final ByteVector a(long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean)
  {
    return b(paramLong, paramTimeUnit, l.b.m.a.d, paramBoolean, h.a);
  }
  
  public final ByteVector a(long paramLong, l.b.f.r paramR)
  {
    if (paramLong >= 0L)
    {
      l.b.g.b.b.a(paramR, "predicate is null");
      return l.b.k.a.a((ByteVector)new Oa(this, paramLong, paramR));
    }
    throw new IllegalArgumentException(StringBuilder.get("times >= 0 required but it was ", paramLong));
  }
  
  public final ByteVector a(Class paramClass)
  {
    l.b.g.b.b.a(paramClass, "clazz is null");
    return a(l.b.g.b.a.a(paramClass));
  }
  
  public final ByteVector a(Iterable paramIterable, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramIterable, "other is null");
    l.b.g.b.b.a(paramC, "zipper is null");
    return l.b.k.a.a((ByteVector)new Fb(this, paramIterable, paramC));
  }
  
  public final ByteVector a(Object paramObject, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramObject, "seed is null");
    return a(l.b.g.b.a.b(paramObject), paramC);
  }
  
  public final ByteVector a(Callable paramCallable, int paramInt)
  {
    l.b.g.b.b.a(paramCallable, "boundary is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return l.b.k.a.a((ByteVector)new Ab(this, paramCallable, paramInt));
  }
  
  public final ByteVector a(Callable paramCallable1, Callable paramCallable2)
  {
    l.b.g.b.b.a(paramCallable1, "boundarySupplier is null");
    l.b.g.b.b.a(paramCallable2, "bufferSupplier is null");
    return l.b.k.a.a((ByteVector)new l.b.g.e.d.o(this, paramCallable1, paramCallable2));
  }
  
  public final ByteVector a(Callable paramCallable, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramCallable, "seedSupplier is null");
    l.b.g.b.b.a(paramC, "accumulator is null");
    return l.b.k.a.a((ByteVector)new Ua(this, paramCallable, paramC));
  }
  
  public final ByteVector a(TimeUnit paramTimeUnit, G paramG)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((ByteVector)new pb(this, paramTimeUnit, paramG));
  }
  
  public final ByteVector a(C paramC)
  {
    l.b.g.b.b.a(paramC, "onLift is null");
    return l.b.k.a.a((ByteVector)new ta(this, paramC));
  }
  
  public final ByteVector a(E paramE)
  {
    l.b.g.b.b.a(paramE, "composer is null");
    return a(((E)paramE).a(this));
  }
  
  public final ByteVector a(G paramG)
  {
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((ByteVector)new vb(this, paramG));
  }
  
  public final ByteVector a(G paramG, boolean paramBoolean, int paramInt)
  {
    l.b.g.b.b.a(paramG, "scheduler is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return l.b.k.a.a((ByteVector)new ya(this, paramG, paramBoolean, paramInt));
  }
  
  public final ByteVector a(Label paramLabel, Callable paramCallable)
  {
    l.b.g.b.b.a(paramLabel, "boundary is null");
    l.b.g.b.b.a(paramCallable, "bufferSupplier is null");
    return l.b.k.a.a((ByteVector)new l.b.g.e.d.p(this, paramLabel, paramCallable));
  }
  
  public final ByteVector a(Label paramLabel1, Label paramLabel2, Label paramLabel3, Label paramLabel4, l.b.f.j paramJ)
  {
    l.b.g.b.b.a(paramLabel1, "o1 is null");
    l.b.g.b.b.a(paramLabel2, "o2 is null");
    l.b.g.b.b.a(paramLabel3, "o3 is null");
    l.b.g.b.b.a(paramLabel4, "o4 is null");
    l.b.g.b.b.a(paramJ, "combiner is null");
    paramJ = l.b.g.b.a.a(paramJ);
    return a(new Label[] { paramLabel1, paramLabel2, paramLabel3, paramLabel4 }, paramJ);
  }
  
  public final ByteVector a(Label paramLabel1, Label paramLabel2, Label paramLabel3, i paramI)
  {
    l.b.g.b.b.a(paramLabel1, "o1 is null");
    l.b.g.b.b.a(paramLabel2, "o2 is null");
    l.b.g.b.b.a(paramLabel3, "o3 is null");
    l.b.g.b.b.a(paramI, "combiner is null");
    paramI = l.b.g.b.a.a(paramI);
    return a(new Label[] { paramLabel1, paramLabel2, paramLabel3 }, paramI);
  }
  
  public final ByteVector a(Label paramLabel1, Label paramLabel2, l.b.f.h paramH)
  {
    l.b.g.b.b.a(paramLabel1, "o1 is null");
    l.b.g.b.b.a(paramLabel2, "o2 is null");
    l.b.g.b.b.a(paramH, "combiner is null");
    paramH = l.b.g.b.a.a(paramH);
    return a(new Label[] { paramLabel1, paramLabel2 }, paramH);
  }
  
  public final ByteVector a(Label paramLabel, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramLabel, "other is null");
    return b(this, paramLabel, paramC);
  }
  
  public final ByteVector a(Label paramLabel, l.b.f.c paramC, boolean paramBoolean)
  {
    return a(this, paramLabel, paramC, paramBoolean);
  }
  
  public final ByteVector a(Label paramLabel, l.b.f.c paramC, boolean paramBoolean, int paramInt)
  {
    return a(this, paramLabel, paramC, paramBoolean, paramInt);
  }
  
  public final ByteVector a(Label paramLabel, l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramLabel, "firstTimeoutIndicator is null");
    return b(paramLabel, paramO, null);
  }
  
  public final ByteVector a(Label paramLabel, l.b.f.o paramO, int paramInt)
  {
    l.b.g.b.b.a(paramLabel, "openingIndicator is null");
    l.b.g.b.b.a(paramO, "closingIndicator is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return l.b.k.a.a((ByteVector)new zb(this, paramLabel, paramO, paramInt));
  }
  
  public final ByteVector a(Label paramLabel, l.b.f.o paramO, Callable paramCallable)
  {
    l.b.g.b.b.a(paramLabel, "openingIndicator is null");
    l.b.g.b.b.a(paramO, "closingIndicator is null");
    l.b.g.b.b.a(paramCallable, "bufferSupplier is null");
    return l.b.k.a.a((ByteVector)new l.b.g.e.d.n(this, paramLabel, paramO, paramCallable));
  }
  
  public final ByteVector a(Label paramLabel1, l.b.f.o paramO, Label paramLabel2)
  {
    l.b.g.b.b.a(paramLabel1, "firstTimeoutIndicator is null");
    l.b.g.b.b.a(paramLabel2, "other is null");
    return b(paramLabel1, paramO, paramLabel2);
  }
  
  public final ByteVector a(Label paramLabel, l.b.f.o paramO1, l.b.f.o paramO2, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramLabel, "other is null");
    l.b.g.b.b.a(paramO1, "leftEnd is null");
    l.b.g.b.b.a(paramO2, "rightEnd is null");
    l.b.g.b.b.a(paramC, "resultSelector is null");
    return l.b.k.a.a((ByteVector)new pa(this, paramLabel, paramO1, paramO2, paramC));
  }
  
  public final ByteVector a(Label paramLabel, boolean paramBoolean)
  {
    l.b.g.b.b.a(paramLabel, "sampler is null");
    return l.b.k.a.a((ByteVector)new Ra(this, paramLabel, paramBoolean));
  }
  
  public final ByteVector a(l.b.f.a paramA)
  {
    l.b.g.b.b.a(paramA, "onFinally is null");
    l.b.f.g localG = l.b.g.b.a.d;
    return a(localG, localG, l.b.g.b.a.c, paramA);
  }
  
  public final ByteVector a(l.b.f.d paramD)
  {
    l.b.g.b.b.a(paramD, "comparer is null");
    return l.b.k.a.a((ByteVector)new I(this, l.b.g.b.a.a, paramD));
  }
  
  public final ByteVector a(l.b.f.e paramE)
  {
    l.b.g.b.b.a(paramE, "stop is null");
    return a(Long.MAX_VALUE, l.b.g.b.a.a(paramE));
  }
  
  public final ByteVector a(l.b.f.g paramG)
  {
    l.b.g.b.b.a(paramG, "consumer is null");
    return a(l.b.g.b.a.c(paramG), l.b.g.b.a.b(paramG), l.b.g.b.a.a(paramG), l.b.g.b.a.c);
  }
  
  public final ByteVector a(l.b.f.g paramG, l.b.f.a paramA)
  {
    l.b.g.b.b.a(paramG, "onSubscribe is null");
    l.b.g.b.b.a(paramA, "onDispose is null");
    return l.b.k.a.a((ByteVector)new M(this, paramG, paramA));
  }
  
  public final ByteVector a(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    return l.b.k.a.a((ByteVector)new ua(this, paramO));
  }
  
  public final ByteVector a(l.b.f.o paramO, int paramInt)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    l.b.g.b.b.a(paramInt, "prefetch");
    if ((this instanceof l.b.g.c.m))
    {
      Object localObject = ((l.b.g.c.m)this).call();
      if (localObject == null) {
        return a();
      }
      return Sa.a(localObject, paramO);
    }
    return l.b.k.a.a((ByteVector)new l.b.g.e.d.v(this, paramO, paramInt, l.b.g.j.j.a));
  }
  
  public final ByteVector a(l.b.f.o paramO, int paramInt1, int paramInt2)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    l.b.g.b.b.a(paramInt1, "maxConcurrency");
    l.b.g.b.b.a(paramInt2, "prefetch");
    return l.b.k.a.a((ByteVector)new w(this, paramO, l.b.g.j.j.a, paramInt1, paramInt2));
  }
  
  public final ByteVector a(l.b.f.o paramO, int paramInt1, int paramInt2, boolean paramBoolean)
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
    return l.b.k.a.a((ByteVector)new w(this, paramO, localJ, paramInt1, paramInt2));
  }
  
  public final ByteVector a(l.b.f.o paramO, int paramInt, long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    l.b.g.b.b.a(paramO, "selector is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return Ma.a(ma.a(this, paramInt, paramLong, paramTimeUnit, paramG), paramO);
  }
  
  public final ByteVector a(l.b.f.o paramO, int paramInt, G paramG)
  {
    l.b.g.b.b.a(paramO, "selector is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    ma.a localA = new ma.a(this, paramInt);
    paramO = new ma.o(paramO, paramG);
    return Ma.a((Callable)localA, paramO);
  }
  
  public final ByteVector a(l.b.f.o paramO, int paramInt, boolean paramBoolean)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    l.b.g.b.b.a(paramInt, "prefetch");
    Object localObject;
    if ((this instanceof l.b.g.c.m))
    {
      localObject = ((l.b.g.c.m)this).call();
      if (localObject == null) {
        return a();
      }
      return Sa.a(localObject, paramO);
    }
    if (paramBoolean) {
      localObject = l.b.g.j.j.c;
    } else {
      localObject = l.b.g.j.j.b;
    }
    return l.b.k.a.a((ByteVector)new l.b.g.e.d.v(this, paramO, paramInt, (l.b.g.j.j)localObject));
  }
  
  public final ByteVector a(l.b.f.o paramO, long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    l.b.g.b.b.a(paramO, "selector is null");
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return Ma.a(ma.a(this, paramLong, paramTimeUnit, paramG), paramO);
  }
  
  public final ByteVector a(l.b.f.o paramO, Callable paramCallable)
  {
    l.b.g.b.b.a(paramO, "keySelector is null");
    l.b.g.b.b.a(paramCallable, "collectionSupplier is null");
    return l.b.k.a.a((ByteVector)new H(this, paramO, paramCallable));
  }
  
  public final ByteVector a(l.b.f.o paramO, G paramG)
  {
    l.b.g.b.b.a(paramO, "selector is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    ma.n localN = new ma.n(this);
    paramO = new ma.o(paramO, paramG);
    return Ma.a((Callable)localN, paramO);
  }
  
  public final ByteVector a(l.b.f.o paramO, Label paramLabel)
  {
    l.b.g.b.b.a(paramLabel, "other is null");
    return b(null, paramO, paramLabel);
  }
  
  public final ByteVector a(l.b.f.o paramO, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    l.b.g.b.b.a(paramC, "resultSelector is null");
    paramO = new ma.d(paramO);
    int i = h.a;
    return a(paramO, paramC, false, i, i);
  }
  
  public final ByteVector a(l.b.f.o paramO, l.b.f.c paramC, int paramInt)
  {
    return a(paramO, paramC, false, paramInt, h.a);
  }
  
  public final ByteVector a(l.b.f.o paramO, l.b.f.c paramC, boolean paramBoolean)
  {
    int i = h.a;
    return a(paramO, paramC, paramBoolean, i, i);
  }
  
  public final ByteVector a(l.b.f.o paramO, l.b.f.c paramC, boolean paramBoolean, int paramInt)
  {
    return a(paramO, paramC, paramBoolean, paramInt, h.a);
  }
  
  public final ByteVector a(l.b.f.o paramO, l.b.f.c paramC, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    l.b.g.b.b.a(paramC, "combiner is null");
    return a(new ma.f(paramC, paramO), paramBoolean, paramInt1, paramInt2);
  }
  
  public final ByteVector a(l.b.f.o paramO1, l.b.f.o paramO2, Callable paramCallable)
  {
    l.b.g.b.b.a(paramO1, "onNextMapper is null");
    l.b.g.b.b.a(paramO2, "onErrorMapper is null");
    l.b.g.b.b.a(paramCallable, "onCompleteSupplier is null");
    return b((Label)new va(this, paramO1, paramO2, paramCallable));
  }
  
  public final ByteVector a(l.b.f.o paramO1, l.b.f.o paramO2, Callable paramCallable, int paramInt)
  {
    l.b.g.b.b.a(paramO1, "onNextMapper is null");
    l.b.g.b.b.a(paramO2, "onErrorMapper is null");
    l.b.g.b.b.a(paramCallable, "onCompleteSupplier is null");
    return c((Label)new va(this, paramO1, paramO2, paramCallable), paramInt);
  }
  
  public final ByteVector a(l.b.f.o paramO1, l.b.f.o paramO2, boolean paramBoolean, int paramInt)
  {
    l.b.g.b.b.a(paramO1, "keySelector is null");
    l.b.g.b.b.a(paramO2, "valueSelector is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return l.b.k.a.a((ByteVector)new ha(this, paramO1, paramO2, paramInt, paramBoolean));
  }
  
  public final ByteVector a(l.b.f.o paramO, boolean paramBoolean)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    return l.b.k.a.a((ByteVector)new Y(this, paramO, paramBoolean));
  }
  
  public final ByteVector a(l.b.f.o paramO, boolean paramBoolean, int paramInt)
  {
    return a(paramO, paramBoolean, paramInt, h.a);
  }
  
  public final ByteVector a(l.b.f.o paramO, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    l.b.g.b.b.a(paramInt1, "maxConcurrency");
    l.b.g.b.b.a(paramInt2, "bufferSize");
    if ((this instanceof l.b.g.c.m))
    {
      Object localObject = ((l.b.g.c.m)this).call();
      if (localObject == null) {
        return a();
      }
      return Sa.a(localObject, paramO);
    }
    return l.b.k.a.a((ByteVector)new U(this, paramO, paramBoolean, paramInt1, paramInt2));
  }
  
  public final ByteVector a(Label[] paramArrayOfLabel, l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramArrayOfLabel, "others is null");
    l.b.g.b.b.a(paramO, "combiner is null");
    return l.b.k.a.a((ByteVector)new Db(this, paramArrayOfLabel, paramO));
  }
  
  public final ExtensionData a(int paramInt)
  {
    l.b.g.b.b.a(paramInt, "capacityHint");
    return l.b.k.a.a((ExtensionData)new ub(this, paramInt));
  }
  
  public final ExtensionData a(long paramLong, Object paramObject)
  {
    if (paramLong >= 0L)
    {
      l.b.g.b.b.a(paramObject, "defaultItem is null");
      return l.b.k.a.a((ExtensionData)new P(this, paramLong, paramObject));
    }
    throw new IndexOutOfBoundsException(StringBuilder.get("index >= 0 required but it was ", paramLong));
  }
  
  public final ExtensionData a(Object paramObject, l.b.f.b paramB)
  {
    l.b.g.b.b.a(paramObject, "initialValue is null");
    return a(l.b.g.b.a.b(paramObject), paramB);
  }
  
  public final ExtensionData a(Comparator paramComparator)
  {
    l.b.g.b.b.a(paramComparator, "comparator is null");
    return length().b(l.b.g.b.a.a(paramComparator));
  }
  
  public final ExtensionData a(Comparator paramComparator, int paramInt)
  {
    l.b.g.b.b.a(paramComparator, "comparator is null");
    return a(paramInt).b(l.b.g.b.a.a(paramComparator));
  }
  
  public final ExtensionData a(Callable paramCallable, l.b.f.b paramB)
  {
    l.b.g.b.b.a(paramCallable, "initialValueSupplier is null");
    l.b.g.b.b.a(paramB, "collector is null");
    return l.b.k.a.a((ExtensionData)new t(this, paramCallable, paramB));
  }
  
  public final ExtensionData a(l.b.f.o paramO1, l.b.f.o paramO2)
  {
    l.b.g.j.m localM = l.b.g.j.m.a;
    l.b.g.j.b localB = l.b.g.j.b.a;
    return a(paramO1, paramO2, (Callable)localM, localB);
  }
  
  public final ExtensionData a(l.b.f.o paramO1, l.b.f.o paramO2, Callable paramCallable, l.b.f.o paramO3)
  {
    l.b.g.b.b.a(paramO1, "keySelector is null");
    l.b.g.b.b.a(paramO2, "valueSelector is null");
    l.b.g.b.b.a(paramCallable, "mapSupplier is null");
    l.b.g.b.b.a(paramO3, "collectionFactory is null");
    return a(paramCallable, l.b.g.b.a.a(paramO1, paramO2, paramO3));
  }
  
  public final ExtensionData a(l.b.f.r paramR)
  {
    l.b.g.b.b.a(paramR, "predicate is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.d.j(this, paramR));
  }
  
  public final l.b.c.c a(l.b.f.g paramG1, l.b.f.g paramG2)
  {
    return a(paramG1, paramG2, l.b.g.b.a.c, l.b.g.b.a.d);
  }
  
  public final l.b.c.c a(l.b.f.g paramG1, l.b.f.g paramG2, l.b.f.a paramA)
  {
    return a(paramG1, paramG2, paramA, l.b.g.b.a.d);
  }
  
  public final l.b.c.c a(l.b.f.g paramG1, l.b.f.g paramG2, l.b.f.a paramA, l.b.f.g paramG3)
  {
    l.b.g.b.b.a(paramG1, "onNext is null");
    l.b.g.b.b.a(paramG2, "onError is null");
    l.b.g.b.b.a(paramA, "onComplete is null");
    l.b.g.b.b.a(paramG3, "onSubscribe is null");
    paramG1 = new l.b.g.d.v(paramG1, paramG2, paramA, paramG3);
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
    paramR = new l.b.g.d.p(paramR, paramG, paramA);
    a(paramR);
    return paramR;
  }
  
  public final d a(l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramC, "reducer is null");
    return l.b.k.a.a((d)new Fa(this, paramC));
  }
  
  public final l.b.h.a a(int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    return a(paramInt, paramLong, paramTimeUnit, l.b.m.a.a());
  }
  
  public final l.b.h.a a(int paramInt, long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    l.b.g.b.b.a(paramInt, "bufferSize");
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return Ma.a(this, paramLong, paramTimeUnit, paramG, paramInt);
  }
  
  public final l.b.h.a a(int paramInt, G paramG)
  {
    l.b.g.b.b.a(paramInt, "bufferSize");
    return Ma.a(f(paramInt), paramG);
  }
  
  public final h a(b paramB)
  {
    l.b.g.e.b.ka localKa = new l.b.g.e.b.ka(this);
    int i = ((Enum)paramB).ordinal();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 3)
        {
          if (i != 4) {
            return ((h)localKa).setVisible();
          }
          return ((h)localKa).i();
        }
        return ((h)localKa).onSubMenuSelected();
      }
      return l.b.k.a.a((h)new l.b.g.e.b.Ka((h)localKa));
    }
    return (h)localKa;
  }
  
  public final l.b.i.u a(boolean paramBoolean)
  {
    l.b.i.u localU = new l.b.i.u(u.a.a);
    if (paramBoolean) {
      localU.dispose();
    }
    a(localU);
    return localU;
  }
  
  public final void a(F paramF)
  {
    l.b.g.b.b.a(paramF, "observer is null");
    try
    {
      paramF = l.b.k.a.a(this, paramF);
      l.b.g.b.b.a(paramF, "Plugin returned null Observer");
      putShort(paramF);
      return;
    }
    catch (Throwable paramF)
    {
      l.b.d.b.b(paramF);
      l.b.k.a.b(paramF);
      NullPointerException localNullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
      localNullPointerException.initCause(paramF);
      throw localNullPointerException;
    }
    catch (NullPointerException paramF)
    {
      throw paramF;
    }
  }
  
  public final Object add()
  {
    Object localObject = new f();
    a((F)localObject);
    localObject = ((l.b.g.d.e)localObject).b();
    if (localObject != null) {
      return localObject;
    }
    throw new NoSuchElementException();
  }
  
  public final Object add(Object paramObject)
  {
    Object localObject = new f();
    a((F)localObject);
    localObject = ((l.b.g.d.e)localObject).b();
    if (localObject != null) {
      return localObject;
    }
    return paramObject;
  }
  
  public final ByteVector add(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt == 0) {
        return l.b.k.a.a(this);
      }
      return l.b.k.a.a((ByteVector)new ab(this, paramInt));
    }
    throw new IndexOutOfBoundsException(StringBuilder.toString("count >= 0 required but it was ", paramInt));
  }
  
  public final ByteVector add(long paramLong)
  {
    if (paramLong >= 0L)
    {
      if (paramLong == 0L) {
        return a();
      }
      return l.b.k.a.a((ByteVector)new Ja(this, paramLong));
    }
    throw new IllegalArgumentException(StringBuilder.get("times >= 0 required but it was ", paramLong));
  }
  
  public final ByteVector add(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, G paramG)
  {
    return a(paramLong1, paramLong2, paramTimeUnit, paramG, (Callable)l.b.g.j.b.a);
  }
  
  public final ByteVector add(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return a(paramLong, paramTimeUnit, paramG, Long.MAX_VALUE, false);
  }
  
  public final ByteVector add(long paramLong1, TimeUnit paramTimeUnit, G paramG, long paramLong2)
  {
    return a(paramLong1, paramTimeUnit, paramG, paramLong2, false);
  }
  
  public final ByteVector add(long paramLong, TimeUnit paramTimeUnit, G paramG, boolean paramBoolean)
  {
    return a(paramLong, paramTimeUnit, paramG, paramBoolean, h.a);
  }
  
  public final ByteVector add(long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean)
  {
    return a(paramLong, paramTimeUnit, l.b.m.a.a(), paramBoolean);
  }
  
  public final ByteVector add(TimeUnit paramTimeUnit, G paramG)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return a(l.b.g.b.a.a(paramTimeUnit, paramG));
  }
  
  public final ByteVector add(Label paramLabel)
  {
    l.b.g.b.b.a(paramLabel, "other is null");
    return l.b.k.a.a((ByteVector)new lb(this, paramLabel));
  }
  
  public final ByteVector add(Label paramLabel, int paramInt)
  {
    l.b.g.b.b.a(paramLabel, "boundary is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return l.b.k.a.a((ByteVector)new yb(this, paramLabel, paramInt));
  }
  
  public final ByteVector add(l.b.f.a paramA)
  {
    l.b.f.g localG = l.b.g.b.a.d;
    return a(localG, localG, paramA, l.b.g.b.a.c);
  }
  
  public final ByteVector add(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "resumeFunction is null");
    return l.b.k.a.a((ByteVector)new za(this, paramO, false));
  }
  
  public final ByteVector add(l.b.f.o paramO, boolean paramBoolean)
  {
    return a(paramO, paramBoolean, Integer.MAX_VALUE);
  }
  
  public final F add(F paramF)
  {
    a(paramF);
    return paramF;
  }
  
  public final l.b.c.c add(l.b.f.g paramG)
  {
    return a(paramG, l.b.g.b.a.f, l.b.g.b.a.c, l.b.g.b.a.d);
  }
  
  public final l.b.c.c add(l.b.f.r paramR)
  {
    return a(paramR, l.b.g.b.a.f, l.b.g.b.a.c);
  }
  
  public final ByteVector addSubMenu(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "handler is null");
    return l.b.k.a.a((ByteVector)new Pa(this, paramO));
  }
  
  public final Object b(Object paramObject)
  {
    Object localObject = new l.b.g.d.g();
    a((F)localObject);
    localObject = ((l.b.g.d.e)localObject).b();
    if (localObject != null) {
      return localObject;
    }
    return paramObject;
  }
  
  public final ByteVector b()
  {
    return length().b().a(l.b.g.b.a.a(l.b.g.b.a.f())).b(l.b.g.b.a.a);
  }
  
  public final ByteVector b(int paramInt, Callable paramCallable)
  {
    return a(paramInt, paramInt, paramCallable);
  }
  
  public final ByteVector b(long paramLong)
  {
    return a(paramLong, l.b.g.b.a.h);
  }
  
  public final ByteVector b(long paramLong1, long paramLong2)
  {
    return a(paramLong1, paramLong2, h.a);
  }
  
  public final ByteVector b(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return a(paramLong1, paramLong2, paramTimeUnit, l.b.m.a.d, false, h.a);
  }
  
  public final ByteVector b(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, G paramG)
  {
    return a(paramLong1, paramLong2, paramTimeUnit, paramG, h.a);
  }
  
  public final ByteVector b(long paramLong, TimeUnit paramTimeUnit)
  {
    return a(paramLong, paramTimeUnit, l.b.m.a.d, false, h.a);
  }
  
  public final ByteVector b(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((ByteVector)new l.b.g.e.d.B(this, paramLong, paramTimeUnit, paramG));
  }
  
  public final ByteVector b(long paramLong, TimeUnit paramTimeUnit, G paramG, int paramInt)
  {
    return a(paramLong, paramTimeUnit, paramG, paramInt, (Callable)l.b.g.j.b.a, false);
  }
  
  public final ByteVector b(long paramLong, TimeUnit paramTimeUnit, G paramG, boolean paramBoolean)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((ByteVector)new Qa(this, paramLong, paramTimeUnit, paramG, paramBoolean));
  }
  
  public final ByteVector b(long paramLong, TimeUnit paramTimeUnit, G paramG, boolean paramBoolean, int paramInt)
  {
    return a(Long.MAX_VALUE, paramLong, paramTimeUnit, paramG, paramBoolean, paramInt);
  }
  
  public final ByteVector b(long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean)
  {
    return a(paramLong, paramTimeUnit, l.b.m.a.d, paramBoolean, h.a);
  }
  
  public final ByteVector b(Class paramClass)
  {
    l.b.g.b.b.a(paramClass, "clazz is null");
    return b(l.b.g.b.a.b(paramClass)).a(paramClass);
  }
  
  public final ByteVector b(Comparator paramComparator)
  {
    l.b.g.b.b.a(paramComparator, "sortFunction is null");
    return length().b().a(l.b.g.b.a.a(paramComparator)).b(l.b.g.b.a.a);
  }
  
  public final ByteVector b(TimeUnit paramTimeUnit)
  {
    return a(paramTimeUnit, l.b.m.a.a());
  }
  
  public final ByteVector b(F paramF)
  {
    l.b.g.b.b.a(paramF, "observer is null");
    ma.l localL = new ma.l(paramF);
    ma.k localK = new ma.k(paramF);
    paramF = new ma.j(paramF);
    l.b.f.a localA = l.b.g.b.a.c;
    return a((l.b.f.g)localL, (l.b.f.g)localK, paramF, localA);
  }
  
  public final ByteVector b(G paramG)
  {
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((ByteVector)new eb(this, paramG));
  }
  
  public final ByteVector b(G paramG, boolean paramBoolean)
  {
    return a(paramG, paramBoolean, h.a);
  }
  
  public final ByteVector b(Label paramLabel, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramLabel, "other is null");
    l.b.g.b.b.a(paramC, "combiner is null");
    return l.b.k.a.a((ByteVector)new Cb(this, paramC, paramLabel));
  }
  
  public final ByteVector b(Label paramLabel, l.b.f.o paramO)
  {
    return a(paramLabel, paramO, h.a);
  }
  
  public final ByteVector b(Label paramLabel, l.b.f.o paramO1, l.b.f.o paramO2, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramLabel, "other is null");
    l.b.g.b.b.a(paramO1, "leftEnd is null");
    l.b.g.b.b.a(paramO2, "rightEnd is null");
    l.b.g.b.b.a(paramC, "resultSelector is null");
    return l.b.k.a.a((ByteVector)new ia(this, paramLabel, paramO1, paramO2, paramC));
  }
  
  public final ByteVector b(l.b.f.a paramA)
  {
    l.b.g.b.b.a(paramA, "onTerminate is null");
    return a(l.b.g.b.a.d, l.b.g.b.a.a(paramA), paramA, l.b.g.b.a.c);
  }
  
  public final ByteVector b(l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramC, "accumulator is null");
    return l.b.k.a.a((ByteVector)new Ta(this, paramC));
  }
  
  public final ByteVector b(l.b.f.d paramD)
  {
    l.b.g.b.b.a(paramD, "predicate is null");
    return l.b.k.a.a((ByteVector)new Na(this, paramD));
  }
  
  public final ByteVector b(l.b.f.e paramE)
  {
    l.b.g.b.b.a(paramE, "stop is null");
    return l.b.k.a.a((ByteVector)new l.b.g.e.d.Ka(this, paramE));
  }
  
  public final ByteVector b(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    return l.b.k.a.a((ByteVector)new Z(this, paramO));
  }
  
  public final ByteVector b(l.b.f.o paramO, int paramInt)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    if ((this instanceof l.b.g.c.m))
    {
      Object localObject = ((l.b.g.c.m)this).call();
      if (localObject == null) {
        return a();
      }
      return Sa.a(localObject, paramO);
    }
    return l.b.k.a.a((ByteVector)new gb(this, paramO, paramInt, false));
  }
  
  public final ByteVector b(l.b.f.o paramO, int paramInt, long paramLong, TimeUnit paramTimeUnit)
  {
    return a(paramO, paramInt, paramLong, paramTimeUnit, l.b.m.a.a());
  }
  
  public final ByteVector b(l.b.f.o paramO, long paramLong, TimeUnit paramTimeUnit)
  {
    return a(paramO, paramLong, paramTimeUnit, l.b.m.a.a());
  }
  
  public final ByteVector b(l.b.f.o paramO, l.b.f.c paramC)
  {
    int i = h.a;
    return a(paramO, paramC, false, i, i);
  }
  
  public final ByteVector b(l.b.f.o paramO1, l.b.f.o paramO2)
  {
    return a(paramO1, paramO2, false, h.a);
  }
  
  public final ByteVector b(l.b.f.o paramO1, l.b.f.o paramO2, boolean paramBoolean)
  {
    return a(paramO1, paramO2, paramBoolean, h.a);
  }
  
  public final ByteVector b(l.b.f.o paramO, boolean paramBoolean)
  {
    return a(paramO, l.b.g.b.a.a, paramBoolean, h.a);
  }
  
  public final ByteVector b(l.b.f.r paramR)
  {
    l.b.g.b.b.a(paramR, "predicate is null");
    return l.b.k.a.a((ByteVector)new T(this, paramR));
  }
  
  public final ByteVector b(Object... paramVarArgs)
  {
    paramVarArgs = a(paramVarArgs);
    if (paramVarArgs == a()) {
      return l.b.k.a.a(this);
    }
    return a(new Label[] { paramVarArgs, this });
  }
  
  public final ExtensionData b(int paramInt)
  {
    return a(l.b.g.b.a.k, paramInt);
  }
  
  public final ExtensionData b(l.b.f.o paramO1, l.b.f.o paramO2, Callable paramCallable)
  {
    return a(paramO1, paramO2, paramCallable, l.b.g.j.b.a);
  }
  
  public final void b(l.b.f.g paramG1, l.b.f.g paramG2)
  {
    l.b.g.e.d.l.a(this, paramG1, paramG2, l.b.g.b.a.c);
  }
  
  public final void b(l.b.f.g paramG1, l.b.f.g paramG2, l.b.f.a paramA)
  {
    l.b.g.e.d.l.a(this, paramG1, paramG2, paramA);
  }
  
  public final ByteVector c(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt == 0) {
        return l.b.k.a.a((ByteVector)new l.b.g.e.d.ka(this));
      }
      if (paramInt == 1) {
        return l.b.k.a.a((ByteVector)new jb(this));
      }
      return l.b.k.a.a((ByteVector)new ib(this, paramInt));
    }
    throw new IndexOutOfBoundsException(StringBuilder.toString("count >= 0 required but it was ", paramInt));
  }
  
  public final ByteVector c(long paramLong, TimeUnit paramTimeUnit)
  {
    return c(paramLong, paramTimeUnit, l.b.m.a.a());
  }
  
  public final ByteVector c(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((ByteVector)new ob(this, paramLong, paramTimeUnit, paramG));
  }
  
  public final ByteVector c(Label paramLabel)
  {
    l.b.g.b.b.a(paramLabel, "other is null");
    return c(this, paramLabel);
  }
  
  public final ByteVector c(l.b.f.a paramA)
  {
    l.b.g.b.b.a(paramA, "onFinally is null");
    return l.b.k.a.a((ByteVector)new K(this, paramA));
  }
  
  public final ByteVector c(l.b.f.g paramG)
  {
    l.b.g.b.b.a(paramG, "onAfterNext is null");
    return l.b.k.a.a((ByteVector)new J(this, paramG));
  }
  
  public final ByteVector c(l.b.f.o paramO, int paramInt)
  {
    l.b.g.b.b.a(paramO, "selector is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    return Ma.a((Callable)new ma.a(this, paramInt), paramO);
  }
  
  public final ExtensionData c(Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "defaultItem is null");
    return l.b.k.a.a((ExtensionData)new Za(this, paramObject));
  }
  
  public final ExtensionData c(Object paramObject, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramObject, "seed is null");
    l.b.g.b.b.a(paramC, "reducer is null");
    return l.b.k.a.a((ExtensionData)new Ga(this, paramObject, paramC));
  }
  
  public final ExtensionData c(Callable paramCallable)
  {
    l.b.g.b.b.a(paramCallable, "collectionSupplier is null");
    return l.b.k.a.a((ExtensionData)new ub(this, paramCallable));
  }
  
  public final ExtensionData c(Callable paramCallable, l.b.f.c paramC)
  {
    l.b.g.b.b.a(paramCallable, "seedSupplier is null");
    l.b.g.b.b.a(paramC, "reducer is null");
    return l.b.k.a.a((ExtensionData)new Ha(this, paramCallable, paramC));
  }
  
  public final ExtensionData c(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "keySelector is null");
    l.b.g.j.m localM = l.b.g.j.m.a;
    paramO = l.b.g.b.a.a(paramO);
    return a((Callable)localM, paramO);
  }
  
  public final ExtensionData c(l.b.f.o paramO1, l.b.f.o paramO2)
  {
    l.b.g.b.b.a(paramO1, "keySelector is null");
    l.b.g.b.b.a(paramO2, "valueSelector is null");
    l.b.g.j.m localM = l.b.g.j.m.a;
    paramO1 = l.b.g.b.a.a(paramO1, paramO2);
    return a((Callable)localM, paramO1);
  }
  
  public final ExtensionData c(l.b.f.o paramO1, l.b.f.o paramO2, Callable paramCallable)
  {
    l.b.g.b.b.a(paramO1, "keySelector is null");
    l.b.g.b.b.a(paramO1, "keySelector is null");
    l.b.g.b.b.a(paramO2, "valueSelector is null");
    l.b.g.b.b.a(paramCallable, "mapSupplier is null");
    return a(paramCallable, l.b.g.b.a.a(paramO1, paramO2));
  }
  
  public final ExtensionData c(l.b.f.r paramR)
  {
    l.b.g.b.b.a(paramR, "predicate is null");
    return l.b.k.a.a((ExtensionData)new l.b.g.e.d.g(this, paramR));
  }
  
  public final l.b.c.c c()
  {
    return a(l.b.g.b.a.d, l.b.g.b.a.f, l.b.g.b.a.c, l.b.g.b.a.d);
  }
  
  public final c c(l.b.f.o paramO, boolean paramBoolean)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    return l.b.k.a.a((c)new W(this, paramO, paramBoolean));
  }
  
  public final l.b.h.a c(G paramG)
  {
    l.b.g.b.b.a(paramG, "scheduler is null");
    return Ma.a(getInt(), paramG);
  }
  
  public final void close(l.b.f.g paramG)
  {
    l.b.g.e.d.l.a(this, paramG, l.b.g.b.a.f, l.b.g.b.a.c);
  }
  
  public final ByteVector collapseActionView(l.b.f.o paramO)
  {
    return d(paramO, h.a);
  }
  
  public final ByteVector compare()
  {
    return l.b.k.a.a((ByteVector)new l.b.g.e.d.G(this));
  }
  
  public final ExtensionData createFromParcel()
  {
    return l.b.k.a.a((ExtensionData)new sa(this, null));
  }
  
  public final ByteVector d(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    return a(paramLong1, paramLong2, paramTimeUnit, l.b.m.a.a(), h.a);
  }
  
  public final ByteVector d(long paramLong, TimeUnit paramTimeUnit)
  {
    return b(paramLong, paramTimeUnit, l.b.m.a.a());
  }
  
  public final ByteVector d(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return b(paramLong, paramTimeUnit, paramG, false, h.a);
  }
  
  public final ByteVector d(long paramLong, TimeUnit paramTimeUnit, G paramG, boolean paramBoolean)
  {
    return b(paramLong, paramTimeUnit, paramG, paramBoolean, h.a);
  }
  
  public final ByteVector d(long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean)
  {
    return b(paramLong, paramTimeUnit, l.b.m.a.a(), paramBoolean);
  }
  
  public final ByteVector d(Label paramLabel)
  {
    l.b.g.b.b.a(paramLabel, "other is null");
    return b(this, paramLabel);
  }
  
  public final ByteVector d(l.b.f.g paramG)
  {
    l.b.f.g localG = l.b.g.b.a.d;
    l.b.f.a localA = l.b.g.b.a.c;
    return a(localG, paramG, localA, localA);
  }
  
  public final ByteVector d(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "keySelector is null");
    return l.b.k.a.a((ByteVector)new I(this, paramO, l.b.g.b.b.a));
  }
  
  public final ByteVector d(l.b.f.o paramO, int paramInt)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    l.b.g.b.b.a(paramInt, "bufferSize");
    if ((this instanceof l.b.g.c.m))
    {
      Object localObject = ((l.b.g.c.m)this).call();
      if (localObject == null) {
        return a();
      }
      return Sa.a(localObject, paramO);
    }
    return l.b.k.a.a((ByteVector)new gb(this, paramO, paramInt, true));
  }
  
  public final ByteVector d(l.b.f.o paramO, boolean paramBoolean)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    return l.b.k.a.a((ByteVector)new X(this, paramO, paramBoolean));
  }
  
  public final ByteVector d(l.b.f.r paramR)
  {
    l.b.g.b.b.a(paramR, "predicate is null");
    return l.b.k.a.a((ByteVector)new db(this, paramR));
  }
  
  public final ExtensionData d()
  {
    return d(0L);
  }
  
  public final ExtensionData d(long paramLong)
  {
    if (paramLong >= 0L) {
      return l.b.k.a.a((ExtensionData)new P(this, paramLong, null));
    }
    throw new IndexOutOfBoundsException(StringBuilder.get("index >= 0 required but it was ", paramLong));
  }
  
  public final ExtensionData d(Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "element is null");
    return a(l.b.g.b.a.a(paramObject));
  }
  
  public final void e()
  {
    l.b.g.e.d.l.a(this);
  }
  
  public final ByteVector encodeUTF8(l.b.f.o paramO)
  {
    return a(paramO, h.a, true);
  }
  
  public final Iterable ensureListMenuPresenter()
  {
    return (Iterable)new l.b.g.e.d.e(this);
  }
  
  public final l.b.h.a f(int paramInt)
  {
    l.b.g.b.b.a(paramInt, "bufferSize");
    return Ma.h(this, paramInt);
  }
  
  public final Iterable get()
  {
    return get(h.a);
  }
  
  public final Iterable get(int paramInt)
  {
    l.b.g.b.b.a(paramInt, "bufferSize");
    return (Iterable)new l.b.g.e.d.b(this, paramInt);
  }
  
  public final Iterable get(Object paramObject)
  {
    return (Iterable)new l.b.g.e.d.d(this, paramObject);
  }
  
  public final ByteVector get(long paramLong, TimeUnit paramTimeUnit)
  {
    return set(paramLong, paramTimeUnit);
  }
  
  public final ByteVector get(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return set(paramLong, paramTimeUnit, paramG);
  }
  
  public final ExtensionData getElementType()
  {
    return l.b.k.a.a((ExtensionData)new Za(this, null));
  }
  
  public final l.b.h.a getInt()
  {
    return Ma.w(this);
  }
  
  public final d getItem(long paramLong)
  {
    if (paramLong >= 0L) {
      return l.b.k.a.a((d)new O(this, paramLong));
    }
    throw new IndexOutOfBoundsException(StringBuilder.get("index >= 0 required but it was ", paramLong));
  }
  
  public final ByteVector getItemId(long paramLong, TimeUnit paramTimeUnit)
  {
    return b(paramLong, paramTimeUnit, l.b.m.a.d, false, h.a);
  }
  
  public final ByteVector getListMenuView()
  {
    return l.b.k.a.a((ByteVector)new wa(this));
  }
  
  public final ByteVector getPixelValue(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "handler is null");
    return l.b.k.a.a((ByteVector)new La(this, paramO));
  }
  
  public final c getPixelValue()
  {
    return l.b.k.a.a((c)new la(this));
  }
  
  public final d getSelectedItem()
  {
    return getItem(0L);
  }
  
  public final l.b.h.a i(long paramLong, TimeUnit paramTimeUnit)
  {
    return i(paramLong, paramTimeUnit, l.b.m.a.a());
  }
  
  public final l.b.h.a i(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return Ma.a(this, paramLong, paramTimeUnit, paramG);
  }
  
  public final ByteVector initialize(Label paramLabel)
  {
    l.b.g.b.b.a(paramLabel, "other is null");
    return l.b.k.a.a((ByteVector)new fb(this, paramLabel));
  }
  
  public final ExtensionData length()
  {
    return a(16);
  }
  
  public final c length(l.b.f.o paramO)
  {
    return c(paramO, false);
  }
  
  public final ExtensionData next()
  {
    return c(l.b.g.b.a.i);
  }
  
  public final ByteVector onConfigurationChanged(Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "item is null");
    return onConfigurationChanged(l.b.g.b.a.c(paramObject));
  }
  
  public final ByteVector onConfigurationChanged(Label paramLabel)
  {
    l.b.g.b.b.a(paramLabel, "next is null");
    return l.b.k.a.a((ByteVector)new za(this, l.b.g.b.a.c(paramLabel), true));
  }
  
  public final ByteVector onConfigurationChanged(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "valueSupplier is null");
    return l.b.k.a.a((ByteVector)new Aa(this, paramO));
  }
  
  public final ByteVector onCreate(Iterable paramIterable, l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramIterable, "others is null");
    l.b.g.b.b.a(paramO, "combiner is null");
    return l.b.k.a.a((ByteVector)new Db(this, paramIterable, paramO));
  }
  
  public final ByteVector onCreate(Label paramLabel)
  {
    l.b.g.b.b.a(paramLabel, "sampler is null");
    return l.b.k.a.a((ByteVector)new Ra(this, paramLabel, false));
  }
  
  public final ByteVector onCreate(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    return l.b.k.a.a((ByteVector)new Z(this, paramO));
  }
  
  public final ByteVector onCreate(l.b.f.r paramR)
  {
    l.b.g.b.b.a(paramR, "predicate is null");
    return l.b.k.a.a((ByteVector)new mb(this, paramR));
  }
  
  public final ExtensionData onCreate(Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "defaultItem is null");
    return l.b.k.a.a((ExtensionData)new sa(this, paramObject));
  }
  
  public final void onCreate(F paramF)
  {
    l.b.g.b.b.a(paramF, "s is null");
    if ((paramF instanceof s))
    {
      a(paramF);
      return;
    }
    a(new s(paramF));
  }
  
  public final Object onCreateView()
  {
    Object localObject = new l.b.g.d.g();
    a((F)localObject);
    localObject = ((l.b.g.d.e)localObject).b();
    if (localObject != null) {
      return localObject;
    }
    throw new NoSuchElementException();
  }
  
  public final ByteVector onCreateView(Label paramLabel)
  {
    l.b.g.b.b.a(paramLabel, "other is null");
    return b(new Label[] { this, paramLabel });
  }
  
  public final ExtensionData onCreateViewHolder()
  {
    return l.b.k.a.a((ExtensionData)new y(this));
  }
  
  public final ByteVector onOptionsItemSelected(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "debounceSelector is null");
    return l.b.k.a.a((ByteVector)new A(this, paramO));
  }
  
  public final ByteVector onOptionsItemSelected(l.b.f.r paramR)
  {
    l.b.g.b.b.a(paramR, "predicate is null");
    return l.b.k.a.a((ByteVector)new nb(this, paramR));
  }
  
  public final Future parse()
  {
    return (Future)add(new l.b.g.d.r());
  }
  
  public final ByteVector put()
  {
    return add(Long.MAX_VALUE);
  }
  
  public final ByteVector put(long paramLong, TimeUnit paramTimeUnit)
  {
    return d(paramLong, paramTimeUnit);
  }
  
  public final ByteVector put(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return put(a(paramLong, paramTimeUnit, paramG));
  }
  
  public final ByteVector put(Label paramLabel)
  {
    l.b.g.b.b.a(paramLabel, "other is null");
    return l.b.k.a.a((ByteVector)new cb(this, paramLabel));
  }
  
  public final ByteVector put(l.b.f.o paramO)
  {
    return add(paramO, false);
  }
  
  public final ExtensionData put(Object paramObject)
  {
    return a(0L, paramObject);
  }
  
  public final l.b.c.c put(l.b.f.g paramG)
  {
    return add(paramG);
  }
  
  public final ByteVector put11(l.b.f.o paramO)
  {
    return ma.b(this, paramO);
  }
  
  public final ByteVector put12()
  {
    return trimToSize().S();
  }
  
  public final ByteVector put12(l.b.f.o paramO)
  {
    return ma.a(this, paramO);
  }
  
  public final ByteVector put2(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return b(paramLong, paramTimeUnit, paramG);
  }
  
  public final ByteVector putByte()
  {
    return l.b.k.a.a((ByteVector)new Xa(this));
  }
  
  public final ByteVector putByte(Label paramLabel)
  {
    return a(paramLabel, (Callable)l.b.g.j.b.a);
  }
  
  public final ByteVector putByte(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "selector is null");
    return Ma.a((Callable)new ma.n(this), paramO);
  }
  
  public final void putByte(F paramF)
  {
    l.b.g.e.d.l.a(this, paramF);
  }
  
  public final ByteVector putByteArray()
  {
    return a(l.b.g.b.a.a, l.b.g.b.a.c());
  }
  
  public final ByteVector putByteArray(long paramLong, TimeUnit paramTimeUnit)
  {
    return a(paramLong, paramTimeUnit, null, l.b.m.a.a());
  }
  
  public final ByteVector putByteArray(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return a(paramLong, paramTimeUnit, null, paramG);
  }
  
  public final ByteVector putByteArray(G paramG)
  {
    return a(TimeUnit.MILLISECONDS, paramG);
  }
  
  public final ExtensionData putByteArray(l.b.f.o paramO)
  {
    l.b.f.o localO = l.b.g.b.a.a;
    l.b.g.j.m localM = l.b.g.j.m.a;
    l.b.g.j.b localB = l.b.g.j.b.a;
    return a(paramO, localO, (Callable)localM, localB);
  }
  
  public final ByteVector putInt()
  {
    return add(TimeUnit.MILLISECONDS, l.b.m.a.a());
  }
  
  public final ByteVector putInt(int paramInt)
  {
    return putInt(paramInt, paramInt);
  }
  
  public final ByteVector putInt(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2, (Callable)l.b.g.j.b.a);
  }
  
  public final ByteVector putInt(long paramLong, TimeUnit paramTimeUnit)
  {
    return putInt(paramLong, paramTimeUnit, l.b.m.a.a());
  }
  
  public final ByteVector putInt(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return putInt(a(paramLong, paramTimeUnit, paramG));
  }
  
  public final ByteVector putInt(Label paramLabel)
  {
    l.b.g.b.b.a(paramLabel, "other is null");
    return l.b.k.a.a((ByteVector)new l.b.g.e.d.E(this, paramLabel));
  }
  
  public final ByteVector putInt(Label paramLabel, int paramInt)
  {
    l.b.g.b.b.a(paramInt, "initialCapacity");
    return a(paramLabel, l.b.g.b.a.a(paramInt));
  }
  
  public final ByteVector putInt(Label paramLabel, l.b.f.o paramO)
  {
    return putInt(paramLabel).putInt(paramO);
  }
  
  public final ByteVector putInt(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "itemDelay is null");
    return put(new ma.g(paramO));
  }
  
  public final ByteVector putInt(l.b.f.o paramO, int paramInt)
  {
    l.b.g.b.b.a(paramO, "mapper is null");
    l.b.g.b.b.a(paramInt, "prefetch");
    return a(new ma.d(paramO), paramInt);
  }
  
  public final ByteVector putLong()
  {
    return l.b.k.a.a((ByteVector)new ja(this));
  }
  
  public final ByteVector putLong(long paramLong)
  {
    return a(paramLong, paramLong, h.a);
  }
  
  public final ByteVector putLong(long paramLong, TimeUnit paramTimeUnit)
  {
    return a(paramLong, paramTimeUnit, l.b.m.a.a(), false);
  }
  
  public final ByteVector putLong(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return add(a(paramLong, paramTimeUnit, paramG));
  }
  
  public final ByteVector putLong(Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "item is null");
    return a(new Label[] { a(paramObject), this });
  }
  
  public final ByteVector putLong(TimeUnit paramTimeUnit)
  {
    return add(paramTimeUnit, l.b.m.a.a());
  }
  
  public final ByteVector putLong(G paramG)
  {
    return add(TimeUnit.MILLISECONDS, paramG);
  }
  
  public final ByteVector putLong(Label paramLabel)
  {
    l.b.g.b.b.a(paramLabel, "next is null");
    return add(l.b.g.b.a.c(paramLabel));
  }
  
  public final ByteVector putLong(l.b.f.o paramO)
  {
    return a(paramO, false);
  }
  
  public final ByteVector putShort()
  {
    return l.b.g.e.d.r.a(this);
  }
  
  public final ByteVector putShort(int paramInt)
  {
    return l.b.g.e.d.r.a(this, paramInt);
  }
  
  public final ByteVector putShort(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return a(paramLong, paramTimeUnit, paramG, false);
  }
  
  public final ByteVector putShort(l.b.f.o paramO)
  {
    return a(paramO, l.b.g.b.a.c());
  }
  
  public final ByteVector putShort(l.b.f.o paramO, int paramInt)
  {
    return a(paramO, false, paramInt, h.a);
  }
  
  public abstract void putShort(F paramF);
  
  public final ByteVector putUTF8()
  {
    return a(TimeUnit.MILLISECONDS, l.b.m.a.a());
  }
  
  public final ByteVector putUTF8(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, G paramG)
  {
    return a(paramLong1, paramLong2, paramTimeUnit, paramG, false, h.a);
  }
  
  public final ByteVector putUTF8(long paramLong, TimeUnit paramTimeUnit)
  {
    return a(paramLong, paramTimeUnit, l.b.m.a.a(), Long.MAX_VALUE, false);
  }
  
  public final ByteVector putUTF8(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return a(paramLong, paramTimeUnit, paramG, false, h.a);
  }
  
  public final ByteVector putUTF8(Iterable paramIterable)
  {
    return a(new Label[] { a(paramIterable), this });
  }
  
  public final ByteVector putUTF8(Callable paramCallable)
  {
    return a(paramCallable, h.a);
  }
  
  public final ByteVector putUTF8(G paramG)
  {
    return a(paramG, false, h.a);
  }
  
  public final ByteVector putUTF8(Label paramLabel)
  {
    l.b.g.b.b.a(paramLabel, "other is null");
    return a(new Label[] { paramLabel, this });
  }
  
  public final ByteVector putUTF8(l.b.f.a paramA)
  {
    return a(l.b.g.b.a.d, paramA);
  }
  
  public final ByteVector putUTF8(l.b.f.g paramG)
  {
    l.b.f.g localG = l.b.g.b.a.d;
    l.b.f.a localA = l.b.g.b.a.c;
    return a(paramG, localG, localA, localA);
  }
  
  public final ByteVector putUTF8(l.b.f.o paramO)
  {
    return a(paramO, 2);
  }
  
  public final ByteVector putUTF8(l.b.f.r paramR)
  {
    return a(Long.MAX_VALUE, paramR);
  }
  
  public final Object read(Object paramObject)
  {
    return c(paramObject).setIcon();
  }
  
  public final ByteVector read()
  {
    return d(l.b.g.b.a.a);
  }
  
  public final ByteVector read(long paramLong, TimeUnit paramTimeUnit)
  {
    return add(add(paramLong, paramTimeUnit));
  }
  
  public final ByteVector read(Label paramLabel)
  {
    return add(paramLabel, h.a);
  }
  
  public final ByteVector read(l.b.f.o paramO)
  {
    return d(paramO, false);
  }
  
  public final void read(l.b.f.g paramG)
  {
    Iterator localIterator = get().iterator();
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
  
  public final ByteVector set(long paramLong, TimeUnit paramTimeUnit)
  {
    return set(paramLong, paramTimeUnit, l.b.m.a.a());
  }
  
  public final ByteVector set(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    l.b.g.b.b.a(paramTimeUnit, "unit is null");
    l.b.g.b.b.a(paramG, "scheduler is null");
    return l.b.k.a.a((ByteVector)new Qa(this, paramLong, paramTimeUnit, paramG, false));
  }
  
  public final ByteVector setActionView()
  {
    return l.b.k.a.a((ByteVector)new l.b.g.e.d.F(this));
  }
  
  public final ByteVector setActionView(l.b.f.o paramO)
  {
    l.b.g.b.b.a(paramO, "selector is null");
    return l.b.k.a.a((ByteVector)new Ca(this, paramO));
  }
  
  public final ByteVector setEnabled(l.b.f.o paramO)
  {
    return a(paramO, l.b.g.b.a.a, false, h.a);
  }
  
  public final Object setTitle()
  {
    Object localObject = setVisible().setTitle();
    if (localObject != null) {
      return localObject;
    }
    throw new NoSuchElementException();
  }
  
  public final d setVisible()
  {
    return l.b.k.a.a((d)new Ya(this));
  }
  
  public final d startSupportActionMode()
  {
    return l.b.k.a.a((d)new ra(this));
  }
  
  public final ExtensionData toByteArray()
  {
    return a(l.b.g.b.a.k);
  }
  
  public final l.b.h.a trimToSize()
  {
    return Ba.w(this);
  }
  
  public final ByteVector visitEnum(l.b.f.o paramO)
  {
    return b(paramO, h.a);
  }
  
  public final ByteVector visitIntInsn(l.b.f.o paramO)
  {
    return b(null, paramO, null);
  }
  
  public final l.b.i.u visitLdcInsn()
  {
    l.b.i.u localU = new l.b.i.u(u.a.a);
    a(localU);
    return localU;
  }
  
  public final Iterable withIndex()
  {
    return (Iterable)new l.b.g.e.d.c(this);
  }
  
  public final ByteVector write()
  {
    return a(Long.MAX_VALUE, l.b.g.b.a.h);
  }
  
  public final ByteVector write(long paramLong)
  {
    if (paramLong <= 0L) {
      return l.b.k.a.a(this);
    }
    return l.b.k.a.a((ByteVector)new _a(this, paramLong));
  }
  
  public final ByteVector write(long paramLong, TimeUnit paramTimeUnit)
  {
    return put(add(paramLong, paramTimeUnit));
  }
  
  public final ByteVector write(long paramLong, TimeUnit paramTimeUnit, G paramG)
  {
    return a(paramLong, paramTimeUnit, paramG, Integer.MAX_VALUE, (Callable)l.b.g.j.b.a, false);
  }
  
  public final ByteVector write(Object paramObject)
  {
    l.b.g.b.b.a(paramObject, "defaultItem is null");
    return initialize(a(paramObject));
  }
  
  public final ByteVector write(Callable paramCallable)
  {
    return a(paramCallable, (Callable)l.b.g.j.b.a);
  }
  
  public final ByteVector write(Label paramLabel, l.b.f.o paramO)
  {
    return a(paramLabel, paramO, (Callable)l.b.g.j.b.a);
  }
  
  public final ByteVector write(l.b.f.g paramG)
  {
    return a(paramG, l.b.g.b.a.c);
  }
  
  public final ByteVector write(l.b.f.o paramO)
  {
    return a(paramO, Integer.MAX_VALUE, h.a);
  }
  
  public final ByteVector write(l.b.f.o paramO, boolean paramBoolean)
  {
    return a(paramO, Integer.MAX_VALUE, h.a, paramBoolean);
  }
}
