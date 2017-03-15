package track.lessons.lesson3;

import java.util.NoSuchElementException;

/**
 * Created by islamov on 15.03.17.
 */

// Stack interface

public interface Stack {
    public void push(int value);
    public int pop() throws NoSuchElementException;
}
