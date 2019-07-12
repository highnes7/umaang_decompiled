package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.text.DecimalFormat;

public class DefaultValueFormatter
  implements ValueFormatter
{
  public DecimalFormat mFormat;
  
  public DefaultValueFormatter(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramInt)
    {
      if (i == 0) {
        localStringBuffer.append(".");
      }
      localStringBuffer.append("0");
      i += 1;
    }
    StringBuilder localStringBuilder = f.sufficientlysecure.rootcommands.util.StringBuilder.append("###,###,###,##0");
    localStringBuilder.append(localStringBuffer.toString());
    mFormat = new DecimalFormat(localStringBuilder.toString());
  }
  
  public String getFormattedValue(float paramFloat, Entry paramEntry, int paramInt, ViewPortHandler paramViewPortHandler)
  {
    return mFormat.format(paramFloat);
  }
}
