package f.g.org.org.codehaus.jackson.objectweb.asm.signature.signature;

import f.g.org.org.codehaus.jackson.objectweb.asm.signature.Base64.DecoderException;
import f.g.org.org.codehaus.jackson.objectweb.asm.signature.Base64.EncoderException;
import f.g.org.org.codehaus.jackson.objectweb.asm.signature.BinaryDecoder;
import f.g.org.org.codehaus.jackson.objectweb.asm.signature.BinaryEncoder;

public abstract class BaseNCodec
  implements BinaryEncoder, BinaryDecoder
{
  public static final int DEFAULT_BUFFER_RESIZE_FACTOR = 2;
  public static final int DEFAULT_BUFFER_SIZE = 8192;
  public static final int MASK_8BITS = 255;
  public static final int MIME_CHUNK_SIZE = 76;
  public static final int PEM_CHUNK_SIZE = 64;
  public static final byte pad = 61;
  public final byte PAD = 61;
  public byte[] buffer;
  public final int chunkSeparatorLength;
  public int currentLinePos;
  public final int encodedBlockSize;
  public boolean eof;
  public final int lineLength;
  public int modulus;
  public int pos;
  public int readPos;
  public final int unencodedBlockSize;
  
  public BaseNCodec(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    unencodedBlockSize = paramInt1;
    encodedBlockSize = paramInt2;
    if ((paramInt3 > 0) && (paramInt4 > 0)) {
      paramInt1 = paramInt3 / paramInt2 * paramInt2;
    } else {
      paramInt1 = 0;
    }
    lineLength = paramInt1;
    chunkSeparatorLength = paramInt4;
  }
  
  public static boolean isWhiteSpace(byte paramByte)
  {
    return (paramByte == 9) || (paramByte == 10) || (paramByte == 13) || (paramByte == 32);
  }
  
  private void reset()
  {
    buffer = null;
    pos = 0;
    readPos = 0;
    currentLinePos = 0;
    modulus = 0;
    eof = false;
  }
  
  private void resizeBuffer()
  {
    byte[] arrayOfByte1 = buffer;
    if (arrayOfByte1 == null)
    {
      buffer = new byte[getDefaultBufferSize()];
      pos = 0;
      readPos = 0;
      return;
    }
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length * 2];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    buffer = arrayOfByte2;
  }
  
  public int available()
  {
    if (buffer != null) {
      return pos - readPos;
    }
    return 0;
  }
  
  public boolean containsAlphabetOrPad(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return false;
    }
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      byte b = paramArrayOfByte[i];
      if ((61 != b) && (!isInAlphabet(b))) {
        i += 1;
      } else {
        return true;
      }
    }
    return false;
  }
  
  public Object decode(Object paramObject)
    throws Base64.DecoderException
  {
    if ((paramObject instanceof byte[])) {
      return decode((byte[])paramObject);
    }
    if ((paramObject instanceof String)) {
      return decode((String)paramObject);
    }
    throw new Base64.DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
  }
  
  public abstract void decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public byte[] decode(String paramString)
  {
    return decode(StringUtils.getBytesUtf8(paramString));
  }
  
  public byte[] decode(byte[] paramArrayOfByte)
  {
    reset();
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return paramArrayOfByte;
      }
      decode(paramArrayOfByte, 0, paramArrayOfByte.length);
      decode(paramArrayOfByte, 0, -1);
      arrayOfByte = new byte[pos];
      readResults(arrayOfByte, 0, arrayOfByte.length);
    }
    return arrayOfByte;
  }
  
  public Object encode(Object paramObject)
    throws Base64.EncoderException
  {
    if ((paramObject instanceof byte[])) {
      return encode((byte[])paramObject);
    }
    throw new Base64.EncoderException("Parameter supplied to Base-N encode is not a byte[]");
  }
  
  public abstract void encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public byte[] encode(byte[] paramArrayOfByte)
  {
    reset();
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return paramArrayOfByte;
      }
      encode(paramArrayOfByte, 0, paramArrayOfByte.length);
      encode(paramArrayOfByte, 0, -1);
      arrayOfByte = new byte[pos - readPos];
      readResults(arrayOfByte, 0, arrayOfByte.length);
    }
    return arrayOfByte;
  }
  
  public String encodeAsString(byte[] paramArrayOfByte)
  {
    return StringUtils.newStringUtf8(encode(paramArrayOfByte));
  }
  
  public String encodeToString(byte[] paramArrayOfByte)
  {
    return StringUtils.newStringUtf8(encode(paramArrayOfByte));
  }
  
  public void ensureBufferSize(int paramInt)
  {
    byte[] arrayOfByte = buffer;
    if ((arrayOfByte == null) || (arrayOfByte.length < pos + paramInt)) {
      resizeBuffer();
    }
  }
  
  public int getDefaultBufferSize()
  {
    return 8192;
  }
  
  public long getEncodedLength(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    int j = unencodedBlockSize;
    long l2 = (i + j - 1) / j * encodedBlockSize;
    i = lineLength;
    long l1 = l2;
    if (i > 0) {
      l1 = l2 + (i + l2 - 1L) / i * chunkSeparatorLength;
    }
    return l1;
  }
  
  public boolean hasData()
  {
    return buffer != null;
  }
  
  public abstract boolean isInAlphabet(byte paramByte);
  
  public boolean isInAlphabet(String paramString)
  {
    return isInAlphabet(StringUtils.getBytesUtf8(paramString), true);
  }
  
  public boolean isInAlphabet(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      if (!isInAlphabet(paramArrayOfByte[i]))
      {
        if (!paramBoolean) {
          break label50;
        }
        if ((paramArrayOfByte[i] != 61) && (!isWhiteSpace(paramArrayOfByte[i]))) {
          return false;
        }
      }
      i += 1;
    }
    return true;
    label50:
    return false;
  }
  
  public int readResults(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (buffer != null)
    {
      paramInt2 = Math.min(available(), paramInt2);
      System.arraycopy(buffer, readPos, paramArrayOfByte, paramInt1, paramInt2);
      readPos += paramInt2;
      if (readPos >= pos)
      {
        buffer = null;
        return paramInt2;
      }
    }
    else
    {
      if (eof) {
        return -1;
      }
      return 0;
    }
    return paramInt2;
  }
}
