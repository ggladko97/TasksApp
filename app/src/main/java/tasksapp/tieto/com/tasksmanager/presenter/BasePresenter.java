package tasksapp.tieto.com.tasksmanager.presenter;



public interface BasePresenter<V> {
    void bindView(V view);
    void unbindView();
}