package track.lessons.lesson3;

/**
 * Created by islamov on 15.03.17.
 */

import java.util.NoSuchElementException;

 // Queue interface.

public interface Queue {

    public void enqueue(int value);

    public int dequeue() throws NoSuchElementException;

}