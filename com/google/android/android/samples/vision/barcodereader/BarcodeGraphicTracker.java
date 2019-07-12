package com.google.android.android.samples.vision.barcodereader;

import com.google.android.android.vision.Detector.Detections;
import com.google.android.gms.vision.Tracker;

public class BarcodeGraphicTracker
  extends Tracker<com.google.android.gms.vision.barcode.Barcode>
{
  public BarcodeGraphic mGraphic;
  public com.google.android.gms.samples.vision.barcodereader.ui.camera.GraphicOverlay<com.google.android.gms.samples.vision.barcodereader.BarcodeGraphic> mOverlay;
  
  public BarcodeGraphicTracker(com.google.android.android.samples.vision.barcodereader.pref.camera.GraphicOverlay paramGraphicOverlay, BarcodeGraphic paramBarcodeGraphic)
  {
    mOverlay = paramGraphicOverlay;
    mGraphic = paramBarcodeGraphic;
  }
  
  public void onDone()
  {
    mOverlay.remove(mGraphic);
  }
  
  public void onMissing(Detector.Detections paramDetections)
  {
    mOverlay.remove(mGraphic);
  }
  
  public void onNewItem(int paramInt, com.google.android.android.vision.barcode.Barcode paramBarcode)
  {
    mGraphic.setId(paramInt);
  }
  
  public void onUpdate(Detector.Detections paramDetections, com.google.android.android.vision.barcode.Barcode paramBarcode)
  {
    mOverlay.update(mGraphic);
    mGraphic.updateItem(paramBarcode);
  }
}
