package com.company;

public class Link {
    private long id;
    private long compId;
    private long personId;

    public Link() {
    }

    public Link(long compId, long personId, long id) {
        this.compId = compId;
        this.personId = personId;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCompId() {
        return compId;
    }

    public void setCompId(long compId) {
        this.compId = compId;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }
}
