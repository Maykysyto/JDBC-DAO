import java.math.BigDecimal;

public class Incident {
    private String FlowID;
    private String SourceIP;
    private int SourcePort;
    private int DestinationPort;
    private int Protocol;
    private String DestinationID;
    private String Label;


    public Incident(String FlowID, String SourceIP, int SourcePort,String DestinationID, int DestinationPort, int Protocol, String Label) {

        this.FlowID = FlowID;
        this.SourceIP = SourceIP;
        this.SourcePort = SourcePort;
        this.DestinationID = DestinationID;
        this.DestinationPort = DestinationPort;
        this.Protocol = Protocol;
        this.Label = Label;

    }

    public void setDestinationPort(int destinationPort) {
        DestinationPort = destinationPort;
    }
    public void setDestinationID(String destinationID) {DestinationID = destinationID;}
    public void setLabel(String label) {
        Label = label;
    }

    public void setFlowID(String flowID) {
        FlowID = flowID;
    }

    public void setProtocol(int protocol) {Protocol = protocol;}

    public void setSourceIP(String sourceIP) {
        SourceIP = sourceIP;
    }

    public void setSourcePort(int sourcePort) {
        SourcePort = sourcePort;
    }

    public String getFlowID() {
        return FlowID;
    }
    public String getLabel() {
        return Label;
    }

    public int getDestinationPort() {
        return DestinationPort;
    }
    public String getDestinationID() {return DestinationID;}


    public int getProtocol() {return Protocol;}

    public String getSourceIP() {
        return SourceIP;
    }

    public int getSourcePort() {
        return SourcePort;
    }

    public String toString() {
        return "FlowID=" + FlowID + ","+"Source IP=" + SourceIP +"," + "SourcePort=" + SourcePort + ",Destination IP="+DestinationID+",DestinationPort="+DestinationPort+"," + "Protocol=" + Protocol + ",Label="+Label+
                "};";
    }

    public String getdetailedString() {
        return null;
    }
    public Integer getFlowDuration() {
            return null;
    }

    public Integer getTotalFlow() {
        return null;
    }

    public BigDecimal getFlowPacket() {
        return null;
    }

    public BigDecimal getPacketLength() {
        return null;
    }

    public BigDecimal getAvPacket() {
        return null;
    }
}