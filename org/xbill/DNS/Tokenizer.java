package org.xbill.DNS;

import f.sufficientlysecure.rootcommands.util.StringBuilder;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.xbill.DNS.utils.base16;
import org.xbill.DNS.utils.base32;
import org.xbill.DNS.utils.base64;

public class Tokenizer
{
  public static final int COMMENT = 5;
  public static final int EOF = 0;
  public static final int EOL = 1;
  public static final int IDENTIFIER = 3;
  public static final int QUOTED_STRING = 4;
  public static final int WHITESPACE = 2;
  public static String delim;
  public static String quotes;
  public Tokenizer.Token current;
  public String delimiters;
  public String filename;
  public PushbackInputStream is;
  public int line;
  public int multiline;
  public boolean quoting;
  public StringBuffer sb;
  public boolean ungottenToken;
  public boolean wantClose;
  
  public Tokenizer(File paramFile)
    throws FileNotFoundException
  {
    this(new FileInputStream(paramFile));
    wantClose = true;
    filename = paramFile.getName();
  }
  
  public Tokenizer(InputStream paramInputStream)
  {
    Object localObject = paramInputStream;
    if (!(paramInputStream instanceof BufferedInputStream)) {
      localObject = new BufferedInputStream((InputStream)paramInputStream);
    }
    is = new PushbackInputStream((InputStream)localObject, 2);
    ungottenToken = false;
    multiline = 0;
    quoting = false;
    delimiters = delim;
    current = new Tokenizer.Token();
    sb = new StringBuffer();
    filename = "<none>";
    line = 1;
  }
  
  public Tokenizer(String paramString)
  {
    this(new ByteArrayInputStream(paramString.getBytes()));
  }
  
  private String _getIdentifier(String paramString)
    throws IOException
  {
    Tokenizer.Token localToken = get();
    if (type == 3) {
      return value;
    }
    throw StringBuilder.get("expected ", paramString, this);
  }
  
  private void checkUnbalancedParens()
    throws TextParseException
  {
    if (multiline <= 0) {
      return;
    }
    throw exception("unbalanced parentheses");
  }
  
  private int getChar()
    throws IOException
  {
    int j = is.read();
    int i = j;
    if (j == 13)
    {
      i = is.read();
      if (i != 10) {
        is.unread(i);
      }
      i = 10;
    }
    if (i == 10) {
      line += 1;
    }
    return i;
  }
  
  private String remainingStrings()
    throws IOException
  {
    Object localObject2;
    for (Object localObject1 = null;; localObject1 = localObject2)
    {
      Tokenizer.Token localToken = get();
      if (!localToken.isString())
      {
        unget();
        if (localObject1 == null) {
          return null;
        }
        return localObject1.toString();
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new StringBuffer();
      }
      ((StringBuffer)localObject2).append(value);
    }
  }
  
  private int skipWhitespace()
    throws IOException
  {
    int i = 0;
    for (;;)
    {
      int j = getChar();
      if ((j != 32) && (j != 9) && ((j != 10) || (multiline <= 0)))
      {
        ungetChar(j);
        return i;
      }
      i += 1;
    }
  }
  
  private void ungetChar(int paramInt)
    throws IOException
  {
    if (paramInt == -1) {
      return;
    }
    is.unread(paramInt);
    if (paramInt == 10) {
      line -= 1;
    }
  }
  
  public void close()
  {
    if (wantClose)
    {
      PushbackInputStream localPushbackInputStream = is;
      try
      {
        localPushbackInputStream.close();
        return;
      }
      catch (IOException localIOException) {}
    }
  }
  
  public TextParseException exception(String paramString)
  {
    return (TextParseException)new Tokenizer.TokenizerException(filename, line, paramString);
  }
  
  public void finalize()
  {
    close();
  }
  
  public Tokenizer.Token get()
    throws IOException
  {
    return get(false, false);
  }
  
