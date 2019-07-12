package f.g.org.org.util.xml;

import f.sufficientlysecure.rootcommands.util.StringBuilder;

public class PercentEscaper
  extends UnicodeEscaper
{
  public static final String SAFECHARS_URLENCODER = "-_.*";
  public static final String SAFEPATHCHARS_URLENCODER = "-_.!~*'()@:$&,;=";
  public static final String SAFEQUERYSTRINGCHARS_URLENCODER = "-_.!~*'()@:$,;/?:";
  public static final String SAFEUSERINFOCHARS_URLENCODER = "-_.!~*'():$&,;=";
  public static final String SAFE_PLUS_RESERVED_CHARS_URLENCODER = "-_.!~*'()@:$&,;=+/?";
  public static final char[] UPPER_HEX_DIGITS = "0123456789ABCDEF".toCharArray();
  public static final char[] URI_ESCAPED_SPACE = { '+' };
  public final boolean plusForSpace;
  public final boolean[] safeOctets;
  
  public PercentEscaper(String paramString, boolean paramBoolean)
  {
    if (!paramString.matches(".*[0-9A-Za-z].*"))
    {
      if ((paramBoolean) && (paramString.contains(" "))) {
        throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
      }
      if (!paramString.contains("%"))
      {
        plusForSpace = paramBoolean;
        safeOctets = createSafeOctets(paramString);
        return;
      }
      throw new IllegalArgumentException("The '%' character cannot be specified as 'safe'");
    }
    throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
  }
  
  public static boolean[] createSafeOctets(String paramString)
  {
    paramString = paramString.toCharArray();
    int m = paramString.length;
    int k = 0;
    int i = 0;
    int j = 122;
    while (i < m)
    {
      j = Math.max(paramString[i], j);
      i += 1;
    }
    boolean[] arrayOfBoolean = new boolean[j + 1];
    i = 48;
    while (i <= 57)
    {
      arrayOfBoolean[i] = true;
      i += 1;
    }
    i = 65;
    while (i <= 90)
    {
      arrayOfBoolean[i] = true;
      i += 1;
    }
    i = 97;
    while (i <= 122)
    {
      arrayOfBoolean[i] = true;
      i += 1;
    }
    j = paramString.length;
    i = k;
    while (i < j)
    {
      arrayOfBoolean[paramString[i]] = true;
      i += 1;
    }
    return arrayOfBoolean;
  }
  
  public String escape(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      localObject = paramString;
      if (i >= j) {
        break label62;
      }
      int k = paramString.charAt(i);
      localObject = safeOctets;
      if ((k >= localObject.length) || (localObject[k] == 0)) {
        break;
      }
      i += 1;
    }
    Object localObject = escapeSlow(paramString, i);
    label62:
    return localObject;
  }
  
  public char[] escape(int paramInt)
  {
    Object localObject = safeOctets;
    if ((paramInt < localObject.length) && (localObject[paramInt] != 0)) {
      return null;
    }
    if ((paramInt == 32) && (plusForSpace)) {
      return URI_ESCAPED_SPACE;
    }
    int i;
    if (paramInt <= 127)
    {
      localObject = UPPER_HEX_DIGITS;
      i = localObject[(paramInt & 0xF)];
      return new char[] { '%', localObject[(paramInt >>> 4)], i };
    }
    int j;
    int k;
    if (paramInt <= 2047)
    {
      localObject = UPPER_HEX_DIGITS;
      i = localObject[(paramInt & 0xF)];
      paramInt >>>= 4;
      j = localObject[(paramInt & 0x3 | 0x8)];
      paramInt >>>= 2;
      k = localObject[(paramInt & 0xF)];
      return new char[] { '%', localObject[(paramInt >>> 4 | 0xC)], k, '%', j, i };
    }
    int m;
    if (paramInt <= 65535)
    {
      localObject = UPPER_HEX_DIGITS;
      i = localObject[(paramInt & 0xF)];
      paramInt >>>= 4;
      j = localObject[(paramInt & 0x3 | 0x8)];
      paramInt >>>= 2;
      k = localObject[(paramInt & 0xF)];
      paramInt >>>= 4;
      m = localObject[(paramInt & 0x3 | 0x8)];
      return new char[] { '%', 'E', localObject[(paramInt >>> 2)], '%', m, k, '%', j, i };
    }
    if (paramInt <= 1114111)
    {
      localObject = UPPER_HEX_DIGITS;
      i = localObject[(paramInt & 0xF)];
      paramInt >>>= 4;
      j = localObject[(paramInt & 0x3 | 0x8)];
      paramInt >>>= 2;
      k = localObject[(paramInt & 0xF)];
      paramInt >>>= 4;
      m = localObject[(paramInt & 0x3 | 0x8)];
      paramInt >>>= 2;
      int n = localObject[(paramInt & 0xF)];
      paramInt >>>= 4;
      int i1 = localObject[(paramInt & 0x3 | 0x8)];
      return new char[] { '%', 'F', localObject[(paramInt >>> 2 & 0x7)], '%', i1, n, '%', m, k, '%', j, i };
    }
    throw new IllegalArgumentException(StringBuilder.add(43, "Invalid unicode character value ", paramInt));
  }
  
  public int nextEscapeIndex(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      int i = paramCharSequence.charAt(paramInt1);
      boolean[] arrayOfBoolean = safeOctets;
      if (i >= arrayOfBoolean.length) {
        break;
      }
      if (arrayOfBoolean[i] == 0) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return paramInt1;
  }
}
