package f.fasterxml.jackson.core.impl;

import f.d.a.a.c.f;
import f.fasterxml.jackson.core.util.ByteArrayBuilder;
import f.fasterxml.jackson.core.util.TextBuffer;
import java.lang.ref.SoftReference;

public final class JsonStringEncoder
{
  public static final byte[] HEX_BYTES = Utf8StreamParser.copyHexBytes();
  public static final char[] HEX_CHARS = ;
  public static final int INT_0 = 48;
  public static final int INT_BACKSLASH = 92;
  public static final int INT_U = 117;
  public static final int SURR1_FIRST = 55296;
  public static final int SURR1_LAST = 56319;
  public static final int SURR2_FIRST = 56320;
  public static final int SURR2_LAST = 57343;
  public static final ThreadLocal<SoftReference<f>> _threadEncoder = new ThreadLocal();
  public ByteArrayBuilder _byteBuilder;
  public final char[] _quoteBuffer = new char[6];
  public TextBuffer _textBuffer;
  
  public JsonStringEncoder()
  {
    char[] arrayOfChar = _quoteBuffer;
    arrayOfChar[0] = '\\';
    arrayOfChar[2] = '0';
    arrayOfChar[3] = '0';
  }
  
  private int _appendByteEscape(int paramInt1, int paramInt2, ByteArrayBuilder paramByteArrayBuilder, int paramInt3)
  {
    paramByteArrayBuilder.setCurrentSegmentLength(paramInt3);
    paramByteArrayBuilder.append(92);
    if (paramInt2 < 0)
    {
      paramByteArrayBuilder.append(117);
      if (paramInt1 > 255)
      {
        paramInt2 = paramInt1 >> 8;
        paramByteArrayBuilder.append(HEX_BYTES[(paramInt2 >> 4)]);
        paramByteArrayBuilder.append(HEX_BYTES[(paramInt2 & 0xF)]);
        paramInt1 &= 0xFF;
      }
      else
      {
        paramByteArrayBuilder.append(48);
        paramByteArrayBuilder.append(48);
      }
      paramByteArrayBuilder.append(HEX_BYTES[(paramInt1 >> 4)]);
      paramByteArrayBuilder.append(HEX_BYTES[(paramInt1 & 0xF)]);
    }
    else
    {
      paramByteArrayBuilder.append((byte)paramInt2);
    }
    return paramByteArrayBuilder.getCurrentSegmentLength();
  }
  
  private int _appendNamedEscape(int paramInt, char[] paramArrayOfChar)
  {
    paramArrayOfChar[1] = ((char)paramInt);
    return 2;
  }
  
  private int _appendNumericEscape(int paramInt, char[] paramArrayOfChar)
  {
    paramArrayOfChar[1] = 'u';
    char[] arrayOfChar = HEX_CHARS;
    paramArrayOfChar[4] = arrayOfChar[(paramInt >> 4)];
    paramArrayOfChar[5] = arrayOfChar[(paramInt & 0xF)];
    return 6;
  }
  
