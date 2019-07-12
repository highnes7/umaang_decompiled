package support.android.v4.tts;

import android.util.Base64;
import java.util.List;
import support.android.v4.util.Label;

public final class h
{
  public final String b;
  public final String d;
  public final List<List<byte[]>> e;
  public final String f;
  public final int g;
  public final String i;
  
  public h(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (paramString1 != null)
    {
      f = paramString1;
      if (paramString2 != null)
      {
        b = paramString2;
        if (paramString3 != null)
        {
          i = paramString3;
          e = null;
          boolean bool;
          if (paramInt != 0) {
            bool = true;
          } else {
            bool = false;
          }
          Label.b(bool);
          g = paramInt;
          paramString1 = new StringBuilder(f);
          paramString1.append("-");
          paramString1.append(b);
          paramString1.append("-");
          paramString1.append(i);
          d = paramString1.toString();
          return;
        }
        throw new NullPointerException();
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public h(String paramString1, String paramString2, String paramString3, List paramList)
  {
    if (paramString1 != null)
    {
      f = paramString1;
      if (paramString2 != null)
      {
        b = paramString2;
        if (paramString3 != null)
        {
          i = paramString3;
          if (paramList != null)
          {
            e = paramList;
            g = 0;
            paramString1 = new StringBuilder(f);
            paramString1.append("-");
            paramString1.append(b);
            paramString1.append("-");
            paramString1.append(i);
            d = paramString1.toString();
            return;
          }
          throw new NullPointerException();
        }
        throw new NullPointerException();
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }
  
  public String a()
  {
    return d;
  }
  
  public int b()
  {
    return g;
  }
  
  public String f()
  {
    return f;
  }
  
  public String getGroupId()
  {
    return b;
  }
  
  public List getTitle()
  {
    return e;
  }
  
  public String i()
  {
    return i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("FontRequest {mProviderAuthority: ");
    ((StringBuilder)localObject).append(f);
    ((StringBuilder)localObject).append(", mProviderPackage: ");
    ((StringBuilder)localObject).append(b);
    ((StringBuilder)localObject).append(", mQuery: ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(", mCertificates:");
    localStringBuilder.append(((StringBuilder)localObject).toString());
    int j = 0;
    while (j < e.size())
    {
      localStringBuilder.append(" [");
      localObject = (List)e.get(j);
      int k = 0;
      while (k < ((List)localObject).size())
      {
        localStringBuilder.append(" \"");
        localStringBuilder.append(Base64.encodeToString((byte[])((List)localObject).get(k), 0));
        localStringBuilder.append("\"");
        k += 1;
      }
      localStringBuilder.append(" ]");
      j += 1;
    }
    localStringBuilder.append("}");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mCertificatesArray: ");
    ((StringBuilder)localObject).append(g);
    localStringBuilder.append(((StringBuilder)localObject).toString());
    return localStringBuilder.toString();
  }
}
