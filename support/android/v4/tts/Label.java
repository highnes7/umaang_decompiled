package support.android.v4.tts;

import android.net.Uri;

public class Label
{
  public final int a;
  public final int b;
  public final Uri c;
  public final int d;
  public final boolean f;
  
  public Label(Uri paramUri, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if (paramUri != null)
    {
      c = paramUri;
      d = paramInt1;
      a = paramInt2;
      f = paramBoolean;
      b = paramInt3;
      return;
    }
    throw new NullPointerException();
  }
  
  public int a()
  {
    return a;
  }
  
  public int b()
  {
    return d;
  }
  
  public int c()
  {
    return b;
  }
  
  public Uri getName()
  {
    return c;
  }
  
  public boolean getValue()
  {
    return f;
  }
}
