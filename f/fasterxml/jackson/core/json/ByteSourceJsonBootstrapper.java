package f.fasterxml.jackson.core.json;

import f.fasterxml.jackson.core.JsonEncoding;
import f.fasterxml.jackson.core.JsonParseException;
import f.fasterxml.jackson.core.JsonParser;
import f.fasterxml.jackson.core.ObjectCodec;
import f.fasterxml.jackson.core.format.InputAccessor;
import f.fasterxml.jackson.core.format.MatchStrength;
import f.fasterxml.jackson.core.impl.IOContext;
import f.fasterxml.jackson.core.sym.BytesToNameCanonicalizer;
import f.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public final class ByteSourceJsonBootstrapper
{
  public static final byte UTF8_BOM_1 = -17;
  public static final byte UTF8_BOM_2 = -69;
  public static final byte UTF8_BOM_3 = -65;
  public boolean _bigEndian = true;
  public final boolean _bufferRecyclable;
  public int _bytesPerChar = 0;
  public final IOContext _context;
  public final InputStream _in;
  public final byte[] _inputBuffer;
  public int _inputEnd;
  public int _inputProcessed;
  public int _inputPtr;
  
  public ByteSourceJsonBootstrapper(IOContext paramIOContext, InputStream paramInputStream)
  {
    _context = paramIOContext;
    _in = paramInputStream;
    _inputBuffer = paramIOContext.allocReadIOBuffer();
    _inputPtr = 0;
    _inputEnd = 0;
    _inputProcessed = 0;
    _bufferRecyclable = true;
  }
  
  public ByteSourceJsonBootstrapper(IOContext paramIOContext, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    _context = paramIOContext;
    _in = null;
    _inputBuffer = paramArrayOfByte;
    _inputPtr = paramInt1;
    _inputEnd = (paramInt2 + paramInt1);
    _inputProcessed = (-paramInt1);
    _bufferRecyclable = false;
  }
  
  private boolean checkUTF16(int paramInt)
  {
    if ((0xFF00 & paramInt) == 0)
    {
      _bigEndian = true;
    }
    else
    {
      if ((paramInt & 0xFF) != 0) {
        break label35;
      }
      _bigEndian = false;
    }
    _bytesPerChar = 2;
    return true;
    label35:
    return false;
  }
  
  private boolean checkUTF32(int paramInt)
    throws IOException
  {
    if (paramInt >> 8 == 0)
    {
      _bigEndian = true;
    }
    else
    {
      if ((0xFFFFFF & paramInt) != 0) {
        break label34;
      }
      _bigEndian = false;
    }
    _bytesPerChar = 4;
    return true;
    label34:
    if ((0xFF00FFFF & paramInt) != 0)
    {
      if ((paramInt & 0xFFFF00FF) != 0) {
        return false;
      }
      reportWeirdUCS4("2143");
      throw new NullPointerException("Null throw statement replaced by Soot");
    }
    reportWeirdUCS4("3412");
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  private boolean handleBOM(int paramInt)
    throws IOException
  {
    if (paramInt != -16842752)
    {
      if (paramInt != -131072)
      {
        if (paramInt != 65279)
        {
          if (paramInt != 65534)
          {
            int i = paramInt >>> 16;
            if (i == 65279)
            {
              _inputPtr += 2;
              _bytesPerChar = 2;
              _bigEndian = true;
              return true;
            }
            if (i == 65534)
            {
              _inputPtr += 2;
              _bytesPerChar = 2;
              _bigEndian = false;
              return true;
            }
            if (paramInt >>> 8 == 15711167)
            {
              _inputPtr += 3;
              _bytesPerChar = 1;
              _bigEndian = true;
              return true;
            }
            return false;
          }
          reportWeirdUCS4("2143");
          throw new NullPointerException("Null throw statement replaced by Soot");
        }
        _bigEndian = true;
        _inputPtr += 4;
        _bytesPerChar = 4;
        return true;
      }
      _inputPtr += 4;
      _bytesPerChar = 4;
      _bigEndian = false;
      return true;
    }
    reportWeirdUCS4("3412");
    throw new NullPointerException("Null throw statement replaced by Soot");
  }
  
  public static MatchStrength hasJSONFormat(InputAccessor paramInputAccessor)
    throws IOException
  {
    if (!paramInputAccessor.hasMoreBytes()) {
      return MatchStrength.INCONCLUSIVE;
    }
    byte b2 = paramInputAccessor.nextByte();
    byte b1 = b2;
    if (b2 == -17)
    {
      if (!paramInputAccessor.hasMoreBytes()) {
        return MatchStrength.INCONCLUSIVE;
      }
      if (paramInputAccessor.nextByte() != -69) {
        return MatchStrength.NO_MATCH;
      }
      if (!paramInputAccessor.hasMoreBytes()) {
        return MatchStrength.INCONCLUSIVE;
      }
      if (paramInputAccessor.nextByte() != -65) {
        return MatchStrength.NO_MATCH;
      }
      if (!paramInputAccessor.hasMoreBytes()) {
        return MatchStrength.INCONCLUSIVE;
      }
      b1 = paramInputAccessor.nextByte();
    }
    int i = skipSpace(paramInputAccessor, b1);
    if (i < 0) {
      return MatchStrength.INCONCLUSIVE;
    }
    if (i == 123)
    {
      i = skipSpace(paramInputAccessor);
      if (i < 0) {
        return MatchStrength.INCONCLUSIVE;
      }
      if ((i != 34) && (i != 125)) {
        return MatchStrength.NO_MATCH;
      }
      return MatchStrength.SOLID_MATCH;
    }
    if (i == 91)
    {
      i = skipSpace(paramInputAccessor);
      if (i < 0) {
        return MatchStrength.INCONCLUSIVE;
      }
      if ((i != 93) && (i != 91)) {
        return MatchStrength.SOLID_MATCH;
      }
      return MatchStrength.SOLID_MATCH;
    }
    MatchStrength localMatchStrength = MatchStrength.WEAK_MATCH;
    if (i == 34) {
      return localMatchStrength;
    }
    if ((i <= 57) && (i >= 48)) {
      return localMatchStrength;
    }
    if (i == 45)
    {
      i = skipSpace(paramInputAccessor);
      if (i < 0) {
        return MatchStrength.INCONCLUSIVE;
      }
      if ((i <= 57) && (i >= 48)) {
        return localMatchStrength;
      }
      return MatchStrength.NO_MATCH;
    }
    if (i == 110) {
      return tryMatch(paramInputAccessor, "ull", localMatchStrength);
    }
    if (i == 116) {
      return tryMatch(paramInputAccessor, "rue", localMatchStrength);
    }
    if (i == 102) {
      return tryMatch(paramInputAccessor, "alse", localMatchStrength);
    }
    return MatchStrength.NO_MATCH;
  }
  
  private void reportWeirdUCS4(String paramString)
    throws IOException
  {
    throw new CharConversionException(StringBuilder.append("Unsupported UCS-4 endianness (", paramString, ") detected"));
  }
  
  public static int skipSpace(InputAccessor paramInputAccessor)
    throws IOException
  {
    if (!paramInputAccessor.hasMoreBytes()) {
      return -1;
    }
    return skipSpace(paramInputAccessor, paramInputAccessor.nextByte());
  }
  
  public static int skipSpace(InputAccessor paramInputAccessor, byte paramByte)
    throws IOException
  {
    for (;;)
    {
      paramByte &= 0xFF;
      if ((paramByte != 32) && (paramByte != 13) && (paramByte != 10) && (paramByte != 9)) {
        return paramByte;
      }
      if (!paramInputAccessor.hasMoreBytes()) {
        return -1;
      }
      paramByte = paramInputAccessor.nextByte();
    }
  }
  
  public static MatchStrength tryMatch(InputAccessor paramInputAccessor, String paramString, MatchStrength paramMatchStrength)
    throws IOException
  {
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      if (!paramInputAccessor.hasMoreBytes()) {
        return MatchStrength.INCONCLUSIVE;
      }
      if (paramInputAccessor.nextByte() != paramString.charAt(i)) {
        return MatchStrength.NO_MATCH;
      }
      i += 1;
    }
    return paramMatchStrength;
  }
  
  public JsonParser constructParser(int paramInt, ObjectCodec paramObjectCodec, BytesToNameCanonicalizer paramBytesToNameCanonicalizer, CharsToNameCanonicalizer paramCharsToNameCanonicalizer, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException, JsonParseException
  {
    if ((detectEncoding() == JsonEncoding.UTF8) && (paramBoolean1))
    {
      paramBytesToNameCanonicalizer = paramBytesToNameCanonicalizer.makeChild(paramBoolean1, paramBoolean2);
      return new UTF8StreamJsonParser(_context, paramInt, _in, paramObjectCodec, paramBytesToNameCanonicalizer, _inputBuffer, _inputPtr, _inputEnd, _bufferRecyclable);
    }
    return new ReaderBasedJsonParser(_context, paramInt, constructReader(), paramObjectCodec, paramCharsToNameCanonicalizer.makeChild(paramBoolean1, paramBoolean2));
  }
  
  public Reader constructReader()
    throws IOException
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a6 = a5\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  public JsonEncoding detectEncoding()
    throws IOException, JsonParseException
  {
    boolean bool = ensureLoaded(4);
    int j = 0;
    Object localObject;
    int k;
    int m;
    if (bool)
    {
      localObject = _inputBuffer;
      i = _inputPtr;
      k = localObject[i];
      m = localObject[(i + 1)];
      int n = localObject[(i + 2)];
      k = localObject[(i + 3)] & 0xFF | k << 24 | (m & 0xFF) << 16 | (n & 0xFF) << 8;
      if ((!handleBOM(k)) && (!checkUTF32(k)))
      {
        i = j;
        if (!checkUTF16(k >>> 16)) {
          break label178;
        }
      }
    }
    else
    {
      i = j;
      if (!ensureLoaded(2)) {
        break label178;
      }
      localObject = _inputBuffer;
      k = _inputPtr;
      m = localObject[k];
      i = j;
      if (!checkUTF16(localObject[(k + 1)] & 0xFF | (m & 0xFF) << 8)) {
        break label178;
      }
    }
    int i = 1;
    label178:
    if (i == 0)
    {
      localObject = JsonEncoding.UTF8;
    }
    else
    {
      i = _bytesPerChar;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 4)
          {
            if (_bigEndian) {
              localObject = JsonEncoding.UTF32_BE;
            } else {
              localObject = JsonEncoding.UTF32_LE;
            }
          }
          else {
            throw new RuntimeException("Internal error");
          }
        }
        else if (_bigEndian) {
          localObject = JsonEncoding.UTF16_BE;
        } else {
          localObject = JsonEncoding.UTF16_LE;
        }
      }
      else {
        localObject = JsonEncoding.UTF8;
      }
    }
    _context.setEncoding((JsonEncoding)localObject);
    return localObject;
  }
  
  public boolean ensureLoaded(int paramInt)
    throws IOException
  {
    int i = _inputEnd - _inputPtr;
    while (i < paramInt)
    {
      InputStream localInputStream = _in;
      int j;
      if (localInputStream == null)
      {
        j = -1;
      }
      else
      {
        byte[] arrayOfByte = _inputBuffer;
        j = _inputEnd;
        j = localInputStream.read(arrayOfByte, j, arrayOfByte.length - j);
      }
      if (j < 1) {
        return false;
      }
      _inputEnd += j;
      i += j;
    }
    return true;
  }
}
