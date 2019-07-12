package f.fasterxml.jackson.core.util;

import f.fasterxml.jackson.core.impl.NumberInput;
import java.math.BigDecimal;
import java.util.ArrayList;

public final class TextBuffer
{
  public static final int MAX_SEGMENT_LEN = 262144;
  public static final int MIN_SEGMENT_LEN = 1000;
  public static final char[] NO_CHARS = new char[0];
  public final BufferRecycler _allocator;
  public char[] _currentSegment;
  public int _currentSize;
  public boolean _hasSegments = false;
  public char[] _inputBuffer;
  public int _inputLen;
  public int _inputStart;
  public char[] _resultArray;
  public String _resultString;
  public int _segmentSize;
  public ArrayList<char[]> _segments;
  
  public TextBuffer(BufferRecycler paramBufferRecycler)
  {
    _allocator = paramBufferRecycler;
  }
  
  private char[] buildResultArray()
  {
    Object localObject1 = _resultString;
    if (localObject1 != null) {
      return ((String)localObject1).toCharArray();
    }
    int i = _inputStart;
    int j;
    if (i >= 0)
    {
      j = _inputLen;
      if (j < 1) {
        return NO_CHARS;
      }
      localObject1 = new char[j];
      System.arraycopy(_inputBuffer, i, localObject1, 0, j);
      return localObject1;
    }
    i = size();
    if (i < 1) {
      return NO_CHARS;
    }
    localObject1 = new char[i];
    Object localObject2 = _segments;
    if (localObject2 != null)
    {
      int m = ((ArrayList)localObject2).size();
      j = 0;
      i = 0;
      for (;;)
      {
        k = i;
        if (j >= m) {
          break;
        }
        localObject2 = (char[])_segments.get(j);
        k = localObject2.length;
        System.arraycopy(localObject2, 0, localObject1, i, k);
        i += k;
        j += 1;
      }
    }
    int k = 0;
    System.arraycopy(_currentSegment, 0, localObject1, k, _currentSize);
    return localObject1;
  }
  
  private void clearSegments()
  {
    _hasSegments = false;
    _segments.clear();
    _segmentSize = 0;
    _currentSize = 0;
  }
  
  private char[] ensureCapacity(int paramInt)
  {
    return new char[paramInt];
  }
  
  private void expand(int paramInt)
  {
    if (_segments == null) {
      _segments = new ArrayList();
    }
    char[] arrayOfChar = _currentSegment;
    _hasSegments = true;
    _segments.add(arrayOfChar);
    _segmentSize += arrayOfChar.length;
    int j = arrayOfChar.length;
    int i = j >> 1;
    if (i >= paramInt) {
      paramInt = i;
    }
    arrayOfChar = new char[Math.min(262144, j + paramInt)];
    _currentSize = 0;
    _currentSegment = arrayOfChar;
  }
  
  private char[] findBuffer(int paramInt)
  {
    BufferRecycler localBufferRecycler = _allocator;
    if (localBufferRecycler != null) {
      return localBufferRecycler.allocCharBuffer(BufferRecycler.CharBufferType.TEXT_BUFFER, paramInt);
    }
    return new char[Math.max(paramInt, 1000)];
  }
  
  private void unshare(int paramInt)
  {
    int i = _inputLen;
    _inputLen = 0;
    char[] arrayOfChar1 = _inputBuffer;
    _inputBuffer = null;
    int j = _inputStart;
    _inputStart = -1;
    paramInt += i;
    char[] arrayOfChar2 = _currentSegment;
    if ((arrayOfChar2 == null) || (paramInt > arrayOfChar2.length)) {
      _currentSegment = findBuffer(paramInt);
    }
    if (i > 0) {
      System.arraycopy(arrayOfChar1, j, _currentSegment, 0, i);
    }
    _segmentSize = 0;
    _currentSize = i;
  }
  
  public void append(char paramChar)
  {
    if (_inputStart >= 0) {
      unshare(16);
    }
    _resultString = null;
    _resultArray = null;
    char[] arrayOfChar2 = _currentSegment;
    char[] arrayOfChar1 = arrayOfChar2;
    if (_currentSize >= arrayOfChar2.length)
    {
      expand(1);
      arrayOfChar1 = _currentSegment;
    }
    int i = _currentSize;
    _currentSize = (i + 1);
    arrayOfChar1[i] = paramChar;
  }
  
