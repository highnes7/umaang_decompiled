package org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.spongycastle.util.Arrays;

public class ASN1ObjectIdentifier
  extends ASN1Primitive
{
  public static final long LONG_LIMIT = 72057594037927808L;
  public static final ConcurrentMap<ASN1ObjectIdentifier.OidHandle, ASN1ObjectIdentifier> pool = new ConcurrentHashMap();
  public byte[] body;
  public final String identifier;
  
  public ASN1ObjectIdentifier(String paramString)
  {
    if (paramString != null)
    {
      if (isValidIdentifier(paramString))
      {
        identifier = paramString;
        return;
      }
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.append("string ", paramString, " not an OID"));
    }
    throw new IllegalArgumentException("'identifier' cannot be null");
  }
  
  public ASN1ObjectIdentifier(ASN1ObjectIdentifier paramASN1ObjectIdentifier, String paramString)
  {
    if (isValidBranchID(paramString, 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramASN1ObjectIdentifier.getId());
      localStringBuilder.append(".");
      localStringBuilder.append(paramString);
      identifier = localStringBuilder.toString();
      return;
    }
    throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.append("string ", paramString, " not a valid OID branch"));
  }
  
  public ASN1ObjectIdentifier(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    long l1 = 0L;
    int k = 0;
    Object localObject1 = null;
    int i = 1;
    while (k != paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[k] & 0xFF;
      if (l1 <= 72057594037927808L)
      {
        l1 += (j & 0x7F);
        if ((j & 0x80) == 0)
        {
          long l2 = l1;
          j = i;
          if (i != 0)
          {
            if (l1 < 40L)
            {
              localStringBuffer.append('0');
            }
            else if (l1 < 80L)
            {
              localStringBuffer.append('1');
              l1 -= 40L;
            }
            else
            {
              localStringBuffer.append('2');
              l1 -= 80L;
            }
            j = 0;
            l2 = l1;
          }
          localStringBuffer.append('.');
          localStringBuffer.append(l2);
          l1 = 0L;
          i = j;
        }
        else
        {
          l1 <<= 7;
        }
      }
      else
      {
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = BigInteger.valueOf(l1);
        }
        localObject2 = ((BigInteger)localObject2).or(BigInteger.valueOf(j & 0x7F));
        localObject1 = localObject2;
        if ((j & 0x80) == 0)
        {
          j = i;
          if (i != 0)
          {
            localStringBuffer.append('2');
            localObject1 = ((BigInteger)localObject2).subtract(BigInteger.valueOf(80L));
            j = 0;
          }
          localStringBuffer.append('.');
          localStringBuffer.append(localObject1);
          l1 = 0L;
          localObject1 = null;
          i = j;
        }
        else
        {
          localObject1 = ((BigInteger)localObject2).shiftLeft(7);
        }
      }
      k += 1;
    }
    identifier = localStringBuffer.toString();
    body = Arrays.clone(paramArrayOfByte);
  }
  
  private void doOutput(ByteArrayOutputStream paramByteArrayOutputStream)
  {
    OIDTokenizer localOIDTokenizer = new OIDTokenizer(identifier);
    int i = Integer.parseInt(localOIDTokenizer.nextToken()) * 40;
    String str = localOIDTokenizer.nextToken();
    if (str.length() <= 18)
    {
      long l = i;
      writeField(paramByteArrayOutputStream, Long.parseLong(str) + l);
    }
    else
    {
      writeField(paramByteArrayOutputStream, new BigInteger(str).add(BigInteger.valueOf(i)));
    }
    while (localOIDTokenizer.hasMoreTokens())
    {
      str = localOIDTokenizer.nextToken();
      if (str.length() <= 18) {
        writeField(paramByteArrayOutputStream, Long.parseLong(str));
      } else {
        writeField(paramByteArrayOutputStream, new BigInteger(str));
      }
    }
  }
  
  public static ASN1ObjectIdentifier fromOctetString(byte[] paramArrayOfByte)
  {
    Object localObject = new ASN1ObjectIdentifier.OidHandle(paramArrayOfByte);
    ASN1ObjectIdentifier localASN1ObjectIdentifier = (ASN1ObjectIdentifier)pool.get(localObject);
    localObject = localASN1ObjectIdentifier;
    if (localASN1ObjectIdentifier == null) {
      localObject = new ASN1ObjectIdentifier(paramArrayOfByte);
    }
    return localObject;
  }
  
  private byte[] getBody()
  {
    try
    {
      if (body == null)
      {
        localObject = new ByteArrayOutputStream();
        doOutput((ByteArrayOutputStream)localObject);
        body = ((ByteArrayOutputStream)localObject).toByteArray();
      }
      Object localObject = body;
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  public static ASN1ObjectIdentifier getInstance(Object paramObject)
  {
    if ((paramObject != null) && (!(paramObject instanceof ASN1ObjectIdentifier)))
    {
      if ((paramObject instanceof ASN1Encodable))
      {
        ASN1Encodable localASN1Encodable = (ASN1Encodable)paramObject;
        if ((localASN1Encodable.toASN1Primitive() instanceof ASN1ObjectIdentifier)) {
          return (ASN1ObjectIdentifier)localASN1Encodable.toASN1Primitive();
        }
      }
      if ((paramObject instanceof byte[]))
      {
        paramObject = (byte[])paramObject;
        try
        {
          paramObject = ASN1Primitive.fromByteArray(paramObject);
          return (ASN1ObjectIdentifier)paramObject;
        }
        catch (IOException paramObject)
        {
          throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.get(paramObject, f.sufficientlysecure.rootcommands.util.StringBuilder.append("failed to construct object identifier from byte[]: ")));
        }
      }
      throw new IllegalArgumentException(f.sufficientlysecure.rootcommands.util.StringBuilder.toString(paramObject, f.sufficientlysecure.rootcommands.util.StringBuilder.append("illegal object in getInstance: ")));
    }
    return (ASN1ObjectIdentifier)paramObject;
  }
  
  public static ASN1ObjectIdentifier getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    ASN1Primitive localASN1Primitive = paramASN1TaggedObject.getObject();
    if ((!paramBoolean) && (!(localASN1Primitive instanceof ASN1ObjectIdentifier))) {
      return fromOctetString(ASN1OctetString.getInstance(paramASN1TaggedObject.getObject()).getOctets());
    }
    return getInstance(localASN1Primitive);
  }
  
  public static boolean isValidBranchID(String paramString, int paramInt)
  {
    int i = paramString.length();
    boolean bool;
    do
    {
      int j;
      for (bool = false;; bool = true)
      {
        i -= 1;
        if (i < paramInt) {
          break label54;
        }
        j = paramString.charAt(i);
        if ((48 > j) || (j > 57)) {
          break;
        }
      }
      if (j != 46) {
        break label57;
      }
    } while (bool);
    return false;
    label54:
    return bool;
    label57:
    return false;
  }
  
  public static boolean isValidIdentifier(String paramString)
  {
    if (paramString.length() >= 3)
    {
      if (paramString.charAt(1) != '.') {
        return false;
      }
      int i = paramString.charAt(0);
      if (i >= 48)
      {
        if (i > 50) {
          return false;
        }
        return isValidBranchID(paramString, 2);
      }
    }
    return false;
  }
  
  private void writeField(ByteArrayOutputStream paramByteArrayOutputStream, long paramLong)
  {
    byte[] arrayOfByte = new byte[9];
    int i = (byte)((int)paramLong & 0x7F);
    int j = 8;
    arrayOfByte[8] = i;
    while (paramLong >= 128L)
    {
      paramLong >>= 7;
      j -= 1;
      arrayOfByte[j] = ((byte)((int)paramLong & 0x7F | 0x80));
    }
    paramByteArrayOutputStream.write(arrayOfByte, j, 9 - j);
  }
  
  private void writeField(ByteArrayOutputStream paramByteArrayOutputStream, BigInteger paramBigInteger)
  {
    int i = (paramBigInteger.bitLength() + 6) / 7;
    if (i == 0)
    {
      paramByteArrayOutputStream.write(0);
      return;
    }
    byte[] arrayOfByte = new byte[i];
    int j = i - 1;
    i = j;
    while (i >= 0)
    {
      arrayOfByte[i] = ((byte)(paramBigInteger.intValue() & 0x7F | 0x80));
      paramBigInteger = paramBigInteger.shiftRight(7);
      i -= 1;
    }
    arrayOfByte[j] = ((byte)(arrayOfByte[j] & 0x7F));
    paramByteArrayOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
  }
  
  public boolean asn1Equals(ASN1Primitive paramASN1Primitive)
  {
    if (paramASN1Primitive == this) {
      return true;
    }
    if (!(paramASN1Primitive instanceof ASN1ObjectIdentifier)) {
      return false;
    }
    return identifier.equals(identifier);
  }
  
  public ASN1ObjectIdentifier branch(String paramString)
  {
    return new ASN1ObjectIdentifier(this, paramString);
  }
  
  public void encode(ASN1OutputStream paramASN1OutputStream)
    throws IOException
  {
    byte[] arrayOfByte = getBody();
    paramASN1OutputStream.write(6);
    paramASN1OutputStream.writeLength(arrayOfByte.length);
    paramASN1OutputStream.write(arrayOfByte);
  }
  
  public int encodedLength()
    throws IOException
  {
    int i = getBody().length;
    return StreamUtil.calculateBodyLength(i) + 1 + i;
  }
  
  public String getId()
  {
    return identifier;
  }
  
  public int hashCode()
  {
    return identifier.hashCode();
  }
  
  public ASN1ObjectIdentifier intern()
  {
    ASN1ObjectIdentifier.OidHandle localOidHandle = new ASN1ObjectIdentifier.OidHandle(getBody());
    ASN1ObjectIdentifier localASN1ObjectIdentifier2 = (ASN1ObjectIdentifier)pool.get(localOidHandle);
    ASN1ObjectIdentifier localASN1ObjectIdentifier1 = localASN1ObjectIdentifier2;
    if (localASN1ObjectIdentifier2 == null)
    {
      localASN1ObjectIdentifier2 = (ASN1ObjectIdentifier)pool.putIfAbsent(localOidHandle, this);
      localASN1ObjectIdentifier1 = localASN1ObjectIdentifier2;
      if (localASN1ObjectIdentifier2 == null) {
        return this;
      }
    }
    return localASN1ObjectIdentifier1;
  }
  
  public boolean isConstructed()
  {
    return false;
  }
  
  public boolean on(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    String str = getId();
    paramASN1ObjectIdentifier = paramASN1ObjectIdentifier.getId();
    return (str.length() > paramASN1ObjectIdentifier.length()) && (str.charAt(paramASN1ObjectIdentifier.length()) == '.') && (str.startsWith(paramASN1ObjectIdentifier));
  }
  
  public String toString()
  {
    return getId();
  }
}
