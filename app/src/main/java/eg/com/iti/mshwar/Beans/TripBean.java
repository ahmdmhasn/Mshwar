package eg.com.iti.mshwar.Beans;

public class TripBean {

    private String key;
    private String name;
    private String startPoint;
    private String endPoint;
    private String repetition;
    private String type;
    private String date;
    private String time;
    private Double startPointLongitude;
    private  Double startPointLatitude;
    private Double endPointLongitude;
    private  Double endPointLatitude;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getRepetition() {
        return repetition;
    }

    public void setRepetition(String repetition) {
        this.repetition = repetition;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getStartPointLongitude() {
        return startPointLongitude;
    }

    public void setStartPointLongitude(Double startPointLongitude) {
        this.startPointLongitude = startPointLongitude;
    }

    public Double getStartPointLatitude() {
        return startPointLatitude;
    }

    public void setStartPointLatitude(Double startPointLatitude) {
        this.startPointLatitude = startPointLatitude;
    }

    public Double getEndPointLongitude() {
        return endPointLongitude;
    }

    public void setEndPointLongitude(Double endPointLongitude) {
        this.endPointLongitude = endPointLongitude;
    }

    public Double getEndPointLatitude() {
        return endPointLatitude;
    }

    public void setEndPointLatitude(Double endPointLatitude) {
        this.endPointLatitude = endPointLatitude;
    }
}