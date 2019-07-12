package org.spongycastle.jcajce;

import org.spongycastle.crypto.CharToByteConverter;
import org.spongycastle.util.Arrays;

public class PBKDF2Key
  implements PBKDFKey
{
  public final CharToByteConverter converter;
  public final char[] password;
  
  public PBKDF2Key(char[] paramArrayOfChar, CharToByteConverter paramCharToByteConverter)
  {
    password = Arrays.clone(paramArrayOfChar);
    converter = paramCharToByteConverter;
  }
  
  public String getAlgorithm()
  {
    return "PBKDF2";
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
