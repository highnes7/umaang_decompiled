package com.google.android.android.internal;

import android.os.Bundle;
import java.util.Iterator;
import java.util.Set;

public final class zzcbi
  implements Iterator<String>
{
  public Iterator<String> zzinp = zzcbh.getArguments(zzinq).keySet().iterator();
  
  public zzcbi(zzcbh paramZzcbh) {}
  
  public final boolean hasNext()
  {
    return zzinp.hasNext();
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException("Remove not supported");
  }
}
