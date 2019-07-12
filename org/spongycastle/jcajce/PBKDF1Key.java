package org.spongycastle.jcajce;

import org.spongycastle.crypto.CharToByteConverter;

public class PBKDF1Key
  implements PBKDFKey
{
  public final CharToByteConverter converter;
  public final char[] password;
  
  public PBKDF1Key(char[] paramArrayOfChar, CharToByteConverter paramCharToByteConverter)
  {
    password = new char[paramArrayOfChar.length];
    converter = paramCharToByteConverter;
    System.arraycopy(paramArrayOfChar, 0, password, 0, paramArrayOfChar.length);
  }
  
  public String getAlgorithm()
  {
    return "PBKDF1";
  }
  
  public byte[] getEncoded()
  {
    return converter.convert(password);
  }
  
  public String getFormat()
  {
    return converter.getType();
  }
  
  public char[] getPassword()
  {
    return password;
  }
}
