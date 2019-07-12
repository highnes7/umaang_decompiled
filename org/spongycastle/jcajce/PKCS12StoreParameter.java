package org.spongycastle.jcajce;

import java.io.OutputStream;
import java.security.KeyStore.LoadStoreParameter;
import java.security.KeyStore.ProtectionParameter;

public class PKCS12StoreParameter
  implements KeyStore.LoadStoreParameter
{
  public final boolean forDEREncoding;
  public final OutputStream out;
  public final KeyStore.ProtectionParameter protectionParameter;
  
  public PKCS12StoreParameter(OutputStream paramOutputStream, KeyStore.ProtectionParameter paramProtectionParameter)
  {
    out = paramOutputStream;
    protectionParameter = paramProtectionParameter;
    forDEREncoding = false;
  }
  
  public PKCS12StoreParameter(OutputStream paramOutputStream, KeyStore.ProtectionParameter paramProtectionParameter, boolean paramBoolean)
  {
    out = paramOutputStream;
    protectionParameter = paramProtectionParameter;
    forDEREncoding = paramBoolean;
  }
  
  public PKCS12StoreParameter(OutputStream paramOutputStream, char[] paramArrayOfChar)
  {
    this(paramOutputStream, paramArrayOfChar, false);
  }
  
  public PKCS12StoreParameter(OutputStream paramOutputStream, char[] paramArrayOfChar, boolean paramBoolean)
  {
    out = paramOutputStream;
    protectionParameter = paramArrayOfChar;
    forDEREncoding = paramBoolean;
  }
  
  public OutputStream getOutputStream()
  {
    return out;
  }
  
  public KeyStore.ProtectionParameter getProtectionParameter()
  {
    return protectionParameter;
  }
  
  public boolean isForDEREncoding()
  {
    return forDEREncoding;
  }
}
