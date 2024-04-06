/*
Jonathan Etiz & Luan Nguyen
Model.java
Version 0
 */

package mvc;

import java.io.Serializable;

public class Model extends Publisher implements Serializable {
    private boolean unsavedChanges = false;
    private String fileName = null;
    public void changed() {
        unsavedChanges = true;
        // fire property change event
        notifySubscribers();
    }

    public void setUnsavedChanges(boolean newState) {
        unsavedChanges = newState;
    }

    public boolean getUnsavedChanges() {
        return unsavedChanges;
    }

    public void setFileName(String newName) {
        fileName = newName;
    }

    public String getFileName() {
        return fileName;
    }
}
