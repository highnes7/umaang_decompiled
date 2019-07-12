package f.g.c.http;

import f.g.c.a.a;
import f.g.c.hash.HashCode;
import f.g.c.hash.HashFunction;
import f.g.c.hash.Hashing;
import f.g.c.io.ByteArrayDataInput;
import f.g.c.io.ByteStreams;
import f.g.c.io.ByteStreams.ByteArrayDataInputStream;
import f.g.c.j.g;
import f.g.c.package_10.Objects;
import f.g.c.package_10.Preconditions;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;

@a
public final class InetAddresses
{
  public static final Inet4Address ANY4 = (Inet4Address)forString("0.0.0.0");
  public static final int IPV4_PART_COUNT = 4;
  public static final int IPV6_PART_COUNT = 8;
  public static final Inet4Address LOOPBACK4 = (Inet4Address)forString("127.0.0.1");
  
  public InetAddresses() {}
  
  public static InetAddress bytesToInetAddress(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = InetAddress.getByAddress(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (UnknownHostException paramArrayOfByte)
    {
      throw new AssertionError(paramArrayOfByte);
    }
  }
  
  public static int coerceToInteger(InetAddress paramInetAddress)
  {
    return new ByteStreams.ByteArrayDataInputStream(getCoercedIPv4Address(paramInetAddress).getAddress()).readInt();
  }
  
  public static void compressLongestRunOfZeroes(int[] paramArrayOfInt)
  {
    int i = 0;
    int k = -1;
    int m = -1;
    int i1;
    for (int j = -1; i < paramArrayOfInt.length + 1; j = i1)
    {
      int n;
      int i2;
      if ((i < paramArrayOfInt.length) && (paramArrayOfInt[i] == 0))
      {
        n = k;
        i2 = m;
        i1 = j;
        if (j < 0)
        {
          i1 = i;
          n = k;
          i2 = m;
        }
      }
      else
      {
        n = k;
        i2 = m;
        i1 = j;
        if (j >= 0)
        {
          i1 = i - j;
          n = k;
          if (i1 > k)
          {
            n = i1;
            m = j;
          }
          i1 = -1;
          i2 = m;
        }
      }
      i += 1;
      k = n;
      m = i2;
    }
    if (k >= 2) {
      Arrays.fill(paramArrayOfInt, m, k + m, -1);
    }
  }
  
  public static String convertDottedQuadToHex(String paramString)
  {
    int i = paramString.lastIndexOf(':') + 1;
    String str = paramString.substring(0, i);
    Object localObject = textToNumericFormatV4(paramString.substring(i));
    if (localObject == null) {
      return null;
    }
    paramString = Integer.toHexString((localObject[0] & 0xFF) << 8 | localObject[1] & 0xFF);
    i = localObject[2];
    localObject = Integer.toHexString(localObject[3] & 0xFF | (i & 0xFF) << 8);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(paramString);
    localStringBuilder.append(":");
    localStringBuilder.append((String)localObject);
    return localStringBuilder.toString();
  }
  
  public static byte[] copyOfRange(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt2 -= paramInt1;
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  public static InetAddress forString(String paramString)
  {
    byte[] arrayOfByte = ipStringToBytes(paramString);
    if (arrayOfByte != null) {
      return bytesToInetAddress(arrayOfByte);
    }
    throw new IllegalArgumentException(String.format("'%s' is not an IP string literal.", new Object[] { paramString }));
  }
  
  public static InetAddress forUriString(String paramString)
  {
    if (paramString != null)
    {
      int i;
      if ((paramString.startsWith("[")) && (paramString.endsWith("]")))
      {
        localObject = f.sufficientlysecure.rootcommands.util.StringBuilder.substring(paramString, 1, 1);
        i = 16;
      }
      else
      {
        i = 4;
        localObject = paramString;
      }
      Object localObject = ipStringToBytes((String)localObject);
      if ((localObject != null) && (localObject.length == i)) {
        return bytesToInetAddress((byte[])localObject);
      }
      throw new IllegalArgumentException(String.format("Not a valid URI IP literal: '%s'", new Object[] { paramString }));
    }
    throw new NullPointerException();
  }
  
  public static Inet4Address fromInteger(int paramInt)
  {
    return getInet4Address(g.b(paramInt));
  }
  
  public static InetAddress fromLittleEndianByteArray(byte[] paramArrayOfByte)
    throws UnknownHostException
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      arrayOfByte[i] = paramArrayOfByte[(paramArrayOfByte.length - i - 1)];
      i += 1;
    }
    return InetAddress.getByAddress(arrayOfByte);
  }
  
  public static Inet4Address get6to4IPv4Address(Inet6Address paramInet6Address)
  {
    Preconditions.checkArgument(is6to4Address(paramInet6Address), "Address '%s' is not a 6to4 address.", new Object[] { toAddrString(paramInet6Address) });
    return getInet4Address(copyOfRange(paramInet6Address.getAddress(), 2, 6));
  }
  
