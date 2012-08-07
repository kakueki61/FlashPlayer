package org.kakueki61.swf.lib.utils;

public class SwfIOException extends Exception {
    private static final String TAG = SwfIOException.class.getSimpleName();
    
    /**
     * Default constructor
     */
    public SwfIOException() {
        super();
    }
    
    /**
     * Creates SwfIOException using string message.
     * @param s the message created when this exception is thrown.
     */
    public SwfIOException(String s) {
        super(s);
    }
}
