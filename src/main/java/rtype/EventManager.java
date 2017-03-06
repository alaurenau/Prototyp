package rtype;

import java.util.ArrayList;

public class EventManager {

    private static EventManager instance;

    ;
    private ArrayList<KeyListener> listeners = new ArrayList<KeyListener>();

    //Singleton variable and methods:
    private EventManager() {
    }

    public static EventManager instance() {
        if (instance == null)
            instance = new EventManager();
        return instance;
    }

    public void addListener(int key, KeyListener listener) {
        listener.setKeyMonitored(key);
        listeners.add(listener);
    }

    public void removeListener(KeyListener listener) {
        listeners.remove(listener);
    }

    public void clear() {
        listeners.clear();
    }

    void checkEvents() {
        for (KeyListener listener : listeners) {
            listener.checkKey();
        }
    }
}
