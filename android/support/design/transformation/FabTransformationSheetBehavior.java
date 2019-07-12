package android.support.design.transformation;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.design.R.animator;
import android.support.design.animation.MotionSpec;
import android.support.design.animation.Positioning;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import java.util.Map;
import support.android.v4.view.ViewCompat;

public class FabTransformationSheetBehavior
  extends FabTransformationBehavior
{
  public Map<View, Integer> importantForAccessibilityMap;
  
  public FabTransformationSheetBehavior() {}
  
  public FabTransformationSheetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void updateImportantForAccessibility(View paramView, boolean paramBoolean)
  {
    Object localObject = paramView.getParent();
    if (!(localObject instanceof CoordinatorLayout)) {
      return;
    }
    localObject = (CoordinatorLayout)localObject;
    int k = ((ViewGroup)localObject).getChildCount();
    int i = Build.VERSION.SDK_INT;
    if (paramBoolean) {
      importantForAccessibilityMap = new HashMap(k);
    }
    i = 0;
    while (i < k)
    {
      View localView = ((ViewGroup)localObject).getChildAt(i);
      int j;
      if (((localView.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) && ((((CoordinatorLayout.LayoutParams)localView.getLayoutParams()).getBehavior() instanceof FabTransformationScrimBehavior))) {
        j = 1;
      } else {
        j = 0;
      }
      if ((localView != paramView) && (j == 0)) {
        if (!paramBoolean)
        {
          Map localMap = importantForAccessibilityMap;
          if ((localMap != null) && (localMap.containsKey(localView))) {
            ViewCompat.setImportantForAccessibility(localView, ((Integer)importantForAccessibilityMap.get(localView)).intValue());
          }
        }
        else
        {
          j = Build.VERSION.SDK_INT;
          importantForAccessibilityMap.put(localView, Integer.valueOf(localView.getImportantForAccessibility()));
          ViewCompat.setImportantForAccessibility(localView, 4);
        }
      }
      i += 1;
    }
    if (!paramBoolean) {
      importantForAccessibilityMap = null;
    }
  }
  
  public FabTransformationBehavior.FabTransformationSpec onCreateMotionSpec(Context paramContext, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = R.animator.mtrl_fab_transformation_sheet_expand_spec;
    } else {
      i = R.animator.mtrl_fab_transformation_sheet_collapse_spec;
    }
    FabTransformationBehavior.FabTransformationSpec localFabTransformationSpec = new FabTransformationBehavior.FabTransformationSpec();
    timings = MotionSpec.createFromResource(paramContext, i);
    positioning = new Positioning(17, 0.0F, 0.0F);
    return localFabTransformationSpec;
  }
  
  public boolean onExpandedStateChange(View paramView1, View paramView2, boolean paramBoolean1, boolean paramBoolean2)
  {
    updateImportantForAccessibility(paramView2, paramBoolean1);
    super.onExpandedStateChange(paramView1, paramView2, paramBoolean1, paramBoolean2);
    return true;
  }
}
