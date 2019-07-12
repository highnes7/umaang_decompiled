package f.fasterxml.jackson.core.format;

import f.fasterxml.jackson.core.JsonFactory;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public abstract interface InputAccessor
{
  public abstract boolean hasMoreBytes()
    throws IOException;
  
  public abstract byte nextByte()
    throws IOException;
  
  public abstract void reset();
  
  public class Std
    implements InputAccessor
  {
    public int _bufferedEnd;
    public final int _bufferedStart;
    public final InputStream _in;
    public int _ptr;
    
    public Std(byte[] paramArrayOfByte)
    {
      _in = InputAccessor.this;
      _bufferedStart = 0;
      _ptr = 0;
      _bufferedEnd = 0;
    }
    
    public Std()
    {
      _in = null;
      _bufferedStart = 0;
      _bufferedEnd = InputAccessor.this.length;
    }
    
    public Std(int paramInt1, int paramInt2)
    {
      _in = null;
      _ptr = paramInt1;
      _bufferedStart = paramInt1;
      _bufferedEnd = (paramInt1 + paramInt2);
    }
    
    public DataFormatMatcher createMatcher(JsonFactory paramJsonFactory, MatchStrength paramMatchStrength)
    {
      InputStream localInputStream = _in;
      byte[] arrayOfByte = InputAccessor.this;
      int i = _bufferedStart;
      return new DataFormatMatcher(localInputStream, arrayOfByte, i, _bufferedEnd - i, paramJsonFactory, paramMatchStrength);
    }
    
    public boolean hasMoreBytes()
      throws IOException
    {
      int i = _ptr;
      if (i < _bufferedEnd) {
        return true;
      }
      InputStream localInputStream = _in;
      if (localInputStream == null) {
        return false;
      }
      byte[] arrayOfByte = InputAccessor.this;
      int j = arrayOfByte.length - i;
      if (j < 1) {
        return false;
      }
      i = localInputStream.read(arrayOfByte, i, j);
      if (i <= 0) {
        return false;
      }
      _bufferedEnd += i;
      return true;
    }
    
    public byte nextByte()
      throws IOException
    {
      if ((_ptr >= _bufferedEnd) && (!hasMoreBytes()))
      {
        localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.append("Failed auto-detect: could not read more than ");
        ((StringBuilder)localObject).append(_ptr);
        ((StringBuilder)localObject).append(" bytes (max buffer size: ");
        throw new EOFException(f.sufficientlysecure.rootcommands.util.StringBuilder.append((StringBuilder)localObject, InputAccessor.this.length, ")"));
      }
      Object localObject = InputAccessor.this;
      int i = _ptr;
      _ptr = (i + 1);
      return localObject[i];
    }
    
    public void reset()
    {
      _ptr = _bufferedStart;
    }
  }
}
