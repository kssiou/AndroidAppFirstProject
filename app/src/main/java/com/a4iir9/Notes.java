package com.a4iir9;

public class Notes {
    private String label ;
    private Float note ;

    public Notes(String label, Float note) {
        this.label = label;
        this.note = note;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Float getNote() {
        return note;
    }

    public void setNote(Float note) {
        this.note = note;
    }
}
