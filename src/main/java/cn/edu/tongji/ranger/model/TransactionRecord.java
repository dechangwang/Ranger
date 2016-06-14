package cn.edu.tongji.ranger.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by LiaoShanhe on 2016/6/7.
 */
@Entity
@Table(name = "transaction_record", schema = "ranger", catalog = "")
public class TransactionRecord {
    private long id;
    private long fromId;
    private long toId;
    private Timestamp time;
    private int status;
    private Long orderformId;
    private String brief;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "from_id")
    public long getFromId() {
        return fromId;
    }

    public void setFromId(long fromId) {
        this.fromId = fromId;
    }

    @Basic
    @Column(name = "to_id")
    public long getToId() {
        return toId;
    }

    public void setToId(long toId) {
        this.toId = toId;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "orderform_id")
    public Long getOrderformId() {
        return orderformId;
    }

    public void setOrderformId(Long orderformId) {
        this.orderformId = orderformId;
    }

    @Basic
    @Column(name = "brief")
    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionRecord that = (TransactionRecord) o;

        if (id != that.id) return false;
        if (fromId != that.fromId) return false;
        if (toId != that.toId) return false;
        if (status != that.status) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (orderformId != null ? !orderformId.equals(that.orderformId) : that.orderformId != null) return false;
        if (brief != null ? !brief.equals(that.brief) : that.brief != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (fromId ^ (fromId >>> 32));
        result = 31 * result + (int) (toId ^ (toId >>> 32));
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + (orderformId != null ? orderformId.hashCode() : 0);
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        return result;
    }
}
