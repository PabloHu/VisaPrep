package view;

/**
 * Created by kiwic on 1/30/2018.
 */

public interface BasePresenter <V extends BaseView> {
    void attachView(V view);
    void detachView();
}
