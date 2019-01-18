package e.smyye.todolist.model;

import java.io.Serializable;

public class ItemTask implements Serializable {
    String title;
    String detail;

    public ItemTask() {
    }

    public ItemTask(String title, String detail) {
        this.title = title;
        this.detail = detail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
