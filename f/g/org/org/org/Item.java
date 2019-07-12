package f.g.org.org.org;

import f.g.b.a.b.a;
import f.g.org.org.util.SecurityUtils;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;

public final class Item
{
  public static final Integer a = Integer.valueOf(1);
  public static final Integer b = Integer.valueOf(20);
  public static final Integer c = Integer.valueOf(0);
  public static final String id;
  public static KeyStore mTag;
  
  static
  {
    String str1 = String.valueOf(a);
    String str2 = String.valueOf(b);
    String str3 = String.valueOf(c);
    int i = str1.length();
    int j = str2.length();
    StringBuilder localStringBuilder = new StringBuilder(str3.length() + (j + (i + 2)));
    f.sufficientlysecure.rootcommands.util.StringBuilder.append(localStringBuilder, str1, ".", str2, ".");
    localStringBuilder.append(str3);
    id = localStringBuilder.toString().toString();
  }
  
  public Item() {}
  
  public static KeyStore getTag()
    throws IOException, GeneralSecurityException
  {
    try
    {
      if (mTag == null)
      {
        mTag = SecurityUtils.getJavaKeyStore();
        localObject = a.class.getResourceAsStream("google.jks");
        SecurityUtils.loadKeyStore(mTag, (InputStream)localObject, "notasecret");
      }
      Object localObject = mTag;
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