  public Tokenizer.Token get(boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    if (ungottenToken)
    {
      ungottenToken = false;
      localToken = current;
      i = type;
      if (i == 2)
      {
        if (paramBoolean1) {
          return localToken;
        }
      }
      else if (i == 5)
      {
        if (paramBoolean2) {
          return localToken;
        }
      }
      else
      {
        if (i == 1) {
          line += 1;
        }
        return current;
      }
    }
    if ((skipWhitespace() > 0) && (paramBoolean1))
    {
      localToken = current;
      Tokenizer.Token.access$100(localToken, 2, null);
      return localToken;
    }
    int i = 3;
    sb.setLength(0);
    int m;
    for (;;)
    {
      m = getChar();
      int j = m;
      if ((m != -1) && (delimiters.indexOf(m) == -1))
      {
        int k;
        if (m == 92)
        {
          j = getChar();
          k = j;
          if (j != -1) {
            sb.append('\\');
          } else {
            throw exception("unterminated escape sequence");
          }
        }
        else
        {
          k = j;
          if (quoting) {
            if (m != 10) {
              k = j;
            } else {
              throw exception("newline in quoted string");
            }
          }
        }
        sb.append((char)k);
      }
      else
      {
        if (m == -1)
        {
          if (!quoting)
          {
            if (sb.length() == 0)
            {
              localToken = current;
              Tokenizer.Token.access$100(localToken, 0, null);
              return localToken;
            }
            localToken = current;
            Tokenizer.Token.access$100(localToken, i, sb);
            return localToken;
          }
          throw exception("EOF in quoted string");
        }
        if ((sb.length() != 0) || (i == 4)) {
          break label603;
        }
        if (m == 40)
        {
          multiline += 1;
          skipWhitespace();
        }
        else if (m == 41)
        {
          j = multiline;
          if (j > 0)
          {
            multiline = (j - 1);
            skipWhitespace();
          }
          else
          {
            throw exception("invalid close parenthesis");
          }
        }
        else if (m == 34)
        {
          if (!quoting)
          {
            quoting = true;
            delimiters = quotes;
            i = 4;
          }
          else
          {
            quoting = false;
            delimiters = delim;
            skipWhitespace();
          }
        }
        else
        {
          if (m == 10)
          {
            localToken = current;
            Tokenizer.Token.access$100(localToken, 1, null);
            return localToken;
          }
          if (m != 59) {
            break label595;
          }
          for (;;)
          {
            j = getChar();
            if ((j == 10) || (j == -1)) {
              break;
            }
            sb.append((char)j);
          }
          if (paramBoolean2)
          {
            ungetChar(j);
            localToken = current;
            Tokenizer.Token.access$100(localToken, 5, sb);
            return localToken;
          }
          if ((j == -1) && (i != 4))
          {
            checkUnbalancedParens();
            localToken = current;
            Tokenizer.Token.access$100(localToken, 0, null);
            return localToken;
          }
          if (multiline <= 0) {
            break;
          }
          skipWhitespace();
          sb.setLength(0);
        }
      }
    }
    Tokenizer.Token localToken = current;
    Tokenizer.Token.access$100(localToken, 1, null);
    return localToken;
    label595:
    throw new IllegalStateException();
    label603:
    ungetChar(m);
    if ((sb.length() == 0) && (i != 4))
    {
      checkUnbalancedParens();
      localToken = current;
      Tokenizer.Token.access$100(localToken, 0, null);
      return localToken;
    }
    localToken = current;
    Tokenizer.Token.access$100(localToken, i, sb);
    return localToken;
  }
  
  public InetAddress getAddress(int paramInt)
    throws IOException
  {
    Object localObject = _getIdentifier("an address");
    try
    {
      localObject = Address.getByAddress((String)localObject, paramInt);
      return localObject;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      throw exception(localUnknownHostException.getMessage());
    }
  }
  
  public byte[] getBase32String(base32 paramBase32)
    throws IOException
  {
    paramBase32 = paramBase32.fromString(_getIdentifier("a base32 string"));
    if (paramBase32 != null) {
      return paramBase32;
    }
    throw exception("invalid base32 encoding");
  }
  
