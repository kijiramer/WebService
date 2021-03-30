package com.example.web_service;

public class Rent {

    private String begin;
    private String end;

    public Rent(String begin, String end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "begin='" + begin + '\'' +
                ", end='" + end + '\'' +
                '}';
    }

    public Rent(){

    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}