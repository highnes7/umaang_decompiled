package com.google.android.android.internal;

import java.io.IOException;

public abstract class zzeyh<M extends com.google.android.gms.internal.zzeyh<M>>
  extends com.google.android.gms.internal.zzeyn
{
  public zzeyj zzotl;
  
  public zzeyh() {}
  
  public final Object addTo(zzeyi paramZzeyi)
  {
    Object localObject = zzotl;
    if (localObject == null) {
      return null;
    }
    localObject = ((zzeyj)localObject).zzle(uuid >>> 3);
    if (localObject == null) {
      return null;
    }
    return ((zzeyk)localObject).addElement(paramZzeyi);
  }
  
  public final boolean digest(zzeye paramZzeye, int paramInt)
    throws IOException
  {
    int i = paramZzeye.getPosition();
    if (!paramZzeye.zzjl(paramInt)) {
      return false;
    }
    int j = paramInt >>> 3;
    zzeyp localZzeyp = new zzeyp(paramInt, paramZzeye.zzai(i, paramZzeye.getPosition() - i));
    paramZzeye = null;
    Object localObject = zzotl;
    if (localObject == null) {
      zzotl = new zzeyj(10);
    } else {
      paramZzeye = ((zzeyj)localObject).zzle(j);
    }
    localObject = paramZzeye;
    if (paramZzeye == null)
    {
      localObject = new zzeyk();
      zzotl.digest(j, (zzeyk)localObject);
    }
    ((zzeyk)localObject).flush(localZzeyp);
    return true;
  }
  
  public void multiply(zzeyf paramZzeyf)
    throws IOException
  {
    if (zzotl == null) {
      return;
    }
    int i = 0;
    while (i < zzotl.size())
    {
      zzotl.zzlf(i).get(paramZzeyf);
      i += 1;
    }
  }
  
  public int updateBookmarks()
  {
    zzeyj localZzeyj = zzotl;
    int i = 0;
    int j;
    if (localZzeyj != null)
    {
      j = 0;
      while (i < zzotl.size())
      {
        j += zzotl.zzlf(i).indexOf();
        i += 1;
      }
    }
    return 0;
    return j;
  }
  
  public zzeyh zzcvz()
    throws CloneNotSupportedException
  {
    zzeyh localZzeyh = (zzeyh)super.zzcwa();
    zzeyl.blur(this, localZzeyh);
    return localZzeyh;
  }
}