  public static Inet4Address getCoercedIPv4Address(InetAddress paramInetAddress)
  {
    if ((paramInetAddress instanceof Inet4Address)) {
      return (Inet4Address)paramInetAddress;
    }
    byte[] arrayOfByte = paramInetAddress.getAddress();
    int i = 0;
    while (i < 15)
    {
      if (arrayOfByte[i] != 0)
      {
        i = 0;
        break label47;
      }
      i += 1;
    }
    i = 1;
    label47:
    if ((i != 0) && (arrayOfByte[15] == 1)) {
      return LOOPBACK4;
    }
    if ((i != 0) && (arrayOfByte[15] == 0)) {
      return ANY4;
    }
    paramInetAddress = (Inet6Address)paramInetAddress;
    long l;
    if (hasEmbeddedIPv4ClientAddress(paramInetAddress)) {
      l = getEmbeddedIPv4ClientAddress(paramInetAddress).hashCode();
    } else {
      l = ByteBuffer.wrap(paramInetAddress.getAddress(), 0, 8).getLong();
    }
    int j = Hashing.MURMUR3_32.hashLong(l).asInt() | 0xE0000000;
    i = j;
    if (j == -1) {
      i = -2;
    }
    return getInet4Address(g.b(i));
  }
  
  public static Inet4Address getCompatIPv4Address(Inet6Address paramInet6Address)
  {
    Preconditions.checkArgument(isCompatIPv4Address(paramInet6Address), "Address '%s' is not IPv4-compatible.", new Object[] { toAddrString(paramInet6Address) });
    return getInet4Address(copyOfRange(paramInet6Address.getAddress(), 12, 16));
  }
  
  public static Inet4Address getEmbeddedIPv4ClientAddress(Inet6Address paramInet6Address)
  {
    if (isCompatIPv4Address(paramInet6Address)) {
      return getCompatIPv4Address(paramInet6Address);
    }
    if (is6to4Address(paramInet6Address)) {
      return get6to4IPv4Address(paramInet6Address);
    }
    if (isTeredoAddress(paramInet6Address)) {
      return getTeredoInfo(paramInet6Address).getClient();
    }
    throw new IllegalArgumentException(String.format("'%s' has no embedded IPv4 address.", new Object[] { toAddrString(paramInet6Address) }));
  }
  
  public static Inet4Address getInet4Address(byte[] paramArrayOfByte)
  {
    boolean bool;
    if (paramArrayOfByte.length == 4) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "Byte array has invalid length for an IPv4 address: %s != 4.", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
    return (Inet4Address)bytesToInetAddress(paramArrayOfByte);
  }
  
  public static Inet4Address getIsatapIPv4Address(Inet6Address paramInet6Address)
  {
    Preconditions.checkArgument(isIsatapAddress(paramInet6Address), "Address '%s' is not an ISATAP address.", new Object[] { toAddrString(paramInet6Address) });
    return getInet4Address(copyOfRange(paramInet6Address.getAddress(), 12, 16));
  }
  
  public static TeredoInfo getTeredoInfo(Inet6Address paramInet6Address)
  {
    boolean bool = isTeredoAddress(paramInet6Address);
    Object localObject = toAddrString(paramInet6Address);
    int i = 0;
    Preconditions.checkArgument(bool, "Address '%s' is not a Teredo address.", new Object[] { localObject });
    localObject = paramInet6Address.getAddress();
    paramInet6Address = getInet4Address(copyOfRange((byte[])localObject, 4, 8));
    int j = ByteStreams.newDataInput((byte[])localObject, 8).readShort();
    Preconditions.checkPositionIndex(10, localObject.length, "index");
    int k = new ByteStreams.ByteArrayDataInputStream((byte[])localObject, 10).readShort();
    localObject = copyOfRange((byte[])localObject, 12, 16);
    while (i < localObject.length)
    {
      localObject[i] = ((byte)localObject[i]);
      i += 1;
    }
    return new TeredoInfo(getInet4Address((byte[])localObject), 0xFFFF & k, j & 0xFFFF);
  }
  
  public static boolean hasEmbeddedIPv4ClientAddress(Inet6Address paramInet6Address)
  {
    return (isCompatIPv4Address(paramInet6Address)) || (is6to4Address(paramInet6Address)) || (isTeredoAddress(paramInet6Address));
  }
  
