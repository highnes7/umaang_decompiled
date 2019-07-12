package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.ViewPortHandler;
import java.text.DecimalFormat;

public class PercentFormatter
  implements ValueFormatter, YAxisValueFormatter
{
  public DecimalFormat mFormat;
  
  public PercentFormatter()
  {
    mFormat = new DecimalFormat("###,###,##0.0");
  }
  
  public PercentFormatter(DecimalFormat paramDecimalFormat)
  {
    mFormat = paramDecimalFormat;
  }
  
  public String getFormattedValue(float paramFloat, YAxis paramYAxis)
  {
    paramYAxis = new StringBuilder();
    paramYAxis.append(mFormat.format(paramFloat));
    paramYAxis.append(" %");
    return paramYAxis.toString();
  }
  
  public String getFormattedValue(float paramFloat, Entry paramEntry, int paramInt, ViewPortHandler paramViewPortHandler)
  {
    paramEntry = new StringBuilder();
    paramEntry.append(mFormat.format(paramFloat));
    paramEntry.append(" %");
    return paramEntry.toString();
  }
}
