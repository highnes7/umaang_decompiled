package com.google.android.android.vision;

public class Tracker<T>
{
  public Tracker() {}
  
  public void onDone() {}
  
  public void onMissing(Detector.Detections paramDetections) {}
  
  public void onNewItem(int paramInt, Object paramObject) {}
  
  public void onUpdate(Detector.Detections paramDetections, Object paramObject) {}
}
