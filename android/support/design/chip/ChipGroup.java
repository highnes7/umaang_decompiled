package android.support.design.chip;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.R.attr;
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.support.design.internal.FlowLayout;
import android.support.design.internal.ThemeEnforcement;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import b.b.a.G;
import b.b.a.o;
import b.b.a.v;

public class ChipGroup
  extends FlowLayout
{
  @v
  public int checkedId = -1;
  public final CheckedStateTracker checkedStateTracker = new CheckedStateTracker(null);
  @o
  public int chipSpacingHorizontal;
  @o
  public int chipSpacingVertical;
  @G
  public OnCheckedChangeListener onCheckedChangeListener;
  public PassThroughHierarchyChangeListener passThroughListener = new PassThroughHierarchyChangeListener(null);
  public boolean protectFromCheckedChange = false;
  public boolean singleSelection;
  
  public ChipGroup(Context paramContext)
  {
    this(paramContext, null, R.attr.chipGroupStyle);
  }
  
  public ChipGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.chipGroupStyle);
  }
  
  public ChipGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = ThemeEnforcement.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.ChipGroup, paramInt, R.style.Widget_MaterialComponents_ChipGroup, new int[0]);
    paramInt = paramContext.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacing, 0);
    setChipSpacingHorizontal(paramContext.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacingHorizontal, paramInt));
    setChipSpacingVertical(paramContext.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacingVertical, paramInt));
    setSingleLine(paramContext.getBoolean(R.styleable.ChipGroup_singleLine, false));
    setSingleSelection(paramContext.getBoolean(R.styleable.ChipGroup_singleSelection, false));
    paramInt = paramContext.getResourceId(R.styleable.ChipGroup_checkedChip, -1);
    if (paramInt != -1) {
      checkedId = paramInt;
    }
    paramContext.recycle();
    super.setOnHierarchyChangeListener(passThroughListener);
  }
  
  private void setCheckedId(int paramInt)
  {
    checkedId = paramInt;
    OnCheckedChangeListener localOnCheckedChangeListener = onCheckedChangeListener;
    if ((localOnCheckedChangeListener != null) && (singleSelection)) {
      localOnCheckedChangeListener.onCheckedChanged(this, paramInt);
    }
  }
  
  private void setCheckedStateForView(int paramInt, boolean paramBoolean)
  {
    View localView = findViewById(paramInt);
    if ((localView instanceof Chip))
    {
      protectFromCheckedChange = true;
      ((Chip)localView).setChecked(paramBoolean);
      protectFromCheckedChange = false;
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramView instanceof Chip))
    {
      Chip localChip = (Chip)paramView;
      if (localChip.isChecked())
      {
        int i = checkedId;
        if ((i != -1) && (singleSelection)) {
          setCheckedStateForView(i, false);
        }
        setCheckedId(localChip.getId());
      }
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public void check(int paramInt)
  {
    int i = checkedId;
    if (paramInt == i) {
      return;
    }
    if ((i != -1) && (singleSelection)) {
      setCheckedStateForView(i, false);
    }
    if (paramInt != -1) {
      setCheckedStateForView(paramInt, true);
    }
    checkedId = paramInt;
    OnCheckedChangeListener localOnCheckedChangeListener = onCheckedChangeListener;
    if ((localOnCheckedChangeListener != null) && (singleSelection)) {
      localOnCheckedChangeListener.onCheckedChanged(this, paramInt);
    }
  }
  
  public boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof LayoutParams));
  }
  
  public void clearCheck()
  {
    protectFromCheckedChange = true;
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if ((localView instanceof Chip)) {
        ((Chip)localView).setChecked(false);
      }
      i += 1;
    }
    protectFromCheckedChange = false;
    setCheckedId(-1);
  }
  
  public ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-2, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getCheckedChipId()
  {
    if (singleSelection) {
      return checkedId;
    }
    return -1;
  }
  
  public int getChipSpacingHorizontal()
  {
    return chipSpacingHorizontal;
  }
  
  public int getChipSpacingVertical()
  {
    return chipSpacingVertical;
  }
  
  public boolean isSingleSelection()
  {
    return singleSelection;
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    int i = checkedId;
    if (i != -1)
    {
      setCheckedStateForView(i, true);
      setCheckedId(checkedId);
    }
  }
  
  public void setChipSpacing(int paramInt)
  {
    setChipSpacingHorizontal(paramInt);
    setChipSpacingVertical(paramInt);
  }
  
  public void setChipSpacingHorizontal(int paramInt)
  {
    if (chipSpacingHorizontal != paramInt)
    {
      chipSpacingHorizontal = paramInt;
      setItemSpacing(paramInt);
      requestLayout();
    }
  }
  
  public void setChipSpacingHorizontalResource(int paramInt)
  {
    setChipSpacingHorizontal(getResources().getDimensionPixelOffset(paramInt));
  }
  
  public void setChipSpacingResource(int paramInt)
  {
    setChipSpacing(getResources().getDimensionPixelOffset(paramInt));
  }
  
  public void setChipSpacingVertical(int paramInt)
  {
    if (chipSpacingVertical != paramInt)
    {
      chipSpacingVertical = paramInt;
      setLineSpacing(paramInt);
      requestLayout();
    }
  }
  
  public void setChipSpacingVerticalResource(int paramInt)
  {
    setChipSpacingVertical(getResources().getDimensionPixelOffset(paramInt));
  }
  
  public void setDividerDrawableHorizontal(Drawable paramDrawable)
  {
    throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
  }
  
  public void setDividerDrawableVertical(Drawable paramDrawable)
  {
    throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
  }
  
  public void setFlexWrap(int paramInt)
  {
    throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
  }
  
  public void setOnCheckedChangeListener(OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    onCheckedChangeListener = paramOnCheckedChangeListener;
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    PassThroughHierarchyChangeListener.access$202(passThroughListener, paramOnHierarchyChangeListener);
  }
  
  public void setShowDividerHorizontal(int paramInt)
  {
    throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
  }
  
  public void setShowDividerVertical(int paramInt)
  {
    throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
  }
  
  public void setSingleLine(int paramInt)
  {
    setSingleLine(getResources().getBoolean(paramInt));
  }
  
  public void setSingleSelection(int paramInt)
  {
    setSingleSelection(getResources().getBoolean(paramInt));
  }
  
  public void setSingleSelection(boolean paramBoolean)
  {
    if (singleSelection != paramBoolean)
    {
      singleSelection = paramBoolean;
      clearCheck();
    }
  }
  
  private class CheckedStateTracker
    implements CompoundButton.OnCheckedChangeListener
  {
    public CheckedStateTracker() {}
    
    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      if (ChipGroup.access$300(ChipGroup.this)) {
        return;
      }
      int i = paramCompoundButton.getId();
      if (paramBoolean)
      {
        if ((ChipGroup.access$400(ChipGroup.this) != -1) && (ChipGroup.access$400(ChipGroup.this) != i) && (ChipGroup.access$500(ChipGroup.this)))
        {
          paramCompoundButton = ChipGroup.this;
          ChipGroup.access$600(paramCompoundButton, ChipGroup.access$400(paramCompoundButton), false);
        }
        ChipGroup.access$700(ChipGroup.this, i);
        return;
      }
      if (ChipGroup.access$400(ChipGroup.this) == i) {
        ChipGroup.access$700(ChipGroup.this, -1);
      }
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
  }
  
  public static abstract interface OnCheckedChangeListener
  {
    public abstract void onCheckedChanged(ChipGroup paramChipGroup, int paramInt);
  }
  
  private class PassThroughHierarchyChangeListener
    implements ViewGroup.OnHierarchyChangeListener
  {
    public ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener;
    
    public PassThroughHierarchyChangeListener() {}
    
    public void onChildViewAdded(View paramView1, View paramView2)
    {
      if ((paramView1 == ChipGroup.this) && ((paramView2 instanceof Chip)))
      {
        if (paramView2.getId() == -1)
        {
          int i = Build.VERSION.SDK_INT;
          paramView2.setId(View.generateViewId());
        }
        ((Chip)paramView2).setOnCheckedChangeListenerInternal(ChipGroup.access$800(ChipGroup.this));
      }
      ViewGroup.OnHierarchyChangeListener localOnHierarchyChangeListener = onHierarchyChangeListener;
      if (localOnHierarchyChangeListener != null) {
        localOnHierarchyChangeListener.onChildViewAdded(paramView1, paramView2);
      }
    }
    
    public void onChildViewRemoved(View paramView1, View paramView2)
    {
      if ((paramView1 == ChipGroup.this) && ((paramView2 instanceof Chip))) {
        ((Chip)paramView2).setOnCheckedChangeListenerInternal(null);
      }
      ViewGroup.OnHierarchyChangeListener localOnHierarchyChangeListener = onHierarchyChangeListener;
      if (localOnHierarchyChangeListener != null) {
        localOnHierarchyChangeListener.onChildViewRemoved(paramView1, paramView2);
      }
    }
  }
}
