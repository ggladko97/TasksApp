package tasksapp.tieto.com.tasksmanager.domain;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;


/**
 * Created by hladlyev on 09.04.2018.
 */
@Entity(nameInDb = "project")
public class Project {

    @Id(autoincrement = true)
    private Long id;

    @NotNull
    @Property(nameInDb = "title")
    private String title;


    @Property(nameInDb = "endDate")
    private String endDate;


    @Property(nameInDb = "endTime")
    private String endTime;

    @NotNull
    @Property(nameInDb = "isDone")
    private Boolean isDone;

    @Generated(hash = 1369236257)
    public Project(Long id, @NotNull String title, String endDate, String endTime,
            @NotNull Boolean isDone) {
        this.id = id;
        this.title = title;
        this.endDate = endDate;
        this.endTime = endTime;
        this.isDone = isDone;
    }

    @Generated(hash = 1767516619)
    public Project() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Boolean getIsDone() {
        return this.isDone;
    }

    public void setIsDone(Boolean isDone) {
        this.isDone = isDone;
    }


}
