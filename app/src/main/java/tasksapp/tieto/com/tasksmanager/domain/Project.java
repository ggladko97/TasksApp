package tasksapp.tieto.com.tasksmanager.domain;

import java.io.Serializable;

/**
 * Created by hladlyev on 09.04.2018.
 */

public class Project implements Serializable {
    private Long id;
    private String title;
    private String endDate;
    private String endTime;
    private Boolean isDone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {

        return "Project{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", endDate='" + endDate + '\'' +
                ", endTime='" + endTime + '\'' +
                ", isDone=" + isDone +
                '}';
    }
}
