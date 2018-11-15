package concurrent.thread001;

import java.util.LinkedList;

public class EventQueue {

    private final int max;

    static class Event{

    }

    private final LinkedList<Event> eventQueue = new LinkedList<>();

    private final static int DEFAULT_MAX_EVENT = 10;

    public EventQueue(){
        this(DEFAULT_MAX_EVENT);
    }

    public EventQueue(int aMax){
        this.max = aMax;
    }


    public void offer(Event event){
        synchronized (eventQueue){
            while (eventQueue.size() >= max){
                try{
                    console(" hte queue is full");
                    eventQueue.wait();
                    console(" ---------->>>");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            console(" the new event is submitted" + eventQueue.size());
            eventQueue.addLast(event);
            eventQueue.notifyAll();

        }
    }


    public Event take(){
        synchronized (eventQueue){
            while (eventQueue.isEmpty()){
                try{
                    console(" the queue is empty");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Event event = eventQueue.removeFirst();
            this.eventQueue.notifyAll();
            console("the event " + event + " is handled" + eventQueue.size());
            return event;
        }
    }

    private void console(String message){
        System.out.printf("%s:%s\n", Thread.currentThread().getName(),message);
    }

}
