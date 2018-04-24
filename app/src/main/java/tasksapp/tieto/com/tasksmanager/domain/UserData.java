package tasksapp.tieto.com.tasksmanager.domain;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * Created by hladlyev on 03.04.2018.
 */
@Entity(nameInDb = "userData")
public class UserData {

    @Id(autoincrement = true)
    private Long id;

    private Long userId;

    @ToOne(joinProperty = "userId")
    private User user;

    @Property(nameInDb = "allCreatedTasks")
    private Integer allCreatedTasks;

    @Property(nameInDb = "allCompletedTasks")
    private Integer allCompletedTasks;

    @Property(nameInDb = "allScheduleTasks")
    private Integer allScheduleTasks;

    @Property(nameInDb = "personalErrSize")
    private Integer personalErrSize;

    @Property(nameInDb = "workProjSize")
    private Integer workProjSize;

    @Property(nameInDb = "grocListSize")
    private Integer grocListSize;

    @Property(nameInDb = "schoolListSize")
    private Integer schoolListSize;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1464190928)
    private transient UserDataDao myDao;

    @Generated(hash = 1800155524)
    public UserData(Long id, Long userId, Integer allCreatedTasks,
            Integer allCompletedTasks, Integer allScheduleTasks,
            Integer personalErrSize, Integer workProjSize, Integer grocListSize,
            Integer schoolListSize) {
        this.id = id;
        this.userId = userId;
        this.allCreatedTasks = allCreatedTasks;
        this.allCompletedTasks = allCompletedTasks;
        this.allScheduleTasks = allScheduleTasks;
        this.personalErrSize = personalErrSize;
        this.workProjSize = workProjSize;
        this.grocListSize = grocListSize;
        this.schoolListSize = schoolListSize;
    }

    @Generated(hash = 1838565001)
    public UserData() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getAllCreatedTasks() {
        return this.allCreatedTasks;
    }

    public void setAllCreatedTasks(Integer allCreatedTasks) {
        this.allCreatedTasks = allCreatedTasks;
    }

    public Integer getAllCompletedTasks() {
        return this.allCompletedTasks;
    }

    public void setAllCompletedTasks(Integer allCompletedTasks) {
        this.allCompletedTasks = allCompletedTasks;
    }

    public Integer getAllScheduleTasks() {
        return this.allScheduleTasks;
    }

    public void setAllScheduleTasks(Integer allScheduleTasks) {
        this.allScheduleTasks = allScheduleTasks;
    }

    public Integer getPersonalErrSize() {
        return this.personalErrSize;
    }

    public void setPersonalErrSize(Integer personalErrSize) {
        this.personalErrSize = personalErrSize;
    }

    public Integer getWorkProjSize() {
        return this.workProjSize;
    }

    public void setWorkProjSize(Integer workProjSize) {
        this.workProjSize = workProjSize;
    }

    public Integer getGrocListSize() {
        return this.grocListSize;
    }

    public void setGrocListSize(Integer grocListSize) {
        this.grocListSize = grocListSize;
    }

    public Integer getSchoolListSize() {
        return this.schoolListSize;
    }

    public void setSchoolListSize(Integer schoolListSize) {
        this.schoolListSize = schoolListSize;
    }

    @Generated(hash = 251390918)
    private transient Long user__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 859885876)
    public User getUser() {
        Long __key = this.userId;
        if (user__resolvedKey == null || !user__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserDao targetDao = daoSession.getUserDao();
            User userNew = targetDao.load(__key);
            synchronized (this) {
                user = userNew;
                user__resolvedKey = __key;
            }
        }
        return user;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1065606912)
    public void setUser(User user) {
        synchronized (this) {
            this.user = user;
            userId = user == null ? null : user.getId();
            user__resolvedKey = userId;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 809121455)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserDataDao() : null;
    }

   
}
