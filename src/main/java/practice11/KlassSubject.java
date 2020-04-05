package practice11;

import java.util.List;

public interface KlassSubject {
    List<KlassListener> getListeners();

    void register(KlassListener klassListener);
}
