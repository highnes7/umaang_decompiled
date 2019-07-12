package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.AbsSeekBar;
import android.widget.SeekBar;

public class AppCompatSeekBar
  extends SeekBar
{
  public final AppCompatSeekBarHelper mAppCompatSeekBarHelper = new AppCompatSeekBarHelper(this);
  
  public AppCompatSeekBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, i);
    mAppCompatSeekBarHelper.loadFromAttributes(paramAttributeSet, i);
  }
  
  public AppCompatSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    mAppCompatSeekBarHelper.loadFromAttributes(paramAttributeSet, paramInt);
  }
  
  public void drawableStateChanged()
  {
    super.drawableStateChanged();
    mAppCompatSeekBarHelper.drawableStateChanged();
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    mAppCompatSeekBarHelper.jumpDrawablesToCurrentState();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      mAppCompatSeekBarHelper.drawTickMarks(paramCanvas);
      return;
    }
    catch (Throwable paramCanvas)
    {
      throw paramCanvas;
    }
  }
}
