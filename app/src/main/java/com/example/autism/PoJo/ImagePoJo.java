package com.example.autism.PoJo;

public class ImagePoJo {

    int serialNumber;
    int imageDrawableId;

    public ImagePoJo(int serialNumber, int imageDrawableId) {
        this.serialNumber = serialNumber;
        this.imageDrawableId = imageDrawableId;
    }

    public ImagePoJo() {
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getImageDrawableId() {
        return imageDrawableId;
    }

    public void setImageDrawableId(int imageDrawableId) {
        this.imageDrawableId = imageDrawableId;
    }
}
