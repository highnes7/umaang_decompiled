package f.g.c.package_10;

import f.g.c.a.b;

@b
public enum f
{
  public final String f;
  public final h g;
  
  static
  {
    a = new f("LOWER_UNDERSCORE", 1, h.is('_'), "_");
    r = new f("LOWER_CAMEL", 2, h.inRange('A', 'Z'), "");
  }
  
  public f(h paramH, String paramString)
  {
    g = paramH;
    f = paramString;
  }
  
  public static String a(String paramString)
  {
    int i = paramString.length();
    if (i == 0) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder(i);
    localStringBuilder.append(ClassWriter.get(paramString.charAt(0)));
    localStringBuilder.append(ClassWriter.toLowerCase(paramString.substring(1)));
    return localStringBuilder.toString();
  }
  
  private String b(String paramString)
  {
    if (ordinal() != 2) {
      return c(paramString);
    }
    return ClassWriter.toLowerCase(paramString);
  }
  
  private String c(String paramString)
  {
    int i = ordinal();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i == 4) {
              return ClassWriter.a(paramString);
            }
            throw new RuntimeException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString("unknown case: ", this));
          }
          return a(paramString);
        }
        return a(paramString);
      }
      return ClassWriter.toLowerCase(paramString);
    }
    return ClassWriter.toLowerCase(paramString);
  }
  
  public String a(f paramF, String paramString)
  {
    if (paramF != null)
    {
      if (paramString != null)
      {
        if (paramF == this) {
          return paramString;
        }
        int i = ordinal();
        if (i != 0)
        {
          if (i != 1)
          {
            if (i == 4)
            {
              i = paramF.ordinal();
              if (i != 0)
              {
                if (i == 1) {
                  return ClassWriter.toLowerCase(paramString);
                }
              }
              else {
                return ClassWriter.toLowerCase(paramString.replace('_', '-'));
              }
            }
          }
          else
          {
            i = paramF.ordinal();
            if (i != 0)
            {
              if (i == 4) {
                return ClassWriter.a(paramString);
              }
            }
            else {
              return paramString.replace('_', '-');
            }
          }
        }
        else
        {
          i = paramF.ordinal();
          if (i == 1) {
            break label284;
          }
          if (i == 4) {
            break label272;
          }
        }
        i = 0;
        StringBuilder localStringBuilder = null;
        int j = -1;
        for (;;)
        {
          int k = g.a(paramString, j + 1);
          j = k;
          if (k == -1) {
            break;
          }
          if (i == 0)
          {
            int m = paramString.length();
            localStringBuilder = new StringBuilder(f.length() * 4 + m);
            localStringBuilder.append(paramF.b(paramString.substring(i, k)));
          }
          else
          {
            localStringBuilder.append(paramF.c(paramString.substring(i, k)));
          }
          localStringBuilder.append(f);
          i = f.length() + k;
        }
        if (i == 0) {
          return paramF.b(paramString);
        }
        localStringBuilder.append(paramF.c(paramString.substring(i)));
        return localStringBuilder.toString();
        label272:
        return ClassWriter.a(paramString.replace('-', '_'));
        label284:
        return paramString.replace('-', '_');
      }
      throw new NullPointerException();
    }
    paramF = new NullPointerException();
    throw paramF;
  }
}
