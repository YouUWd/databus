package com.youu.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBusUtils {

    private static ThreadLocal<Map<Thread, String>> thString = new ThreadLocal<Map<Thread, String>>();

    private static ThreadLocal<Map<Thread, List<Message>>> thMessage = new ThreadLocal<Map<Thread, List<Message>>>();

    public static void addSimpleMsg(String msg) {
        if (thString.get() == null) {
            thString.set(new HashMap<Thread, String>());
        }
        thString.get().put(Thread.currentThread(), msg);
    }

    public static String getSimpleMsg(Thread ct) {
        if (thString.get() == null) {
            return null;
        }
        return thString.get().get(ct);
    }

    public static void addMessage(Message msg) {
        Thread ct = Thread.currentThread();
        if (thMessage.get() == null) {
            thMessage.set(new HashMap<Thread, List<Message>>());
        }
        List<Message> msgs;
        if (thMessage.get().get(ct) != null) {
            msgs = thMessage.get().get(ct);

        } else {
            msgs = new ArrayList<Message>();
        }
        msgs.add(msg);

        thMessage.get().put(ct, msgs);
    }

    public static List<Message> getMessage() {
        if (thMessage.get() == null) {
            return null;
        }
        return thMessage.get().get(Thread.currentThread());
    }

    public static void releaseSimpleMsg() {
        Thread ct = Thread.currentThread();
        if (thString.get().containsKey(ct))
            thString.get().remove(ct);
    }

    public static void releaseMessage() {
        Thread ct = Thread.currentThread();
        if (thMessage.get().containsKey(ct))
            thMessage.get().remove(ct);
    }

    public static void main(String[] args) {
        Message message = new Message();
        addMessage(message);
        System.out.println(thMessage.get());
        releaseMessage();
        System.out.println(thMessage.get());
        addMessage(message);
        System.out.println(thMessage.get());
    }
}
