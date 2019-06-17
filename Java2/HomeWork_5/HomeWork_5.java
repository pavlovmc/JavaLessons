package HomeWork_5;

public class HomeWork_5 {
    static private final int size = 20000000;
    static private final int h = size / 2;

    public static void main(String[] args) {
        HomeWork_5 hw = new HomeWork_5();
        int[] flag = {0};
        float[] arr = new float[size];

        hw.initArray(arr);
        long startTime = System.currentTimeMillis();
        hw.recountArray(arr,0);
        System.out.println(System.currentTimeMillis() - startTime);

        hw.initArray(arr);
        startTime = System.currentTimeMillis();
        Thread t1 = new Thread(()-> {
            float[] a1 = new float[h];
            System.arraycopy(arr, 0, a1, 0, h);
            hw.recountArray(a1, 0);
            hw.mergeArray(a1, arr, 0, h);
            flag[0]++;
        });
        Thread t2 = new Thread(() -> {
            float[] a1 = new float[h];
            System.arraycopy(arr, h, a1, 0, h);
            hw.recountArray(a1, h);
            hw.mergeArray(a1, arr, h, h);
            flag[0]++;
        });
        t1.start();
        t2.start();
        while(flag[0]<2) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }

    private void initArray(float[] arr) {
        for (int i=0;i<arr.length;i++){
            arr[i] = 1;
        }
    }

    private void recountArray(float[] arr, int startPos){
        int j;
        for (int i = 0; i<arr.length; i++){
            j = i + startPos;
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (float)(j / 5))
                    * Math.cos(0.2f + (float)(j / 5)) * Math.cos(0.4f + (float)(j / 2)));
        }
    }

    synchronized private void mergeArray(float[] arrSrc, float[] arrDst, int starPosDst, int size){
        System.arraycopy(arrSrc, 0, arrDst, starPosDst, size);
    }
}
