package ru.ratnikoff;

public class Thread3 extends Thread {
    float[] mdim;

    public Thread3(float[] mTemp1) {
        mdim = mTemp1;
    }

    @Override
    public void run() {
        for (int i = 0; i < mdim.length; i++) {
            mdim[i] = (float) (mdim[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

    public float[] getDim() {
        return mdim;
    }
}
