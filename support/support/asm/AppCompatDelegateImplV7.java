package support.support.asm;

import android.arch.lifecycle.LiveData;
import b.b.a.N;
import b.b.a.W;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import support.support.v7.widget.AsyncHttpClient;
import support.support.v7.widget.Tag;

@N({b.b.a.N.a.b})
public abstract class AppCompatDelegateImplV7<T>
{
  public AtomicBoolean a = new AtomicBoolean(false);
  public AtomicBoolean c = new AtomicBoolean(true);
  @W
  public final Runnable n = new DayFragment.1(this);
  @W
  public final Runnable r = new EventInfoFragment.1(this);
  public final LiveData<T> s;
  public final Executor v;
  
  public AppCompatDelegateImplV7()
  {
    this(Tag.data);
  }
  
  public AppCompatDelegateImplV7(Executor paramExecutor)
  {
    v = paramExecutor;
    s = new Roster.RosterPushListener(this);
  }
  
  public void a()
  {
    Tag.valueOf().cancel(n);
  }
  
  public LiveData d()
  {
    return s;
  }
  
  public abstract Object read();
}