  public void append(String paramString, int paramInt1, int paramInt2)
  {
    if (_inputStart >= 0) {
      unshare(paramInt2);
    }
    _resultString = null;
    _resultArray = null;
    char[] arrayOfChar = _currentSegment;
    int i = arrayOfChar.length;
    int k = _currentSize;
    int m = i - k;
    if (m >= paramInt2)
    {
      paramString.getChars(paramInt1, paramInt1 + paramInt2, arrayOfChar, k);
      _currentSize += paramInt2;
      return;
    }
    i = paramInt1;
    int j = paramInt2;
    if (m > 0)
    {
      i = paramInt1 + m;
      paramString.getChars(paramInt1, i, arrayOfChar, k);
      j = paramInt2 - m;
    }
    for (;;)
    {
      expand(j);
      paramInt2 = Math.min(_currentSegment.length, j);
      paramInt1 = i + paramInt2;
      paramString.getChars(i, paramInt1, _currentSegment, 0);
      _currentSize += paramInt2;
      j -= paramInt2;
      if (j <= 0) {
        return;
      }
      i = paramInt1;
    }
  }
  
  public void append(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (_inputStart >= 0) {
      unshare(paramInt2);
    }
    _resultString = null;
    _resultArray = null;
    char[] arrayOfChar = _currentSegment;
    int i = arrayOfChar.length;
    int k = _currentSize;
    int m = i - k;
    if (m >= paramInt2)
    {
      System.arraycopy(paramArrayOfChar, paramInt1, arrayOfChar, k, paramInt2);
      _currentSize += paramInt2;
      return;
    }
    int j = paramInt1;
    i = paramInt2;
    if (m > 0)
    {
      System.arraycopy(paramArrayOfChar, paramInt1, arrayOfChar, k, m);
      j = paramInt1 + m;
      i = paramInt2 - m;
    }
    do
    {
      expand(i);
      paramInt1 = Math.min(_currentSegment.length, i);
      System.arraycopy(paramArrayOfChar, j, _currentSegment, 0, paramInt1);
      _currentSize += paramInt1;
      j += paramInt1;
      paramInt1 = i - paramInt1;
      i = paramInt1;
    } while (paramInt1 > 0);
  }
  
  public char[] contentsAsArray()
  {
    char[] arrayOfChar2 = _resultArray;
    char[] arrayOfChar1 = arrayOfChar2;
    if (arrayOfChar2 == null)
    {
      arrayOfChar1 = buildResultArray();
      _resultArray = arrayOfChar1;
    }
    return arrayOfChar1;
  }
  
  public BigDecimal contentsAsDecimal()
    throws NumberFormatException
  {
    char[] arrayOfChar = _resultArray;
    if (arrayOfChar != null) {
      return new BigDecimal(arrayOfChar);
    }
    int i = _inputStart;
    if (i >= 0) {
      return new BigDecimal(_inputBuffer, i, _inputLen);
    }
    if (_segmentSize == 0) {
      return new BigDecimal(_currentSegment, 0, _currentSize);
    }
    return new BigDecimal(contentsAsArray());
  }
  
  public double contentsAsDouble()
    throws NumberFormatException
  {
    return NumberInput.parseDouble(contentsAsString());
  }
  
  public String contentsAsString()
  {
    if (_resultString == null)
    {
      Object localObject1 = _resultArray;
      if (localObject1 != null)
      {
        _resultString = new String((char[])localObject1);
      }
      else
      {
        int i = _inputStart;
        localObject1 = "";
        int j;
        if (i >= 0)
        {
          j = _inputLen;
          if (j < 1)
          {
            _resultString = "";
            return "";
          }
          _resultString = new String(_inputBuffer, i, j);
        }
        else
        {
          i = _segmentSize;
          j = _currentSize;
          if (i == 0)
          {
            if (j != 0) {
              localObject1 = new String(_currentSegment, 0, j);
            }
            _resultString = ((String)localObject1);
          }
          else
          {
            localObject1 = new StringBuilder(i + j);
            Object localObject2 = _segments;
            if (localObject2 != null)
            {
              j = ((ArrayList)localObject2).size();
              i = 0;
              while (i < j)
              {
                localObject2 = (char[])_segments.get(i);
                ((StringBuilder)localObject1).append((char[])localObject2, 0, localObject2.length);
                i += 1;
              }
            }
            ((StringBuilder)localObject1).append(_currentSegment, 0, _currentSize);
            _resultString = ((StringBuilder)localObject1).toString();
          }
        }
      }
    }
    return _resultString;
  }
  
  public char[] emptyAndGetCurrentSegment()
  {
    _inputStart = -1;
    _currentSize = 0;
    _inputLen = 0;
    _inputBuffer = null;
    _resultString = null;
    _resultArray = null;
    if (_hasSegments) {
      clearSegments();
    }
    char[] arrayOfChar2 = _currentSegment;
    char[] arrayOfChar1 = arrayOfChar2;
    if (arrayOfChar2 == null)
    {
      arrayOfChar1 = findBuffer(0);
      _currentSegment = arrayOfChar1;
    }
    return arrayOfChar1;
  }
  
