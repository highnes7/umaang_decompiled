package com.google.android.android.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class zzexa
  implements Iterator<Object>
{
  public zzexa() {}
  
  public final boolean hasNext()
  {
    return false;
  }
  
  public final Object next()
  {
    throw new NoSuchElementException();
  }
  
  public final void remove()
  {
    throw new UnsupportedOperationException();
  }
}
