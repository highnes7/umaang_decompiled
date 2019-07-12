package support.android.v4.asm;

import android.media.VolumeProvider;
import android.os.Build.VERSION;

public abstract class f
{
  public static final int A = 2;
  public static final int d = 0;
  public static final int f = 1;
  public Object b;
  public int h;
  public la.a k;
  public final int n;
  public final int s;
  
  public f(int paramInt1, int paramInt2, int paramInt3)
  {
    s = paramInt1;
    n = paramInt2;
    h = paramInt3;
  }
  
  public Object a()
  {
    if ((b == null) && (Build.VERSION.SDK_INT >= 21)) {
      b = new VolumeProviderCompatApi21.1(s, n, h, new g(this));
    }
    return b;
  }
  
  public final void b(int paramInt)
  {
    h = paramInt;
    Object localObject = a();
    if ((localObject != null) && (Build.VERSION.SDK_INT >= 21)) {
      ((VolumeProvider)localObject).setCurrentVolume(paramInt);
    }
    localObject = k;
    if (localObject != null) {
      ((la.a)localObject).setPlaybackToRemote(this);
    }
  }
  
  public void clear(int paramInt) {}
  
  public void d(int paramInt) {}
  
  public final int getCurrentVolume()
  {
    return s;
  }
  
  public final int getMaxVolume()
  {
    return h;
  }
  
  public final int getVolumeControl()
  {
    return n;
  }
  
  public void setCallback(la.a paramA)
  {
    k = paramA;
  }
}
