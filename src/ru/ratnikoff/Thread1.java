package ru.ratnikoff;

public class Thread1 extends Thread {
    private float[] mDim;
    private final int mSize;

    public Thread1(int size) {
        super();
        mSize = size;
    }

    @Override
    public void run() {

        mDim = new float[mSize];
        for (int i = 0; i < mDim.length; i++) {
            mDim[i] = 1;
        }
        long time = System.currentTimeMillis();
        for (int i = 0; i < mDim.length; i++) {
            mDim[i] = 1;
            mDim[i] = (float) (mDim[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время работы метода 1: " + (System.currentTimeMillis() - time));
    }
}
