package com.google.android.android.samples.vision.barcodereader;

import com.google.android.android.vision.Tracker;
import com.google.android.gms.vision.MultiProcessor.Factory;

public abstract class BarcodeTrackerFactory
  implements MultiProcessor.Factory<com.google.android.gms.vision.barcode.Barcode>
{
  public com.google.android.gms.samples.vision.barcodereader.ui.camera.GraphicOverlay<com.google.android.gms.samples.vision.barcodereader.BarcodeGraphic> mGraphicOverlay;
  
  public BarcodeTrackerFactory(com.google.android.android.samples.vision.barcodereader.pref.camera.GraphicOverlay paramGraphicOverlay)
  {
    mGraphicOverlay = paramGraphicOverlay;
  }
  
  public Tracker create(com.google.android.android.vision.barcode.Barcode paramBarcode)
  {
    onCodeDetected(paramBarcode);
    paramBarcode = new BarcodeGraphic(mGraphicOverlay);
    return new BarcodeGraphicTracker(mGraphicOverlay, paramBarcode);
  }
  
  public abstract void onCodeDetected(com.google.android.android.vision.barcode.Barcode paramBarcode);
}
