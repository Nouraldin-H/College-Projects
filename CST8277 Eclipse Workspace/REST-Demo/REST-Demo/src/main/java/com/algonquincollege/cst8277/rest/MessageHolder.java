/*****************************************************************
 * File:  MessageHolder.java
 * Course Materials CST 8277
 * @author (original) Mike Norman
 * @author Teddy Yap
 *
 */
package com.algonquincollege.cst8277.rest;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MessageHolder implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String theMessage;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime date;

    public MessageHolder() {
        super();
        date = LocalDateTime.now();
    }

    public MessageHolder(String theMessage) {
        this();
        this.theMessage = theMessage;
    }

    //make JSON field 'msg', not 'theMessage' - Java beans naming convention (again!)
    public String getMsg() {
        return theMessage;
    }
    public void setMsg(String msg) {
        this.theMessage = msg;
    }

    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("(MessageHolder)msg = ")
            .append(getMsg())
            .append(" [date = ")
            .append(getDate())
            .append("]");
        return builder.toString();
    }
}