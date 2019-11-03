package ru.ariona.testingsystem.domain;

public class Question {

    private String que;
    private String ans;

    public Question(String question) {
        String[] strings = question.split(";");
        que = strings[0];
        ans = strings[1];
    }

    public String getQue() {
        return que;
    }

    public void setQue(String que) {
        this.que = que;
    }

    public String getAns() {
        return ans.trim();
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public void print() {
        System.out.println(que);
    }
}
