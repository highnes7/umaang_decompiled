package android.support.design.theme;

import android.content.Context;
import android.support.annotation.Keep;
import android.support.design.R.attr;
import android.support.design.button.MaterialButton;
import android.support.v7.app.AppCompatViewInflater;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

@Keep
public class MaterialComponentsViewInflater
  extends AppCompatViewInflater
{
  public MaterialComponentsViewInflater() {}
  
  public AppCompatButton createButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new MaterialButton(paramContext, paramAttributeSet, R.attr.materialButtonStyle);
  }
}
