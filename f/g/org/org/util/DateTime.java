package f.g.org.org.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DateTime
  implements Serializable
{
  public static final TimeZone GMT = TimeZone.getTimeZone("GMT");
  public static final Pattern RFC3339_PATTERN = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})([Tt](\\d{2}):(\\d{2}):(\\d{2})(\\.\\d+)?)?([Zz]|([+-])(\\d{2}):(\\d{2}))?");
  public static final long serialVersionUID = 1L;
  public final boolean dateOnly;
  public final int tzShift;
  public final long value;
  
  public DateTime(long paramLong)
  {
    this(false, paramLong, null);
  }
  
  public DateTime(long paramLong, int paramInt)
  {
    this(false, paramLong, Integer.valueOf(paramInt));
  }
  
  public DateTime(String paramString)
  {
    paramString = parseRfc3339(paramString);
    dateOnly = dateOnly;
    value = value;
    tzShift = tzShift;
  }
  
  public DateTime(Date paramDate)
  {
    this(paramDate.getTime());
  }
  
  public DateTime(Date paramDate, TimeZone paramTimeZone)
  {
    this(false, l, paramDate);
  }
  
  public DateTime(boolean paramBoolean, long paramLong, Integer paramInteger)
  {
    dateOnly = paramBoolean;
    value = paramLong;
    int i;
    if (paramBoolean) {
      i = 0;
    } else if (paramInteger == null) {
      i = TimeZone.getDefault().getOffset(paramLong) / 60000;
    } else {
      i = paramInteger.intValue();
    }
    tzShift = i;
  }
  
  public static void appendInt(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 < 0)
    {
      paramStringBuilder.append('-');
      i = -paramInt1;
    }
    paramInt1 = i;
    while (paramInt1 > 0)
    {
      paramInt1 /= 10;
      paramInt2 -= 1;
    }
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      paramStringBuilder.append('0');
      paramInt1 += 1;
    }
    if (i != 0) {
      paramStringBuilder.append(i);
    }
  }
  
  public static DateTime parseRfc3339(String paramString)
    throws NumberFormatException
  {
    Matcher localMatcher = RFC3339_PATTERN.matcher(paramString);
    if (!localMatcher.matches())
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "Invalid date/time format: ".concat(paramString);
      } else {
        paramString = new String("Invalid date/time format: ");
      }
      throw new NumberFormatException(paramString);
    }
    int i3 = Integer.parseInt(localMatcher.group(1));
    int i4 = Integer.parseInt(localMatcher.group(2));
    int i5 = Integer.parseInt(localMatcher.group(3));
    String str1 = localMatcher.group(4);
    int i2 = 0;
    int j;
    if (str1 != null) {
      j = 1;
    } else {
      j = 0;
    }
    String str2 = localMatcher.group(9);
    int k;
    if (str2 != null) {
      k = 1;
    } else {
      k = 0;
    }
    str1 = null;
    if ((k != 0) && (j == 0))
    {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "Invalid date/time format, cannot specify time zone shift without specifying time: ".concat(paramString);
      } else {
        paramString = new String("Invalid date/time format, cannot specify time zone shift without specifying time: ");
      }
      throw new NumberFormatException(paramString);
    }
    int m;
    int n;
    int i1;
    int i;
    if (j != 0)
    {
      m = Integer.parseInt(localMatcher.group(5));
      n = Integer.parseInt(localMatcher.group(6));
      i1 = Integer.parseInt(localMatcher.group(7));
      if (localMatcher.group(8) != null) {
        i = Integer.parseInt(localMatcher.group(8).substring(1));
      } else {
        i = 0;
      }
    }
    else
    {
      i = 0;
      m = 0;
      n = 0;
      i1 = 0;
    }
    paramString = new GregorianCalendar(GMT);
    paramString.set(i3, i4 - 1, i5, m, n, i1);
    paramString.set(14, i);
    long l3 = paramString.getTimeInMillis();
    long l1 = l3;
    paramString = str1;
    long l2 = l1;
    if (j != 0)
    {
      paramString = str1;
      l2 = l1;
      if (k != 0)
      {
        if (Character.toUpperCase(str2.charAt(0)) == 'Z')
        {
          i = i2;
        }
        else
        {
          i = Integer.parseInt(localMatcher.group(11));
          i = Integer.parseInt(localMatcher.group(12)) + i * 60;
          if (localMatcher.group(10).charAt(0) == '-') {
            i = -i;
          }
          l1 = l3 - i * 60000L;
        }
        paramString = Integer.valueOf(i);
        l2 = l1;
      }
    }
    return new DateTime(j ^ 0x1, l2, paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof DateTime)) {
      return false;
    }
    paramObject = (DateTime)paramObject;
    return (dateOnly == dateOnly) && (value == value) && (tzShift == tzShift);
  }
  
  public int getTimeZoneShift()
  {
    return tzShift;
  }
  
  public long getValue()
  {
    return value;
  }
  
  public int hashCode()
  {
    long l2 = value;
    long l1;
    if (dateOnly) {
      l1 = 1L;
    } else {
      l1 = 0L;
    }
    return Arrays.hashCode(new long[] { l2, l1, tzShift });
  }
  
  public boolean isDateOnly()
  {
    return dateOnly;
  }
  
  public String toString()
  {
    return toStringRfc3339();
  }
  
  public String toStringRfc3339()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(GMT);
    long l = value;
    localGregorianCalendar.setTimeInMillis(tzShift * 60000L + l);
    appendInt(localStringBuilder, localGregorianCalendar.get(1), 4);
    localStringBuilder.append('-');
    appendInt(localStringBuilder, localGregorianCalendar.get(2) + 1, 2);
    localStringBuilder.append('-');
    appendInt(localStringBuilder, localGregorianCalendar.get(5), 2);
    if (!dateOnly)
    {
      localStringBuilder.append('T');
      appendInt(localStringBuilder, localGregorianCalendar.get(11), 2);
      localStringBuilder.append(':');
      appendInt(localStringBuilder, localGregorianCalendar.get(12), 2);
      localStringBuilder.append(':');
      appendInt(localStringBuilder, localGregorianCalendar.get(13), 2);
      if (localGregorianCalendar.isSet(14))
      {
        localStringBuilder.append('.');
        appendInt(localStringBuilder, localGregorianCalendar.get(14), 3);
      }
      int i = tzShift;
      if (i == 0)
      {
        localStringBuilder.append('Z');
      }
      else
      {
        if (i > 0)
        {
          localStringBuilder.append('+');
        }
        else
        {
          localStringBuilder.append('-');
          i = -i;
        }
        appendInt(localStringBuilder, i / 60, 2);
        localStringBuilder.append(':');
        appendInt(localStringBuilder, i % 60, 2);
      }
    }
    return localStringBuilder.toString();
  }
}
