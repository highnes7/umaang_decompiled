package support.android.v4.content;

import java.util.ArrayList;

public final class ByteVector
{
  public ByteVector() {}
  
  public static boolean add(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return false;
    }
    return get(paramString1.split("/"), paramString2.split("/"));
  }
  
  public static boolean get(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if (paramArrayOfString2.length == 2)
    {
      if ((!paramArrayOfString2[0].isEmpty()) && (!paramArrayOfString2[1].isEmpty()))
      {
        if (paramArrayOfString1.length != 2) {
          return false;
        }
        if ((!"*".equals(paramArrayOfString2[0])) && (!paramArrayOfString2[0].equals(paramArrayOfString1[0]))) {
          return false;
        }
        if (!"*".equals(paramArrayOfString2[1]))
        {
          if (!paramArrayOfString2[1].equals(paramArrayOfString1[1])) {
            return false;
          }
        }
        else {
          return true;
        }
      }
      else
      {
        throw new IllegalArgumentException("Ill-formatted MIME type filter. Type or subtype empty.");
      }
    }
    else {
      throw new IllegalArgumentException("Ill-formatted MIME type filter. Must be type/subtype.");
    }
    return true;
  }
  
  public static String[] getArray(String[] paramArrayOfString, String paramString)
  {
    int i = 0;
    if (paramArrayOfString == null) {
      return new String[0];
    }
    ArrayList localArrayList = new ArrayList();
    paramString = paramString.split("/");
    int j = paramArrayOfString.length;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (get(str.split("/"), paramString)) {
        localArrayList.add(str);
      }
      i += 1;
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public static String read(String paramString, String[] paramArrayOfString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = paramString.split("/");
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (get(paramString, str.split("/"))) {
        return str;
      }
      i += 1;
    }
    return null;
  }
  
  public static String read(String[] paramArrayOfString, String paramString)
  {
    if (paramArrayOfString == null) {
      return null;
    }
    paramString = paramString.split("/");
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (get(str.split("/"), paramString)) {
        return str;
      }
      i += 1;
    }
    return null;
  }
}
