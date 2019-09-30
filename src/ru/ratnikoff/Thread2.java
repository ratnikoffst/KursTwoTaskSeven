package ru.ratnikoff;

import com.sun.jdi.VMDisconnectedException;

public class Thread2 extends Thread {
    private float[] mDim;
    private int mH;
    private int mSize;
    private float[] mTemp1;
    private float[] mTemp2;

    public Thread2(int size, int h) {
        mSize = size;
        mH = h;
    }

    @Override
    public void run() {
        mDim = new float[mSize];
        mTemp1 = new float[mH];
        mTemp2 = new float[mH];

        for (int i=0;i<mDim.length;i++) {
            mDim[i]=1;
        }
        long time = System.currentTimeMillis();
        System.arraycopy(mDim, 0, mTemp1, 0, mH);
        System.arraycopy(mDim, mH, mTemp2, 0, mH);

        Thread3 task1 = new Thread3(mTemp1);
        Thread3 task2 = new Thread3(mTemp2);

        task1.start();
        task2.start();

        try {
            task1.join();
            task2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(task1.getDim(), 0, mDim, 0, mH);
        System.arraycopy(task2.getDim(), 0, mDim, mH, mH);

        System.out.println("Время работы метода 2: " + (System.currentTimeMillis() - time));
    }
}
