package practice11;

import java.util.List;

public interface KlassSubject {
    List<KlassListener> getListeners();

    void send(Klass.KlassNotification klassNotification);

    void register(KlassListener klassListener);
}
