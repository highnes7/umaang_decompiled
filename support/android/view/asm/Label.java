package support.android.view.asm;

import java.util.Arrays;

public class Label
{
  public static final int ATTENDEES_INDEX_RELATIONSHIP = 3;
  public static final int CALENDARS_INDEX_CAN_ORGANIZER_RESPOND = 4;
  public static final boolean DEBUG = false;
  public static final int PHOTO_THUMBNAIL_URI = 6;
  public static final int REACHABLE = 0;
  public static final int RESOLVED = 2;
  public static final int TRANSACTION_getInfo = 5;
  public static final int f = 1;
  public static int h;
  public c a;
  public h[] b = new h[8];
  public int c = -1;
  public float[] d = new float[6];
  public String e;
  public float g;
  public int i = 0;
  public int j = -1;
  public int k = 0;
  
  public Label(String paramString, c paramC)
  {
    e = paramString;
    a = paramC;
  }
  
  public Label(c paramC)
  {
    a = paramC;
  }
  
  public static String a(c paramC)
  {
    h += 1;
    int m = paramC.ordinal();
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 3)
          {
            paramC = f.sufficientlysecure.rootcommands.util.StringBuilder.append("V");
            paramC.append(h);
            return paramC.toString();
          }
          paramC = f.sufficientlysecure.rootcommands.util.StringBuilder.append("e");
          paramC.append(h);
          return paramC.toString();
        }
        paramC = f.sufficientlysecure.rootcommands.util.StringBuilder.append("S");
        paramC.append(h);
        return paramC.toString();
      }
      paramC = f.sufficientlysecure.rootcommands.util.StringBuilder.append("C");
      paramC.append(h);
      return paramC.toString();
    }
    paramC = f.sufficientlysecure.rootcommands.util.StringBuilder.append("U");
    paramC.append(h);
    return paramC.toString();
  }
  
  public void a()
  {
    e = null;
    a = c.f;
    i = 0;
    j = -1;
    c = -1;
    g = 0.0F;
    k = 0;
  }
  
  public void a(String paramString)
  {
    e = paramString;
  }
  
  public void a(h paramH)
  {
    int n = 0;
    int m = 0;
    while (m < k)
    {
      if (b[m] == paramH)
      {
        int i1;
        for (;;)
        {
          i1 = k;
          if (n >= i1 - m - 1) {
            break;
          }
          paramH = b;
          i1 = m + n;
          paramH[i1] = paramH[(i1 + 1)];
          n += 1;
        }
        k = (i1 - 1);
        return;
      }
      m += 1;
    }
  }
  
  public void b()
  {
    int m = 0;
    while (m < 6)
    {
      d[m] = 0.0F;
      m += 1;
    }
  }
  
  public void b(c paramC)
  {
    a = paramC;
  }
  
  public void b(h paramH)
  {
    int m = 0;
    int n;
    for (;;)
    {
      n = k;
      if (m >= n) {
        break;
      }
      if (b[m] == paramH) {
        return;
      }
      m += 1;
    }
    h[] arrayOfH = b;
    if (n >= arrayOfH.length) {
      b = ((h[])Arrays.copyOf(arrayOfH, arrayOfH.length * 2));
    }
    arrayOfH = b;
    m = k;
    arrayOfH[m] = paramH;
    k = (m + 1);
  }
  
  public String e()
  {
    return e;
  }
  
  public String format()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this);
    ((StringBuilder)localObject).append("[");
    localObject = ((StringBuilder)localObject).toString();
    int m = 0;
    while (m < d.length)
    {
      localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append((String)localObject);
      ((StringBuilder)localObject).append(d[m]);
      localObject = ((StringBuilder)localObject).toString();
      if (m < d.length - 1) {
        localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.toString((String)localObject, ", ");
      } else {
        localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.toString((String)localObject, "] ");
      }
      m += 1;
    }
    return localObject;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("");
    localStringBuilder.append(e);
    return localStringBuilder.toString();
  }
}