  public static String hextetsToIPv6String(int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(39);
    int j = 0;
    int i;
    for (int k = 0; j < paramArrayOfInt.length; k = i)
    {
      if (paramArrayOfInt[j] >= 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (k != 0) {
          localStringBuilder.append(':');
        }
        localStringBuilder.append(Integer.toHexString(paramArrayOfInt[j]));
      }
      else if ((j == 0) || (k != 0))
      {
        localStringBuilder.append("::");
      }
      j += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static InetAddress increment(InetAddress paramInetAddress)
  {
    byte[] arrayOfByte = paramInetAddress.getAddress();
    int i = arrayOfByte.length - 1;
    while ((i >= 0) && (arrayOfByte[i] == -1))
    {
      arrayOfByte[i] = 0;
      i -= 1;
    }
    boolean bool;
    if (i >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "Incrementing %s would wrap.", new Object[] { paramInetAddress });
    arrayOfByte[i] = ((byte)(arrayOfByte[i] + 1));
    return bytesToInetAddress(arrayOfByte);
  }
  
  public static byte[] ipStringToBytes(String paramString)
  {
    int i = 0;
    int k = 0;
    int j = 0;
    while (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (c == '.')
      {
        j = 1;
      }
      else if (c == ':')
      {
        if (j != 0) {
          return null;
        }
        k = 1;
      }
      else if (Character.digit(c, 16) == -1)
      {
        return null;
      }
      i += 1;
    }
    if (k != 0)
    {
      String str = paramString;
      if (j != 0)
      {
        paramString = convertDottedQuadToHex(paramString);
        str = paramString;
        if (paramString == null) {
          return null;
        }
      }
      return textToNumericFormatV6(str);
    }
    if (j != 0) {
      return textToNumericFormatV4(paramString);
    }
    return null;
  }
  
  public static boolean is6to4Address(Inet6Address paramInet6Address)
  {
    paramInet6Address = paramInet6Address.getAddress();
    return (paramInet6Address[0] == 32) && (paramInet6Address[1] == 2);
  }
  
  public static boolean isCompatIPv4Address(Inet6Address paramInet6Address)
  {
    if (!paramInet6Address.isIPv4CompatibleAddress()) {
      return false;
    }
    paramInet6Address = paramInet6Address.getAddress();
    if ((paramInet6Address[12] == 0) && (paramInet6Address[13] == 0) && (paramInet6Address[14] == 0))
    {
      if (paramInet6Address[15] != 0)
      {
        if (paramInet6Address[15] != 1) {
          break label56;
        }
        return false;
      }
    }
    else {
      return true;
    }
    return false;
    label56:
    return true;
  }
  
  public static boolean isInetAddress(String paramString)
  {
    return ipStringToBytes(paramString) != null;
  }
  
  public static boolean isIsatapAddress(Inet6Address paramInet6Address)
  {
    if (isTeredoAddress(paramInet6Address)) {
      return false;
    }
    paramInet6Address = paramInet6Address.getAddress();
    if ((paramInet6Address[8] | 0x3) != 3) {
      return false;
    }
    return (paramInet6Address[9] == 0) && (paramInet6Address[10] == 94) && (paramInet6Address[11] == -2);
  }
  
  public static boolean isMappedIPv4Address(String paramString)
  {
    paramString = ipStringToBytes(paramString);
    if ((paramString != null) && (paramString.length == 16))
    {
      int i = 0;
      int j;
      for (;;)
      {
        j = 10;
        if (i >= 10) {
          break;
        }
        if (paramString[i] != 0) {
          return false;
        }
        i += 1;
      }
      while (j < 12)
      {
        if (paramString[j] != -1) {
          return false;
        }
        j += 1;
      }
      return true;
    }
    return false;
  }
  
  public static boolean isMaximum(InetAddress paramInetAddress)
  {
    paramInetAddress = paramInetAddress.getAddress();
    int i = 0;
    while (i < paramInetAddress.length)
    {
      if (paramInetAddress[i] != -1) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean isTeredoAddress(Inet6Address paramInet6Address)
  {
    paramInet6Address = paramInet6Address.getAddress();
    return (paramInet6Address[0] == 32) && (paramInet6Address[1] == 1) && (paramInet6Address[2] == 0) && (paramInet6Address[3] == 0);
  }
  
  public static boolean isUriInetAddress(String paramString)
  {
    try
    {
      forUriString(paramString);
      return true;
    }
    catch (IllegalArgumentException paramString)
    {
      for (;;) {}
    }
    return false;
  }
  
  public static short parseHextet(String paramString)
  {
    int i = Integer.parseInt(paramString, 16);
    if (i <= 65535) {
      return (short)i;
    }
    throw new NumberFormatException();
  }
  
  public static byte parseOctet(String paramString)
  {
    int i = Integer.parseInt(paramString);
    if ((i <= 255) && ((!paramString.startsWith("0")) || (paramString.length() <= 1))) {
      return (byte)i;
    }
    throw new NumberFormatException();
  }
  
  public static byte[] textToNumericFormatV4(String paramString)
  {
    paramString = paramString.split("\\.", 5);
    if (paramString.length != 4) {
      return null;
    }
    byte[] arrayOfByte = new byte[4];
    int j = 0;
    for (;;)
    {
      String str;
      if (j < arrayOfByte.length) {
        str = paramString[j];
      }
      try
      {
        int i = parseOctet(str);
        arrayOfByte[j] = i;
        j += 1;
      }
      catch (NumberFormatException paramString) {}
    }
    return arrayOfByte;
    return null;
  }
  
  public static byte[] textToNumericFormatV6(String paramString)
  {
    paramString = paramString.split(":", 10);
    int i;
    int j;
    int k;
    int n;
    int m;
    ByteBuffer localByteBuffer;
    if (paramString.length >= 3)
    {
      if (paramString.length > 9) {
        return null;
      }
      i = 1;
      for (j = -1; i < paramString.length - 1; j = k)
      {
        k = j;
        if (paramString[i].length() == 0)
        {
          if (j >= 0) {
            return null;
          }
          k = i;
        }
        i += 1;
      }
      if (j >= 0)
      {
        n = paramString.length - j - 1;
        if (paramString[0].length() == 0)
        {
          i = j - 1;
          k = i;
          if (i != 0) {
            return null;
          }
        }
        else
        {
          k = j;
        }
        i = n;
        m = k;
        if (paramString[(paramString.length - 1)].length() == 0)
        {
          n -= 1;
          i = n;
          m = k;
          if (n != 0) {
            return null;
          }
        }
      }
      else
      {
        m = paramString.length;
        i = 0;
      }
      n = 8 - (m + i);
      if (j >= 0) {
        if (n < 1) {
          break label272;
        }
      } else if (n != 0) {
        return null;
      }
      localByteBuffer = ByteBuffer.allocate(16);
      j = 0;
    }
    else
    {
      for (;;)
      {
        String str;
        if (j < m) {
          str = paramString[j];
        }
        try
        {
          localByteBuffer.putShort(parseHextet(str));
          j += 1;
        }
        catch (NumberFormatException paramString) {}
      }
      j = 0;
      for (;;)
      {
        k = i;
        if (j >= n) {
          break;
        }
        localByteBuffer.putShort((short)0);
        j += 1;
      }
      while (k > 0)
      {
        str = paramString[(paramString.length - k)];
        localByteBuffer.putShort(parseHextet(str));
        k -= 1;
      }
      return localByteBuffer.array();
      return null;
    }
    label272:
    return null;
  }
  
  public static String toAddrString(InetAddress paramInetAddress)
  {
    if (paramInetAddress != null)
    {
      if ((paramInetAddress instanceof Inet4Address)) {
        return paramInetAddress.getHostAddress();
      }
      Preconditions.checkArgument(paramInetAddress instanceof Inet6Address);
      paramInetAddress = paramInetAddress.getAddress();
      int[] arrayOfInt = new int[8];
      int i = 0;
      while (i < arrayOfInt.length)
      {
        int j = i * 2;
        arrayOfInt[i] = g.a(0, 0, paramInetAddress[j], paramInetAddress[(j + 1)]);
        i += 1;
      }
      compressLongestRunOfZeroes(arrayOfInt);
      return hextetsToIPv6String(arrayOfInt);
    }
    paramInetAddress = new NullPointerException();
    throw paramInetAddress;
  }
  
  public static String toUriString(InetAddress paramInetAddress)
  {
    if ((paramInetAddress instanceof Inet6Address))
    {
      StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("[");
      localStringBuilder.append(toAddrString(paramInetAddress));
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
    return toAddrString(paramInetAddress);
  }
  
  @a
  public final class TeredoInfo
  {
    public final Inet4Address client;
    public final int flags;
    public final int port;
    public final Inet4Address server;
    
    public TeredoInfo(Inet4Address paramInet4Address, int paramInt1, int paramInt2)
    {
      boolean bool;
      if ((paramInt1 >= 0) && (paramInt1 <= 65535)) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "port '%s' is out of range (0 <= port <= 0xffff)", new Object[] { Integer.valueOf(paramInt1) });
      if ((paramInt2 >= 0) && (paramInt2 <= 65535)) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkArgument(bool, "flags '%s' is out of range (0 <= flags <= 0xffff)", new Object[] { Integer.valueOf(paramInt2) });
      server = ((Inet4Address)Objects.firstNonNull(this$1, InetAddresses.ANY4));
      client = ((Inet4Address)Objects.firstNonNull(paramInet4Address, InetAddresses.ANY4));
      port = paramInt1;
      flags = paramInt2;
    }
    
    public Inet4Address getClient()
    {
      return client;
    }
    
    public int getFlags()
    {
      return flags;
    }
    
    public int getPort()
    {
      return port;
    }
    
    public Inet4Address getServer()
    {
      return server;
    }
  }
}