  private int _convertSurrogate(int paramInt1, int paramInt2)
  {
    if ((paramInt2 >= 56320) && (paramInt2 <= 57343)) {
      return paramInt2 - 56320 + ((paramInt1 - 55296 << 10) + 65536);
    }
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Broken surrogate pair: first char 0x");
    localStringBuilder.append(Integer.toHexString(paramInt1));
    localStringBuilder.append(", second 0x");
    localStringBuilder.append(Integer.toHexString(paramInt2));
    localStringBuilder.append("; illegal combination");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private void _throwIllegalSurrogate(int paramInt)
  {
    if (paramInt <= 1114111)
    {
      if (paramInt >= 55296)
      {
        if (paramInt <= 56319)
        {
          localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unmatched first part of surrogate pair (0x");
          localStringBuilder.append(Integer.toHexString(paramInt));
          localStringBuilder.append(")");
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
        localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Unmatched second part of surrogate pair (0x");
        localStringBuilder.append(Integer.toHexString(paramInt));
        localStringBuilder.append(")");
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Illegal character point (0x");
      localStringBuilder.append(Integer.toHexString(paramInt));
      localStringBuilder.append(") to output");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Illegal character point (0x");
    localStringBuilder.append(Integer.toHexString(paramInt));
    localStringBuilder.append(") to output; max is 0x10FFFF as per RFC 4627");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static JsonStringEncoder getInstance()
  {
    Object localObject1 = (SoftReference)_threadEncoder.get();
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (JsonStringEncoder)((SoftReference)localObject1).get();
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new JsonStringEncoder();
      _threadEncoder.set(new SoftReference(localObject2));
    }
    return localObject2;
  }
  
  public byte[] encodeAsUTF8(String paramString)
  {
    Object localObject1 = _byteBuilder;
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new ByteArrayBuilder(null, 500);
      _byteBuilder = ((ByteArrayBuilder)localObject2);
    }
    int i4 = paramString.length();
    localObject1 = ((ByteArrayBuilder)localObject2).resetAndGetFirstSegment();
    int i = localObject1.length;
    int k = 0;
    int j = 0;
    int m;
    for (;;)
    {
      m = j;
      if (k >= i4) {
        break;
      }
      int n = k + 1;
      m = paramString.charAt(k);
      k = n;
      for (n = i; m <= 127; n = i)
      {
        i = n;
        i1 = j;
        if (j >= n)
        {
          localObject1 = ((ByteArrayBuilder)localObject2).finishCurrentSegment();
          i = localObject1.length;
          i1 = 0;
        }
        j = i1 + 1;
        localObject1[i1] = ((byte)m);
        if (k >= i4)
        {
          m = j;
          break label601;
        }
        m = paramString.charAt(k);
        k += 1;
      }
      i = n;
      int i1 = j;
      byte[] arrayOfByte;
      if (j >= n)
      {
        arrayOfByte = ((ByteArrayBuilder)localObject2).finishCurrentSegment();
        localObject1 = arrayOfByte;
        i = arrayOfByte.length;
        i1 = 0;
      }
      if (m < 2048)
      {
        localObject1[i1] = ((byte)(m >> 6 | 0xC0));
        j = i1 + 1;
        i1 = m;
      }
      else
      {
        int i2;
        if ((m >= 55296) && (m <= 57343))
        {
          if (m <= 56319)
          {
            if (k < i4)
            {
              i2 = _convertSurrogate(m, paramString.charAt(k));
              m = i2;
              if (i2 <= 1114111)
              {
                int i3 = i1 + 1;
                localObject1[i1] = ((byte)(i2 >> 18 | 0xF0));
                j = i;
                n = i3;
                if (i3 >= i)
                {
                  arrayOfByte = ((ByteArrayBuilder)localObject2).finishCurrentSegment();
                  localObject1 = arrayOfByte;
                  j = arrayOfByte.length;
                  n = 0;
                }
                i1 = n + 1;
                localObject1[n] = ((byte)(i2 >> 12 & 0x3F | 0x80));
                i = j;
                n = i1;
                if (i1 >= j)
                {
                  localObject1 = ((ByteArrayBuilder)localObject2).finishCurrentSegment();
                  i = localObject1.length;
                  n = 0;
                }
                localObject1[n] = ((byte)(i2 >> 6 & 0x3F | 0x80));
                j = n + 1;
                k += 1;
                i1 = m;
              }
              else
              {
                _throwIllegalSurrogate(i2);
                throw new NullPointerException("Null throw statement replaced by Soot");
              }
            }
            else
            {
              _throwIllegalSurrogate(m);
              throw new NullPointerException("Null throw statement replaced by Soot");
            }
          }
          else
          {
            _throwIllegalSurrogate(m);
            throw new NullPointerException("Null throw statement replaced by Soot");
          }
        }
        else
        {
          i2 = i1 + 1;
          localObject1[i1] = ((byte)(m >> 12 | 0xE0));
          n = i;
          j = i2;
          if (i2 >= i)
          {
            localObject1 = ((ByteArrayBuilder)localObject2).finishCurrentSegment();
            n = localObject1.length;
            j = 0;
          }
          i = j + 1;
          localObject1[j] = ((byte)(m >> 6 & 0x3F | 0x80));
          j = i;
          i1 = m;
          i = n;
        }
      }
      m = i;
      n = j;
      if (j >= i)
      {
        localObject1 = ((ByteArrayBuilder)localObject2).finishCurrentSegment();
        m = localObject1.length;
        n = 0;
      }
      localObject1[n] = ((byte)(i1 & 0x3F | 0x80));
      j = n + 1;
      i = m;
    }
    label601:
    return _byteBuilder.completeAndCoalesce(m);
  }
  
  public char[] quoteAsString(String paramString)
  {
    Object localObject1 = _textBuffer;
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new TextBuffer(null);
      _textBuffer = ((TextBuffer)localObject2);
    }
    localObject1 = ((TextBuffer)localObject2).emptyAndGetCurrentSegment();
    int[] arrayOfInt = Utf8StreamParser.sOutputEscapes128;
    int i1 = arrayOfInt.length;
    int i2 = paramString.length();
    int k = 0;
    int j = 0;
    int m = j;
    if (k < i2) {
      for (;;)
      {
        int i = paramString.charAt(k);
        if ((i < i1) && (arrayOfInt[i] != 0))
        {
          m = paramString.charAt(k);
          int n = arrayOfInt[m];
          if (n < 0)
          {
            _appendNumericEscape(m, _quoteBuffer);
            m = 6;
          }
          else
          {
            _appendNamedEscape(n, _quoteBuffer);
            m = 2;
          }
          n = j + m;
          if (n > localObject1.length)
          {
            n = localObject1.length - j;
            if (n > 0) {
              System.arraycopy(_quoteBuffer, 0, localObject1, j, n);
            }
            localObject3 = ((TextBuffer)localObject2).finishCurrentSegment();
            localObject1 = localObject3;
            j = m - n;
            System.arraycopy(_quoteBuffer, n, localObject3, 0, j);
          }
          else
          {
            System.arraycopy(_quoteBuffer, 0, localObject1, j, m);
            j = n;
          }
          k += 1;
          break;
        }
        Object localObject3 = localObject1;
        m = j;
        if (j >= localObject1.length)
        {
          localObject3 = ((TextBuffer)localObject2).finishCurrentSegment();
          m = 0;
        }
        j = m + 1;
        localObject3[m] = i;
        k += 1;
        if (k >= i2)
        {
          m = j;
          break label299;
        }
        localObject1 = localObject3;
      }
    }
    label299:
    ((TextBuffer)localObject2).setCurrentLength(m);
    return ((TextBuffer)localObject2).contentsAsArray();
  }
  
  public byte[] quoteAsUTF8(String paramString)
  {
    Object localObject1 = _byteBuilder;
    Object localObject3 = localObject1;
    if (localObject1 == null)
    {
      localObject3 = new ByteArrayBuilder(null, 500);
      _byteBuilder = ((ByteArrayBuilder)localObject3);
    }
    int n = paramString.length();
    Object localObject2 = ((ByteArrayBuilder)localObject3).resetAndGetFirstSegment();
    int j = 0;
    int i = 0;
    int k = i;
    if (j < n)
    {
      int[] arrayOfInt = Utf8StreamParser.sOutputEscapes128;
      k = j;
      for (;;)
      {
        m = paramString.charAt(k);
        if ((m > 127) || (arrayOfInt[m] != 0)) {
          break;
        }
        localObject1 = localObject2;
        j = i;
        if (i >= localObject2.length)
        {
          localObject1 = ((ByteArrayBuilder)localObject3).finishCurrentSegment();
          j = 0;
        }
        i = j + 1;
        localObject1[j] = ((byte)m);
        k += 1;
        if (k >= n)
        {
          k = i;
          break label626;
        }
        localObject2 = localObject1;
      }
      localObject1 = localObject2;
      int m = i;
      if (i >= localObject2.length)
      {
        localObject1 = ((ByteArrayBuilder)localObject3).finishCurrentSegment();
        m = 0;
      }
      j = k + 1;
      int i1 = paramString.charAt(k);
      if (i1 <= 127)
      {
        i = _appendByteEscape(i1, arrayOfInt[i1], (ByteArrayBuilder)localObject3, m);
        localObject2 = ((ByteArrayBuilder)localObject3).getCurrentSegment();
      }
      for (;;)
      {
        break;
        if (i1 <= 2047)
        {
          localObject1[m] = ((byte)(i1 >> 6 | 0xC0));
          k = i1 & 0x3F | 0x80;
          i = m + 1;
        }
        else if ((i1 >= 55296) && (i1 <= 57343))
        {
          if (i1 <= 56319)
          {
            if (j < n)
            {
              i1 = _convertSurrogate(i1, paramString.charAt(j));
              if (i1 <= 1114111)
              {
                k = m + 1;
                localObject1[m] = ((byte)(i1 >> 18 | 0xF0));
                localObject2 = localObject1;
                i = k;
                if (k >= localObject1.length)
                {
                  localObject2 = ((ByteArrayBuilder)localObject3).finishCurrentSegment();
                  i = 0;
                }
                k = i + 1;
                localObject2[i] = ((byte)(i1 >> 12 & 0x3F | 0x80));
                localObject1 = localObject2;
                i = k;
                if (k >= localObject2.length)
                {
                  localObject1 = ((ByteArrayBuilder)localObject3).finishCurrentSegment();
                  i = 0;
                }
                m = i + 1;
                localObject1[i] = ((byte)(i1 >> 6 & 0x3F | 0x80));
                k = i1 & 0x3F | 0x80;
                j += 1;
                i = m;
              }
              else
              {
                _throwIllegalSurrogate(i1);
                throw new NullPointerException("Null throw statement replaced by Soot");
              }
            }
            else
            {
              _throwIllegalSurrogate(i1);
              throw new NullPointerException("Null throw statement replaced by Soot");
            }
          }
          else
          {
            _throwIllegalSurrogate(i1);
            throw new NullPointerException("Null throw statement replaced by Soot");
          }
        }
        else
        {
          k = m + 1;
          localObject1[m] = ((byte)(i1 >> 12 | 0xE0));
          localObject2 = localObject1;
          i = k;
          if (k >= localObject1.length)
          {
            localObject2 = ((ByteArrayBuilder)localObject3).finishCurrentSegment();
            i = 0;
          }
          k = i + 1;
          localObject2[i] = ((byte)(i1 >> 6 & 0x3F | 0x80));
          m = i1 & 0x3F | 0x80;
          i = k;
          k = m;
          localObject1 = localObject2;
        }
        localObject2 = localObject1;
        m = i;
        if (i >= localObject1.length)
        {
          localObject2 = ((ByteArrayBuilder)localObject3).finishCurrentSegment();
          m = 0;
        }
        localObject2[m] = ((byte)k);
        i = m + 1;
      }
    }
    label626:
    return _byteBuilder.completeAndCoalesce(k);
  }
}
