package com.kaishengit.pojo;

import javax.persistence.*;

@Entity
@Table(name = "t_announcement")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contextid",unique = true)
    private AnnouncementContext announcementContext;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AnnouncementContext getAnnouncementContext() {
        return announcementContext;
    }

    public void setAnnouncementContext(AnnouncementContext announcementContext) {
        this.announcementContext = announcementContext;
    }
}
