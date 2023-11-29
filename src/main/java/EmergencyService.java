import java.sql.Date;

public class EmergencyService {
    private EmergencyServiceContext _fsm;

    private String emergencyID;

    private String location;

    private Date time;

    private String severity;

    public EmergencyService() {
        _fsm = new EmergencyServiceContext(this);
    }

    public EmergencyServiceContext getContext() {
        return _fsm;
    }

    public void activateEmergency() {
        throw new RuntimeException("Not Implemented!");
    }

    public void deactivateEmergency() {
        throw new RuntimeException("Not Implemented!");
    }

    public void updateEmergencyDetails(String newDetails) {
        throw new RuntimeException("Not Implemented!");
    }

}