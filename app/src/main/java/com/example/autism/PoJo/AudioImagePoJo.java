package com.example.autism.PoJo;

public class AudioImagePoJo {

    int audioId;
    int imageId;

    public AudioImagePoJo(int audioId, int imageId) {
        this.audioId = audioId;
        this.imageId = imageId;
    }

    public int getAudioId() {
        return audioId;
    }

    public void setAudioId(int audioId) {
        this.audioId = audioId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
