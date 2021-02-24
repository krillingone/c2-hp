class Message {
    private String title;
    private String content;

    private boolean flag = true;    // true空的可以生产不可以取；false满的生产不了可以取

    public synchronized void set(String title, String content) {
        if (!this.flag) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.title = title;
        this.content = content;
        System.out.println("装填： " + this.title + " : " + this.content);

        this.flag = false;
        super.notify();
    }

    public synchronized void get() {
        if (this.flag) {
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("消耗： " + this.title + "-------->" + this.content);

        this.flag = true;
        super.notify();
    }
}

class Provider implements Runnable {
    private Message msg;

    public Provider(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                this.msg.set("野兽先辈", "24岁，是学生。");
            } else {
                this.msg.set("比利王", "乖乖♂站好！");
            }
        }
    }
}

class Consumer implements Runnable {
    private Message msg;

    public Consumer(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            this.msg.get();
        }
    }
}

public class Task11_ProviderConsumer {
    public static void main(String[] args) {
        Message msg = new Message();
        new Thread(new Provider(msg)).start();
        new Thread(new Consumer(msg)).start();
    }
}
