package f.g.org.org.util.xml;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public final class CharEscapers
{
  public static final Escaper URI_ESCAPER = new PercentEscaper("-_.*", true);
  public static final Escaper URI_PATH_ESCAPER = new PercentEscaper("-_.!~*'()@:$&,;=", false);
  public static final Escaper URI_QUERY_STRING_ESCAPER = new PercentEscaper("-_.!~*'()@:$,;/?:", false);
  public static final Escaper URI_RESERVED_ESCAPER = new PercentEscaper("-_.!~*'()@:$&,;=+/?", false);
  public static final Escaper URI_USERINFO_ESCAPER = new PercentEscaper("-_.!~*'():$&,;=", false);
  
  public CharEscapers() {}
  
  public static String decodeUri(String paramString)
  {
    try
    {
      paramString = URLDecoder.decode(paramString, "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  public static String escapeUri(String paramString)
  {
    return URI_ESCAPER.escape(paramString);
  }
  
  public static String escapeUriPath(String paramString)
  {
    return URI_PATH_ESCAPER.escape(paramString);
  }
  
  public static String escapeUriPathWithoutReserved(String paramString)
  {
    return URI_RESERVED_ESCAPER.escape(paramString);
  }
  
  public static String escapeUriQuery(String paramString)
  {
    return URI_QUERY_STRING_ESCAPER.escape(paramString);
  }
  
  public static String escapeUriUserInfo(String paramString)
  {
    return URI_USERINFO_ESCAPER.escape(paramString);
  }
}
