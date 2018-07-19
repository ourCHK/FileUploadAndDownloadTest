package beans;

public class WorkOrderBean {
	int id;
    String reporter;
    String report_date;
    int device_id;
    String field_station;
    String error_1;
    String error_2;
    String comment;
    String imagesJson;
    int state;

    String area_manager;
    String repair_man;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getReport_date() {
        return report_date;
    }

    public void setReport_date(String report_date) {
        this.report_date = report_date;
    }

    public int getDevice_id() {
        return device_id;
    }

    public void setDevice_id(int device_id) {
        this.device_id = device_id;
    }

    public String getField_station() {
        return field_station;
    }

    public void setField_station(String field_station) {
        this.field_station = field_station;
    }

    public String getError_1() {
        return error_1;
    }

    public void setError_1(String error_1) {
        this.error_1 = error_1;
    }

    public String getError_2() {
        return error_2;
    }

    public void setError_2(String error_2) {
        this.error_2 = error_2;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getImagesJson() {
        return imagesJson;
    }

    public void setImagesJson(String imagesJson) {
        this.imagesJson = imagesJson;
    }

    public String getRepair_man() {
        return repair_man;
    }

    public void setRepair_man(String repair_man) {
        this.repair_man = repair_man;
    }

    public String getArea_manager() {
        return area_manager;
    }

    public void setArea_manager(String area_manager) {
        this.area_manager = area_manager;
    }
    
}
