package com.mytutorial.jsToWicket;

import java.io.Serializable;

public class Task implements Serializable{
    private static final long serialVersionUID = 1L;
    private String id;
    private int order;
    private String label;
    
    
    public Task(String id, int order, String label) {
        super();
        this.id = id;
        this.order = order;
        this.label=label;
    }
    
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getOrder() {
        return order;
    }
    public void setOrder(int order) {
        this.order = order;
    }
    

}
