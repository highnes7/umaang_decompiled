package f.fasterxml.jackson.core;

import f.sufficientlysecure.rootcommands.util.StringBuilder;

public final class Base64Variants
{
  public static final Base64Variant MIME = new Base64Variant("MIME", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", true, '=', 76);
  public static final Base64Variant MIME_NO_LINEFEEDS = new Base64Variant(MIME, "MIME-NO-LINEFEEDS", Integer.MAX_VALUE);
  public static final Base64Variant MODIFIED_FOR_URL;
  public static final Base64Variant PEM = new Base64Variant(MIME, "PEM", true, '=', 64);
  public static final String STD_BASE64_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
  
  static
  {
    StringBuffer localStringBuffer = new StringBuffer("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
    localStringBuffer.setCharAt(localStringBuffer.indexOf("+"), '-');
    localStringBuffer.setCharAt(localStringBuffer.indexOf("/"), '_');
    MODIFIED_FOR_URL = new Base64Variant("MODIFIED-FOR-URL", localStringBuffer.toString(), false, '\000', Integer.MAX_VALUE);
  }
  
  public Base64Variants() {}
  
  public static Base64Variant valueOf()
  {
    return MIME_NO_LINEFEEDS;
  }
  
  public static Base64Variant valueOf(String paramString)
    throws IllegalArgumentException
  {
    if (MIME_name.equals(paramString)) {
      return MIME;
    }
    if (MIME_NO_LINEFEEDS_name.equals(paramString)) {
      return MIME_NO_LINEFEEDS;
    }
    if (PEM_name.equals(paramString)) {
      return PEM;
    }
    if (MODIFIED_FOR_URL_name.equals(paramString)) {
      return MODIFIED_FOR_URL;
    }
    if (paramString == null) {
      paramString = "<null>";
    } else {
      paramString = StringBuilder.append("'", paramString, "'");
    }
    throw new IllegalArgumentException(StringBuilder.toString("No Base64Variant with name ", paramString));
  }
}
