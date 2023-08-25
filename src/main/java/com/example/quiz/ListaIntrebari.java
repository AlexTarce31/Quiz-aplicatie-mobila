package com.example.quiz;

public class ListaIntrebari
{
    private String intrebare, opt1, opt2, opt3, opt4, raspuns;
    private String raspunsSelectat;

    public ListaIntrebari(String intrebare, String opt1, String opt2, String opt3, String opt4, String raspuns, String raspunsSelectat) {
        this.intrebare = intrebare;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.opt4 = opt4;
        this.raspuns = raspuns;
        this.raspunsSelectat = raspunsSelectat;
    }

    public String getIntrebare() {
        return intrebare;
    }

    public String getOpt1() {
        return opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public String getOpt3() {
        return opt3;
    }

    public String getOpt4() {
        return opt4;
    }

    public String getRaspuns() {
        return raspuns;
    }

    public String getRaspunsSelectat() {
        return raspunsSelectat;
    }

    public void setRaspunsSelectat(String raspunsSelectat) {
        this.raspunsSelectat = raspunsSelectat;
    }
}
