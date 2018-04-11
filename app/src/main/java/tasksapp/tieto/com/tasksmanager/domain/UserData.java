package tasksapp.tieto.com.tasksmanager.domain;

/**
 * Created by hladlyev on 03.04.2018.
 */

public class UserData {
    private User user;

    private Integer allCreatedTasks;
    private Integer allCompletedTasks;
    private Integer allScheduleTasks;
    private Integer personalErrSize;
    private Integer workProjSize;
    private Integer grocListSize;
    private Integer schoolListSize;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getAllCreatedTasks() {
        return allCreatedTasks;
    }

    public void setAllCreatedTasks(Integer allCreatedTasks) {
        this.allCreatedTasks = allCreatedTasks;
    }

    public Integer getAllCompletedTasks() {
        return allCompletedTasks;
    }

    public void setAllCompletedTasks(Integer allCompletedTasks) {
        this.allCompletedTasks = allCompletedTasks;
    }

    public Integer getAllScheduleTasks() {
        return allScheduleTasks;
    }

    public void setAllScheduleTasks(Integer allScheduleTasks) {
        this.allScheduleTasks = allScheduleTasks;
    }

    public Integer getPersonalErrSize() {
        return personalErrSize;
    }

    public void setPersonalErrSize(Integer personalErrSize) {
        this.personalErrSize = personalErrSize;
    }

    public Integer getWorkProjSize() {
        return workProjSize;
    }

    public void setWorkProjSize(Integer workProjSize) {
        this.workProjSize = workProjSize;
    }

    public Integer getGrocListSize() {
        return grocListSize;
    }

    public void setGrocListSize(Integer grocListSize) {
        this.grocListSize = grocListSize;
    }

    public Integer getSchoolListSize() {
        return schoolListSize;
    }

    public void setSchoolListSize(Integer schoolListSize) {
        this.schoolListSize = schoolListSize;
    }
}
