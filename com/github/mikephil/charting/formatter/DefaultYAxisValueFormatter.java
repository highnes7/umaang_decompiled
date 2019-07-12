package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.components.YAxis;
import java.text.DecimalFormat;

public class DefaultYAxisValueFormatter
  implements YAxisValueFormatter
{
  public DecimalFormat mFormat;
  
  public DefaultYAxisValueFormatter(int paramInt)
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
  
  public String getFormattedValue(float paramFloat, YAxis paramYAxis)
  {
    return mFormat.format(paramFloat);
  }
}
