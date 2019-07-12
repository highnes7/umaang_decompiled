package org.spongycastle.jcajce;

import org.spongycastle.crypto.PBEParametersGenerator;

public class PKCS12Key
  implements PBKDFKey
{
  public final char[] password;
  public final boolean useWrongZeroLengthConversion;
  
  public PKCS12Key(char[] paramArrayOfChar)
  {
    this(paramArrayOfChar, false);
  }
  
  public PKCS12Key(char[] paramArrayOfChar, boolean paramBoolean)
  {
    char[] arrayOfChar = paramArrayOfChar;
    if (paramArrayOfChar == null) {
      arrayOfChar = new char[0];
    }
    password = new char[arrayOfChar.length];
    useWrongZeroLengthConversion = paramBoolean;
    System.arraycopy(arrayOfChar, 0, password, 0, arrayOfChar.length);
  }
  
  public String getAlgorithm()
  {
    return "PKCS12";
  }
  
  public byte[] getEncoded()
  {
    if ((useWrongZeroLengthConversion) && (password.length == 0)) {
      return new byte[2];
    }
    return PBEParametersGenerator.PKCS12PasswordToBytes(password);
  }
  
  public String getFormat()
  {
    return "PKCS12";
  }
  
  public char[] getPassword()
  {
    return password;
  }
}
