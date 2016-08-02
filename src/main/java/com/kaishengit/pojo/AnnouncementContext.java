package com.kaishengit.pojo;

import javax.persistence.*;

@Entity
@Table(name = "t_announcement_context")
public class AnnouncementContext {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String context;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
