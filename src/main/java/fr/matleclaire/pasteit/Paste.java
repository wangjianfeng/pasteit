package fr.matleclaire.pasteit;

import java.util.Date;


public class Paste {

    private String id;
    private String label;
    private String text;
    private Date createdDate;

    public Paste() {
        this.createdDate = new Date();
    }

    public Paste(String id, String label, String text) {
        this.id = id;
        this.label = label;
        this.text = text;
        this.createdDate = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }


    @Override
    public String toString() {
        return "Paste {" + "id=" + id + ", createdDate ="+ createdDate +",  label=" + label + "}";
    }
}
