package android.arch.lifecycle;

import b.a.b.s;
import b.b.a.F;
import java.util.Iterator;
import java.util.Map.Entry;
import support.support.asm.ClassReader;
import support.support.asm.MonthByWeekFragment.2;
import support.support.asm.Observer;
import support.support.asm.d;
import support.support.asm.f;
import support.support.v7.util.LinkedListMultimap;
import support.support.v7.util.RefMap.SetIterator;
import support.support.v7.widget.Tag;

public abstract class LiveData<T>
{
  public static final Object NOT_SET = new Object();
  public static final int START_VERSION = -1;
  public int mActiveCount = 0;
  public volatile Object mData;
  public final Object mDataLock = new Object();
  public boolean mDispatchInvalidated;
  public boolean mDispatchingValue;
  public b.a.a.b.c<s<T>, LiveData<T>.b> mObservers = new LinkedListMultimap();
  public volatile Object mPendingData;
  public final Runnable mPostValueRunnable;
  public int mVersion;
  
  public LiveData()
  {
    Object localObject = NOT_SET;
    mData = localObject;
    mPendingData = localObject;
    mVersion = -1;
    mPostValueRunnable = new MonthByWeekFragment.2(this);
  }
  
  public static void assertMainThread(String paramString)
  {
    if (Tag.valueOf().execute()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot invoke ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" on a background");
    localStringBuilder.append(" thread");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private void considerNotify(b paramB)
  {
    if (!d) {
      return;
    }
    if (!paramB.b())
    {
      paramB.b(false);
      return;
    }
    int i = i;
    int j = mVersion;
    if (i >= j) {
      return;
    }
    i = j;
    s.onChanged(mData);
  }
  
  private void dispatchingValue(b paramB)
  {
    if (mDispatchingValue)
    {
      mDispatchInvalidated = true;
      return;
    }
    mDispatchingValue = true;
    do
    {
      mDispatchInvalidated = false;
      b localB;
      if (paramB != null)
      {
        considerNotify(paramB);
        localB = null;
      }
      else
      {
        RefMap.SetIterator localSetIterator = mObservers.put();
        do
        {
          localB = paramB;
          if (!localSetIterator.hasNext()) {
            break;
          }
          considerNotify((b)((Map.Entry)localSetIterator.next()).getValue());
        } while (!mDispatchInvalidated);
        localB = paramB;
      }
      paramB = localB;
    } while (mDispatchInvalidated);
    mDispatchingValue = false;
  }
  
  public Object getValue()
  {
    Object localObject = mData;
    if (localObject != NOT_SET) {
      return localObject;
    }
    return null;
  }
  
  public int getVersion()
  {
    return mVersion;
  }
  
  public boolean hasActiveObservers()
  {
    return mActiveCount > 0;
  }
  
  public boolean hasObservers()
  {
    return mObservers.size() > 0;
  }
  
  public void observe(d paramD, Observer paramObserver)
  {
    if (paramD.getLifecycle().a() == f.c) {
      return;
    }
    LifecycleBoundObserver localLifecycleBoundObserver = new LifecycleBoundObserver(paramD, paramObserver);
    paramObserver = (b)mObservers.remove(paramObserver, localLifecycleBoundObserver);
    if ((paramObserver != null) && (!paramObserver.c(paramD))) {
      throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }
    if (paramObserver != null) {
      return;
    }
    paramD.getLifecycle().a(localLifecycleBoundObserver);
  }
  
  public void observeForever(Observer paramObserver)
  {
    a localA = new a(paramObserver);
    paramObserver = (b)mObservers.remove(paramObserver, localA);
    if ((paramObserver != null) && ((paramObserver instanceof LifecycleBoundObserver))) {
      throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }
    if (paramObserver != null) {
      return;
    }
    localA.b(true);
  }
  
  public void onActive() {}
  
  public void onInactive() {}
  
  public void postValue(Object paramObject)
  {
    Object localObject = mDataLock;
    for (;;)
    {
      try
      {
        if (mPendingData == NOT_SET)
        {
          i = 1;
          mPendingData = paramObject;
          if (i == 0) {
            return;
          }
          Tag.valueOf().post(mPostValueRunnable);
          return;
        }
      }
      catch (Throwable paramObject)
      {
        throw paramObject;
      }
      int i = 0;
    }
  }
  
  public void removeObserver(Observer paramObserver)
  {
    assertMainThread("removeObserver");
    paramObserver = (b)mObservers.remove(paramObserver);
    if (paramObserver == null) {
      return;
    }
    paramObserver.a();
    paramObserver.b(false);
  }
  
  public void removeObservers(d paramD)
  {
    assertMainThread("removeObservers");
    Iterator localIterator = mObservers.iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((b)localEntry.getValue()).c(paramD)) {
        removeObserver((Observer)localEntry.getKey());
      }
    }
  }
  
  public void setValue(Object paramObject)
  {
    assertMainThread("setValue");
    mVersion += 1;
    mData = paramObject;
    dispatchingValue(null);
  }
  
  public class LifecycleBoundObserver
    extends LiveData<T>.b
    implements GenericLifecycleObserver
  {
    @F
    public final d a;
    
    public LifecycleBoundObserver(d paramD, Observer paramObserver)
    {
      super(paramObserver);
      a = paramD;
    }
    
    public void a()
    {
      a.getLifecycle().d(this);
    }
    
    public void b(d paramD, support.support.asm.c paramC)
    {
      if (a.getLifecycle().a() == f.c)
      {
        removeObserver(s);
        return;
      }
      b(b());
    }
    
    public boolean b()
    {
      return a.getLifecycle().a().a(f.g);
    }
    
    public boolean c(d paramD)
    {
      return a == paramD;
    }
  }
  
  private class a
    extends LiveData<T>.b
  {
    public a(Observer paramObserver)
    {
      super(paramObserver);
    }
    
    public boolean b()
    {
      return true;
    }
  }
  
  private abstract class b
  {
    public boolean d;
    public int i = -1;
    public final s<T> s;
    
    public b(Observer paramObserver)
    {
      s = paramObserver;
    }
    
    public void a() {}
    
    public void b(boolean paramBoolean)
    {
      if (paramBoolean == d) {
        return;
      }
      d = paramBoolean;
      int j = LiveData.access$300(LiveData.this);
      int k = 1;
      if (j == 0) {
        j = 1;
      } else {
        j = 0;
      }
      LiveData localLiveData = LiveData.this;
      int m = LiveData.access$300(localLiveData);
      if (!d) {
        k = -1;
      }
      LiveData.access$302(localLiveData, m + k);
      if ((j != 0) && (d)) {
        onActive();
      }
      if ((LiveData.access$300(LiveData.this) == 0) && (!d)) {
        onInactive();
      }
      if (d) {
        LiveData.access$400(LiveData.this, this);
      }
    }
    
    public abstract boolean b();
    
    public boolean c(d paramD)
    {
      return false;
    }
  }
}
