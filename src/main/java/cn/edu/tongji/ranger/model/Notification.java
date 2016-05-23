package cn.edu.tongji.ranger.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by LiaoShanhe on 2016/5/23.
 */
@Entity
@Table(name = "notification")
public class Notification {
    private long id;
    private long orderformId;
    private String content;
    private Timestamp generateTime;
    private byte isViewed;
    private long receiverId;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "orderform_id")
    public long getOrderformId() {
        return orderformId;
    }

    public void setOrderformId(long orderformId) {
        this.orderformId = orderformId;
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

    @Basic
    @Column(name = "receiver_id")
    public long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(long receiverId) {
        this.receiverId = receiverId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notification that = (Notification) o;

        if (id != that.id) return false;
        if (orderformId != that.orderformId) return false;
        if (isViewed != that.isViewed) return false;
        if (receiverId != that.receiverId) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (generateTime != null ? !generateTime.equals(that.generateTime) : that.generateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (orderformId ^ (orderformId >>> 32));
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (generateTime != null ? generateTime.hashCode() : 0);
        result = 31 * result + (int) isViewed;
        result = 31 * result + (int) (receiverId ^ (receiverId >>> 32));
        return result;
    }
}
