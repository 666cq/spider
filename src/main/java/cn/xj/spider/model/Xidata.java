package cn.xj.spider.model;

public class Xidata {
    private Integer id;

    private Integer equipmentId;

    private String value;

    private String state;

    private String time;

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Xidata{" +
                "id='" + id + '\'' +
                ", equipment_id='" + equipmentId + '\'' +
                ", value='" + value + '\'' +
                ", state='" + state + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
