package com.jxnu.app.model;

/**
 * Created by puchunwei on 16/5/1.
 */
public class Note {

    private Long   id;
    private String content;
    private Long   user_id;
    private Long   course_id;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourse_id() { return course_id;}

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
