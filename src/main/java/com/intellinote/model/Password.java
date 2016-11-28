package model;

/**
 * Created by shashankbhardwaj on 26/11/16.
 */
public class Password {
    private int pId;
    private String hashContent;

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getHashContent() {
        return hashContent;
    }

    public void setHashContent(String hashContent) {
        this.hashContent = hashContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Password password = (Password) o;

        return pId == password.pId;

    }

    @Override
    public int hashCode() {
        return pId;
    }
}
