public class Task10_AlternatelyPrint {
    public static void main(String[] args) {
        TurnRunner tr = new TurnRunner();
        new Thread(tr, "线程A").start();
        new Thread(tr, "线程B").start();
    }

    static class TurnRunner implements Runnable {
        private int count = 0;

        @Override
        public void run() {
            while (count <= 100) {
                synchronized (this) {
                    System.out.println(Thread.currentThread().getName() + ": " + count++);
                    this.notify();
                    try {
                        if (count <= 100) {
                            this.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}