  public void ensureNotShared()
  {
    if (_inputStart >= 0) {
      unshare(16);
    }
  }
  
  public char[] expandCurrentSegment()
  {
    char[] arrayOfChar = _currentSegment;
    int j = arrayOfChar.length;
    int i;
    if (j == 262144) {
      i = 262145;
    } else {
      i = Math.min(262144, (j >> 1) + j);
    }
    _currentSegment = new char[i];
    System.arraycopy(arrayOfChar, 0, _currentSegment, 0, j);
    return _currentSegment;
  }
  
  public char[] finishCurrentSegment()
  {
    if (_segments == null) {
      _segments = new ArrayList();
    }
    _hasSegments = true;
    _segments.add(_currentSegment);
    int i = _currentSegment.length;
    _segmentSize += i;
    char[] arrayOfChar = new char[Math.min(i + (i >> 1), 262144)];
    _currentSize = 0;
    _currentSegment = arrayOfChar;
    return arrayOfChar;
  }
  
  public char[] getCurrentSegment()
  {
    if (_inputStart >= 0)
    {
      unshare(1);
    }
    else
    {
      char[] arrayOfChar = _currentSegment;
      if (arrayOfChar == null) {
        _currentSegment = findBuffer(0);
      } else if (_currentSize >= arrayOfChar.length) {
        expand(1);
      }
    }
    return _currentSegment;
  }
  
  public int getCurrentSegmentSize()
  {
    return _currentSize;
  }
  
  public char[] getTextBuffer()
  {
    if (_inputStart >= 0) {
      return _inputBuffer;
    }
    Object localObject = _resultArray;
    if (localObject != null) {
      return localObject;
    }
    localObject = _resultString;
    if (localObject != null)
    {
      localObject = ((String)localObject).toCharArray();
      _resultArray = ((char[])localObject);
      return localObject;
    }
    if (!_hasSegments) {
      return _currentSegment;
    }
    return contentsAsArray();
  }
  
  public int getTextOffset()
  {
    int i = _inputStart;
    if (i >= 0) {
      return i;
    }
    return 0;
  }
  
  public boolean hasTextAsCharacters()
  {
    if (_inputStart < 0)
    {
      if (_resultArray != null) {
        return true;
      }
      if (_resultString != null) {
        return false;
      }
    }
    return true;
  }
  
  public void releaseBuffers()
  {
    if (_allocator == null)
    {
      resetWithEmpty();
      return;
    }
    if (_currentSegment != null)
    {
      resetWithEmpty();
      char[] arrayOfChar = _currentSegment;
      _currentSegment = null;
      _allocator.releaseCharBuffer(BufferRecycler.CharBufferType.TEXT_BUFFER, arrayOfChar);
    }
  }
  
  public void resetWithCopy(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    _inputBuffer = null;
    _inputStart = -1;
    _inputLen = 0;
    _resultString = null;
    _resultArray = null;
    if (_hasSegments) {
      clearSegments();
    } else if (_currentSegment == null) {
      _currentSegment = findBuffer(paramInt2);
    }
    _segmentSize = 0;
    _currentSize = 0;
    append(paramArrayOfChar, paramInt1, paramInt2);
  }
  
  public void resetWithEmpty()
  {
    _inputStart = -1;
    _currentSize = 0;
    _inputLen = 0;
    _inputBuffer = null;
    _resultString = null;
    _resultArray = null;
    if (_hasSegments) {
      clearSegments();
    }
  }
  
  public void resetWithShared(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    _resultString = null;
    _resultArray = null;
    _inputBuffer = paramArrayOfChar;
    _inputStart = paramInt1;
    _inputLen = paramInt2;
    if (_hasSegments) {
      clearSegments();
    }
  }
  
  public void resetWithString(String paramString)
  {
    _inputBuffer = null;
    _inputStart = -1;
    _inputLen = 0;
    _resultString = paramString;
    _resultArray = null;
    if (_hasSegments) {
      clearSegments();
    }
    _currentSize = 0;
  }
  
  public void setCurrentLength(int paramInt)
  {
    _currentSize = paramInt;
  }
  
  public int size()
  {
    if (_inputStart >= 0) {
      return _inputLen;
    }
    Object localObject = _resultArray;
    if (localObject != null) {
      return localObject.length;
    }
    localObject = _resultString;
    if (localObject != null) {
      return ((String)localObject).length();
    }
    return _segmentSize + _currentSize;
  }
  
  public String toString()
  {
    return contentsAsString();
  }
}
