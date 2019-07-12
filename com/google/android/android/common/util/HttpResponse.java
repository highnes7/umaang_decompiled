package com.google.android.android.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class HttpResponse
{
  public static final Pattern zzfza = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
  public static final Pattern zzfzb = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
  public static final Pattern zzfzc = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
  
  public static String decode(String paramString1, String paramString2)
  {
    if (paramString2 == null) {
      paramString2 = "ISO-8859-1";
    }
    try
    {
      paramString1 = URLDecoder.decode(paramString1, paramString2);
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      throw new IllegalArgumentException(paramString1);
    }
  }
  
  public static Map parse(URI paramURI, String paramString)
  {
    Object localObject = Collections.emptyMap();
    paramURI = paramURI.getRawQuery();
    Scanner localScanner;
    if ((paramURI != null) && (paramURI.length() > 0))
    {
      localObject = new HashMap();
      localScanner = new Scanner(paramURI);
      localScanner.useDelimiter("&");
    }
    while (localScanner.hasNext())
    {
      String[] arrayOfString = localScanner.next().split("=");
      if ((arrayOfString.length != 0) && (arrayOfString.length <= 2))
      {
        String str = decode(arrayOfString[0], paramString);
        paramURI = null;
        if (arrayOfString.length == 2) {
          paramURI = decode(arrayOfString[1], paramString);
        }
        ((Map)localObject).put(str, paramURI);
      }
      else
      {
        throw new IllegalArgumentException("bad parameter");
        return localObject;
      }
    }
    return localObject;
  }
}
