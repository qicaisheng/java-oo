package practice11;

import java.util.List;

public interface KlassSubject {
    List<KlassListener> getObservers();

    void register(KlassListener klassListener);
}
