package f.fasterxml.jackson.core.impl;

import f.d.a.a.c.l;
import f.fasterxml.jackson.core.SerializableString;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;

public class SerializedString
  implements SerializableString, Serializable
{
  public transient String _jdkSerializeValue;
  public char[] _quotedChars;
  public byte[] _quotedUTF8Ref;
  public byte[] _unquotedUTF8Ref;
  public final String _value;
  
  public SerializedString(String paramString)
  {
    if (paramString != null)
    {
      _value = paramString;
      return;
    }
    throw new IllegalStateException("Null String illegal for SerializedString");
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException
  {
    _jdkSerializeValue = paramObjectInputStream.readUTF();
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.writeUTF(_value);
  }
  
  public int appendQuoted(char[] paramArrayOfChar, int paramInt)
  {
    char[] arrayOfChar2 = _quotedChars;
    char[] arrayOfChar1 = arrayOfChar2;
    if (arrayOfChar2 == null)
    {
      arrayOfChar2 = JsonStringEncoder.getInstance().quoteAsString(_value);
      arrayOfChar1 = arrayOfChar2;
      _quotedChars = arrayOfChar2;
    }
    int i = arrayOfChar1.length;
    if (paramInt + i > paramArrayOfChar.length) {
      return -1;
    }
    System.arraycopy(arrayOfChar1, 0, paramArrayOfChar, paramInt, i);
    return i;
  }
  
  public int appendQuotedUTF8(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte2 = _quotedUTF8Ref;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null)
    {
      arrayOfByte2 = JsonStringEncoder.getInstance().quoteAsUTF8(_value);
      arrayOfByte1 = arrayOfByte2;
      _quotedUTF8Ref = arrayOfByte2;
    }
    int i = arrayOfByte1.length;
    if (paramInt + i > paramArrayOfByte.length) {
      return -1;
    }
    System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, paramInt, i);
    return i;
  }
  
  public int appendUnquoted(char[] paramArrayOfChar, int paramInt)
  {
    String str = _value;
    int i = str.length();
    if (paramInt + i > paramArrayOfChar.length) {
      return -1;
    }
    str.getChars(0, i, paramArrayOfChar, paramInt);
    return i;
  }
  
  public int appendUnquotedUTF8(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte2 = _unquotedUTF8Ref;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null)
    {
      arrayOfByte2 = JsonStringEncoder.getInstance().encodeAsUTF8(_value);
      arrayOfByte1 = arrayOfByte2;
      _unquotedUTF8Ref = arrayOfByte2;
    }
    int i = arrayOfByte1.length;
    if (paramInt + i > paramArrayOfByte.length) {
      return -1;
    }
    System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, paramInt, i);
    return i;
  }
  
  public final char[] asQuotedChars()
  {
    char[] arrayOfChar2 = _quotedChars;
    char[] arrayOfChar1 = arrayOfChar2;
    if (arrayOfChar2 == null)
    {
      arrayOfChar1 = JsonStringEncoder.getInstance().quoteAsString(_value);
      _quotedChars = arrayOfChar1;
    }
    return arrayOfChar1;
  }
  
  public final byte[] asQuotedUTF8()
  {
    byte[] arrayOfByte2 = _quotedUTF8Ref;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = JsonStringEncoder.getInstance().quoteAsUTF8(_value);
      _quotedUTF8Ref = arrayOfByte1;
    }
    return arrayOfByte1;
  }
  
  public final byte[] asUnquotedUTF8()
  {
    byte[] arrayOfByte2 = _unquotedUTF8Ref;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null)
    {
      arrayOfByte1 = JsonStringEncoder.getInstance().encodeAsUTF8(_value);
      _unquotedUTF8Ref = arrayOfByte1;
    }
    return arrayOfByte1;
  }
  
  public final int charLength()
  {
    return _value.length();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject != null) && (paramObject.getClass() == l.class))
    {
      paramObject = (SerializedString)paramObject;
      return _value.equals(_value);
    }
    return false;
  }
  
  public final String getValue()
  {
    return _value;
  }
  
  public final int hashCode()
  {
    return _value.hashCode();
  }
  
  public int putQuotedUTF8(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte2 = _quotedUTF8Ref;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null)
    {
      arrayOfByte2 = JsonStringEncoder.getInstance().quoteAsUTF8(_value);
      arrayOfByte1 = arrayOfByte2;
      _quotedUTF8Ref = arrayOfByte2;
    }
    int i = arrayOfByte1.length;
    if (i > paramByteBuffer.remaining()) {
      return -1;
    }
    paramByteBuffer.put(arrayOfByte1, 0, i);
    return i;
  }
  
  public int putUnquotedUTF8(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte2 = _unquotedUTF8Ref;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null)
    {
      arrayOfByte2 = JsonStringEncoder.getInstance().encodeAsUTF8(_value);
      arrayOfByte1 = arrayOfByte2;
      _unquotedUTF8Ref = arrayOfByte2;
    }
    int i = arrayOfByte1.length;
    if (i > paramByteBuffer.remaining()) {
      return -1;
    }
    paramByteBuffer.put(arrayOfByte1, 0, i);
    return i;
  }
  
  public Object readResolve()
  {
    return new SerializedString(_jdkSerializeValue);
  }
  
  public final String toString()
  {
    return _value;
  }
  
  public int writeQuotedUTF8(OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte2 = _quotedUTF8Ref;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null)
    {
      arrayOfByte2 = JsonStringEncoder.getInstance().quoteAsUTF8(_value);
      arrayOfByte1 = arrayOfByte2;
      _quotedUTF8Ref = arrayOfByte2;
    }
    int i = arrayOfByte1.length;
    paramOutputStream.write(arrayOfByte1, 0, i);
    return i;
  }
  
  public int writeUnquotedUTF8(OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte2 = _unquotedUTF8Ref;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2 == null)
    {
      arrayOfByte2 = JsonStringEncoder.getInstance().encodeAsUTF8(_value);
      arrayOfByte1 = arrayOfByte2;
      _unquotedUTF8Ref = arrayOfByte2;
    }
    int i = arrayOfByte1.length;
    paramOutputStream.write(arrayOfByte1, 0, i);
    return i;
  }
}
