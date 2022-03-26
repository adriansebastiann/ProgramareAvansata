package laborator3.homework.model.interfaces;

import laborator3.homework.constans.UnitsOfStorage;

/**
 * Created by Alexoaie Adrian Sebastian
 * This interface is used for the classes that need to return a storage capacity
 */
public interface Storage {
    double getStorage();
    void setStorage(double storageValue);
    double convertStorage(UnitsOfStorage unitsOfStorage);
}
