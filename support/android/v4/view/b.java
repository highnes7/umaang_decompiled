package support.android.v4.view;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public final class b
{
  public static final String g = "AsyncLayoutInflater";
  public ClassWriter a;
  public LayoutInflater b;
  public Handler f;
  public Handler.Callback l = new MainActivity.6(this);
  
  public b(Context paramContext)
  {
    b = new InternalLayoutInflater(paramContext);
    f = new Handler(l);
    a = ClassWriter.a;
  }
  
  public void a(int paramInt, ViewGroup paramViewGroup, Item paramItem)
  {
    if (paramItem != null)
    {
      e localE = a.a();
      c = this;
      l = paramInt;
      b = paramViewGroup;
      k = paramItem;
      a.put(localE);
      return;
    }
    throw new NullPointerException("callback argument may not be null!");
  }
}
