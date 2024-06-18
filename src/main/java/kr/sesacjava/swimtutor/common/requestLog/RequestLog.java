package kr.sesacjava.swimtutor.common.requestLog;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class RequestLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Enumerated(EnumType.STRING)
    private MethodType method;
    private String sqlstring;
    @Temporal(TemporalType.TIMESTAMP)
    private Date regidate;
    private boolean success;

    public RequestLog() {
    }

    public RequestLog(MethodType method, String sqlstring, boolean success) {
        this.id = -1;
        this.method = method;
        this.sqlstring = sqlstring;
        this.regidate = new Date();
        this.success = success;
    }

    public RequestLog(Integer id, MethodType method, String sqlstring, Date regidate, boolean success) {
        this.id = id;
        this.method = method;
        this.sqlstring = sqlstring;
        this.regidate = regidate;
        this.success = success;
    }

    @Override
    public String toString() {
        return "RequestLog [id=" + id + ", method=" + method + ", sqlstring=" + sqlstring + ", regidate=" + regidate
                + ", success=" + success + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MethodType getMethod() {
        return method;
    }

    public void setMethod(MethodType method) {
        this.method = method;
    }

    public String getSqlstring() {
        return sqlstring;
    }

    public void setSqlstring(String sqlstring) {
        this.sqlstring = sqlstring;
    }

    public Date getRegidate() {
        return regidate;
    }

    public void setRegidate(Date regidate) {
        this.regidate = regidate;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}