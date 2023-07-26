package com.algoda.exam.controller;

public class Checkdto {
    String word;
    String meaninga;
    String meaningb;
    String meaningc;
    String ans;
    String similiar_worda;
    boolean check;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaninga() {
        return meaninga;
    }

    public void setMeaninga(String meaninga) {
        this.meaninga = meaninga;
    }

    public String getMeaningb() {
        return meaningb;
    }

    public void setMeaningb(String meaningb) {
        this.meaningb = meaningb;
    }

    public String getMeaningc() {
        return meaningc;
    }

    public void setMeaningc(String meaningc) {
        this.meaningc = meaningc;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public String getSimiliar_worda() {
        return similiar_worda;
    }

    public void setSimiliar_worda(String similiar_worda) {
        this.similiar_worda = similiar_worda;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
