package support.support.asm;

import android.arch.lifecycle.LiveData;
import b.a.a.b.c;
import b.a.b.p.a;
import b.a.b.r;
import java.util.Iterator;
import java.util.Map.Entry;
import support.support.v7.util.LinkedListMultimap;

public class i<T>
  extends r<T>
{
  public c<LiveData<?>, p.a<?>> q = new LinkedListMultimap();
  
  public i() {}
  
  public void d(LiveData paramLiveData)
  {
    paramLiveData = (Logger)q.remove(paramLiveData);
    if (paramLiveData != null) {
      paramLiveData.log();
    }
  }
  
  public void d(LiveData paramLiveData, Observer paramObserver)
  {
    Logger localLogger = new Logger(paramLiveData, paramObserver);
    paramLiveData = (Logger)q.remove(paramLiveData, localLogger);
    if ((paramLiveData != null) && (f != paramObserver)) {
      throw new IllegalArgumentException("This source was already added with the different observer");
    }
    if (paramLiveData != null) {
      return;
    }
    if (hasActiveObservers()) {
      localLogger.fatal();
    }
  }
  
  public void onActive()
  {
    Iterator localIterator = q.iterator();
    while (localIterator.hasNext()) {
      ((Logger)((Map.Entry)localIterator.next()).getValue()).fatal();
    }
  }
  
  public void onInactive()
  {
    Iterator localIterator = q.iterator();
    while (localIterator.hasNext()) {
      ((Logger)((Map.Entry)localIterator.next()).getValue()).log();
    }
  }
}
