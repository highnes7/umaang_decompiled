package f.g.org.org.util.xml;

public abstract class UnicodeEscaper
  extends Escaper
{
  public static final int DEST_PAD = 32;
  
  public UnicodeEscaper() {}
  
  public static int codePointAt(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 < paramInt2)
    {
      int j = paramInt1 + 1;
      i = paramCharSequence.charAt(paramInt1);
      if (i >= 55296)
      {
        if (i > 57343) {
          return i;
        }
        if (i <= 56319)
        {
          if (j == paramInt2) {
            return -i;
          }
          char c = paramCharSequence.charAt(j);
          if (Character.isLowSurrogate(c)) {
            return Character.toCodePoint(i, c);
          }
          paramCharSequence = new StringBuilder(83);
          paramCharSequence.append("Expected low surrogate but got char '");
          paramCharSequence.append(c);
          paramCharSequence.append("' with value ");
          paramCharSequence.append(c);
          paramCharSequence.append(" at index ");
          paramCharSequence.append(j);
          throw new IllegalArgumentException(paramCharSequence.toString());
        }
        paramCharSequence = new StringBuilder(82);
        paramCharSequence.append("Unexpected low surrogate character '");
        paramCharSequence.append(i);
        paramCharSequence.append("' with value ");
        paramCharSequence.append(i);
        paramCharSequence.append(" at index ");
        paramCharSequence.append(j - 1);
        throw new IllegalArgumentException(paramCharSequence.toString());
      }
    }
    else
    {
      throw new IndexOutOfBoundsException("Index exceeds specified range");
    }
    return i;
  }
  
  public static char[] growBuffer(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    char[] arrayOfChar = new char[paramInt2];
    if (paramInt1 > 0) {
      System.arraycopy(paramArrayOfChar, 0, arrayOfChar, 0, paramInt1);
    }
    return arrayOfChar;
  }
  
  public abstract String escape(String paramString);
  
  public abstract char[] escape(int paramInt);
  
  public final String escapeSlow(String paramString, int paramInt)
  {
    int i1 = paramString.length();
    Object localObject1 = Platform.charBufferFromThreadLocal();
    int j = 0;
    int i = 0;
    int k = paramInt;
    paramInt = i;
    Object localObject2;
    while (k < i1)
    {
      i = codePointAt(paramString, k, i1);
      if (i >= 0)
      {
        char[] arrayOfChar = escape(i);
        if (Character.isSupplementaryCodePoint(i)) {
          i = 2;
        } else {
          i = 1;
        }
        int n = i + k;
        localObject2 = localObject1;
        int m = j;
        i = paramInt;
        if (arrayOfChar != null)
        {
          int i2 = k - j;
          m = paramInt + i2;
          i = arrayOfChar.length + m;
          localObject2 = localObject1;
          if (localObject1.length < i) {
            localObject2 = growBuffer((char[])localObject1, paramInt, i + i1 - k + 32);
          }
          i = paramInt;
          if (i2 > 0)
          {
            paramString.getChars(j, k, (char[])localObject2, paramInt);
            i = m;
          }
          paramInt = i;
          if (arrayOfChar.length > 0)
          {
            System.arraycopy(arrayOfChar, 0, localObject2, i, arrayOfChar.length);
            paramInt = i + arrayOfChar.length;
          }
          m = n;
          i = paramInt;
        }
        k = nextEscapeIndex(paramString, n, i1);
        localObject1 = localObject2;
        j = m;
        paramInt = i;
      }
      else
      {
        throw new IllegalArgumentException("Trailing high surrogate at end of input");
      }
    }
    i = i1 - j;
    if (i > 0)
    {
      i += paramInt;
      localObject2 = localObject1;
      if (localObject1.length < i) {
        localObject2 = growBuffer((char[])localObject1, paramInt, i);
      }
      paramString.getChars(j, i1, (char[])localObject2, paramInt);
      localObject1 = localObject2;
      paramInt = i;
    }
    return new String((char[])localObject1, 0, paramInt);
  }
  
  public abstract int nextEscapeIndex(CharSequence paramCharSequence, int paramInt1, int paramInt2);
}