  public byte[] getBase64()
    throws IOException
  {
    return getBase64(false);
  }
  
  public byte[] getBase64(boolean paramBoolean)
    throws IOException
  {
    Object localObject = remainingStrings();
    if (localObject == null)
    {
      if (!paramBoolean) {
        return null;
      }
      throw exception("expected base64 encoded string");
    }
    localObject = base64.fromString((String)localObject);
    if (localObject != null) {
      return localObject;
    }
    throw exception("invalid base64 encoding");
  }
  
  public void getEOL()
    throws IOException
  {
    int i = gettype;
    if (i != 1)
    {
      if (i == 0) {
        return;
      }
      throw exception("expected EOL or EOF");
    }
  }
  
  public byte[] getHex()
    throws IOException
  {
    return getHex(false);
  }
  
  public byte[] getHex(boolean paramBoolean)
    throws IOException
  {
    Object localObject = remainingStrings();
    if (localObject == null)
    {
      if (!paramBoolean) {
        return null;
      }
      throw exception("expected hex encoded string");
    }
    localObject = base16.fromString((String)localObject);
    if (localObject != null) {
      return localObject;
    }
    throw exception("invalid hex encoding");
  }
  
  public byte[] getHexString()
    throws IOException
  {
    byte[] arrayOfByte = base16.fromString(_getIdentifier("a hex string"));
    if (arrayOfByte != null) {
      return arrayOfByte;
    }
    throw exception("invalid hex encoding");
  }
  
  public String getIdentifier()
    throws IOException
  {
    return _getIdentifier("an identifier");
  }
  
  public long getLong()
    throws IOException
  {
    String str = _getIdentifier("an integer");
    if (Character.isDigit(str.charAt(0))) {}
    try
    {
      long l = Long.parseLong(str);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;) {}
    }
    throw exception("expected an integer");
    throw exception("expected an integer");
  }
  
  public Name getName(Name paramName)
    throws IOException
  {
    String str = _getIdentifier("a name");
    try
    {
      paramName = Name.fromString(str, paramName);
      boolean bool = paramName.isAbsolute();
      if (bool) {
        return paramName;
      }
      paramName = new RelativeNameException(paramName);
      paramName = (Throwable)paramName;
      throw paramName;
    }
    catch (TextParseException paramName)
    {
      throw exception(paramName.getMessage());
    }
  }
  
  public String getString()
    throws IOException
  {
    Tokenizer.Token localToken = get();
    if (localToken.isString()) {
      return value;
    }
    throw exception("expected a string");
  }
  
  public long getTTL()
    throws IOException
  {
    String str = _getIdentifier("a TTL value");
    try
    {
      long l = TTL.parseTTL(str);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;) {}
    }
    throw exception("expected a TTL value");
  }
  
  public long getTTLLike()
    throws IOException
  {
    String str = _getIdentifier("a TTL-like value");
    try
    {
      long l = TTL.parse(str, false);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;) {}
    }
    throw exception("expected a TTL-like value");
  }
  
  public int getUInt16()
    throws IOException
  {
    long l = getLong();
    if ((l >= 0L) && (l <= 65535L)) {
      return (int)l;
    }
    throw exception("expected an 16 bit unsigned integer");
  }
  
  public long getUInt32()
    throws IOException
  {
    long l = getLong();
    if ((l >= 0L) && (l <= 4294967295L)) {
      return l;
    }
    throw exception("expected an 32 bit unsigned integer");
  }
  
  public int getUInt8()
    throws IOException
  {
    long l = getLong();
    if ((l >= 0L) && (l <= 255L)) {
      return (int)l;
    }
    throw exception("expected an 8 bit unsigned integer");
  }
  
  public void unget()
  {
    if (!ungottenToken)
    {
      if (current.type == 1) {
        line -= 1;
      }
      ungottenToken = true;
      return;
    }
    throw new IllegalStateException("Cannot unget multiple tokens");
  }
}
