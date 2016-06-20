package cn.edu.tongji.ranger.utils;

/**
 * Created by Dai on 6/20/16.
 */
public class IdAndStrWrapper {
    private long id;
    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "IdAndStrWrapper{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
