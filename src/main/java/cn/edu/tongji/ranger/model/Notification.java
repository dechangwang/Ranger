package cn.edu.tongji.ranger.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by LiaoShanhe on 2016/4/27.
 */
@Entity
@Table(name = "notification")
public class Notification {
    private long id;
    private String content;
    private Timestamp generateTime;
    private byte isViewed;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "generate_time")
    public Timestamp getGenerateTime() {
        return generateTime;
    }

    public void setGenerateTime(Timestamp generateTime) {
        this.generateTime = generateTime;
    }

    @Basic
    @Column(name = "is_viewed")
    public byte getIsViewed() {
        return isViewed;
    }

    public void setIsViewed(byte isViewed) {
        this.isViewed = isViewed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notification that = (Notification) o;

        if (id != that.id) return false;
        if (isViewed != that.isViewed) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (generateTime != null ? !generateTime.equals(that.generateTime) : that.generateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (generateTime != null ? generateTime.hashCode() : 0);
        result = 31 * result + (int) isViewed;
        return result;
    }
}
