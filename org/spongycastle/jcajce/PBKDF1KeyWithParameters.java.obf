package org.spongycastle.jcajce;

import javax.crypto.interfaces.PBEKey;
import org.spongycastle.crypto.CharToByteConverter;
import org.spongycastle.util.Arrays;

public class PBKDF1KeyWithParameters
  extends PBKDF1Key
  implements PBEKey
{
  public final int iterationCount;
  public final byte[] salt;
  
  public PBKDF1KeyWithParameters(char[] paramArrayOfChar, CharToByteConverter paramCharToByteConverter, byte[] paramArrayOfByte, int paramInt)
  {
    super(paramArrayOfChar, paramCharToByteConverter);
    salt = Arrays.clone(paramArrayOfByte);
    iterationCount = paramInt;
  }
  
  public int getIterationCount()
  {
    return iterationCount;
  }
  
  public byte[] getSalt()
  {
    return salt;
  }
}
