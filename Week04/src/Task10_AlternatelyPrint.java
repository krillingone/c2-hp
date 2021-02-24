public class Task10_AlternatelyPrint {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new TurnRunner(), "线程A").start();
        new Thread(new TurnRunner(), "线程B").start();
    }

    static class TurnRunner implements Runnable {
        private static int count = 0;
        private static final Object lock = new Object();

        @Override
        public void run() {
            while (count <= 100) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + ": " + count++);
                    lock.notify();
                    try {
                        if (count <= 100) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}